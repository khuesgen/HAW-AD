package A1;

import java.util.concurrent.ThreadLocalRandom;

public class Performance {
	
	private DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
	private ArrayList<Integer> al = new ArrayList<Integer>(Integer.class);
	private long startTime;
	private long testTime;

	
	
	public void testreihe1AL() {
		
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 30000; j++) {
				al.insertAt(0, ThreadLocalRandom.current().nextInt(0, 100));
			}
			System.out.println(i);
			al.clear();
		}
		testTime = System.currentTimeMillis() - startTime;
		System.out.println("Test: 30000 Zufalls Elemente am Anfang einfügen. \n Dauer:" + testTime +  "ms \n Dauer pro Durchlauf: " + (testTime / 10) +"ms");
		
		
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 30000; j++) {
				al.insertAt(j, ThreadLocalRandom.current().nextInt(0, 100));
			}
			System.out.println(i);
			al.clear();
		}
		testTime = System.currentTimeMillis() - startTime;
		System.out.println("Test: 30000 Zufalls Elemente am Ende einfügen. \n Dauer:" + testTime +  "ms \n Dauer pro Durchlauf: " + (testTime / 10) +"ms");

		
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			al.insertAt(0, 1);
			for (int j = 1; j < 30000; j++) {
				int x = ThreadLocalRandom.current().nextInt(0, j);
				al.insertAt(x, ThreadLocalRandom.current().nextInt(0, 100));
			}
			System.out.println(i);
			al.clear();
		}
		testTime = System.currentTimeMillis() - startTime;
		System.out.println("Test: 30000 Zufalls Elemente zufällig einfügen. \n Dauer:" + testTime +  "ms \n Dauer pro Durchlauf: " + (testTime / 10) +"ms");
	}
	
	public static void main(String[] args) {
		Performance pf = new Performance();
		pf.testreihe1AL();
	}
}
