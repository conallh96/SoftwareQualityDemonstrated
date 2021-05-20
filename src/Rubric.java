import java.util.ArrayList;

public class Rubric {
	//Rubric object has a name and list of criterion students can be graded against
	private String name;
	private ArrayList<String> criteria = new ArrayList<>();

	

	public Rubric(String name) {
		super();
		this.name = name;
	}





	public String getName() {
		return name;
	}


	public ArrayList<String> getCriteria() {
		return criteria;
	}


	
	public void addCriteria(String criterion) {
		
		criteria.add(criterion);
		
	}



	
	

}