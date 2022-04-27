package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import ourPackage.BookKeeping;
import ourPackage.Category;
import ourPackage.Record;

class BoookKeepingTest {

	@Test
	void testAddToTotals() {
		BookKeeping bookKeeping = new BookKeeping();
		Date date = new Date();
		Record recordOne = new Record("Schnucks Run", date, 12.50, Category.GROCERIES);
		Record recordTwo = new Record("Bagel", date, 2.5, Category.DINING);
		
		bookKeeping.addToTotals(recordOne);
		bookKeeping.addToTotals(recordTwo);
		
		assertEquals(12.5, bookKeeping.getTotalGroceries(), 0.05);
		assertEquals(2.5, bookKeeping.getTotalDining(), 0.05);
		
	}

}
