package Chapter11;

public class MyStack {

	private java.util.ArrayList list = new java.util.ArrayList();
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public int getSize(){
		return list.size();
	}
	
	public void push(Object o){
		list.add(o);
	}
	
	public Object pop(){
		Object rst = list.get(list.size()-1);
		list.remove(list.size()-1);
		return rst;
	}
	
	public Object peek(){
		return list.get(list.size()-1);
	}
	
	public int search(Object o){
		return list.lastIndexOf(o);
	}
}
