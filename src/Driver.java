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
	
	//Add a blank grade for a student assigned to a specific rubric
	public void addGrade(String name, Rubric rubric) {
		Grade theGrade = new Grade(name, rubric);
		grades.add(theGrade);
	}
	
	//Get all Grades on file associated with a named Rubric
	public ArrayList<Grade> getAllRubricGrades(String rubricName) {
		ArrayList<Grade> gradesFromRubric = new ArrayList<>();
		
		for (Grade g : grades) {
			if(g.getRubric().getName().equals(rubricName)) {
				gradesFromRubric.add(g);
			}
		}
		return gradesFromRubric;
	}
	
	
	
}
