package Chapter11;


//���ǿ��Խ�һ�������ʵ��ת��Ϊһ������ı�������Ϊ�����ʵ����Զ���������ʵ����
//����һ�������ʵ��ת��Ϊ����ı���ʱ������ʹ��ת���Ǻš�������������ʽת����Ϊʹת���ɹ�������ȷ��
//Ҫת���Ķ����������һ��ʵ��������ClassCastException��   ���� instanceof ��ʵ��ȷ����


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
// ����getArea getDiameter������Object�����ǲ����õģ������б�Ҫ��ʽ��ת����Circle��