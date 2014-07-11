package Chapter21;


// 可以使用泛型类/接口 而无需指定具体类型， 等价于<Object>， 不使用类型参数的泛型类称为原始类型

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
