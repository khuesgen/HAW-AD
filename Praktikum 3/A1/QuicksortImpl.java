package A1;

public class QuicksortImpl<T extends Comparable<T>, U> extends Quicksort<T,U> {

	public QuicksortImpl(PivotStrategie pivotStrategy) {
		super(pivotStrategy);
	}

	
	@Override
	public void sortiere(SchluesselWertPaar<T, U>[] a) {
		int links = 0;
		int rechts =a.length - 1;
		
		quicksort(a, links, rechts);		
	}


	private void quicksort(SchluesselWertPaar<T, U>[] a, int links, int rechts) {
		// TODO Auto-generated method stub
		
	}

	
}
