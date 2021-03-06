package A1;

import java.lang.reflect.Array;
import java.util.Arrays;

@SuppressWarnings("all")
public class ArrayList<E> implements IList<E> {

	private E[] ary;
	private final int ARRAY_LENGTH = 0;

	/**
	 * Konstruktor mit �bergebener L�nge.
	 * 
	 * @param clazz
	 * @param length
	 */
	public ArrayList(Class<E> clazz, int length) {
		ary = (E[]) Array.newInstance(clazz, length);
	}

	/**
	 * Konstruktor ohne �bergebener L�nge, diese wird dann dem Standartwert
	 * zugewiesen.
	 * 
	 * @param clazz
	 */
	public ArrayList(Class<E> clazz) {
		ary = (E[]) Array.newInstance(clazz, ARRAY_LENGTH);
	}

	@Override
	public int getLength() {
		return ary.length;
	}

	@Override
	public void deleteAt(int index) {
		if (ary.length == 0 || ary.length < index) {
			throw new IllegalArgumentException();
		}

		@SuppressWarnings("unchecked")
		E[] temp = (E[]) Array.newInstance(this.ary[0].getClass(), this.getLength() - 1);
		int j = 0;
		for (int i = 0; i < ary.length; i++) {
			if (i != index) {
				temp[j] = ary[i];
				j++;
			}
		}

		ary = temp;
	}

	@Override
	public E getElem(int index) {
		if (ary.length == 0 || ary.length < index) {
			throw new IllegalArgumentException();
		}
		return ary[index];
	}

	@Override
	public void clear() {
		if (ary.length != 0) {
			E[] temp = (E[]) Array.newInstance(this.ary[0].getClass(), 0);
			ary = temp;
		}
	}

	@Override
	public IList<E> extract(int i1, int i2) {
		if (!(i1 >= 0 && i1 < i2 && i2 < ary.length)) {
			throw new IllegalArgumentException();
		}

		// Temporäre neue Klasse
		@SuppressWarnings("unchecked")
		ArrayList<E> newal = new ArrayList(ary.getClass().getComponentType());

		// Einfügen der Werte inklusiv i1 bis inklusiv i2
		for (int i = 0; (i1 + i) <= i2; i++) {
			newal.insertAt(i, this.getElem(i1 + i));
		}

		return newal;
	}

	@Override
	public void insertAt(int index, E elem) throws IllegalArgumentException {
		if (!(index >= 0 && index <= ary.length)) {
			throw new IllegalArgumentException();
		}

		// if (elem.getClass() != list.getClass()) {
		// throw new IllegalArgumentException("Falscher Typ!");
		// }
		
		E[] temp = (E[]) Array.newInstance(ary.getClass().getComponentType(), ary.length + 1);
		int count = this.getLength();
		
		for (int i = 0; i < index; i++) {
			temp[i] = getElem(i);
		}
		temp[index] = elem;

		for (int i = index; i < count; i++) {
			temp[i + 1] = getElem(i);
		}
		
		ary = temp;
	}

	@Override
	public IList<E> concat(IList<E> list) throws IllegalArgumentException {

		for (int i = 0; i < list.getLength(); i++) {
			this.insertAt(ary.length, list.getElem(i));
		}
		return this;
	}

	/**
	 * Gibt die Liste in lesbarer Form zur�ck.
	 */
	public String toString() {
		return Arrays.toString(ary);
	}

}
