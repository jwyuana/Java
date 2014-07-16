package Chapter20;

public class RecursiveSelectionSort {
	
	public static void sort(double[] list){
		sort(list, 0, list.length-1);
	}
	
	public static void sort(double[] list, int low, int high){
		if(low < high){
			int min = low;
			for(int i=low+1; i<=high; i++)
				if(list[i] < list[min])
					min = i;
			
			double minVal = list[min];
			list[min] = list[low];
			list[low] = minVal;
			
			sort(list, low+1, high);
		}
	}

}
