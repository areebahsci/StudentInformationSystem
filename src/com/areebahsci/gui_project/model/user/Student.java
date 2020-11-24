package com.areebahsci.gui_project.model.user;

import com.areebahsci.gui_project.model.course.Course;

// student is a user
public class Student extends User {

	// this is the major of the student 
	private String major;
	
    // this variable saves the GPA of the student 
	private double GPA;
	
	/* the 2d array will contain the courseID in the first column and the grade in that course in the 
	 * second column */
	private double [][] enrolledCourses; 
	
	// the number of courses taken by the student 
	private int coursesTaken;
	
	// the max number of courses a student can take 
	private static final int MAX_COURSES = 5;

	// constructor 
	public Student(String ID, String name, String username, String password,
			String major, double GPA) {
		
		super(ID, name, username, password);
		this.major=major;
		this.GPA=GPA;
		
		/* here we set the max size of the array to the max number of courses the student can take
		 * there will be 2 columns, one to store the course ID and the second for the corresponding grade
		 * in that course */
		this.enrolledCourses= new double [MAX_COURSES][2];
		
		/* when we first initialize the student, we dont set the coursesTaken as that is done by 
		 * another function, so we set it to 0 here so it can be incremented without any errors */
		this.coursesTaken=0;
		
	}
	
	/* this function adds a course to the student and is used when first initalizing students in the 
	 * model */
	public void addCourse(int courseID, double grade) {
		enrolledCourses[coursesTaken][0]=(double)courseID;
		enrolledCourses[coursesTaken][1]=grade;
		coursesTaken++;
	}
	
	/* this function adds a course to the student and is used when a student chooses to register to a  
	 * new course */
	public void addCourse(Course course) {
		
		enrolledCourses[coursesTaken][0]=course.getCourseID();
		enrolledCourses[coursesTaken][1]=-1;
		coursesTaken++;
		course.addStudent(this);
	}
	
	// retrieves the student's grade in a course 
	public double getGradeOfCourse(Course course) {
		for (int i=0;i<coursesTaken;i++) {
			if (course.getCourseID()==enrolledCourses[i][0]) {
				return enrolledCourses[i][1];
			}
		}
		return 0;
	}

	// this method calculates the GPA of the student 
	public double calculateGPA() {
		
		double GPA=0;
		for (int i=0;i<coursesTaken;i++) {
			GPA+=enrolledCourses[i][1];
		}
		GPA/=100;
		return GPA;
	}
	
	/* used to print data for validation purposes to ensure the methods are functioning the way they are
	 * supposed to be */
	@Override
	public void printData() {
		System.out.println("Name: "+this.name+ " ID: "+this.ID+" major: "+this.major+
				" username: "+this.username+" password: "+this.password+" GPA: "+
				this.GPA + " coursesTaken: "+this.coursesTaken);
		for (int i=0;i<this.coursesTaken;i++) {
			System.out.println("Course ID: "+ this.enrolledCourses[i][0]+
					" Grade: "+ this.enrolledCourses[i][1]);
		}
	}
	
	/* this ensures we get the length of the course array incase theres an error and the 
	 * the number of courses isnt updated when we add a course */
	public int getCoursesTaken() {
		
		/* for a 2d array, the length returns the number of rows which, for us, is how many
		 * courses there are anyway so it is correct */
		return(coursesTaken=enrolledCourses.length); 
	}

	/* we will never need to set this value as it should always be equal to the length of the course
	 * array so this function will just set it to the length of the course array */
	public void setNumberOfCourses() {
		
		/* for a 2d array, the length returns the number of rows which, for us, is how many
		 * courses there are anyway so it is correct */
		coursesTaken = enrolledCourses.length;
	}
	
	// GENERIC GETTERS AND SETTERS

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
	}

	public double[][] getEnrolledCourses() {
		return enrolledCourses;
	}

	public void setEnrolledCourses(double[][] enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}
	
}
