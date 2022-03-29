package ourPackage;
import java.util.Date;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
public class BookKeeping {
    public static void main(String[] args) throws FileNotFoundException
    {
    	Records records = new Records();
        menu(records);
        
        //input
        

    }
    
    private static void menu(Records records) {
    	int option = selectOption();
    	switch(option) {
    		case 1:printRecords();
    		break;
    		case 2:showSummary();
			break;
    		case 3:addRecord(records);
			break;
    		case 4:editRecord();
			break;
    		case 5:quit();
			break;
 
    	}
    		
    }
    
    private static int selectOption()
    {
    	System.out.println("Please select an option: (just enter the number you chose)");
    	System.out.println("1. show all your spent");
    	System.out.println("2. show your spending summary");
    	System.out.println("3. add a new record");
    	System.out.println("4. edit existing record");
    	Scanner sc = new Scanner(System.in);
        int optiontype = sc.nextInt();
        if(optiontype >= 4) {
        	System.out.println("Invalid format! Please re-enter the option that you want to choose. ");
        	selectOption();
        }
        sc.close();
    	return optiontype;
    }
    
    
    private static void printRecords()
    {
    	
    }
    
    private static void showSummary()
    {
    	
    }
    
    private static void addRecord(Records records)
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Please provide a note for the new record:");
    	String record_note = sc.nextLine();
    	//System.out.println("Please provide the date of the purchase:");//specify required format for date
    	
    	/*System.out.println("Year:");
    	int year = sc.nextInt();
    	int month = sc.nextInt();
    	int date = sc.nextInt();
    	*/
    	
    	System.out.println("Please provide the amount of the purchase:");
    	double amount = sc.nextDouble();
    	
    	System.out.println("Choose a category for the new record: (Please enter a number)");
    	System.out.println("1. Groceries");
    	System.out.println("2. Transportation");
    	System.out.println("3. Dining");
    	int category = sc.nextInt();
    	Category c = Category.NONE;
    	switch(category) {
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
    	
    	Date date = new Date();//gets the instant record was created
    	
    	Record record = new Record(record_note, date, amount, c);
    	
    	records.addRecord(record);

    }
    
    private static void editRecord()
    {
    	//delete
    	//update
    }
    
    private static void quit()
    {
    	//delete
    	//update
    }

}
