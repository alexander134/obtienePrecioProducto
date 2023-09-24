package com.app.EPricingService.application.infrastructure.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.EPricingService.domain.model.Price;
import com.app.EPricingService.domain.repository.PriceRepository;

@Repository
public class JpaPriceRepository implements PriceRepository {

    private final JpaPriceCrudRepository jpaPriceCrudRepository;

    @Autowired
    public JpaPriceRepository(JpaPriceCrudRepository jpaPriceCrudRepository) {
        this.jpaPriceCrudRepository = jpaPriceCrudRepository;
    }

    @Override
    public Optional<Price> findApplicablePrice(Integer brandId, Integer productId, LocalDateTime date) {
    	return jpaPriceCrudRepository.findFirstByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
    	        brandId, productId, date, date);
    }
    
    @Override
    public List<Price> findAll() {
        return (List<Price>) jpaPriceCrudRepository.findAll();
    }
    
    @Override
    public List<Price> findAllByProductId(Integer productId) {
        return jpaPriceCrudRepository.findAllByProductId(productId);
    }
}