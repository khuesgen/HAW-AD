/**
 * 
 */
package A1;

/**
 * @author Kevin Hüsgen
 *
 */
public class DoubleLinkedList<E> implements IList<E> {

	// Referenziert den Anfang der Liste
	private Link head;

	// Referenziert das Ende der Liste
	private Link tail;

	// Länge der Liste
	private int length;

	public DoubleLinkedList() {
		head = null;
		tail = null;
		length = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see A1.IList#getLength()
	 */
	@Override
	public int getLength() {
		return length;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see A1.IList#insertAt(int, java.lang.Object)
	 */
	@Override
	public void insertAt(int index, Object elem) throws IllegalArgumentException {

		Link temp = new Link((E) elem);

		if (index > length || index < 0) {
			throw new IllegalArgumentException();
		}

		if (length == 0) {
			this.head = temp;
			this.tail = temp;		
		} else if ( index == length) {		
			tail.setNext(temp);
			temp.setPrevious(tail);
			this.tail = temp;
		} else if (index == 0) {
			Link oldPosition = head;
			
			this.head = temp;
			this.head.setNext(oldPosition);
			
			oldPosition.setPrevious(temp);
			
		} else {
			Link oldPosition = getLink(index);
			Link oldPositionPrevious = oldPosition.getPrevious();
			
			
			temp.setPrevious(oldPositionPrevious);		
			temp.setNext(oldPosition);
			
			oldPositionPrevious.setNext(temp);
			oldPosition.setPrevious(temp);
			
		}
			
		length++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see A1.IList#deleteAt(int)
	 */
	@Override
	public void deleteAt(int index) throws IllegalArgumentException {
		// TODO Auto-generated method stub

		length--;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see A1.IList#getElem(int)
	 */
	@Override
	public E getElem(int index) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see A1.IList#clear()
	 */
	@Override
	public void clear() {
		this.head = null;
		this.tail = null;

		length = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see A1.IList#concat(A1.IList)
	 */
	@Override
	public IList<E> concat(IList<E> list) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see A1.IList#extract(int, int)
	 */
	@Override
	public IList<E> extract(int i1, int i2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	public Link getLink(int i) {
		Link akt = head;

		for (int y = 0; y < i; y++) {
			akt = akt.next;
		}

	   return akt;
	}
	
	public String toString() {
		
		String toString = "";
		
		for (int i = 0; i < length; i++) {
			toString += getLink(i).getValue() + " -> ";
		}
		
		return toString;
	}

	class Link {

		public E value;
		public Link next;
		public Link previous;

		public Link(E value, Link next, Link previous) {
			this.value = value;
			this.next = next;
			this.previous = previous;
		}

		public Link(E value) {
			this.value = value;
		}

		public E getValue() {
			return value;
		}

		public void setValue(E value) {
			this.value = value;
		}

		public Link getNext() {
			return next;
		}

		public void setNext(Link next) {
			this.next = next;
		}

		public Link getPrevious() {
			return previous;
		}

		public void setPrevious(Link previous) {
			this.previous = previous;
		}

	}

}
