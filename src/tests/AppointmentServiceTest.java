package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import appointments.AppointmentService;

class AppointmentServiceTest {

	
	@Test
	void testAddAppointment() {
		AppointmentService bookingService = new AppointmentService(); // test Service
		
		bookingService.addAppointment("10-11-2030", "This is a valid test case");	
		
		assertEquals(1, bookingService.getAppointListSize(), "Appointment not saved."); // confirms the addition of Appointment
		bookingService.showAppointList(); // confirms everything saved, as well as uniqueness of ID.	
	}

	@Test
	void testDeleteAppointment() 
	{
		String AID = "";
		
		AppointmentService bookingService = new AppointmentService(); // test Service
		
		bookingService.addAppointment("10-11-2030", "This is a valid test case");	
		
		for (appointments.Appointment Appointment : bookingService.appointList)
		{
			AID = Appointment.getAppointID();
		}
		
		
		bookingService.deleteAppointment(AID);
		assertEquals(0, bookingService.getAppointListSize(), "Appointment not deleted."); // confirms the deletion of Appointment
		
			
	}

}
