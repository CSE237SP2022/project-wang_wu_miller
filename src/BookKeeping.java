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
//        int num=0, sum=0;
//        Scanner input = new Scanner(f);
//        while (input.hasNextInt())
//        {
//            num = input.nextInt();
//            sum+=num;
//        }
//        System.out.println("The sum is "+sum);
//        input.close();
    	Scanner input=new Scanner(System.in);
    	double d = -1;
    	while(d != 0) {
    		System.out.println("input a double\n");
    		d = input.nextDouble();
    		System.out.println("You print "+d);
    	}
    }

}
