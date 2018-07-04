import java.util.Arrays;
import java.util.Random;

public class Quicksort2  {

	/**
	 * Wrapper method
	 * @param values
	 * @return
	 */
    public static int[] quickSort(int[] values) {
        quicksort(values, 0, values.length - 1);
        
        return values;
    }

    private static void quicksort(int[] numbers, int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivotIndex = returnPivotIndexRandomNumber(low, high);
        int pivot = numbers[pivotIndex];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
            	swap(numbers, i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(numbers, low, j);
        if (i < high)
            quicksort(numbers, i, high);
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
    
	public static boolean isSorted(int[] input) {
		for(int i=1;i<input.length;i++) {
			if(input[i]-input[i-1] < 0) {
				return false;
			}	
		}
		
		return true;
	}
	
	/**
	 * Pick the index of the pivot random index in the array within the specified range.
	 */
	public static int returnPivotIndexRandomNumber(int low, int high) {
		int sizeOfRange = high - low + 1;
		return new Random().nextInt(sizeOfRange) + low;
	}
    
	public static int[] getRandomizedArray(int size) {
		
		int[] randomNumbers = new int[size];
		
		for(int i=0; i<size; i++) {
			randomNumbers[i] = (int) (size*Math.random());
		}
		
		return randomNumbers;
	}
	
    public static void main(String[] args) {
		
    	System.out.println("Test!!!");
    	
		int[] sortedNumbers;
		
		int[] randomizedArray = getRandomizedArray(1000);
		
		//int[] randomizedArray = new int[]{8, 4, 0, 1, 0, 9, 0, 3, 3, 3};
		
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

