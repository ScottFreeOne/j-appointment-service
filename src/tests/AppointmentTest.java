package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import appointments.Appointment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class AppointmentTest {
	
	@Test
	void testAppointmentAssigned() throws ParseException{

		String dateString = "10-11-2030";
		Appointment testAppointment = new Appointment(dateString, "This tests the appointment description"); 
		
		Date expectedDate = new SimpleDateFormat("MM-dd-yyyy").parse(dateString);

		
		assertEquals(expectedDate, testAppointment.getAppointDate());
		assertEquals("This tests the appointment description", testAppointment.getAppointDescription());
		
	}
	
	@Test
	void testAppointmentNotNull() {
		Appointment testAppointment = new Appointment("10-11-2030", "This tests the task"); 
		
		assertNotNull(testAppointment.getAppointDate(), "Task Name is Null!");
		assertNotNull(testAppointment.getAppointDescription(), "Task Description is Null!");
	}
	
	
	
	
	//Exception Tests -- should throw exceptions for each argument, if not, error message will show up in log.
		@Test
		void testDescriptionTooLong() 
		{
			
			Assertions.assertThrows(IllegalArgumentException.class, () -> 
			{
				Appointment testAppointment = new Appointment("10-25-2030", "This tests the task12345678912345678912345678912345");
			}, "Appointment Description Long Exception was not thrown!");	
		}
		
		@Test
		void testAppointmentIsNull() 
		{	
			Assertions.assertThrows(IllegalArgumentException.class, () -> 
			{
				Appointment AppointmentTestB = new Appointment(null, "This tests the appointment description");
			}, "Appointment Date Null Exception was not thrown!");	
			
			Assertions.assertThrows(IllegalArgumentException.class, () -> 
			{
				Appointment AppointmentTestB = new Appointment("10-11-2030", null);
			}, "AppointDate Description Null Exception was not thrown!");	
		}
		
		@Test
		void testUpdateAppointment() throws ParseException {
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


}
