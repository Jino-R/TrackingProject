
/**
 * 
 * @author Jino Rigney
 * 
 * This class creates the project details 
 *
 */

public class Project {
// Attributes
private	String projectNumber;
private	String projectName;
private	String buildingType;
private	String projectAddress;
private String deadline;
private	String erfNumber;
private	String totalFee;
private	String amountPaid;
private	String completed;

	// constructor
	public Project(String projectNumber,  String projectName,  String buildingType, String projectAddress,  String erfNumber,String totalFee, String amountPaid,String deadline, String completed) {

		this.projectNumber = projectNumber;
		this.projectName = projectName;
		this.buildingType = buildingType;
		this.projectAddress = projectAddress;
		this.erfNumber = erfNumber;
		this.totalFee = totalFee;
		this.amountPaid = amountPaid;
		this.deadline = deadline;
		this.completed = completed;
	}

	// methods

	public String getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

	public String getProjectAddress() {
		return projectAddress;
	}

	public void setProjectAddress(String physicalAddress) {
		this.projectAddress = physicalAddress;
	}

	public String getDeadline() {
		return deadline;
	}
	
	

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getErfNumber() {
		return erfNumber;
	}

	public void setErfNumber(String erfNumber) {
		this.erfNumber = erfNumber;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(String totalAmountPaid) {
		this.amountPaid = totalAmountPaid;
	}
	
	public String getCompleted() {
		return completed;
	}
	
	public void setCompleted(String completed) {
		this.completed = completed;
	}

	// this is where we get our out out for each value
	public String toString() {
		String output = "Project Number: " + projectNumber;
		output += "\nProject Name: " + projectName;
		output += "\nBuilding Type: " + buildingType;
		output += "\nPhysical Address: " + projectAddress;
		output += "\nERF Number : " + erfNumber;
		output += "\nTotal Fee :" + totalFee;
		output += "\nTotal Amount Paid: " + amountPaid;
		output += "\nDeadline :" + deadline;
		output += "\nCompleted :" + completed;

		return output;
	}
}
