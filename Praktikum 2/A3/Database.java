package A3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import A3.Searchcriteria.Column;

public class Database {

	public static String csvFile = "./resources/StaedteStatistik.csv";
	public static String cvsSplitBy = ";";

	public static int count = 0;

	static List<CityData> citylist = new ArrayList<CityData>();
	public static Integer[] blank;
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
					// System.out.println(cd);
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

	public static int getData(int index, Column column) {

		switch (column) {

		case ZIP:
			return citylist.get(index).getPostcode();

		case AREA:
			return (int) (citylist.get(index).getArea() * 100);

		case POP:
			return citylist.get(index).getPopulation();

		case MPOP:
			return citylist.get(index).getMale();

		case FPOP:
			return citylist.get(index).getFemale();

		default:
			return -1;

		}
	}

	public static void initArrays() {
		blank = IntStream.rangeClosed(0, citylist.size() - 1).boxed().toArray(Integer[]::new);
		postcode = IntStream.rangeClosed(0, citylist.size() - 1).boxed().toArray(Integer[]::new);
		area = IntStream.rangeClosed(0, citylist.size() - 1).boxed().toArray(Integer[]::new);
		population = IntStream.rangeClosed(0, citylist.size() - 1).boxed().toArray(Integer[]::new);
		male = IntStream.rangeClosed(0, citylist.size() - 1).boxed().toArray(Integer[]::new);
		female = IntStream.rangeClosed(0, citylist.size() - 1).boxed().toArray(Integer[]::new);
	}

	public static int binarySearchMin(Integer[] ary, Integer min, Column column) {

		// if (ary[ary.length - 1] < min)
		// return -1;

		System.out.println("MIN");

		int lowindex = 0;
		int highindex = ary.length - 1;
		int midindex;

		while (lowindex <= highindex) {
			midindex = lowindex + ((highindex - lowindex) / 2);
			if (getData(ary[midindex], column) >= min) {
				highindex = midindex - 1;
				count++;
			} else {
				lowindex = midindex + 1;
				count++;
			}
		}
		System.out.println(highindex + 1);
		return highindex + 1;
		// return ary[highindex + 1];
	}

	public static int binarySearchMax(Integer[] ary, Integer max, Column column) {

		// if (ary[0] > max)
		// return -1;

		System.out.println("MAX");

		int lowindex = 0;
		int highindex = ary.length - 1;
		int midindex;

		while (lowindex <= highindex) {
			midindex = lowindex + ((highindex - lowindex) / 2);
			if (getData(ary[midindex], column) > max) {
				highindex = midindex - 1;
				count++;
			} else {
				lowindex = midindex + 1;
				count++;
			}
		}
		System.out.println(lowindex - 1);
		return lowindex - 1;
		// return ary[lowindex - 1];
	}

	public static Integer[] processSearchRequest(List<Searchcriteria> request) {

		Integer[] temp = blank;

		for (Searchcriteria rq : request) {
			switch (rq.getColumnID()) {

			case ZIP:
				temp = sortByPostcode(temp, rq.getMin(), rq.getMax());
				break;

			case AREA:
				temp = sortByArea(temp, rq.getMin(), rq.getMax());
				break;

			case POP:
				temp = sortByPopulation(temp, rq.getMin(), rq.getMax());
				break;

			case MPOP:
				temp = sortByMale(temp, rq.getMin(), rq.getMax());
				break;

			case FPOP:
				temp = sortByFemale(temp, rq.getMin(), rq.getMax());
				break;
			}
		}
		return temp;
	}

	public static Integer[] sortByPostcode(Integer[] ary, Integer min, int max) {

		Arrays.sort(ary, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(citylist.get(o1).getPostcode(), citylist.get(o2).getPostcode());
			}
		});

		Integer[] retary;

		int start = 0;
		int end = ary.length - 1;

		start = binarySearchMin(ary, min, Column.ZIP);
		end = binarySearchMax(ary, max, Column.ZIP);

		retary = Arrays.copyOfRange(ary, start, end);
		return retary;
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

		start = binarySearchMin(ary, min * 100, Column.AREA);
		end = binarySearchMax(ary, max * 100, Column.AREA);

		retary = Arrays.copyOfRange(ary, start, end);
		return retary;
	}

	public static Integer[] sortByPopulation(Integer[] ary, Integer min, int max) {

		Arrays.sort(population, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(citylist.get(o1).getPopulation(), citylist.get(o2).getPopulation());
			}
		});

		Integer[] retary;

		int start = 0;
		int end = ary.length - 1;

		start = binarySearchMin(ary, min, Column.POP);
		end = binarySearchMax(ary, max, Column.POP);

		retary = Arrays.copyOfRange(ary, start, end);
		return retary;
	}

	public static Integer[] sortByFemale(Integer[] ary, Integer min, int max) {

		Arrays.sort(female, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(citylist.get(o1).getFemale(), citylist.get(o2).getFemale());
			}
		});

		Integer[] retary;

		int start = 0;
		int end = ary.length - 1;

		start = binarySearchMin(ary, min, Column.FPOP);
		end = binarySearchMax(ary, max, Column.FPOP);

		retary = Arrays.copyOfRange(ary, start, end);
		return retary;
	}

	public static Integer[] sortByMale(Integer[] ary, Integer min, int max) {

		Arrays.sort(male, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(citylist.get(o1).getMale(), citylist.get(o2).getMale());
			}
		});

		Integer[] retary;

		int start = 0;
		int end = ary.length - 1;

		start = binarySearchMin(ary, min, Column.MPOP);
		end = binarySearchMax(ary, max, Column.MPOP);

		retary = Arrays.copyOfRange(ary, start, end);
		return retary;
	}

	public static void main(String[] args) {
		loadData(0, 2057);
		initArrays();

//		 for (int i : sortByPostcode(postcode, 50000, 60000)) {
//		 System.out.println(citylist.get(i).getPostcode());
//		 }
		// sortByPostcode(postcode, 50000, 60000);

		// for (int i : sortByArea(area, 200, 500)) {
		// System.out.println(citylist.get(i).getArea());
		// }
		// sortByArea(area, 200, 500);

		// for (int i : sortByPopulation(population, 90000, 500000)) {
		// System.out.println(citylist.get(i).getPopulation());
		// }
		// sortByPopulation(population, 90000, 500000);

		// for (int i : sortByFemale(female, 30000, 40000)) {
		// System.out.println(citylist.get(i).getFemale());
		// }
		// sortByFemale(female, 30000, 40000);

		// for (int i : sortByMale(male, 20000, 30000)) {
		// System.out.println(citylist.get(i).getMale());
		// }
		// sortByMale(male, 20000, 30000);

		
		List<Searchcriteria> request = new ArrayList<Searchcriteria>();
		request.add(new Searchcriteria(Column.ZIP, 50000, 60000));
//		request.add(new Searchcriteria(Column.AREA, 150, 200));
		
		for (int i : processSearchRequest(request)) {
			System.out.println(citylist.get(i).getName());
			System.out.println(citylist.get(i).getPostcode());
		}

		System.out.println(count);
	}
}
