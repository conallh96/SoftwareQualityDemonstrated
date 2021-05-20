import java.util.ArrayList;

public class Grade {
	//Grade object holds a students name, the rubric they are being marked against
	// and the overall average grade for the rubric.
	private String studentName;
	private Rubric rubric;
	private double overall;
	private ArrayList<Integer> marks = new ArrayList<>();
	

	public Grade(String studentName, Rubric rubric) {
		super();
		this.studentName = studentName;
		this.rubric = rubric;
		for(String s: rubric.getCriteria()) {
			marks.add(0);
		}
	}




	public Rubric getRubric() {
		return rubric;
	}




	public double getOverall() {

		
		return overall;
	}



	public ArrayList<Integer> getMarks() {
		return marks;
	}


	
	public void addGrade(int criterion, int score) {
		marks.set(criterion, score);
		
		double overallHere = 0;
		int total = 0;
		
		for (int i: marks) {
			
			total = total + i;
			
		}
		
		overallHere = (double)total/(double)marks.size();
		overall = overallHere;
		
		
	}



	
	

}