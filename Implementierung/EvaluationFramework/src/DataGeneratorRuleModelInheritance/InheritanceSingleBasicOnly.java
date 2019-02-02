package DataGeneratorRuleModelInheritance;

import java.util.concurrent.ThreadLocalRandom;

import DataGeneratorRandomString.GeneratorRandomString;

public class InheritanceSingleBasicOnly {

	public static void main(String[] args) {

		// Inherits only rmi, rmi2
		RMIModule rmi = new RMIModule();
		String s = rmi.generateRMIModule(2, 2, 2, 2);
		Module m1 = rmi.getModule();

		RMIModule rmi2 = new RMIModule();
		String s2 = rmi2.generateRMIModule(2, 2, 2, 2, m1);
		Module m2 = rmi2.getModule();

		// abstract rmi3
		RMIModule rmi3 = new RMIModule();
		String s3 = rmi3.generateRMIModuleAbstact(6, 2, 2, 2);
		//System.out.println(s3);

		// structure rmi 4, rmi 5
		RMIModule rmi4 = new RMIModule();
		String s4 = rmi4.generateRMIModuleWithNonOmitable(2, 2, 2, 2);
		Module m3 = rmi4.getModule();
	

		RMIModule rmi5 = new RMIModule();
		String s5 = rmi4.generateRMIModule(2, 2, 2, 2, m3);
	

		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String s6 = GeneratorRandomString.getRandomString(randomNumber);
		Annotation module = new Annotation(s6);

		


		System.out.println("==================");

		System.out.println("===============================");

		// static
		RMIModule rmi10 = new RMIModule();
		String s11 = rmi10.generateRMIModuleStatic(2, 2, 2, 2);
		Module m10 = rmi10.getModule();

		RMIModule rmi11 = new RMIModule();
		String s12 = rmi11.generateRMIModule(2, 2, 2, 2, m10);
		Module m9 = rmi11.getModule();

		
		// System.out.println(s + s2);
		// System.out.println(s3);
		
		//dynamic  
		RMIModule rmi12 = new RMIModule();
		String s14 = rmi12.generateRMIModuleDynamic();
		Module m14 = rmi12.getModule();

		RMIModule rmi13 = new RMIModule();
		String s111 = rmi13.generateRMIModuleDynamic(m14);
		Module m15 = rmi13.getModule();
		
		RMIModule rmi14 = new RMIModule();
		String s112 = rmi14.generateRMIModuleDynamicResultset(m14, 3);
		
		
		
		RMIModule rmi15 = new RMIModule();
		String s113 = rmi15.generateRMIModuleDynamicResultsetInheritance(m15, m14);
		
		System.out.print(s14 + s111 + s112 + s113);
		
		
	}

}
