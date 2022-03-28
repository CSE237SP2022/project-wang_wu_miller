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
    	return -1;
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
