package Chapter20;

public class RecursivePalindromeUsingSubstring {

	public static void main(String[] args){
		System.out.println(isPalindrome("moom"));
	}
	
	public static boolean isPalindrome(String s){
		if(s.length() <= 1)
			return true;
		else if(s.charAt(0) != s.charAt(s.length() - 1))
			return false;
		else
			return isPalindrome(s.substring(1, s.length()-1));  //产生新字符串    不够高效
	}
	
	public static boolean isPalindrome2(String s, int low, int high){
		if(low >= high)
			return true;
		else if(s.charAt(low) != s.charAt(high))
			return false;
		else
			return isPalindrome2(s, low+1, high-1);   // 利用辅助下标！
	}
}
