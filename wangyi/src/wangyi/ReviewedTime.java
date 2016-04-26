package wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class ReviewedTime{	
	
	public static void main(String[] args)throws Exception{
        Scanner scanner=new Scanner(System.in);

        while(scanner.hasNext()){
        	int n = scanner.nextInt();
            int r = scanner.nextInt();  // ÿ�ſε�����
            int avg = scanner.nextInt();
            int[] a=new int[n]; // ÿ�ſε�ƽʱ�ɼ�
            int[] b=new int[n]; // ÿ�ŵ�һ������Ҫ�ĸ�ϰʱ��
            int[] c=new int[n]; // ÿ�ſ���������ߵķ��� 
            int totalScoresNeeded=0; //Ϊ�˴ﵽĿ����Ҫ��ߵ��ܷ���
            
            for(int i=0;i<n;i++){
            	a[i]=scanner.nextInt();
            	b[i]=scanner.nextInt();
            	c[i]=r-a[i];
            	
            	totalScoresNeeded+=avg-a[i];
            }
            
            int time=new ReviewedTime().getLeastReviewedTime(c,b,totalScoresNeeded);
            System.out.println(time);
        }
        
        
    }
    
	/**
	 * dp[i][j] ��ʾǰi�ſεõ�����j����Ҫ������ʱ��
	 * dp[i][j]=min{dp[i-1][j-k]+k*b[i] | 0<=k<=c[i]&&k<=j}
	 * @param c c[i]��ʾ��i�ſο�����ߵķ���
	 * @param b b[i]��ʾÿ��ߵ�i�ſ�һ����Ҫ���ѵ�ʱ��
	 * @param totalScoresNeeded
	 * @return
	 */
    public int getLeastReviewedTime(int[] c, int[] b,int totalScoresNeeded){
    	if(c.length==0 || c==null || totalScoresNeeded<0)
    		return -1;
    	int[][] dp=new int[c.length][totalScoresNeeded+1];
    	int max=Integer.MAX_VALUE;
    	int n=c.length;
    	
    	for(int j=1;j<=totalScoresNeeded;j++){
    		dp[0][j]=max;   //��ʾ���ٶ�ʱ�䶼û�취���
    		if(j<=c[0]){
    			dp[0][j]=j*b[0];
    		}
    	}

    	for(int i=1;i<n;i++){
    		for(int j=1;j<=totalScoresNeeded;j++){
    			dp[i][j]=dp[i-1][j];
    			for(int k=1; k<=c[i]&&k<=j; k++){
    				if(dp[i-1][j-k]!=max)
    					dp[i][j]=Math.min(dp[i][j], dp[i-1][j-k]+k*b[i]);
    			}
    		}
    	}
    	
    	return dp[n-1][totalScoresNeeded]!=max ? dp[n-1][totalScoresNeeded]:-1;
    }
}

