package A1;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListTest {
	
	public ArrayList<Integer> list;
	public ArrayList<Integer> list2;
	public DoubleLinkedList<Integer> doublelist;
	public DoubleLinkedList<Integer> doublelist2;
	
	@BeforeEach
	void setUp() throws Exception {
		list = new ArrayList<Integer>(Integer.class);
		list.insertAt(0, 1);
		list.insertAt(1, 2);
		list.insertAt(2, 3);
		list.insertAt(3, 4);
		list.insertAt(4, 5);
		list.insertAt(5, 6);
		list.insertAt(6, 7);
		
		list2 = new ArrayList<Integer>(Integer.class);
		list2.insertAt(0,8);
		list2.insertAt(1, 9);
		list2.insertAt(2, 10);
		
		doublelist = new DoubleLinkedList<Integer>();
		doublelist2 = new DoubleLinkedList<Integer>();
		
		doublelist.insertAt(0, 9);
		doublelist.insertAt(1, 8);
		doublelist.insertAt(2, 7);
		doublelist.insertAt(3, 6);
		
		
		doublelist2.insertAt(0, 5);
		doublelist2.insertAt(1, 4);
		doublelist2.insertAt(2, 3);
				
	}

	@Test
	void basicTest() {	
		
		// ArrayList Tests
		assertEquals(7, list.getLength());
		assertEquals(4, list.extract(3, 6).getLength());
		
		list.concat(list2);
		assertEquals(10, list.getLength());
		
		assertEquals(new Integer(9), list.getElem(8));
		
		list.deleteAt(9);
		assertEquals(9,list.getLength());
		
		assertEquals(new Integer(9), list.getElem(8));
		
		list.insertAt(0, 5);
		assertEquals(new Integer(5), list.getElem(0));
		
		list.clear();
		assertEquals(0, list.getLength());
		
		
		// DoubleLinkedList test
		assertEquals(4, doublelist.getLength());
		assertEquals(3, doublelist2.getLength());
		
		assertEquals(new Integer(9), doublelist.getElem(0));
		assertEquals(new Integer(7), doublelist.getElem(2));
		
		doublelist.insertAt(0, 10);
		assertEquals(new Integer(10), doublelist.getElem(0));
		
		doublelist.insertAt(4, 5);
		assertEquals(new Integer(5), doublelist.getElem(4));
		
		doublelist.deleteAt(0);
		assertEquals(new Integer(9), doublelist.getElem(0));
		
		doublelist.deleteAt(2);
		assertEquals(new Integer(5), doublelist.getElem(2));
		
		assertEquals(2, doublelist.extract(0, 1).getLength());
		assertEquals(3, doublelist.extract(0, 2).getLength());
		
		doublelist.concat(doublelist2);
		assertEquals(7, doublelist.getLength());
		
		
		// Test zwischen DoubleLinkedList & ArrayList
		
		doublelist2.clear();
		doublelist2.insertAt(0, 5);
		doublelist2.insertAt(1, 4);
		doublelist2.insertAt(2, 3);
	
		
		doublelist2.concat(list2);
		assertEquals(6, doublelist2.getLength());
		
		list2.concat(doublelist2);
		assertEquals(9, list2.getLength()); // 9 da vorher schon concat 
		
		assertEquals(new Integer(8), doublelist2.getElem(3));
		
		assertEquals(new Integer(10), doublelist2.getElem(5));
		
		doublelist2.clear();
		assertEquals(0, doublelist2.getLength());
		
		list2.clear();
		assertEquals(0, list2.getLength());
	}
	
	@Test
	public void exceptionTest() {
		assertThrows(IllegalArgumentException.class,
		()->{	
			
			list.extract(-1, 0);
			list.getElem(100);
			list.deleteAt(100);
			list.insertAt(100, 5);
			
			doublelist.insertAt(-1, 5);
			doublelist.getElem(-1);
			doublelist.getElem(100);
			doublelist.deleteAt(100);
			doublelist.extract(-1, 100);
			
		}		
		);
	}

}
