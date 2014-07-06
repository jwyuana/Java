package Chapter14;

public class AbstractClassEx {

	public static void main(String[] args){
		Animal animal = new Chicken();
		eat(animal);
		animal = new Duck();
		eat(animal);
	}
	
	public static void eat(Animal animal){
		System.out.println(animal.howToEat());
	}
	
}


abstract class Animal {
	public abstract String howToEat();
}

class Chicken extends Animal {
	public String howToEat(){
		return "fry it";
	}
}

class Duck extends Animal {
	public String howToEat(){
		return "roast it";
	}
}

