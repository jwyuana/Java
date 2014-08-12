package Chapter26;

import java.util.*;

public class TestBST {

	public static void main(String[] args){
		BST<String> tree = new BST<String>();
		tree.insert("George");
		tree.insert("Michael");
		tree.insert("Tom");
		tree.insert("Adam");
		tree.insert("Jones");
		tree.insert("Peter");
		tree.insert("Daniel");
		
		System.out.print("Inorder sort: ");
		tree.inorder();
		System.out.print("\nPostorder sort: ");
		tree.postorder();
		System.out.print("\nPreorder sort: ");
		tree.preorder();
		
		System.out.println("\n The number of nodes is " + tree.getSize());
		
		System.out.println("Is Peter in the tree: " + tree.search("Peter"));
		
		System.out.print("Path from root to Peter: ");
		ArrayList<TreeNode<String>> path = tree.path("Peter");
		for(int i=0; i<path.size(); i++)
			System.out.print(path.get(i).elem + " ");
		System.out.println();
		
		tree.delete("Jones");
		System.out.println("\n The number of nodes is " + tree.getSize());
		System.out.println("Is Peter in the tree: " + tree.search("Peter"));
		System.out.print("Inorder sort: ");
		tree.inorder();
	}
	
}
