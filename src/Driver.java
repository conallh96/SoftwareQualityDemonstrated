import java.util.ArrayList;
import java.util.Collections;

public class Driver {
	
	//Driver class to store functions to be called for adding rubrics and grades.
	
	//Array List of rubrics on the system
	ArrayList<Rubric> rubrics = new ArrayList<>();
	//Array List of all grades stored for all rubrics.
	ArrayList<Grade> grades = new ArrayList<>();

	public Driver() {
		
		
	}
	
	//Create new rubric with name and add to 
	public void addRubric(String name) {
		Rubric r = new Rubric(name);
		rubrics.add(r);
	}
	
	
	//return specific rubric based on name
	public Rubric getSpecificRubric(String name) {
		Rubric found = null;
		
		for(Rubric r : rubrics) {
			if(r.getName().equals(name)){
				found = r;
			}
		}
		
		return found;
		
	}
	
	//get all rubrics stored in collection.
	public ArrayList<Rubric> getAllRubrics() {
		return rubrics;
	}
	
}
