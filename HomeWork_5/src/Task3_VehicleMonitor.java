import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Scanner;

class Vehicle{
	String type;	
	String model;
	int power;
	double fuelConsumption;
	int yearProduced;
	String  licenseNo;
	int weight;
	String color = "N/A";
	
	
	public Vehicle (String type, String model, int power, double fuelConsumption, int yearProduced, String licenseNo) {
		this.type=type;
		this.model=model;
		this.power=power;
		this.fuelConsumption=fuelConsumption;
		this.yearProduced=yearProduced;
		this.licenseNo=licenseNo;
	}
	
	public Vehicle (String type, String model, int power, double fuelConsumption, int yearProduced, String licenseNo, int weight ) {
		this(type, model, power, fuelConsumption, yearProduced, licenseNo);
		this.weight=weight;
	}
	
	public Vehicle (String type, String model, int power, double fuelConsumption, int yearProduced, String licenseNo, String color ) {
		this(type, model, power, fuelConsumption, yearProduced, licenseNo);
		this.color=color;
		}
	
	public Vehicle (String type, String model, int power, double fuelConsumption, int yearProduced, String licenseNo,int weight, String color ) {
		this(type, model, power, fuelConsumption, yearProduced, licenseNo, weight);
		this.color=color;
		}
	
	public double calculateTripPrice(double fuelPrice, double distance) {
		return this.fuelConsumption / 100 * distance * fuelPrice;
	}
	
	public double typeCoefficient () {
		double typeCoefficient=0;
		
		switch (type) {
		case  "car":
			typeCoefficient = 1.00;
			break;
		case  "suv":
			typeCoefficient = 1.12;
			break;
		case  "truck":
			typeCoefficient = 1.20;
			break;
		case  "motorcycle":
			typeCoefficient = 1.50;
		break;
		}
		
		return typeCoefficient;
		}
	
	public double getInsurancePrice() {
		int carAge = Calendar.getInstance().get(Calendar.YEAR) - this.yearProduced ;
		return (0.16 * power) * (1.25 * carAge) * (0.05 * fuelConsumption) * this.typeCoefficient() ;
		}
	
	
}



public class Task3_VehicleMonitor {
	
	public static String  GetUniqueVehicleLicenceNumber(int random) {
		String randomLicenceNumber = null;
		
		if(random / 10 == 0) {
			randomLicenceNumber = "000" + random;
		}else if(random / 10 > 0 && random / 10 < 10) {
			randomLicenceNumber = "00" + random;
		} else if(random / 10 > 9 && random / 10 < 100) {
			randomLicenceNumber = "0" + random;
		}else if(random / 10 > 99){
			randomLicenceNumber = Integer.toString(random);
		}
		
		return randomLicenceNumber;
	}
	
	public static void main (String[] args) {
		
		DecimalFormat df2 = new DecimalFormat("#.##");
		Scanner sc= new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.nextLine();
		
		double F = sc.nextDouble();
		sc.nextLine();
		
		
		Vehicle [] vehicleArray = new Vehicle[N];
		Double [] tripPriceArray = new Double [N];
		
		for (int i = 0; i < vehicleArray.length; i++) {
			
			String line = sc.nextLine();
			
			String [] arg = line.split(", ");
			
			if(arg.length == 6) {
				vehicleArray[i] = new Vehicle(arg[0], arg[1], Integer.parseInt(arg[2]), Double.parseDouble(arg[3]), Integer.parseInt(arg[4]), GetUniqueVehicleLicenceNumber(i));
			} else if(arg[6].matches(".*\\d.*") && arg[7] == null) {
				vehicleArray[i] = new Vehicle(arg[0], arg[1], Integer.parseInt(arg[2]), Double.parseDouble(arg[3]), Integer.parseInt(arg[4]), GetUniqueVehicleLicenceNumber(i), Integer.parseInt(arg[6]));
			} else if(arg[6].matches("[\\s]+")) {
				vehicleArray[i] = new Vehicle(arg[0], arg[1], Integer.parseInt(arg[2]), Double.parseDouble(arg[3]), Integer.parseInt(arg[4]), GetUniqueVehicleLicenceNumber(i), arg[6]);
				} else vehicleArray[i] = new Vehicle(arg[0], arg[1], Integer.parseInt(arg[2]), Double.parseDouble(arg[3]), Integer.parseInt(arg[4]), GetUniqueVehicleLicenceNumber(i), Integer.parseInt(arg[6]), arg[7]);
		
			tripPriceArray[i] = vehicleArray[i].calculateTripPrice(F, Double.valueOf(arg[5]));
		}
		
	
		
		for (int i = 0; i < vehicleArray.length; i++) {
			System.out.println(vehicleArray[i].licenseNo + " - " + vehicleArray[i].model + ", " + vehicleArray[i].yearProduced + ", " + vehicleArray[i].color);
			System.out.println("Insurance cost: " + vehicleArray[i].getInsurancePrice() + " - Òravel cost: " + df2.format(tripPriceArray[i]));
		}
		
		sc.close();
	}
}

