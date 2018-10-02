package Assignment1;

public class MyIntegerBST implements A1Tree {

	private Node root = null;

	public MyIntegerBST() {
		this.root = null;
	}

	@Override
	public void insert(Integer value) {
		Node addNode = new Node(value);

		if (root == null) {
			root = addNode;
			return;
		} else if (!containsNode(value)) {
			Node now = root;
			Node parent = null;
			while (true) {
				parent = now;
				if (value < now.key) {
				}
				now = now.left;
				if (now == null) {
					parent.left = addNode;
					return;

				} else if (value > now.key) {
					parent.right = addNode;
				}
			}
		} else {
			System.err.println("You have inserted a duplicate integer, please insert another integer.");
		}

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
		// TODO Auto-generated method stub

	}

	public Node searchForNode(Node searchNode, Integer key) {
		if (searchNode == null) {
			return null;
		} else {
			if (searchNode.key > key) {
				searchForNode(searchNode.left, key);
			} else if (searchNode.key < key) {
				searchForNode(searchNode.right, key);
			}
			return searchNode;
		}

	}

	public boolean containsNode(Integer key) {
		if (searchForNode(root, key).key == key)
			return true;
		else
			return false;
	}

	public Integer searchDifference(Node root, Integer key) {
		Integer min = Integer.MAX_VALUE;
		Integer difference;
		Node closestNode = null;
		Node temp = root;
		while (root != null) {
			if (key > temp.key) {
				difference = Math.abs(temp.key - key);
				if (difference < min) {
					min = difference;
					closestNode = temp;
				}
				temp = temp.right;
			} else if (key < temp.key) {
				difference = Math.abs(temp.key - key);
				if(difference < min) {
					min = difference;
					closestNode = temp;
				}
				temp = temp.left;
			} else {
				return temp.key;
			}
		}
		return null;

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
