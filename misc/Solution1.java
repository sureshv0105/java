package misc;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int noOfInputs = sc.nextInt();
        sc.nextLine();
        Set inputSet = new HashSet();
        List<Integer> printList = new ArrayList<Integer>();
        for(int i=0;i<noOfInputs;i++){
            String name = sc.next() + sc.next();
            if(sc.hasNext()){
                sc.nextLine();
            } 
            inputSet.add(name);          
            printList.add(inputSet.size());
        }
        sc.close();
        for(Integer i : printList)
        	System.out.println(i);
    }
}