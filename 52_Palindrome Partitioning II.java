class Solution {
    public int minCut(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];//bool dp to store whether palindrome or not
        for(int g=0;g<s.length();g++)// gap strategy
        {
            for(int i=0,j=g;j<dp.length;i++,j++)
            {
                if(g==0)//if gap is zero--> a,b,c...
                    dp[i][j]= true;// single characters are palindrome..
                else if(g==1)//if gap is one--> ab,bc,cc...
                {
                    if(s.charAt(i)==s.charAt(j))// if both characters are alike then palindrome..
                        dp[i][j]= true;// true..
                    else
                        dp[i][j]=false;// else false
                }
                else// rest other
                {
                    if(s.charAt(i)==s.charAt(j)&& dp[i+1][j-1]== true)//for 3 char or more.. extreme characters to be equal and also between them..
                        dp[i][j]=true;
                    else
                        dp[i][j]=false;
                }
            }
        }
        int[] dp1= new int[s.length()];// 1d dp1 array to store minimum cuts
        dp1[0]=0;// 0 for 1st char.. as single character..
        for(int j=1;j<dp1.length;j++)//from second element till end of dp1..
        {
            int min = Integer.MAX_VALUE;// min giving maximum value
            for(int i=j;i>=0;i--)// from j to start of dp1..
            {
                if(i==0 && dp[i][j]==true)// if iterated to 0 and all characters from ij in dp table is true.. 
                    min=0;// min is 0 as no need of cuts..
                else if(dp[i][j]==true)// if for any ith position and ij from dp table is true..
                    min=Math.min(min,dp1[i-1]+1);// take the minimum of given min with the previous dp1 array(+1 as we cut through word)
            }
            dp1[j]=min;// assign in dp table at jth position.
        }
        return dp1[dp1.length-1];// and return the last element as the word min-cuts is last element in dp1..
    }
}