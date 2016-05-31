package dsandalgo.algo.sort;

import java.util.Arrays;

public class InsertSortPartial1 {

	public static void main(String[] args){
		int[] arrayPlusE = new int[]{9,4,3,5,6,10,1,2,8,7};
		
		
		int e = arrayPlusE[arrayPlusE.length - 1];
		int currentElement = 0;
		System.out.println("Unsorted " + Arrays.toString(arrayPlusE));
		for(int i = arrayPlusE.length-2; i>-1;i--){
			currentElement =  arrayPlusE[i];
			//System.out.println("currentElement " + currentElement);
			if(currentElement > e){
				arrayPlusE[i + 1] = currentElement;
				System.out.println("Sorted " + Arrays.toString(arrayPlusE));
			}else{
				arrayPlusE[i + 1] = e;				
				System.out.println("Sorted " + Arrays.toString(arrayPlusE));
				break;
			}
		}
		if(currentElement > e){
			arrayPlusE[0] = e;
		}
		System.out.println("Sorted " + Arrays.toString(arrayPlusE));
	}
}
