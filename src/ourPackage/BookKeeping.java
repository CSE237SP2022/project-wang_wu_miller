package ourPackage;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
public class BookKeeping {
    public static void main(String[] args) throws FileNotFoundException
    {
    	//
        File f=new File("record.txt");
        if (!f.exists())
        {
            System.out.println("record.txt does not exists.");
            System.out.println("Please prepare record.txt and rerun the program.");
            System.exit(0);
        }
        
        //read file
        Scanner file = new Scanner(f);
        Records records = RecordsOperations.readRecords(file);
        
        //start menu, edit records
        menu();
        
        //input
        RecordsOperations.writeRecords(records,f);
        
        file.close();
        

    }
    
    private static void menu() {
    	int option = selectOption();
    	switch(option) {
    		case 1:printRecords();
    		break;
    		case 2:showSummary();
			break;
    		case 3:addRecord();
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
    
    private static void addRecord()
    {
    	
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
