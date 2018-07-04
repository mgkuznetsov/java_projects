package Anagrams;
import java.util.Arrays;
import java.util.Random;

public class SortImplementations {
	
	
	public static int[] getRandomizedArray(int size) {
		
		int[] randomNumbers = new int[size];
		
		for(int i=0; i<size; i++) {
			randomNumbers[i] = (int) (size*Math.random());
		}
		
		return randomNumbers;
	}
	
	/**
	 * Bubble sort: 
	 * 1. We iterate through the array, each time we swap adjacent numbers
	 * 2. We keep on iterating until we complete an iteration where we don't need to swap - that is how
	 *    we know that the array is sorted.
	 * Notice that after each pass, the last element in the array is the greatest element, so we don't need to evaluate the
	 * last element of a pass. For each iteration through the array, at least one element is sorted. So in the worst case,
	 * we need to do (N + (N-1) + ... + 1) = 0.5N(N+1) iterations so it's O(N^2) time.
	 * @param input
	 * @return
	 */
	public static int[] bubbleSort(int[] input) {
		boolean swap = false; //True we have an iteration through array where did not need to swap any elements
		
		for(int i=0; i<input.length; i++) {	
			for(int j=0; j<input.length-i-1; j++) {
				if(input[j]>input[j+1]) {
					swap=true; //Swap
					swap(input, j, j+1);										
				}
			}
			
			if(!swap) {
				break; //If we did not swap during an iteration, then we are done
			} else {
				swap = false; //reset the value
			}
		}
		
		return input;
	}
	
	/**
	 * Selection Sort:
	 * 1. Iterate over the array and for each iteration find the minimum element of the array and put it in the beginning.
	 * 2. Since the first element is always sorted, we need to only sort the last n-i elements of the array.
	 * @param input
	 * @return
	 */
	public static int[] selectionSort(int[] input) {
		int minIndex; //index of the minimum element
		for(int i=0; i<input.length; i++) {
			minIndex = i;
			for(int j=i+1; j<input.length; j++) {
				if(input[j] < input[minIndex]) {
					minIndex = j;
				}
			}
			//Swap first element with the smallest element
			swap(input, i, minIndex);
		}
		
		return input;
	}
	
	/**
	 * Insertion Sort:
	 * 1. Iterate over the array and for each iteration, we INSERT the ith element in the proper place with respect to the previous elements
	 * 2. We start with the second element of the array (i=1) since the first element has nothing to the left of it
	 * 3. If the ith element is greater than the previous elements, then we don't want to insert it into the previous elements because all the 
	 * previous elements will be less that its value. So we can stop the insertion for that iteration.
	 * @param input
	 * @return
	 */
	public static int[] insertionSort(int[] input) {
		int temp;
		
		for(int i=1; i<input.length; i++) {
			temp=input[i]; //the element that will be inserted somewhere to its left
			
						
			//Go to the left and shift all the elements that are larger than the ith element over to the right
			int j=i-1;
			while(j>=0 && temp < input[j]) {
				input[j+1]=input[j];
				j--;
			}
			
			input[j+1] = temp;
		}
		
		return input;
	}
	
	public static int[] mergeSort(int[] input) {
		
		//Base case - If input array has only one element then we return the input
		if(input.length == 1) {
			return input;
		}
		
		//Recursively perform merge sort on left and right sub-arrays:
		//Note: If input is odd, then the left sub array will be 1 less than right sub array
		int length = input.length;
		int midpoint = (int)Math.floor(0.5*input.length);
		
		int[] leftSubArray = mergeSort(Arrays.copyOfRange(input, 0, midpoint));
		int[] rightSubArray = mergeSort(Arrays.copyOfRange(input, midpoint, length));	
		
		
		//Merge sub arrays and return:
		//Note: both sub-arrays are sorted
		int[] returnArray = new int[length];
		int mergeIndex=0;
		int leftIndex = 0;
		int rightIndex = 0;
		
		while(leftIndex < leftSubArray.length && rightIndex < rightSubArray.length) {
			if(leftSubArray[leftIndex] < rightSubArray[rightIndex]) {
				returnArray[mergeIndex] = leftSubArray[leftIndex];
				leftIndex++;				
			} else {
				returnArray[mergeIndex] = rightSubArray[rightIndex];
				rightIndex++;
			}
			mergeIndex++;
		}
		
		//Merge remaining left sub-array if any:
		while(leftIndex < leftSubArray.length) {
			returnArray[mergeIndex] = leftSubArray[leftIndex];
			leftIndex++;
			mergeIndex++;
		}
		
		//Merge remaining right sub-array if any:
		while(rightIndex < rightSubArray.length) {
			returnArray[mergeIndex] = rightSubArray[rightIndex];
			rightIndex++;
			mergeIndex++;
		}
		
		return returnArray;	
	}
	
	
	/**
	 * Pick the index of the pivot random index in the array within the specified range.
	 */
	public static int returnPivotIndexRandomNumber(int low, int high) {
		int sizeOfRange = high - low + 1;
		return new Random().nextInt(sizeOfRange) + low;
	}
	
