/**
 * Program name: Selection Sort
 * The "Selection Sort Algorithm" is one of the most intuitive algorithm 
 * that was invented for sorting a list of elements in ascending or 
 * descending order. This algorithm is in general more quicker than
 * the "Bubble Sort Algorithm".
 * 
 * @author Gonzales Cenelia
 * website: www.ai-search.4t.com
 */

public class SelectionSort {

	// sorts an array of integers by using the
	// selection sort algorithm
	static void sort(int[] array) {
		for(int i = 0; i < array.length - 1; ++i) {
			int maxPos = findMax(array, array.length - i);
			swap(array, maxPos, array.length - 1 - i);
		}
	}
	
	// finds the position of the greatest 
	// element in an array
	static int findMax(int[] array, int lim) {
		int max = array[0], maxPos = 0;
		for(int i = 0; i < lim; ++i) {
			if(array[i] > max) {
				max = array[i];
				maxPos = i;
			}
		}
		return maxPos;
	}
	
	static void swap(int[] array, int pos1, int pos2) {
		int temp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = temp;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ArrayOfInts = {79, 45, 69, 158, 12, 93, 127, 457, 57, 71};
		
		System.out.println("Array before sorting:");
		for(int i = 0; i < ArrayOfInts.length; ++i) {
			System.out.println("    ArrayOfInts[" + i + "] = " + ArrayOfInts[i]);
		}
		sort(ArrayOfInts);
		
		System.out.println("\nArray after sorting:");
		for(int i = 0; i < ArrayOfInts.length; ++i) {
			System.out.println("    ArrayOfInts[" + i + "] = " + ArrayOfInts[i]);
		}
	}
}
