// Fibonacci class 

public class Fibonacci
{
    // create instance feilds: long num1, num2, and fibonum, and then make an integer index instance
    private long fiboNum;
    private long num1;
    private long num2;
    private int index;

    // defaul contricter initializes the numbers to their appropreate value
    // index is 0, num1 is 0, num2 = 1, fubonum can be anything, but will makje it 0 in this case
    public Fibonacci()
    {
        index = 0;
        num1 = 0;
        num2 = 1;
        fiboNum = 0;
    }

    // getNextFibo method returns the next fibonacci number in a sequence
    public long getNextFibo()
    {
        // if the index is 0 (meaning that we havebnt generated an number yet, return 1 and increment index)
        // before this, the code would "forget" the second 1 in the begginging 0, 1, >1<, 2, 3, 5,..
        if (index == 0)
        {
            index++;
            return 1;
        }
        // increment all the values
        // fibonum is both num1 and num2
        fiboNum = num1 + num2;
        // num1 is set to num2
        num1 = num2;
        // num2 is set to fibonum
        num2 = fiboNum;
        // increment index
        index++;
        // then return the fiboNum
        return fiboNum;
    }

    // method getIdnex returns index
    public int getIndex()
    {
        return index;
    }
}