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
	 * ��ʾ����һϵ�л����б����б��еĵ�i��������ʼ{
	 * �һ�һ������Ľ�ң��ҵ����еĶһ������
	 * �ȿ�������i��Ӳ�ҿ���ȡ������ֵ k>=0 && k*coins[i]<=restMoney
	 * ����i��Ӳ�ҵĸ���ѡ��k���ڿ���i+1��Ӳ������һ� restMoney-k*coins[i]
	 * ���εݹ�
	 * @param coins �洢�Ų�ͬ��Ӳ�ұ�ֵ
	 * @param i coins�ĵ�i������
	 * @param restMoney ��Ҫ�һ��Ľ������
	 * @return �ܵĶһ���
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
	
	// δ��֤
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
	 * @param map  map[i][j]:��ʾ�ӵ�i��������Ӳ�ҿ�ʼ����һ���������Ϊj�ķ���������
	 * 				Ϊ0��ʾ��û�в�����㡢Ϊ-1��ʾ�����˼��㵫�ǽ��Ϊ0������0��ʾʵ�ʵķ�������
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
