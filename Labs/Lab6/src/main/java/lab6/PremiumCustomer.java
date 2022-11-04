package lab6;

//import java.util.Scanner;

public class PremiumCustomer extends Customer implements Premium {
	private int vipCard;
	private int years;
	
	public PremiumCustomer(String name, double balance, String item, double cartCost, int vipCard, int years) {
		super(name, balance, item, cartCost);
		this.vipCard = vipCard;
		this.years = years;
	}
	
	public double discountPrice(double startingPrice) {
		double salePrice = startingPrice - (startingPrice*.15);
		return salePrice;
	}

	@Override
	public void buy() {
		// TODO Auto-generated method stub
		boolean remove=false;
		String [] itemArray = super.item.split(" ");
		
		do {
			for(int i=0; i<itemArray.length; i++) {
				if(itemArray[i] == item) { //not sure about variable item here
					itemArray[i] = null;
					super.itemCost[i]=0;
				}
			}	
			
			for(int i=0; i<itemArray.length; i++) {
				super.cartCost = super.cartCost + super.itemCost[i];
			}
			
			for(int i=0; i<itemArray.length; i++) {
				super.item = super.item + itemArray[i] + " ";
			}
			
			super.balance = super.balance - super.cartCost;
	
		}while(remove!=false);
		
		super.balance = discountPrice(super.balance);
	}

	public int getVipCard() {
		return vipCard;
	}

	public void setVipCard(int vipCard) {
		this.vipCard = vipCard;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}
	
	public String getName() {
		return super.name;
	}

	public void setName(String name) {
		super.name = name;
	}
	
	public double getBalance() {
		return super.balance;
	}

	public void setBalance(double balance) {
		super.balance = balance;
	}
	
	public double getCartCost() {
		return super.cartCost;
	}

	public void setCartCost(double cartCost) {
		super.cartCost = cartCost;
	}
}