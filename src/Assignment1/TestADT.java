package Assignment1;

public class TestADT {

	public static void main(String[] args) {
		MySequenceADT adt = new MySequenceADT();
		
		adt.insertRight(10);
		adt.insertLeft(12);
		adt.insertRight(5);
		adt.insertRight(21);
		adt.insertRight(6);
		adt.insertLeft(9);
		adt.insertLeft(2);
		adt.insertLeft(25);
		adt.iterateSequencePrint();
		System.out.println(adt.findMinimum());
		adt.iterateSequencePrint();
		adt.removeLeft();
		adt.removeRight();
		adt.iterateSequencePrint();
		
	}

}
