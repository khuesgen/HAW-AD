/**
 * 
 */
package A1;

import java.util.Random;

/**
 * @author Kevin Hüsgen
 *
 */
public class PivotStrategieZufallsPosition implements PivotStrategie {

	/* (non-Javadoc)
	 * @see A1.PivotStrategie#getIndex(A1.SchluesselWertPaar[], int, int)
	 */
	@Override
	public <T extends Comparable<T>, U> int getIndex(SchluesselWertPaar<T, U>[] a, int iLinks, int iRechts) {
		return iLinks + (int) (Math.random() * (iRechts - iLinks));
	}

}
