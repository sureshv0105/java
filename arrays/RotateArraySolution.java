package arrays;

public class RotateArraySolution {


	public static void main(String[] args){
		int noOfCharsToRotate = 6;
		String STR_TO_ROTATE = "SantaMonica";
		int srcStringLength = STR_TO_ROTATE.length();
		char[] chrArray = STR_TO_ROTATE.toCharArray();
		char[] tailingChars = new char[noOfCharsToRotate];
		char[] leadingChars = new char[srcStringLength - noOfCharsToRotate];
		char[] destArray = new char[srcStringLength];
		
		//noOfCharsToRotate = STR_TO_ROTATE.length()%noOfCharsToRotate;
		/*for(int i=CHARS_TO_ROTATE; i>-1; i--){
			
		}*/
		  
		System.arraycopy(chrArray, STR_TO_ROTATE.length()-noOfCharsToRotate, tailingChars, 0, noOfCharsToRotate);
		System.out.println(new String(tailingChars));
		
		
		System.arraycopy(chrArray, 0, leadingChars, 0, leadingChars.length);
		System.out.println(new String(leadingChars));
		
		System.arraycopy(tailingChars, 0, destArray, 0, tailingChars.length);
		System.arraycopy(leadingChars, 0, destArray, tailingChars.length, leadingChars.length);
		System.out.println(new String(destArray));
	}
	
}