	/**
	 * NOTE: This method does not work!!
	 * 1. Select pivot
	 * 2. Puts all elements smaller than pivot to right of pivot and all elements larger than pivot to left of 
	 * pivot by swapping
	 * @param input
	 * @param low
	 * @param high
	 * @return
	 */
	public static int partition(int[] input, int low, int high) {
		int initialPivotIndex = returnPivotIndexRandomNumber(low, high); //Value of the pivot
		int pivotValue = input[initialPivotIndex];
		
		//If pivot is not at the initial value, then swap pivot with the first element of the array
		if(initialPivotIndex > low) {
			swap(input, low, initialPivotIndex);
		}		
		
		//Iterate through the array:
		int leftIndex = low+1; //pivot is the first value so no need to compare
		int rightIndex = high;
		
		mainloop:
		while(leftIndex < rightIndex) {
			//Move left index towards the right until we find element > pivot value
			while(input[leftIndex] < pivotValue) {
				leftIndex++;
				if(leftIndex == rightIndex) {
					break mainloop; //We have iterated the whole array
				}
			}
			
			//Move right index towards the left until we find element < pivot value
			while(input[rightIndex] > pivotValue) {
				rightIndex--;
				if(leftIndex == rightIndex) {
					break mainloop; //we have iterated the whole array
				}
			}
			
			swap(input, leftIndex, rightIndex); //Swap the elements of leftIndex and rightIndex
			System.out.println("afterSwap");
		}
		
		/*If leftIndex equals rightIndex then we need to put the pivot into the right place.
		 * (rightIndex-1) is the furthest to the right element that is less or equal to pivot
		 * Since we know that the pivot is in the first (low) location in the array, we swap elements
		 * in locations of (low) index and (rightIndex-1).
		 * The partition index will then be the location of rightIndex-1.
		 */
		int partitionIndex = rightIndex;
		swap(input, low, partitionIndex);
		
		return partitionIndex;		
	}
		
	
	/**
	 * Wrapper method
	 * @param values
	 * @return
	 */
    public static int[] quickSort(int[] values) {
        quicksort(values, 0, values.length - 1);
        
        return values;
    }

    private static void quicksort(int[] input, int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivotIndex = returnPivotIndexRandomNumber(low, high);
        int pivot = input[pivotIndex];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (input[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (input[j] > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
            	swap(input, i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j) {
        	quicksort(input, low, j);
        }
            
        if (i < high) {
        	quicksort(input, i, high);
        }
            
    }

	
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
	
	public static void isSorted(int[] input, String title) {
		for(int i=1;i<input.length;i++) {
			if(input[i]-input[i-1] < 0) {
				System.out.println(title + ": " + "Array is NOT sorted!!!");
				return;
			}	
		}
		
		System.out.println(title + ": " + "Array is sorted!!!");
		return;
	}
	
	public static void main(String[] args) {
		
		int[] sortedNumbers;
		
		int[] randomizedArray = getRandomizedArray(100);
		//printOutArray(randomizedArray, "Original array");
		
		//Bubble Sort:
		sortedNumbers = bubbleSort(Arrays.copyOf(randomizedArray, randomizedArray.length));
		//printOutArray(sortedNumbers, "Bubble Sort:");
		isSorted(sortedNumbers, "Bubble Sort");
		
		//Selection Sort:
		sortedNumbers = selectionSort(Arrays.copyOf(randomizedArray, randomizedArray.length));
		//printOutArray(sortedNumbers, "Selection Sort:");
		isSorted(sortedNumbers, "Selection Sort");
		
		//Insertion Sort:
		sortedNumbers = insertionSort(Arrays.copyOf(randomizedArray, randomizedArray.length));
		//printOutArray(sortedNumbers, "Insertion Sort:");
		isSorted(sortedNumbers,  "Insertion Sort");
		
		//Merge Sort:
		sortedNumbers = mergeSort(Arrays.copyOf(randomizedArray, randomizedArray.length));
		//printOutArray(sortedNumbers, "Merge Sort:");
		isSorted(sortedNumbers, "Merge Sort");
		
		//Quick Sort:
		sortedNumbers = quickSort(Arrays.copyOf(randomizedArray, randomizedArray.length));
		//printOutArray(sortedNumbers, "Quick Sort:");
		isSorted(sortedNumbers, "Quick Sort");
		

	}
}
