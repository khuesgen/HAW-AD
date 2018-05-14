package A1;

public class DoubleLinkedListTest {
	
	public static void main(String[] args) {
		
		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		dll.insertAt(0, 1);
		System.out.println(dll.toString());
		
		dll.insertAt(1, 2);
		System.out.println(dll.toString());
		
		dll.insertAt(0, 5);
		System.out.println(dll.toString());
		
		dll.insertAt(3, 99);
		System.out.println(dll.toString());
		
		System.out.println(dll.getLink(1).getPrevious());
		System.out.println(dll.getLink(2).getPrevious());
		
		dll.insertAt(2, 150);

		System.out.println(dll.toString());
		
		IList<Integer> test = dll.extract(1,4);
		System.out.println("Neue Liste: " + test.toString());
		
	}

}
