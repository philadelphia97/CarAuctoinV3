package carauctoinv3;

import javax.swing.JOptionPane;



public class CarAuctionV3 {
	
	static String input = "";
	static int selection = 0;
	static Car [] car = new Car[100];
	static int carCount = 0;
	static String searchVIN = "";
	static double totalMileage = 0;
	static int oldestCar = 0;

	public static void main(String[] args) {
		
		javax.swing.JOptionPane.showMessageDialog(null, "WELCOME TO THE CAR5 ACUTIONEER 3000!!");
		while(selection != 10) {
			menu();
		switch(selection) {
		case 1 : 
		car[carCount] = new Car();
		car[carCount].getInfo();
		car[carCount].report();
		carCount++;
		break;
		case 2 : 
		displayAllCars();
		break;
		case 3:
		searchVIN();
		case 4 : totalMileage();
		break;
		case 5 : oldestCar();
		break;
		}
		}//end while
		
		
	}//end main method
	
	public static void menu() {
		input = JOptionPane.showInputDialog("to enter a new car select - 1 " + "\n" +
											"to displasy all cars select - 2 " + "\n" +
											"to search for a car - 3 " + "\n" + 
											"to exit the program select - 4 " );
		selection = Integer.parseInt(input);
	}//end menu
	
	public static void displayAllCars() {
		for(int i = 0; i < carCount; i++) {
			car[i].report();
		}
	}//end display all cars

	public static void searchVIN() {
		input = JOptionPane.showInputDialog("Please Enter the VI of the Car you would like to search !!! :: ");
		searchVIN = input;
		for (int i = 0; i < carCount; i ++) {
			if (car[i].VIN.equals(searchVIN)) {
				car[i].report();
			} else if (!car[i].VIN.equals(searchVIN)) {
				JOptionPane.showMessageDialog(null, "that car Don't exist");
			} else {
				i++;
			}
		}
		
	}//end search VIN
	
	public static void totalMileage() {
		//for the total mileage we'll have to add up ever.miles and say it the total mileage
		for (int i = 0; i <  carCount; i++) {
			totalMileage = car[i].mileage + totalMileage;
		}
		JOptionPane.showMessageDialog(null, "total mileage of all cars : " + totalMileage);

	}
	
	public static void oldestCar() {
		if (carCount == 0) {
		JOptionPane.showMessageDialog(null, "There are no cars in car count... please add a car");
		} else {
		oldestCar = car[0].year;
		for(int i = 0; i < carCount; i++) {
			if (car[i].year < oldestCar) {
				oldestCar = car[i].year;
			}//end if
		}//end for loop
		JOptionPane.showMessageDialog(null, "The oldest Car " + oldestCar);
	}//end oldest car
	}
	
	
	

}//end main class

class Car{
	//declarations
	static String input = "";
	
	
	String make;
	String model;
	String VIN;
	int year;
	double price;
	double mileage;
	
	Car(){
		make = "";
		model = "";
		VIN = "";
		year = 0;
		price = 0;
		mileage = 0;
		
	}//end constructor w/o arguments
	
	Car(String make,String model,String VIN,int year,double price,double mileage){
		this.make = make;
		this.model = model;
		this.VIN = VIN;
		this.year = year;
		this.price  = price;
		this.mileage = mileage;
	}
	
	void getInfo() {
		input = JOptionPane.showInputDialog("please enter the make of your car : ");
		make = input;
		input = JOptionPane.showInputDialog("please enter the model of your car : ");
		model = input;
		input = JOptionPane.showInputDialog("please enter the VIN of your car : ");
		VIN = input;
		input = JOptionPane.showInputDialog("please enter the year of your car : ");
		year =Integer.parseInt(input);
		input = JOptionPane.showInputDialog("please enter the price of your car : ");
		price = Double.parseDouble(input);
		input = JOptionPane.showInputDialog("please enter the mileage on your car : ");
		mileage = Double.parseDouble(input);
		
	}//end get info
	
	void report() {
		JOptionPane.showMessageDialog(null, "Make : " + make  + "\n" +
									   "Model : " + model  + "\n" + 
									   "VIN : " + VIN  + "\n" + 
									   "Year : " + year  + "\n" + 
									   "Price : " + price  + "\n" + 
									   "Mileage : " + mileage);
	}

	
	
	
	
	
	
}//end car class