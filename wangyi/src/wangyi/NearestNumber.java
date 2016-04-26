package wangyi;

public   class  NearestNumber {  
	  
    public   static   void  main(String[] args) {   
        int A[] = { 1, 5, 7, 8, 9, 6, 3, 11, 20, 17 };   
        func(A);  
    }  
  
    static   void  func( int  A[]) {  
        int  i;  
        int  j;  
  
        int  n2 = A.length;  
        int  n = n2 /  2 ;  
        int  sum =  0 ;  
        for  (i =  0 ; i < A.length; i++) {  
            sum += A[i];  
        }  
  
        /** 
         * flag[i][j]:任意i个数组元素之和是j,则flag[i][j]为true 
         */   
        boolean  flag[][] =  new   boolean [A.length +  1 ][sum /  2  +  1 ];  
        for  (i =  0 ; i < A.length; i++)  
            for  (j =  0 ; j < sum /  2  +  1 ; j++)  
                flag[i][j] = false ;  
          
        flag[0 ][ 0 ] =  true ;  
          
        for  ( int  k =  0 ; k < n2; k++) {  
            for  (i = k > n ? n : k; i >=  1 ; i--) {  
                // 两层外循环是遍历集合S(k,i)  前k个元素中任意取i个元素的和的集合 
                for  (j =  0 ; j <= sum /  2 ; j++) {  
                    if  (j >= A[k] && flag[i -  1 ][j - A[k]])  
                        flag[i][j] = true ;  
                }  
            }  
        }  
        for  (i = sum /  2 ; i >=  0 ; i--) {  
            if  (flag[n][i]) {  
                System.out.println("sum is "  + sum);  
                System.out.println("sum/2 is "  + sum /  2 );  
                System.out.println("i is "  + i);  
                System.out.println("minimum delta is "  + Math.abs( 2  * i - sum));  
                break ;  
            }  
        }  
    }  
}  