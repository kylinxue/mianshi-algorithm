package wangyi;

import java.util.Scanner;

/**
 * 
 * @author kylinxue
 *
 */
public class MinCoins {

	public static void main(String[] args) {
	// dp[i][j]����coins[0..i]ȡ����Ļ������Ǯ��j�����ٻ�����
	
	// ��ȫ��ʹ��coins[i]����µ��������� dp[i-1][j]
	// ֻʹ��һ��coins[i]����µ��������� dp[i-1][j-coins[i]]+1
	// ... ...  
	// ʹ��k��coins[i]����µ��������� dp[i-1][j-k*coins[i]]+k
	// dp[i][j]=min{dp[i-1][j-k*coins[i]]+k | k>=0 && k*coins[i]<j}


	// �����Ƶ���� dp[i][j]=min{dp[i-1][j],dp[i][j-coins[i]]+1}
		
//		int[] coins=new int[]{2,5,5};
		// ����aim��ֵ
//		Scanner scanner=new Scanner(System.in);
//		while(scanner.hasNextInt()){
//			int aim=scanner.nextInt();
//			int[][] dp=new int[coins.length][aim+1];
//			for(int j=0;j<aim+1;j++){
//				dp[0][j]=j; // ��ֵΪ1��Ӳ�ң����Ǯ��j�Ļ�����Ϊj
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
	 * ����һ����ֵ�Ļ��ң�ÿ�����ҵ��������ޣ���һ�һ����ֵǮ����Ҫ�����ٻ�����
	 * �����Ƶ���� dp[i][j]=min{dp[i-1][j],dp[i][j-coins[i]]+1}
	 * @param coins
	 * @param aim
	 * @return ����ֵΪ-1����ʾ�һ�ʧ�ܣ���ʾ�������öһ�����������Ǯ
	 */
	public int minCoins(int[] coins, int aim){
		if(coins==null || coins.length==0 || aim<0)
			return -1;
		int[][] dp=new int[coins.length][aim+1];
		int max=Integer.MAX_VALUE;
		for(int j=1;j<aim+1;j++){
			if(j>=coins[0] && dp[0][j-coins[0]]!=max)
				dp[0][j]=dp[0][j-coins[0]]+1; // ��ֵΪcoins[0]���Ǯ��j������Ӳ����
			else
				dp[0][j]=max;  // ��ʾ�һ�����
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
	 * ÿöӲ��ֻ��һ����coins��ʾ�ж���öӲ��
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
		//��Ϊһ������ֻ��һö����һ������ֻ�ܶһ�j=coins[0]
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
