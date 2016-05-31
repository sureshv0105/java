package dsandalgo.algo.sort;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String arg[]) {
		int array[] = { 4, 2, 5, 6, 10, 3, 1, 6 };
		sort(array);
		System.out.println(Arrays.toString(array));
	}

	public static void sort(int array[]) {
		int tmp = 0;
		for (int itr = 0; itr < array.length; itr++) {
			for (int j = itr; j < array.length-1; j++) {
				tmp = array[itr];
				if (array[j+1] < array[itr]) {
					array[itr] = array[j+1];
					array[j+1] = tmp;
				}
				System.out.println("itr = " + itr + " j=" + j+ Arrays.toString(array));
			}
		}
	}
}