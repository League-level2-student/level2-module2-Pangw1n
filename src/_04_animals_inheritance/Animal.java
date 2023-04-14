package _04_animals_inheritance;

public class Animal {
	String name;
	String furColor;
	Boolean isFemale;
	
	Animal(String name, String furColor, Boolean isFemale)
	{
		this.name = name;
		this.furColor = furColor;
		this.isFemale = isFemale;
	}
	
	public void printName() {
		System.out.println("My name is "+name);
	}
	
	public void getFurColor() {
		System.out.println("I have " + furColor + " fur");
	}

	public void getGender() {
		if (isFemale)
			System.out.println("I am a female");
		else
			System.out.println("I am a male");
	}
	
	public void eat() {
		System.out.println("Eating");
	}
	
	public void sleep() {
		System.out.println("Sleeping");
	}
	
	public void play() {
		System.out.println("Playing");
	}
}
