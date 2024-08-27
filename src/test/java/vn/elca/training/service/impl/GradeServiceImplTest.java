package vn.elca.training.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import vn.elca.training.service.GradeService;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-config.xml" })
public class GradeServiceImplTest {
    @Autowired
    private GradeService gradeService;

    @Test
    public void fiftyNineShouldReturnF() {
        // 1. Prepare data
        int score = 59;

        // 2. Execute
        char result = gradeService.determineGrade(score);

        // 3. Verify
        assertThat(result).isEqualTo('F');
    }

    @Test
    public void ninetyNineShouldReturnA() {
        // 1. Prepare data
        int score = 99;

        // 2. Execute
        char result = gradeService.determineGrade(score);

        // 3. Verify
        assertThat(result).isEqualTo('A');
    }

    //write test method to cover the remaining cases
    @Test
    public void sixtyShouldReturnD() {
        // 1. Prepare data
        int score = 60;

        // 2. Execute
        char result = gradeService.determineGrade(score);

        // 3. Verify
        assertThat(result).isEqualTo('D');
    }

    @Test
    public void seventyShouldReturnC() {
        // 1. Prepare data
        int score = 70;

        // 2. Execute
        char result = gradeService.determineGrade(score);

        // 3. Verify
        assertThat(result).isEqualTo('C');
    }

    @Test
    public void eightyShouldReturnB() {
        // 1. Prepare data
        int score = 80;

        // 2. Execute
        char result = gradeService.determineGrade(score);

        // 3. Verify
        assertThat(result).isEqualTo('B');
    }

    @Test
    public void negativeScoreShouldThrowException() {
        // 1. Prepare data
        int score = -1;

        // 2. Execute
        try {
            gradeService.determineGrade(score);
        } catch (IllegalArgumentException e) {
            // 3. Verify
            assertThat(e.getMessage()).isEqualTo("Score must be between 0 and 100");
        }
    }

    @Test
    public void scoreGreaterThanHundredShouldThrowException() {
        // 1. Prepare data
        int score = 101;

        // 2. Execute
        try {
            gradeService.determineGrade(score);
        } catch (IllegalArgumentException e) {
            // 3. Verify
            assertThat(e.getMessage()).isEqualTo("Score must be between 0 and 100");
        }

    }
}
