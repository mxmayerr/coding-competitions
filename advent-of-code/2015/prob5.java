import java.util.ArrayList;

public class prob5 {

    public static void main(String[] args) {
        // inport strings into an string array

        ArrayList<String> words = new ArrayList<String>();
        words = AOCUtils.readLinesToArrayList("data/input05.txt");
        int count = 0;

        // for every string of the array
        for (int i = 0; i < words.size(); i++)
        {
            // put string into string varuable
            String word = words.get(i);

            // // if the stirng includes ab,cd,pq,xy, immidiely skip the rest and dont count
            // if (!includesLetters(word))
            //     {
            //         if (includesDoubleLetter(word))
            //         {
            //             // if it contains at least three values
            //             if (countVowels(word) >= 3)
            //             {
            //                 count++;
            //             }
            //         }

                    
            //     }

            if (doubleDoubleLetters(word) && repeatingLetters(word))
                count++;
            
        }

        

           System.out.println(count);
           

        //increment count
        
    }

    public static int countVowels(String word)
    {
        int count = 0;
        for (int i = 0; i < word.length(); i ++)
        {
            if (word.substring(i,i+1).equals("a") || word.substring(i,i+1).equals("e") ||word.substring(i,i+1).equals("o") || word.substring(i,i+1).equals("i") || word.substring(i,i+1).equals("u"))
                count++;
        }
        return count;
    }

    public static boolean includesLetters(String word)
    {
        for (int i = 0; i < word.length() - 1; i++)
        {
            if (word.substring(i,i+2).equals("ab") || word.substring(i,i+2).equals("cd") || word.substring(i,i+2).equals("xy") || word.substring(i,i+2).equals("pq"))
                return true;
        }
        return false;
    }

    public static boolean includesDoubleLetter(String word)
    {
        for (int i = 0; i < word.length()-1; i++)
        {
            if (word.substring(i,i+1).equals(word.substring(i+1,i+2)))
                return true;
        }
        return false;
    }

    public static boolean doubleDoubleLetters(String word)
    {
        for (int i = 0; i < word.length() - 3; i++)
        {            
            for (int x = i+2; x < word.length() - 1; x++)
            {
                if (word.substring(i,i+2).equals(word.substring(x,x+2)))
                    return true;
            }
        }
        return false;
    }

    public static boolean repeatingLetters(String word)
    {
        for (int i = 0; i < word.length()-2; i++)
        {
            if (word.substring(i,i+1).equals(word.substring(i+2,i+3)))
                return true;
        }
        return false;
    }
}
