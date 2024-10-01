class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        StringBuilder sb = new StringBuilder(s);
        return helper(sb, wordDict, 0);
    }
    public boolean helper( StringBuilder sb, List<String> wordDict, int flag ){
        if(sb.length() == 0) return true;
        for( int i = 0 ; i < wordDict.size() ; i++ ){
            String curr = wordDict.get(i);

            if(sb.indexOf(curr) == 0){
                StringBuilder sb1 = new StringBuilder(sb);
                boolean result = helper(sb1.delete(0, curr.length()), wordDict, flag);
                if( result ){
                    flag = 1;
                    break;
                }
            }
        }
        return flag == 1;
    }
}
/*
leetcode
curr=leet
s1=leet

code
curr=code



*/