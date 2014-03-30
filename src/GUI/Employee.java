import java.io.Serializable;

/**
 * MIS HW5
 * 12/09/2013
 * @author Jinwei Yuan
 *
 */

public class Employee implements Serializable{
	public int ID;
	public String name;
	public double salary;
	
	public Employee(int id, String name, double salary){
		ID = id;
		this.name = name;
		this.salary = salary;
	}
	
	public String toString(){
		return "[" + ID + " " + name + " " + salary + "]";
	}
}
