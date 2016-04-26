package wangyi;

public class CountsOfChange {

	public static void main(String[] args) {
		int[] coins = new int[]{2,4};
		int res = coins(coins,  4);
		
		System.out.println(res);
	}
	
	 public static int coins(int[] coins, int money){
		if(coins==null || coins.length==0 || money<0)
			return 0;
		
		return findCounts(coins, 0, money);		
	}
	
	/**
	 * 表示给定一系列货币列表，从列表中的第i个索引开始{
	 * 兑换一定数额的金币，找到所有的兑换结果。
	 * 先看看当第i个硬币可能取的所有值 k>=0 && k*coins[i]<=restMoney
	 * 当第i个硬币的个数选定k后，在看第i+1个硬币如果兑换 restMoney-k*coins[i]
	 * 依次递归
	 * @param coins 存储着不同的硬币币值
	 * @param i coins的第i个索引
	 * @param restMoney 需要兑换的金币数额
	 * @return 总的兑换数
	 */
	public static int findCounts(int[] coins, int i, int restMoney){
		if(i==coins.length){
			if(restMoney==0)
				return 1;
			else return 0;
		}	
		
		int count=0;
		for(int k=0; k*coins[i]<=restMoney; k++){
			count += findCounts(coins, i+1, restMoney-k*coins[i]);
		}
		
		return count;
	}
	
	// 未验证
	public static int coinsByMap(int[] coins, int money,int[][] map){
		if(coins==null || coins.length==0 || money<0)
			return 0;
		
		return findCountsByMap(coins, 0, money, map);	
	}
	
	/**
	 * 
	 * @param coins
	 * @param index
	 * @param restMoney
	 * @param map  map[i][j]:表示从第i个索引的硬币开始计算兑换货币总数为j的方法总数。
	 * 				为0表示还没有参与计算、为-1表示参与了计算但是结果为0、大于0表示实际的方法总数
	 * @return
	 */
	public static int findCountsByMap(int[] coins, int index, int restMoney, int[][] map ){
		if(index==coins.length){
			return restMoney==0?1:0;
		}
		int count=0;
		for(int k=0;k*coins[index]<=restMoney;k++){
			if(map[index+1][restMoney-k*coins[index]]==0){
				count+=findCountsByMap(coins,index+1,restMoney-k*coins[index],map);
			}else{
				if(map[index+1][restMoney-k*coins[index]]!=-1)
					count+=map[index+1][restMoney-k*coins[index]];
			}
		}
		return count;
	}

}
