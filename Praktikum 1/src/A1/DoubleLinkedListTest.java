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
		dll.deleteAt(1);
		System.out.println(dll.toString());
		dll.deleteAt(3);
		System.out.println(dll.toString());
		dll.deleteAt(0);
		System.out.println(dll.toString());
		dll.clear();
		System.out.println("Empty: " + dll.toString());
		
		
		
		
		
		DoubleLinkedList<Integer> dll1 = new DoubleLinkedList<Integer>();
		dll1.insertAt(0, 1);	
		dll1.insertAt(1, 2);
		dll1.insertAt(2, 3);
		dll1.insertAt(3, 99);
		System.out.println(dll1.toString());
		
		DoubleLinkedList<Integer> dll2 = new DoubleLinkedList<Integer>();
		dll2.insertAt(0, 3);	
		dll2.insertAt(1, 2);
		dll2.insertAt(2, 1);
		dll2.insertAt(3, 99);
		System.out.println(dll2.toString());
		
		dll1.concat(dll2);
		System.out.println(dll1.toString());
		
		
		ArrayList<Integer> list = new ArrayList<Integer>(Integer.class);
		list.insertAt(0, 1);
		list.insertAt(1, 2);
		list.insertAt(2, 3);
		list.insertAt(3, 4);
		list.insertAt(4, 5);
		list.insertAt(5, 6);
		list.insertAt(6, 7);
		System.out.println(list.toString());
		
		dll1.concat(list);
		System.out.println(dll1.toString());
	}

}
