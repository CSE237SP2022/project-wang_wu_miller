package ourPackage;
import java.util.Date;
import java.util.UUID;

public class Record {
	private String note;
	private Date date;
	private double amount;
	private Category category;
	private String ID;
	
	Record(String note, Date date, double amount, Category category){
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
}
