package appointments;


import java.util.ArrayList;

public class AppointmentService
{
	public ArrayList<Appointment> AppointList = new ArrayList<Appointment>();
	
	public void showAppointList()
	{
		for (int i = 0; i < AppointList.size(); i++)
		{
			System.out.println("\t Appointment ID: " + AppointList.get(i).getAppointID());
			System.out.println("\t Appointment Date: " + AppointList.get(i).getAppointDate());
			System.out.println("\t Appointment Description: " + AppointList.get(i).getAppointDescription());
		}
	}
	
	//Date is in MM-dd-yyyy format
	public void addAppointment(String potentialDate, String AppointDescription)
	{
		Appointment newAppoint = new Appointment(potentialDate, AppointDescription);
		AppointList.add(newAppoint);
	}
	
	public void deleteAppointment(String AppointID) 
	{
		boolean AppointFound = false;
		for (int i = 0; i < AppointList.size(); i++) 
		{
			if(AppointList.get(i).getAppointID().equals(AppointID)) 
			{
				AppointFound = true;
				AppointList.remove(i);
				break;
			} 
		}
		if(!AppointFound) 
		{
			System.out.println("Appointment ID was not found. Appointment ID: " + AppointID); //printout if AppointID was not found.
		}
	}

}
	

