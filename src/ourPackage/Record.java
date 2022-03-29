package ourPackage;
import java.util.Date;
public class Record {
	String note;
	Date d;
	double amount;
	Category c;
	Record(String note, Date d, double amount, Category c){
		this.note =note;
		this.d = d;
		this.amount = amount;
		this.c = c; 
	}
	
	public void editRecord(String note, Date d, double amount, Category c) {
		this.note =note;
		this.d = d;
		this.amount = amount;
		this.c = c; 
	}
	
	 public String getNote() {
		 return note;
	 }
	 
	 public Date getDate() {
		 return d;
	 }
	 
	 public double getAmount() {
		 return amount;
	 }
	 
	 public Category getCategory() {
		 return c;
	 }
}
