package Chapter11;

public class DynamicBindingDemo {

	public static void main(String[] args){
		m(new GraduateStudent());
		m(new Student());
		m(new Person());
		m(new Object());
	}
	
	public static void m(Object o){
		System.out.println(o.toString()); // µÈ¼ÛÓÚSystem.out.println(o);
	}
	
}


class GraduateStudent extends Student {
	
}

class Student extends Person {
	public String toString(){
		return "Student";
	}
}

class Person extends Object {
	public String toString(){
		return "Person";
	}
}