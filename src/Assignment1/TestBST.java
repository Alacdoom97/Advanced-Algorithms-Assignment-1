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
		bst.insert(39);
		bst.insert(42);
		bst.insert(2);
		bst.insert(8);
		bst.insert(15);
		bst.insert(16);
		bst.insert(99);
		bst.insert(13);
		bst.insert(29);
		bst.insert(55);
		bst.insert(65);
		bst.insert(49);
		bst.insert(81);
		bst.insert(999);
		bst.printByLevels();
	}

}
