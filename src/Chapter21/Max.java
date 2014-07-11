package Chapter21;


// ����ʹ�÷�����/�ӿ� ������ָ���������ͣ� �ȼ���<Object>�� ��ʹ�����Ͳ����ķ������Ϊԭʼ����

public class Max {

	// raw type, not safe
	public static Comparable max1(Comparable o1, Comparable o2){
		if(o1.compareTo(o2)>0)
			return o1;
		else 
			return o2;
	}
	
	
	// safe way
	public static <E extends Comparable<E>> E max2(E o1, E o2){
		if(o1.compareTo(o2)>0)
			return o1;
		else 
			return o2;
	}
	
}
