package A2;

public class BBaumLoesung <T extends Comparable<T>, U> extends BBaum<T, U> {

	public BBaumLoesung(int ordnung) {
		super(ordnung);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void einfuegen(T schluessel, U wert) {
		SchluesselWertPaar<T, U> element = new SchluesselWertPaar<T, U>(schluessel, wert);
		
		if (wurzel == null) {
			wurzel = new BBaumKnoten<T, U>(element);
		} else {
			//TODO
		}
	}

}
