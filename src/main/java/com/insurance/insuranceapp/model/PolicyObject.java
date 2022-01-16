package com.insurance.insuranceapp.model;

import com.insurance.insuranceapp.model.enums.RiskType;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Data
public class PolicyObject {

    private String name;

    private Set<PolicySubObject> subObjects;

    public PolicyObject(){    }

    public PolicyObject(String name, Set<PolicySubObject> subObjects) {
        this.name = name;
        this.subObjects = subObjects;
    }

    public double calculateSumInsuredByRiskType(RiskType riskType){
        double sumInsured = 0;
        try{
            for (PolicySubObject s: subObjects) {
                if(s.getRiskType() == riskType){
                    sumInsured += s.getSumInsured();
                }
            }
        }catch(NullPointerException e){
             sumInsured = 0;
        }
        return sumInsured;
    }
}
