package Chapter14;

public class InterfaceEx {
	public static void main(String[] args){
		Object[] objects = {new Tiger(), new Chicken(), new Apple()};
		for(int i=0; i<objects.length; i++)
			if(objects[i] instanceof Edible) // inatanceof
				System.out.println(((Edible)objects[i]).howToEat());  //(Edible)
	}
}

//interface is saimilar to class, it only contain constants and abstract methods
interface Edible {
	public abstract String howToEat();
}


class Animal {
	
}

// use keyword "implements" to inherit from an interface
class Chicken extends Animal implements Edible {
	public String howToEat() {
		return "Chicken: fry it";
	}
}

class Tiger extends Animal {
	
}

abstract class Fruit implements Edible {
	
}

class Apple extends Fruit {
	public String howToEat(){
		return "Apple: Make apple cider";
	}
}

class Orange extends Fruit {
	public String howToEat(){
		return "Orange: Make juice";
	}
}