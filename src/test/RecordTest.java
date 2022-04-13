package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import ourPackage.Category;

import ourPackage.Record;

class RecordTest {

	@Test
	void testGetAmount() {
		Date date = new Date();
		Record record = new Record("Ticket",date,12.50,Category.GROCERIES);
		double amount = record.getAmount();
		assertEquals(12.5, amount, 0.05);
		
	}
	
	@Test
	void testGetNote() {
		Date date = new Date();
		Record record = new Record("Ticket",date,12.50,Category.GROCERIES);
		String note = record.getNote();
		assertEquals("Ticket", note);
		
	}
	
	@Test
	void testGetCategory() {
		Date date = new Date();
		Record record = new Record("Ticket",date,12.50,Category.GROCERIES);
		Category category = record.getCategory();
		assertEquals(Category.GROCERIES, category);
		
	}


}
