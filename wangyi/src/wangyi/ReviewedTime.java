package wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class ReviewedTime{	
	
	public static void main(String[] args)throws Exception{
        Scanner scanner=new Scanner(System.in);

        while(scanner.hasNext()){
        	int n = scanner.nextInt();
            int r = scanner.nextInt();  // 每门课的满分
            int avg = scanner.nextInt();
            int[] a=new int[n]; // 每门课的平时成绩
            int[] b=new int[n]; // 每门得一分所需要的复习时间
            int[] c=new int[n]; // 每门课最多可以提高的分数 
            int totalScoresNeeded=0; //为了达到目标需要提高的总分数
            
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
	 * dp[i][j] 表示前i门课得到分数j所需要的最少时间
	 * dp[i][j]=min{dp[i-1][j-k]+k*b[i] | 0<=k<=c[i]&&k<=j}
	 * @param c c[i]表示第i门课可以提高的分数
	 * @param b b[i]表示每提高第i门课一分需要花费的时间
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
    		dp[0][j]=max;   //表示花再多时间都没办法达标
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

