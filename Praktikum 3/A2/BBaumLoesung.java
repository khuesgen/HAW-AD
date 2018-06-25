package A2;

public class BBaumLoesung<T extends Comparable<T>, U> extends BBaum<T, U> {

	public BBaumLoesung(int ordnung) {
		super(ordnung);
	}

	@Override
	public void einfuegen(T schluessel, U wert) {
		SchluesselWertPaar<T, U> element = new SchluesselWertPaar<T, U>(schluessel, wert);

		if (wurzel == null) {
			wurzel = new BBaumKnoten<T, U>(element);
		} else {
			einf�genrekursiv(element, wurzel);
		}
	}

	public void einf�genrekursiv(SchluesselWertPaar<T, U> element, BBaumKnoten<T, U> knoten) {

		if (knoten.istBlattknoten()) {
			// TODO

		} else {

			for (int i = 0; i < knoten.getAnzahlSchluesselWertPaare(); i++) {

				if (element.getSchluessel().compareTo(knoten.getSchluesselWertPaar(i).getSchluessel()) == -1) {
					einf�genrekursiv(element, knoten.getKind(i));
					break;

				} else if (i + 1 == knoten.getAnzahlSchluesselWertPaare()) {
					einf�genrekursiv(element, knoten.getKind(i + 1));
				}
			}

		}

	}

}
