import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	
	
	public static int[] getRandomizedArray(int size) {
		
		int[] randomNumbers = new int[size];
		
		for(int i=0; i<size; i++) {
			randomNumbers[i] = (int) (size*Math.random());
		}
		
		return randomNumbers;
	}
	
	
	
	
	/**
	 * Pick the index of the pivot random index in the array within the specified range.
	 */
	public static int returnPivotIndexRandomNumber(int low, int high) {
		int sizeOfRange = high - low + 1;
		return new Random().nextInt(sizeOfRange) + low;
	}
	
	
	
	
	
	
	public static int[] quickSort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
		return arr;
	}
	
	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = returnPivotIndexRandomNumber(low, high); //pick pivot as random number
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				swap(arr, i, j);
				i++;
				j--;
			}
		}
		
		int partitionIndex1 = i-1;
		int partitionIndex2 = j+1;
 
		// recursively sort two sub parts
	    quickSort(arr, low, j);
	    quickSort(arr, i, high);
	}
	
	/*
	public static int[] quickSortBackup(int[] arr) {
		quickSortBackup(arr, 0, arr.length-1);
		return arr;
	}
	
	public static void quickSortBackup(int[] input, int low, int high) {
		if (input == null || input.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int pivotIndex = returnPivotIndexRandomNumber(low, high); //pick pivot as random number
		int pivotValue = input[pivotIndex];
 
		// make left < pivot and right > pivot
		int leftIndex = low;
		int rightIndex = high;
		while (leftIndex <= rightIndex) {
			while (input[leftIndex] < pivotValue) {
				leftIndex++;
			}
 
			while (input[rightIndex] > pivotValue) {
				rightIndex--;
			}
 
			if (leftIndex <= rightIndex) {
				swap(input, leftIndex, rightIndex);
				leftIndex++;
				rightIndex--;
			}
		}
 
		// recursively sort two sub parts
			quickSort(input, low, rightIndex);
			quickSort(input, leftIndex, high);
	}
	*/

	
	/**
	 * Swap two elements in an array given their indices
	 * @param input
	 * @param index1
	 * @param index2
	 */
	public static void swap(int[] input, int index1, int index2) {
		int temp = input[index1];
		input[index1] = input[index2];
		input[index2] = temp;
	}
	
	
	public static void printOutArray(int[] input, String arrayName) {
		System.out.println();
		System.out.println(arrayName);
		for(int i: input) {
			System.out.println(i);
		}
	}
	
	public static boolean isSorted(int[] input) {
		for(int i=1;i<input.length;i++) {
			if(input[i]-input[i-1] < 0) {
				return false;
			}	
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		int[] sortedNumbers;
		
		//int[] randomizedArray = getRandomizedArray(10);
		
		int[] randomizedArray = new int[]{8, 4, 0, 1, 0, 9, 0, 3, 3, 3};
		
		//Quick Sort:
		int[] arrayToSort = Arrays.copyOf(randomizedArray, randomizedArray.length);
		
		Long startTime = System.currentTimeMillis();
		sortedNumbers = quickSort(arrayToSort);
		Long endTime = System.currentTimeMillis();
		
		
		//printOutArray(sortedNumbers, "Quick Sort:");
		if(isSorted(sortedNumbers)) {
			System.out.println("Array is sorted!!!");
		} else {
			System.out.println("Array is NOT sorted!!!");
		}
		
		System.out.println("Time to sort (ms): " + (endTime - startTime));
	}
}
