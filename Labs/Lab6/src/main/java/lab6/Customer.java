package lab6;

//import java.util.ArrayList;

public abstract class Customer {
	protected String name;
	protected double balance;
	protected String item;
	protected double cartCost;
	protected double itemCost[];
	protected int i=0;
	
	public Customer(String name, double balance, String item, double cartCost) {
		this.name = name;
		this.balance = balance;
		this.item = item;
		this.cartCost = cartCost;
	}
	
	public void addToCart(String item, double cost) {
		this.itemCost[i] = cost;
		this.i++;
		this.cartCost = this.cartCost + cost;
		this.item = this.item + item + " ";
	}
	
	public abstract void buy();
	
}