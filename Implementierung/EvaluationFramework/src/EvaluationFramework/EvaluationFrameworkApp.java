package EvaluationFramework;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import DataGeneratorCBR.GeneratorCBR;
import DataGeneratorRuleModelInheritance.GeneratorRuleModelInheritance;
import DataGeneratorRuleModelInheritance.RMIModule;
import Exceptions.NegativeNumberException;
import Models.CBR;
import Models.RMI;
import Vadalog.VadalogExecution;

public class EvaluationFrameworkApp {

	public static void main(String[] args) {

		System.out.println("Welcome!");

		System.out.println("1. CBR");
		System.out.println("2. RMI");

		System.out.print("Please choose your option: ");

		int option;
		Scanner s1 = new Scanner(System.in);

		option = s1.nextInt();

		if (option == 1) {

			int parameters;
			int parameterValues;
			int businessCases;

			System.out.print("Parameters: ");
			parameters = s1.nextInt();
			System.out.print("Parameter Values: ");
			parameterValues = s1.nextInt();
			System.out.print("Business Cases: ");
			businessCases = s1.nextInt();
			System.out.print("\n");

			String text = GeneratorCBR.generateCBRCode(parameters, parameterValues, businessCases);

			System.out.println("Input ");
			System.out.println("==================");
			System.out.println("Parameters: " + parameters);
			System.out.println("Parameter Values: " + parameterValues);
			System.out.println("Business Cases: " + businessCases);
			System.out.print("\n");

			System.out.println("Generated CBR Code");
			System.out.println("==================");

			System.out.println(text);
			
			double exTime = VadalogExecution.calcExTime();
			boolean error = VadalogExecution.calcNoErrors(); 
			double cpuUsage = VadalogExecution.calcCpuUsage(); 
			
			
			System.out.println("Evaluation");
			System.out.println("==================");
			System.out.print("Execution Time: " + exTime);
			System.out.print("\n");
			System.out.print("Errors: " );
			if (error == true) {
				System.out.print("no errors detected");
			} else {
				System.out.print("errors detected");
			}
			
			System.out.print("\n");
			System.out.print("CPU Usage: " + cpuUsage);
			System.out.print("\n");
			
			CBR cbrObject = new CBR(); 
			
			cbrObject.setId(ThreadLocalRandom.current().nextInt(0, 101));
			
			Calendar now = Calendar.getInstance(); 
			Date date = now.getTime(); 
			
			cbrObject.setDay(now.get(Calendar.DAY_OF_MONTH)); 
			cbrObject.setMonth(now.get(Calendar.MONTH)+1);
			cbrObject.setYear(now.get(Calendar.YEAR));
			cbrObject.setHour(date.getHours());
			cbrObject.setMinute(date.getMinutes());
			cbrObject.setSecond(date.getSeconds());
			
			cbrObject.setNoParm(parameters);
			cbrObject.setNoParmVal(parameterValues);
			cbrObject.setNoBusCase(businessCases);
			
			cbrObject.setExTime(exTime);
			cbrObject.setErrors(error);
			cbrObject.setCpuUsage(cpuUsage);

			DBConnection.DBSaveEntry.newCBR(cbrObject);
			
			System.out.println(now.get(Calendar.DAY_OF_MONTH));
			System.out.println(now.get(Calendar.MONTH)+1);
			System.out.println(now.get(Calendar.YEAR));
			System.out.println(date.getHours());
			System.out.println(date.getMinutes());
			System.out.println(date.getSeconds());
			
		} else if (option == 2) {
			
			int rules;
			int facts;
			int noInPr;
			int noOutPr;

			System.out.print("Rules: ");
			rules = s1.nextInt();
			System.out.print("Facts: ");
			facts = s1.nextInt();
			System.out.print("NoInPr: ");
			noInPr = s1.nextInt();
			System.out.print("NoOutPr: ");
			noOutPr = s1.nextInt();
			System.out.print("\n");
			
			RMIModule m1 = new RMIModule();
			String text = m1.generateRMIModule(rules, facts, noInPr, noOutPr );

			System.out.println("Input ");
			System.out.println("==================");
			System.out.println("Rules: " + rules);
			System.out.println("Facts: " + facts);
			System.out.println("NoInPr: " + noInPr);
			System.out.println("NoOutPr: " + noOutPr);
			System.out.print("\n");

			System.out.println("Generated RMI Meta-Code");
			System.out.println("==================");

			System.out.println(text);
			
			
			double exTime = VadalogExecution.calcExTime();
			boolean error = VadalogExecution.calcNoErrors(); 
			double cpuUsage = VadalogExecution.calcCpuUsage(); 
			
			
			System.out.println("Evaluation");
			System.out.println("==================");
			System.out.print("Execution Time: " + exTime);
			System.out.print("\n");
			System.out.print("Errors: " );
			if (error == true) {
				System.out.print("no errors detected");
			} else {
				System.out.print("errors detected");
			}
			
			System.out.print("\n");
			System.out.print("CPU Usage: " + cpuUsage);
			System.out.print("\n");
			
			RMI rmiObject = new RMI(); 
			
			rmiObject.setId(ThreadLocalRandom.current().nextInt(0, 101));
			
			Calendar now = Calendar.getInstance(); 
			Date date = now.getTime(); 
			
			rmiObject.setDay(now.get(Calendar.DAY_OF_MONTH)); 
			rmiObject.setMonth(now.get(Calendar.MONTH)+1);
			rmiObject.setYear(now.get(Calendar.YEAR));
			rmiObject.setHour(date.getHours());
			rmiObject.setMinute(date.getMinutes());
			rmiObject.setSecond(date.getSeconds());
			rmiObject.setTestType(1);
			rmiObject.setNoRules(rules);
			rmiObject.setNoFacts(facts);
			rmiObject.setNoInPr(noInPr);
			rmiObject.setNoOutPr(noOutPr);
			
			rmiObject.setExTime(exTime);
			rmiObject.setErrors(error);
			rmiObject.setCpuUsage(cpuUsage);

			DBConnection.DBSaveEntry.newRMI(rmiObject);
			
			System.out.println(now.get(Calendar.DAY_OF_MONTH));
			System.out.println(now.get(Calendar.MONTH)+1);
			System.out.println(now.get(Calendar.YEAR));
			System.out.println(date.getHours());
			System.out.println(date.getMinutes());
			System.out.println(date.getSeconds());
			
			

			/*System.out.println("\n\n");

			System.out.println("1. AbstractionOnly");
			System.out.println("2. ConformanceOnly");
			System.out.println("3. DynamicBehavioralDetectionOnly");
			System.out.println("4. StaticBehavioralDetectionOnly");
			System.out.println("5. InheritanceOnly");
			System.out.println("6. StructuralDetectionOnly");

			System.out.print("Please choose your option: ");
			option2 = s1.nextInt();

			switch (option2) {

			case 1:

				int anno1;
				int facts1;
				int rules1;

				System.out.println("\nAbstractionOnly: \n");
				System.out.print("Annotations: ");
				anno1 = s1.nextInt();
				System.out.print("Facts: ");
				facts1 = s1.nextInt();
				System.out.print("Rules: ");
				rules1 = s1.nextInt();

				EvaluationFramework.RunAbstractionOnly(anno1, facts1, rules1);

				break;

			case 2:

				break;

			case 3:

				System.out.println("\nDynamicBehavioralDetectionOnly: \n");
				System.out.print("Facts: ");
				facts1 = s1.nextInt();

				System.out.println("\n");
				EvaluationFramework.RunDynamicBehavioralDetectionOnly(facts1);

				break;

			default:
			}// switch

		} else {
			System.out.println("Option not valid!");
		*/

	}
	}

}
