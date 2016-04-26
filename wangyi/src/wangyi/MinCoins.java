package wangyi;

import java.util.Scanner;

/**
 * 
 * @author kylinxue
 *
 */
public class MinCoins {

	public static void main(String[] args) {
	// dp[i][j]：从coins[0..i]取任意的货币组成钱数j的最少货币数
	
	// 完全不使用coins[i]情况下的最少张数 dp[i-1][j]
	// 只使用一张coins[i]情况下的最少张数 dp[i-1][j-coins[i]]+1
	// ... ...  
	// 使用k张coins[i]情况下的最少张数 dp[i-1][j-k*coins[i]]+k
	// dp[i][j]=min{dp[i-1][j-k*coins[i]]+k | k>=0 && k*coins[i]<j}


	// 最终推导结果 dp[i][j]=min{dp[i-1][j],dp[i][j-coins[i]]+1}
		
//		int[] coins=new int[]{2,5,5};
		// 输入aim的值
//		Scanner scanner=new Scanner(System.in);
//		while(scanner.hasNextInt()){
//			int aim=scanner.nextInt();
//			int[][] dp=new int[coins.length][aim+1];
//			for(int j=0;j<aim+1;j++){
//				dp[0][j]=j; // 币值为1的硬币，组合钱数j的货币数为j
//			}
//			for(int i=1;i<coins.length;i++){
//				for(int j=0;j<aim+1;j++){
//					if(coins[i]>j){
//						dp[i][j]=dp[i-1][j];
//					}else{
//						dp[i][j]=Math.min(dp[i-1][j], dp[i][j-coins[i]]+1);
//					}
//				}
//			}
//			System.out.println(dp[coins.length-1][aim]);
//		}
		
		int[] coins=new int[]{2,5,5};
		int aim = 15;
		int n = new MinCoins().minCoinsOne(coins, aim); 
		System.out.println(n);
			
	}
	
	/**
	 * 给定一定币值的货币，每个货币的数量不限，求兑换一定数值钱所需要的最少货币数
	 * 最终推导结果 dp[i][j]=min{dp[i-1][j],dp[i][j-coins[i]]+1}
	 * @param coins
	 * @param aim
	 * @return 返回值为-1，表示兑换失败，表示不能正好兑换，还得找零钱
	 */
	public int minCoins(int[] coins, int aim){
		if(coins==null || coins.length==0 || aim<0)
			return -1;
		int[][] dp=new int[coins.length][aim+1];
		int max=Integer.MAX_VALUE;
		for(int j=1;j<aim+1;j++){
			if(j>=coins[0] && dp[0][j-coins[0]]!=max)
				dp[0][j]=dp[0][j-coins[0]]+1; // 币值为coins[0]组合钱数j的最少硬币数
			else
				dp[0][j]=max;  // 表示兑换不了
		}
		int right;
		for(int i=1;i<coins.length;i++){
			for(int j=0;j<aim+1;j++){
				right=max;
				if(coins[i]<=j && dp[i][j-coins[i]]!=max){
					right=dp[i][j-coins[i]]+1;
				}
				dp[i][j]=Math.min(dp[i-1][j],right);
			}
		}
		
		return dp[coins.length-1][aim] != max ? dp[coins.length-1][aim] : -1;
	}
	
	/**
	 * 每枚硬币只有一个，coins表示有多少枚硬币
	 * dp[i][j]=min{dp[i-1][j],dp[i-1][j-coins[i]]+1}
	 * @param coins
	 * @param aim
	 * @return
	 */
	public int minCoinsOne(int[] coins, int aim){
		if(coins==null || coins.length==-1 || aim<0)
			return -1;
		int n=coins.length;
		int max=Integer.MAX_VALUE;
		int[][] dp=new int[n][aim+1];
		for(int j=1;j<=aim;j++){
			dp[0][j]=max;
		}
		//因为一个货币只有一枚，第一个货币只能兑换j=coins[0]
		if(coins[0]<=aim)  
			dp[0][coins[0]]=1;
		
		int leftup;
		for(int i=1;i<coins.length;i++){
			for(int j=0;j<=aim;j++){
				leftup=max;
				if(j>=coins[i] && dp[i-1][j-coins[i]]!=max){
					leftup=dp[i-1][j-coins[i]]+1;
				}
				dp[i][j]=Math.min(dp[i-1][j], leftup);
			}
		}
		
		return dp[n-1][aim]!=max?dp[n-1][aim]:-1;
	}

}
