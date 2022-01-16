package com.insurance.insuranceapp.controller;

import com.insurance.insuranceapp.calculations.PremiumCalculator;
import com.insurance.insuranceapp.model.Policy;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Data
@AllArgsConstructor
public class PremiumCalculatorController {

    private PremiumCalculator premiumCalculator;

    @PostMapping(value = "/calculate")
    public double calculatePremium(@RequestBody Policy policy){

        return premiumCalculator.calculate(policy);
    }

}
