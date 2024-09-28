class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if( gas.length == 1 && gas[0] >= cost[0]){
            return 0;
        }
        for( int i = 0 ; i < gas.length ; i++ ){
            if( gas[i] > cost[i]) {
                boolean a = helper(i, gas, cost);
                if( a ){
                    return i;
                }
            }
        }
        return -1;
    }
    public boolean helper( int i, int[] gas, int[] cost ){
        int len = gas.length;
        int g = 0;
        int index = i;
        if( index == 0 ){
            index = gas.length;
        }
        while( i != (index-1) % len ){
            g += gas[i];
            if(g < cost[i]) return false;
            g -= cost[i];
            i += 1;
            if( i == len ) i = 0;
        }
        if( g + gas[i] < cost[i] ){
            
            return false;
        }
        return true;
    }
}
