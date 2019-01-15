package Test;

import DataGeneratorCBR.GeneratorCBR;
import DataGeneratorRuleModelInheritance.GeneratorRuleModelInheritance;
import Exceptions.NegativeNumberException;

public class TestGeneratorRuleModelInheritance {
	
	
	public static void main(String[] args) {

		
		//test - generate facts (1 fact, 1 term)
		
		System.out.println("generate facts (1 fact, 1 term)\n");
		String text = GeneratorRuleModelInheritance.generateProgram() + 
				      GeneratorRuleModelInheritance.generateOnlyFacts(1,1);
		System.out.println(text);
		
		
		//test - generate facts (1 fact, 5 term)
		
		System.out.println("generate facts (1 fact, 5 term)\n");
		String text2 = GeneratorRuleModelInheritance.generateProgram() + 
					   GeneratorRuleModelInheritance.generateOnlyFacts(1,5);
		System.out.println(text2);
		
		//test - generate facts (2 fact, 1 term)
		
		System.out.println("generate facts (2 fact, 1 term)\n");
		String text3 = GeneratorRuleModelInheritance.generateProgram() + 
					   GeneratorRuleModelInheritance.generateOnlyFacts(2,1);
		System.out.println(text3);
		
		
	    //test - generate facts (2 fact, 6 term)
		
		System.out.println("generate facts (2 fact, 6 term)\n");
		String text4 = GeneratorRuleModelInheritance.generateProgram() + 
					   GeneratorRuleModelInheritance.generateOnlyFacts(2,6);
		System.out.println(text4);
		
		
		//test - generate rules (1 fact, 1 term, 1 rule)
		
		System.out.println("generate rules (1 fact, 1 term, 1 rule)\n");
		String text5 = GeneratorRuleModelInheritance.generateProgram() + 
					   GeneratorRuleModelInheritance.generateOnlyRules(1,1,1);
		System.out.println(text5);
		
		

		//test - generate rules (1 fact, 3 term, 1 rule)
		
		System.out.println("generate rules (1 fact, 3 term, 1 rule)\n");
		String text6 = GeneratorRuleModelInheritance.generateProgram() + 
					   GeneratorRuleModelInheritance.generateOnlyRules(1,3,1);
		System.out.println(text6);
		
		
		//test - generate rules (3 fact, 3 term, 1 rule)
		
		System.out.println("generate rules (3 fact, 3 term, 1 rule)\n");
		String text7 = GeneratorRuleModelInheritance.generateProgram() + 
					   GeneratorRuleModelInheritance.generateOnlyRules(3,3,1);
		System.out.println(text7);
		

		//test - generate rules (3 fact, 3 term, 3 rule)
		
		System.out.println("generate rules (3 fact, 3 term, 3 rule)\n");
		String text8 = GeneratorRuleModelInheritance.generateProgram() + 
					   GeneratorRuleModelInheritance.generateOnlyRules(3,3,3);
		System.out.println(text8);
		
		
		//test - generate anno (1 anno, 1 term)
		
		System.out.println("generate Annotations (1 anno, 1 term)\n");
		String text9 = GeneratorRuleModelInheritance.generateProgram() + 
				      GeneratorRuleModelInheritance.generateOnlyAnnotations(1,1);
		System.out.println(text9);
		

		//test - generate anno (1 anno, 3 term)
		
		System.out.println("generate Annotations (1 anno, 3 term)\n");
		String text10 = GeneratorRuleModelInheritance.generateProgram() + 
				      GeneratorRuleModelInheritance.generateOnlyAnnotations(1,3);
		System.out.println(text10);
		

		//test - generate anno (3 anno, 3 term)
		
		System.out.println("generate Annotations (3 anno, 3 term)\n");
		String text11 = GeneratorRuleModelInheritance.generateProgram() + 
				      GeneratorRuleModelInheritance.generateOnlyAnnotations(3,3);
		System.out.println(text11);
		

		//test - generate annoWithFacts (1 anno, 1 annoTerm, 1 factTerm)
		
		System.out.println("generate Annotations with facts (1 anno, 1 annoTerm, 1 factTerm)\n");
		String text12 = GeneratorRuleModelInheritance.generateProgram() + 
				        GeneratorRuleModelInheritance.generateAnnotationsWithFacts(1, 1, 1);
		System.out.println(text12);
		
		
		//test - generate annoWithFacts (1 anno, 3 annoTerm, 3 factTerm)
		
		System.out.println("generate Annotations with facts (1 anno, 3 annoTerm, 3 factTerm)\n");
		String text13 = GeneratorRuleModelInheritance.generateProgram() + 
					    GeneratorRuleModelInheritance.generateAnnotationsWithFacts(1, 3, 3);
		System.out.println(text13);
		

		//test - generate annoWithFacts (3 anno, 3 annoTerm, 3 factTerm)
		
		System.out.println("generate Annotations with facts (3 anno, 3 annoTerm, 3 factTerm)\n");
		String text14 = GeneratorRuleModelInheritance.generateProgram() + 
					    GeneratorRuleModelInheritance.generateAnnotationsWithFacts(3, 3, 3);
		System.out.println(text14);


		//test - generate annoWithRules (1 anno, 1 Term, 1 ruleFact)
		
		System.out.println("generate Annotations with facts (1 anno, 1 annoTerm, 1 factTerm)\n");
		String text15 = GeneratorRuleModelInheritance.generateProgram() + 
					    GeneratorRuleModelInheritance.generateAnnotationsWithRules(1, 1, 1);
		System.out.println(text15);
		
		

		//test - generate annoWithRules (1 anno, 3 Term, 3 ruleFact)
		
		System.out.println("generate Annotations with facts (1 anno, 3 annoTerm, 3 factTerm)\n");
		String text16 = GeneratorRuleModelInheritance.generateProgram() + 
					    GeneratorRuleModelInheritance.generateAnnotationsWithRules(1, 3, 3);
		System.out.println(text16);
		
		//test - generate annoWithRules (3 anno, 3 Term, 3 ruleFact)
		
		System.out.println("generate Annotations with facts (3 anno, 3 annoTerm, 3 factTerm)\n");
		String text17 = GeneratorRuleModelInheritance.generateProgram() + 
					    GeneratorRuleModelInheritance.generateAnnotationsWithRules(3, 3, 3);
	    System.out.println(text17);
	    

		//test - generate positiveAndNegativeRules (1 rule, 1 Term, 1 positive, 1 negative)
		
		System.out.println("generate Annotations with facts (1 rule, 1 Term, 1 positive, 1 negative)\n");
		String text18 = GeneratorRuleModelInheritance.generateProgram() + 
					    GeneratorRuleModelInheritance.generatePositiveAndNegativeRules(1, 1, 1, 1);
	    System.out.println(text18);
	    

		//test - generate positiveAndNegativeRules (1 rule, 1 Term, 3 positive, 3 negative)
		
		System.out.println("generate Annotations with facts (1 rule, 1 Term, 3 positive, 3 negative)\n");
		String text19 = GeneratorRuleModelInheritance.generateProgram() + 
					    GeneratorRuleModelInheritance.generatePositiveAndNegativeRules(1, 1, 3, 3);
	    System.out.println(text19);
	    

		//test - generate rulesWithNonRelationalAtoms (1 rule, 1 Terms, 1 relationalAtom, 1 nonRelationalAtom)
		
		System.out.println("generate Annotations with facts (1 rule, 1 Terms, 1 relationalAtom, 1 nonRelationalAtom)\n");
		String text20 = GeneratorRuleModelInheritance.generateProgram() + 
					    GeneratorRuleModelInheritance.generateRulesWithNonRelationalAtoms(1, 1, 1, 1);
	    System.out.println(text20);
	    
		
	}
	

}
