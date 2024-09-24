class Solution {
    public List<String> summaryRanges(int[] nums) 
    {
        List<String> list = new ArrayList<>();
        if( nums.length == 0 )
        {
            return list;
        }
        if( nums.length == 1 )
        {
            list.add(""+nums[0]);
            return list;
        }
        
        int i = 0;
        int j = i + 1;
        int k = i;
        while( j < nums.length )
        {
            
            if( nums[k] + 1 != nums[j] )
            {
                if( i == k )
                {
                    list.add(nums[k] + "");
                    i++;
                    j++;
                    k++;
                }
                else
                {
                    list.add(nums[i]+"->"+nums[k]);
                    i = j;
                    k = i;
                    j++;
                    
                }
            }
            else
            {
                j++;
                k++;
            }
        }
        if( j >= nums.length && i != nums.length - 1 )
        {
            list.add(nums[i]+"->"+nums[k]);
        }
        else
        {
            list.add(nums[i]+"");
        }
        return list;
    }
}