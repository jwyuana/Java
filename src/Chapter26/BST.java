package Chapter26;

import java.util.*;

public class BST<E extends Comparable<E>> extends AbstractTree<E>{
	
	protected TreeNode<E> root;
	protected int size = 0;
	
	public BST(){
	}
	
	public BST(E[] objs){
		for(int i=0; i<objs.length; i++)
			insert(objs[i]);
	}
	
	
	public boolean search(E e){
		TreeNode<E> curr = root;
		
		while(curr != null){
			if(e.compareTo(curr.elem) > 0)
				curr = curr.right;
			else if(e.compareTo(curr.elem) < 0)
				curr = curr.left;
			else
				return true;
		}
		
		return false;
	}
	
	
	public boolean insert(E e){
		if(root == null)
			root = new TreeNode<E>(e);
		else{
			TreeNode<E> parent = null;
			TreeNode<E> curr = root;
			while(curr != null){
				if(e.compareTo(curr.elem) > 0){
					parent = curr;
					curr = curr.right;
				}
				else if(e.compareTo(curr.elem) < 0){
					parent = curr;
					curr = curr.left;
				}
				else
					return false;
			}
			if(e.compareTo(parent.elem) > 0)
				parent.right = new TreeNode<E>(e);
			else
				parent.left = new TreeNode<E>(e);
		}
		size++;
		return true;
	}

	
	public void inorder(){
		inorder(root);
		System.out.println();
	}
	
	public void inorder(TreeNode<E> node){
		if(node == null)
			return;
		inorder(node.left);
		System.out.print(node.elem + " ");
		inorder(node.right);
	}
	
	
	public void preorder(){
		preorder(root);
		System.out.println();
	}
	
	public void preorder(TreeNode<E> node){
		if(node == null)
			return;
		System.out.print(node.elem + " ");
		preorder(node.left);
		preorder(node.right);
	}
	
	
	public void postorder(){
		postorder(root);
		System.out.println();
	}
	
	public void postorder(TreeNode<E> node){
		if(node == null)
			return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.elem + " ");
	}
	
	
	public int getSize(){
		return size;
	}
	
	
	public TreeNode getRoot(){
		return root;
	}
	
	
	public ArrayList<TreeNode<E>> path(E e){
		ArrayList<TreeNode<E>> list = new ArrayList<TreeNode<E>>();
		TreeNode<E> curr = root;
		
		while(curr != null){
			list.add(curr);
			if(e.compareTo(curr.elem) > 0)
				curr = curr.right;
			else if(e.compareTo(curr.elem) < 0)
				curr = curr.left;
			else
				break;
		}
		
		return list;
	}
	
	
	public boolean delete(E e){
		TreeNode<E> parent = null;
		TreeNode<E> curr = root;
		
		while(curr != null){
			if(e.compareTo(curr.elem) > 0){
				parent = curr;
				curr = curr.right;
			}
			else if(e.compareTo(curr.elem) < 0){
				parent = curr;
				curr = curr.left;
			}
			else{
				if(curr.left == null)
					if(e.compareTo(parent.elem) > 0)
						parent.right = curr.right;
					else
						parent.left = curr.right;
				else if(curr.right == null)
					if(e.compareTo(parent.elem) > 0)
						parent.right = curr.left;
					else
						parent.left = curr.left;
				else{
					TreeNode<E> leftmost = curr.right;
					parent = curr;
					while(leftmost.left != null){
						parent = leftmost;
						leftmost = leftmost.left;
					}
					curr.elem = leftmost.elem;
					if(parent.right == leftmost)
						parent.right = leftmost.right;
					else
						parent.left = leftmost.right;
					
				}
				size--;
				return true;
			}
		}
		
		return false;
	}
	
	public Iterator iterator(){
		return new InorderIterator();
	}
	
	class InorderIterator implements Iterator{
		private ArrayList<E> list = new ArrayList<E>();
		private int current = 0;
		
		public InorderIterator(){
			inorder();
		}
		
		private void inorder(){
			inorder(root);
		}
		
		private void inorder(TreeNode<E> node){
			if(node == null)
				return;
			inorder(node.left);
			list.add(node.elem);
			inorder(node.right);
		}
		
		public boolean hasNext(){
			if(current < list.size())
				return true;
			return false;
		}
		
		public Object next(){
			return list.get(current++);
		}
		
		public void remove(){
			delete(list.get(current));
			list.clear();
			inorder();
		}
	}
	
	
	public void clear(){
		root = null;
		size = 0;
	}
	
	
	
	
}
