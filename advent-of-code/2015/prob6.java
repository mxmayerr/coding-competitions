import java.util.ArrayList;

public class prob6 {
    

    public static void main(String[] args) {
        

        // read input into seperate ararylist lines
        ArrayList<String> data = new ArrayList<>();

        data = AOCUtils.readLinesToArrayList("data/input06.txt");

        Grid g = new Grid(1000);
        

        // for every input of data
        for (int i = 0; i < data.size(); i++)
        {
            // make a string and assign it to the current line we are working on
            String s = data.get(i);
            // given the data, determine if we need to turn off, on, or toggle

            if (s.contains("turn on"))
            {
                // now, get the numbers and send to the class
                g.lightsOn(Integer.parseInt(s.substring(8,s.indexOf(","))), Integer.parseInt(s.substring(s.indexOf(",")+1,s.indexOf("th")-1)), Integer.parseInt(s.substring(s.indexOf("through")+8,s.indexOf(",", s.indexOf(",")+1))), Integer.parseInt(s.substring(s.indexOf(",", s.indexOf(",")+1) +1)));
            }
            else if (s.contains("turn off"))
            {
                g.lightsOff(Integer.parseInt(s.substring(9,s.indexOf(","))), Integer.parseInt(s.substring(s.indexOf(",")+1,s.indexOf("th")-1)), Integer.parseInt(s.substring(s.indexOf("through")+8,s.indexOf(",", s.indexOf(",")+1))), Integer.parseInt(s.substring(s.indexOf(",", s.indexOf(",")+1) +1)));
            }
            else
            {
                g.lightsToggle(Integer.parseInt(s.substring(7,s.indexOf(","))), Integer.parseInt(s.substring(s.indexOf(",")+1,s.indexOf("th")-1)), Integer.parseInt(s.substring(s.indexOf("through")+8,s.indexOf(",", s.indexOf(",")+1))), Integer.parseInt(s.substring(s.indexOf(",", s.indexOf(",")+1) +1)));

            }
            
        }

        System.out.println(g.countLights());
        
    }
}
