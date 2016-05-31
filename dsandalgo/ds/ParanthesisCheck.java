package dsandalgo.ds;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ParanthesisCheck {
	private static final Map<Character, Character> matchingParenMap = new HashMap<Character, Character>();
	private static final Set<Character> openingParenSet = new HashSet<Character>();
	
	static{
		matchingParenMap.put('}', '{');
		matchingParenMap.put(']', '[');
		matchingParenMap.put(')', '(');
		openingParenSet.addAll(matchingParenMap.values());
	}
	
	public static void main(String arg[]){
		String goodInput = "{ABC}(CD{EF}GH){IJ}";
		boolean result = hasMatchingParens(goodInput);
		System.out.println("Expected result is true: actual result is " + result);

		String badInput = "{ABC}CD{EF}GH{IJ}}";
		result = hasMatchingParens(badInput);
		System.out.println("Expected result is false: actual result is " + result);

	}
	
	public static boolean hasMatchingParens(String input){
		try{
			Stack<Character> parenStack = new Stack<Character>();
			for(int i=0;i<input.length();i++){
				Character ch = input.charAt(i);
				if(openingParenSet.contains(ch)){
					parenStack.push(ch);
				}
				
				if(matchingParenMap.containsKey(ch)){
					Character lastParen = parenStack.pop();
					if(!lastParen.equals(matchingParenMap.get(ch))){
						return false;
					}
				}
			}
			return parenStack.isEmpty();
		}
		catch(Exception e){
			System.out.println("Stack exception " + e);
		}
		return false;
	}
}
