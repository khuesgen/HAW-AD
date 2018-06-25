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
			einfügenrekursiv(element, wurzel);
		}
	}

	public void einfügenrekursiv(SchluesselWertPaar<T, U> element, BBaumKnoten<T, U> knoten) {

		if (knoten.istBlattknoten()) {
			
			if (knoten.getAnzahlSchluesselWertPaare() >= ((2 * ordnung) -1)) {
				teilen(knoten);
				einfügenrekursiv(element, wurzel);
			}

			for (int i = 0; i < knoten.getAnzahlSchluesselWertPaare(); i++) {

				if (element.getSchluessel().compareTo(knoten.getSchluesselWertPaar(i).getSchluessel()) == -1) {
					knoten.addSchluesselWertPaar(i, element);
					break;

				} else if (i + 1 == knoten.getAnzahlSchluesselWertPaare()
						&& element.getSchluessel().compareTo(knoten.getSchluesselWertPaar(i).getSchluessel()) == 1) {
					knoten.addSchluesselWertPaar(i + 1, element);
				}

			}

		} else {

			for (int i = 0; i < knoten.getAnzahlSchluesselWertPaare(); i++) {

				if (element.getSchluessel().compareTo(knoten.getSchluesselWertPaar(i).getSchluessel()) == -1) {
					einfügenrekursiv(element, knoten.getKind(i));
					break;

				} else if (i + 1 == knoten.getAnzahlSchluesselWertPaare()
						&& element.getSchluessel().compareTo(knoten.getSchluesselWertPaar(i).getSchluessel()) == 1) {
					einfügenrekursiv(element, knoten.getKind(i + 1));
				}
			}
		}
	}
	
	
	public void teilen(BBaumKnoten<T, U> knoten) {
		
		BBaumKnoten<T, U> left = new BBaumKnoten<T, U>(knoten.getSchluesselWertPaar(0));
		BBaumKnoten<T, U> right = new BBaumKnoten<T, U>(knoten.getSchluesselWertPaar(2));
		
		if (knoten.getElternknoten() == null) {
			BBaumKnoten<T, U> neueWurzel = new BBaumKnoten<T, U>(knoten.getSchluesselWertPaar(1));
			neueWurzel.setKind(0, left);
			neueWurzel.setKind(1, right);
			this.wurzel = neueWurzel;
			
		} else {
			
			if (knoten.getElternknoten().getAnzahlSchluesselWertPaare() >= ((2 * ordnung) -1)) {
				teilen(knoten.getElternknoten());
			}
			
			for (int i = 0; i < knoten.getElternknoten().getAnzahlSchluesselWertPaare(); i++) {
				if (knoten.getElternknoten().getKind(i).equals(knoten)) {
					knoten.getElternknoten().addSchluesselWertPaar(i, knoten.getSchluesselWertPaar(1));
					knoten.getElternknoten().setKind(i, left);
					knoten.getElternknoten().setKind(i + 1, right);	
				}
			}	
		}	
	}
}
