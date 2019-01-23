package DataGeneratorRuleModelInheritance;

import java.util.concurrent.ThreadLocalRandom;

import DataGeneratorRandomString.GeneratorRandomString;

public class InheritanceSingleBasicOnly {
	
	public static void main(String []args){
		RMIModule rmi = new RMIModule();
		
		
		String s = rmi.generateRMIModule(2, 2, 2, 2);
		
		
		
			
		Module m1 = rmi.getModule();
		
		RMIModule rmi2 = new RMIModule();
		String s2 = rmi2.generateRMIModule(2, 2,2, 2, m1);
		Module m2 = rmi2.getModule();
		
		m2.setPrev(m1);
		
		RMIModule rmi3 = new RMIModule();
		String s3 = rmi3.generateRMIModuleAbstact(2, 2, 2, 2);
		

		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String	s6 = GeneratorRandomString.getRandomString(randomNumber);
		Annotation module = new Annotation(s6);
		
		System.out.println(s  + s2);
		System.out.println(s3);
		
	}

}
		

