package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ourPackage.BookKeeping;
import ourPackage.Category;
import ourPackage.Record;
import ourPackage.Records;

class BoookKeepingTest {

	private BookKeeping bookKeeping;
	private Date date;
	private Record recordOne;
	private Record recordTwo;
	

	
	@BeforeEach
	void setup()
	{
		bookKeeping = new BookKeeping();
		date = new Date();
		recordOne = new Record("Schnucks Run", date, 12.50, Category.GROCERIES);
		recordTwo = new Record("Bagel", date, 2.5, Category.DINING);
		
	}
	@Test
	void testAddToTotals() 
	{	
		bookKeeping.addToTotals(recordOne);
		bookKeeping.addToTotals(recordTwo);
		
		assertEquals(12.5, bookKeeping.getTotalGroceries(), 0.05);
		assertEquals(2.5, bookKeeping.getTotalDining(), 0.05);
		assertEquals(15, bookKeeping.getTotalAmount(), 0.05);
		
	}
	
	@Test
	void testSubtractFromTotals() 
	{
		bookKeeping.addToTotals(recordOne);
		bookKeeping.addToTotals(recordTwo);
		bookKeeping.subtractFromTotals(recordTwo);
		
		assertEquals(12.5, bookKeeping.getTotalGroceries(), 0.05);
		assertEquals(0, bookKeeping.getTotalDining(), 0.05);
		assertEquals(12.5, bookKeeping.getTotalAmount(), 0.05);
	}
	
	@Test
	void testFormatCurrency()
	{
		double formatted = bookKeeping.formatCurrency(179.481);
		assertEquals(179.48, formatted, 0.05);
	}
	
	@Test
	void testGetTotalPercentage()
	{
		bookKeeping.addToTotals(recordOne);
		bookKeeping.addToTotals(recordTwo);
		
		double groceriesPercentage = bookKeeping.getTotalPercentage(bookKeeping.getTotalGroceries());
		assertEquals(83, groceriesPercentage, 0.05);
	}
	@Test
	void addRecordTest()
	{
		Record added = bookKeeping.addRecord();
		Records records = bookKeeping.getRecords();
		int size = records.size();
		assertEquals(records.get(size - 1), added);
		
	}
	@Test
	void testListMatchingRecords()
	{
		Records records = bookKeeping.getRecords();
		records.addRecord(recordOne);
		boolean match = bookKeeping.listMatchingRecords("Schnucks Run");
		assertEquals(true, match);
	}
	
	
	

}
