// Prime class


public class Prime
{
    // int num to store the prime
    private int num;

    // default consturctor sets num to 1
    public Prime()
    {
        num = 1;
    }

    // getNextPrime method returns an integer of the next prime in the sequence
    public int getNextPrime()
    {
        // for eveyr number  from number +1 to the end
        for (int i = num+1; i < Integer.MAX_VALUE; i++)
        {
            // if the number is prime, set num to i  and return i
            if (EulerUtils.isPrime(i))
            {
                num = i;
                return i;
            }
        }
        // else, return -1 (this wont get trigged but must be included)
        return -1;
    }
}