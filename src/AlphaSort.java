/**
 * Program Name: AlphaSort
 * These program uses the "Bubble Sort Algorithm" to sort an array of strings
 * in alphabetical order. The "Bubble Sort Algorithm" is not the "quickest algorithm"
 * that can be use to sort a list of elements but it's mechanism is among the most
 * simple to understand.
 * 
 * @author Gonzales Cenelia
 * website: www.ai-search.4t.com
 */



public class AlphaSort {
	
	// this function uses the "Bubble Sort Algorithm"
	// to sort an array of strings in ascending order
	static void alphaSort(String[] array) {
		for(int i = array.length - 1; i > 0; --i) {
			boolean bSwaped = false;
			for(int j = 0; j < i; ++j) {
				if(array[j].compareTo(array[j + 1]) > 0) {
					swap(array, j, j + 1);
					bSwaped = true;
				}
			}
			if(!bSwaped) {
				break;
			}
		}
	}
	
	static void swap(String[] array, int pos1, int pos2) {
		String temp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ArrayOfString = {
				"Computer", "Artificial", "Real", "Virtual", "Smart", "Alive"
		};
		
		System.out.println("Alphabetical Ordering Program\n");
		System.out.println("Strings before ordering:");
		for(int i = 0; i < ArrayOfString.length; ++i) {
			System.out.println("    ArrayOfString[" + i + "] = " + ArrayOfString[i]);
		}
		System.out.println("\nStrings before ordering:");
		alphaSort(ArrayOfString);
		for(int i = 0; i < ArrayOfString.length; ++i) {
			System.out.println("    ArrayOfString[" + i + "] = " + ArrayOfString[i]);
		}
	}
}
