import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class AOCUtils {


    public static String readParagraphToString(String fileName)
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