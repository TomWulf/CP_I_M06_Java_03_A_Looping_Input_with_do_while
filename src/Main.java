import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String trash = "";
        int age = 0; //  We loop as long as this is still zero
        int favNum = 0;
        double wages = 0.0;

        // Example 1: Here is the Model for using do while to loop to get an int
        do {
            // Prompt for input:
            System.out.print("Enter your age: ");
            // check or valid int
            if (in.hasNextInt())
            {
                age = in.nextInt();  //OK read it
                in.nextLine(); // Clear the newline from the buffer
            }
            else
            {
                trash = in.nextLine();  //Read that bad input as a string
                System.out.println("You must enter a valid number not: " + trash + "\n");
            }

        }while (age == 0); // we loop as lng as age is still set to zero
                        // but the user could also enter zero or a negative value... <=
        System.out.println("You said your age is " + age);

        // Example 2: Here is better version that uses a general boolean control variable instead

        boolean done = false; // Needs to be false or the loop will terminate after one pass
        do {
            // Prompt for input:
            System.out.print("Enter your age: ");
            if (in.hasNextInt())
            {
                age = in.nextInt();
                in.nextLine(); // Clear the newline from the buffer
                done = true;
            }
            else
            {
                trash = in.nextLine();
                System.out.println("You must enter a valid number not: " + trash + "\n");
            }

        }while (!done); // we loop until this is set to True by the test
        System.out.println("You said your age is " + age);

        // Example 3: Getting a value in a range  Fav Num must be [1-10]
        done = false; // Needs to be false or the loop will terminate after one pass
        do {
            // Prompt for input:
            System.out.print("Enter your favorite number [1-10]: ");
            if (in.hasNextInt())
            {
                favNum = in.nextInt();
                in.nextLine(); // Clear the newline from the buffer
                // Right here we add the extra test to enforce the range
                if(favNum >= 1 && favNum <= 10)
                {
                    done = true; // Now we end the loop here when it meets the extra test
                }
                else // User entered an int but it was not in the range
                {
                    System.out.println("You must enter a value between [1-10]: ");
                }

            }
            else
            {
                trash = in.nextLine();
                System.out.println("You must enter a valid number [1-10] not: " + trash + "\n");
            }

        }while (!done); // we loop until this is set to True by the test
        System.out.println("You said your fav num is " + favNum);

    }
}
