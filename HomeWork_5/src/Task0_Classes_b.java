import java.util.Calendar;

       class  Car{
		String brand;
		String model;
		int enginePower;
		int years;
		String category;
		int tax;
		
		
		public String insuranceCategory(int years) {
			
			int Yearofmanufacture= Calendar.getInstance().get(Calendar.YEAR)- years ;
			
			if (Yearofmanufacture<8) {
				this.category= "Категория 1";
				}
			if (Yearofmanufacture>=8 && Yearofmanufacture<15 ) {
				this.category= "Категория 2";
						}
			if (Yearofmanufacture>=15 && Yearofmanufacture <25) {
				this.category= "Категория 3";
						}
			if (Yearofmanufacture >25) {
				this.category= "Категория 4";
						}
			
			
			return category ;
			}
		
		public double tax() {
			double tax=0;
			
			switch (category) {
			case  "Категория 1":{
				tax=150 ;
			}
			case  "Категория 2":{
				tax=200  ;
			}
			case  "Категория 3":{
				tax=300  ;
			}
			case  "Категория 4":{
				tax=500  ;
			}
			break;
			
			}
			if (enginePower<80) {
				tax= tax+(tax*0.2);
				
			}
			if (enginePower>140) {
				tax= tax+(tax*0.45);
				
			}
			
			return tax;
			}
		
		}
       public class Task0_Classes_b {
    	   
    	   public static void main(String[] args) {
    		   
    		   Car opel= new Car();
    		   opel.years=12;
    		   opel.model="Corsa";
    		   opel.enginePower=75;
    		   opel.brand= "Opel";
    		   
    		   
    		   
    		   
    		   System.out.println(opel.insuranceCategory(1992));
    		   System.out.println(opel.tax());
    		   
			
		}
	}



