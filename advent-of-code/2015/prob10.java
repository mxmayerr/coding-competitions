public class prob10 {
    public static void main(String[] args) {
        
        // solution to AoC 2015 problem 10

        // the data is given below:
        String data = "111221";

        // create a temp variable to store temp information
        String temp = "";

        // create a count variable for use later at 1
        int count = 1;

        // we are told to repeatthe process 40 times
        for (int i = 0; i < 1; i++)
        {
            // loop to loop trhough all parts of the word
            for (int x = 0; x < data.length(); x++)
            {
                // take the first characterand put it into a variable for temp storage
                String character = data.substring(x,x+1);

                // check if the character is the same as the second character
                // if it is, increment the count variable
                // use a while loop here (while next char is the same...)
                int counter = x+1;
                while (data.length() > 3 && character.equals(data.substring(counter,counter+1)))
                {   
                    count++;
                    counter++;
                }

                // now that we know how many ofthe characters repeat,
                // take the temp variable we made in the start and add the count and the char
                // reset count for next time
                temp = temp + Integer.toString(count) + character;
                count = 1;

            }
            // reassign the data number variable as the new number
            data = temp;
            temp = "";

        }

        // return the length of the string
        System.out.println(data.length());
        

    }
}