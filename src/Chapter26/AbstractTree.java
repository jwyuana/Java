package Chapter26;

public abstract class AbstractTree<E extends Comparable<E>> implements Tree<E> {
	
	public void inorder(){
		
	}
	
	public void preorder(){
		
	}
	
	public void postorder(){
		
	}
	
	public boolean isEmpty(){
		return getSize() == 0;
	}
	
	public java.util.Iterator iterator(){
		return null;
	}

}
