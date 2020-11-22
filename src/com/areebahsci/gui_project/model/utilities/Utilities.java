package com.areebahsci.gui_project.model.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.areebahsci.gui_project.model.course.Course;
import com.areebahsci.gui_project.model.user.professor.Professor;
import com.areebahsci.gui_project.model.user.student.Student;

public class Utilities {
 
 public static String loadFileAsString(String path) {
		StringBuilder builder=new StringBuilder();
		try {
			BufferedReader br= new BufferedReader(new FileReader(path));
			String line;
			while((line=br.readLine())!=null) {
				builder.append(line+"\n");
			}
			br.close();
		}catch(IOException e) { //for file reading and writing errors
			e.printStackTrace();
		}
		return builder.toString();
	}
	
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		}catch(NumberFormatException e) { //not a number error
			e.printStackTrace();
			return 0;
		}
	}
	
	public static double parseDouble(String number) {
		try {
			return Double.parseDouble(number);
		}catch(NumberFormatException e) { //not a number error
			e.printStackTrace();
			return 0;
		}
	}
	
}
