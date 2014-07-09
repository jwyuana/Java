package Chapter11;


//总是可以将一个子类的实例转换为一个父类的变量，因为子类的实例永远是它父类的实例。
//当把一个父类的实例转换为子类的变量时，必须使用转换记号“（）”进行显式转换。为使转换成功，必须确保
//要转换的对象是子类的一个实例，否则ClassCastException。   可用 instanceof 来实现确保！


public class CastingDemo {

	public static void main(String[] args){
		Object object1 = new Circle(1);
		Object object2 = new Rectangle(1,1);
		
		displayObject(object1);
		displayObject(object2);
	}
	
	public static void displayObject(Object object){
		if(object instanceof Circle){
			System.out.println(((Circle)object).getArea());           // casting
			System.out.println(((Circle)object).getDiameter());
		}
		else if(object instanceof Rectangle){
			System.out.println(((Rectangle)object).getArea());
		}
	}
}
// 由于getArea getDiameter方法在Object类中是不可用的，所以有必要显式地转换成Circle类