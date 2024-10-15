import java.util.Scanner;

class Test1{
	 public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);	 	
		 	System.out.print("");
		 		int width = sc.nextInt();
		 
		 	System.out.printf("");
		 		int length = sc.nextInt();
		 
		 		for(int i = 0; i< length; i++) {
		 			for(int j = 0; j< width; j++) {
		 				System.out.print("*");
		 			}
		 				System.out.println();		 
		 } 
		
	}
}
