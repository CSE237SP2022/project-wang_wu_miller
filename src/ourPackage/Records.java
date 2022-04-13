package ourPackage;
import java.util.*;
public class Records {
	List<Record> records;
	
	Records(){
		records = new ArrayList<Record>();
	}
	
	public void addRecord(Record r) {
		records.add(r);
	}
	
	public void removeRecord(Record r) {
		records.remove(r);
	}

	public int size() {
		// TODO Auto-generated method stub
		
		return records.size();
	}
	public Record get(int i) {
		// TODO Auto-generated method stub
		Record r = records.get(i);
		return r;
	}
	
	public void printRecords()
	{
		System.out.println("All of your records: " + "(" + size() + ")");
		System.out.println();
		
		for (int i = 0; i < size(); i++) {
			Record record = records.get(i);
			System.out.println("Entry #" + i + ": ");
			System.out.println("Note: " + record.getNote());
			System.out.println("Date: " + record.getDate());
			System.out.println("Amount: " + record.getAmount());
			System.out.println("Category: " + record.getCategory());
			System.out.println();
		}
		System.out.println();
	}
}


