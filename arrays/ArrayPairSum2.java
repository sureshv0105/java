package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayPairSum2 {

	private static int[] array1 = {1,2,4,3,1,2,3};
	
	private static int[] sarray1 = {7,1,2,4,3,3};
	
	public static void main(String arg[]){
		int count = countUniquePairs(sarray1, 4);
		
		System.out.println("Count is" + count);
	}
	

	private static int countUniquePairs(int[] array, int sum){
		List<Integer> seenNums = new ArrayList<Integer>();
		Set<Pair> outputPairs = new HashSet<Pair>();
		
		if(array.length < 2){
			return 0;
		}
		
		for(int num: array) {
			
			int target = sum - num;
			
			//Add it to set if target hasn't been seen
			if(!seenNums.contains(target)){
				seenNums.add(num);
			}else{
				outputPairs.add(new Pair(num, target));
			}
			
		}
		System.out.println(outputPairs);
		
		return outputPairs.size();
	}
	
}
