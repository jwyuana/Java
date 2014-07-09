package Chapter11;


// 多态, 子类是父类的特殊化，每个子类的实例都是其父类的实例，但反过来不成立。
// 总是可以将子类的实例传给需要父类类型的参数。

public class PolymorphismDemo {

	public static void main(String[] args){
		displayObject(new Circle());
		displayObject(new Rectangle());
	}
	
	public static void displayObject(GeometricObject object){
		System.out.println("Created on " + object.getDateCreated() +
				". Color is " + object.getColor());
	}
	
}

