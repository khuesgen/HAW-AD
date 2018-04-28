package A1;

/**
 * 
 * Interface f�r eine generische Liste
 * 
 * @author aby764
 *
 * @param <E>
 */
public interface IList<E> {
	
	/**
	 * 
	 * Gibt die L�nge der Liste zur�ck
	 * 
	 * @return
	 */
	
	public int getLength();
	
	/**
	 * 
	 * F�gt ein Element vom Typ E der Liste an der definierten Position index ein
	 * 
	 * @param index, elem
	 * @throws IllegalArgumentException
	 * 0 <=index <= getLength
	 */
	
	public void insertAt(int index, E elem) throws IllegalArgumentException;
	
	/**
	 * 
	 * L�scht ein Element aus der Liste an der angegebenen Position
	 * 
	 * @param index
	 * @throws IllegalArgumentException
	 *  0 <=index < getLength
	 */
	public void deleteAt(int index) throws IllegalArgumentException;
	
	
	/**
	 * 
	 * Gibt ein Element E an Position index zur�ck
	 * 
	 * @param index
	 * @return
	 * @throws IllegalArgumentException
	 *  0 <=index < getLength
	 */
	public E getElem(int index) throws IllegalArgumentException;
	
	/**
	 * 
	 * Leert die Liste
	 * 
	 */
	
	public void clear();
	
	/**
	 * 
	 * F�gt zwei Listen vom Typ E zusammen und gibt eine neue Liste zur�ck. Die zweite Liste wird am Ende der ersten Liste angef�gt.
	 * Falls die Typen der beiden Listen nicht übereinstimmen, wird eine IllegalArgumentException geworfen.
	 * 
	 * @param list
	 * @return
	 * @throws IllegalArgumentException
	 */
	
	public IList<E> concat(IList<E> list) throws IllegalArgumentException;
	
	/**
	 * 
	 * Gibt eine Subliste von Position inklusiv i1 bis inklusiv i2 zurück
	 * 
	 * @param i1
	 * @param i2
	 * @return
	 * @throws IllegalArgumentException
	 * 0 <= i1 < i2 < getLength
	 */
	public IList<E> extract(int i1, int i2) throws IllegalArgumentException;

}
