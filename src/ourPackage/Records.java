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
}


