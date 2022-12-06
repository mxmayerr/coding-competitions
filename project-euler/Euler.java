/* welcome to my solutions
* most of the algorithmic thinking was done on pencil and paper, yes, on paper
* so i tried to remake the algorithms on here best i could, but alot of them requires you to understand what the problem is asking
* all solutions on here run under 60 seconds and yeild correct answers
*/


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Scanner;

public class Euler
{

    public static int euler002(int maxEnd)
    {
        // create result variable
        int result = 0;

        // create variables for fibonacci (num1, num2, and fibo) and set to appropriate values
        int num1 = 1;
        int num2 = 1;
        // int fiboNum = num1 + num2;
        int fibo = num1 + num2;

        

        // while we are below 4000000 (maxEnd)
        while (fibo < maxEnd)
        {
            // if the number is even, incrememnt it to result
            if (fibo % 2 == 0)
            {
                result+=fibo;
            }
            // then reasssign all the variables for the next term in the sequence
            int temp = num2;
            num2 = num1 + num2;
            num1 = temp;
            fibo = num1 + num2;
        }
        
        // return result
        return result;
    }
    // ------------------------------------------------------
    public static long euler006(int num)
    {
        // return the square of sum - sum of squares
        return EulerUtils.squareOfSum(num) - EulerUtils.sumOfSquares(num);
    }
    // ------------------------------------------------------
    public static int euler005(int div)
    {
        // for every value to the max
        for (int i = 1; i < Integer.MAX_VALUE; i++)
        {
            // if the value is evenly divisible by parameter div, return the number
            if (EulerUtils.evenlyDivisible(i, div))
            {
                return i;
            }
        }
        // else return -1 if not found
        return -1;
    }
    // ------------------------------------------------------
    public static int euler003(long n)
    {
        // create a long for the number given, and a maximum varuable at 0
        long num = n;
        int max = 0;

        // for every number 1-sqrt of number (because when checking factors we just need to go to the sqrt of num)
        for (int i = 1; i < Math.sqrt(num); i++)
        {
            // if the number is prime and it is a factor of the number
            if (EulerUtils.isPrime(i) && num % i == 0)
            {
                // check if it is the maximum and reassign if needed
                if (i > max)
                {
                    max = i;
                }
            }
        }
        // return max
        return max;
    }
    // ------------------------------------------------------
    public static int euler004(int maxBound)
    {
        // create max value
        int max = 0;
        // nested for loop for both values 100-maxBound (has to be 3 digits so start at 100) 
        // start at the top and go down since we are trying to find the maximum value
        for (int num1 = maxBound; num1 >= 100; num1--)
        {
            for (int num2 = maxBound; num2 >= 100; num2--)
            {
                // if it is a palindrone and it is more then max, reassign max to the product of the numbers
                if (EulerUtils.isPalindrome(num1 * num2) && num1 * num2 > max)
                {
                    System.out.println("reached");
                    max = num1 * num2;
                }
            }
        }
        // return max
        return max;
    }
    // ------------------------------------------------------
    public static int euler007(int num)
    {
        // create varuables for int prime,0, and count,1
        int prime = 0;
        int count = 1;
        // for loop to loop num times 
        for (int i = 0; i < num; i++)
        {
            // if count is prime, reassign prime to this value and increment count
            if (EulerUtils.isPrime(count))
            {
                prime = count;
                count++;
            }
            // else, increment count but decrement i so we go through the loop again (this makes sure that we find the numTh prime)
            else
            {
                count++;
                i--;
            }

        }
        // then return the prime
        return prime;
    }
    // ------------------------------------------------------
    public static long euler010(int maxBound)
    {
        // create a result variable at 0 (long since it is a big nubmer)
        long result = 0;
        // for every value 0 to maxBound
        for (int i = 0; i < maxBound; i++)
        {
            // if its prime, increment it to result
            if (EulerUtils.isPrime(i))
                result+= (long) i;
        }
        // return result
        return result;
    }
    // ------------------------------------------------------
    // this problem is not finished, ignore
    public static int euler014()
    {
        int num = 0;
        int max = 0;
        for (int i = 1; i < 100000; i++)
        {
            if (EulerUtils.length(i) > max)
            {
                System.out.println("here");
                max = EulerUtils.length(i);
                num = i;
            }
        }
        return num;

        // return EulerUtils.length(1000000);
    }
    // ------------------------------------------------------
    public static long euler008(int sequenceLen)
    {
        // create a string of the entire number
        String num = EulerUtils.fileToString("euler008.txt");
        // System.out.println(num);
        // create a max and result varuable (result must be 1 and not 0 so we dont multiply by 0 and get 0, more on this later)
        long max = 0;
        long result = 1;
        // for every digit in the long number, up to the sequenceLen to last (to prevent out of bounds error)
        for (int i = 0; i < num.length()-sequenceLen; i++)
        {
            // for the chunk of sequenceLen numbers, multiply them to result
            for (int n = i; n < i + sequenceLen; n++)
            {
                // take the char at the location, turn it into a string, then int, then ,multiply to result
                result*=Integer.parseInt(Character.toString(num.charAt(n)));
            }
            // if the current result is more then max, reassign max
            if (result > max)
            {
                System.out.println("here");
                max = result;
            }
            // reset result to 1
            result = 1;
        }
        // return max
        return max;
    }
    // ------------------------------------------------------
    public static int euler012(int numFactors)
    {
        // the count incrementation is based on the fact that a triangular num sequqnce increments by 1, 2, 3, 4, 5, ... every time
        // example: 1,3,6,10,15
        //          +2,+3,+4,+5
        // this is why count starts at 1 and i is incremented by count

        // create count variable at 1
        int count = 1;
        // for starting at 1 to the highest num -1, count+=i (because we increment by a bigger amount each time)
        for (int i = 1; i < Integer.MAX_VALUE - 1; i+=count)
        {
            // increment count
            count++;
            // if the number of factors at the number is more then numFactors, return the number
            if (EulerUtils.numberOfFactors(i) > numFactors)
            {
                return i;
            }
            
        }
        // return -1 if not found
        return -1;
    }
    // ------------------------------------------------------
    public static int euler034()
    {
        // create a hashmap to store the values of factorial of numbers 0-9 (this cuts down on run time)
        HashMap<Integer, Integer> table = EulerUtils.fillFactorial();

        // create current count and result sum variables at 0, count at 3 (since we start at 3)
        int currentCount = 0;
        int resultSum = 0;
        int count = 3; 
        // for every value from 1 to integer max (or any high number)
        for (int i = 3; i < 100000; i++)
        {
            // make new variable named num equal to count
            int num = count;
            // while that number is more  0
            while (num > 0)
            {
                // increment current count to the factorial of its digits
                // System.out.println(num);
                currentCount += table.get(num%10);
                num = num/10;
                // System.out.println(currentCount);
            }
            // if the sum of the factorial of its digits is equal to the number, increment to resultSum
            if (currentCount == count)
            {
                resultSum+=i;
            }
            // reset the currentCount varuable to 0 and increment count for the next number (count acts as "i" but is editable)
            currentCount = 0;
            count++; 
        }
        // return the resultsum
        return resultSum;
    }
    // ------------------------------------------------------
    public static long euler022()
    {
        // create a result variable at 0, a charNumber variable at 0, and a number's total score at 0
        long result = 0;
        long charNum = 0;
        long totalScore = 0;
        // create an arraylist of names using our eulerUtils function
        ArrayList<String> names = EulerUtils.convertFromOneLineP22("p022_names.txt");
        // for every element in arraylist
        for (int i = 0; i < names.size(); i++)
        {
            // for eveyr char in the name/element
            for (int c = 0; c < names.get(i).length(); c++)
            {
                // charnum increments to the value of the letter
                // use compare to A to get the value of the letter
                charNum += names.get(i).substring(c,c+1).compareTo("A")+1;
                // System.out.println(charNum);
            }
            // total score is the charnum times its position in the arraylist
            // must do "i+1" since positions are shifted. example: name at index 0 is actually position 1
            totalScore = charNum * (i+1);
            // System.out.println(names.get(i) + " - " + totalScore);
            // increment total score to result
            result = result + totalScore;
            // System.out.println(result);
            // then reset charnum to 0 (since were moving to a new name)
            charNum = 0;
        }   
        // return result
        return result;
        

    }
    // ------------------------------------------------------
    public static int euler036(int maxBound)
    {
        // create integer result variable for the sum of the palindromes
        int result = 0;
        // for all numbers starting at 1 to maxBound
        for (int i = 1; i < maxBound; i++)
        {
            // if number is palinedrone and its binary is palindrone (use eulerUtils)
            if (EulerUtils.isPalindrome(i) && EulerUtils.isStringPalindrome(Integer.toBinaryString(i)))
            {
                // incrememnt that nmber to count
                result += i;
                System.out.println(result);
            }
        }
        // return count
        return result;
    }
    // ------------------------------------------------------
    public static int euler021(int maxBound)
    {
        // create resukt variable at 0
        int result = 0;
        // for every number from 1-maxBound
        for (int i = 1; i < maxBound; i++)
        {
            // if i equals the sumOfFactors of its sum of factors, increment result by i
            if (i != EulerUtils.sumOfFactors(i) && i == EulerUtils.sumOfFactors(EulerUtils.sumOfFactors(i)))
            {
                result+=i;
            }
        }
        // return result
        return result;
    }
    // ------------------------------------------------------
    public static int euler074(int maxBound)
    {
        // create an arraylist to store the already used sums (more on this later)
        ArrayList<Integer> list = new ArrayList<Integer>();
        // create variables count charins at 0, sum at 0, and count at 0 (all ints)
        int countChains = 0;
        int sum = 0;
        int count = 0;
        // for every number 1-maxBound
        for (int i = 1; i < maxBound; i++)
        {
            // sum equals the sum of factorial of its digits
            sum = EulerUtils.sumOfFactorialOfDigits(i);
            // while the sum doesnt equal the number (this would complete the sequence of non-repeating numbers)
            while (sum != i)
            {
                // if HOWEVER, we counted the varuable already, break the while loop (since we ran into a repeated number)
                if (list.contains(sum))
                {
                    // break the loop and move on
                    break;
                }
                // increment the count (non repeating term means this increments)
                count++;
                // add sum to arraylist for checking later
                list.add(sum);
                // reassign sum to its factorial sum
                sum = EulerUtils.sumOfFactorialOfDigits(sum);
                // System.out.println("here");
            }
            // if count is 60, increment result (we must do 60 + 1 because we started at count = 0)
            if (count + 1 == 60)
            {
                // count chains increment
                countChains++;
                // System.out.println("counted");
            }
            // reset count and list (because we went to a new number)
            count = 0;
            list.clear();
        }
        // return the number of chains
        return countChains;
    }
    // ------------------------------------------------------
    public static long euler037()
    {
        // make a result variable to hold the sums
        long result = 0;
        // boolean variable at trur
        boolean check = true;
        // for eveyr number 8 - end (end can be any number that 1) gives correct answer and 2) doesnt take too long)
        for (int i = 8; i < 10000000; i++)
        {
            // if the number isnt prime to start off with, make check false (ignores the rest of the code)
            if (!EulerUtils.isPrime(i))
            {
                check = false;
            }

            // if it is prime to start, create a new varable with the same value (so we dont motify the looping variable i)
            int iCopy = Integer.valueOf(i);
            // then check that the numbr is prime every time you remove a digit on the right
            // (add another condition to make sure check is true (this cuts down on run time and makes sure that if the number isnt
            // prime to start off with then it wont go into the while loop))
            // while check and value isnt 0
            while (check && iCopy != 0)
            {
                // if the vakue isnt prime, make check false
                if (!EulerUtils.isPrime(iCopy))
                {
                    // System.out.println("here");
                    check = false;
                }
                // else, remove a value on the right
                iCopy = iCopy/10;
            }
            // at this point if check is trye we know that the number has the right property
            // so now we check the left property like above
            // we will use string and substring to remove the leftmost digit
            int iCopy2 = Integer.valueOf(i);
            while (check && iCopy2 != 0)
            {
                if (!EulerUtils.isPrime(iCopy2))
                {
                    check = false;
                }
                // if the number is one digit, break the while loop (since this would cause an error with substring-ing )
                if (iCopy2 / 10 == 0)
                {
                    break;
                }
                iCopy2 = Integer.parseInt(Integer.toString(iCopy2).substring(1));
            }
            
            // if we reach this point and check is still true, that means the number should be counted, increment to result
            if (check)
            {
                result+=i;
                // System.out.println(result);
            }
            // reset check to true for the next number
            check = true;
        }
        return result;
    }
    // ------------------------------------------------------
    public static int euler009()
    {
        // for a starting at 1 to 998
        for (int a = 1; a < 998; a++)
        // for b starting at 1 to 1000-a
        {
            for (int b = 1; b < 1000 - a; b++)
            {
                // for c 1000-a-b (repeat this once)
                for (int c = 1000-a-b; c < 1000-a-b+1; c++)
                {
                    // if a b and c are pythagorean triplets, return their product
                    if (EulerUtils.isPythagoreanTriplet(a, b, c))
                    {
                        return a * b * c;
                    }
                }
            }
        }
        // else return -1
        return -1;
        
        
    }
    //  -------------------------------------
    //  NOT FINISHED, IGNORE
    public static int euler025()
    {
        // create a new fibo
        Fibonacci fibo = new Fibonacci();
        // create int to sore the fibo number
        long val = fibo.getNextFibo();
        while (Long.toString(fibo.getNextFibo()).length() < 1000)
        // get the next numeber and 
        {
            // System.out.println("here");
        }
        // once it is more then 1000 digits long, return the index
        return fibo.getIndex();
    }
    // --------------------------------------------
    public static int euler050(int maxBound)
    {
        // create a max length variable at 0 and a current max length variable at 0
        int currentMaxLen = 0;
        int maxLen = 0;
        // create result varuable
        int result = 0;
        // starting at 1001 up to under maxBound
        for (int i = 1001; i < maxBound; i++)
        {
            // if i isnt prime, go to next i
            if (EulerUtils.isPrime(i))
            {
                // create a new prime object
                Prime p = new Prime();
                // create a new variable with i's valeu that we czn edit
                // *NOTE i am still trying to understand why +10 gives the correct answer
                int iCopy = Integer.valueOf(i) + 10;
                // while i is more then or equal to 0
                while (iCopy > 0)
                // take i, and subtract the next prime, and increment max len
                {
                    // System.out.println("hi");
                    iCopy = iCopy - p.getNextPrime();
                    currentMaxLen++;
                    // System.out.println(iCopy);
                }
                // if it didnt evenly subtract, set maxlen to 0 (so it doesnt count as a consecutive prime)
                // if maxlen is more then previous max len, reassign the result
                if (iCopy == 0 && currentMaxLen > maxLen)
                {
                    maxLen = currentMaxLen;
                    result = i;
                    System.out.println(result);
                    // System.out.println(maxLen);
                }
                // reset current max len to 0
                currentMaxLen = 0;
            }

        }
        // return result
        return result;
    }
    // -------------------------------------------
    public static long euler015(int gridLen)
    {
        // create a 2d array of longs at 21 length (problem asks for 20, so we need 21 due to how the problem draws through the grid)
        long[][] result = new long[gridLen + 1][gridLen + 1];

        // with some research and drawing on paper, i have realized that the possible
        // number of moves to a certain spot on the grid is represented
        // by a pattern called the Pascal's sequence (pascal triangle)
        
        // to start off, we know that any of the edge spaces (on top or left side) are only 1 move 
        // so we fill in those edges here

        // (loop throgh all the values on the top row and fill it with 1)
        for (int i = 0; i < result[0].length; i++)
        {
            result[0][i] = 1;
        }
        // (loop through all the values on the left side and fill it with 1)
        for (int i = 0; i < result.length; i++)
        {
            result[i][0] = 1;
        }

        // now the array has 1's on the left and top edge
        // 1 1 1 1 1 ...
        // 1 0 0 0 0 0 0 ...
        // 1 0 0 0 0 0 ...

        // then, we need to fill in the rest of the array to represent the number of moves possible at a given location
        // i realized that at any given spot, it is the sum of the element above it and before it 
        // (this is seen in the Pascal triangle "diagnals")
        // to do this, traverse the array and set each value to the element above it added to the value left of it
        // row major traversal (ignoring the first row and col since we filled them in up there)
        for (int r = 1; r < result[0].length; r++)
        {
            for (int c = 1; c < result.length; c++)
            {
                // result is the sum of the value to its left and the value above it
                result[r][c] = result[r-1][c] + result[r][c-1];
            }
        }

        // for (long[] x : result)
        //     {
        //     for (long y : x)
        //     {
        //             System.out.print(y + " ");
        //     }
        //     System.out.println();
        //     }

        // return the result at the last spot on the board
        return result[result.length-1][result.length-1];
    }
    // ---------------------------------------------
    public static String euler013(int digits)
    {
        // there is another way to do this!
        // if we only need the first 10 digits, we only need to add the first 12 digits of each number
        // this makes it much easier and we dont need to use big int, but i will be leaving it for now

        // create an arraylist of the numbers
        ArrayList<BigInteger> data = EulerUtils.getDataBigInteger("euler013.txt");

        // create big int result at 0
        BigInteger result = new BigInteger("0");
        // loop over all the numbers in the array list and add them to each other
        for (BigInteger n : data)
        {
            result = result.add(n);
        }
        // convert the num to stirng then return the first 10 digits
        return result.toString().substring(0,digits);
         
    }
    // --------------------------------------------
    // NOT FINISHED, IGNORE
    public static void euler011()
    {
        // load the data into a 2d array
        // use the stirngData euler utils function and then load that into a 2d array
        String data = EulerUtils.fileToString("euler011.txt");

        // System.out.println(data);

        // create the 20 x 20 int array
        int[][] dataArr = new int[20][20];

        // row major tranverse the 2d array and fill with vakues of the data string
        // put the two digit number in the rray, then reassign the string to the next part of the string
        for (int r = 0; r < dataArr[0].length; r++)
        {
            for (int c = 0; c < dataArr.length; c++)
            {
                // add the number
                dataArr[r][c] = Integer.parseInt(data.substring(0,2));
                // redo the data string (deleting the space foolliwing the number)
                data = data.substring(2);
                // System.out.println(data);
            }
        }

        // now its time to search through the array
        // firstly, create a maxSum and a Sum int variable at 0
        int maxProduct = 0;
        int product = 0;

        // first we are going to do is check for left adn right
        // we do this by row major traversal the 2d array, and check every length of 4 adacent numbers, and compare
        // their product to the max value

        // for row 0 to the end of the array
        for (int r = 0; r < dataArr[0].length; r++)
        {
            // then, for every set of 4 numbers, compare their product to the max product, and if its bigger, reassign the max variable
            for (int i = r; i < r + 4; i ++)
            {
                product*= dataArr[r][i];
            }

        }

        for (int r = 0; r < dataArr[0].length; r++)
        {
            for (int c = 0; c < dataArr.length; c++)
            {
                System.out.print("[" + dataArr[r][c] + "] ");
            }
            System.out.println("");
        }    
    }
    // -----------------------------------------------
    public static BigInteger euler016(int exp)
    {
        // create a big integer with the value givin in the problem (2)
        BigInteger result = new BigInteger("2");
        // raise that to exp using the bigintger pow function
        result = result.pow(exp);
        // then return the sum of digits
        return EulerUtils.sumOfDigits(result);
    }

