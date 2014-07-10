package Chapter21;

public class GenericStack<T> {

	private java.util.ArrayList<T> list = new java.util.ArrayList<T>();
	
	public int getSize(){
		return list.size();
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public T peek(){
		return list.get(list.size()-1);
	}
	
	public T pop(){
		T rst = list.get(list.size()-1);
		list.remove(list.size()-1);
		return rst; 
	}
	
	public void push(T elem){
		list.add(elem);
	}
}
