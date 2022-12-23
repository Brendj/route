package com.prog.route.converter;

import com.prog.route.dto.FraudDto;
import com.prog.route.model.Fraud;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class FraudConverter {
    public FraudDto mapToFraudDto(Fraud fraud) {
        FraudDto fraudDto = new FraudDto();
        fraudDto.setName(fraud.getName());
        fraudDto.setTextFraud(fraud.getTextFraud());
        fraudDto.setRoute(fraud.getRoute());
        fraudDto.setRouteVersion(fraud.getRouteVersion());
        return fraudDto;
    }

}
