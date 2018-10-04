package Assignment1;

public class MyIntegerBST implements A1Tree {

	private Node root = null;

	public MyIntegerBST() {
	}

	@Override
	public void insert(Integer value) {
		
		if(value == null) {
			System.err.println("Error, there is no value given!");
		}
		else if(!containsNode(value)) {
			this.root = insertElement(this.root, value);
		}
		else {
			System.err.println("Error, duplicate value detected! Try Again!");
		}
		
		
	}
	
	public Node getRoot() {
		return root;
	}

	@Override
	public Integer mostSimilarValue(Integer value) {

		if (containsNode(value)) {
			return value;
		} else {
			return searchDifference(root, value);	
		}
	}

	@Override
	public void printByLevels() {
		int height = heightOfBST(root);
		
		for(int i = 1; i <= height; i++) {
			System.out.print("Depth " + (i-1) + ": ");
			printOneLevel(root, i);
			System.out.println("");
		}

	}
	
	public void printOneLevel(Node n, int depth) {
		if (n == null ) {
			return;
		}
		if(depth == 1) {
			System.out.print(n.key);
			System.out.print(" ");
		}
		else if(depth > 1) {
			printOneLevel(n.left, depth - 1);
			printOneLevel(n.right, depth - 1);
		}
	}

	public Node searchForNode(Node searchNode, Integer key) {
		if (searchNode == null) {
			return null;
		} else {
			if (searchNode.key > key) {
				return searchForNode(searchNode.left, key);
			} else if (searchNode.key < key) {
				return searchForNode(searchNode.right, key);
			}
			return searchNode;
		}

	}

	public boolean containsNode(Integer key) {
		if (searchForNode(root, key) == null) {
			return false;
		}
		else if (searchForNode(root, key).key == key) {
			return true;
		}
		else {
			return false;
		}
	}

	public Integer searchDifference(Node root, Integer key) {
		Integer min = Integer.MAX_VALUE;
		Integer difference;
		Node closestNode = null;
		Node temp = root;
		while (root != null) {
			if (key > root.key) {
				difference = Math.abs(root.key - key);
				if (difference < min) {
					min = difference;
					closestNode = root;
				}
				if(root.right == null) {
					return closestNode.key;
				} else {
				root = root.right;
				}
			} else if (key < root.key) {
				difference = Math.abs(root.key - key);
				if(difference < min) {
					min = difference;
					closestNode = root;
				}
				if (root.left == null) {
					return closestNode.key;
				} else {
				root = root.left;
				}
				
			} else {
				return root.key;
			}
		}
		return null;

	}
	
	public int heightOfBST(Node rootLevel) {
		if (rootLevel == null) {
			return -1;
		}
		
		int leftSide = 0;
		int rightSide = 0;
		
		if(rootLevel.left != null) {
			leftSide = heightOfBST(rootLevel.left);
		}
		if(rootLevel.right != null) {
			rightSide = heightOfBST(rootLevel.right);
		}
		if (leftSide > rightSide) {
			return leftSide + 1;
		}
		else {
			return rightSide + 1;
		}
	}
	
	public Node insertElement(Node n, Integer key) {
		if(n == null) {
            n = new Node(key);
		}
        else if(n.key > key) {
        	
           n.left = insertElement(n.left, key);
        }
        else if(n.key < key) {
        	
           n.right = insertElement(n.right, key);
        }
		return n;
	}

	private class Node {
		Integer key;
		Node left;
		Node right;

		public Node(Integer key) {
			this.key = key;
			left = null;
			right = null;
		}
	}

}
