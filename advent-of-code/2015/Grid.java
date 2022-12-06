// class designed for AoC problen 6 2015

public class Grid 
{
    // variables, 1000x1000 integer grid
    int[][] grid;

    // constructure initializes the grid
    public Grid(int size)
    {
        grid = new int[size][size];
    }

    // method to plotLights
    public void lightsOn(int startX, int startY, int endX, int endY)
    {
        // starting at x to y, change value to one
        for (int y = startY; y < endY + 1; y++)
        {
            for (int x = startX; x < endX + 1; x++)
            {
                grid[y][x]++;
            }
        }
    }

    public void lightsOff(int startX, int startY, int endX, int endY)
    {
        // starting at x to y, change value to one
        for (int y = startY; y < endY + 1; y++)
        {
            for (int x = startX; x < endX + 1; x++)
            {
                if (grid[y][x] != 0)
                    grid[y][x]--;
            }
        }
    }

    public void lightsToggle(int startX, int startY, int endX, int endY)
    {
        // starting at x to y, change value to one
        for (int y = startY; y < endY + 1; y++)
        {
            for (int x = startX; x < endX + 1; x++)
            {
                grid[y][x] = grid[y][x] + 2;
            }
        }
    }

    public void printGrid()
    {
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[r].length; c++)
            {
                System.out.print("[" + grid[r][c] + "]");
            }
            System.out.println();
            
        }
    }

    public int countLights()
    {
        int count = 0;
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[r].length; c++)
            {
                count += grid[r][c];
            }
        }
        return count;
    }

}