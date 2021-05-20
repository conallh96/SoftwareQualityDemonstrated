

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
    
    //Test to ensure all rubrics in the system can be retrieved
    @Test                                               
    @DisplayName("Get all rubrics should work and be filled with one Rubric")   
    public void testAllRubrics() {
      ArrayList<Rubric> allRubrics = new ArrayList<>();
      
      allRubrics = driver.getAllRubrics();
      assertNotNull(allRubrics);
      assertEquals(allRubrics.size(), 1);
      
      
    }
    
    //Test to ensure a specific rubric can be retrieved by name
    @Test
    @DisplayName("Get a specific rubric by name")   
    public void testSpecificRubric() {
      Rubric theRubric = driver.getSpecificRubric("Rubric 1");
      
     
      assertNotNull(theRubric);
      assertEquals(theRubric.getName(), "Rubric 1");
      
      
    }
    
    //Test to ensure successful retrieval of grades from a specific Rubric.
    @Test
    @DisplayName("Get all rubrics Grades should work and be filled with one Rubrics Grades")   
    public void testAllRubricsGrades() {
      ArrayList<Grade> allRubricsGrades = new ArrayList<>();
      
      allRubricsGrades = driver.getAllRubricGrades("Rubric 1");
      assertNotNull(allRubricsGrades);
      assertEquals(allRubricsGrades.size(), 2);
      
      
    }
    
    @Test                                               
    @DisplayName("Add Score for Criterion should work")   
    public void testScoreCriterion() {
    	Grade grade = driver.grades.get(0);
    	
    	grade.addGrade(0, 5);
    	
    	assertEquals(grade.getMarks().get(0),5);
    }

    //Test to ensure average grade achieved in a Rubric is correctly retrieved.
    @Test                                               
    @DisplayName("Simple Rubric Average should work")   
    public void testRubricAverage() {
        assertEquals(3.7, driver.rubricAverage("Rubric 1"),      
        "Average Rubric Grade Should Equal 3.7");          
    }
    
    //Test to ensure Standard Deviation calculation for an entire rubric's grades is working.
    @Test                                               
    @DisplayName("Simple Rubric Std should work")   
    public void testRubricStd() {
        assertEquals(0.09999999999999987, driver.rubricStd("Rubric 1"),      
        "Std of Rubric Grade Should Equal 0.09999999999999987");          
    }
    
    //Test to ensure correct maximum grade is obtained from grades of specific rubric
    @Test                                               
    @DisplayName("Simple Rubric Max Grade should work")   
    public void testRubricMax() {
        assertEquals(3.8, driver.rubricMax("Rubric 1"),      
        "Max Rubric Grade Should Equal 3.8");          
    }
    
    //Test to ensure correct minimium grade achieved in a specific rubric is obtained.
    @Test                                               
    @DisplayName("Simple Rubric Min Grade should work")   
    public void testRubricMin() {
        assertEquals(3.6, driver.rubricMin("Rubric 1"),      
        "Min Rubric Grade Should Equal 3.6");          
    }
    
    //Test to ensure expected average for a specific criterion is returned.
    @Test                                               
    @DisplayName("Simple Criterion Average should work")   
    public void testCriterionAverage() {
        assertEquals(3.0, driver.criterionAverage("Rubric 1", "Efficiency"),      
        "Average Criterion Grade Should Equal 3.0");          
    }
    
  //Test to ensure expected standard deviation of scores for a specific criterion is returned.
    @Test                                               
    @DisplayName("Simple Criterion Std should work")   
    public void testCriterionStd() {
        assertEquals(1.0, driver.criterionStd("Rubric 1", "Efficiency"),      
        "Std of Criterion Grade Should Equal 1.0");          
    }
  
    //Test to ensure the expected maximum grade achieved in a criterion is returned with no issues.
    @Test                                               
    @DisplayName("Simple Criterion Max Grade should work")   
    public void testCriterionMax() {
        assertEquals(4.0, driver.criterionMax("Rubric 1", "Efficiency"),      
        "Max Criterion Grade Should Equal 4.0");          
    }
}


