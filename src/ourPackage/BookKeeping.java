package ourPackage;

import java.util.Date;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import ourPackage.Records;
public class BookKeeping {
	
	private Scanner scanner;
	private Records records;
	private double totalGroceries;
	private double totalTransportation;
	private double totalDining;
	private double totalOther;
	private double totalAmount;
	

	public BookKeeping()
	{
		this.scanner = new Scanner(System.in);
		this.records = new Records();
		totalGroceries = 0;
		totalTransportation = 0;
		totalDining = 0;
		totalOther = 0;
		totalAmount = 0;
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
			System.out.println("Please select an option: (just enter the number you chose)");
			System.out.println("1. show all your spent");
			System.out.println("2. show your spending summary");
			System.out.println("3. add a new record");
			System.out.println("4. edit existing record");
			System.out.println("5. quit");
			option = Integer.parseInt(scanner.nextLine());
			chooseMenuOption(option);
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
	
	public void showCategoryTotals()
	{
		//ternary operations prevent arithmetic exception from dividing by zero
		double formattedTotalAmount = (totalAmount == 0) ? 0 : (double) Math.round((totalAmount*100)/100);
		double formattedTotalGroceries = (totalGroceries == 0) ? 0 : (double) Math.round((totalGroceries*100)/100);
		double formattedTotalTransportation = (totalTransportation == 0) ? 0 : (double) Math.round((totalTransportation*100)/100);
		double formattedTotalDining = (totalDining == 0) ? 0 : (double) Math.round((totalDining*100)/100);
		double formattedTotalOther = (totalOther == 0) ? 0 : (double) Math.round((totalOther*100)/100);

		
		System.out.println("Total amount: " + formattedTotalAmount);
		System.out.println("Total groceries: " + formattedTotalGroceries);
		System.out.println("Total transportation: " + formattedTotalTransportation);
		System.out.println("Total dining: " + formattedTotalDining);
		System.out.println("Total other: " + formattedTotalOther);
		System.out.println();
	}
	
	
	public void showCategoryPercentages()
	{
		//ternary operations prevent arithmetic exception from dividing by zero
		double percentGroceries = (totalAmount == 0) ? 0 : (totalGroceries / totalAmount)*100; 
		double percentTransportation = (totalAmount == 0) ? 0 : (totalTransportation / totalAmount)*100; 
		double percentDining = (totalAmount == 0) ? 0 : (totalDining / totalAmount)*100; 
		double percentOther = (totalOther == 0) ? 0 : (totalOther / totalAmount)*100; 
		
		System.out.println("Percent spent on groceries: " + (double) Math.round(percentGroceries*100)/100);
		System.out.println("Percent spent on transportation: " + (double) Math.round(percentTransportation*100)/100);
		System.out.println("Percent spent on dining: " + (double) Math.round(percentDining*100)/100);
		System.out.println("Percent spent on other: " + (double) Math.round(percentOther*100)/100);

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
	
	
	public void addRecord() 
	{
		System.out.println("Please provide a note for the new record:");
		String record_note = scanner.nextLine(); 

		System.out.println("Please provide the amount of the purchase:");
		double amount = Double.parseDouble(scanner.nextLine());

		Category category = promptForCategory();

		Date date = new Date();// gets the instant record was created

		Record record = new Record(record_note, date, amount, category);

		records.addRecord(record);

		addToTotals(record);
	}

	
	public void listMatchingRecords()
	{
		boolean foundRecord = false; 
		while(!foundRecord) {
			System.out.println("Please provide a name for the record to edit:");
			String record_name = scanner.nextLine();
			
			for(int i=0; i<records.size(); i++) {
				
				Record record = records.get(i);
				
				if (record.getNote().equals(record_name)) {
					System.out.println("Entry #" + i + ": ");
					record.printRecord();
					foundRecord = true;
				}
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
		Record new_record = new Record(new_note, current_record.getDate(), new_amount, new_category);
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
		listMatchingRecords();
		
		
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
