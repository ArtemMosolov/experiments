package week_1.core.general.copy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 *  student 1 Student1 [id=111, name=John, course=Course1 [subject1=Physics, subject2=Chemistry, subject3=Biology]]
	student 2 Student1 [id=111, name=John, course=Course1 [subject1=Physics, subject2=Chemistry, subject3=Biology]]
	
	// changed ID and Subject
	
	student 1 Student1 [id=111, name=John, course=Course1 [subject1=Physics, subject2=Chemistry, subject3=Biology]]
	student 2 Student1 [id=222, name=John, course=Course1 [subject1=Physics, subject2=Chemistry, subject3=Maths]]
 * 
 */

public class deep_copy_sample_2 {
	public static void main(String[] args) throws Exception {
		Course2 science = new Course2("Physics", "Chemistry", "Biology");
		Student2 student1 = new Student2(111, "John", science);
		Student2 student2 = null;

		student2 = (Student2) ObjectClonerUtil.deepCopy(student1);

		System.out.println("student 1 " + student1);
		System.out.println("student 2 " + student2);
		student2.id = 222;
		student2.course.subject3 = "Maths";
		System.out.println("student 1 " + student1);
		System.out.println("student 2 " + student2);
	}
}

class Course2 implements Serializable {

	private static final long serialVersionUID = -1156997019783635521L;
	String subject1;
	String subject2;
	String subject3;

	public Course2(String sub1, String sub2, String sub3) {
		this.subject1 = sub1;
		this.subject2 = sub2;
		this.subject3 = sub3;
	}

	@Override
	public String toString() {
		return "Course1 [subject1=" + subject1 + ", subject2=" + subject2 + ", subject3=" + subject3 + "]";
	}

}

class Student2 implements Serializable {
	private static final long serialVersionUID = -8491434461894336733L;
	
	int id;
	String name;
	Course2 course;

	public Student2(int id, String name, Course2 course) {
		this.id = id;
		this.name = name;
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student1 [id=" + id + ", name=" + name + ", course=" + course + "]";
	}

}

class ObjectClonerUtil {
	static public Object deepCopy(Object oldObj) throws Exception {
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream(); // A
			oos = new ObjectOutputStream(bos); // B
			oos.writeObject(oldObj); // C
			oos.flush(); // D
			ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray()); // E
			ois = new ObjectInputStream(bin); // F
			return ois.readObject(); // G
		} catch (Exception e) {
			System.out.println("Exception in ObjectCloner = " + e);
			throw (e);
		} finally { 
			oos.close();
			ois.close();
		}
	}

}
