class Solution 
{
    public boolean canVisitAllRooms(List<List<Integer>> rooms) 
    {
        HashSet<Integer> set = new HashSet<>();
        dfs(rooms,rooms.get(0),set);
        set.remove(0);
        return set.size() == rooms.size() - 1;
    }
    public void dfs(List<List<Integer>> rooms,List<Integer> curr,HashSet<Integer> set)
    {
        for(int i = 0 ; i < curr.size() ; i++)
        {
            if(!set.contains(curr.get(i)))
            {
                set.add(curr.get(i));
                dfs(rooms, rooms.get(curr.get(i)),set );   
            }
        }
    }
}
/*
    DFS approach
    Used set cause it has constant lookup
*/