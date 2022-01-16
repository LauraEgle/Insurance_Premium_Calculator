package com.insurance.insuranceapp.calculations;

import com.insurance.insuranceapp.model.Policy;
import com.insurance.insuranceapp.model.enums.RiskType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PremiumCalculator {

    private Policy policy;

    public PremiumCalculator(Policy policy){
        this.policy = policy;
    }

    public double calculate(Policy policy){

        double premiumFire = policy.calculateTotalPremiumByRiskType(RiskType.FIRE);
        double premiumTheft = policy.calculateTotalPremiumByRiskType(RiskType.THEFT);
        double premiumTotal = premiumFire + premiumTheft;
        return Math.round(premiumTotal*100d)/100d;
    }
}

