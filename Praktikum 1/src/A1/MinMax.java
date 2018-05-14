package A1;

public class MinMax {

	public static int min = Integer.MIN_VALUE;
	public static int max = Integer.MAX_VALUE;

	// Zählt die Vergleiche
	public static int count = 0;

	/**
	 * Enthält den MinMax-Algorithmus, setzt die Instanzvariablen min und max
	 * entsprechend.
	 * 
	 * @param ary
	 */
	public static void algo(int[] ary) {

		if (ary[0] < ary[1]) {
			min = ary[0];
			max = ary[1];
			
			count++;
		} else {
			min = ary[1];
			max = ary[0];
			count++;
		}
		
		for (int i = 2; i < ary.length; i++) {
			if (ary[i] < min) {
				min = ary[i];
				count++;
			} else if (ary[i] > max) {
				max = ary[i];
				count++;
			} else {
				count += 2;
			}
		}
	}

	public static void main(String[] args) {

		int[] peterMaffei = {1,1,1,1,1};
		algo(peterMaffei);
		System.out.println(count);
	}
}
