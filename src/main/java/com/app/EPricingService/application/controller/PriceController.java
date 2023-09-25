package com.app.EPricingService.application.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.EPricingService.application.dto.AppliedPriceDTO;
import com.app.EPricingService.application.dto.PriceDTO;
import com.app.EPricingService.domain.service.PriceService;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/aplicación/servicio")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @RequestMapping("/byProductId")
    public ResponseEntity<List<PriceDTO>> getPrice(@RequestParam @NotNull Integer productId) {
        return ResponseEntity.ok(priceService.findAllByProductId(productId));
    }
    
    @RequestMapping("/all")
    public List<PriceDTO> getAllPrices() {
        return priceService.findAllPrice();
    }
    
    @RequestMapping("/apply-price")
    public ResponseEntity<AppliedPriceDTO> getAppliedPrice(
            @RequestParam @NotNull Integer brandId,
            @RequestParam @NotNull Integer productId,
            @RequestParam @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date
            ) {
        return ResponseEntity.ok(priceService.findAppliedPrice(date, productId, brandId));
    }
    
}