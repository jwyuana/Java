package Chapter11;


// ��̬, �����Ǹ�������⻯��ÿ�������ʵ�������丸���ʵ��������������������
// ���ǿ��Խ������ʵ��������Ҫ�������͵Ĳ�����

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

