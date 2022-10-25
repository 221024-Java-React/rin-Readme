public class Lab2{
	public int add(int a, int b){
		return a + b;
	}

	public int sub(int a, int b){
		return a - b;
	}

	public double multiply(double a, double b){
		return a*b;
	}

	public double divide(double a, double b){
		return a/b;
	}

	public static void main(String[] args){
		Lab2 lab2 = new Lab2();

		System.out.println("add method: " + lab2.add(5,2));
		System.out.println("sub method: " + lab2.sub(3,4));
		System.out.println("multiply method: " + lab2.multiply(8,3));
		System.out.println("divide method: " + lab2.divide(5,2));
	}
}
