package com.insurance.insuranceapp.calculations;

import com.insurance.insuranceapp.model.Policy;
import com.insurance.insuranceapp.model.PolicyObject;
import com.insurance.insuranceapp.model.PolicySubObject;
import com.insurance.insuranceapp.model.enums.RiskType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PremiumCalculatorTest {

    @Test
    void shouldCalculatePremiumWithSubObjectsOfAllRiskTypesTestOne() {

        PremiumCalculator premiumCalculatorInTest = new PremiumCalculator();
        PolicySubObject policySubObject1 = new PolicySubObject("TV", 500d, RiskType.FIRE);
        PolicySubObject policySubObject2 = new PolicySubObject("Fridge", 102.51d, RiskType.THEFT);

        Set<PolicySubObject> policySubObjects = new HashSet<>();
        policySubObjects.add(policySubObject1);
        policySubObjects.add(policySubObject2);

        PolicyObject policyObject = new PolicyObject("House", policySubObjects);
        Set<PolicyObject> policyObjects = new HashSet<>();
        policyObjects.add(policyObject);
        Policy policy = new Policy("123456", policyObjects);

        final double calculationResult = premiumCalculatorInTest.calculate(policy);

        assertEquals(17.13, calculationResult);
    }

    @Test
    void shouldCalculatePremiumWithSubObjectsOfAllRiskTypesTestTwo() {

        PremiumCalculator premiumCalculatorInTest = new PremiumCalculator();
        PolicySubObject policySubObject1 = new PolicySubObject("TV", 100d, RiskType.FIRE);
        PolicySubObject policySubObject2 = new PolicySubObject("Fridge", 8d, RiskType.THEFT);

        Set<PolicySubObject> policySubObjects = new HashSet<>();
        policySubObjects.add(policySubObject1);
        policySubObjects.add(policySubObject2);

        PolicyObject policyObject = new PolicyObject("House", policySubObjects);
        Set<PolicyObject> policyObjects = new HashSet<>();
        policyObjects.add(policyObject);
        Policy policy = new Policy("123456", policyObjects);

        final double calculationResult = premiumCalculatorInTest.calculate(policy);

        assertEquals(2.28, calculationResult);
    }

    @Test
    void shouldReturnZeroWhenThereAreNoPolicyObjectsPresent() {

        PremiumCalculator premiumCalculatorInTest = new PremiumCalculator();
        Policy policy = new Policy();

        final double calculationResult = premiumCalculatorInTest.calculate(policy);

        assertEquals(0, calculationResult);
    }
}