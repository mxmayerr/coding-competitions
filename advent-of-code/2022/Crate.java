
// import string builder
import java.lang.StringBuilder;

public class Crate 
{
    String[] stack;

    public Crate()
    {
        stack = new String[9];
        stack[0] = "ZJNWPS";
        stack[1] = "GST";
        stack[2] = "VQRLH";
        stack[3] = "VSTD";
        stack[4] = "QZTDBMJ";
        stack[5] = "MWTJDCZL";
        stack[6] = "LPMWGTJ";
        stack[7] = "NGMTBFQH";
        stack[8] = "RDGCPBQW";

    }

    public void show()
    {
        for (int i = 0; i < stack.length; i++)
        {
            System.out.print(stack[i].substring(stack[i].length()-1));
        }
    }

    public void move(int from, int to, int num)
    {
        String s = stack[from];

        if (num > s.length())
        {
            num = s.length();
        }

        // num is the size of the string we need to move

        String move = stack[from].substring(s.length()-num);
			
        stack[from] = stack[from].substring(0, s.length()-num);   

        // FOR PART 1
        // StringBuilder sb = new StringBuilder(move);
        // stack[to] = stack[to] + sb.reverse().toString();

        // FOR PART 2
        stack[to] = stack[to].concat(move);


    }
}
