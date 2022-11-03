package demo.app;

import java.util.Arrays;

public class ArrayApp {

	public static void main(String[] args) {
		Integer[] intArray = { 40, -4, 2, 5, 8, 20 };
		sortedArray(intArray);
		// System.out.println(Arrays.toString(intArray));

		Double[] doubleArray = { 20.6, 10.0, 11.60, 0.405 };
		sortedArray(doubleArray);
		// System.out.println(Arrays.toString(doubleArray));

		String[] namesArray = { "Zenn", "Abebe", "Alex", "Keisha", "Benni" };
		sortedArray(namesArray);
		System.out.println(Arrays.toString(namesArray));

		int[] inputArray = { 6, 1, -6, 20, 15, 30, 10 };

		// quickSort(inputArray,0,6);
		//System.out.println("Sorted ArraY: "+Arrays.toString(inputArray));

	}

	public static <T extends Object> T[] sortedArray(T[] array) {
		Arrays.sort(array);
		print(array);
		return array;
	}

	// Declaring generic type
	public static <T> void print(T[] type) {
		System.out.println("\nPrinting Sorted Array of type: " + type.getClass().getSimpleName());
		System.out.println(Arrays.toString(type));
	}

	public static void quickSort(int[] arr, int left, int right) {

		int pivotalIndex = left + (right - left) / 2;
		int pivotalValue = arr[pivotalIndex];

		int i = left;
		int j = right;

		while (i <= j && j>0) {
			while (arr[i] < pivotalValue) {
				i++;
			}
			while (arr[j] > pivotalValue) {
				j--;
				
			}
		}

		if (i <= j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		if (left < i) {
			quickSort(arr, left, j);
		}
		if (right > i) {
			quickSort(arr, i, right);
		}

	}
}
