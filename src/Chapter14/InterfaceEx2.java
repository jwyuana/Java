package Chapter14;

public class InterfaceEx2 {

	public static void main(String[] args){
		Edible stuff = new Chicken();
		eat(stuff);
		stuff = new Broccoli();
		eat(stuff);
	}
	
	public static void eat(Edible stuff){
		System.out.println(stuff.howToEat());
	}
	
}

interface Edible {
	public String howToEat();
}

class Chicken implements Edible {
	public String howToEat() {
		return "fry it";
	}
}

class Broccoli implements Edible {
	public String howToEat() {
		return "Stir-fry it";
	}
}

