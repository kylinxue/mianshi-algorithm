package wangyi;

import java.util.Scanner;

public class Battery {

	public static void main(String[] args) throws Exception {
		Scanner scanner=new Scanner(System.in);
		int[][] batterys=new int[3][2]; 
		
		while(scanner.hasNext()){
			int R=scanner.nextInt();
			for(int i=0;i<3;i++){
				for(int j=0;j<2;j++){
					batterys[i][j]=scanner.nextInt();
				}
			}
			int x0=scanner.nextInt();
			int y0=scanner.nextInt();
			
			int value=0;
			for(int[] position:batterys){
				if(canAttack(position[0],position[1],x0,y0,R))
					value++;
			}
			
			System.out.println(value + "x");
		}	
		
	}
	static boolean canAttack(int x,int y,int x0,int y0, int R){
		if((x-x0)*(x-x0)+(y-y0)*(y-y0)<=R*R) 
			return true;
		
		return false;
	}
}
