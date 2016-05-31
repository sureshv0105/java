package arrays;

import java.util.Scanner;



public class LoopSolution {

	public static void main(String args[]) throws Exception{		
		Scanner scanner = new Scanner(System.in);
		
		//int a = Integer.parseInt(args[0]);
		//int b = Integer.parseInt(args[1]);
		//int n = Integer.parseInt(args[2]);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int n = scanner.nextInt();
		generateSeries(a,b,n);
	}
	
	private static void generateSeries(int a, int b, int n) throws Exception{
		checkConstraints(a, b, n);
		
		for(int count = 0; count < n; ++count) {
			int term = a;
			for(int incount = 0; incount < count; ++incount) {
				term = term + ((int)Math.pow(2, count)*b);				
			}
			System.out.println(count + 1 + " term = " + term);
	    }
	}
	
	private static void checkConstraints(int a, int b, int n) throws Exception{
		if ((a<0 || a>50) || (b<0 || b>50) || (n<1 || n>15)){
			System.out.println("Bad input \n 0<=a,b<=50 \n 1<=n<=15");			
		}
	}
}
