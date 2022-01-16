package com.insurance.insuranceapp.model;

import com.insurance.insuranceapp.model.enums.PolicyStatus;
import com.insurance.insuranceapp.model.enums.RiskType;
import lombok.*;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
@Data
@NoArgsConstructor
public class Policy {
    private String policyNumber;
    private PolicyStatus policyStatus;
    private Set<PolicyObject> policyObjects;

    public Policy(String policyNumber, Set<PolicyObject> policyObjects) {
        this.policyNumber = policyNumber;
        this.policyObjects = policyObjects;
    }

    public double calculateTotalPremiumByRiskType(RiskType riskType){
        double premium = 0;
        double coefficient;
        try{
            for (PolicyObject object : this.policyObjects) {
                premium += object.calculateSumInsuredByRiskType(riskType);
            }
        } catch (NullPointerException e){
            premium = 0;
        }

        switch(riskType) {
            case FIRE:
                if(premium > 100){
                    coefficient = 0.024d;
                }else {
                    coefficient = 0.014d;
                }
                break;
            case THEFT:
                if(premium >= 15){
                    coefficient = 0.05d;
                }else {
                    coefficient = 0.11d;
                }
                break;
            default:
                coefficient = 0;
        }

        return Math.round(premium * coefficient*100d)/100d;
    }
}

