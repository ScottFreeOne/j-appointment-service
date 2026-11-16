package appointments;


import java.util.ArrayList;

public class AppointmentService
{
	private ArrayList<Appointment> appointList = new ArrayList<Appointment>();
	
	public int getAppointListSize() 
	{
		return appointList.size();
	}

	//Method to display all appointments in the list
	public void showAppointList()
	{
		for (int i = 0; i < appointList.size(); i++)
		{
			System.out.println("\t Appointment ID: " + appointList.get(i).getAppointID());
			System.out.println("\t Appointment Date: " + appointList.get(i).getAppointDate());
			System.out.println("\t Appointment Description: " + appointList.get(i).getAppointDescription());
		}
	}
	
	//Date is in MM-dd-yyyy format
	public void addAppointment(String potentialDate, String appointDescription)
	{
		Appointment newAppoint = new Appointment(potentialDate, appointDescription);
		appointList.add(newAppoint);
	}
	
	public void deleteAppointment(String appointID) 
	{
		boolean appointFound = false;
		for (int i = 0; i < appointList.size(); i++) 
		{
			if(appointList.get(i).getAppointID().equals(appointID)) 
			{
				appointFound = true;
				appointList.remove(i);
				break;
			} 
		}
		if(!appointFound) 
		{
			System.out.println("Appointment ID was not found. Appointment ID: " + appointID); //printout if appointID was not found.
		}
	}

}
	

