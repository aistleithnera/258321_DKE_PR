package EvaluationFramework;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import DataGeneratorCBR.GeneratorCBR;
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

					// Printing the Tests and Generated Code into the out txt file
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

					// Printing the Resulst of the Vadalog Execution into the out txt file
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

					// create an CBR OBject with all data to make JDBC saving easier
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

			}// end switch

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

				Calendar now = Calendar.getInstance();
				Date utilDate = now.getTime();
				java.sql.Date date;
				java.sql.Time time;

				date = new java.sql.Date(utilDate.getYear(), utilDate.getMonth(), utilDate.getDate() + 1);
				time = new java.sql.Time(utilDate.getHours() + 1, utilDate.getMinutes(), utilDate.getSeconds());

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

				DB.SaveEntry.newRMI(rmiObject);

				outputStream.close();

				System.out.print("\n");
				System.out.println("Done.");
				System.out.println("Please check your txt file.");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}
	}

}
