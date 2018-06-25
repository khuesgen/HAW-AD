package A1;

import java.util.Arrays;

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
		if (links < rechts) {
			int pivotElement = pivotStrategy.getIndex(a, links, rechts);
			System.out.println(pivotElement);
			int i = partition(a, links, rechts, pivotElement);
			quicksort(a, links , i-1);
			quicksort(a, i +1 , rechts);
		}
		
	}
	
	// https://de.wikiversity.org/wiki/Kurs:Algorithmen_und_Datenstrukturen/Vorlesung/QuickSort#Pivot_Element
	// CompareTo -1 = kleiner, 0 = gleich, 1 = größer
	private int partition(SchluesselWertPaar<T, U>[] a, int links, int rechts, int pivotElement) {
		T pivot = a[pivotElement].getSchluessel();
		System.out.println("Pivotelement: " + pivot);
		while (links < rechts) {
			
			// ELement ist kleiner als Pivot-Element
			while (a[links].getSchluessel().compareTo(pivot) < 0) {
				System.out.println("Erhöhe Links");
				links++;
			} 
			
			// Element ist größer als Pivot-Element
			while (a[rechts].getSchluessel().compareTo(pivot) > 0) {
				System.out.println("Verringere Rechts");
				rechts--;
			} 
			
			// Element gefunden, tausche 
			if (links < rechts) {
				System.out.println("Tausche");
				SchluesselWertPaar<T, U> temp = a[links];
				a[links] = a[rechts];
				a[rechts] = temp;
			} 
			
			// Falls wir zwei gleiche Elemente haben und/oder das Pivotelement
			if (a[links].getSchluessel().compareTo(a[rechts].getSchluessel()) == 0 
					&& a[links].getSchluessel().compareTo(pivot) == 0  && links < rechts) {
				links++;
			}
			
			System.out.println("Durchgang beendet!");
			System.out.println("Links: " + links);
			System.out.println("Rechts: " + rechts);
			System.out.println(Arrays.toString(a));
		
		}
		return links;
	}
		
}
