package com.areebahsci.gui_project.model.user;

import com.areebahsci.gui_project.model.course.Course;

// professor is a user 
public class Professor extends User {

	// the department in which the professor teaches 
	private String department;
	
	// this array holds the courses that the professor teaches 
	private Course[]coursesTeachingArray;
	
	// the number of courses the professor is teaching 
	private int numberOfCourses;
	
	// the max number of courses a professor can teach 
	private static final int MAX_COURSES=3;
	
	// constructor 
	public Professor(String ID, String name, String username, String password,
			String department) {
		
		super(ID, name, username, password);
		this.department=department;
		
		/* we set the max size of the array of courses the professor teaches to the max number of courses
		 * they can teach */
		coursesTeachingArray=new Course[MAX_COURSES];
		
		/* when we instantiate the professor, we dont pass the number of courses they teach in the
		 * constructor, rather the courses a professor teaches is handled by another function 
		 * so we set it to 0 so it can be incremented later without any errors */
		numberOfCourses = 0;
	}
	
	// this function is used to change a student's grade 
	public void setGrade(Student student, Course course, double grade) {
		
		int courseCount=student.getCoursesTaken();
		for (int i=0;i<courseCount;i++) {
			if (course.getCourseID()==student.getEnrolledCourses()[i][0]) {
				student.getEnrolledCourses()[i][1]=grade;
				return;
			}
		}
	}
	
	// this function is used to change the username of the professor 
	public void changeUsername(String username) {
		this.setUsername(username);
	}
	
	// this function is used to change the password of the professor 
	public void changePassword(String password) {
		this.setPassword(password);
	}
	
	// this function is used to add a course to the professor
	public void addCourse(Course course) {
		coursesTeachingArray[numberOfCourses]=course;
		numberOfCourses++;
	}
	
	/* used to print data for validation purposes to ensure the methods are functioning the way they are
	 * supposed to be */
	@Override
	public void printData() {
		System.out.println("Name: "+this.name+ " ID: "+this.ID+" department: "+this.department+
				" username: "+this.username+" password: "+this.password+" numberofCourses: "+
				this.numberOfCourses);
		for (int i=0;i<this.numberOfCourses;i++) {
			System.out.println("Course ID: "+ this.coursesTeachingArray[i].getCourseID()+
					" Course Name: "+ this.coursesTeachingArray[i].getCourseName()+
					" Credits: "+this.coursesTeachingArray[i].getCredits());
		}
	}
	
	// GENERIC GETTERS AND SETTERS

	public String getDepartment() {
		return department;
	}

	public int getNumberOfCourses() {
		return numberOfCourses;
	}

	public void setNumberOfCourses(int numberOfCourses) {
		this.numberOfCourses = numberOfCourses;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Course[] getCoursesTeachingArray() {
		return coursesTeachingArray;
	}

	public void setCoursesTeachingArray(Course[] coursesTeachingArray) {
		this.coursesTeachingArray = coursesTeachingArray;
	}

	public static int getMaxCourses() {
		return MAX_COURSES;
	}

}
