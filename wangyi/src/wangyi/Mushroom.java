package wangyi;
import java.util.Scanner;

public class Mushroom {

	public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
        	int N=scanner.nextInt();
            int M=scanner.nextInt();
            int K=scanner.nextInt();
            int[][] pos=new int[K][2];
            for(int i=0;i<K;i++){
                pos[i][0]=scanner.nextInt();
                pos[i][1]=scanner.nextInt();
            }
            Mushroom mushroom=new Mushroom();
            int[][] NM=mushroom.getNM(N, M, K, pos);
            int count = mushroom.scanMushroom(NM);
            count += mushroom.scanMushroom(NM);
            
            System.out.println(count);
        }
        
    }
	
	public int[][] getNM(int N, int M, int K, int[][] pos){
		if(N<3) N=3;
    	if(M<3) M=3;
        int[][] NM=new int[N+1][M+1];
    	for(int i=1;i<=N;i++){
    		for(int j=1;j<=M;j++){
    			NM[i][j]=0;
    		}
    	}
    	
    	for(int i=0;i<K;i++){
    		++NM[pos[i][0]][pos[i][1]];
    	}
    	
    	return NM;
	}
    
    public int scanMushroom(int[][] NM){
    	int maxCount=0; 
    	// 数组是按行向量存储的
    	int N=NM.length-1;
    	int M=NM[0].length-1;
    	
        CountAndPos rc1=getMushroomInRect(NM, 2, 2);   //记录3*3矩形内最大蘑菇数和此时矩形的中心坐标
    	for(int i=2;i<=N-1;i++){
    		for(int j=2;j<=M-1;j++){
    			CountAndPos rc2= getMushroomInRect(NM, i, j);
    			if(maxCount<rc2.countInRect){
    				rc1=rc2;
    				maxCount = rc2.countInRect;
    			}
    		}
    	}
    	
    	// 扫描蘑菇后清除蘑菇
    	int centerX=rc1.x;
    	int centerY=rc1.y;
    	for(int i=-1;i<=1;i++){
    		for(int j=-1;j<=1;j++){
    			if(NM[centerX+i][centerY+j]>0){
    				--NM[centerX+i][centerY+j];
    			}
    		}
    	}    
    	
        return maxCount;
    }
    
    public CountAndPos getMushroomInRect(int[][]NM,int centerX, int centerY){
    	int countInRect=0;
    	for(int i=-1;i<=1;i++){
    		for(int j=-1;j<=1;j++){
    			if(NM[centerX+i][centerY+j]>0){
    				countInRect++;
    			}
    		}
    	}
    	CountAndPos cp = new CountAndPos(countInRect,centerX,centerY);
    	return cp;
    }
    
    private class CountAndPos{
    	public int countInRect;
    	public int x;
    	public int y;
    	public CountAndPos(int count, int x, int y){
    		this.countInRect=count;
    		this.x=x;
    		this.y=y;
    	}
    }

}
