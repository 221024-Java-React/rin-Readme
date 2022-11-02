package lab6;

//import java.util.Scanner;

public class Lab6{
	
	public static void main(String[] args) {
		
		PremiumCustomer c1 = new PremiumCustomer("Tom", 5.20, "banana ns4", 5.00, 12345, 2025);
		
		System.out.println(c1.getBalance());
		System.out.println(c1.getCartCost());
		System.out.println(c1.getName());
		System.out.println(c1.getVipCard());
		System.out.println(c1.getYears());
		
		System.out.println(c1.discountPrice(15.50));
		
		System.out.println("Hello World");
	}

}