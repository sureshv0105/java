package arrays;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

	public static void main(String arg[]){
		
		System.out.println(anagram("Clint Eastwood", "Old West Action"));
		
		System.out.println(anagram("god", "dog"));
		
		System.out.println(anagram("Client Eastwood", "Old West Action"));
	}
	
	private static boolean anagram(String s1, String s2){
				
		s1 = s1.replace(" ", "");
		s1 = s1.toLowerCase();
		
		s2 = s2.replace(" ", "");
		s2 = s2.toLowerCase();
		
		if(s1.length() != s2.length()){
			return false;
		}
		
		Map<Character, Integer> allChars = new HashMap<Character, Integer>();
		
		char[] s1Chars = s1.toCharArray();
		
		for(char ch : s1Chars){
			if(allChars.containsKey(ch)){
				Integer newValue = allChars.get(ch);
				newValue = newValue + 1;
				allChars.put(ch, newValue);
			}else{
				allChars.put(ch, new Integer(1));
			}
		}
		
		char[] s2Chars = s2.toCharArray();
		
		for(char ch : s2Chars){
			if(allChars.containsKey(ch)){
				Integer newValue = allChars.get(ch);
				newValue = newValue - 1;
				if(newValue == 0){
					allChars.remove(ch);
				}else{
					allChars.put(ch, newValue);
				}				
			}else{
				allChars.put(ch, new Integer(1));
			}
		}		
		
		//System.out.println("all chars: " + allChars);
		
		if(!allChars.isEmpty()){
			return false;
		}
		
		/*for(char ch : allChars.keySet()){
			Integer count = allChars.get(ch);
			if(count != 0){
				return false;
			}
		}*/
		
		return true;
	}
}
