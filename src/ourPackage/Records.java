package ourPackage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
public class Records {
	List<Record> records;
	int size;
	Records(){
		records = new ArrayList<Record>();
		size = 0;
	}
	public void print() {
		for(Record record: records) {
			record.print();
		}
	}
	public void addRecord(Record r, Boolean write) throws IOException {
		records.add(r);
		if(write) {
			writeRecord(r);
		}
		size++;
	}
	
	public void writeRecord(Record r) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append(r.getID());
		sb.append("///");
		sb.append(r.getNote());
		sb.append("///");
		sb.append(r.getDate().toString());
		sb.append("///");
		sb.append(r.getAmount());
		sb.append("///");
		sb.append(r.getCategory().ordinal());
		Files.write(Paths.get("src/Driver/Records.txt"), (sb.toString() + System.lineSeparator()).getBytes(),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
	}
}


