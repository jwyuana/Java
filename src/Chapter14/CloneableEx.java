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
		 * 第10行将calendar的引用复制给calendar1，所以calendar和calendar1都指向相同的Calendar对象。
		 * 第11行创建一个新对象，是calendar的克隆，然后将这个新对象的引用赋值给calendar2.calendar2和calendar是内容相同的不同对象。
		 * 
		 * */
		
		// 用clone方法克隆数组
		int[] list1 = {1, 2};
		int[] list2 = list1.clone();
		list1[0] = 7; list1[1] = 8;
		
		System.out.println("list1 is " + list1[0] + ", " + list1[1]);  // 7, 8
		System.out.println("list2 is " + list2[0] + ", " + list2[1]);  // 1, 2
	}
	
}
