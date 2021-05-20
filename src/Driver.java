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
	
	// Return the average overall grade from grades associated with a rubric
	public double rubricAverage(String rubric) {
	ArrayList<Double> overallsFromRubric = new ArrayList<>();
	double total = 0.0;
		
		for (Grade g : grades) {
			
			if(g.getRubric().getName().equals(rubric)) {
				overallsFromRubric.add(g.getOverall());
			}
		}
			
			
			for (int i = 0; i < overallsFromRubric.size(); i++)  {  
			       total = total + overallsFromRubric.get(i);
			   }
		
		return total/overallsFromRubric.size();
		
		
			
		
	}
	
	//Standard Deviation calculation for an entire rubric's grades
	public double rubricStd(String rubric) {
	
		ArrayList<Double> overallsFromRubric = new ArrayList<>();
		
			
			for (Grade g : grades) {
				if(g.getRubric().getName().equals(rubric)) {
					overallsFromRubric.add(g.getOverall());
				}
			}
			
			 
		    double mean = rubricAverage(rubric);
		    double temp = 0;

		    for (double i : overallsFromRubric)
		    {
		        

		        
		        double squrDiffToMean = Math.pow(i - mean, 2);

		        
		        temp += squrDiffToMean;
		    }

		    
		    double meanOfDiffs = (double) temp / (double) (overallsFromRubric.size());

		    
		    
				
		    return Math.sqrt(meanOfDiffs);
		
	}
	
	//Method to return highest grade achieved in a specific rubric
	public double rubricMax(String rubric) {
		
		ArrayList<Double> overallsFromRubric = new ArrayList<>();
		
		
		for (Grade g : grades) {
			if(g.getRubric().getName().equals(rubric)) {
				overallsFromRubric.add(g.getOverall());
			}
		}
		return Collections.max(overallsFromRubric);
		
	}
	
	//Returns lowest grade achieved in a specific rubric
	public double rubricMin(String rubric) {
	ArrayList<Double> overallsFromRubric = new ArrayList<>();
		
		
		for (Grade g : grades) {
			if(g.getRubric().getName().equals(rubric)) {
				overallsFromRubric.add(g.getOverall());
			}
		}
		return Collections.min(overallsFromRubric);
		
	}
	
	//retrieves all marks obtained in a specific criterion of a rubric
	// and generates the average value.
	public double criterionAverage(String rubric, String criterion) {
		ArrayList<Grade> gradesFromRubric = new ArrayList<>();
		ArrayList<Integer> scoresOnCriteria = new ArrayList<>();
		double total = 0.0;
		
		Rubric theRubric = getSpecificRubric(rubric);
		int criterionIndex = 0;
		
		for(String s: theRubric.getCriteria()) {
			if (s.equals(criterion)) {
				criterionIndex = theRubric.getCriteria().indexOf(s);
			}
		}
		
		for (Grade g : grades) {
			if(g.getRubric().getName().equals(rubric)) {
				gradesFromRubric.add(g);
			}
		}
		
		for (Grade g : gradesFromRubric) {
			
			scoresOnCriteria.add(g.getMarks().get(criterionIndex));
			
		}
		
		
		for (int i = 0; i < scoresOnCriteria.size(); i++)  {  
		       total = total + scoresOnCriteria.get(i);
		   }
	
	return total/scoresOnCriteria.size();
		
		
		
	}
	
	//returns the standard deviation of scores achieved in a specific rubric criterion
public double criterionStd(String rubric, String criterion) {
		
		
		ArrayList<Grade> gradesFromRubric = new ArrayList<>();
		ArrayList<Integer> scoresOnCriteria = new ArrayList<>();
		double total = 0.0;
		
		Rubric theRubric = getSpecificRubric(rubric);
		int criterionIndex = 0;
		
		for(String s: theRubric.getCriteria()) {
			if (s.equals(criterion)) {
				criterionIndex = theRubric.getCriteria().indexOf(s);
			}
		}
		
		for (Grade g : grades) {
			if(g.getRubric().getName().equals(rubric)) {
				gradesFromRubric.add(g);
			}
		}
		
		for (Grade g : gradesFromRubric) {
			
			scoresOnCriteria.add(g.getMarks().get(criterionIndex));
			
		}
		
		 
	    double mean = criterionAverage(rubric, criterion);
	    double temp = 0;

	    for (double i : scoresOnCriteria)
	    {
	        

	        
	        double squrDiffToMean = Math.pow(i - mean, 2);

	        
	        temp += squrDiffToMean;
	    }

	    
	    double meanOfDiffs = (double) temp / (double) (scoresOnCriteria.size());

	    
	    
			
	    return Math.sqrt(meanOfDiffs);
		
		
	}
	
	
	
	
	
}
