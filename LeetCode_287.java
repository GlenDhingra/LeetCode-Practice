/*
	As constant space is required , we use binary search[without sorting]
	[1,3,3,2]

	so if we find elements less than and equal to 2 in 1st iteration
	we find only 2 elements

	so inc low
	when we find elements less than or equal to 3
	we find 4 elements[but there should be 3 if no duplicates exists]
	
*/

class Solution {
    public int findDuplicate(int[] nums) 
    {
        int low = 1;
        int high = nums.length - 1;
        int duplicate = -1;
        
        while( low <= high )
        {
            int curr = (low + high) / 2;
            
            int count = 0;
            for( int num : nums )
            {
                if( num <= curr )
                    count++;
            }
            
            if( count > curr )
            {
                duplicate = curr;
                high = curr - 1;
            }
            else
            {
                low = curr + 1;
            }
        }
        return duplicate;
    }
}
