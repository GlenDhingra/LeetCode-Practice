class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        Distance[] distArray = new Distance[points.length];
        for( int i = 0 ; i < points.length ; i++ ){
            Distance obj = new Distance();
            obj.setPoint(points[i]);
            obj.setDist(obj.calculateDist());
            distArray[i] = obj;
        }        
        Arrays.sort(distArray, new Comparator<Distance>(){
            @Override
            public int compare(Distance o1, Distance o2){
                return Double.compare(o1.getDist(), o2.getDist());
            }
        });
        for( int i =0 ; i < k ; i++ ){
            res[i] = distArray[i].getPoint();
        }
        return res;
    }
}
class Distance{
    double dist;
    int[] point;
    public Distance(){

    }
    public double getDist(){
        return dist;
    }
    public int[] getPoint(){
        return point;
    }
    public void setDist(double dist){
        this.dist = dist;
    }
    public void setPoint(int[] point){
        this.point = point;
    }
    public double calculateDist(){
        return Math.abs(Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2)));
    }
}