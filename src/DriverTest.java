

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

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
    
  
}

