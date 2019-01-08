package EvaluationFramework;

import org.omg.Messaging.SyncScopeHelper;

import DataGeneratorRuleModelInheritance.GeneratorRuleModelInheritance;

public class EvaluationFramework {
	
	public static void RunDynamicBehavioralDetectionOnly(int factNum) {
		
		String dynamical = "";
		
		dynamical += GeneratorRuleModelInheritance.generateProgram() + 
			         GeneratorRuleModelInheritance.generateOnlyAnnotations(1,1) + 
			         GeneratorRuleModelInheritance.generateOnlyFacts(factNum, 1);
		
	System.out.print(dynamical);	
	}
	
	
   public static void RunAbstractionOnly(int annoNum, int factNum, int rulesNum) {
		
		String abstractionOnly = "";
		
		abstractionOnly += GeneratorRuleModelInheritance.generateProgram() + 
			         GeneratorRuleModelInheritance.generateOnlyAnnotations(annoNum,3) + 
			         GeneratorRuleModelInheritance.generateOnlyFacts(factNum, 3) + 
			         GeneratorRuleModelInheritance.generateOnlyRules(3, 3, rulesNum) + 
			         GeneratorRuleModelInheritance.generateAnnotationsWithFacts(annoNum, 4, factNum) + 
			         GeneratorRuleModelInheritance.generateAnnotationsWithRules(annoNum, 4, factNum); 
			        
		
	System.out.print(abstractionOnly);	
	}
	

}
