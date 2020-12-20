package com.areebahsci.gui_project.model.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
			FileWriter mycout = new FileWriter(path);
		
			for (int i=0;i<model.getCourseCount();i++) {
				Course course = model.getCoursesArray().get(i);
				mycout.write(course.getCourseID()+"; "+course.getCourseName()+"; "+
						course.getCredits()+";\n");
			}
			mycout.close();
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	// this function writes a new course that a professor has registered to teach into the file
	public static void addCourse(Model model, String path) {
		try {
			BufferedWriter mycout = new BufferedWriter(new FileWriter(path, true));
			Course course = model.getCoursesArray().get(model.getCourseCount()-1);
			mycout.write(course.getCourseID()+"; "+course.getCourseName()+"; "+
					course.getCredits()+";\n");
			mycout.close();
		}
		catch (IOException e) {
			 System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		
	}
	
	/* this function will be very similar to the loadCoursesIntoFile function where, whenever a student
	 * successfully registers for a course or drops one OR when the professor changes a students
	 * grade in a course or when the course theyre taking is no longer being offered,
	 * then the entire file containing all student information gets updated by
	 * rewriting it with the updated information saved in the model's arraylist */
	public static void updateStudentFile(Model model, String path) {
		try {
			
			// we create a filewriter object that writes into the path passed into its constructor
			FileWriter mycout = new FileWriter(path);
			mycout.write(model.getStudentCount()+";\n");
			for (int i=0;i<model.getStudentCount();i++) {
				Student student = model.getStudentsArray().get(i);
				StringBuilder courseInfo = new StringBuilder();
				for (int j=0;j<student.getCoursesTaken();j++) {
					courseInfo.append(" ");
					courseInfo.append((int)(student.getEnrolledCourses()[j][0]));
					courseInfo.append(" ");
					courseInfo.append(student.getEnrolledCourses()[j][1]);
				}
				String courseInfoFinal = courseInfo.toString();
				mycout.write(student.getID()+" "+student.getName()+" "+student.getUsername()+" "+
				student.getPassword()+" "+student.getMajor()+" "+student.getGPA()+" "+student.getCoursesTaken()
				+courseInfoFinal+";\n");
			}
			mycout.close();
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
		
	/* this function will be very similar to the loadStudentsIntoFile function where, whenever a prof
	 * successfully drops or adds a course, or when they change their username or password, the entire 
	 * file containing all student information gets updated by rewriting it with the updated information 
	 * saved in the model's arraylist */
	public static void updateProfessorFile(Model model, String path) {
		//203 Professor Three professor3 password3 CAS 2 Writing 204 3 Physics 202 4;
		try {
			
			// we create a filewriter object that writes into the path passed into its constructor
			FileWriter mycout = new FileWriter(path);
			mycout.write(model.getProfessorCount()+";\n");
			for (int i=0;i<model.getProfessorCount();i++) {
				Professor professor = model.getProfessorsArray().get(i);
				StringBuilder courseInfo = new StringBuilder();
				for (int j=0;j<professor.getNumberOfCourses();j++) {
					Course course = professor.getCoursesTeachingArray().get(j);
					courseInfo.append(" ");
					courseInfo.append(course.getCourseName());
					courseInfo.append(" ");
					courseInfo.append(course.getCourseID());
					courseInfo.append(" ");
					courseInfo.append(course.getCredits());
				}
				String courseInfoFinal = courseInfo.toString();
				mycout.write(professor.getID()+" "+professor.getName()+" "+professor.getUsername()+" "+
				professor.getPassword()+" "+professor.getDepartment()+" "+professor.getNumberOfCourses()
				+courseInfoFinal+";\n");
			}
			mycout.close();
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
}

