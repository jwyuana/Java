package Chapter24;

public class QuickSort {

	public static void quickSort(int[] arr){
		quickSort(arr, 0, arr.length-1);
	}
	
	public static void quickSort(int[] arr, int left, int right){
		if(left >= right)
			return;
		
		int pivot = arr[left+(right-left)/2];
		arr[left+(right-left)/2] = arr[right];
		int index = left;
		for(int i=left; i<right; i++)
			if(arr[i] <= pivot){
				int val = arr[i];
				arr[i] = arr[index];
				arr[index] = val;
				index++;
			}
		arr[right] = arr[index];
		arr[index] = pivot;
		
		quickSort(arr, left, index-1);
		quickSort(arr, index+1, right);
	}
	
	public static void main(String[] args){
		int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		quickSort(list);
		for(int i=0; i<list.length; i++)
			System.out.print(list[i] + " ");
	}
	
}
