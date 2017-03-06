package week_1.core.general.copy;

/*
 *  student 1 Student [id=111, name=John, course=Course [subject1=Physics, subject2=Chemistry, subject3=Biology]]
	student 2 Student [id=111, name=John, course=Course [subject1=Physics, subject2=Chemistry, subject3=Biology]]
	
	// changed ID and Subject
	
	student 1 Student [id=111, name=John, course=Course [subject1=Physics, subject2=Chemistry, subject3=Maths]]
	student 2 Student [id=222, name=John, course=Course [subject1=Physics, subject2=Chemistry, subject3=Maths]]
 * 
 */

public class shallow_copy {

	public static void main(String[] args) {
		// https://en.wikipedia.org/wiki/Object_copying#Copying_in_Java

		Course science = new Course("Physics", "Chemistry", "Biology");
		Student student1 = new Student(111, "John", science);
		Student student2 = null;
		try {
			student2 = (Student) student1.clone();
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

class Course {
	String subject1;
	String subject2;
	String subject3;

	public Course(String sub1, String sub2, String sub3) {
		this.subject1 = sub1;
		this.subject2 = sub2;
		this.subject3 = sub3;
	}

	@Override
	public String toString() {
		return "Course [subject1=" + subject1 + ", subject2=" + subject2 + ", subject3=" + subject3 + "]";
	}
}

class Student implements Cloneable {
	int id;
	String name;
	Course course;

	public Student(int id, String name, Course course) {
		this.id = id;
		this.name = name;
		this.course = course;
	}

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + "]";
	}
	
}
