package ourPackage;
import java.util.*;
public class Records {
	List<Record> records;
	
	public Records(){
		records = new ArrayList<Record>();
	}
	
	public void addRecord(Record r) {
		records.add(r);
	}
	
	public boolean contains(Record r) {
		return records.contains(r);
	}
}


