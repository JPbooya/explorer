import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ExplorerSearchTest {
    @Test            
     public void testReachableArea_someUnreachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }

    // Add more tests here!ste
    // Come up with varied cases

     @Test
    public void testForReachAbleIsland() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };

        int[] start = {3,4};
        List<int[]> moves = ExplorerSearch.reachAbleIsland(island, start);
        assertEquals(3, moves.size());
    }

     @Test
    public void testForLeftCornerLocation() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };

        int[] start = {0,0};
        List<int[]> moves = ExplorerSearch.reachAbleIsland(island, start);
        assertEquals(1, moves.size());
    }

    @Test
    public void testFindsLocation() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };

        int[] actual = ExplorerSearch.findsLocation(island);
        assertArrayEquals(new int[]{3,4}, actual);
    }

}
