package Chapter21;


// ͨ�䷺�����ͣ� ?, ? extends T, ? super T

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

// ������������� public static double max(GenericStack<Number> stack)
// line13����ͻ����
// ��Ϊinteger��number������ ���ܴ���GenericStack<Integer>��GenericStack<Number>������


// ͬ��  GenericStack<Integer> GenericStack<Object>����
// GenericStack<Integer> GenericStack<?> ���ǶԵ