package com.app.EPricingService.application.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDTO {

	private Integer brandId;
    private Integer productId;
    private Double price;
    private String curr;
	

}
