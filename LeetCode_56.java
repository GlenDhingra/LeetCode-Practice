class Solution {
    public int[][] merge(int[][] intervals) {
        Interval[] intervalArray = new Interval[intervals.length];
        for( int i = 0 ; i < intervals.length ; i++ ){
            Interval obj = new Interval(intervals[i][0], intervals[i][1]);
            intervalArray[i] = obj;
        }
        Arrays.sort(intervalArray, new Comparator<Interval>() {
            @Override
            public int compare(Interval obj1, Interval obj2) {
                return Integer.compare(obj1.start, obj2.start);
            }
        });
        ArrayList<Interval> list = new ArrayList<>();
        list.add(intervalArray[0]);
        int i = 1;
        while(i < intervalArray.length){
            Interval prev = list.get(list.size()-1);
            Interval current = intervalArray[i];
            if( current.getStart() <= prev.getEnd() ){
                int min = prev.getStart();
                int max = Math.max(current.getEnd(), prev.getEnd());
                list.remove(list.size()-1);
                list.add(new Interval(min, max));
            }
            else{
                Interval obj = new Interval(current.getStart(), current.getEnd());
                list.add(obj);
            }
            i++;
        }
        int[][] res = new int[list.size()][2];
        for( int j = 0 ; j < list.size() ; j++ ){
            res[j][0] = list.get(j).getStart();
            res[j][1] = list.get(j).getEnd();
        }
        return res;
    }
}
class Interval{
    int start, end;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
    public int getStart(){
        return start;
    }
    public int getEnd(){
        return end;
    }

}