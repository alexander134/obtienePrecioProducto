package com.app.EPricingService.application.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.app.EPricingService.application.dto.AppliedPriceDTO;
import com.app.EPricingService.application.dto.PriceDTO;
import com.app.EPricingService.domain.model.AppliedPrice;
import com.app.EPricingService.domain.model.Price;

@Service
public class DtoMapperService {
	private final ModelMapper modelMapper;
    
    public DtoMapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        
    }
    
    public PriceDTO convertToDto(Price price) {
        return modelMapper.map(price, PriceDTO.class);
    }
    
    public AppliedPriceDTO convertToDto(AppliedPrice appliedPrice) {
        return modelMapper.map(appliedPrice, AppliedPriceDTO.class);
    }
    
    public AppliedPrice convertToAppliedPrice(Price price) {
        if (price == null) return null;

        AppliedPrice appliedPrice = new AppliedPrice();
        appliedPrice.setProductId(price.getProductId());
        appliedPrice.setBrandId(price.getBrandId());
        appliedPrice.setFinalPrice(price.getPrice());
        appliedPrice.setStartDate(price.getStartDate());
        appliedPrice.setEndDate(price.getEndDate());
        return appliedPrice;
    }
}
