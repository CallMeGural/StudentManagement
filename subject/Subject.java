package subject;

public class Subject {
	int id;
	String name,abbr;
	int maxi;
	
	public Subject(int id, String name, String abbr, int maxi) {
		super();
		this.id = id;
		this.name = name;
		this.abbr = abbr;
		this.maxi = maxi;
	}
	public Subject(String name, String abbr, int maxi) {
		super();
		this.name = name;
		this.abbr = abbr;
		this.maxi = maxi;
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
	public String getAbbr() {
		return abbr;
	}
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	public int getMaxi() {
		return maxi;
	}
	public void setMaxi(int maxi) {
		this.maxi = maxi;
	}
}
