// file for solutions to AoC 2022
// https://adventofcode.com/2022
// created by: MCM '22

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Collections;
import java.util.TreeSet;
// import hashmap
import java.util.HashMap;
// import map
import java.util.Map;






public class aoc 
{
    // advent of code, 2022, problem 1
    // counting calories
    public static int p1()
    {
        // put data into an arraylist
        ArrayList<String> data = utils.readLinesToArrayList("data/prob1.txt");
        // create a list of total calories
        List<Integer> total = new ArrayList<Integer>();
        
        // create a sum variable
        int sum = 0;

        // for every line in data
        for (String line : data)
        {
            // if we reach a empty, we know its the end of an elf
            // so add the existing total to our list and reset sum
            if (line.equals(""))
            {
                total.add(sum);
                sum = 0;
            }
            // else, add the current number to the sum
            else 
            {
                sum+=Integer.parseInt(line);
            }
        }
        // FOR PART 1, you can just return sum
        // FOR PART 2, you must find the max three times
        // so, reset the sum variable
        sum = 0;
        // add to sum the max of total
        sum+= Collections.max(total);
        // then get the index of that max and remove it
        int high1 = total.indexOf(Collections.max(total));
        total.remove(high1);
        // repeat this two more times
        sum+= Collections.max(total);
        int high2 = total.indexOf(Collections.max(total));
        total.remove(high2);
        sum+= Collections.max(total);
        int high3 = total.indexOf(Collections.max(total));
        total.remove(high3);

        // return sum
        return sum;

    }

    // advent of code, 2022, problem 2
    // rock paper sizzors problem
    public static int p2()
    {
        // read in data
        ArrayList<String> data = utils.readLinesToArrayList("data/prob2.txt");

        // create a sum variable 
        int sum = 0;

        // THIS IS FOR PART 2
        // the same structure goes for part 1, but the point values are different, so just rethink those
        // to get part one
        // for every string l in data
        for (String l : data)
        {
            // IF OPONENT GOES ROCK
            if (l.substring(0,1).equals("A"))
            {
                // if x, we need to lose, so go sizzors
                if (l.substring(2).equals("X"))
                { 
                    sum += 3; //lose
                }
                // if y,we need to draw, so go rock
                else if (l.substring(2).equals("Y"))
                {
                    sum += 4; //lose
                }
                // if they z, we need to win, so go paper
                else if (l.substring(2).equals("Z"))
                {
                    sum += 8; //lose
                }
            }
            // OPONENT GOES PAPER
            else if (l.substring(0,1).equals("B"))
            {
                // if x, we need to lose, so go rock
                if (l.substring(2).equals("X"))
                { 
                    sum += 1; //lose
                }
                // if y, we need to draw, so go paper
                else if (l.substring(2).equals("Y"))
                {
                    sum += 5; //draw
                }
                // if z, we need to win, so go sizzors
                else if (l.substring(2).equals("Z"))
                {
                    sum += 9; //win
                }
            }
            // IF OPONENT GOES SIZZORS
            else if (l.substring(0,1).equals("C"))
            {
                // we need to lose, so go paper
                if (l.substring(2).equals("X"))
                { 
                    sum += 2; //win
                }
                // we need to tie, so go sizzoes
                else if (l.substring(2).equals("Y"))
                {
                    sum += 6; //lose
                }
                // we ned to win, so go rock
                else if (l.substring(2).equals("Z"))
                {
                    sum += 7; //draw
                }
            }
        }
        return sum;
    }

    // advent of code, 2022, problem 3
    // rucksack problem
    public static int p3()
    {
        // read data into arraylist and create a arraylist of chars
        ArrayList<String> data = utils.readLinesToArrayList("data/prob3.txt");
        ArrayList<String> chars = new ArrayList<>();

        // for every string in data
        // FOR PART 1 (change the increment to 1)
        for (int x = 0; x < data.size(); x+=3)
        {
            // THIS IS FOR PART 2
            // (creating three sets for each three lines of data
            // FOR PART 1 (not shown), you need to create 2 sets of both halfs
            // of data.get(x)
 
            Set<Character> characters1 = new TreeSet<Character>();
            for(int i = 0; i < data.get(x).length(); i++) {
                characters1.add(data.get(x).charAt(i));
            }
            
            Set<Character> characters2 = new TreeSet<Character>();
            for(int i = 0; i < data.get(x+1).length(); i++) {
                characters2.add(data.get(x+1).charAt(i));
            }

            Set<Character> characters3 = new TreeSet<Character>();
            for(int i = 0; i < data.get(x+2).length(); i++) {
                characters3.add(data.get(x+2).charAt(i));
            }
            
            // retain all the characters in all three sets
            // FOR PART 1, you need to retain all the characters in the two sets
            characters1.retainAll(characters2);
            characters1.retainAll(characters3);
            // add the retained character into the chars ararylist
            // characters1.toString returns "[x]" so we need to remove the brackets
            chars.add(characters1.toString().substring(1,2));
        }

        // create a sum variable at 0
        int sum = 0;
        // for string s in chars
        for (String s : chars)
        {
            // get the ascii value and do the proper math to get its value, and increment to sum
            char c = s.charAt(0);
            if (Character.isUpperCase(c))
                sum += (int) c -38;
            else
                sum += (int) c -96;
        }
        return sum;    
    }
    
