package A3;

public class Searchcriteria {
	
	public Column columnID;
	public int max;
	public int min;
	
	public enum Column {
		ZIP,
		AREA,
		POP,
		MPOP,
		FPOP
	}
}
