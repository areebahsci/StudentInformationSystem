package com.areebahsci.gui_project.model.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utilities {
	
	// this function loads a file into a string 
	public static String loadFileAsString(String path) {
		StringBuilder convertedString = new StringBuilder();
		try {
			BufferedReader bufferedReader= new BufferedReader(new FileReader(path));
			String line;
			while((line=bufferedReader.readLine())!=null) {
				convertedString.append(line+"\n");
			}
			bufferedReader.close();
		}catch(IOException e) { 
			// this try catch block is used to catch file reading and writing errors
			e.printStackTrace();
		}
		return convertedString.toString();
	}
	
	/* this function converts a string into an int. While this can be done with a simple function
	 * 'Integer.parseInt', it requires to be surrounded by a try catch block so i made this function
	 * so that we dont include try catch blocks within our main code  */
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		}catch(NumberFormatException e) { 
			/* this try catch block is used to catch errors that might take place when converting the string
			 * into an int (which could happen if the string has non numeric characters for eg.) */
			e.printStackTrace();
			return 0;
		}
	}
	
	/* this function converts a string into an int. While this can be done with a simple function
	 * 'Double.parseDouble', it requires to be surrounded by a try catch block so i made this function
	 * so that we dont include try catch blocks within our main code  */
	public static double parseDouble(String number) {
		try {
			return Double.parseDouble(number);
		}catch(NumberFormatException e) {
			/* this try catch block is used to catch errors that might take place when converting the string
			 * into an int (which could happen if the string has non numeric characters for eg.) */
			e.printStackTrace();
			return 0;
		}
	}
	
}
