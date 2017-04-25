package utils;

public class Person implements Comparable<Person> {

	String firstName;
	String sex;
	long dateOfBirth;
	Person leftPerson;
	Person rightPerson;

	// Constructor
	public Person(String firstName, String sex, long dateOfBirth, String motherName, String fatherName) {
		this.firstName = firstName;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Person [First Name: " + firstName + ", Sex: " + sex + ", Date Of Birth: " + dateOfBirth + ", Mother: "
				+ leftPerson + ", Father: " + rightPerson + "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public long getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(long dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Person getLeftPerson() {
		return leftPerson;
	}

	public void setLeftPerson(Person leftPerson) {
		this.leftPerson = leftPerson;
	}

	public Person getRightPerson() {
		return rightPerson;
	}

	public void setRightPerson(Person rightPerson) {
		this.rightPerson = rightPerson;
	}

	public int compareTo(Person secondNameTwo) {

		if (leftPerson.equals(secondNameTwo)) {
			return 1;
		} else {
			return 0;
		}

	}



}
