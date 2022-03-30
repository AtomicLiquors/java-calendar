package ateamproject.MainWindow;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
public class Dday {
    
  public static long[] setDday(int y, int m, int d) {
	  LocalDate fromDate = LocalDate.now();
	  LocalDate toDate = LocalDate.of(y, m, d); 
	
	  long betweenDays = ChronoUnit.DAYS.between(fromDate, toDate);
	  
	  if (betweenDays < 0)
		  betweenDays = 0;
	  if (betweenDays > 99)
		  betweenDays = 99;
	  
      System.out.println("D-" + betweenDays/10 + betweenDays % 10);
      
      long numTen = betweenDays/10;
      long numOne = betweenDays%10;
      
      return new long[] {numTen, numOne};

  }
}