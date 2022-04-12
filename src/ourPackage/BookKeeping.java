package ourPackage;

import java.util.Date;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

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
		//Records records = new Records();
		System.out.println("begin...");
		bookKeeping.displayMenu();

		// input?

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
	
	
	
	public void displayMenu() 
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
			option = scanner.nextInt();
			chooseMenuOption(option);
		}
	}

	
	
	public void updateTotals(Record record)
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

		
		System.out.println("Total amount: " + formattedTotalAmount);
		System.out.println("Total groceries: " + formattedTotalGroceries);
		System.out.println("Total transportation: " + formattedTotalTransportation);
		System.out.println("Total dining: " + formattedTotalDining);
		System.out.println();
	}
	
	
	public void showCategoryPercentages()
	{
		//ternary operations prevent arithmetic exception from dividing by zero
		double percentGroceries = (totalAmount == 0) ? 0 : (totalGroceries / totalAmount)*100; 
		double percentTransportation = (totalAmount == 0) ? 0 : (totalTransportation / totalAmount)*100; 
		double percentDining = (totalAmount == 0) ? 0 : (totalDining / totalAmount)*100; 
		
		System.out.println("Percent spent on groceries: " + (double) Math.round(percentGroceries*100)/100);
		System.out.println("Percent spent on transportation: " + (double) Math.round(percentTransportation*100)/100);
		System.out.println("Percent spent on dining: " + (double) Math.round(percentDining*100)/100);
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
		int category = scanner.nextInt();
		
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
	
	
	public void addRecord() {
		
		
		
		System.out.println("Please provide a note for the new record:");
		String record_note = scanner.next(); 
		
		scanner.nextLine();
		
		System.out.println("Please provide the amount of the purchase:");
		double amount = scanner.nextDouble();
		
		scanner.nextLine();

		Category category = promptForCategory();

		Date date = new Date();// gets the instant record was created

		Record record = new Record(record_note, date, amount, category);

		records.addRecord(record);
		updateTotals(record);
	}

	public void editRecord() {
		// delete
		// update
		System.out.println("edit record ...");
		
	}
	
	//save and quit
	public void quit() {
		System.out.println("Quit");
		scanner.close();
		System.exit(0);
		
	}

}
