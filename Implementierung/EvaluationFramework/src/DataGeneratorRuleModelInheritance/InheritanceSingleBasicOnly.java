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
		String s3 = rmi3.generateRMIModuleAbstact(2, 2, 2, 2);

		// structure rmi 4, rmi 5
		RMIModule rmi4 = new RMIModule();
		String s4 = rmi4.generateRMIModuleWithNonOmitable(2, 2, 2, 2);
		Module m3 = rmi4.getModule();
		System.out.println(s4 + "\n\n\n\n");

		RMIModule rmi5 = new RMIModule();
		String s5 = rmi4.generateRMIModule(2, 2, 2, 2, m3);
		System.out.println(s5 + "\n\n\n\n");

		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String s6 = GeneratorRandomString.getRandomString(randomNumber);
		Annotation module = new Annotation(s6);

		// inherits multi
		RMIModule rmi6 = new RMIModule();
		String s7 = rmi6.generateRMIModule(2, 2, 2, 2);
		Module m6 = rmi6.getModule();

		RMIModule rmi7 = new RMIModule();
		String s8 = rmi7.generateRMIModule(2, 2, 2, 2, m6);
		Module m7 = rmi7.getModule();

		RMIModule rmi8 = new RMIModule();
		String s9 = rmi8.generateRMIModule(2, 2, 2, 2, m6);
		Module m8 = rmi8.getModule();

		System.out.println("==================");
		System.out.println(s7 + s8 + s9);

		System.out.println("===============================");

		// static
		RMIModule rmi10 = new RMIModule();
		String s11 = rmi10.generateRMIModuleStatic(2, 2, 2, 2);
		Module m10 = rmi10.getModule();

		RMIModule rmi11 = new RMIModule();
		String s12 = rmi11.generateRMIModule(2, 2, 2, 2, m10);
		Module m9 = rmi11.getModule();

		System.out.println(s11 + s12);

		// System.out.println(s + s2);
		// System.out.println(s3);

	}

}
