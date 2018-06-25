package A3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaerBaumTest {

	BinaryTree b;
	BinaryTree notBalanced;
	
	@BeforeEach
	void setUp() throws Exception {
		b = new BinaryTree();
		b.insert(52);
		b.insert(25);
		b.insert(67);
		b.insert(36);
		b.insert(59);
		b.insert(69);
		b.insert(12);
		
		notBalanced = new BinaryTree();
		notBalanced.insert(52);
		notBalanced.insert(36);
		notBalanced.insert(25);
		notBalanced.insert(12);
		notBalanced.insert(67);
		
		
		
	}

	@Test
	void test() {
		assertTrue(b.isBalanced(b.getRoot()));
		assertFalse(notBalanced.isBalanced(notBalanced.getRoot()));
	}

}
