package wangyi;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyString {

	public static void main(String[] args) {
		String str="123";
		char[] charArray=str.toCharArray();

		
		StringBuilder builder=new StringBuilder(str);
		builder.insert(1,true);
		builder.setCharAt(0, 'c');
		System.out.println(builder);

		
		builder.deleteCharAt(0);
		
		System.out.println(builder);


	}
	

}


