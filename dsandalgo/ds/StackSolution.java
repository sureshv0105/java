package dsandalgo.ds;

import java.util.*;
class StackSolution{
   
   public static void main(String []argh)
   {
      Scanner sc = new Scanner(System.in);
      Map<Character, Character> matchingParenMap = new HashMap<Character, Character>();
      matchingParenMap.put(')','(');
      matchingParenMap.put('}','{');
      matchingParenMap.put(']','[');
      Set<Character> openParenSet = new HashSet<Character>();
      openParenSet.addAll(matchingParenMap.values());
       
      while (sc.hasNext()) {
         Stack<Character> openParenStack = new Stack<Character>();
         String input=sc.nextLine();
         /*if(sc.hasNext())
            sc.nextLine();*/
         boolean result = true;
         for(int i=0;i<input.length();i++){
             Character c = input.charAt(i);
             
             if(openParenSet.contains(c)){
                 openParenStack.push(c);
             }
             
             if(matchingParenMap.containsKey(c)){
                Character lastParen = null;
                try{
                	lastParen = openParenStack.pop();
                }catch(EmptyStackException e){
                	result = false;
                }
                                 
                if(lastParen!= null && !lastParen.equals(matchingParenMap.get(c))){
					result = false;
				}
             }             
         }
         if(!openParenStack.isEmpty()){
             result = false;
         }
         System.out.println(result) ;          
      }    
   }
}
