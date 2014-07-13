package Chapter22;

import java.io.Serializable;
import java.util.*;

import Chapter14.*;


public class TestTreeSetWithComparator{
	
	public static void main(String[] args){
		Set<GeometricObject> set = new TreeSet<GeometricObject>(new GeometricObjectComparator());
		set.add(new Rectangle(4, 5));
		set.add(new Circle(40));
		set.add(new Circle(40));
		set.add(new Rectangle(4, 1));
		
		System.out.println("A sorted set of geometric objects");
		for(GeometricObject elem:set)
			System.out.println("area = " + elem.getArea());
	}
}




class GeometricObjectComparator implements Comparator<GeometricObject>, Serializable {
	
	public int compare(GeometricObject o1, GeometricObject o2){
		double area1 = o1.getArea();
		double area2 = o2.getArea();
		
		if(area1 < area2)
			return -1;
		else if(area1 == area2)
			return 0;
		else 
			return 1;
	}

}
