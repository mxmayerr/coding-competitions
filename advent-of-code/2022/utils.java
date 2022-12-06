// utility functions for AoC 2022


import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class utils 
{
    

    /* sums the sqare of 1...n 
    * return long result
    */ 
    public static long sumOfSquares(int n)
    {
        // create result
        long result = 0;
        // square the number and increment it to result
        for (int i = 1; i <= n; i++)
        {
            result+=(i * i);
        }
        return result;
    }

    /* squares the sum of 1...n 
    * return long result
    */ 
    public static long squareOfSum(int n)
    {
        // create result
        long sum = 0;
        // increment the number to sum then square it
        for (int i = 1; i <= n; i++)
        {
            sum+=i;
        }
        return (sum * sum);
    }


    /* checks if num is evenly divisible by 1...n
    * return boolean result
    */     
    public static boolean evenlyDivisible(int num, int n)
    {
        // for every number 1.. n
        // if it doesnt evenly divide, return false
        for (int i = 1; i <= n; i++)
        {
            if (num % i != 0)
            {
                return false;
            }
        }
        return true;
    }
    /* checks is a number is prime
    * return boolean result
    */ 
    public static boolean isPrime(int n)
    {
        // base caseses in which we can cross out immidietly
        if (n <= 1)
        {
            return false;
        }
        if (n <= 3)
        {
            return true;
        }
  
        // then check if the number is a multiple of 2 or 3
        // this is checked so we can skip 2,3, and 4 (and all even numbers) in the loop below (cuts down on run time)
        if (n % 2 == 0 || n % 3 == 0)
        {
            return false;
        }
        
        // for starting at 5 to the squareroot of n (multiplying i * i is faster then doing Math.sqrt())
        for (int i = 5; i * i <= n; i = i + 6)
        {
            // if the number evenly divides into i OR i + 2(because we need to check for i and i+2. ex: 5 OR 7 (we already checked for evens above)), return false
            if (n % i == 0 || n % (i + 2) == 0)
            {
                return false;
            }
            
        }
        // else return true
        return true;
    
    }


    /* checks if n is a palindrome or not
    * returns boolean result
    */
    public static boolean isPalindrome(int n)
    {
        return (n == Integer.reverse(n));
    }

    /* checks if a, b, and c are pythagorean triplets
    * returns boolean result
    */
    public static boolean isPythagoreanTriplet(int a, int b, int c)
    {
        // as per rules:
        return (a < b && b < c && a * a + b * b == c * c);
    }

    /* returns the length of the collatz sequance starting at n
    * this is still a work in progress
    * returns an int
    */
    public static int length(int n)
    {
        // as per rules:
        if (n % 2 == 0)
        {
            return 1 + length(n/2);
        }
        else if (n == 1)
        {
            return 1;
        }
        else 
        {
            return 1 + length(n*3 + 1);
        }
    }

    /* this takes a filename, looks for the file, and then turns it into a single string
    * returns a string
    */
    public static String fileToString(String fileName)
    {
        // create a String to store the data
       String result = "";
       
        try 
        {
        // constructor of File class having file path/name as argument
        // in this case just a filename because file is in same folder
        File file = new File(fileName);
        // pass file to be scanned to Scanner constructor
        Scanner sc = new Scanner(file);
        // returns true if and only if scanner has another token
        while (sc.hasNextLine())
        { result+=sc.nextLine(); }
        // close the scanner
        sc.close();
        }
        catch(Exception e) // in case file is not found
        { e.printStackTrace(); }

        // return the arraylist
        return result;
        
    }

    /* returns number of factors a number has
    * returns an int
    */
    public static int numberOfFactors(int n)
    {
        // create  count vairable
        int count = 0;
        // for every number to the sqrt of the number, increment count by 2 (since for ex 20 has a factor set of 5 AND 4)
        for (int i = 1; i <= Math.sqrt(n); i++)
        {
            if (n % i == 0)
            {
                count+=2;
                
            }
        }
        return count;
    }

    /* returns the factorial of a number n
    * returns an int
    */
    public static int factorial(int n)
    {
        // if n is 0, return 1
        if (n == 0)
        {
            return 1;
        }
        // else, return n * factorial of n -1
        else
        {
            // return the num times the next num
            return (n * factorial(n-1));
        }
    }

    /* returns the factorial of a number n
    * returns an int
    */
    public static BigInteger factorial(BigInteger n)
    {
        // if n equals 0, return 1
        if (n.equals(new BigInteger("0")))
        {
            return (new BigInteger("1"));
        }
        // else, return n * factorial of n - 1
        else
        {
            // return the num times the next num
            return (n.multiply(factorial(n.subtract(new BigInteger("1")))));
            
        }
    }

    /* creates a dictionary (hashmap) of numbers 0-9 and their factorial value
    * returns a hashmap of Integer, Integer
    */
    public static HashMap<Integer, Integer> fillFactorial()
    {
        // create a hashmap named result with Integer, Integer type
        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
        // for 0 to 9 inclusive
        for (int i = 0; i <= 9; i++)
        {
            // i into the key and the factorial of i into the value
            result.put(i, factorial(i));
        }
        // return the hashmap
        return result;
    }

    /* this is specially designed for problem 22
    * takes a file, and takes all the lines onto one string
    * returns a string
    */
    public static ArrayList<String> convertFromOneLineP22(String fileName)
    {
        // cereate an arraylist of string type
        ArrayList<String> result = new ArrayList<>();

        // read input the entire file into one string:
        try 
        {
        
        File file = new File(fileName);

        Scanner sc = new Scanner(file);

        // create string variable with the file input named fileString
        String fileString = sc.nextLine();
        sc.close();

        // System.out.println(fileString);

            // while the string stil has length and it contains " (meaning we havent reached the end)
        while (fileString.length() != 0 && fileString.contains("\","))
        {
            // starting index is the index of the first "
            int startingIndex = fileString.indexOf("\"");
            // end index is the index of the ",
            int endingIndex = fileString.indexOf("\",");

            // add the substring of fileString with start and end index variables
            result.add(fileString.substring(startingIndex+1,endingIndex));
            // reassign the filestring variable to ending index + 2
            fileString = fileString.substring(endingIndex+2);
        }

        // add ther last part to the list
        result.add(fileString.substring(1,fileString.length()-1));

        }
        // catch exeption
        catch(Exception e) // in case file is not found
        { e.printStackTrace(); }

        // sort the arralist
        Collections.sort(result);
        // return list
        return result;

    }

    // /* creates a 2d array with numbers in a spiral
    // *   numbers are integers starting at 1 to the max needed value
    // */  
    // public static int[][] fillSpiralArray(int size)
    // {
    //     // create a result array with the size
    //     // create a count which will be used to fill the array
    //     // 

    //     return int[100][100];
    // }

    /* turns decimal nubmer into its binary representation
    * returns an integer in binary form
    */
    public static int decimalToBinary(int dec)
    {
        // return the integer form of a dicimal number in binary
        return Integer.parseInt(Integer.toBinaryString(dec));
    }

    /* determines if a string is a palendrone or not
    * returns a boolean
    */
    public static boolean isStringPalindrome(String s)
    {
        // create variables for index
        // x = 0, y is length of string - 1 (so no out of bounds)
        int x = 0;
        int y = s.length()-1;

        // while the letters are still apart, check if same
        while (y > x)
        {
            // if letter at x does not equal the letter at y, return false
            if (s.charAt(x) != s.charAt(y))
            {
                return false;
            }
            // increment x and decrement y (moves to next letters)
            x++;
            y--;
        }
        // if it reaches the end, return true
        return true;
    }

    /* returns the sum of the factors of the given number
    * returns an int
    */
    public static int sumOfFactors(int n)
    {
        // create a count variable 
        int count = 0;
        // for 1-sqrt of the number
        for (int i = 1; i <= Math.sqrt(n); i++)
        {
            // if the num divides evenly to i
            if (n % i == 0)
            {
                // if both factors are the same, add it once
                if (i == (n / i))
                {   
                    count += i;
                }    
                // else, add it for both (since sometimes factors come in pairs. ex: 5 and 4 in 20)
                else
                {
                    count += (i + n / i);
                }
            }
        }
        // return count - n (since we dont want to count the number utself)
        return count-n;
    }
     

    /* returns the sum of the factorial of the digits of a number
    * returns an int
    */
    public static int sumOfFactorialOfDigits(int n)
    {
        // create result variable at 0
        int result = 0;
        // while n is not 0
        while (n != 0)
        {
            // for every digit, increment its factorial to result
            result += factorial(n % 10);
            // n = n / 10
            n = n / 10;
        }
        return result;
    }

     /* returns the sum of the digits of a number
    * returns an int
    */
    public static int sumOfDigits(int n)
    {
        // create reult variable at 0
        int result = 0;
        // while n is not 0
        while (n != 0)
        {
            // for every digit, increment its value to result
            result += n % 10;
            // remove the outmost digit (since we just added it)
            n = n / 10;
        }
        return result;
    }

    /* returns the sum of the digits of a BIG INTEGER number
    * returns bigInteger 
    */
    public static BigInteger sumOfDigits(BigInteger n)
    {
        // create biginteger result variable at 0
        BigInteger result = new BigInteger("0");
        // create a biginterger with a value of 10 (used in the loop later)
        BigInteger ten = new BigInteger("10");
        // while n is not 0
        while (!n.equals(new BigInteger("0")))
        {
            // for every digit, increment its value to result
            result = result.add(n.mod(ten));
            // remove the outmost digit (since we just added it)
            n = n.divide(ten);
        }
        return result;
    }


    /* returns the triangular form of the number
    */
    public static int triangular(int n)
    {
        // return n(n+1)/2 (triangular form)
        return n * (n + 1) / 2;
    }

    /* returns the pentagonal form of the number
    */
    public static int pentagonal(int n)
    {
        // return n(3n-1)/2
        return n * ( 3 * n - 1) / 2;
    }


    /* returns the hexagonal form of the number
    */
    public static int hexagonal(int n)
    {
        // return n ( 2n-1)
        return n * (2 * n - 1);
    }

    /* returns data from a file in BigInteger datatype
    * returns ararylist of BigIntegers
    */
    public static ArrayList<BigInteger> getDataBigInteger(String fileName)
    {
        // create ArrayList of Strings to store the data, line by line
       ArrayList<BigInteger> result = new ArrayList<>();
       
       try 
       {
       // constructor of File class having file path/name as argument
       // in this case just a filename because file is in same folder
       File file = new File(fileName);
       // pass file to be scanned to Scanner constructor
       Scanner sc = new Scanner(file);
       // returns true if and only if scanner has another token
       while (sc.hasNextLine())
       { result.add(sc.nextBigInteger()); }
       // close the scanner
       sc.close();
       }
       catch(Exception e) // in case file is not found
       { e.printStackTrace(); }

       // return the arraylist
       return result;
       
   }

   // rotates the digits in a number by one digit to the right
   public static int rotateDigits(int n)
   {
       // if the the number is one digit, return the number
       if (n < 10)
            return n;
       // turn n into a string 
       String num = Integer.toString(n);
       // take the last digit, and move it to the front of the string
       // return the string (convert from stirng to int) up to the last digit, wiht the last digit in the front
       return Integer.parseInt(num.substring(num.length()-1) + num.substring(0,num.length()-1));
   }
    
   // returns true if a number is a circular prime
   // make sure to pass this function a prime number
   public static boolean isCircularPrime(int primeNum)
   {
       // for the length of the number - 1 (since we already know ther first config is prime)
       for (int i = 0; i < Integer.toString(primeNum).length()-1; i++)
       {
        // reassign primeNum to the roation of its digits
        primeNum = rotateDigits(primeNum);
        // if the new number isnt prime, return false
        if (!isPrime(primeNum))
            return false;
       } 
       // else, return true
       return true;
   }

   public static String readParagraphToString(String fileName) throws FileNotFoundException
    {
        // create a String to store the data
       String result = "";
       
       try 
       {
       // constructor of File class having file path/name as argument
       // in this case just a filename because file is in same folder
       File file = new File(fileName);
       // pass file to be scanned to Scanner constructor
       Scanner sc = new Scanner(file);
       // returns true if and only if scanner has another token
       while (sc.hasNextLine())
       { result+=sc.nextLine(); }
       // close the scanner
       sc.close();
       }
       catch(Exception e) // in case file is not found
       { e.printStackTrace(); }

       // return the arraylist
       return result;
    }

    public static ArrayList<String> readLinesToArrayList(String filename)
    {
        ArrayList<String> result = new ArrayList<String>();

        try{
            File file = new File(filename);

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine())
            {
                result.add(sc.nextLine());
            }

            sc.close();
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }


   
}

