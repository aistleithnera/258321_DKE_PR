package EvaluationFramework;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
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

	public static void main(String[] args){

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
			int tests;

			String fileName = "out.txt";

			try {
				PrintWriter outputStream = new PrintWriter(fileName);

				outputStream.println("CBR Code Tests ");
				outputStream.println("==================");
				outputStream.print("\n");

				System.out.print("Parameters: ");
				parameters = s1.nextInt();
				System.out.print("Parameter Values: ");
				parameterValues = s1.nextInt();
				System.out.print("Business Cases: ");
				businessCases = s1.nextInt();
				System.out.print("How many tests would you like to run: ");
				tests = s1.nextInt();
				System.out.print("\n");

				outputStream.println("Input ");
				outputStream.println("==================");
				outputStream.println("Parameters: " + parameters);
				outputStream.println("Parameter Values: " + parameterValues);
				outputStream.println("Business Cases: " + businessCases);
				outputStream.println("Test: " + tests);
				outputStream.print("\n");

				for (int i = 0; i < tests; i++) {

					String text = GeneratorCBR.generateCBRCode(parameters, parameterValues, businessCases);

					outputStream.println("Test: " + i);
					outputStream.println("==================");
					outputStream.print("\n");

					outputStream.println("Generated CBR Code");
					outputStream.println("==================");

					outputStream.println(text);

					double exTime = VadalogExecution.calcExTime();
					boolean error = VadalogExecution.calcNoErrors();
					double cpuUsage = VadalogExecution.calcCpuUsage();

					outputStream.println("Evaluation Test " + i);
					outputStream.println("==================");
					outputStream.println("Execution Time: " + exTime + " Seconds");

					String errorsHelp;

					if (error == true) {
						errorsHelp = "no errors detected";
					} else {
						errorsHelp = "errors detected";
					}

					outputStream.println("Errors: " + errorsHelp);

					outputStream.println("CPU Usage: " + cpuUsage + " %");
					outputStream.println("\n");

					CBR cbrObject = new CBR();

					cbrObject.setId(ThreadLocalRandom.current().nextInt(0, 101));

					Calendar now = Calendar.getInstance();
					Date date = now.getTime();

					cbrObject.setDay(now.get(Calendar.DAY_OF_MONTH));
					cbrObject.setMonth(now.get(Calendar.MONTH) + 1);
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

				}

				outputStream.close();

				System.out.println("Done.");
				System.out.println("Please check your txt file.");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		} else if (option == 2) {

			int rules = 0;
			int facts = 0;
			int noInPr = 0;
			int noOutPr = 0;
			String text = "";
			
		
			 System.out.println("\n\n");
			  
			 System.out.println("1. AbstractionOnly");
			 System.out.println("2. DynamicBehavioralDetectionOnly");
			 System.out.println("3. StaticBehavioralDetectionOnly");
			 System.out.println("4. InheritanceOnly");
			 System.out.println("5. StructuralDetectionOnly");
			 System.out.print("Please choose your option: "); 
			 
			 int noTest = s1.nextInt();

			 switch (noTest) {
			 
			 case 1:
				 	System.out.println("==================");
				 	System.out.println("AbstractionOnly");
				 	System.out.println("==================");
				 	
				 	System.out.print("Rules: ");
					rules = s1.nextInt();
					System.out.print("Facts: ");
					facts = s1.nextInt();
					System.out.print("NoInPr: ");
					noInPr = s1.nextInt();
					System.out.print("NoOutPr: ");
					noOutPr = s1.nextInt();
					System.out.print("\n");
					
					RMIModule rmi = new RMIModule();
					text = rmi.generateRMIModuleAbstact(rules, facts, noInPr, noOutPr);
			
					
			 break;
			 
			 case 2:
				 System.out.println("==================");
				 System.out.println("DynamicBehavioralDetectionOnly");
				 System.out.println("==================");
				 
				 
				 
			  
			 break;
			  
			 case 3:
			  
			
			 
			  
			 System.out.println("\n");
			 
			  
			 break;
			 
			 default:
				 System.out.println("Option not valid!");
				 
			break;
			
			 }//end switch
			  
					
			String fileName = "out.txt";
			
			
			
			try {
			
			PrintWriter outputStream = new PrintWriter(fileName);
			
			
			outputStream.println("Input ");
			outputStream.println("==================");
			outputStream.println("Rules: " + rules);
			outputStream.println("Facts: " + facts);
			outputStream.println("NoInPr: " + noInPr);
			outputStream.println("NoOutPr: " + noOutPr);
			outputStream.print("\n");

			outputStream.println("Generated RMI Meta-Code");
			outputStream.println("==================");

			outputStream.println(text);

			double exTime = VadalogExecution.calcExTime();
			boolean error = VadalogExecution.calcNoErrors();
			double cpuUsage = VadalogExecution.calcCpuUsage();

			outputStream.println("Evaluation");
			outputStream.println("==================");
			outputStream.print("Execution Time: " + exTime + " Seconds");
			outputStream.print("\n");
			outputStream.print("Errors: ");
			if (error == true) {
				outputStream.print("no errors detected");
			} else {
				System.out.println("errors detected");
			}

			outputStream.print("\n");
			outputStream.print("CPU Usage: " + cpuUsage + " %");
			outputStream.print("\n");

			RMI rmiObject = new RMI();

			rmiObject.setId(ThreadLocalRandom.current().nextInt(0, 101));

			Calendar now = Calendar.getInstance();
			Date date = now.getTime();

			rmiObject.setDay(now.get(Calendar.DAY_OF_MONTH));
			rmiObject.setMonth(now.get(Calendar.MONTH) + 1);
			rmiObject.setYear(now.get(Calendar.YEAR));
			rmiObject.setHour(date.getHours());
			rmiObject.setMinute(date.getMinutes());
			rmiObject.setSecond(date.getSeconds());
			rmiObject.setTestType(noTest);
			rmiObject.setNoRules(rules);
			rmiObject.setNoFacts(facts);
			rmiObject.setNoInPr(noInPr);
			rmiObject.setNoOutPr(noOutPr);
			rmiObject.setExTime(exTime);
			rmiObject.setErrors(error);
			rmiObject.setCpuUsage(cpuUsage);

			DBConnection.DBSaveEntry.newRMI(rmiObject);
			
			outputStream.close();

			System.out.println("Done.");
			System.out.println("Please check your txt file.");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		}
	}

}
