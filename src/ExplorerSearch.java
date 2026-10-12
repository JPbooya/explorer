import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExplorerSearch {

    /**
     * Returns how much land area an explorer can reach on a rectangular island.
     * 
     * The island is represented by a rectangular int[][] that contains
     * ONLY the following nunbers:
     * 
     * '0': represents the starting location of the explorer
     * '1': represents a field the explorer can walk through
     * '2': represents a body of water the explorer cannot cross
     * '3': represents a mountain the explorer cannot cross
     * 
     * The explorer can move one square at a time: up, down, left, or right.
     * They CANNOT move diagonally.
     * They CANNOT move off the edge of the island.
     * They CANNOT move onto a a body of water or mountain.
     * 
     * This method should return the total number of spaces the explorer is able
     * to reach from their starting location. It should include the starting
     * location of the explorer.
     * 
     * For example
     * 
     * @param island the locations on the island
     * @return the number of spaces the explorer can reach
     */
    public static int reachableArea(int[][] island) {
        int[] start = findsLocation(island);
        boolean[][] visited =  new boolean[island.length][island[0].length];
        Stack<int[]> toVisit = new Stack<>();
        toVisit.push(start);

        int count = 0;

        while(!toVisit.isEmpty()) {
            int[] current = toVisit.pop();

            if(visited[current[0]][current[1]]) {
                continue;
            }

            visited[current[0]][current[1]] = true;
            count++;

            List<int[]> neighbors = reachAbleIsland(island, current);
            for(int[] neighbor : neighbors) {
                toVisit.push(neighbor);
            }
        }

        return count;
    }

    public  static List<int[]> reachAbleIsland(int[][] island , int[] current ) {
        List<int[]> neighbors = new ArrayList<>();

        int row =  current[0];
        int col = current[1];

        // up
        if(row -1 >= 0 && (island[row - 1][col] == 0 || island[row-1][col] == 1 )) {
            int[] up = {row -1, col};
            neighbors.add(up);
        }

        // down
        if(row + 1 < island.length && (island[row +1][col] == 0 || island[row +1][col] == 1)) {
            int[] down = {row +1, col};
            neighbors.add(down);
        }

        // left
        if(col -1 >= 0 && (island[row][col - 1] == 0 || island[row][col -1] == 1)) {
            int[] left = {row, col -1};
            neighbors.add(left);
        }

        // right
        if(col + 1 < island[row].length && (island[row][col + 1] == 0 || island[row][col +1] == 1)) {
            int[] right = {row, col +1};
            neighbors.add(right);
        }

        return neighbors;
    }

    public static int[] findsLocation(int[][] island) {
        for(int row = 0; row < island.length; row++) {
            for(int col = 0; col < island[row].length; col++) {
                if(island[row][col] == 0) {
                    int[] newLocation = {row,col};
                    return newLocation;
                }
            }
        }
        throw new IllegalArgumentException("no valid location");
    }
}
