package com.dodoscompany.somedatademo;

import com.dodoscompany.somedatademo.DAO.StudentDao;
import com.dodoscompany.somedatademo.entities.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class SomedatademoApplication {
	private static final String[] FIRST_NAMES = {"John", "Jane", "Alex", "Chris", "Katie", "Mike", "Sarah", "David", "Laura", "Tom"};
	private static final String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
	private static final String EMAIL_DOMAIN = "@gmail.com";
	public static void main(String[] args) {
		SpringApplication.run(SomedatademoApplication.class, args);
	}




//	@Bean
//	public CommandLineRunner demo(StudentDao studentDao) {
//		return runner -> {
//
//			saveStudents(studentDao,30);
//
//		};
//	}


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
}
