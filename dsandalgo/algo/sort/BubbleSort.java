package dsandalgo.algo.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String arg[]){
		int[] array = {9,4,3,5,6,10,1,2,8,7};
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	private static void bubbleSort(int[] array){
		int noOfSwaps = 0;
		for(int itr=0;itr<array.length;itr++){
			int tmp = 0;
			boolean swapped = false;
			for(int j=0;j<array.length-1-itr;j++){
				if(array[j] > array[j+1]){
					//swap
					tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
					swapped = true;
					noOfSwaps++;
				}
			}
			System.out.println("Iteration is " + itr + "; list is  " + Arrays.toString(array));
			if(!swapped){				
				break;
			}
		}
		System.out.println("No of Swaps: " + noOfSwaps);
	}
}
