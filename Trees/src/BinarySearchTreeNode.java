import java.util.ArrayList;
import java.util.Stack;

/**
 * Representation of Binary Search Tree (BST).
 * If there are duplicates, then they get inserted as the left child of the appropriate node.
 * @author Admin
 *
 */
public class BinarySearchTreeNode {
	private int key;
	private int size;
	private BinarySearchTreeNode left;
	private BinarySearchTreeNode right;
	private BinarySearchTreeNode parent;
	
	public BinarySearchTreeNode(int key, BinarySearchTreeNode left, BinarySearchTreeNode right, BinarySearchTreeNode parent) {
		this.key = key;
		this.left = left;
		this.right = right;
		this.parent = parent;
		this.size = 1;
	}
	
	public BinarySearchTreeNode getLeftChild() {
		return left;
	}
	
	public BinarySearchTreeNode getRightChild() {
		return right;
	}
	
	public BinarySearchTreeNode getParent() {
		return parent;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setLeftChild(BinarySearchTreeNode left) {
		this.left = left;
	}
	
	public void setRightChild(BinarySearchTreeNode right) {
		this.right = right;
	}
	
	public void setParent(BinarySearchTreeNode parent) {
		this.parent = parent;
	}
	
	public void setSize(int size) {
		this.size = size;
	}

	
	/**
	 * Perform inorder traversal of a binary tree:
	 * 1. Visit Left subtree
	 * 2. Visit Root
	 * 3. Visit Right Subtree
	 * @param root - root node of tree
	 * @param output - values of tree in the order of traversal
	 */
	public static void inorderTraversalRecursive(BinarySearchTreeNode root, ArrayList<Integer> output) {
		
		//Base case
		if(root == null) {
			return;
		}
		
		if(root.getLeftChild() != null) {
			inorderTraversalRecursive(root.getLeftChild(), output);
		}
		
		output.add(root.getKey());
		
		if(root.getRightChild() != null){
			inorderTraversalRecursive(root.getRightChild(), output);		
		}		
	}
	
	public static ArrayList<Integer> inorderTraversalIterative(BinarySearchTreeNode root) {
		
		ArrayList<Integer> output = new ArrayList<>();
		
		BinarySearchTreeNode currentNode = root;
		Stack<BinarySearchTreeNode> stack = new Stack<>();
		
		while(currentNode!= null || !stack.isEmpty()) {
			while(currentNode != null) {				
				//Go all the way down the left subtree until we get to the end
				stack.push(currentNode);
				currentNode = currentNode.getLeftChild();		
			}
			
			//Get parent node, which is the latest leaf node
			currentNode = stack.pop(); 			
			output.add(currentNode.getKey()); //Parent node is now the current node, so we get its value			
			
			if(currentNode.getRightChild() != null) {
				currentNode = currentNode.getRightChild();
			} else {
				//We looked at the left subtree, we looked at the root, and there is no right subtree.
				//We are done.
				currentNode = null; 
			}			
		}

		return output;
	}
	
	public static ArrayList<Integer> preorderTraversalIterative(BinarySearchTreeNode root) {
		
        ArrayList<Integer> output = new ArrayList<>();
		
		BinarySearchTreeNode currentNode = root;
		Stack<BinarySearchTreeNode> stack = new Stack<>();
		
		while(currentNode!= null || !stack.isEmpty()) {
			while(currentNode != null) {				
				//Go all the way down the left subtree until we get to the end
				output.add(currentNode.getKey()); //Get the current node
				stack.push(currentNode);
				currentNode = currentNode.getLeftChild();		
			}
			
			//Get parent node, which is the latest leaf node
			currentNode = stack.pop();		
			
			if(currentNode.getRightChild() != null) {
				currentNode = currentNode.getRightChild();
			} else {
				//We looked at the left subtree, we looked at the root, and there is no right subtree.
				//We are done.
				currentNode = null; 
			}			
		}

		return output;
	}
	
	public static ArrayList<Integer> postorderTraversalIterative(BinarySearchTreeNode root) {
		
		ArrayList<Integer> output = new ArrayList<>();
		
		
		Stack<BinarySearchTreeNode> stack = new Stack<>();		
		stack.push(root);
		BinarySearchTreeNode currentNode = null;
		BinarySearchTreeNode currentNodeTemp = null; //Used to keep track if we visited a node or not
		
		while(!stack.isEmpty()) {
			currentNodeTemp = stack.peek();
			
			if(currentNodeTemp.left != null && currentNodeTemp.right != null) {
				//We have not kept track of the left and right subtrees yet
				
				//We put right node on the stack to keep track of it
				if(currentNodeTemp.right != null) {
					stack.push(currentNodeTemp.right);
					currentNodeTemp.right = null; //Mark temp node as null so we don't put it in stack again
				}
				
				//We put left node on the stack to keep track of it
				if(currentNodeTemp.left != null) {
					stack.push(currentNodeTemp.left);
					currentNodeTemp.left = null; //Mark temp node as null so we don't put it in stack again
				}
			} else {
				//We have already kept track of the left and right subtrees, so we can process the node		
				currentNode = stack.pop(); 
				output.add(currentNode.getKey()); //We get the current node
			}
		}

		return output;
	}
	
	
	/**
	 * Perform preorder traversal of a binary tree:
	 * 1. Visit Root
	 * 2. Visit Left subtree
	 * 3. Visit Right Subtree
	 * @param root - root node of tree
	 * @param output - values of tree in the order of traversal
	 */
	public static void preorderTraversalRecursive(BinarySearchTreeNode root, ArrayList<Integer> output) {
		
		//Base case
		if(root == null) {
			return;
		}
		
		output.add(root.getKey());
		
		if(root.getLeftChild() != null) {
			preorderTraversalRecursive(root.getLeftChild(), output);
		}
		
		if(root.getRightChild() != null){
			preorderTraversalRecursive(root.getRightChild(), output);		
		}		
	}
	
	/**
	 * Perform postorder traversal of a binary tree:
	 * 1. Visit Right Subtree
	 * 2. Visit Left subtree
	 * 3. Visit Root
	 * 
	 * @param root - root node of tree
	 * @param output - values of tree in the order of traversal
	 */
	public static void postorderTraversalRecursive(BinarySearchTreeNode root, ArrayList<Integer> output) {
		
		//Base case
		if(root == null) {
			return;
		}
		
		if(root.getLeftChild() != null) {
			inorderTraversalRecursive(root.getLeftChild(), output);
		}
		
		if(root.getRightChild() != null){
			inorderTraversalRecursive(root.getRightChild(), output);		
		}	
		
		output.add(root.getKey());	
	}
	
	/**
	 * Insert a node in the appropriate place in the tree.
	 * If we find a duplicate, then we insert the node to the left of the tree. If the duplicate node has a right child,
	 * then we make the right child be the child of the inserted duplicate.
	 * @param key
	 * @param root
	 * @return
	 */
	public static BinarySearchTreeNode insert(int key, BinarySearchTreeNode root) {
		if(root==null) {
			return new BinarySearchTreeNode(key, null, null, null);
		}
		
		BinarySearchTreeNode insertedNode;
		BinarySearchTreeNode insertedLeftChild;
		BinarySearchTreeNode insertedRightChild;
		BinarySearchTreeNode parentNode = null;
		BinarySearchTreeNode currentNode = root;
		
		
		//Find the appropriate location to insert the new node. We navigate until we either find a duplicate node or a leaf:
		while(currentNode != null) {			
			if(currentNode.key == key) {
				//If we have a duplicate node, then insert this node as the left child
				if(currentNode.left == null) {
					insertedNode = new BinarySearchTreeNode(key, null, null, currentNode);				
					
				} else {
					insertedNode = new BinarySearchTreeNode(key, currentNode.left, (currentNode.left).right, currentNode);
					insertedNode.setSize(1 + insertedNode.left.getSize() + insertedNode.right.getSize());
				}
				currentNode.left = insertedNode;
				currentNode.size++;
				return insertedNode;
			} else if(currentNode.key > key) {
				//Inserted node will be in the left subtree
				currentNode.size++;
				parentNode = currentNode;
				currentNode = currentNode.left;
			} else {
				//Inserted node will be in the right subtree
				currentNode.size++;
				parentNode = currentNode;
				currentNode = currentNode.right;
			}
		}
		
		//If we are here, then we are at a leaf node:
		insertedNode = new BinarySearchTreeNode(key, null, null, parentNode);
		if(parentNode.key > key) {		
			parentNode.left = insertedNode; //Inserted node will be in parent's left subtree
			
		} else {
			parentNode.right = insertedNode; //Inserted node will be in the right subtree			
		}
		return insertedNode;
	}
	
	/**
	 * Search for the first encountered node with a value the same as a given key.
	 * If key is not present in BST, then return null;
	 * @param key
	 * @param root
	 * @return
	 */
	public static BinarySearchTreeNode search(int key, BinarySearchTreeNode root) {
		
		BinarySearchTreeNode currentNode = root;
		
		while(currentNode != null) {
			if(currentNode.key == key) {
				return currentNode;
			} else {
				if(currentNode.key > key) {
					currentNode = currentNode.left; //Value will be in the left subtree
				} else {
					currentNode = currentNode.left; //Value will be in the right subtree
				}
			}
		}
		
		return null; //We did not find the value in the tree
	}
	
	/**
	 * Find node with the minimum value in the BST. The node must be in the left path of the tree.
	 * @param root
	 * @return
	 */
	public static BinarySearchTreeNode findMin(BinarySearchTreeNode root) {
		
		BinarySearchTreeNode currentNode = root;

		while(currentNode.left != null) {
			currentNode = currentNode.left;
		}
		
		return currentNode;
	}
	
	/**
	 * Find node with the maximum value in the BST. The node must be in the left path of the tree.
	 * @param root
	 * @return
	 */
	public static BinarySearchTreeNode findMax(BinarySearchTreeNode root) {
		
		BinarySearchTreeNode currentNode = root;

		while(currentNode.right != null) {
			currentNode = currentNode.right;
		}
		
		return currentNode;
	}
	
	public static void delete(int key, BinarySearchTreeNode root) {
		
		//Search for the node in the tree, and keep track of the parent nodes
		ArrayList<BinarySearchTreeNode> parentNodes = new ArrayList<>();

		BinarySearchTreeNode currentNode = root;
				
		while(currentNode != null) {
			if(currentNode.key == key) {
				break;
			} else {
				parentNodes.add(currentNode);
				if(currentNode.key > key) {
					currentNode = currentNode.left; //Value will be in the left subtree					
				} else {
					currentNode = currentNode.left; //Value will be in the right subtree
				}
			}
		}
		
		//we did not find the node - stop
		if(currentNode == null) {
			return; 
		}
		
		//If node has no children - we simply delete the node
		if(currentNode.left == null && currentNode.right == null) {			
			if(currentNode == currentNode.parent.left) {
				currentNode.parent.left = null;
			} else {
				currentNode.parent.right = null;
			}
		} else if(currentNode.left != null && currentNode.right == null) {
			//If node only has left subtree
			if(currentNode == currentNode.parent.left) {
				currentNode.parent.left = currentNode.left;
			} else {
				currentNode.parent.right = currentNode.left;
			}
		} else if(currentNode.left == null && currentNode.right != null) {
			//If node only has right subtree
			if(currentNode == currentNode.parent.left) {
				currentNode.parent.left = currentNode.right;
			} else {
				currentNode.parent.right = currentNode.right;
			}
		} else {
			//If node only has both left and right subtree

			//Substitute node with maximum node in left subtree.
			//The max node is the currentNode's predecessor
			BinarySearchTreeNode predecessorNode = findMax(currentNode);
			BinarySearchTreeNode predecessorParent = predecessorNode.getParent();
			
			//Substitute:
			predecessorParent.right = predecessorNode.getLeftChild(); //in case the predecessor node has a 
			predecessorNode.left = currentNode.left;
			predecessorNode.right = currentNode.right;
			predecessorNode.parent = currentNode.parent;
			predecessorNode.size = currentNode.size;
			
			currentNode.parent.left = predecessorNode;			
			}
		
		decrementSize(parentNodes); //Mark parent nodes as having one less node in subtrees		
	}
	
	private static void decrementSize(ArrayList<BinarySearchTreeNode> nodes) {
		for(BinarySearchTreeNode node : nodes) {
			node.size--;
		}
	}
	

	
	
	
	
		
}
