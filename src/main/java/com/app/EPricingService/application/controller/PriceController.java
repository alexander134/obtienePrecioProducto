package com.app.EPricingService.application.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.EPricingService.application.dto.AppliedPriceDTO;
import com.app.EPricingService.application.dto.PriceDTO;
import com.app.EPricingService.domain.model.AppliedPrice;
import com.app.EPricingService.domain.model.Price;
import com.app.EPricingService.domain.service.PriceService;

@RestController
@RequestMapping("/aplicación/servicio")
public class PriceController {

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/byProductId")
    public ResponseEntity<List<PriceDTO>> getPrice(@RequestParam Integer productId) {

    	List<Price> prices = priceService.findAllByProductId(productId);
        List<PriceDTO> priceDTOs = prices.stream().map(this::mapToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(priceDTOs);
    }

    private PriceDTO mapToDTO(Price price) {
        if (price == null) return null;

        PriceDTO priceDTO = new PriceDTO();
        
        priceDTO.setBrandId(price.getBrandId());
        priceDTO.setProductId(price.getProductId());
        priceDTO.setPrice(price.getPrice());
        priceDTO.setCurr(price.getCurr());

        return priceDTO;
    }
    
    @GetMapping("/all")
    public List<PriceDTO> getAllPrices() {
        List<Price> prices = priceService.findAllPrice();
        return prices.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    
    @GetMapping("/apply-price")
    public ResponseEntity<AppliedPriceDTO> getAppliedPrice(
            @RequestParam Integer brandId,
            @RequestParam Integer productId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date
            ) {
        
        AppliedPrice appliedPrice = priceService.findAppliedPrice(date, productId, brandId);
        
        AppliedPriceDTO appliedPriceDTO = mapToAppliedPriceDTO(appliedPrice);
        
        return ResponseEntity.ok(appliedPriceDTO);
    }
    
    private AppliedPriceDTO mapToAppliedPriceDTO(AppliedPrice appliedPrice) {
        if (appliedPrice == null) return null;
        
        AppliedPriceDTO dto = new AppliedPriceDTO();
        dto.setProductId(appliedPrice.getProductId());
        dto.setBrandId(appliedPrice.getBrandId());
        dto.setFinalPrice(appliedPrice.getFinalPrice());
        dto.setStartDate(appliedPrice.getStartDate());
        dto.setEndDate(appliedPrice.getEndDate());
        
        return dto;
    }
    
}