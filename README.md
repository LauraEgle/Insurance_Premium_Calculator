# Insurance_Premium_Calculator

Main functionality of this program is to calculate insurance premium to be paid by client based on Policy objects, sub-objects and their type and sum insured. 

PremiumCalculator class / #calculate(Policy policy)
PremiumCalculator class and method #calculate makes use of method #calculateTotalPremiumByRiskType(RiskType riskType) defined in Policy class. Method calculate(Policy policy) takes 
in Policy object, calculates total premium for particular risk type and sums up these results.  

Policy class / #calculateTotalPremiumByRiskType(RiskType riskType)
This method calculates total sum insured of all Policy objects for specific risk type and applies coefficient based on this amount.
In case there are no Policy objects method returns 0.

PolicyObject class / #calculateSumInsuredByRiskType(RiskType riskType)
This method calculates total sum insured for all Policy Sub-Objects. 
In scenario where there are no sub-objects insured with specific risk type, method #calculateSumInsuredByRiskType(RiskType riskType) defined in PolicyObject class returns 0.

PremiumCalculatorController class / #calculatePremium(@RequestBody Policy policy)
Rest Controller provides endpoint /calculatePremium for posting Policy object via API and accessing PremiumCalculator calculate(Policy policy) method.

json for testing:
{
   "policyNumber":"123456",
   "policyStatus":"APPROVED",
   "policyObjects":[
      {
         "name":"House",
         "subObjects":[
            {
               "name":"TV",
               "sumInsured":"500",
               "riskType":"FIRE"
            },
            {
               "name":"Fridge",
               "sumInsured":"102.51",
               "riskType":"THEFT"
            }
         ]
      }
   ]
}
