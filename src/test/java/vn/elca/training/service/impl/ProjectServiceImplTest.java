package vn.elca.training.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import vn.elca.training.dom.Project;
import vn.elca.training.dom.ProjectStore;
import vn.elca.training.service.ProjectService;

import static org.fest.assertions.Assertions.assertThat;

/**
 * 
 * @author coh
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-config.xml" })
public class ProjectServiceImplTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private ProjectService projectService;

	// TODO [Task � 1] Add necessary configuration to make ProjectServiceImplTest.java runnable under JUnit.

	@Test
	public void testFindProjectByName() {
		// 1. Prepare data
		insertProject("Project P1", 1001, "Customer C1", "COH");
		insertProject("Project P2", 1002, "Customer C2", "COH");
		
		// 2. Execute
		List<Project> result = projectService.findByQuery("P1");
		
		// 3. Verify
		// TODO [Task � 2] Fill MISSING points to verify the test result by using assertion library.
		assertThat(result).hasSize(1);
	}

	@Test
	public void testFindProjectByNumber() {
		// 1. Prepare data
		insertProject("Project P3", 1001, "Customer C3", "COH");
		
		// 2. Execute
		List<Project> result = projectService.findByQuery("1001");
		
		// 3. Verify
		// TODO [Task � 2] Fill MISSING points to verify the test result by using assertion library.
		assertThat(result.get(0).getLeader()).isEqualTo("COH");
	}

	@Test
	public void testFindProjectWithBlankCriteria() {
		// 1. Prepare data
		insertProject("Project P4", 1004, "Customer C4", "COH");

		// 2. Execute
		List<Project> result = projectService.findByQuery("");

		// 3. Verify
		assertThat(result).isEmpty();
	}
	
	// TODO [Task � 3] Install jacoco, run test and find missing tests cases for the function projectService.findByQuery based on jacoco report result
	//mvn clean test
	//mvn jacoco:report

	private void insertProject(String name, int number, String customer, String leader) {
		Project project = new Project();
		project.setName(name);
		project.setNumber(number);
		project.setCustomer(customer);
		project.setLeader(leader);
		ProjectStore.getProjects().add(project);
	}
}