    // advent of code 2022, problem 4
    // * im not going to lie I did this at 1am so 
    // I kinda forget my thinking towards the end...
    public static int p4()
    {
        // read in data
        ArrayList<String> data = utils.readLinesToArrayList("data/prob4.txt");

        // create a total variable at 0
        int total = 0;

        // for every string in data
        for (String s : data)
        {
            // get first and second half of string
            String r1 = s.substring(0,s.indexOf(","));
            String r2 = s.substring(s.indexOf(",")+1);

            // get the two values of first half of input line
            // add their range to an set
            // example: "3-5" will yeild 3,4,5 in n1
            Set<Integer> n1 = new TreeSet<Integer>();
            int start = Integer.parseInt(r1.substring(0, r1.indexOf("-")));
            int end = Integer.parseInt(r1.substring(r1.indexOf("-")+1));
            while (start <= end)
            {
                n1.add(start);
                start++;
            }

            // do the same as above for the second have of the data
            Set<Integer> n2 = new TreeSet<Integer>();
            start = Integer.parseInt(r2.substring(0, r2.indexOf("-")));
            end = Integer.parseInt(r2.substring(r2.indexOf("-")+1));
            while (start <= end)
            {
                n2.add(start);
                start++;
            }            

            // create duplicate sets for the two ranges
            Set<Integer> n1a = new TreeSet<Integer>();
            n1a = n1;

            Set<Integer> n2a = new TreeSet<Integer>();
            n2a = n2;

            // get the intersection of the two ranges in BOTH directions
            n1a.retainAll(n2a);
            n2.retainAll(n1);
            
            // if either of the ranges are more then 0 (means they have interection), increment total
            if (n1a.size() > 0 || n2.size() > 0)
                total++;
        }
        // return total
        return total;
    }

    // advent of code 2022, problem 5
    // crane with crates problem
    public static void p5()
    {
        // read in the data
        ArrayList<String> data = utils.readLinesToArrayList("data/prob5.txt");

        // create a new instance of Crate class
        Crate c = new Crate();

        // for every s in data
        for (String s : data)
        {
            // parse the input:
            int num = Integer.parseInt(s.substring(5, s.indexOf("f")-1));
            int from = Integer.parseInt(s.substring(s.indexOf("from")+5, s.indexOf("t")-1)) - 1;
            int to = Integer.parseInt(s.substring(s.indexOf("to")+3)) - 1;

            // call the move function with the parsed input
            c.move(from, to, num);
        }
        // print the result
        c.show();  
    }
    
    // advent of code 2022, problem 6
    // differing characters problem
    public static int p6()
    {
        // read in data
        String data = utils.readLinesToArrayList("data/prob6.txt").get(0);
        
        // FOR PART 1, CHANGE TO THIS
        // for (int i = 0; i < 4; i++)
        // {
        //     String s = data.substring(i,i+4);
        
        // for groups of 4/14 letters
        for (int i = 0; i < data.length()-13; i++)
        {
            // get the group of 4/14 letters
            String s = data.substring(i,i+14);
            
            // turn it into a char array
            char[] carray = s.toCharArray();

            // create boolean found for if a duplicate is found
            boolean found = false;

            // for each letter in the group, check if there is a duplicate
            // if there is, set found to true and break
            for (int x = 0; x < s.length(); x++) 
            {
                for (int j = x + 1; j < s.length(); j++) 
                {
                   if (carray[x] == carray[j]) 
                   {
                      found = true;
                      break;
                   }
                }
             }
            
             // if no duplicate is found, return i + 4 (part 1), i + 14 (part 2)
             if (!found)
                return i + 14;
                
        }
        // else, return -1
        return -1;
    }

    
}






