package com.app.EPricingService.domain.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.EPricingService.domain.model.AppliedPrice;
import com.app.EPricingService.domain.model.Price;
import com.app.EPricingService.domain.repository.PriceRepository;
import com.app.EPricingService.exception.PriceNotFoundException;

@Service
public class PriceService {

    private final PriceRepository priceRepository;

    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Price findApplicablePrice(Integer brandId, Integer productId, LocalDateTime date) {
        return priceRepository.findApplicablePrice(brandId, productId, date)
                              .orElseThrow(() -> new PriceNotFoundException("Precio no encontrado"));
    }
    
    public List<Price> findAllByProductId(Integer productId) {
        return priceRepository.findAllByProductId(productId);
    }
    
    public List<Price> findAllPrice() {
        return priceRepository.findAll();
    }
    
    public AppliedPrice findAppliedPrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        Price applicablePrice = priceRepository.findApplicablePrice(brandId, productId, applicationDate)
                                               .orElseThrow(() -> new PriceNotFoundException("Precio no encontrado"));
        
        AppliedPrice appliedPrice = new AppliedPrice();
        appliedPrice.setProductId(applicablePrice.getProductId());
        appliedPrice.setBrandId(applicablePrice.getBrandId());
        appliedPrice.setFinalPrice(applicablePrice.getPrice());
        appliedPrice.setStartDate(applicablePrice.getStartDate());
        appliedPrice.setEndDate(applicablePrice.getEndDate());
        
        return appliedPrice;
    }
}