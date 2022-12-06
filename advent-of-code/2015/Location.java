import java.util.ArrayList;

// class tp keep track of locaiton on a grid, specifically for problem 3 in 2015
public class Location {
    
    // instance feilds x cord and y cord
    int xPos;
    int yPos;
    // feilds for array to kepe track of if you have bene in position
    static ArrayList<Integer> xPosList;
    static ArrayList<Integer> yPosList;

    // consturcer to initialize the cords at 0,0 and mark that they have been at 0,0 alreafy
    public Location()
    {
        xPos = 0;
        yPos = 0;

        xPosList = new ArrayList<>();
        yPosList = new ArrayList<>();

        xPosList.add(0);
        yPosList.add(0);

    }

    //methods to move the poition and add the new position to the record
    public void up()
    {
        if (!hasVisited())
            record();
        yPos++;
    }

    public void down()
    {
        if (!hasVisited())
            record();
        yPos--;
    }

    public void left()
    {
        if (!hasVisited())
            record();
        xPos--;
    }

    public void right()
    {
        if (!hasVisited())
            record();
        xPos++;
    }

    // method to check if you have been to speicfic placve before and if not, adds to recvord

    private void record()
    {
        xPosList.add(xPos);
        yPosList.add(yPos);
    }
    public boolean hasVisited()
    {
        // System.out.println(xPosList);
        // System.out.println(yPosList);
        
        
        for (int i = 0; i < xPosList.size(); i++)
        {
            if (xPos == xPosList.get(i) && yPos == yPosList.get(i))
            {
                return true;
            }
        }
        return false;
    }

    public String position()
    {
        return "X: " + xPos + ", Y: " + yPos;
    }




}