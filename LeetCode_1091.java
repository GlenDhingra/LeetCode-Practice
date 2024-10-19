class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if (grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1) {
            return -1;
        }

        int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int[][] costArray = new int[grid.length][grid.length];
        for (int[] row : costArray) {
            Arrays.fill(row, Integer.MAX_VALUE - 1);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        costArray[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int i = current[0];
            int j = current[1];
            int cost = costArray[i][j];

            if (i == grid.length - 1 && j == grid[i].length - 1) { 
                return cost;
            }
            grid[i][j] = 1;
            for (int[] direction : directions) {
                int i1 = i + direction[0];
                int j1 = j + direction[1];
                if (i1 >= 0 && i1 < grid.length && j1 >= 0 && j1 < grid[i].length && grid[i1][j1] == 0) { // <-- Inline check
                    if (costArray[i1][j1] > cost + 1) {
                        costArray[i1][j1] = cost + 1;
                        queue.offer(new int[]{i1, j1});
                    }
                }
            }
        }
        return -1;
    }
}
