class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        int i = 0;
        int j = 0;
        ArrayList<int[]> list = new ArrayList<>();
        while( i < encoded1.length && j < encoded2.length ){
            int start = encoded1[i][0] * encoded2[j][0];
            int end = Math.min(encoded1[i][1], encoded2[j][1]);
            list.add( new int[]{start, end} );
            encoded1[i][1] -= end;
            encoded2[j][1] -= end;

            if( encoded1[i][1] == 0 ){
                i++;
            }
            if( encoded2[j][1] == 0 ){
                j++;
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        i = 0;
        List<Integer> temp = new ArrayList<>();
        temp.add( list.get(0)[0] );
        temp.add( list.get(0)[1] );
        res.add(temp);
        i++;
        while( i < list.size() ){
            List<Integer> prev = res.get(res.size()-1);
            List<Integer> curr = new ArrayList<>();
        
            if( prev.get(0) == list.get(i)[0] ){
                res.remove(res.size()-1);
                int a = prev.get(0);
                int b = list.get(i)[1] + prev.get(1);
                curr.add(a);
                curr.add(b);
            }
            else{
                curr.add( list.get(i)[0] );
                curr.add( list.get(i)[1] );
            }
            res.add(curr);
            i++;
        }
        return res;
    }
}