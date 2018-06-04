package A3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Database {

	public static String csvFile = "./resources/StaedteStatistik.csv";
	public static String cvsSplitBy = ";";

	public static int count = 0;

	static List<CityData> citylist = new ArrayList<CityData>();
	public static Integer[] postcode;
	public static Integer[] area;
	public static Integer[] population;
	public static Integer[] male;
	public static Integer[] female;

	/**
	 * Liest die Datensätze von in dem übergebenen Intervall von inklusiv from bis
	 * inklusiv to aus der .csv Datei aus.
	 * 
	 * @param from
	 * @param to
	 */
	public static void loadData(int from, int to) {
		int i = 0;
		String line;
		CityData cd;

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				if (from <= i && i <= to) {

					String[] row = line.split(cvsSplitBy);

					cd = parseRow(row, i);
					System.out.println(cd);
					citylist.add(cd);

					i++;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Eine parse-Funktion die aus einem übergebenen String Array ein CityData
	 * Objekt erstellt.
	 * 
	 * @param row
	 * @return
	 */
	public static CityData parseRow(String[] row, int id) {

		String name;
		int postcode;
		float area;
		Integer population;
		Integer male;
		Integer female;

		name = row[0];
		postcode = Integer.parseInt(row[1]);
		area = Float.parseFloat(row[2].replace(",", "."));

		if (row[3].matches("[^0-9]")) {
			population = 0;
		} else {
			population = Integer.parseInt(row[3].replace(" ", ""));
		}

		if (row[4].matches("[^0-9]")) {
			male = 0;
		} else {
			male = Integer.parseInt(row[4].replace(" ", ""));
		}

		if (row[5].matches("[^0-9]")) {
			female = 0;
		} else {
			female = Integer.parseInt(row[5].replace(" ", ""));
		}

		return new CityData(id, name, postcode, area, population, male, female);
	}

	public static void presort() {

		postcode = IntStream.rangeClosed(0, citylist.size() - 1).boxed().toArray(Integer[]::new);
		area = IntStream.rangeClosed(0, citylist.size() - 1).boxed().toArray(Integer[]::new);
		population = IntStream.rangeClosed(0, citylist.size() - 1).boxed().toArray(Integer[]::new);
		male = IntStream.rangeClosed(0, citylist.size() - 1).boxed().toArray(Integer[]::new);
		female = IntStream.rangeClosed(0, citylist.size() - 1).boxed().toArray(Integer[]::new);

		Arrays.sort(postcode, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(citylist.get(o1).getPostcode(), citylist.get(o2).getPostcode());
			}
		});

		Arrays.sort(area, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Float.compare(citylist.get(o1).getArea(), citylist.get(o2).getArea());
			}
		});

		Arrays.sort(population, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(citylist.get(o1).getPopulation(), citylist.get(o2).getPopulation());
			}
		});

		Arrays.sort(male, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(citylist.get(o1).getMale(), citylist.get(o2).getMale());
			}
		});

		Arrays.sort(female, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(citylist.get(o1).getFemale(), citylist.get(o2).getFemale());
			}
		});
	}

	public static Integer[] sortByPostcode(Integer[] ary, int min, int max) {

		Arrays.sort(ary, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(citylist.get(o1).getPostcode(), citylist.get(o2).getPostcode());
			}
		});

		Integer[] retary;

		int start = 0;
		int end = ary.length - 1;

		start = binarySearchPostcode(ary, min);
		end = binarySearchPostcode(ary, max);

		retary = Arrays.copyOfRange(ary, start, end);
		return retary;
	}

	public static int binarySearchPostcode(Integer[] ary, Integer key) {

		int retint = 0;

		int u = 0;
		int o = ary.length - 1;
		int m;

		while (u <= o) {
			m = (u + o) / 2;
			retint = m;
			if (citylist.get(ary[m]).getPostcode() == key) {
				retint = m;
				count++;
				break;
			} else {
				if (key < citylist.get(ary[m]).getPostcode()) {
					o = m - 1;
					count += 2;
				} else {
					u = m + 1;
					count += 2;
				}
			}
		}
		return retint;
	}

	public static Integer[] sortByArea(Integer[] ary, int min, int max) {

		Arrays.sort(area, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Float.compare(citylist.get(o1).getArea(), citylist.get(o2).getArea());
			}
		});

		Integer[] retary;

		int start = 0;
		int end = ary.length - 1;

		start = binarySearchArea(ary, min);
		end = binarySearchArea(ary, max);

		// TODO Fehler abfangen
		System.out.println(start);
		System.out.println(citylist.get(ary[start]).getArea());
		System.out.println(end);
		System.out.println(citylist.get(ary[end]).getArea());

		retary = Arrays.copyOfRange(ary, start, end);
		return retary;
	}

	public static int binarySearchArea(Integer[] ary, Integer min, Integer max) {

		if (ary[ary.length - 1] < min) {
			return -1;
		}

		int low = 0;
		int high = ary.length - 1;

		while (low <= high) {
			int mid = low + ((high - low) / 2);

			if (ary[mid] >= min)
				high = mid - 1;
			else // if(a[mid]<i)
				low = mid + 1;
		}

		return high + 1;

		
		
		
		
		
		
		int retint = 0;

		int u = 0;
		int o = ary.length - 1;
		int m;

		while (u <= o) {
			m = (u + o) / 2;
			retint = m;
			if (citylist.get(ary[m]).getArea() == key) {
				retint = m;
				count++;
				break;
			} else {
				if (key < citylist.get(ary[m]).getArea()) {
					o = m - 1;
					count += 2;
				} else {
					u = m + 1;
					count += 2;
				}
			}
		}
		return retint;
	}

	// public static Integer[] sortByPopulation(Integer[] ary, int min, int max) {
	//
	// Arrays.sort(ary, new Comparator<Integer>() {
	//
	// @Override
	// public int compare(Integer o1, Integer o2) {
	// return Integer.compare(citylist.get(o1).getPostcode(),
	// citylist.get(o2).getPostcode());
	// }
	// });
	//
	// Integer[] retary;
	//
	// int start = 0;
	// int end = ary.length -1;
	//
	// start = binarySearchPopulation(ary, min);
	// end = binarySearchPopulation(ary, max);
	//
	// System.out.println(start);
	// System.out.println(end);
	//
	//
	// retary = Arrays.copyOfRange(ary, start, end);
	// return retary;
	// }
	//
	// public static int binarySearchPopulation(Integer[] ary, Integer key) {
	//
	// int retint = 0;
	//
	// int u = 0;
	// int o = ary.length -1;
	// int m;
	//
	// while (u <= o) {
	// m = (u + o) / 2;
	// retint = m;
	// System.out.println(citylist.get(ary[m]).getPopulation());
	// if (citylist.get(ary[m]).getPopulation() == key) {
	// retint = m;
	// count++;
	// break;
	// } else {
	// if (key < citylist.get(ary[m]).getPopulation()) {
	// o = m - 1;
	// count += 2;
	// } else {
	// u = m + 1;
	// count += 2;
	// }
	// }
	// }
	// return retint;
	// }

	public static void main(String[] args) {
		loadData(0, 2057);
		presort();
		sortByPostcode(postcode, 50000, 60000);
		sortByArea(area, 200, 500);
		// sortByPopulation(population, 90000, 500000);
	}
}
