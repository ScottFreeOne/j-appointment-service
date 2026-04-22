package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import appointments.Appointment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class AppointmentTest {
	
	//Valid Test
	@Test
	void testAppointmentAssigned() throws ParseException{

		String dateString = "10-11-2030";
		Appointment testAppointment = new Appointment(dateString, "This tests the appointment description"); 
		
		Date expectedDate = new SimpleDateFormat("MM-dd-yyyy").parse(dateString);

		
		assertEquals(expectedDate, testAppointment.getAppointDate());
		assertEquals("This tests the appointment description", testAppointment.getAppointDescription());
		
		
	}
	
	//Constructor Tests
	@Test
	void testAppointmentNotNull() 
	{
		Appointment testAppointment = new Appointment("10-11-2030", "This tests the task"); 
		
		assertNotNull(testAppointment.getAppointDate(), "Task Name is Null!");
		assertNotNull(testAppointment.getAppointDescription(), "Task Description is Null!");
	}
	
	//Constructor Exception Tests

	@Test
	void testConstructorBlankInputs() {
	    assertThrows(IllegalArgumentException.class, () -> new Appointment("   ", "desc"));
	    assertThrows(IllegalArgumentException.class, () -> new Appointment("10-11-2030", "   "));
	}
	
	@Test
	void testAppointmentDateRejectsPast()
	{
		assertThrows(IllegalArgumentException.class, () -> 
		{
			new Appointment("01-01-2000", "This tests is a valid description"); }, "Appointment Date cannot be in the past!");	
	}
	
	@Test
	void testAppointmentDateBadFormat() {
		assertThrows(IllegalArgumentException.class, () -> {
    	new Appointment("2030-10-11", "This is a valid test Description"); }, "Appointment must be in MM-dd-yyyy format");
		
		assertThrows(IllegalArgumentException.class, ()-> {
			new Appointment("AV-10-2030", "this is a valid Description");}, "Appointment must be in MM-dd-yyyy format");
		
		
	}
	
	@Test
	void testAppointDescriptTooLong() 
	{
		
		assertThrows(IllegalArgumentException.class, () -> 
		{
			new Appointment("10-25-2030", "This tests the task12345678912345678912345678912345");
		}, "Appointment Description Long Exception was not thrown!");
	}
	
	
	//Setter Tests
	
	@Test
	void testAppointmentSetterUpdate() throws ParseException {
		String AID = "";
		Date formattedDate;
		
		Appointment testAppoint = new Appointment("10-11-2030", "This is a valid test case");	
	
		// **For manual review, uncomment** 
		//System.out.println("\t Appointment ID: " + testAppoint.getAppointID());
		//System.out.println("\t Appointment Date: " + testAppoint.getAppointDate());
		//System.out.println("\t Appointment Description: " + testAppoint.getAppointDescription());
		
		AID = testAppoint.getAppointID();
		
		testAppoint.setAppointDate("11-10-2030");
		testAppoint.setAppointDescript("This is a new descriptor");
		
		Date expectedDate = new SimpleDateFormat("MM-dd-yyyy").parse("11-10-2030");
		String expectedDescript = "This is a new descriptor";
		
		//formattedDate = testAppoint.stringToDate("11-10-2030");
		
		//**For manual review, uncomment** 
		//System.out.println("\t Appointment ID: " + testAppoint.getAppointID());
		//System.out.println("\t Appointment Date: " + testAppoint.getAppointDate());
		//System.out.println("\t Appointment Description: " + testAppoint.getAppointDescription());
		
		//test comparison
		assertEquals(expectedDate, testAppoint.getAppointDate());
		assertEquals(expectedDescript, testAppoint.getAppointDescription());
	}
	
	
	//Exception Tests -- should throw exceptions for each argument, if not, error message will show up in log.
	

	@Test
		void testSetDateRejectsPast() {
	    Appointment testAppoint = new Appointment("10-11-2030", "This is a valid test description");
	    assertThrows(IllegalArgumentException.class, () -> {
	    	testAppoint.setAppointDate("01-01-2000"); }, "Appointment date cannot be in the past!");
		}
	@Test
		void testSetDateRejectsFormat() {
		Appointment testAppoint = new Appointment("10-11-2030", "This is a valid test description");
		assertThrows(IllegalArgumentException.class, ()-> {
			testAppoint.setAppointDate("2030-10-11"); }, "Appointment must be in MM-dd-yyyy format");
		}
	
		
		
		
	@Test
	void testAppointSettersNotNull() {
		Appointment testAppoint = new Appointment("10-11-2030", "This is a valid test case.");
			
		assertThrows(IllegalArgumentException.class, ()-> {
			testAppoint.setAppointDate(null);},"Appointment Date cannot be null");
			
		assertThrows(IllegalArgumentException.class, ()-> {
				testAppoint.setAppointDescript(null);},"Appointment Descript cannot be null");
		}
		
	@Test
	void testAppointSettersNotEmpty() {
		Appointment testAppoint = new Appointment("10-11-2030", "This is a valid test case");
			
			assertThrows(IllegalArgumentException.class, ()-> {
				testAppoint.setAppointDate("    ");}, "Appointment Date cannot be blank");
			assertThrows(IllegalArgumentException.class, ()-> {
				testAppoint.setAppointDescript("    ");}, "Appointment Description cannot be blank");
		}
		

	//stringToDate test
	@Test
	void testStringToDate() throws ParseException{
		Appointment testAppoint = new Appointment("10-11-2030", "This is a valid test case");
		
		Date expectedDate = new SimpleDateFormat("MM-dd-yyyy").parse("10-11-2030");
		assertEquals(expectedDate, testAppoint.stringToDate("10-11-2030"));
	}

	
	
	//**Appoint ID Tests**
	@Test
	void testIDProperties() {
	    Appointment testAppoint1 = new Appointment("10-11-2030", "desc");
	    Appointment testAppoint2 = new Appointment("10-12-2030", "desc");

	    assertEquals(10, testAppoint1.getAppointID().length());
	    assertTrue(testAppoint1.getAppointID().matches("\\d{10}"));
	    assertNotEquals(testAppoint1.getAppointID(), testAppoint2.getAppointID());
	}

		


}
