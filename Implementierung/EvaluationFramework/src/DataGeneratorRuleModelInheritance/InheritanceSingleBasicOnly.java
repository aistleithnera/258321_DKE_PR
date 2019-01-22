package DataGeneratorRuleModelInheritance;

import java.util.concurrent.ThreadLocalRandom;

import DataGeneratorRandomString.GeneratorRandomString;

public class InheritanceSingleBasicOnly {
	
	public static void main(String []args){
		RMIModule rmi = new RMIModule();
		
		String s = rmi.generateRMIModule(2, 2, 2, 2);
		
		Module m1 = rmi.getModule();
		Module m2 = m1;
			
		m2.setPrev(m1);
		//m2.setName();
		
	
		String s2 = rmi.generateRMIModule(2, 2, 2, 2, m2);
		
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
		String	s6 = GeneratorRandomString.getRandomString(randomNumber);
		Annotation module = new Annotation(s6);
		
		System.out.println(s  + s2);
		
	}

}
