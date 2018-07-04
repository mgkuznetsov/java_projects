import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeMap;

public class TreeMainClass {

	public static void printIntegerList(ArrayList<Integer> list, String title) {
		
		String output = title + ": ";
		for(Integer i : list) {
			output = output + i + ", ";
		}
		
		System.out.println(output);
	}
	
	public static void main(String[] args) {
		
		//Traversals of Binary Tree:
		
		//Create the tree:
		BinarySearchTreeNode three = new BinarySearchTreeNode(3, null, null, null);
		BinarySearchTreeNode four = new BinarySearchTreeNode(4, null, null, null);
		BinarySearchTreeNode five = new BinarySearchTreeNode(5, null, null, null);
		BinarySearchTreeNode two = new BinarySearchTreeNode(2, four, five, null); //TODO: Check if this causes errors
		BinarySearchTreeNode root = new BinarySearchTreeNode(1, two, three, null);

		//Inorder Traversal: 4, 2, 5, 1, 3
		ArrayList<Integer> inorderRecursiveOutput = new ArrayList<>();		
		BinarySearchTreeNode.inorderTraversalRecursive(root, inorderRecursiveOutput);
		printIntegerList(inorderRecursiveOutput, "Inorder Traversal (Recursive): ");
		
		//Preorder Traversal: 1, 2, 4, 5, 3
		ArrayList<Integer> preorderRecursiveOutput = new ArrayList<>();		
		BinarySearchTreeNode.preorderTraversalRecursive(root, preorderRecursiveOutput);
		printIntegerList(preorderRecursiveOutput, "Preorder Traversal (Recursive): ");
		
		//Postorder Traversal: 4, 5, 2, 3, 1
		ArrayList<Integer> postorderRecursiveOutput = new ArrayList<>();		
		BinarySearchTreeNode.postorderTraversalRecursive(root, postorderRecursiveOutput);
		printIntegerList(postorderRecursiveOutput, "Postorder Traversal (Recursive): ");

		//Inorder Traversal (Iteration): 4, 2, 5, 1, 3	
		ArrayList<Integer> inorderIterativeOutput = BinarySearchTreeNode.inorderTraversalIterative(root);
		printIntegerList(inorderIterativeOutput, "Inorder Traversal (Iterative): ");
		
		//Preorder Traversal (Iteration): 4, 5, 2, 3, 1	
		ArrayList<Integer> preIterativeOutput = BinarySearchTreeNode.preorderTraversalIterative(root);
		printIntegerList(preIterativeOutput, "Preorder Traversal (Iterative): ");
		
		//Postorder Traversal (Iteration): 4, 5, 2, 3, 1	
		ArrayList<Integer> postIterativeOutput = BinarySearchTreeNode.postorderTraversalIterative(root);
		printIntegerList(postIterativeOutput, "Postorder Traversal (Iterative): ");

	}
	
}
