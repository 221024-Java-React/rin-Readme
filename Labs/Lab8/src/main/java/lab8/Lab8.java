package lab8;

public class Lab8 {
	
	private static String st2="";
	
	public Lab8() {
		
	}
	
	public Lab8(String st2) {
		super();
		this.st2 = st2;
	}


	public static void main(String[] args) {
		Lab8 l8 = new Lab8();
		
		System.out.println(l8.reverse("rinchheng"));
	}
	
	public String reverse(String str1) {
		try {
		
			for(int i=str1.length()-1; i>-1; i--) {
			
				st2 = (new StringBuffer(st2)).append(str1.charAt(i)).toString();
			}
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		
		return st2;
	}
	
	

}
