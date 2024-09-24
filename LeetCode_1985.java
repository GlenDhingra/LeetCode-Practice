import java.math.BigInteger;
class Solution 
{
    public String kthLargestNumber(String[] nums, int k) 
    {
        /*Method 1 : Using Big Integer
        List<BigInteger> list = new ArrayList<>();
        for( int i = 0 ; i < nums.length ; i++ )
        {
            list.add( new BigInteger( nums[i] ) );
        }
        Collections.sort( list , Collections.reverseOrder() );
        return list.get(k-1).toString();
        */
        //Method 2 [Preffered]
        Arrays.sort( nums , (String o1,String o2) -> {
            if( o1.length() == o2.length() )
            {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        } );
        return nums[ nums.length - k ];
    }
}
/*
Using the functionalities of sort method,sort the array
then return kth largest number
*/