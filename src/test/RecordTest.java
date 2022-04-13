package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ourPackage.Record;

import ourPackage.Category;

class RecordTest {

	private Record record;
	private Date date;

	
	@BeforeEach
	void setup() {
		date = new Date();
		record = new Record("Schnucks Run", date, 12.50, Category.GROCERIES); //setup
	}
	
	
	
	@Test
	void testGetAmount() {
		double amount = record.getAmount();
		assertEquals(12.5, amount, 0.05);
		
	}
	
	@Test
	void testGetNote() {
		String note = record.getNote();
		assertTrue("Schnucks Run".equals(note));
		
	}
	
	@Test
	void testGetCategory() {
		Category category = record.getCategory();
		assertEquals(Category.GROCERIES, category);
		
	}
	
	@Test
	void testGetDate() {
		Date retrieved_date = record.getDate();
		assertTrue(date.equals(retrieved_date));
		
	}

}
