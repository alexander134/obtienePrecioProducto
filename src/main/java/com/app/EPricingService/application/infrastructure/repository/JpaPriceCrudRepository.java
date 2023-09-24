package com.app.EPricingService.application.infrastructure.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.EPricingService.domain.model.Price;

public interface JpaPriceCrudRepository extends JpaRepository<Price, Long> {

    Optional<Price> findFirstByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
            Integer brandId, Integer productId, LocalDateTime startDate, LocalDateTime endDate
    );
    List<Price> findAllByProductId(Integer productId);
}