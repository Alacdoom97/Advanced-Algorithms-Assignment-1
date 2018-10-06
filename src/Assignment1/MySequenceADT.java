package Assignment1;

public class MySequenceADT implements A1SequenceWithMinimum {

	private Node root;
	private Node left;
	private Node right;

	public MySequenceADT() {
		this.root = null;
	}

	@Override
	public void insertRight(Integer value) {
		if (root == null) {
			root = new Node(value);
			left = root;
			right = root;
		} else {
			Node inserted = new Node(value);
			inserted.left = right;
			right.right = inserted;
			right = inserted;
		}
	}

	@Override
	public Integer removeRight() {
		if (right == null) {
			System.err.println("There is nothing in the list.");
			return null;
		} else {
			Integer rightmost = right.value;
			right = right.left;
			right.right = null;
			return rightmost;
		}
	}

	@Override
	public void insertLeft(Integer value) {
		if (root == null) {
			root = new Node(value);
			left = root;
			right = root;
		} else {
			Node inserted = new Node(value);
			inserted.right = left;
			left.left = inserted;
			left = inserted;
		}
	}

	@Override
	public Integer removeLeft() {
		if (left == null) {
			System.err.println("There is nothing in the list.");
			return null;
		} else {
			Integer leftmost = left.value;
			left = left.right;
			left.left = null;
			return leftmost;
		}
	}

	@Override
	/*This method can start from either right or left
	 * and it wont change the time complexity as its using
	 * the same method for each*/
	public Integer findMinimum() {
		Integer min = null;
		Node now = right;
		while (now.left != null) {
			if (min == null) {
				min = now.value;
			} else if (min > now.value) {
				min = now.value;
			}
			now = now.left;
		}
		if (min > now.value) {
			min = now.value;
			return min;
		}
		return min;
	}
	
	public void iterateSequencePrint() {
		Node now = left;
		while(now.right != null) {
			System.out.print(now.value);
			System.out.print(" ");
			now = now.right;
		}
		System.out.print(now.value);
		System.out.println("");
	}

	private class Node {
		Integer value;
		Node left;
		Node right;

		public Node(Integer value) {
			this.value = value;
			left = null;
			right = null;
		}
	}

}
