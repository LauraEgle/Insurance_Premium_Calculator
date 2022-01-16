package com.insurance.insuranceapp.model;

import com.insurance.insuranceapp.model.enums.RiskType;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data
public class PolicySubObject {

    private String name;

    private double sumInsured;

    private RiskType riskType;

    public PolicySubObject(){

    }

    public PolicySubObject(String name, double sumInsured, RiskType riskType) {
        this.name = name;
        this.sumInsured = sumInsured;
        this.riskType = riskType;
    }
}
