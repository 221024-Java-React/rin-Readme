import java.util.Scanner;

public class Lab3{
	public String replaceAllSpaces(String s){
		
		String s2 = s.replace(" ", "-");

		return s2;
	}
	
	public boolean containsWord(String inputWord, String searchWord) {
		String inputString = inputWord.toLowerCase();
		String searchString = inputWord.toLowerCase();
		boolean flag;
		
		if(inputString.contains(searchString) == true) {
			flag = true;
		}else {
			flag = false;
		}
		
		return flag;
	}
	
	public String[] splitPhoneNumber(String phoneNumber) {
		String[] arrOfStr = phoneNumber.split("-");
		
		return arrOfStr;
	}

	public static void main(String[] args) {
		
		Lab3 l3 = new Lab3();
		
		System.out.println(l3.replaceAllSpaces("Hi my name is Rin"));
		
		
		String[] arrOfString = l3.splitPhoneNumber("231-321-322");
		for(String s: arrOfString) {
			System.out.println(s);
		}
		boolean word = l3.containsWord("Hi My name is rin Chheng", "rin");
		System.out.println(word);
	}

}
