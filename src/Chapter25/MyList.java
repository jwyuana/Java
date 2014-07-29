package Chapter25;

public interface MyList<T> {
	
	public void add(T elem);
	
	public void add(int index, T elem);
	
	public void clear();
	
	public boolean contain(T elem);
	
	public T get(int index);
	
	public int indexOf(T elem);
	
	public boolean isEmpty();
	
	public int lastIndexOf(T elem);
	
	public boolean remove(T elem);
	
	public T remove(int index);
	
	public int size();
	
	public T set(int index, T elem);
}
