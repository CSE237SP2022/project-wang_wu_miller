package ourPackage;

public class Record {
	String note;
	MyDate d;
	double amount;
	Category c;
	int ID;
	
	Record(String note, double amount, Category c, MyDate d, int id){
		this.note =note;
		this.d = d;
		this.amount = amount;
		this.c = c; 
		this.ID = id;
	}
	
	public void print() {
		System.out.printf("%d . %.2f %s at %s, %s \n",ID,amount,c.toString(),d.toString(),note);
	}
	
	public void editRecord(String note, MyDate d, double amount, Category c) {
		this.note =note;
		this.d = d;
		this.amount = amount;
		this.c = c; 
	}
	
	 public String getNote() {
		 return note;
	 }
	 
	 public MyDate getDate() {
		 return d;
	 }
	 
	 public double getAmount() {
		 return amount;
	 }
	 
	 public Category getCategory() {
		 return c;
	 }
	 
	 public int getID() {
		 return ID;
	 }
}
