package wangyi;

import java.util.ArrayList;
import java.util.Scanner;

public class kaola {

	static int[] gIndexes=new int[16];  //���������ģ���ַ����ڵ�����λ��
	public static void main(String[] args) {
		
//		Scanner scanner=new Scanner(System.in);
//		while(scanner.hasNextLine()){
//			String line=scanner.nextLine();
//			char[] chars=line.toCharArray();
//			int index=0;
//			int gCounts=0;  // ��gIndexes�е�����
//			for(char c:chars){
//				++index;
//				if(c=='g' || c=='9'){
//					gIndexes[gCounts++]=index;
//				}
//			}
//			// ����gIndexΪg��9�ĸ���������ֻ��Ҫ����gIndexes��0...gIndex-1��Ԫ�ؼ��ɡ�
//			if(gCounts==0){
//				System.out.println(chars);
//			}
//			else{
//				
//			}
//					
//		}
		char[] chars=new char[]{'3','3','3'};
		ArrayList<char[]> list;
		try {
			list = permutation(chars);
			for(char[] charArray : list){
				System.out.println(new String(charArray));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 
		}
		

	}
	
	/**
	 *  ����������Ԫ�أ�ÿ��Ԫ��ȡg��9����һ�������ֿ���
	 * @param intArray
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<char[]> permutation(char[] intArray) throws Exception{
		if(intArray==null || intArray.length==0) 
			throw new Exception("no such array");
		return recursivePermutation(intArray, 0);
	}
	
	private static ArrayList<char[]> recursivePermutation(char[] intArray, int start){
		if(start==intArray.length-1){
			char[] char1={'9'};
			char[] char2={'g'};
			ArrayList<char[]> list=new ArrayList<>();
			list.add(char1);
			list.add(char2);
			return list;
		}

		ArrayList<char[]> afterList=recursivePermutation(intArray, start+1);
		ArrayList<char[]> list=new ArrayList<>();
		for(char[] chars:afterList){
			char[] newCharsG=new char[chars.length+1];
			for(int i=0;i<newCharsG.length;i++){
				if(i==0) newCharsG[i]='g';
				else newCharsG[i]=chars[i-1];
			}
			list.add(newCharsG);
			char[] newChars9=new char[chars.length+1];
			for(int i=0;i<newChars9.length;i++){
				if(i==0) newChars9[i]='9';
				else newChars9[i]=chars[i-1];		
			}
			list.add(newChars9);
		}
		afterList=null;
		return list;
	}

}