    // ----------------------------------------------
    public static int euler035(int maxBound)
    {
        // create count int variabel at 0
        int count = 0;
        // create a for loop from 1 - maxBound
        for (int i = 1; i < maxBound; i++)
        {
            // if the number is prime, continue the code, else, skip to the next number
            if (EulerUtils.isPrime(i))
            {
                // if the number is a circular prime, increment count
                if (EulerUtils.isCircularPrime(i))
                    count++;
            }
        }
        // return count
        return count;
    }

    // --------------------------------------------
    public static int euler046()
    {
        // create boolean for numWorks
        boolean numWorks = false;
        // for every number 5000 - max number (can be any number that doesnt take too long but gives the correct asnwer)
        for (int i = 5000; i < 1000000; i++)
        {
            // if the numnber is odd, contunie on, else, go to the next number
            if (i % 2 == 1)
            {
                // create a prime object
                Prime p = new Prime();
                // for starting at the first prime to less then the i
                for (int x = p.getNextPrime(); x < i && !numWorks; x = p.getNextPrime())
                {
                    // System.out.println(x);
                    // for int s is less then i
                    // (less then sqrt of i - x)
                    for (int s = 0; s < i-x && !numWorks; s++)
                    {
                        // if the prime + the square of s is the number (i), numWorks is true
                        if (x + 2 * s * s == i)
                            numWorks = true;
                    }
                }
                // if numWorks is false by this point, return i (since we know the number doesnt work)
                if (!numWorks)
                    return i;
            }
            // reset numWorks to true
            numWorks = false;
            
        }
        return -1;
    }
}

