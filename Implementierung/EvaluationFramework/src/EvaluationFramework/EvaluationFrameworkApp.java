package EvaluationFramework;

import java.util.Scanner;

import DataGeneratorCBR.GeneratorCBR;
import DataGeneratorRuleModelInheritance.GeneratorRuleModelInheritance;
import Exceptions.NegativeNumberException;

public class EvaluationFrameworkApp {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome!");
	
		System.out.println("1. CBR");
		System.out.println("2. RMI");
		
		System.out.print("Please choose your option: ");
		
		int option;
		Scanner s1 = new Scanner(System.in);
		
		option = s1.nextInt();
		
		if(option == 1) {
			
			try {
				
				// String text = GeneratorRandomString.getRandomString(5);
				String text = GeneratorCBR.generateCBRCode(5, 3);
				System.out.println(text);
				
				}catch(Exception e) {
					System.out.println(e.getMessage());
					
					if(e.getClass().equals(NegativeNumberException.class)) {
						System.out.println("Please consider only positive numbers (including the zero).");
					}
				}
			
		}else if(option == 2){
			
			int option2;
			
			System.out.println("\n\n");
			
			System.out.println("1. AbstractionOnly");
			System.out.println("2. ConformanceOnly");
			System.out.println("3. DynamicBehavioralDetectionOnly");
			System.out.println("4. StaticBehavioralDetectionOnly");
			System.out.println("5. InheritanceOnly");
			System.out.println("6. StructuralDetectionOnly");
			
			System.out.print("Please choose your option: ");
			option2 = s1.nextInt();
			
			switch(option2) {
			
			case 1: 
				
				int rules1;
				int facts1;
				
				System.out.println("\n\n AbstractionOnly: \n");
				System.out.print("Rules: ");
				rules1 = s1.nextInt();
				System.out.print("Facts: ");
				facts1 = s1.nextInt();
				
				String text = GeneratorRuleModelInheritance.generateRMI(rules1, facts1);
				System.out.println(text);
				
			
			
			
			default:
			}//switch
			
		}else {
			System.out.println("Option not valid!");
		}
		
		
		
		
		
		
	}
	
	

}
