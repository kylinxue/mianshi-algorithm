package wangyi;

import java.util.Arrays;
import java.util.Scanner;
public class lightDistance {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		while(scanner.hasNext()){
			int n=scanner.nextInt();
			long l=scanner.nextLong();
			long[] a=new long[n];
			
			for(int i=0;i<n;i++){
				a[i] = scanner.nextLong();
			}
			Arrays.sort(a);
			float d=(float)getMaxLightDistance(a);
			float toStart=(float)a[0];
			float toEnd=(float)(l-a[n-1]);

			float max=getMaxFrom(d/2, toStart, toEnd);
			
			System.out.println(String.format("%.2f", max));
		}	
	}
	
	static int getMaxDistance(int[] a, int start, int end){
		if(start==end) return 0;
		int d=getMaxDistance(a,start,end-1);
		
		return Math.max(d, a[end]-a[end-1]);
	}
	
	static float getMaxFrom(float a, float b, float c){
		float max=a;
		if(max<b) max=b;
		if(max<c) max=c;
		
		return max;
	}
	
	static long getMaxLightDistance(long[] a){
		int n=a.length;
		long distance=0;
		for(int i=1;i<n;i++){
			long d=a[i]-a[i-1];
			if(distance < d){
				distance=d;
			}
		}
		
		
		return distance;
	}

}
