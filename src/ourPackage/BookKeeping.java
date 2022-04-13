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
		//Scanner scanner = new Scanner(System.in);
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
		//Scanner scanner = new Scanner(System.in);
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
		//scanner.close();
		//System.exit(0);
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
		//Scanner scanner = new Scanner(System.in);

			 

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
	
	
	public void addRecord() {
		
		
		
		System.out.println("Please provide a note for the new record:");
		String record_note = scanner.nextLine(); 
		
		//scanner.nextLine();
		
		System.out.println("Please provide the amount of the purchase:");
		double amount = Double.parseDouble(scanner.nextLine());
		
		//scanner.nextLine();

		Category category = promptForCategory();

		Date date = new Date();// gets the instant record was created

		Record record = new Record(record_note, date, amount, category);

		records.addRecord(record);

		updateTotals(record);
	}

	

	private static void editRecord(Records records) {
		// delete
		// update
		Scanner sc = new Scanner(System.in);
		
		//check if record name given matches with a corresponding record that exists, if so will list out the records that match up 
		boolean foundRecord = false; 
		while(!foundRecord) {
			System.out.println("Please provide a name for the record to edit:");
			String record_name = sc.nextLine();
			
			for(int i=0; i<records.size(); i++) {
				if (records.get(i).note.equals(record_name)) {
					System.out.println("Entry #" + i + ": ");
					System.out.println(records.get(i).note);
					System.out.println(records.get(i).d);
					System.out.println(records.get(i).amount);
					System.out.println(records.get(i).c);
					System.out.println(records.get(i).ID);
					foundRecord = true;
				}
			}
		}
		
		
		System.out.println("Please enter the entry ID of the entry you want to edit:");
		String recordID = sc.nextLine();
		
		for (int i = 0; i < records.size(); i++) {
			if (records.get(i).ID.equals(recordID)) {
				
				String record_note = records.get(i).note;
				double amount = records.get(i).amount;
				Category c = records.get(i).c;
		
				while(true) {
					System.out.println("What would you like to edit?");
					System.out.println("1: name");
					System.out.println("2: amount");
					System.out.println("3: category");
					System.out.println("4: quit");
					int editOption = sc.nextInt(); 
					
					if(editOption == 4) {
						System.out.println("Exiting editing...");
						//sc.close();
						break;
					}
					
					switch (editOption) {
					case 1: 
						System.out.println("Please provide a note for the edited record:");
						sc.nextLine();
						record_note = sc.nextLine();
						break;
						
					case 2:
						System.out.println("Please provide the new amount of the purchase:");
						amount = sc.nextDouble();
						break;
					
					case 3: 
						System.out.println("Choose a category for the new record: (Please enter a number)");
						System.out.println("1. Groceries");
						System.out.println("2. Transportation");
						System.out.println("3. Dining");
						int category = sc.nextInt();
						switch (category) {
						case 1:
							c = Category.GROCERIES;
							break;
						case 2:
							c = Category.TRANSPORTATION;
							break;
						case 3:
							c = Category.DINING;
							break;
						default:
							System.out.println("Invalid format! Please re-enter the option that you want to choose. ");
							break;
						}
					}
				}
				System.out.println(record_note);
				System.out.println(amount);
				System.out.println(c);

				//add in new record
				Record record = new Record(record_note, records.get(i).d, amount, c);
				records.addRecord(record);
				
				//remove old record
				Record recordToRemove = records.get(i);
				records.removeRecord(recordToRemove);
				printRecords(records);
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
