package Chapter24;

import java.util.*;

public class MergeSort {

	public static void mergeSort(int[] arr){
		mergeSort(arr, 0, arr.length-1);
	}
	
	public static void mergeSort(int[] arr, int left, int right){
		if(left >= right)
			return;
		
		int mid = left + (right-left)/2;
		mergeSort(arr, left, mid);
		mergeSort(arr, mid+1, right);
		
		
		int[] leftArr = new int[mid-left+1];
		System.arraycopy(arr, left, leftArr, 0, leftArr.length);
		int[] rightArr = new int[right-mid];
		System.arraycopy(arr, mid+1, rightArr, 0, rightArr.length);
		
		int pleft = 0;
		int pright = 0;
		int i = left;
		while(i <= right){
			if(pleft >= leftArr.length)
				arr[i++] = rightArr[pright++];
			else if(pright >= rightArr.length)
				arr[i++] = leftArr[pleft++];
			else if(leftArr[pleft] < rightArr[pright])
				arr[i++] = leftArr[pleft++];
			else
				arr[i++] = rightArr[pright++];
		}
	}
	
	
	public static void main(String[] args){
		int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		mergeSort(list);
		for(int i=0; i<list.length; i++)
			System.out.print(list[i] + " ");
	}
	
}
