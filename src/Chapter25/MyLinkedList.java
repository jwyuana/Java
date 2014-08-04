package Chapter25;

public class MyLinkedList<E> extends MyAbstractList<E> {

	private Node<E> head, tail;
	
	public MyLinkedList(){
		
	}
	
	public MyLinkedList(E[] objects){
		super(objects);
	}
	
	public E getFirst(){
		if(size == 0)
			return null;
		else
			return head.elem;
	}
	
	public E getLast(){
		if(size == 0)
			return null;
		else
			return tail.elem;
	}
	
	public void addFirst(E e){
		Node<E> node = new Node<>(e);
		node.next = head;
		head = node;
		size++;
		if(tail == null)
			tail = node;
	}
	
	public void addLast(E e){
		Node<E> node = new Node<>(e);
		if(tail == null)
			head = tail = node;
		else{
			tail.next = node;
			tail = node;
		}
		size++;
	}
	
	public void add(int index, E e){
		Node<E> node = new Node<>(e);
		
		if(index >= size)
			addLast(e);
		else if(index == 0)
			addFirst(e);
		else{
			Node<E> curr = head;
			while(index > 1){
				curr = curr.next;
				index--;
			}
			node.next = curr.next;
			curr.next = node;
			size++;
		}
	}
	
	public E removeFirst(){
		if(head == null)
			return null;
		
		E e = head.elem;
		head = head.next;
		if(head == null)
			tail = null;
		size--;
		return e;
	}
	
	public E removeLast(){
		if(tail == null)
			return null;
		
		E e = tail.elem;
		if(size == 1)
			head = tail = null;
		else{
			Node<E> curr = head;
			for(int i=0; i<size-2; i++)
				curr = curr.next;
			tail = curr;
			tail.next = null;
		}
		size--;
		return e;
	}
	
	public E remove(int index){
		if(index < 0 || index > size-1)
			return null;
		else if(index == 0)
			return removeFirst();
		else if(index == size-1)
			return removeLast();
		else{
			Node<E> prev = head;
			for(int i=1; i<index; i++)
				prev = prev.next;
			Node<E> curr = prev.next;
			prev.next = curr.next;
			size--;
			return curr.elem;
		}
	}
	
	public String toString(){
		StringBuilder rst = new StringBuilder("[");
		
		Node<E> current = head;
		for(int i=0; i<size; i++){
			rst.append(current.elem);
			current = current.next;
			if(current != null)
				rst.append(", ");
			else
				rst.append("]");
		}
		return rst.toString();
	}
	
	public void clear(){
		head = tail = null;
	}
	
	public boolean contain(E e){
		Node<E> curr = head;
		while(curr != null){
			if(e.equals(curr.elem))
				return true;
			curr = curr.next;
		}
		return false;
	}
	
	public E get(int index){
		if(index < 0 || index >= size)
			return null;
		
		Node<E> curr = head;
		for(int i=1; i<=index; i++)
			curr = curr.next;
		return curr.elem;
	}
	
	public int indexOf(E e){
		int index = -1;
		Node<E> curr = head;
		while(curr != null){
			index++;
			if(e.equals(curr.elem))
				return index;
			curr = curr.next;
		}
		return index;
	}
	
	public int lastIndexOf(E e){
		int index = -1;
		int i = -1;
		Node<E> curr = head;
		while(curr != null){
			i++;
			if(e.equals(curr.elem))
				index = i;
			curr = curr.next;
		}
		return index;
	}
	
	public E set(int index, E e){
		Node<E> curr = head;
		for(int i=1; i<=index; i++)
			curr = curr.next;
		curr.elem = e;
		return e;
	}
	
	private static class Node<E> {
		E elem;
		Node<E> next;
		
		public Node(E elem){
			this.elem = elem;
		}
	}
	
	
	
	
	
	
}
