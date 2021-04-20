package Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilities {
	
	public static String getTimeStamp() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String date = formatter.format(now);
		return date.replace("/", "_").replace(":", "_").replace(" ", "_");
	}

}
