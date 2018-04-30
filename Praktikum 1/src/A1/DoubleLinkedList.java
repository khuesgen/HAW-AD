/**
 * 
 */
package A1;

/**
 * @author Kevin Hüsgen
 *
 */
public class DoubleLinkedList<E> implements IList<E>{
	
	private Link head;
	private Link tail;
	
	public DoubleLinkedList() {
			head = null;
			tail = null;
	}

	/* (non-Javadoc)
	 * @see A1.IList#getLength()
	 */
	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see A1.IList#insertAt(int, java.lang.Object)
	 */
	@Override
	public void insertAt(int index, Object elem) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see A1.IList#deleteAt(int)
	 */
	@Override
	public void deleteAt(int index) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see A1.IList#getElem(int)
	 */
	@Override
	public E getElem(int index) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see A1.IList#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see A1.IList#concat(A1.IList)
	 */
	@Override
	public IList<E> concat(IList<E> list) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see A1.IList#extract(int, int)
	 */
	@Override
	public IList<E> extract(int i1, int i2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
	
	class Link{
		public E value;
		public Link next;
		public Link previous;
		
		public Link(E value) {
			this.value = value;
		}
	}

}
