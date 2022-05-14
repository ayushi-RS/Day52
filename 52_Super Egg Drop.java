class Solution {
   public int superEggDrop(int K, int n) {

	//will fail if the answer can be more than 10000 but given the contraints that doesnt happen
    //the worst case according to the constriants is 1 egg 10000 floors and in that case the answer is 10000
    //so to account for that M=10000
	
	int M=10000;
    int dp[][]=new int[M+1][K+1];
    
    for(int i=0;i<=M;i++){
        dp[i][0]=0;
    }
    for(int i=0;i<=K;i++){
        dp[0][i]=0;
    }
    
    
    for(int m=1;m<=M;m++){
        for(int k=1;k<=K;k++){
            dp[m][k]=1+dp[m-1][k-1]+dp[m-1][k];
            if(dp[m][k]>=n)return m;
        }
    }
    return 0;
}
}