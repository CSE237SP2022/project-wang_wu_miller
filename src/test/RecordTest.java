package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ourPackage.Record;
import ourPackage.User;
import ourPackage.Category;

class RecordTest {

	private Record record;
	private User user; 
	private Date date;

	
	@BeforeEach
	void setup() {
		date = new Date();
		user = new User("colin");
		record = new Record("Schnucks Run", date, 12.50, Category.GROCERIES, user); //setup
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

	@Test
	void testEditRecord() {
		Date newDate = new Date();
		record.editRecord("Dinner", newDate, 15.5, Category.DINING);
		
		String newNote = record.getNote();
		double newAmount = record.getAmount();
		Category newCategory = record.getCategory();
		
		assertTrue("Dinner".equals(newNote));
		assertEquals(15.5, newAmount, 0.05);
		assertEquals(Category.DINING, newCategory);
		
	}
}
