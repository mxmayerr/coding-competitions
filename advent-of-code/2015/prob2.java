import java.util.ArrayList;
import java.util.Collections;

public class prob2
{

    public static void main(String args[])
    {
        // get data
        ArrayList<String> data = AOCUtils.readLinesToArrayList("data/input02.txt");
        ArrayList<Integer> numbers = new ArrayList<>();

        int total= 0;

        for (int i = 0; i < data.size();i++)
        {
            String set = data.get(i);

            int temp = set.indexOf("x");
            numbers = new ArrayList<>();
            numbers.add(Integer.parseInt(set.substring(0,temp)));
            set = set.substring(temp+1);

            // System.out.println(set);
            
            

            temp = set.indexOf("x");
            numbers.add(Integer.parseInt(set.substring(0,temp)));
            set = set.substring(temp+1);

            // System.out.println(set);
            

            numbers.add(Integer.parseInt(set.substring(0)));
            Collections.sort(numbers);
            System.out.println(numbers);
            
            
            // System.out.println(i);
            
            // total += 2 * numbers.get(0) * numbers.get(1) + 2 * numbers.get(1) * numbers.get(2) + 2 * numbers.get(0) * numbers.get(2) + numbers.get(0) * numbers.get(1);
            total += numbers.get(0) + numbers.get(0) + numbers.get(1) + numbers.get(1) + numbers.get(0) * numbers.get(1) * numbers.get(2);
            // System.out.println(total);
            
        }

        System.out.println(total);

    }
}