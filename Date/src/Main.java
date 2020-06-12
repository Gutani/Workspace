import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date ano1 = sdf.parse("31/06/2015");
		Date ano2 = sdf2.parse("23/01/2020 17:24:02");
		
		Date dateNow = new Date();
		
		Date dateMiliseconds = new Date(System.currentTimeMillis());
		
		Date firstDate = new Date(0L); //The L means Long
		//The date will correspond to 1970, 5am 
		Date customDate = new Date(1000L * 60L * 60L * 5L); 
		// Multiplying 1000(1 second that means 1000 milliseconds) * 60(minute) * 60(hour) * 5(hours that i want
		//The result will show 2pm, because of time zone Brazil -3
		Date isoFormat = Date.from(Instant.parse("2018-06-25T13:42:02Z"));
		
		System.out.println(sdf.format(ano1)); //just day, month and year
		System.out.println(ano2); //Full format
		System.out.println(dateNow);
		System.out.println(dateMiliseconds);
		System.out.println(firstDate); //
		//mid night of 1970 august 1, GMT UTC, but Brazil time zone is -3, so it appears to be 1969 December 31 at 9pm.
	
		System.out.println(customDate);
		System.out.println(isoFormat);
		System.out.println("This One:  "+ sdf3.format(isoFormat));
	
		Calendar cal = Calendar.getInstance();
		cal.setTime(isoFormat);
		cal.add(Calendar.HOUR_OF_DAY, 3); // Add 3 hours.
		isoFormat = cal.getTime();
		System.out.println(sdf2.format(isoFormat));
		
		//how to get minutes from a date
		int minutes = cal.get(Calendar.MINUTE);
		int month = 1 + cal.get(Calendar.MONTH); //plus 1 because it starts with 0 January
		System.out.println(minutes);
		System.out.println(month);
	
		
	}

}
