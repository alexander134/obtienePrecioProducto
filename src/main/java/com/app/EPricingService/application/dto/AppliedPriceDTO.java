package com.app.EPricingService.application.dto;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppliedPriceDTO {
    private Integer productId;
    private Integer brandId;
    private Double finalPrice;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    
}