package Chapter14;

public class Circle extends GeometricObject{

	private double radius;
	
	public Circle(){
	}
	
	public Circle(double radius){
		this.radius = radius;
	}
	
	public Circle(double radius, String color, boolean filled){
		this.radius = radius;
		setColor(color);
		setFilled(filled);
	}
	
	public double getRadius(){
		return radius;
	}
	
	public void setRadius(double radius){
		this.radius = radius;
	}
	
	public double getArea(){
		return radius*radius*Math.PI;
	}
	
	public double getDiameter(){
		return radius*2;
	}
	
	public double getPerimeter(){
		return 2*radius*Math.PI;
	}
	
	public void printCircle(){
		System.out.println("The circle is created " + getDateCreated() + 
				" and the radius is " + radius); 
	}
	
}
