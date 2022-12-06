

public class prob3 {
    public static void main(String[] args) {

        Location santa = new Location();
        Location elf = new Location();

        boolean isSanta = true;

        int count = 2;

        String data = AOCUtils.readParagraphToString("data/input03.txt");

        for (int i = 0; i < data.length(); i++)
        {
            if (isSanta)
            {
                if (data.substring(i,i+1).equals("^"))
                    santa.up();
                else if (data.substring(i,i+1).equals("v"))
                    santa.down();
                else if (data.substring(i,i+1).equals(">"))
                    santa.right();
                else
                    santa.left();
                isSanta = false;
            }
            else
            {
                if (data.substring(i,i+1).equals("^"))
                    elf.up();
                else if (data.substring(i,i+1).equals("v"))
                    elf.down();
                else if (data.substring(i,i+1).equals(">"))
                    elf.right();
                else
                    elf.left();
                isSanta = true;
            }
            
            

            if (!elf.hasVisited())
                count++;


            
        }
        System.out.println(count);
        
         
    }
}
