class Solution 
{
    public int totalFruit(int[] fruits) 
    {
        HashSet<Integer> set = new HashSet<>();
        
        int i = 0;
        int j = 0;
        int mark = 0;
        int max = 0;
        while( j < fruits.length )
        {
            
            if( set.contains(fruits[j]) )
            {
                j++;
            }
            else if( !set.contains( fruits[j] ) && set.size() < 2 )
            {
                set.add( fruits[j] );
                mark = j;
                j++;
            }
            else
            {
                max = Math.max( max , (j-i) );
                set.clear();
                i = mark;
                j = mark;
            }
        }
        max = Math.max( max , (j-i) );
        return max;
    }
}
/*
{Not the best approach}

Sliding Window Problem
Add elements at j till set size does not exceed 2
set a pointer(mark) when a new element is encountered which was not present in the set and set size < 2
if new element is encountered and set size == 2 then move i to the pointer(mark) and clear the set
update the max before set is cleared

*/