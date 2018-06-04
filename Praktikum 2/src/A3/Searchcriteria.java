package A3;

public class Searchcriteria {

	public Column columnID;
	public int max;
	public int min;
	
	public Searchcriteria(Column columnID, int min, int max) {
		this.columnID = columnID;
		this.min = min;
		this.max = max;
	}

	public Column getColumnID() {
		return columnID;
	}

	public void setColumnID(Column columnID) {
		this.columnID = columnID;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public enum Column {
		ZIP, AREA, POP, MPOP, FPOP
	}
}
