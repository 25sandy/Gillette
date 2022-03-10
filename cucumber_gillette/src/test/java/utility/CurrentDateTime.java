package utility;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
public class CurrentDateTime {    
  public static String getDateTime() {
   DateTimeFormatter dtf = DateTimeFormatter.ofPattern(" yyyy-MM-dd HH-mm-ss ");  
   LocalDateTime now = LocalDateTime.now();  
   String dateTime = dtf.format(now);
   return dateTime;
  }    
}    