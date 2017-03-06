package week_1.core.general.copy;

/*
 *  student 1 Student1 [id=111, name=John, course=Course1 [subject1=Physics, subject2=Chemistry, subject3=Biology]]
	student 2 Student1 [id=111, name=John, course=Course1 [subject1=Physics, subject2=Chemistry, subject3=Biology]]
	
	// changed ID and Subject
	
	student 1 Student1 [id=111, name=John, course=Course1 [subject1=Physics, subject2=Chemistry, subject3=Biology]]
	student 2 Student1 [id=222, name=John, course=Course1 [subject1=Physics, subject2=Chemistry, subject3=Maths]]
 * 
 */

public class deep_copy_sample_1 {
	public static void main(String[] args) {
		Course1 science = new Course1("Physics", "Chemistry", "Biology");
		Student1 student1 = new Student1(111, "John", science);
		Student1 student2 = null;
		try {
			student2 = (Student1) student1.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		System.out.println("student 1 " + student1);
		System.out.println("student 2 " + student2);
		student2.id = 222;
		student2.course.subject3 = "Maths";
		System.out.println("student 1 " + student1);
		System.out.println("student 2 " + student2);
	}
}

class Course1 implements Cloneable {
	String subject1;
	String subject2;
	String subject3;

	public Course1(String sub1, String sub2, String sub3) {
		this.subject1 = sub1;
		this.subject2 = sub2;
		this.subject3 = sub3;
	}

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Course1 [subject1=" + subject1 + ", subject2=" + subject2 + ", subject3=" + subject3 + "]";
	}

}

class Student1 implements Cloneable {
	int id;
	String name;
	Course1 course;

	public Student1(int id, String name, Course1 course) {
		this.id = id;
		this.name = name;
		this.course = course;
	}
	// Overriding clone() method to create a deep copy of an object.

	protected Object clone() throws CloneNotSupportedException {
		Student1 student = (Student1) super.clone();
		student.course = (Course1) course.clone();
		return student;
	}

	@Override
	public String toString() {
		return "Student1 [id=" + id + ", name=" + name + ", course=" + course + "]";
	}

}
