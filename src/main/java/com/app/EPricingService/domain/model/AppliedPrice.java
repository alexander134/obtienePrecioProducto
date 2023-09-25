package com.app.EPricingService.domain.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppliedPrice {
    private Integer productId;
    private Integer brandId;
    private Double finalPrice;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}