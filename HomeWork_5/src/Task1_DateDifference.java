import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class SwiftDate {
	int year;
	int month;
	int day;

	public boolean isLeapYear() {
		boolean isLeapYear = false;
		// java.time.Year.of(this.year).isLeap();
		if (this.year % 400 == 0) {
			isLeapYear = true;
		} else if (this.year % 4 == 0 && this.year % 100 != 0) {
			isLeapYear = true;
		}

		return isLeapYear;
	}

	public int getCentury() {
		int century;

		if (this.year % 100 == 0) {
			century = this.year / 100;
		} else {
			century = (this.year / 100) + 1;
		}

		return century;
	}
	
	public long getDaysDifference(SwiftDate other) {
		LocalDate thisDate = LocalDate.of(this.year, this.month, this.day);
		LocalDate otherDate = LocalDate.of(other.year, other.month, other.day);

		return Math.abs(ChronoUnit.DAYS.between(thisDate, otherDate));
	}

	public void printInfo() {
		String message;
		message = this.year + " " + this.month + " " + this.day + " - " + this.getCentury() + " century. ";

		if (this.isLeapYear()) {
			message = message + "It is LEAP year";
		}
		
		System.out.println(message);
	}
}

public class Task1_DateDifference {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		SwiftDate [] swiftDateArray = new SwiftDate[2];
		
		for (int i = 0; i < swiftDateArray.length; i++) {
			swiftDateArray[i] = new SwiftDate();
			System.out.println("Eneter date" + i + " year in format YYYY" );
			swiftDateArray[i].year = sc.nextInt();
			System.out.println("Eneter date" + i + " month in format MM" );
			swiftDateArray[i].month = sc.nextInt();
			System.out.println("Eneter date" + i + " day in format DD" );
			swiftDateArray[i].day = sc.nextInt();
		}
		
		System.out.println(swiftDateArray[0].getDaysDifference(swiftDateArray[1]));
		
		for (int i = 0; i < 2; i++) {
		swiftDateArray[i].printInfo();
		}
		
		sc.close();
	}
}
