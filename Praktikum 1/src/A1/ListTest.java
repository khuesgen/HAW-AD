package A1;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListTest {
	
	public ArrayList<Integer> list;
	
	
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
		
		
	}

	@Test
	void test() {
		
		assertEquals(7, list.getLength());
		assertEquals(list.extract(3, 6).getLength(), 4);
	}

}
