package misc;

public class Person {
    String name;

    public Person(String personName) {
        this.name = personName;
    }

    public String greet(String yourName) {
        return String.format("Hi %s, my name is %s", name, yourName);
    }
    
    public static void main(String arg[]){
    	Person person = new Person("Suresh");
    	
    	String value = person.greet("Venky");
    	
    	System.out.println(value);
    }
    
}

