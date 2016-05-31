package dsandalgo.algo;

import java.util.ArrayList;
import java.util.List;


public class Panagram{
	
	private static final String ALPHABETS = "abcefghijklmnopqrstuvwxyz";
	
	public static void main(String arg[]){
		//Scanner sc = new Scanner(System.in);
		//String inputString = sc.nextLine();
		String input1 = "Pack my box with five dozen liquor";
		String input2 = "The quick brown fox jumps over the lazy dog";
		String input3 = "The five boxing wizards jump quick";
		checkPanagram(input1);
		checkPanagram(input2);
		checkPanagram(input3);
	}
	
	private static void checkPanagram(String inputString){
		String lwrCaseInput = inputString.toLowerCase();
		boolean allAlphabetsPresent = true;
		List<Character> missingAlphabets = new ArrayList<Character>();
		
		for(int i=0;i<ALPHABETS.length();i++){
			char aCh = ALPHABETS.charAt(i);
			if(lwrCaseInput.indexOf(aCh) == -1){
				allAlphabetsPresent = false;
				missingAlphabets.add(aCh);
			}			
		}
		System.out.println(inputString + " is " + ((allAlphabetsPresent == true) ? "a" : "not a") + " panagram" + 
									((missingAlphabets.size() == 0) ? "" : " ;Missing Alphabets: " + missingAlphabets.toString()) );
		//System.out.println("missin")
	}
}