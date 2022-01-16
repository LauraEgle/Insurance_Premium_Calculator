package com.insurance.insuranceapp.model;

import com.insurance.insuranceapp.calculations.PremiumCalculator;
import com.insurance.insuranceapp.model.enums.RiskType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PolicyTest {


    @Test
    void shouldCalculateTotalPremiumForPolicyByRiskType() {

        PolicySubObject policySubObject1 = new PolicySubObject("TV", 500d, RiskType.FIRE);
        PolicySubObject policySubObject2 = new PolicySubObject("Fridge", 102.51d, RiskType.THEFT);

        Set<PolicySubObject> policySubObjects = new HashSet<>();
        policySubObjects.add(policySubObject1);
        policySubObjects.add(policySubObject2);

        PolicyObject policyObject = new PolicyObject("House", policySubObjects);
        Set<PolicyObject> policyObjects = new HashSet<>();
        policyObjects.add(policyObject);
        Policy policy = new Policy("123456", policyObjects);

        final double calculationResult = policy.calculateTotalPremiumByRiskType(RiskType.THEFT);

        assertEquals(5.13, calculationResult);
    }

    @Test
    void shouldReturnZeroIfParticularRiskTypeNotPresentInPolicy() {

        PolicySubObject policySubObject2 = new PolicySubObject("Fridge", 102.51d, RiskType.THEFT);

        Set<PolicySubObject> policySubObjects = new HashSet<>();
        policySubObjects.add(policySubObject2);

        PolicyObject policyObject = new PolicyObject("House", policySubObjects);
        Set<PolicyObject> policyObjects = new HashSet<>();
        policyObjects.add(policyObject);
        Policy policy = new Policy("123456", policyObjects);

        final double calculationResult = policy.calculateTotalPremiumByRiskType(RiskType.FIRE);

        assertEquals(0, calculationResult);
    }

    @Test
    void shouldReturnZeroIfNoPolicyObjectsArePresent() {

        Policy policy = new Policy();

        final double calculationResult = policy.calculateTotalPremiumByRiskType(RiskType.FIRE);

        assertEquals(0, calculationResult);
    }
}