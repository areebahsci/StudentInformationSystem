package com.areebahsci.gui_project.model.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.areebahsci.gui_project.controller.Controller;
import com.areebahsci.gui_project.model.Model;
import com.areebahsci.gui_project.model.course.Course;
import com.areebahsci.gui_project.model.user.Professor;
import com.areebahsci.gui_project.model.user.Student;

public class File {
	
	/* This method will be used to load and instantiate professors from a file where all the information
	   is saved. This method also loads the course arraylist 
	   since the only courses that will be offered will be those that are being taught
	   by the professors. This method will be similar to the loadStudents method. */
	
	public static void loadProfessorsIntoArray(Model model, String path) {
		
		// first we save the entire file as a string 
		
		String file=Utilities.loadFileAsString(path);
		
		// then we split the string at every ';' into an array of strings
		
		String[]seperatedProfessors=file.split(";\n");
		
		// now we set the professor count 
		
		int professorCount=Utilities.parseInt(seperatedProfessors[0]);
		
		// now we go through the entire list of professors, initializing them and setting their values 
		
		for (int i=1;i<=professorCount;i++) {
			
			/* here we split each string from the seperatedprofessors array into their individual 
			   tokens such as name, id and such data and save it into a new array */
			
			String[]tokens=seperatedProfessors[i].split(" ");
			
			/* each token is then saved as its data type, rather than just inputting it into the 
			   professor constructor all together */
			
			String  ID=tokens[0], 
					name=tokens[1].concat(" "+tokens[2]),
					username=tokens[3], 
					password=tokens[4], 
					department=tokens[5];
			
			// now we can finally add into the professor arraylist
			
			Professor professor=new Professor(ID, name, username, password, department);
			
			// this is where we start adding into the course array
			
			int profCourseCount=Utilities.parseInt(tokens[6]);
			int k=7;
			for (int j=0;j<profCourseCount;j++) {
				String courseName=tokens[k];
				int courseID=Utilities.parseInt(tokens[k+1]),
						credits=Utilities.parseInt(tokens[k+2]);
				Course course = new Course(professor, courseID, courseName, credits);
				
				// this function is used to add the course to the array of courses the professor has
				// and increment the number of courses the professor is teaching
				professor.addCourse(course);
				
				/* at this point, all the current course information we can set has been set so we are
				adding it to the arraylist of courses */
				model.getCoursesArray().add(course);
				k+=3;
			}
			
			// at this point, all the professor info is set so we add it to the arraylist of professors
			model.getProfessorsArray().add(professor);
			
		}

	}
	
	// this function is very similar to the loadProfessorsIntoArray function
	public static void loadStudentsIntoArray(Model model, String path) {
		
		String file=Utilities.loadFileAsString(path);
		String[]seperatedStudents=file.split(";\n");
		int studentCount=Utilities.parseInt(seperatedStudents[0]);
		for (int i=1;i<=studentCount;i++) {
			
			String[]tokens=seperatedStudents[i].split(" ");
			String  ID=tokens[0], 
					name=tokens[1].concat(" "+tokens[2]),
					username=tokens[3], 
					password=tokens[4], 
					major=tokens[5];
			double GPA=Utilities.parseDouble(tokens[6]);
			
			Student student=new Student(ID, name, username, password, major, GPA);
			
			// here we add more information to the courses
			int studentCourseCount=Utilities.parseInt(tokens[7]);
			int k=8;
			for (int j=0;j<studentCourseCount;j++) {
				
				int courseID=Utilities.parseInt(tokens[k]);
				double grade=Utilities.parseDouble(tokens[k+1]);
				
				// this function adds the course to the student
				student.addCourse(courseID, grade); 
				
				/* at this point, all student information is set so we can add the student to the
				arraylist in the model and use the student to update the course information with
				the student taking the course */
				
				// the function 'addStudent' adds the student to the course 
				model.getCourse(courseID).addStudent(student);
				k+=2;
			}
			
			// at this point, all the student info is set so we add it to the arraylist of students
			model.getStudentsArray().add(student);
		}
	}
	
	/* this function writes all the courses in a format of [courseID; courseName; courseCredits]
	 * into a file */
	public static void loadCoursesIntoFile(Model model, String path) {
		try {
			
			// we create a filewriter object that writes into the path passed into its constructor
			FileWriter mycin = new FileWriter(path);
		
			for (int i=0;i<model.getCourseCount();i++) {
				Course course = model.getCoursesArray().get(i);
				mycin.write(course.getCourseID()+"; "+course.getCourseName()+"; "+
						course.getCredits()+";\n");
			}
			mycin.close();
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	public static void updateStudentFile(Model model, String path) throws IOException {
		
		/* the student's index in the student arraylist in the model can help us find the position
		 * of the student in the file. The first line in the file is how many studentd there are in
		 * the system. If for example, the student is on the 4th line in the file, then that means 
		 * it is the 3rd student and therefore its index in the array is 2 since indexes in arraylists
		 * start from 0. so vice versa, if the students index in the array is 5 for example, that means
		 * it is the sixth student and therefore belongs on the 7th line. so 
		 * indexInArray = line position - 2; */
		
		
}

