package Assignment1;

public class TestBST {

	public static void main(String[] args) {
		MyIntegerBST bst = new MyIntegerBST();
		
		bst.insert(10);
		bst.insert(7);
		bst.insert(20);
		bst.insert(4);
		bst.insert(9);
		bst.insert(25);
		bst.insert(8);
		bst.insert(20);
		System.out.println(bst.mostSimilarValue(24));

	}

}
