package test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ourPackage.Category;
import ourPackage.Records;
import ourPackage.Record;

class RecordsTest {
	
	private Record recordOne;
	private Record recordTwo;
	private Record recordThree;
	private Records records;
	
	@BeforeEach
	void setup() {
		Date date = new Date();
		recordOne = new Record("Schnucks Run", date, 12.50, Category.GROCERIES);
		recordTwo = new Record("Bagel", date, 2.5, Category.DINING);
		recordThree = new Record("Schnucks Run", date, 12.50, Category.GROCERIES); 
		records = new Records();
		records.addRecord(recordOne);
		records.addRecord(recordTwo);
		records.addRecord(recordThree);
	}

	@Test
	void testSizeOfRecords() {
		
		int testSize = records.size();
		
		assertEquals(3, testSize);
	}
	
	
	
	
	@Test
	void testGetMethod() {
		Record theSecondRecord = records.get(1);
		
		String note = theSecondRecord.getNote();
		double amount = theSecondRecord.getAmount();
		
		assertEquals("Bagel", note);
		assertEquals(2.5, amount,0.05);
	}
	
	
	@Test
	void testRemove() {
		Record removeItem = records.get(2);
		records.removeRecord(removeItem);
		
		int testSize = records.size();
		
		assertEquals(2, testSize);
	}

}
