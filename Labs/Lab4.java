
public class Lab4 {
	
	
	public static void main(String[] args) {
		int numbers[] = new int[100];
		int num=1;
	
		for(int i=0; i<100; i++) {
			numbers[i] = num++;
		}
	
		for(int j=0; j<100; j++) {
			System.out.print(numbers[j] + " ");
		}
		
		int evenSum = 0;
		int oddSum = 0;
		
		int k = 0;
		while(k < 100) {
			if(numbers[k]%2 == 0) {
				evenSum = evenSum + numbers[k];
			}else {
				oddSum = oddSum + numbers[k];
			}
			
			k++;
		}
		
		System.out.println("\nThe sum of evens should be: " + evenSum);
		System.out.println("The sum of odds should be: " + oddSum);
	}
	
	
}
