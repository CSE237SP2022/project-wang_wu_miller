package ourPackage;

import java.util.Date;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import ourPackage.Records;
public class BookKeeping {
	
	private Scanner scanner;
	private Records records;
	private Users users; 
	private User currentUser; 
	private double totalGroceries;
	private double totalTransportation;
	private double totalDining;
	private double totalOther;
	private double totalAmount;
	

	public BookKeeping()
	{
		this.scanner = new Scanner(System.in);
		this.records = new Records();
		this.users = new Users();
		totalGroceries = 0;
		totalTransportation = 0;
		totalDining = 0;
		totalOther = 0;
		totalAmount = 0;
	}
	
	public double getTotalGroceries() {
		return totalGroceries;
	}
	
	public double getTotalTransportation() {
		return totalTransportation;
	}
	
	public double getTotalDining() {
		return totalDining;
	}
	
	public double getTotalOther() {
		return totalOther;
	}
	
	public double getTotalAmount() {
		return totalAmount;
	}
	
	public Records getRecords()
	{
		return records;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		BookKeeping bookKeeping = new BookKeeping();
		
		System.out.println("begin...");
		bookKeeping.displayMainMenu();

	

	}
	public void chooseMenuOption(int option)
	{
	
		switch (option) {
		case 1:
			records.printRecords();
			break;
		case 2:
			showSummary();
			break;
		case 3:
			addRecord();
			break;
		case 4:
			editRecord();
			break;
		case 5:
			changeUser();
			break;
		case 6:
			quit();
			System.out.println("quiting the program");
			break;
		default:
			System.out.println("Invalid format! Please re-enter the option that you want to choose. ");
			break;
		}
		
	}
	
	
	
	public void displayMainMenu() 
	{
		int option;
	
		while(true)
		{
			if(currentUser == null) {
				System.out.println("Choose a username for your account:");
				String username = scanner.nextLine(); 
				User user = new User(username);
				users.addUser(user);
				user.printUser();
				currentUser = user; 
			}
			
			
			System.out.println("Current user is " + currentUser.getUsername());
			System.out.println("Please select an option: (just enter the number you chose)");
			System.out.println("1. show all your spent");
			System.out.println("2. show your spending summary");
			System.out.println("3. add a new record");
			System.out.println("4. edit existing record");
			System.out.println("5. change user");
			System.out.println("6. quit");
			option = Integer.parseInt(scanner.nextLine());
			chooseMenuOption(option);
		}
	}

	//can create a new user or log into an existing one
	public void changeUser() {
		System.out.println("Do you wish to change users? Press 1 to continue or 2 to quit:");
		int userOption = Integer.parseInt(scanner.nextLine());
		if (userOption == 1) {
			
			System.out.println("Press 1 to enter a new user or press 2 to see current users:");
			int newUser = Integer.parseInt(scanner.nextLine());
			if (newUser == 1) {
				System.out.println("Choose a username for your account:");
				String username = scanner.nextLine(); 
				User user = new User(username);
				users.addUser(user);
				user.printUser();
				currentUser = user;
			}
			else if (newUser == 2) {
				boolean newLogin = false; 
				while(!newLogin) {
					users.printUsers();
					System.out.println("Choose a username from the list to use:");
					String username = scanner.nextLine();
					for (int i=0; i < users.size();i++) {
						User user = users.get(i);
						if (user.getUsername().equals(username)) {
							System.out.println("Logged in as " + username);
							currentUser = user; 
							newLogin = true;
						}
					}
				}
				
			}
			
		}
			
	}
	
	public void addToTotals(Record record)
	{
		double amount = record.getAmount();
		totalAmount += amount;
		
		switch (record.getCategory()) {
			case GROCERIES:
				totalGroceries += amount; 
				break;
			case TRANSPORTATION:
				totalTransportation += amount; 
				break;
			case DINING:
				totalDining += amount;
				break;
			case OTHER:
				totalOther += amount;
				break;
		}
	}
	
	public void subtractFromTotals(Record record)
	{
		double amount = record.getAmount();
		totalAmount -= amount;
		
		switch (record.getCategory()) {
			case GROCERIES:
				totalGroceries -= amount; 
				break;
			case TRANSPORTATION:
				totalTransportation -= amount; 
				break;
			case DINING:
				totalDining -= amount;
				break;
			case OTHER:
				totalOther -= amount;
				break;
		}
	}
	
