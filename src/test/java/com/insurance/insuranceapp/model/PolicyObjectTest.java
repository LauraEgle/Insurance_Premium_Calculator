package com.insurance.insuranceapp.model;

import com.insurance.insuranceapp.model.enums.RiskType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PolicyObjectTest {

    @Test
    void shouldCalculateSumInsuredForOnePolicyObjectByRiskType() {
        PolicySubObject policySubObject1 = new PolicySubObject("TV", 500d, RiskType.FIRE);
        PolicySubObject policySubObject2 = new PolicySubObject("Fridge", 102.51d, RiskType.THEFT);

        Set<PolicySubObject> policySubObjects = new HashSet<>();
        policySubObjects.add(policySubObject1);
        policySubObjects.add(policySubObject2);

        PolicyObject policyObject = new PolicyObject("House", policySubObjects);

        final double calculationResult = policyObject.calculateSumInsuredByRiskType(RiskType.THEFT);

        assertEquals(102.51, calculationResult);
    }

    @Test
    void shouldReturnZeroIfNoSubObjectOfRiskTypePresent() {;
        PolicySubObject policySubObject2 = new PolicySubObject("Fridge", 102.51d, RiskType.THEFT);

        Set<PolicySubObject> policySubObjects = new HashSet<>();
        policySubObjects.add(policySubObject2);

        PolicyObject policyObject = new PolicyObject("House", policySubObjects);

        final double calculationResult = policyObject.calculateSumInsuredByRiskType(RiskType.FIRE);

        assertEquals(0, calculationResult);
    }
}