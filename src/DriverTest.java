

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DriverTest {
	
	//Test class that tests methods in driver class with hardcoded values to ensure 
	// methods act accordingly to system design. 

	private Driver driver = new Driver();

    @BeforeEach                                         
    public void setUp() throws Exception {
    	
		Rubric rubric1 = new Rubric("Rubric 1");
		rubric1.addCriteria("Design");
		rubric1.addCriteria("Implementation");
		rubric1.addCriteria("Efficiency");
		rubric1.addCriteria("Time Management");
		rubric1.addCriteria("Interface");
		
		driver.rubrics.add(rubric1);
		
		Grade grade1 = new Grade("Conall Hunt", driver.rubrics.get(0));
		grade1.addGrade(0,3);
		grade1.addGrade(1,4);
		grade1.addGrade(2,4);
		grade1.addGrade(3,5);
		grade1.addGrade(4,3);
		
		driver.grades.add(grade1);
		
		Grade grade2 = new Grade("Hope Kiernan", driver.rubrics.get(0));
		grade2.addGrade(0,4);
		grade2.addGrade(1,5);
		grade2.addGrade(2,2);
		grade2.addGrade(3,3);
		grade2.addGrade(4,4);
		
		driver.grades.add(grade2);
    }
    
    //Test to ensure rubrics can be added to the collection
    @Test                                               
    @DisplayName("Add Rubric should work")   
    public void testRubricAdd() {
    	ArrayList<Rubric> allRubrics = new ArrayList<>();
    	
    	driver.addRubric("Rubric 2");
    	allRubrics = driver.getAllRubrics();
        assertNotNull(allRubrics);
        assertEquals(allRubrics.size(), 2);        
    }
    
    //Test to add criteria to a rubric
    @Test                                               
    @DisplayName("Add Rubric Criterion should work")   
    public void testRubricAddCriterion() {
    	Rubric allRubric;
    	
    	allRubric = driver.getSpecificRubric("Rubric 1");
    	allRubric.addCriteria("Sportsmanship");
        assertNotNull(allRubric);
        assertEquals(allRubric.getCriteria().size(), 6);        
    }
    
    //Test to ensure no more than 10 criteria per rubric
    @Test
    @DisplayName("No more than 10 criteria")  
    public void tooManyCriteria() {
        // Error path test
    	Rubric rubric4 = new Rubric("Rubric 4");
		rubric4.addCriteria("Design");
		rubric4.addCriteria("Implementation");
		rubric4.addCriteria("Efficiency");
		rubric4.addCriteria("Time Management");
		rubric4.addCriteria("Interface");
		rubric4.addCriteria("Part A");
		rubric4.addCriteria("Part B");
		rubric4.addCriteria("Part C");
		rubric4.addCriteria("Part D");
		rubric4.addCriteria("Part E");
		
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> rubric4.addCriteria("Part F"));
        
    }
    
    //Test to ensuring adding grades with a rubric to system works
    @Test                                               
    @DisplayName("Add Grade should work")   
    public void testGradeAdd() {
    	ArrayList<Grade> allGrades = new ArrayList<>();
    	
    	driver.addGrade("Steve Smith", driver.rubrics.get(0));
    	allGrades = driver.grades;
        assertNotNull(allGrades);
        assertEquals(allGrades.size(), 3);        
    }
    
    //Test to ensure no more than 10 criteria per rubric
    @Test
    @DisplayName("No higher grade than 5")  
    public void theKidsTooSmart() {
        // Error path test
    	Grade grade5 = new Grade("Sam O'Neill", driver.rubrics.get(0));
		
		
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> grade5.addGrade(0,6));
        
    }

  
}


