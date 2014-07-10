package Chapter21;

public class GenericMethodDemo {

	public static void main(String[] args){
		Integer[] integers = {1,2,3,4,5};
		String[] strings = {"London", "Paris", "New York", "Austin"};
		
		GenericMethodDemo.<Integer>print(integers);             // generic method
		GenericMethodDemo.<String>print(strings);
		// Ϊ�˵��÷��ͷ�������Ҫ��ʵ�����ͷ��ڼ���������Ϊ��������ǰ׺��
	}
	
	public static <E> void print(E[] list){
		for(int i=0; i<list.length; i++)
			System.out.print(list[i] + " ");
		System.out.println();
	}
}
