import java.util.ArrayList;
import java.util.Arrays;

public class prob1 {

    public static void main(String[] args) {

        String data = AOCUtils.readParagraphToString("data/input01.txt");

        // System.out.println(data);

        int floor=0;

        for (int i= 0; i < data.length();i++)
        {
            if (data.substring(i,i+1).equals(")"))
                floor --;
            else   
                {floor++;}
            
            if (floor == -1)
                {System.out.println(i+1);
                break;
                }
        }

        // System.out.println(floor);

    }
}
