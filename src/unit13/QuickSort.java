package unit13;

import static java.lang.System.*;
import java.util.Arrays;		//use Arrays.toString() to help print out the array

public class QuickSort
{
	private static int passCount = 0;

	public static void quickSort(Comparable[] list)
	{
		passCount = 0;
		
		int size = list.length - 1;
		
		quickSort(list, 0, size);


	}


	private static void quickSort(Comparable[] list, int low, int high)
	{
		
		if (low < high) {
			int spot = partition(list, low, high);

			System.out.println();
			passCount++;
			
			System.out.println("pass count: " + (passCount));
			
			for (Comparable i : list) {
				System.out.print(i + " ");
			}
			
			quickSort(list, low, spot);
			quickSort(list, spot + 1, high);
		
		}
		
	
	}


	private static int partition(Comparable[] list, int low, int high)
	{
		Comparable pivot = list[low];
		int a = low - 1;
		int b = high + 1;
		
		while (a < b) {
			while (list[--b].compareTo(pivot) > 0);
			while (list[++a].compareTo(pivot) < 0);
			if (a >= b) {
					return b;
			}
				
			Comparable temp = list[a];
			list[a] = list[b];
			list[b] = temp;

		}

		return 0;
	}
}
