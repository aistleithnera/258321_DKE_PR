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
		
		
		RMIModule rmi3 = new RMIModule();
		String s3 = rmi3.generateRMIModuleAbstact(2, 2, 2, 2);
		
		
		RMIModule rmi4 = new RMIModule();
		String s4 = rmi4.generateRMIModuleWithNonOmitable(2, 2, 2, 2);
		Module m3 = rmi4.getModule();
		System.out.println(s4+"\n\n\n\n");
		
		RMIModule rmi5 = new RMIModule();
		String s5 = rmi4.generateRMIModule(2, 2, 2, 2, m3);
		System.out.println(s5+"\n\n\n\n");
		
		
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String	s6 = GeneratorRandomString.getRandomString(randomNumber);
		Annotation module = new Annotation(s6);
		
		System.out.println(s  + s2);
		System.out.println(s3);
		
	}

}
		

