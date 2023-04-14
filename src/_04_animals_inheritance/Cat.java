package _04_animals_inheritance;

public class Cat extends Animal{
	Cat(String name, String furColor, Boolean isFemale) {
		super(name, furColor, isFemale);
		// TODO Auto-generated constructor stub
	}
	
	public void Meow() {
		System.out.println("Meow");
	}
	
}
