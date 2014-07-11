package Chapter21;


// 通配泛型类型： ?, ? extends T, ? super T

public class WildCardDemo {

	public static void main(String[] args){
		GenericStack<Integer> intStack = new GenericStack<Integer>();
		intStack.push(1);
		intStack.push(-1);
		intStack.push(11);
		System.out.print("The max is " + max(intStack));
	}
	
	public static double max(GenericStack<? extends Number> stack){
		double max = stack.pop().doubleValue();
		
		while(!stack.isEmpty()){
			double value = stack.pop().doubleValue();
			if(value>max)
				max = value;
		}
		
		return max;
	}
}

// 如果函数声明是 public static double max(GenericStack<Number> stack)
// line13编译就会出错
// 因为integer是number的子类 不能代表GenericStack<Integer>是GenericStack<Number>的子类


// 同理  GenericStack<Integer> GenericStack<Object>不行
// GenericStack<Integer> GenericStack<?> 才是对的