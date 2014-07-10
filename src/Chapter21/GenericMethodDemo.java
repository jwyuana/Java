package Chapter21;

public class GenericMethodDemo {

	public static void main(String[] args){
		Integer[] integers = {1,2,3,4,5};
		String[] strings = {"London", "Paris", "New York", "Austin"};
		
		GenericMethodDemo.<Integer>print(integers);             // generic method
		GenericMethodDemo.<String>print(strings);
		// 为了调用泛型方法，需要将实际类型放在尖括号内作为方法名的前缀。
	}
	
	public static <E> void print(E[] list){
		for(int i=0; i<list.length; i++)
			System.out.print(list[i] + " ");
		System.out.println();
	}
}
