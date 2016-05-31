package java8;

import java.util.ArrayList;
import java.util.List;

public class LambdaTest {

	//printPersons(roster, new CheckPersonEligibleForSelectiveService());
	
	public static void main(String arg[]){
		
		Person person1 = new Person("Suresh", Person.Sex.MALE, 37, "suresh@gmail.com");
		Person person2 = new Person("Ramesh", Person.Sex.MALE, 23, "ramesh@gmail.com");
		Person person3 = new Person("Mahesh", Person.Sex.MALE, 29, "Mahesh@gmail.com");
		Person person4 = new Person("Smitha", Person.Sex.FEMALE, 27, "smitha@gmail.com");
		List<Person> roster = new ArrayList<Person>();
		roster.add(person1);
		roster.add(person2);
		roster.add(person3);
		roster.add(person4);
		
		PrintPersons.printPersonsWithinAgeRange(roster, new CheckPersonEligibleForSelectiveService());
	}
    
}

class PrintPersons{
	public static void printPersonsWithinAgeRange(List<Person> roster, CheckPerson tester) {
	    System.out.println("Printing all persons of age higher than " + CheckPerson.LOWER_AGE + " and lower than " +  CheckPerson.HIGHER_AGE);
		for (Person p : roster) {
			if (tester.test(p)) {
	            p.printPerson();
	        }
	    }
	}
	
}

class Person {

	public enum Sex {
		MALE, FEMALE
	}
	
	public Person(String name, Sex gender, int age, String emailAddress){
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.emailAddress = emailAddress;
	}

	String name;
	//LocalDate birthday;
	Sex gender;
	String emailAddress;
	int age;
	
	public int getAge() {
		return age;
	}

	public void printPerson() {
		System.out.println("Person - name: " + name + ", age: " + age + ", gender: " + gender + ", emailAddress: " + emailAddress);
	}
}

    
    interface CheckPerson {
        boolean test(Person p);
        int LOWER_AGE = 18;
        int HIGHER_AGE =30;
    }
    
    class CheckPersonEligibleForSelectiveService implements CheckPerson {
        public boolean test(Person p) {
            return p.gender == Person.Sex.MALE &&
                p.getAge() >= LOWER_AGE &&
                p.getAge() <= HIGHER_AGE;
        }
    }