	public double formatCurrency(double amount)
	{
		//ternary operations prevent arithmetic exception from dividing by zero
		return (amount == 0) ? 0 : Math.round(amount*100.0)/100.0;
	}
	public void showCategoryTotals()
	{
		System.out.println("Total amount: " + formatCurrency(totalAmount));
		System.out.println("Total groceries: " + formatCurrency(totalGroceries));
		System.out.println("Total transportation: " + formatCurrency(totalTransportation));
		System.out.println("Total dining: " + formatCurrency(totalDining));
		System.out.println("Total other: " + formatCurrency(totalOther));
		System.out.println();
	}
	
	
	public double getTotalPercentage(double amount)
	{
		//ternary operations prevent arithmetic exception from dividing by zero
		double percent = (totalAmount == 0) ? 0 : (amount / totalAmount) * 100;
		//round to two decimal places
		return Math.round(percent * 100) / 100;
	}
	
	
	public void showCategoryPercentages()
	{
		System.out.println("Percent spent on groceries: " + getTotalPercentage(totalGroceries));
		System.out.println("Percent spent on transportation: " + getTotalPercentage(totalTransportation));
		System.out.println("Percent spent on dining: " + getTotalPercentage(totalDining));
		System.out.println("Percent spent on other: " + getTotalPercentage(totalOther));

		System.out.println();
	}
	
	
	public void showSummary() {
		System.out.println("Summary:");
		System.out.println("Total purchases: " + records.size());
		
		showCategoryTotals();
		
		showCategoryPercentages();
	}


	
	public Category promptForCategory()
	{
		System.out.println("Choose a category for the new record: (Please enter a number)");
		System.out.println("1. Groceries");
		System.out.println("2. Transportation");
		System.out.println("3. Dining");
		int category = Integer.parseInt(scanner.nextLine());
		
		switch (category) {
		case 1:
			return Category.GROCERIES;
			
		case 2:
			return Category.TRANSPORTATION;
			
		case 3:
			return Category.DINING;
			
		}
		return Category.OTHER;
		
	}
	
	
	public Record addRecord() 
	{
		System.out.println("Please provide a note for the new record:");
		String record_note = scanner.nextLine(); 

		System.out.println("Please provide the amount of the purchase:");
		double amount = Double.parseDouble(scanner.nextLine());

		Category category = promptForCategory();

		Date date = new Date();// gets the instant record was created

		User creator = currentUser;
		Record record = new Record(record_note, date, amount, category, creator);
		records.addRecord(record);

		addToTotals(record);
		
		return record;
	}

	public boolean listMatchingRecords(String record_name)
	{
		for(int i=0; i<records.size(); i++) {
			
			Record record = records.get(i);
			
			if (record.getNote().equals(record_name)) {
				System.out.println("Entry #" + i + ": ");
				record.printRecord();
				return true;
			}
		}
		return false;
	}
	
	public boolean promptEdit()
	{
		while(true) {
			System.out.println("Please provide a name for the record to edit:");
			String record_name = scanner.nextLine();
			
			if(!listMatchingRecords(record_name))
			{
				System.out.println("There were no results for " + record_name + ". Press 1 to see the record entries or 2 to go back to the menu.");
				System.out.println("Press any other number to continue.");
				int exitOption = Integer.parseInt(scanner.nextLine());
				if (exitOption == 1) {
					records.printRecords();
				}
				if (exitOption == 2) {
					return false;
				}
			}
			else
			{
				return true;
			}
			
		}
	}

	public Record getEditedRecord(Record current_record)
	{
		String new_note = current_record.getNote();
		double new_amount = current_record.getAmount();
		Category new_category = current_record.getCategory();
		while(true) {
			displayEditingMenu();
			int editOption = Integer.parseInt(scanner.nextLine()); 
			
			if(editOption == 4) {
				System.out.println("Exiting editing...");
				break;
			}
			
			switch (editOption) {
			case 1: 
				System.out.println("Please provide a note for the edited record:");
				new_note = scanner.nextLine();
				break;
				
			case 2:
				System.out.println("Please provide the new amount of the purchase:");
				new_amount = Double.parseDouble(scanner.nextLine());
				break;
			
			case 3: 
				new_category = promptForCategory();
				break;
			
			}
		}
		Record new_record = new Record(new_note, current_record.getDate(), new_amount, new_category, current_record.getUser());
		return new_record;
	}
	
	public void displayEditingMenu()
	{
		System.out.println("What would you like to edit?");
		System.out.println("1: name");
		System.out.println("2: amount");
		System.out.println("3: category");
		System.out.println("4: quit");
	}
	
	
	public void editRecord() {
		
		//check if record name given matches with a corresponding record that exists, if so will list out the records that match up 
		if(promptEdit() == false) {
			return;
		}
		
		
		System.out.println("Please enter the ID of the entry you want to edit:");
		String recordID = scanner.nextLine();
		
		for (int i = 0; i < records.size(); i++) 
		{
			Record record = records.get(i);
			
			if (record.getID().equals(recordID)) 
			{
				Record edited_record = getEditedRecord(record);
				
				System.out.println("Edited Record:");
				edited_record.printRecord();

				//add in new record
				records.addRecord(edited_record);
				addToTotals(edited_record);
				
				//remove old record
				records.removeRecord(record);
				subtractFromTotals(record);
				
				records.printRecords();
				}
			}
	
		System.out.println("finished editing record...");
		
		return;

	}
	
	//save and quit
	public void quit() {
		System.out.println("Quit");
		scanner.close();
		System.exit(0);
		
	}

}
