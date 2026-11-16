package appointments;

import java.util.Random;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Appointment
{
	private String appointID;
	private Date appointDate;
	private String appointDescript;
	
	public Appointment(String potentialDate, String descript) // 
	{
		Date dateHolder = null;
		
		
		
		do
		{
			this.appointID = genAppointID();
		}while(appointID == null || appointID.length() > 10 || appointID.isBlank());
		
		dateHolder = stringToDate(potentialDate);
		
		if (dateHolder == null || dateHolder.before(new Date())) 
		{
            throw new IllegalArgumentException("The provided date is invalid");// error msg if date is null.
        }
		
		
        this.appointDate = dateHolder;
        
        if (descript == null || descript.length() > 50 || descript.isBlank()) 
		{
			throw new IllegalArgumentException("Invalid Description."); // error msg if description isn't valid.
		}
		this.appointDescript = descript;
        
        
    }
	
	//getters
	public String getAppointID() 
	{
		return appointID;
	}

	public Date getAppointDate() 
	{
		return appointDate;
	}
	
	public String getAppointDescription() 
	{
		return appointDescript;
	}
	
	
	//setters
	public void setAppointDate(String date) 
	{
		Date newDate = stringToDate(date);
		if (newDate == null) 
		{
            throw new IllegalArgumentException("The date cannot be null!"); // error msg if date null
        }
		if (newDate.before(new Date()))
		{
			throw new IllegalArgumentException("The date connot be in the past!"); // error msg when date is in the past.
		}
        this.appointDate = newDate;
	}
 
 	public void setAppointDescript(String descript) 
  	{
		if (descript == null || descript.length() > 50 || descript.isBlank()) 
		{
			throw new IllegalArgumentException("Invalid Appointment description."); // error msg if description too long or not present/empty
		}
		this.appointDescript = descript;
	}
	
 	
 	public Date stringToDate(String date)
 	{
 		Date funcDateHolder = null;
 		
 		SimpleDateFormat stringToDateFormatter = new SimpleDateFormat("MM-dd-yyyy");
 		if (date != null)
 		{
 			try 
 			{
 				funcDateHolder = stringToDateFormatter.parse(date);
 			} catch (ParseException e) 
 			{
 				
 				e.printStackTrace();
 			}
 		}
 		else
 		{
 			throw new IllegalArgumentException("Date was null");
 		}
		
		
		if (funcDateHolder != null)
		{
			return funcDateHolder;
		}
		else
		{
			throw new IllegalArgumentException("The date was not converted correctly, please check input date format.");
		}
 	}

	//generates random 9 digit ID and pads the beginning with a 0 to ensure 10 digits.
	 private String genAppointID() 
	    {
	    	Random ranID = new Random(); //generate random number
	    	long inRangeID = Math.abs(ranID.nextLong() % 1_000_000_000); // Ensure the value is non-negative and within range
	        String reRanID = String.format("%010d", inRangeID);// formatting number, limiting total digit count
	        return reRanID;
	    }
	 

}
