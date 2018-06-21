package A3;

public class CityData {

	public int id;
	public String name;
	public int postcode;
	public float area;
	public Integer population;
	public Integer male;
	public Integer female;
	

	public CityData(int id, String name, int postcode, float area, Integer population, Integer male, Integer female) {
		this.id = id;
		this.name = name;
		this.postcode = postcode;
		this.area = area;
		this.population = population;
		this.male = male;
		this.female = female;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Integer getMale() {
		return male;
	}

	public void setMale(Integer male) {
		this.male = male;
	}

	public Integer getFemale() {
		return female;
	}

	public void setFemale(Integer female) {
		this.female = female;
	}

	public String toString() {

		return (id + " " + "Stadt: " + name + " ; PLZ: " + postcode + " ; Flaeche: " + area + " ;  Bevölkerung: Gesamt: "
				+ population + " , M: " + male + " , W: " + female);
	}
}
