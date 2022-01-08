package test;

import java.sql.Date;
import java.util.Calendar;

public class dateClass {
	
	
	public static String getDate(int prevSat) {
		
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(Calendar.DAY_OF_WEEK, calendar.FRIDAY);
		
		calendar.add(Calendar.DATE, prevSat);
		java.util.Date lastWeekSat = calendar.getTime();
		
		calendar.add(Calendar.DATE, 6);
		java.util.Date thisWeekFri = calendar.getTime();
		
//		System.out.println(lastWeekSat + "\n" +  thisWeekFri);
		
		String lastSaturdayDate = lastWeekSat.toString().substring(8, 10);
		String thisFridayDate = thisWeekFri.toString().substring(8, 10);
		
		String lastSaturdayMonth = lastWeekSat.toString().substring(4, 7).toUpperCase();
		String thisFridayMonth = thisWeekFri.toString().substring(4, 7).toUpperCase();
		
		
		String lastSaturdayYear = lastWeekSat.toString().substring(24, 28);
		String thisFridayYear = thisWeekFri.toString().substring(24, 28);
				
		
		String lastWeekSaturday = lastSaturdayDate + "-" + lastSaturdayMonth + "-" + lastSaturdayYear;
		String thisWeekFriday = thisFridayDate + "-" + thisFridayMonth + "-" + thisFridayYear;
		 
		String date = lastWeekSaturday + " To " + thisWeekFriday;
		
		return date;
		
	}
	
}
