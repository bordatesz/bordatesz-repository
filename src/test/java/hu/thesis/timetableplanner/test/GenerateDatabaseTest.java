/**
 * 
 */
package hu.thesis.timetableplanner.test;

import static org.junit.Assert.*;
import hu.thesis.timetableplanner.entity.Occupation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author bordatesz
 *
 */
public class GenerateDatabaseTest {

	private EntityManagerFactory emf;
    private EntityManager em;
    private String PERSISTENCE_UNIT_NAME = "jpatest";
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
    @Before
	public void setUp() throws Exception {
		initEntityManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
    @After
    public void tearDown() throws Exception {
		closeEntityManager();
	}
	
	@Test
	public void testVoid(){
		Occupation testOccup = new Occupation();
		testOccup.setName("ASD");
		em.persist(testOccup);
		assertEquals(new Long(1), testOccup.getId());
	}

	private void initEntityManager() {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();
		// query = new JPAQuery(em);
	}
	
	private void closeEntityManager() {
        em.close();
        emf.close();
    }

}
