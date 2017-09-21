package com.cg.fms.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.fms.dao.FMSDao;
import com.cg.fms.dao.FMSDaoImpl;
import com.cg.fms.dto.Feedback;
import com.cg.fms.exception.FeedbackSysException;

public class FmsTestClass {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void test() {
//
//			FMSDao feedback = new FMSDaoImpl();
//			Feedback fb = new Feedback(12345,54321,"everything_fine","nothing",1,2,3,4,5,Date.valueOf(LocalDate.now()));
//			try {
//				assertEquals(true,feedback.addNewFeedback(fb));
//			} catch (FeedbackSysException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	
//	@Test
//	public void test1() {
//		FMSDao feedback = new FMSDaoImpl();
//		
//		try {
//			assertNotNull(feedback.getAllfeedbackList());
//		} catch (FeedbackSysException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void test() {

		/*	// UPDATE PROGRAM METHOD
		 * FMSDao program = new FMSDaoImpl();
			TrainingProgram p1= new TrainingProgram(10001,10003,10003,Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now()));
			try {
				assertEquals(true,program.updateTrainingProgramWithId(p1));
			} catch (FeedbackSysException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//ADD FEEDBACK METHOD
			FMSDao program = new FMSDaoImpl();
			TrainingProgram p1= new TrainingProgram(10003,10003,Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now()));
			try {
				assertEquals(true,program.addNewTrainingProgram(p1));
			} catch (FeedbackSysException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		//Test Get all Training Programs List 
		 FMSDao program = new FMSDaoImpl();
		 ArrayList<TrainingProgram> products = null;
			try {
				products = program.getAllTrainingProgramList();
			} catch (FeedbackSysException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 assertNotNull(products);
			*/
		} 
	
	
//	@Test
//	public void test() throws FeedbackSysException {
//		
//		TrainingAdminService trainingAdminService = new TrainingAdminServiceImpl();
//		
//		try {
//			assertNotNull(trainingAdminService.getAllEmployeeList());
//		} catch (Exception e) {
//			
//			 throw new FeedbackSysException(e.getMessage());
//		}
//		
//		
//	}
//	
//	@Test
//	public void test1() throws FeedbackSysException {
//		
//		TrainingAdminService trainingAdminService = new TrainingAdminServiceImpl();
//		
//		try {
//			assertNotNull(trainingAdminService.getEmployeeNames());
//		} catch (Exception e) {
//			
//			 throw new FeedbackSysException(e.getMessage());
//		}
//		
//		
//	}
	
	
	/*@Test
	public void test() {
		
		System.out.println("In test");
		FMSDao dao = new FMSDaoImpl();
		try {
			
			System.out.println("In test");
			assertNotNull(dao.getAllCourseList());
			//System.out.println(dao.getAllCourseList());
			System.out.println("In test");
		} catch (FeedbackSysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	/*@Test
	public void test() throws FeedbackSysException
	{
		FMSDao dao = new FMSDaoImpl();
		Course course = new Course(1,"C++",40);
		assertEquals(true,dao.updateCourseWithId(course));
	}*/
	
	/*@Test
	public void test()
	{
		FMSDao dao = new FMSDaoImpl();
		try {
			assertNotNull(dao.getCourseNames());
		} catch (FeedbackSysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("In test");
	}*/
	
//	@Test
//	public void test()
//	{
//		System.out.println("In test");
//		FMSDao dao = new FMSDaoImpl();
//		try {
//			
//			System.out.println("In test");
//			assertNotNull(dao.removeCourse(1));
//			System.out.println("In test");
//		} catch (FeedbackSysException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	
	
}
