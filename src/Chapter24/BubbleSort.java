package Chapter24;

import java.util.*;

public class BubbleSort {

	public static void bubbleSort(int[] arr){
		int n = arr.length;
		boolean needNextPass = true;
		for(int i=n-1; i>0 && needNextPass; i--){
			needNextPass = false;
			for(int j=0; j<i; j++)
				if(arr[j] > arr[j+1]){
					int val = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = val;
					needNextPass = true;
				}
		}
	}
	
	public static void main(String[] args){
		int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		bubbleSort(list);
		for(int i=0; i<list.length; i++)
			System.out.print(list[i] + " ");
	}
	
}
