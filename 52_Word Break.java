class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return hasWord(s,wordDict,0,new Boolean[s.length()+1]);
    }
    
    public boolean hasWord(String s, List<String> word, int i, Boolean[] dp){
        
        if(dp[i]!=null){
            return dp[i];
        }  

        if(i>=s.length()){
            dp[i]=true;
            return true;
        }        

        boolean result=false;

        for(String temp: word){
            if(i<=s.length() && s.startsWith(temp,i)){
                result= true && hasWord(s,word,i+temp.length(),dp);
        }
        if(result){
            break;
        }
    }
        dp[i]=result;
        return result;
}
}