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

	public int size() {
		// TODO Auto-generated method stub
		
		return records.size();
	}
	public Record get(int i) {
		// TODO Auto-generated method stub
		Record r = records.get(i);
		return r;
	}
}


