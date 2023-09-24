package com.app.EPricingService.domain.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.app.EPricingService.domain.model.Price;

public interface PriceRepository {
    Optional<Price> findApplicablePrice(Integer brandId, Integer productId, LocalDateTime date);
    
    List<Price> findAllByProductId(Integer productId);
    
    List<Price> findAll();
}
