package com.app.EPricingService.domain.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.app.EPricingService.application.dto.AppliedPriceDTO;
import com.app.EPricingService.application.dto.PriceDTO;
import com.app.EPricingService.application.exceptionhandler.PriceNotFoundException;
import com.app.EPricingService.application.mapper.DtoMapperService;
import com.app.EPricingService.domain.model.Price;
import com.app.EPricingService.domain.repository.PriceRepository;

@Service
public class PriceService {

    private final PriceRepository priceRepository;
    private final DtoMapperService dtoMapperService;

    public PriceService(PriceRepository priceRepository, DtoMapperService dtoMapperService) {
        this.dtoMapperService = dtoMapperService;
        this.priceRepository = priceRepository;
    }

    public Price findApplicablePrice(Integer brandId, Integer productId, LocalDateTime date) {
        return priceRepository.findApplicablePrice(brandId, productId, date)
                              .orElseThrow(() -> new PriceNotFoundException("Precio no encontrado"));
    }
    
    public List<PriceDTO> findAllByProductId(Integer productId) {
        return priceRepository.findAllByProductId(productId).stream().map(dtoMapperService::convertToDto).collect(Collectors.toList());
    }
    
    public List<PriceDTO> findAllPrice() {
        return priceRepository.findAll().stream().map(dtoMapperService::convertToDto).collect(Collectors.toList());
    }
    
    public AppliedPriceDTO findAppliedPrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        Price applicablePrice = priceRepository.findApplicablePrice(brandId, productId, applicationDate)
                                               .orElseThrow(() -> new PriceNotFoundException("Precio no encontrado"));
        AppliedPriceDTO appliedPriceDTO = dtoMapperService.convertToDto(dtoMapperService.convertToAppliedPrice(applicablePrice));
        
        return appliedPriceDTO;
    }
}