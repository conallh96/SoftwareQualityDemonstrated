import java.util.ArrayList;

public class Grade {
	
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