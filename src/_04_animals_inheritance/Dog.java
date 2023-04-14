package _04_animals_inheritance;

public class Dog extends Animal{
	Dog(String name, String furColor, Boolean isFemale) {
		super(name, furColor, isFemale);
		// TODO Auto-generated constructor stub
	}
	
	public void Woof() {
		System.out.println("Woof");
	}
}
