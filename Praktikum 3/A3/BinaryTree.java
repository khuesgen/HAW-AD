package A3;

public class BinaryTree {
	
	private Node root = null;
	
	public BinaryTree(Node root) {
		this.root = root;
	}
	
	public BinaryTree() {
		
	}
	 /**
	  * Fügt einen Wert ein
	  * @param value
	  */
	public void insert(int value) {
		Node temp = new Node(value);
		if (root == null) {
			this.root = temp;
		} else {
			Node parent = findValue(value);
			
			if (value < parent.getValue()) {
				parent.setLeft(temp);
				temp.setParent(parent);
			} else {
				parent.setRight(temp);
				temp.setParent(parent);
			}
		}
	}
	
	/**
	 * Methode um einen Wert zu finden
	 * @param value
	 * @return
	 */
	public Node findValue(int value) {
		Node temp = root;
		while (temp != null) {
			if (value < temp.getValue()) {
				if (temp.getLeft() == null) {
					return temp;
				}
				temp = temp.getLeft();
			} else if (value > temp.getValue()) {
				if (temp.getRight() == null) {
					return temp;
				}
				temp = temp.getRight();
			}
			else {
				return temp;
			}
		}
		return temp;
	}
	
	/**
	 *  Prüfe rekursiv ob ein Baum höhenbalanciert ist (Die Zweige dürfen nur einen Höhenunterschied von 1 haben)
	 * @param node
	 * @return
	 */
	public boolean isBalanced(Node node) {
		int leftHeight;
		int rightHeight;
		
		if (node == null) {
			return true;
		}
		
		leftHeight = getHeight(node.getLeft());
		rightHeight = getHeight(node.getRight());
		
		if (Math.abs(leftHeight - rightHeight) <= 1
				&& isBalanced(node.getLeft()) && isBalanced(node.getRight())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Gibt rekursiv die Höhe der einzelnen Knoten aus
	 * @param node
	 * @return
	 */
	public int getHeight(Node node) {
		if (node == null) {
			return 0;
		}
		
		return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
	}
	
	public Node getRoot() {
		return root;
	}
	
		
	public class Node {
		
		private Node parent = null;
		private Node left = null;
		private Node right = null;
		private int value;
				
		public Node(int value) {
			this.value = value;
		}
		
		public void setLeft(Node left) {
			this.left = left;
		}
		
		public void setRight(Node right) {
			this.right = right;
		}
		
		public  Node getLeft() {
			return left;
		}
		
		public Node getRight() {
			return right;
		}
		
		public int getValue() {
			return value;
		}
		
		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public boolean isLeaf() {
			return (left == null && right == null);
		}
		
		public boolean isRoot() {
			return (parent == null);
		}
		
	}

}
