package A1;

import java.util.concurrent.ThreadLocalRandom;

public class Performance {

	private DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
	private ArrayList<Integer> al = new ArrayList<Integer>(Integer.class);
	private long startTime;
	private long testTime;

	public void testreihe1AL() {

		System.out.println("Testreihe ArrayList");

		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 30000; j++) {
				al.insertAt(0, ThreadLocalRandom.current().nextInt(0, 100));
			}
			al.clear();
		}
		testTime = System.currentTimeMillis() - startTime;
		System.out.println("Test: 30000 Zufalls Elemente am Anfang einfügen. \n Dauer:" + testTime
				+ "ms \n Dauer pro Durchlauf: " + (testTime / 10) + "ms");

		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 30000; j++) {
				al.insertAt(j, ThreadLocalRandom.current().nextInt(0, 100));
			}
			al.clear();
		}
		testTime = System.currentTimeMillis() - startTime;
		System.out.println("Test: 30000 Zufalls Elemente am Ende einfügen. \n Dauer:" + testTime
				+ "ms \n Dauer pro Durchlauf: " + (testTime / 10) + "ms");

		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			al.insertAt(0, 1);
			for (int j = 1; j < 30000; j++) {
				int x = ThreadLocalRandom.current().nextInt(0, j);
				al.insertAt(x, ThreadLocalRandom.current().nextInt(0, 100));
			}
			al.clear();
		}
		testTime = System.currentTimeMillis() - startTime;
		System.out.println("Test: 30000 Zufalls Elemente zufällig einfügen. \n Dauer:" + testTime
				+ "ms \n Dauer pro Durchlauf: " + (testTime / 10) + "ms");
	}

	public void testreihe1DLL() {

		System.out.println("Testreihe DoubleLinkedList");

		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 30000; j++) {
				dll.insertAt(0, ThreadLocalRandom.current().nextInt(0, 100));
			}
			dll.clear();
		}
		testTime = System.currentTimeMillis() - startTime;
		System.out.println("Test: 30000 Zufalls Elemente am Anfang einfügen. \n Dauer:" + testTime
				+ "ms \n Dauer pro Durchlauf: " + (testTime / 10) + "ms");

		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 30000; j++) {
				dll.insertAt(j, ThreadLocalRandom.current().nextInt(0, 100));
			}
			dll.clear();
		}
		testTime = System.currentTimeMillis() - startTime;
		System.out.println("Test: 30000 Zufalls Elemente am Ende einfügen. \n Dauer:" + testTime
				+ "ms \n Dauer pro Durchlauf: " + (testTime / 10) + "ms");

		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			dll.insertAt(0, 1);
			for (int j = 1; j < 30000; j++) {
				int x = ThreadLocalRandom.current().nextInt(0, j);
				dll.insertAt(x, ThreadLocalRandom.current().nextInt(0, 100));
			}
			dll.clear();
		}
		testTime = System.currentTimeMillis() - startTime;
		System.out.println("Test: 30000 Zufalls Elemente zufällig einfügen. \n Dauer:" + testTime
				+ "ms \n Dauer pro Durchlauf: " + (testTime / 10) + "ms");
	}

	public void testReihe2AL() {

		System.out.println("Testreihe ArrayList Löschen");

		
		for (int j = 0; j < 30000; j++) {
			al.insertAt(0, ThreadLocalRandom.current().nextInt(0, 100));
		}
		startTime = System.currentTimeMillis();
		
		for (int j = 0; j < 1000; j++) {
			al.deleteAt(0);
		}
		
		testTime = System.currentTimeMillis() - startTime;
		System.out.println("Test: 1000 Zufalls Elemente am Anfang löschen. \n Dauer:" + testTime*10
				+ "ms \n Dauer pro Durchlauf: " + (testTime ) + "ms");
		
		startTime = System.currentTimeMillis();
		for (int j = 0; j < 1000; j++) {
			al.deleteAt(ThreadLocalRandom.current().nextInt(0, al.getLength()));
		}
		
		testTime = System.currentTimeMillis() - startTime;
		System.out.println("Test: 1000 Zufalls Elemente zufällig löschen. \n Dauer:" + testTime*10
				+ "ms \n Dauer pro Durchlauf: " + (testTime ) + "ms");
		
		startTime = System.currentTimeMillis();
		for (int j = 0; j < 1000; j++) {
			al.deleteAt(al.getLength()-1);
		}
		testTime = System.currentTimeMillis() - startTime;
		System.out.println("Test: 1000 Zufalls Elemente am Ende löschen. \n Dauer:" + testTime *10
				+ "ms \n Dauer pro Durchlauf: " + (testTime ) + "ms");
	}
	
	public void testReihe2DLL() {

		System.out.println("Testreihe DoubleLinkedList Löschen");

		
		for (int j = 0; j < 30000; j++) {
			dll.insertAt(0, ThreadLocalRandom.current().nextInt(0, 100));
		}
		startTime = System.currentTimeMillis();
		
		for (int j = 0; j < 1000; j++) {
			dll.deleteAt(0);
		}
		
		testTime = System.currentTimeMillis() - startTime;
		System.out.println("Test: 1000 Zufalls Elemente am Anfang löschen. \n Dauer:" + testTime *10
				+ "ms \n Dauer pro Durchlauf: " + (testTime) + "ms");
		
		startTime = System.currentTimeMillis();
		for (int j = 0; j < 1000; j++) {
			dll.deleteAt(ThreadLocalRandom.current().nextInt(0, dll.getLength()));
		}
		
		testTime = System.currentTimeMillis() - startTime;
		System.out.println("Test: 1000 Zufalls Elemente zufällig löschen. \n Dauer:" + testTime *10
				+ "ms \n Dauer pro Durchlauf: " + (testTime) + "ms");
		
		startTime = System.currentTimeMillis();
		for (int j = 0; j < 1000; j++) {
			dll.deleteAt(dll.getLength()-1);
		}
		testTime = System.currentTimeMillis() - startTime;
		System.out.println("Test: 1000 Zufalls Elemente am Ende löschen. \n Dauer:" + testTime *10
				+ "ms \n Dauer pro Durchlauf: " + (testTime) + "ms");
	}

	public static void main(String[] args) {
		Performance pf = new Performance();
		pf.testreihe1AL();
		pf.testreihe1DLL();
		pf.testReihe2AL();
		pf.testReihe2DLL();
	}
}
