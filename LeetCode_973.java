/*
Merge Sort - Time Limit Exceeded (Correct Answer)
Quick Sort - Accepted
*/
class Solution 
{
    public int[][] kClosest(int[][] points, int k) 
    {
        /*mergeSort( points , 0 , points.length - 1 );
        return Arrays.copyOfRange(points,0,k);*/
        quickSort( points , 0 , points.length - 1 );
        return Arrays.copyOfRange(points,0,k);
        
    }
    public int getDist( int[] arr )
    {
        return (int)( Math.pow( arr[0]  ,2 ) + Math.pow( arr[1]  , 2) );
    }
    
    public void quickSort( int[][] points , int low , int high )
    {
        if( low > high )
        {
            return;
        }
        int i = low;
        int k = low;
        int pivotValue = getDist( points[high] );
        while( k < high )
        {
            if( getDist(points[k]) < pivotValue )
            {
                int[] temp = points[i];
                points[i] = points[k];
                points[k] = temp;
                i++;
            }
            k++;
        }
        int[] temp = points[high];
        points[high] = points[i];
        points[i] = temp;
        
        quickSort( points , low , i - 1 );
        quickSort( points , i + 1 , high );
    }
    public int[][] mergeSort( int[][] points ,int low , int high )
    {
        if( low < high )
        {
            int mid = (high+low)/2;
            mergeSort( points , low ,mid );
            mergeSort( points , mid+1 ,high );
            merge( points , low , high, mid );
        }
        return points;
    }
    public void merge( int[][] points , int low , int high,int mid )
    {
        if( low >= high )
        {
            return;
        }
        else if( low == high - 1 )
        {
            if( getDist( points[low] ) > getDist( points[high] ) )
            {
                int[] temp = points[low];
                points[low] = points[high];
                points[high] = temp;
            }
            return;
        }
        else
        {
            int[][] temp = new int[points.length][2];
            int i = low;
            int j = mid+1;
            int k = low;
            while( i <= mid && j <= high )
            {
                if( getDist( points[i] ) < getDist( points[j] ) )
                {
                    System.out.println(Arrays.toString(points[i]));
                    temp[k] = points[i];
                    i++;
                    k++;
                }
                else
                {
                    System.out.println(Arrays.toString(points[j]));
                    temp[k] = points[j];
                    j++;
                    k++;
                }   
            }
            if( i <= mid )
            {
                while( i <= mid )
                {
                    temp[k] = points[i];
                    i++;
                    k++;
                }
            }
            if( j <= high )
            {
                while( j <= high )
                {
                    temp[k] = points[j];
                    j++;
                    k++;
                }
            }
            for( int a = low ; a <= high ; a++ )
            {
                points[a] = temp[a];
            }
        }
    }
}