package lab9;

import java.util.ArrayList;
import java.util.Arrays;

public class Lab9 {
	
	private char [] c1;
	private ArrayList<Integer> bonus = new ArrayList<Integer>();
	
	public ArrayList<Integer> calculateBonuses(char [] c1) {
		try {
			for(int i=0; i < c1.length; i++) {
				char ch1 = c1[i];
				switch(ch1) {
					case 'A' : bonus.add(5000);
						break;
					case 'B' : bonus.add(2500);
						break;
					case 'C' : bonus.add(1000);
						break;
					case 'D' : bonus.add(500);
						break;
					case 'F' : bonus.add(0);
						break;
					default:
						break;
				}	
			}
		}catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		return bonus;
	}

	public static void main(String[] args) {
		Lab9 l9 = new Lab9();
		char[] c = {'A', 'A', 'C', 'F'};
		
		l9.calculateBonuses(c);
		System.out.println(l9.toString());
	}

	@Override
	public String toString() {
		return "Lab9 [c1=" + Arrays.toString(c1) + ", bonus=" + bonus + "]";
	}
}
