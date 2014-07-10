package Chapter21;

import Chapter14.Circle;
import Chapter14.GeometricObject;
import Chapter14.Rectangle;

public class BoundedTypeDemo {

	public static void main(String[] args){
		Rectangle rect = new Rectangle(2,2);
		Circle circle = new Circle(2);
		
		System.out.println("Same area? " + 
		BoundedTypeDemo.<GeometricObject>equalArea(rect, circle));
	}
	
	public static <E extends GeometricObject> boolean equalArea(E obj1, E obj2){
		return obj1.getArea() == obj2.getArea();
	}
}


// 受限的泛型类型<E extends GeometricObject>将E指定为GeometricObject的泛型子类型
// 此时必须传递两个GeometricObject的实例来调用equalArea

// 为了定义一个泛型类型，需要将泛型类型放在类名之后
// 为了定义一个方法为泛型类型，需要将泛型类型放在方法返回类型之前