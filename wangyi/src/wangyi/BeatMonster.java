package wangyi;

import java.util.Scanner;

public class BeatMonster {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int lineCount=1;
		int c;
		while(scanner.hasNext()){
					
			int n= scanner.nextInt();
			int initialAbility=scanner.nextInt();
			c=initialAbility;
			int[] b=new int[n];
			
			for(int i=0;i<n;i++){
				b[i]=scanner.nextInt();
				if(c>=b[i]){
					c+=b[i];
				}else{
					c+=gdc(c,b[i]);
				}
			}
			System.out.println(c);

			lineCount+=2;
		}
	}
	
	static int gdc(int a, int b){
		int max=Math.max(a, b);
		int min=Math.min(a, b);
		while(min!=0){
			int r=max%min;
			max=min;
			min=r;
		}
		
		return max;
	}
	
}
