package ateamproject.MainWindow;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
public class Dday {
    
  public static void main(String[] args) {
	  LocalDate fromDate = LocalDate.now();
	  LocalDate toDate = LocalDate.of(2022,03,30);
	
	  long betweenDays = ChronoUnit.DAYS.between(fromDate, toDate);
      System.out.println("D-" + betweenDays);
  
  }
}