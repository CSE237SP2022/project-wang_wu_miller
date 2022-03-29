package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import ourPackage.Category;

import org.junit.jupiter.api.Test;

import ourPackage.Records;

import ourPackage.Record;

class BookKeepingTest {

	@Test
	void AddRecordtest() {
		Records records = new Records();
		Record record = new Record("Schnucks run", new Date(), 50.00, Category.GROCERIES);
		records.addRecord(record);
		assertEquals(true, records.contains(record));
		
	}

}
