package dsandalgo.algo.sort;

import java.util.Arrays;

public class InsertSort {
	
	public static void main(String arg[]){
		int[] array = {9,4,3,5,6,10,1,2,8,7};
		insertSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	private static void insertSort(int[] array){
		int noOfSwaps = 0;
		for(int itr=0;itr<array.length;itr++){
			int tmp = 0;
			for(int j = itr;j>0;j--){
				if(array[j] < array[j-1]){
					//swap
					tmp = array[j];
					array[j] = array[j-1];
					array[j-1] = tmp;
					noOfSwaps++;
				}else{
					break;
				}
			}
			System.out.println("Iteration: " + itr + "; array is: " + Arrays.toString(array));
		}
		System.out.println("No of Swaps: " + noOfSwaps);
	}

}
