
/**
 * @author Jino Rigney
 * 
 * This class executes the code
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Do you want enter a new project(p) if not, press any key to update project details");
		String option = input.nextLine();
		
		if(option.equals("p")) {
System.out.println("Enter architect details ");
			

			// Ask questions for architect
			System.out.println("Enter name");
			String architectName = input.nextLine();

			System.out.println("Enter email");
			String architectEmail = input.nextLine();

			System.out.println("Enter Physical Address");
			String architectPhysicalAddress = input.nextLine();

			System.out.println("Enter telephone number");
			String architectTelephoneNumber = input.nextLine();

			// create architect object and set values to questions asked
			Person architect = new Person(architectName, architectEmail, architectPhysicalAddress,
					architectTelephoneNumber);

			// print architect details
			System.out.println(architect);
			System.out.println(" ");

			// ask contractor questions
			System.out.println("Enter Contractor's details");
			System.out.println("Enter name");
			String contractorName = input.nextLine();

			System.out.println("Enter email");
			String contractorEmail = input.nextLine();

			System.out.println("Enter physical address");
			String contractorPhysicalAddress = input.nextLine();

			System.out.println("Enter telephone number");
			String contractorTelephoneNumber = input.nextLine();

			// create contractor object and set values to questions asked
			Person contractor = new Person(contractorName, contractorEmail, contractorPhysicalAddress,
					contractorTelephoneNumber);

			// print contractor details
			System.out.println(contractor);
			System.out.println(" ");

			// ask customer details
			System.out.println("Enter Customers's details");
			System.out.println("Enter name");
			String customerName = input.nextLine();

			System.out.println("Enter email");
			String customerEmail = input.nextLine();

			System.out.println("Enter physical address");
			String customerPhysicalAddress = input.nextLine();

			System.out.println("Enter telephone number");
			String customerTelephoneNumber = input.nextLine();

			// create customer object and set values to questions asked
			Person customer = new Person(customerName, customerEmail, customerPhysicalAddress, customerTelephoneNumber);

			// print customer details
			System.out.println(customer);
			System.out.println(" ");

			// Ask project details questions
			System.out.println("Enter project details");
			
			System.out.println("Enter project address");
			String projectAddress = input.nextLine();

			System.out.println("Enter building type");
			String buildingType = input.nextLine();
			
			System.out.println("Enter project name");
			String projectName = input.nextLine();
			
			//if the user has no project name 
			if(projectName.isBlank()) {
				projectName += buildingType + customerName;
			}

			System.out.println("Enter deadline (yyyy-mm-dd)");
			String deadline = input.nextLine();
			
			//if date is wrong format ask user to enter deadline again
			deadline = checkDateFormat(input, deadline);
			
			System.out.println("Enter total fee in (R_,_) ");
			String totalFee = input.nextLine();

			System.out.println("Enter amount paid to date in (R_,_) ");
			String amountPaid = input.nextLine();

			System.out.println("Enter erf number");
			String erfNumber = input.nextLine();

			System.out.println("Enter project number");
			String projectNumber = input.nextLine();

			String completed = "no";
			// create project object
			Project project = new Project(projectNumber, projectName, buildingType, projectAddress, erfNumber, totalFee,
					amountPaid, deadline, completed);

			// print project details
			System.out.println(project);
			System.out.println(" ");

			// store variables to write to file in a string
			String filedata = architectName + ", " + architectEmail + ", " + architectPhysicalAddress + ", "
					+ architectTelephoneNumber + ", " + contractorName + ", " + contractorEmail + ", "
					+ contractorPhysicalAddress + ", " + contractorTelephoneNumber + ", " + customerName + ", "
					+ customerEmail + ", " + customerPhysicalAddress + ", " + customerTelephoneNumber + ", " + projectNumber
					+ ", " + projectName + ", " + buildingType + ", " + projectAddress + ", " + erfNumber + ", " + totalFee
					+ ", " + amountPaid + ", " + deadline + ", " + completed + "\n";

			
			// write data to file
			FileWriter writer = null;
			try {
				writer = new FileWriter("output.txt", true);
			} catch (IOException writeFail) {
				System.out.println("COuld not write to file");
			}
			try {
				writer.write(filedata);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				writer.close();
			} catch (IOException closeFileError) {
				System.out.println("Could not close file");
			}
		};
			

			// read data from file
			File file = new File("output.txt");
			Scanner	scan = new Scanner(file);
			
			// create lists to store file data
			ArrayList<String> lines = new ArrayList<>();
			ArrayList<String> incomplete = new ArrayList<>();
			ArrayList<String> overdue = new ArrayList<>();
			
			// add file data to list
		
			while (scan.hasNextLine()) {

				lines.add(scan.nextLine());
			}
			
			//view incomplete project list
			incompleteProjectList(lines, incomplete);
			System.out.println(" ");
			//view overdue project list
			overdueProjectList(lines, overdue);
			System.out.println(" ");
		
			// ask user if they want to update details
			System.out.println("Do you want to update any details? (yes/no) : ");
			String question = input.nextLine().toLowerCase();

			// if question != yes or no ask user to enter again

			question = checkYesOrNO(input, question);

			// if yes then ask which project they want to change

			if (question.equals("yes")) {
				System.out.println("Select the project number you want to edit ");
				enterInt(input);
				int selectProject = input.nextInt();

				// get project by it's index
				String projectEdit = null;
				try {
					projectEdit = lines.get(selectProject - 1);
			
				} catch (Exception e) {
					System.out.println("Incorrect project number");

				}
				String[] lineList = projectEdit.split(",");

				// ask which details to update

				System.out.println(" Update Person details(p), update project(u), mark as complete(c)");
				String change = input.nextLine().toLowerCase();

				change = checkChangeInput(input, change);
			
				// change details based on user input and print updated details
				if (change.equals("u")) {
					
					// ask user to enter new project details information
					System.out.println("Enter project details");
					System.out.println("Enter name");
					String newProjectName = input.nextLine();

					System.out.println("Enter project address");
					String newProjectAddress = input.nextLine();

					System.out.println("Enter building type");
					String newBuildingType = input.nextLine();

					System.out.println("Enter deadline(yy-mm-dd)");
					String newDeadline = input.nextLine();
					newDeadline = checkDateFormat(input, newDeadline);

					System.out.println("Enter total fee in (R_,_) ");
					String newTotalFee = input.nextLine();

					System.out.println("Enter amount paid to date in (R_,_) ");
					String newAmountPaid = input.nextLine();

					System.out.println("Enter erf number");
					String newErfNumber = input.nextLine();

					System.out.println("Enter project number");
					String newProjectNumber = input.nextLine();

					//change old index to new input
					lineList[12] = newProjectNumber;
					lineList[13] = newProjectName;
					lineList[14] = newBuildingType;
					lineList[15] = newProjectAddress;
					lineList[16] = newErfNumber;
					lineList[17] = newTotalFee;
					lineList[18] = newAmountPaid;
					lineList[19] = newDeadline;

                     //write to file
					editProject(lines, selectProject, lineList);
					System.out.println("Project Updated");
				}

				if (change.equals("p")) {

					System.out.println("Update the Architect (a), Contractor(cn), Customer(cs)");
					String personUpdate = input.nextLine().toLowerCase();
	                
					// check if user selected an option from the menu
					personUpdate = checkPersonUpdateInput(input, personUpdate);

				if (personUpdate.equals("a")) {
					
					//ask user to enter new Architect details
					System.out.println("Enter new Architect details");
					System.out.println(" ");
			
					System.out.println("Enter name");
					String newArchitectName = input.nextLine();
					
					System.out.println("Enter email");
					String newArchitectEmail = input.nextLine();

					System.out.println("Enter Physical Address");
					String newArchitectPhysicalAddress = input.nextLine();

					System.out.println("Enter telephone number");
					String newArchitectTelephoneNumber = input.nextLine();

					//change old index to user input
					lineList[0] = newArchitectName;
					lineList[1] = newArchitectEmail;
					lineList[2] = newArchitectPhysicalAddress;
					lineList[3] = newArchitectTelephoneNumber;

					// write to file
					editProject(lines, selectProject, lineList);
					System.out.println("Architect details updated");
				}

				if (personUpdate.equals("cn")) {
					//ask user to enter contracor's new information
					System.out.println("Enter Contractor's details");
					System.out.println("Enter name");
					String newContractorName = input.nextLine();

					System.out.println("Enter email");
					String newContractorEmail = input.nextLine();

					System.out.println("Enter physical address");
					String newContractorPhysicalAddress = input.nextLine();

					System.out.println("Enter telephone number");
					String newContractorTelephoneNumber = input.nextLine();

					//change old index to new user input
					lineList[4] = newContractorName;
					lineList[5] = newContractorEmail;
					lineList[6] = newContractorPhysicalAddress;
					lineList[7] = newContractorTelephoneNumber;

					//write to file
					editProject(lines, selectProject, lineList);
					System.out.println("Contractor details updated");
				}
				if (personUpdate.equals("cs")) {
					
					//ask user to enter new customer details
					System.out.println("Enter Customers's details");
					System.out.println("Enter name");
					String newCustomerName = input.nextLine();

					System.out.println("Enter email");
					String newCustomerEmail = input.nextLine();

					System.out.println("Enter physical address");
					String newCustomerPhysicalAddress = input.nextLine();

					System.out.println("Enter telephone number");
					String newCustomerTelephoneNumber = input.nextLine();

					//change old index to new user input
					lineList[8] = newCustomerName;
					lineList[9] = newCustomerEmail;
					lineList[10] = newCustomerPhysicalAddress;
					lineList[11] = newCustomerTelephoneNumber;

					//write to file
		     		editProject(lines, selectProject, lineList);
		     		System.out.println("Customer details updated");
				}

				if (change.equals("c")) {
					//change completed to yes
					lineList[20] = "yes";
					
					//write to file
					editProject(lines, selectProject, lineList);
					

					System.out.println("project completed");

				}

			}
		}
		// if user does not want to update details then tell user details have been
		// stored

		else if (question.equals("no")) {
			System.out.println("Details stored successfuly");

		}
	  }




	/**
	 * This method checks if the date the user entered is in the correct format
	 * @param input
	 * @param deadline
	 * @return
	 */
	private static String checkDateFormat(Scanner input, String deadline) {
		while(!deadline.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")) {
			System.out.println("Enter correct date format(yyyy-mm-dd)");
			deadline = input.nextLine();
		}
		return deadline;
	}
			
		
	

	/**
	 * This method makes sure the user enters an option from the menu
	 * 
	 * @param input user selects option from menu
	 * @param personUpdate
	 * @return
	 */
	private static String checkPersonUpdateInput(Scanner input, String personUpdate) {
		while (!personUpdate.equals("a") && !personUpdate.equals("cn") && !personUpdate.equals("cs")) {
			System.out.println("Enter 'a' or 'cn' or 'cs'");
			personUpdate = input.nextLine().toLowerCase();
			}
		return personUpdate;
	}


	/**
	 * This method makes sure the user enters an option from the menu
	 * 
	 * @param input user selects option from menu
	 * @param change
	 * @return
	 */
	private static String checkChangeInput(Scanner input, String change) {
		// if change does not equal to d, t, or u
		while (!change.equals("p") && !change.equals("u") && !change.equals("c")) {
			System.out.println("Enter 'p' or 'u' or 'c'");
			change = input.nextLine().toLowerCase();

		}
		return change;
	}


	/**
	 * This method stores all incomplete projects in a list and displays the list
	 * 
	 * @param lines
	 * @param incomplete
	 */
	private static void incompleteProjectList(ArrayList<String> lines, ArrayList<String> incomplete) {
		//add incomplete projects to a list
		for(int k = 0; k<lines.size(); k++) {
			if(lines.get(k).endsWith("no")) {
				incomplete.add(lines.get(k));
			}
		}
		System.out.println("Projects that still need to be completed : ");
		System.out.println(incomplete.toString());
	}


	/**
	 * This method stores all overdue projects in a list and displays the list
	 * 
	 * @param lines
	 * @param overdue
	 */
	private static void overdueProjectList(ArrayList<String> lines, ArrayList<String> overdue) {
		for(int d = 0; d<lines.size(); d ++) {
			
		//get each line from the file	
			String linecontent= lines.get(d);
			
			//split lines and store in an array
			String [] lineContentList = linecontent.split(",");
			
			// get the deadline from each line
			String date =lineContentList[19];
			
			//get today's date
			Date today = new Date();
			
			//create date object 
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				//convert today's date to simple date format 
				String todayFormat = dateFormat.format(today);
				
				Date convertDateformat =dateFormat.parse(date);
				if (today.compareTo(convertDateformat)> 0) {
					overdue.add(linecontent);
					
				}
				
			} 
			
			catch (ParseException e) {
				System.out.println(" unable to display overdue projects");
				
			}
			
			
			
		}
		System.out.println("Overdue project : ");
		System.out.println(overdue.toString());
	}


	/**
	 * This method makes sure the user enters either yes or no
	 * 
	 * @param input user input
	 * @param question
	 * @return
	 */
	private static String checkYesOrNO(Scanner input, String question) {
		while (!question.equals("yes") && !question.equals("no")) {
			System.out.println("Enter yes or no");
			question = input.nextLine();

		}
		return question;
	}

	/**
	 * This method updates a project based on user input and writes update to txt file
	 * 
	 * @param lines
	 * @param selectProject
	 * @param lineList
	 * @throws IOException
	 */
	private static void editProject(ArrayList<String> lines, int selectProject, String[] lineList) throws IOException {
		String projectEdit;
		String projectUpdate = Arrays.toString(lineList);
		projectEdit = projectUpdate;

		// create newLine to store changed project details
		String newLine = "";

		// add changed line contents to new line
		for (int i = 0; i < lineList.length; i++) {
			newLine += lineList[i] + ",";

		}
		// substring with removed "," from end of the last word
		// last character is "/n"
		newLine = newLine.substring(0, newLine.length() - 1).trim();

		// replace old line with new line
		lines.set(selectProject - 1, newLine);

		// create string to store all the data from the text file with the new data
		String newFileContent = "";

		// add each line from the list to new file content
		for (int j = 0; j < lines.size(); j++) {
			newFileContent += lines.get(j) + "\n";
		}
		
		// write new content to list
		Writer newWrite = new FileWriter("output.txt");
		newWrite.write(newFileContent);
		newWrite.close();
	}

	// check if user input is an integer
	/**
	 * This method makes sure the user enters an integer 
	 * 
	 * @param input user selects option from the menu
	 */
	public static void enterInt(Scanner input) {
		while (!input.hasNextInt()) {
			System.out.println("Enter an integer");
			input.next();

		}
	}

}
	