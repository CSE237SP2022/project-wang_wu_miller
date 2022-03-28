package ourPackage;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
public class BookKeeping {
    public static void main(String[] args) throws FileNotFoundException
    {
        File f=new File("record.txt");
        if (!f.exists())
        {
            System.out.println("record.txt does not exists.");
            System.out.println("Please prepare record.txt and rerun the program.");
            System.exit(0);
        }
        Scanner file = new Scanner(f);
        Records records = RecordsOperations.readRecords(file);
        RecordsOperations.writeRecords(records,f);
        file.close();
        //start menu
        menu();
    	Scanner input=new Scanner(System.in);
    	double d = -1;
    	while(d != 0) {
    		System.out.println("input a double\n");
    		d = input.nextDouble();
    		System.out.println("You print "+d);
    	}
    }
    
    private static void menu() {
    	int option = selectOption();
    	switch(option) {
    		case 1:optionOne();
    		case 2:optionTwo();
    		case 3:optionThree();
    	}
    		
    }
    
    private static int selectOption()
    {
    	return -1;
    }
    
    
    private static void optionOne()
    {
    	
    }
    
    private static void optionTwo()
    {
    	
    }
    
    private static void optionThree()
    {
    	
    }

}
