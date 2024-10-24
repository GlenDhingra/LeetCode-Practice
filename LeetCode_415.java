class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while( i >= 0 && j >= 0 ){
            int n1 = num1.charAt(i) - '0';
            int n2 = num2.charAt(j) - '0';
            int res = n1 + n2 + carry;
            carry = res / 10;
            res = res % 10;
            sb.append(res);
            i--;
            j--;
        }
        while( i >= 0 ){
            int n1 = num1.charAt(i) - '0';
            int res = n1 + carry;
            carry = res / 10;
            res = res % 10;
            sb.append(res);
            i--;
        }
        while( j >= 0 ){
            int n2 = num2.charAt(j) - '0';
            int res = n2 + carry;
            carry = res / 10;
            res = res % 10;
            sb.append(res);
            j--;
        }

        if( carry != 0 ){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}