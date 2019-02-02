package EvaluationFramework;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import DataGeneratorCBR.GeneratorCBR;
import DataGeneratorRuleModelInheritance.Module;
import DataGeneratorRuleModelInheritance.RMIModule;
import Models.CBR;
import Models.RMI;
import Vadalog.VadalogExecution;

public class EvaluationFrameworkApp {

	public static void main(String[] args) {

		// start of the main programme

		System.out.println("Welcome!");

		System.out.println("1. CBR");
		System.out.println("2. RMI");

		// choosing the option of the test
		System.out.print("Please choose your option: ");

		int option;
		Scanner s1 = new Scanner(System.in);

		option = s1.nextInt();

		if (option == 1) {
			// option 1 generates CBR Code
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

				// Reading of the Input Parameters
				System.out.print("Parameters: ");
				parameters = s1.nextInt();
				System.out.print("Parameter Values: ");
				parameterValues = s1.nextInt();
				System.out.print("Business Cases: ");
				businessCases = s1.nextInt();
				System.out.print("How many tests would you like to run: ");
				tests = s1.nextInt();
				System.out.print("\n");

				// Printing the Input Parameters into the out txt file
				outputStream.println("Input ");
				outputStream.println("==================");
				outputStream.println("Parameters: " + parameters);
				outputStream.println("Parameter Values: " + parameterValues);
				outputStream.println("Business Cases: " + businessCases);
				outputStream.println("Test: " + tests);
				outputStream.print("\n");

				for (int i = 0; i < tests; i++) {

					// Generating CBR Code with the Input Parameters
					String text = GeneratorCBR.generateCBRCode(parameters, parameterValues, businessCases);

					// Printing the Tests and Generated Code into the out txt
					// file
					outputStream.println("Test: " + i);
					outputStream.println("==================");
					outputStream.print("\n");

					outputStream.println("Generated CBR Code");
					outputStream.println("==================");

					outputStream.println(text);

					// calling the Vadalog Execution Dummy Methods
					double exTime = VadalogExecution.calcExTime();
					boolean error = VadalogExecution.calcNoErrors();
					double cpuUsage = VadalogExecution.calcCpuUsage();

					// Printing the Resulst of the Vadalog Execution into the
					// out txt file
					outputStream.println("Evaluation Test " + i);
					outputStream.println("==================");
					outputStream.println("Execution Time: " + exTime + " Seconds");

					String errorsHelp;

					if (error == true) {
						errorsHelp = "no errors detected";
					} else {
						errorsHelp = "errors detected";
					}//else

					outputStream.println("Errors: " + errorsHelp);

					outputStream.println("CPU Usage: " + cpuUsage + " %");
					outputStream.println("\n");

					// create an CBR OBject with all data to make JDBC saving
					// easier
					CBR cbrObject = new CBR();

					Calendar now = Calendar.getInstance();
					Date utilDate = now.getTime();
					java.sql.Date date;
					java.sql.Time time;

					// set sql Date and Time
					date = new java.sql.Date(utilDate.getYear(), utilDate.getMonth(), utilDate.getDate() + 1);
					time = new java.sql.Time(utilDate.getHours() + 1, utilDate.getMinutes(), utilDate.getSeconds());

					cbrObject.setDate(date);
					cbrObject.setTime(time);

					cbrObject.setNoParm(parameters);
					cbrObject.setNoParmVal(parameterValues);
					cbrObject.setNoBusCase(businessCases);

					cbrObject.setExTime(exTime);
					cbrObject.setErrors(error);
					cbrObject.setCpuUsage(cpuUsage);

					// save Entry into DB
					DB.SaveEntry.newCBR(cbrObject);

				}//for

				outputStream.close();

				System.out.println("Done.");
				System.out.println("Please check your txt file.");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		} else if (option == 2) {
			// option 2 generates RMI Code
			int rules = 0;
			int facts = 0;
			int noInPr = 0;
			int noOutPr = 0;
			String text = "";
			int x = 1;
			int noTest = 0;

			System.out.print("\n");

			while (x != 0) {

				// choosing the option of the test
				System.out.println("1. AbstractionOnly");
				System.out.println("2. DynamicBehavioralDetectionOnly");
				System.out.println("3. StaticBehavioralDetectionOnly");
				System.out.println("4. InheritanceOnly");
				System.out.println("5. StructuralDetectionOnly");
				System.out.println("6. END");
				System.out.print("Please choose your option: ");

				noTest = s1.nextInt();

				switch (noTest) {

				// case AbstractionOnly
				case 1:
					System.out.println("==================");
					System.out.println("AbstractionOnly");
					System.out.println("==================");
					System.out.println("");

					// Reading of the Input Parameters
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
					text += rmi.generateRMIModuleAbstact(rules, facts, noInPr, noOutPr);

					break;
				// case DynamicBehavioralDetectionOnly
				case 2:
					System.out.println("==============================");
					System.out.println("DynamicBehavioralDetectionOnly");
					System.out.println("==============================");
					System.out.println("");

					// Reading of the Input Parameters
					System.out.print("Output-Facts: ");
					facts = s1.nextInt();

					RMIModule rmi1 = new RMIModule();
					text += rmi1.generateRMIModuleDynamic();
					Module m1 = rmi1.getModule();
					RMIModule rmi2 = new RMIModule();
					text += rmi2.generateRMIModuleDynamic(m1);
					Module m2 = rmi2.getModule();
					RMIModule rmi3 = new RMIModule();
					text += rmi3.generateRMIModuleDynamicResultset(m1, facts);
					RMIModule rmi4 = new RMIModule();
					text += rmi4.generateRMIModuleDynamicResultsetInheritance(m2, m1);

					break;
				// case StaticBehavioralDetectionOnly
				case 3:
					System.out.println("==============================");
					System.out.println("StaticBehavioralDetectionOnly");
					System.out.println("==============================");
					System.out.println("");

					// Reading of the Input Parameters
					System.out.print("Rules: ");
					rules = s1.nextInt();
					System.out.print("Facts: ");
					facts = s1.nextInt();
					System.out.print("NoInPr: ");
					noInPr = s1.nextInt();
					System.out.print("NoOutPr: ");
					noOutPr = s1.nextInt();
					System.out.print("\n");

					RMIModule rmi5 = new RMIModule();
					text += rmi5.generateRMIModuleStatic(rules, facts, noInPr, noOutPr);
					Module m3 = rmi5.getModule();
					RMIModule rmi6 = new RMIModule();
					text += rmi6.generateRMIModule(rules, facts, noInPr, noOutPr, m3);

					break;

				// case InheritanceOnly
				case 4:
					System.out.println("===================");
					System.out.println("4. InheritanceOnly");
					System.out.println("===================");
					System.out.println("");

					// Reading of the Input Parameters
					System.out.print("Rules: ");
					rules = s1.nextInt();
					System.out.print("Facts: ");
					facts = s1.nextInt();
					System.out.print("NoInPr: ");
					noInPr = s1.nextInt();
					System.out.print("NoOutPr: ");
					noOutPr = s1.nextInt();
					System.out.print("\n");

					RMIModule rmi7 = new RMIModule();
					text += rmi7.generateRMIModule(rules, facts, noInPr, noOutPr);
					Module m4 = rmi7.getModule();

					RMIModule rmi8 = new RMIModule();
					text += rmi8.generateRMIModule(2, 2, 2, 2, m4);
					Module m5 = rmi8.getModule();

					break;

				// case StructuralDetectionOnly
				case 5:
					System.out.println("==========================");
					System.out.println("5. StructuralDetectionOnly");
					System.out.println("==========================");
					System.out.println("");

					// Reading of the Input Parameters
					System.out.print("Rules: ");
					rules = s1.nextInt();
					System.out.print("Facts: ");
					facts = s1.nextInt();
					System.out.print("NoInPr: ");
					noInPr = s1.nextInt();
					System.out.print("NoOutPr: ");
					noOutPr = s1.nextInt();
					System.out.print("\n");

					RMIModule rmi9 = new RMIModule();
					text += rmi9.generateRMIModuleWithNonOmitable(rules, facts, noInPr, noInPr);
					Module m6 = rmi9.getModule();
					RMIModule rmi10 = new RMIModule();
					text += rmi10.generateRMIModule(2, 2, 2, 2, m6);
					break;

				// case END Program
				case 6:
					x = 0;
					break;
				default:
					System.out.println("Option not valid!");
					break;

				}// end switch

			} // end while

			String fileName = "out.txt";

			try {

				PrintWriter outputStream = new PrintWriter(fileName);

				// Printing the Input Parameters into the out txt file
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

				// calling the Vadalog Execution Dummy Methods
				double exTime = VadalogExecution.calcExTime();
				boolean error = VadalogExecution.calcNoErrors();
				double cpuUsage = VadalogExecution.calcCpuUsage();

				// Printing the Resulst of the Vadalog Execution into the out
				// txt file
				outputStream.println("Evaluation");
				outputStream.println("==================");
				outputStream.print("Execution Time: " + exTime + " Seconds");
				outputStream.print("\n");
				outputStream.print("Errors: ");
				if (error == true) {
					outputStream.print("no errors detected");
				} else {
					System.out.println("errors detected");
				}//else

				outputStream.print("\n");
				outputStream.print("CPU Usage: " + cpuUsage + " %");
				outputStream.print("\n");

				// create an RMI OBject with all data to make JDBC saving
				// easier
				RMI rmiObject = new RMI();

				Calendar now = Calendar.getInstance();
				Date utilDate = now.getTime();
				java.sql.Date date;
				java.sql.Time time;

				date = new java.sql.Date(utilDate.getYear(), utilDate.getMonth(), utilDate.getDate() + 1);
				time = new java.sql.Time(utilDate.getHours() + 1, utilDate.getMinutes(), utilDate.getSeconds());

				// set sql Date and Time
				rmiObject.setDate(date);
				rmiObject.setTime(time);

				rmiObject.setTestType(noTest);
				rmiObject.setNoRules(rules);
				rmiObject.setNoFacts(facts);
				rmiObject.setNoInPr(noInPr);
				rmiObject.setNoOutPr(noOutPr);
				rmiObject.setExTime(exTime);
				rmiObject.setErrors(error);
				rmiObject.setCpuUsage(cpuUsage);

				// save Entry into DB
				DB.SaveEntry.newRMI(rmiObject);

				outputStream.close();

				System.out.print("\n");
				System.out.println("Done.");
				System.out.println("Please check your txt file.");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}//exception

		} //if
		s1.close();
	}// main

}//EvaluationFramework
