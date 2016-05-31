package dsandalgo.ds;

import java.util.Scanner;
import java.util.Stack;

public class MinimumStack {
	
	private static final MinStack stack = new MinStack();
	
    public static void main(String[] args) throws Exception{
        Scanner sc= new Scanner(System.in);
        String stackInput = sc.nextLine();        

        System.out.println("String: " + stackInput);
        
        String[] sStrs = stackInput.split(",");
        
        for (String str: sStrs){
        	stack.push(new Integer(str));
        }
        
        //lets print and check here
        for (String str: sStrs){
        	int min = stack.getMinimum();
        	System.out.println(stack.pop() + "min is " + min);
        }
    }   
	
}

class MinStack{
	private static final Stack<Integer> actualStack = new Stack<Integer>();
	private static final Stack<Integer> minimumStack = new Stack<Integer>();
	
	
	public void push(int data){
		int min = data;
		if(!minimumStack.isEmpty()){
			if(min > minimumStack.peek()){
				min = minimumStack.peek();
			}
		}
		actualStack.push(data);
		minimumStack.push(min);		
	}
	
	public int pop(){
		minimumStack.pop();
		return actualStack.pop();
	}
	
	public int getMinimum() throws Exception{
		if(!minimumStack.isEmpty()){
			return minimumStack.peek();
		}
		return 0;
	}
}