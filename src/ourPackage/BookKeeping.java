package ourPackage;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

public class BookKeeping {
	private Records myRecords;
	public BookKeeping() throws IOException {
		this.myRecords = new Records();
		System.out.println("Createing a bk instance!");
		System.out.println("reading your records ...");
		int rf = readFile();
		if(rf == 0) {
			System.out.println("Read file success!");
			this.menu();
			
		}else {
			System.out.println("Read file failure!");
		}
	}

	//read txt file from system
	private int readFile() throws IOException {
		Scanner recordScanner = null;
		try {
			File myObj = new File("src/Driver/Records.txt");
			recordScanner = new Scanner(myObj);
			System.out.println("get the txt");
			txt2Records(recordScanner);
			recordScanner.close();
			return 0;
		} catch (FileNotFoundException e) {
			System.out.println("cannot find the txt file !");
			//e.printStackTrace();
			return 1;
		}
	}
	
	//read txt and change it to records
	private int txt2Records(Scanner input) throws IOException {
		while(input.hasNextLine()) {
			String line = input.nextLine();
			Record record = line2Record(line);
			if(record != null) {
				this.myRecords.addRecord(record,false);
			}
		}
		return 0;
	}
	
	//transfer a line to record
	private static Record line2Record(String line) {
		String[] arrOfStr = line.split("///");
		if(arrOfStr.length>=4) {
			int ID = Integer.parseInt(arrOfStr[0]);
			String note = arrOfStr[1];
			MyDate myDate = new MyDate(arrOfStr[2]);
			double amount = Double.parseDouble(arrOfStr[3]);
			Category category = int2Category(Integer.parseInt(arrOfStr[4]));
			return new Record(note, amount, category, myDate, ID);
		}
		return null;
	
	}
	
	private void menu() throws IOException {
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
			if (option == 5) {
				quit();
				System.out.println("quiting the program");
				break;
			}
			switch (option) {
			case 1:
				printRecords();
				break;
			case 2:
				showSummary();
				break;
			case 3:
				addNewRecord();
				break;
			case 4:
				editRecord();
				break;
			default:
				System.out.println("Invalid format! Please re-enter the option that you want to choose. ");
				break;
			}
			System.out.println();

		}
		sc.close();
		System.exit(0);

	}

	public void printRecords() {
		this.myRecords.print();;
		return;
	}

	private static void showSummary() {
		System.out.println("show summary ...");
		return;
	}
	
	private static Category int2Category(int i) {
		Category c = Category.Others;
		switch (i) {
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
		return c;
	}

	private void addNewRecord() throws IOException {
		Scanner sc = new Scanner(System.in);
		String note = getNote(sc);
		double amount = getAmount(sc);
		Category category = getCategory(sc);
		MyDate mydate = new MyDate();// gets the instant record was created
		int ID = this.myRecords.size + 1;
		Record record = new Record(note,  amount, category , mydate, ID);
		this.myRecords.addRecord(record,true);
	}
	
	//get note from scanner input
	private static String getNote(Scanner sc) {
		System.out.println("Please provide a note for the new record:");
		return sc.nextLine();
	}
	
	//get amount from scanner input
	private static double getAmount(Scanner sc) {
		System.out.println("Please provide the amount of the purchase:");
		return sc.nextDouble();
	}
	
	//get note from scanner input
	private static Category getCategory(Scanner sc) {
		System.out.println("Choose a category for the new record: (Please enter a number)");
		System.out.println("1. Groceries");
		System.out.println("2. Transportation");
		System.out.println("3. Dining");
		System.out.println("4. Others");
		return int2Category(sc.nextInt());
	}

	private static void editRecord() {
		// delete
		// update
		System.out.println("edit record ...");
		return;
	}

	// save and quit
	private static void quit() {
		System.out.println("quit ...");
		return;
	}

}
