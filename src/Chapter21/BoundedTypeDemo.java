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


// ���޵ķ�������<E extends GeometricObject>��Eָ��ΪGeometricObject�ķ���������
// ��ʱ���봫������GeometricObject��ʵ��������equalArea

// Ϊ�˶���һ���������ͣ���Ҫ���������ͷ�������֮��
// Ϊ�˶���һ������Ϊ�������ͣ���Ҫ���������ͷ��ڷ�����������֮ǰ