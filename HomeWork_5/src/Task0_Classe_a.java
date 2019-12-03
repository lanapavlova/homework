import java.util.regex.Pattern;

class Person {
	int age;
	String name;

	public int getAge() {

		return age;
	}

	public void setAge(int age) {
		if (age < -1) {
			this.age = -1;
		} else {
			this.age = age;
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (Pattern.compile("[0-9]").matcher(name).find()) {
			this.name = "No name";
		} else {
			this.name = name;
		}
	}

	Person() {
		this.setAge(-1);
		this.setName("No name");
	}

	Person(String name) {
		this.setAge(-1);
		this.setName(name);
	}

	Person(String name, int age) {
		this.setAge(age);
		this.setName(name);
	}
	
	public String greeting() {
		String greeting = "Hello, I am " + this.getName() + ".  I am " + this.getAge() + " years old.";
		
		if (this.getAge() == -1) {
			greeting = "Hello, I am " + this.getName() + ".";
		}
		
		if(this.getName() == "No name"){
			greeting = "I am John Doe.";
		}
		
		return greeting;
	}
}

public class Task0_Classe_a {

	public static void main(String[] args) {

		Person lana = new Person("Lanna");
		System.out.println(lana.greeting()); 
		
	}
}
