/**
 * 
 */
package A1;

/**
 * @author Kevin Hüsgen
 *
 */
public class PivotStrategieMedian implements PivotStrategie{

	/* (non-Javadoc)
	 * @see A1.PivotStrategie#getIndex(A1.SchluesselWertPaar[], int, int)
	 */
	@Override
	public <T extends Comparable<T>, U> int getIndex(SchluesselWertPaar<T, U>[] a, int iLinks, int iRechts) {
		T erstesElement = a[iLinks].getSchluessel();
		T mittleresElement = a[((iLinks + iRechts) /2 )].getSchluessel();
		T letztesElement = a[iRechts].getSchluessel();
		
		// erstes Element größer als mittleres aber kleiner als letztes und vice versa
		if ((erstesElement.compareTo(mittleresElement) >= 0 && erstesElement.compareTo(letztesElement) <= 0) 
				|| (erstesElement.compareTo(letztesElement) >= 0 && erstesElement.compareTo(mittleresElement) <= 0)) {
				return iLinks;
		}
		
		// mittleres Element größer als erstes und kleiner als letztes und vice versa
		if ((mittleresElement.compareTo(erstesElement) >= 0 && mittleresElement.compareTo(letztesElement) <=0)
				|| mittleresElement.compareTo(letztesElement) >= 0 && mittleresElement.compareTo(erstesElement) <= 0) {
			return ((iLinks + iRechts) / 2);
		}
		
		// letztes Element größer als erstes und kleiner als mittleres und vice versa
		if ((letztesElement.compareTo(erstesElement) >= 0 && letztesElement.compareTo(mittleresElement) <= 0) 
				|| letztesElement.compareTo(mittleresElement) >= 0 && letztesElement.compareTo(erstesElement) <= 0) {
			return iRechts;
		}
		
		return 0;
	
	}

}
