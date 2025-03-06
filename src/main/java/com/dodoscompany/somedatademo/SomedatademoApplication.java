package com.dodoscompany.somedatademo;

import com.dodoscompany.somedatademo.DAO.*;
import com.dodoscompany.somedatademo.entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class SomedatademoApplication {
//	private static final String[] FIRST_NAMES = {"John", "Jane", "Alex", "Chris", "Katie", "Mike", "Sarah", "David", "Laura", "Tom"};
//	private static final String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
//	private static final String EMAIL_DOMAIN = "@gmail.com";

	private static final String[] FIRST_NAMES = {"John", "Jane", "Alex", "Chris", "Katie", "Mike", "Sarah", "David", "Laura", "Tom"};
	private static final String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
	private static final String EMAIL_DOMAIN = "@gmail.com";
	private static final String[] HOBBIES = {"Guitar", "Painting", "Running", "Cooking", "Reading", "Traveling"};
	private static final String[] YOUTUBE_CHANNELS = {"http://youtube.com/channel1", "http://youtube.com/channel2", "http://youtube.com/channel3"};
	private static final String[] COURSE_TITLES = {
			"Math 101", "Physics 201", "Chemistry 301", "Biology 101", "History 202", "Art 303", "Computer Science 101"
	};

	private static final String[] COMMENTS = {
			"Great course!", "Very informative.", "Loved the instructor.", "Could be better.", "Highly recommended!", "Not what I expected.", "Excellent material."
	};
	public static void main(String[] args) {
		SpringApplication.run(SomedatademoApplication.class, args);
	}




	@Bean
	public CommandLineRunner demo(InstructorDao instructorDao, InstructoDetailsDao instructoDetailsDao, CourseDao courseDao, ReviewDao reviewDao) {
		return runner -> {

//			for(int i=0;i<100;i++) {
//				Instructor instructor = createRandomInstructor();
//				InstructorDetail instructorDetail = createRandomInstructorDetail();
//				saveInstructor(instructorDao,instructor,instructorDetail);
//			}


			getInstructorJoinFetch(instructorDao,1).getCourses().forEach(System.out::println);
			delInstructor(instructorDao,1);


		};
	}


	private Course getCourseJoinFetch(CourseDao courseDao,int id){
		return courseDao.findCourseByIdJoinFetch(id);
	}

	private Instructor getInstructorJoinFetch(InstructorDao instructorDao,int id){
		return instructorDao.findInstructorByIdJoinFetch(id);

	}

	private void saveCourse(CourseDao courseDao,Course course,Instructor instructor){
		course.setInstructor(instructor);
		courseDao.saveCourse(course);
	}
	private Course getCourse(CourseDao courseDao,int id){
		return courseDao.findCourseById(id);
	}


	private void deleteInstruDetai(InstructoDetailsDao instructoDetailsDao,int id){
		instructoDetailsDao.removeInstructorDetailsById(id);
	}


	private InstructorDetail getInstructorDetail(InstructoDetailsDao instructoDetailsDao,int id){
		return instructoDetailsDao.findInstructorDetailsById(id);
	}





	private  void delInstructor(InstructorDao instructorDao,int id){
		 instructorDao.removeInstructorById(id);
	}
	private  Instructor getInstructor(InstructorDao instructorDao,int id){
		return instructorDao.findInstructorById(id);
	}

	private void saveInstructor(InstructorDao instructorDao,Instructor instructor,InstructorDetail instructorDetail) {

		instructor.setInstructorDetail(instructorDetail);
		instructorDao.saveInstructor(instructor);
	}


	private void saveStudent(StudentDao studentDao) {
		// Student student = new Student("John", "Doe", "
		Student student=new Student("dodos","minas","dodos@gmail.com");
		studentDao.saveStudent(student);
		System.out.println("Student saved "+student);

	}

	private void saveStudents(StudentDao studentDao, int count) {
		List<Student> students = generateRandomStudents(count);
		students.forEach(student -> studentDao.saveStudent(student));
		System.out.println("Students saved: " + students);
	}


	public Student fetchStudent(StudentDao studentDao, int id) {
		Student student=studentDao.findByID(id);
		return student;
	}

	public List<Student> fetchAllStudents(StudentDao studentDao) {
		List<Student> students = studentDao.findAll();
		return students;
	}
	public List<Student> findStudentsByFirstName(StudentDao studentDao, String firstName) {
		List<Student> students = studentDao.findbyFirstName(firstName);
		return students;
	}
	public void removeStudent(StudentDao studentDao, int id) {
		studentDao.removeStudentById(id);
	}

	public void updadeStudet(StudentDao studentDao,Student student,String firstName) {
		studentDao.updateStudentFirstName(student,firstName);
	}

	public void removeAllStudents(StudentDao studentDao) {
		studentDao.removeAllStudents();
	}







	public static List<Student> generateRandomStudents(int count) {
		List<Student> students = new ArrayList<>();
		Random random = new Random();

		for (int i = 0; i < count; i++) {
			String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
			String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
			String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + EMAIL_DOMAIN;

			Student student = new Student(firstName, lastName, email);
			students.add(student);
		}

		return students;
	}
	public static Instructor createRandomInstructor() {
		Random random = new Random();
		String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
		String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
		String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + EMAIL_DOMAIN;

		Instructor instructor = new Instructor();
		instructor.setFirstName(firstName);
		instructor.setLastName(lastName);
		instructor.setEmail(email);

		return instructor;
	}

	public static InstructorDetail createRandomInstructorDetail() {
		Random random = new Random();
		String hobby = HOBBIES[random.nextInt(HOBBIES.length)];
		String youtubeChannel = YOUTUBE_CHANNELS[random.nextInt(YOUTUBE_CHANNELS.length)];

		InstructorDetail instructorDetail = new InstructorDetail();
		instructorDetail.setHobby(hobby);
		instructorDetail.setYoutubeChannel(youtubeChannel);

		return instructorDetail;
	}
	public static List<Review> generateRandomReviews(int count) {
		List<Review> reviews = new ArrayList<>();
		Random random = new Random();

		for (int i = 0; i < count; i++) {
			String comment = COMMENTS[random.nextInt(COMMENTS.length)];
			Review review = new Review(comment);
			reviews.add(review);
		}

		return reviews;
	}
}
