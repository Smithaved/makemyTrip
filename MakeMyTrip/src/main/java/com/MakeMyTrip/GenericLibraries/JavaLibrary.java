package com.MakeMyTrip.GenericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaLibrary {
	public long convertToLong(String timeout)
	{
		return Long.parseLong(timeout);
	}
	
	public String dateFormat()
	{
		return(new SimpleDateFormat("dd-mm-yyyy-HH-ss").format(new Date()));
	}
}
