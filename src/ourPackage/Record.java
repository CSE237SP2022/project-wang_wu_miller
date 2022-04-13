package ourPackage;
import java.util.Date;
import java.util.UUID;

/**
 * Record class indicates each entry of the user spent
 * @author Joanna
 *
 */
public class Record {
	private String note;
	private Date date;
	private double amount;
	private Category category;
	private String ID;
	
	
	/**
	 * constructor, generate an id for each record
	 * @param note
	 * @param date
	 * @param amount
	 * @param category
	 */
	public Record(String note, Date date, double amount, Category category){
		this.note = note;
		this.date = date;
		this.amount = amount;
		this.category = category; 
		this.ID = UUID.randomUUID().toString();
	}
	
	public void editRecord(String note, Date date, double amount, Category category) {
		this.note = note;
		this.date = date;
		this.amount = amount;
		this.category = category; 
	}
	
	
	 public String getNote() {
		 return note;
	 }
	 
	 public Date getDate() {
		 return date;
	 }
	 
	 public double getAmount() {
		 return amount;
	 }
	 
	 public Category getCategory() {
		 return category;
	 }
	 
	 public String getID() {
		 return ID;
	 }
	 
	 public void printRecord()
	 {
		 System.out.println("Note: " + note);
		 System.out.println("Date: " + date);
		 System.out.println("Amount: " + amount);
		 System.out.println("Category: " + category);
		 System.out.println("ID: " + ID);
	 }
}
