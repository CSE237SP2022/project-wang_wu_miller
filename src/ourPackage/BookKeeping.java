package ourPackage;

import java.util.Date;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class BookKeeping {
	public static void main(String[] args) throws FileNotFoundException {
		Records records = new Records();
		System.out.println("begin...");
		menu(records);

		//test .gitignore

	}

	private static void menu(Records records) {
		Scanner sc = new Scanner(System.in);
		int option;
		while (true) {
			System.out.println("Please select an option: (just enter the number you chose)");
			System.out.println("1. show all your spent");
			System.out.println("2. show your spending summary");
			System.out.println("3. add a new record");
			System.out.println("4. edit existing record");
			System.out.println("5. quit");
			option = sc.nextInt();
			if(option == 5) {
				quit();
				System.out.println("quiting the program");
				break;
			}
			switch (option) {
			case 1:
				printRecords(records);
				break;
			case 2:
				showSummary(records);
				break;
			case 3:
				addRecord(records);
				break;
			case 4:
				editRecord();
				break;
			default:
				System.out.println("Invalid format! Please re-enter the option that you want to choose. ");
				break;
			}

		}
		sc.close();
		System.exit(0);

	}

	private static void printRecords(Records records) {
		
		
		for (int i = 0; i < records.size(); i++) {
			System.out.println("Entry #" + i + ": ");
			System.out.println(records.get(i).note);
			System.out.println(records.get(i).d);
			System.out.println(records.get(i).amount);
			System.out.println(records.get(i).c);
		}
		System.out.println();
		return;
	}

	private static void showSummary(Records records) {
		System.out.println("show summary ...");
		System.out.println("show summary ...");
		System.out.println("Total purchases: " + records.size());
		double totalGroceries = 0; 
		double totalTransportation = 0; 
		double totalDining = 0;
		double totalAmount = 0; 

		
		for (int i = 0; i < records.size(); i++) {
			//System.out.println(records.get(i).amount);
			 Category category = records.get(i).c;
			 switch (category) {
				case GROCERIES:
					totalGroceries += records.get(i).amount; 
					totalAmount += records.get(i).amount;
					break;
				case TRANSPORTATION:
					totalTransportation += records.get(i).amount; 
					totalAmount += records.get(i).amount;
					break;
				case DINING:
					totalDining += records.get(i).amount;
					totalAmount += records.get(i).amount;
					break;
				case NONE:
					break;
				}
		}
		
		System.out.println("Total amount: " + (double) Math.round(totalAmount*100)/100);
		System.out.println("Total groceries: " + (double) Math.round(totalGroceries*100)/100);
		System.out.println("Total transportation: " + (double) Math.round(totalTransportation*100)/100);
		System.out.println("Total dining: " + (double) Math.round(totalDining*100)/100);
		double percentGroceries = (totalGroceries / totalAmount)*100; 
		double percentTransportation = (totalTransportation / totalAmount)*100; 
		double percentDining = (totalDining / totalAmount)*100; 
		System.out.println("Percent spent on groceries: " + (double) Math.round(percentGroceries*100)/100);
		System.out.println("Percent spent on transportation: " + (double) Math.round(percentTransportation*100)/100);
		System.out.println("Percent spent on dining: " + (double) Math.round(percentDining*100)/100);
		
		return;
	}

	private static void addRecord(Records records) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please provide a note for the new record:");
		String record_note = sc.nextLine();
		// System.out.println("Please provide the date of the purchase:");//specify
		// required format for date

		/*
		 * System.out.println("Year:"); int year = sc.nextInt(); int month =
		 * sc.nextInt(); int date = sc.nextInt();
		 */

		System.out.println("Please provide the amount of the purchase:");
		double amount = sc.nextDouble();

		System.out.println("Choose a category for the new record: (Please enter a number)");
		System.out.println("1. Groceries");
		System.out.println("2. Transportation");
		System.out.println("3. Dining");
		int category = sc.nextInt();
		Category c = Category.NONE;
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

		}

		Date date = new Date();// gets the instant record was created

		Record record = new Record(record_note, date, amount, c);

		records.addRecord(record);

	}

	private static void editRecord() {
		// delete
		// update
		System.out.println("edit record ...");
		return;
	}
	
	//save and quit
	private static void quit() {
		System.out.println("quit ...");
		return;
	}

}
