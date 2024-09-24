class Solution {
    public int maximum69Number (int num) {
        StringBuilder s = new StringBuilder();
        s.append(num);
        int index = s.indexOf("6");
        if(index == -1) return num;
        s.setCharAt(index,'9');
        return Integer.valueOf(s.toString());
    }
}
/*
Convert Integer to a String and check for the first occurance of 6
Replace that 6 with 9
*/