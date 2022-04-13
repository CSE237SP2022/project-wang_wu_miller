package ourPackage;
import java.util.Calendar;
import java.util.Date;
public class MyDate {
	int day;
	int month;
	int year;
	public MyDate() {
		Date aDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(aDate);
		this.day = calendar.get(Calendar.DAY_OF_MONTH);
		this.month = calendar.get(Calendar.MONTH);
		this.year = calendar.get(Calendar.YEAR);
		System.out.println("create myDate "+year+"-"+month+"-"+day);
	}
	
	public MyDate(String str) {
		String[] arrOfStr = str.split("-");
		if(arrOfStr.length == 3) {
			this.year = Integer.parseInt(arrOfStr[0]);
			this.month = Integer.parseInt(arrOfStr[1]);
			this.day = Integer.parseInt(arrOfStr[2]);
		}
	}
	
	public String toString() {
		return year+"-"+month+"-"+day;
	}
	

}
