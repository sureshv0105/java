package arrays;

import java.util.ArrayList;
import java.util.List;

public class ArrayPairSum {
	
	private static int[] array1 = {1,2,4,3,1,2,3};
	
	private static int[] sarray1 = {7,1,1,2,2,3,3,4};
	
	public static void main(String arg[]){
		int count = countUniquePairs(sarray1, 4);
		
		System.out.println("Count is" + count);
	}
	

	private static int countUniquePairs(int[] array, int sum){
		List<Pair> pairs = new ArrayList<Pair>();
		
		List<Integer> arrayCopy = new ArrayList<Integer>();
		
		for (int n : array){
			arrayCopy.add(n);
		}
		
		for(int i=0;i<array.length;i++){
						
			System.out.println(arrayCopy);
			
			int elementToRemove = -1;
			if(arrayCopy.isEmpty() || arrayCopy.size()<2){
				break;
			}
			
			int firstElement = arrayCopy.get(0);
			for(int j=1;j<arrayCopy.size()-1;j++){
				int s = firstElement + arrayCopy.get(j);
				//System.out.println("firstElement=" + firstElement + "; arrayCopy.get(j)=" + arrayCopy.get(j) + "; s=" + s);
				if(s == sum){
					Pair pair = new Pair(array[i], arrayCopy.get(j));
					pairs.add(pair);
					elementToRemove = j;
					System.out.println("Pair found: " + array[i] + "," + arrayCopy.get(j) + ": index=" + j);
					break;
				}				
			}
			
			if(elementToRemove != -1){
				arrayCopy.remove(elementToRemove);
			}
			
			if(!arrayCopy.isEmpty())
				arrayCopy.remove(0);				

		}
		
		
		return pairs.size();
	}
}

class Pair{
	private int element1;
	private int element2;
	
	Pair(int e1, int e2){
		this.element1 = e1;
		this.element2 = e2;
	}
	
	public int getElement1(){return element1;}
	public int getElement2(){return element2;}
	
	public String toString(){
		return "(" + element1 + ", " + element2 + ")";
	}
	
	@Override
	public boolean equals(Object p1){
		return (((Pair)p1).getElement1()) == element1 && (((Pair)p1).getElement2()) == element2;
	}
	
	@Override
	public int hashCode(){
		return element1 + element2;
	}
}
