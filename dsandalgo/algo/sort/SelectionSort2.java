package dsandalgo.algo.sort;

import java.util.Arrays;

public class SelectionSort2 {
	
	
	public static void main(String arg[]){
		int[] array = {9,4,3,5,6,10,1,2,8,7};
		selectionSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	private static void selectionSort(int[] array){
		int tmp = 0;
		for(int itr=0;itr<array.length;itr++){
			
			for(int j=itr;j<array.length-1;j++){
				if(array[itr] > array[j+1]){
					//swap elements
					tmp = array[itr];
					array[itr] = array[j+1];
					array[j+1] = tmp;
				}
			}			
		}		
	}
}
