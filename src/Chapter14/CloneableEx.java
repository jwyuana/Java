package Chapter14;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CloneableEx {

	public static void main(String[] args){
		Calendar calendar = new GregorianCalendar(2003,2,1);
		Calendar calendar1 = calendar;
		Calendar calendar2 = (Calendar) calendar.clone();
		System.out.println("calendar == calendar1 is " +
		(calendar == calendar1));                         // true
		System.out.println("calendar == calendar2 is " +
				(calendar == calendar2));                 // false
		System.out.println("calendar.equals(calendar2) is " +
				calendar.equals(calendar2));              // true
		
		/*
		 * ��10�н�calendar�����ø��Ƹ�calendar1������calendar��calendar1��ָ����ͬ��Calendar����
		 * ��11�д���һ���¶�����calendar�Ŀ�¡��Ȼ������¶�������ø�ֵ��calendar2.calendar2��calendar��������ͬ�Ĳ�ͬ����
		 * 
		 * */
		
		// ��clone������¡����
		int[] list1 = {1, 2};
		int[] list2 = list1.clone();
		list1[0] = 7; list1[1] = 8;
		
		System.out.println("list1 is " + list1[0] + ", " + list1[1]);  // 7, 8
		System.out.println("list2 is " + list2[0] + ", " + list2[1]);  // 1, 2
	}
	
}
