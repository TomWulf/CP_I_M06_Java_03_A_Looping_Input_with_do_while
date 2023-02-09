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

        // Example 1: Here is the Model for using do while loop to get an int
        do {
            // Prompt for input:
            System.out.print("Enter your age: ");
            // check or valid int
            if (in.hasNextInt())
            {
                age = in.nextInt();  //OK read it
                in.nextLine(); // Clear the newline from the buffer
            }
            else  // Bad input not an int
            {
                trash = in.nextLine();  //Read that bad input as a string
                System.out.println("You must enter a valid number not: " + trash + "\n");
            }

        }while (age == 0); // we loop as long as age is still set to zero
                           // but the user could also enter zero or a negative value...
                           // So <= is better restricting age to be positive
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
                    System.out.println("You must enter a value between [1-10] not: "+ favNum);
                }

            }
            else  //  got a bad number
            {
                trash = in.nextLine();
                System.out.println("You must enter a valid number [1-10] not: " + trash + "\n");
            }

        }while (!done); // we loop until this is set to True by the test
        System.out.println("You said your fav num is " + favNum);

        // Example #4 Using a RegEx pattern to confirm input
        done = false;
        String SSN = "";
        String SSN_RegEx = "^\\d{3}-\\d{2}-\\d{4}$";  // SSN RegEx Pattern
        // Inputting Strings  RegEx
        do
        {
            // prompt
            System.out.print("Enter your SSN: ");
            SSN = in.nextLine();
            if (SSN.matches(SSN_RegEx))
                done = true;
            else
              System.out.println("Not a correct SSN: " + SSN);
        }while (!done);
        System.out.println("You said your SSN is " + SSN);

        //  Example #5 Accumulating multiple inputs
        //  Collect a series of temperature readings and compute the average temp
        // here we prompt each time to continue
        double tempDataPoint = 0.0;
        double totalTemps = 0.0;
        double averageTemp = 0.0;
        int numberOfTemps = 0;
        String continueYN = "";
        done = false; // Needs to be false or the loop will terminate after one pass


        do {
            // Prompt for input:
            System.out.print("Enter temperature reading: ");
            if (in.hasNextDouble())
            {
                tempDataPoint = in.nextDouble();
                in.nextLine(); // Clear the newline from the buffer
                // add to the total
                totalTemps += tempDataPoint; // same as totalTemps = totalTemps + tempDataPoint
                // increment the counter
                numberOfTemps++;

                // See if we are continuing
                System.out.print("Continue [YN]: ");
                continueYN = in.nextLine();

                if(continueYN.equalsIgnoreCase("N"))
                    done = true;
            }
            else  //  got a bad number
            {
                trash = in.nextLine();
                System.out.println("You must enter a valid temperature not: " + trash + "\n");
            }
        }while (!done); // we loop until this is set to True by the test

        // Now do the processing
        averageTemp = totalTemps / numberOfTemps;

        System.out.println("The average temp of " + numberOfTemps " readings is " + averageTemp);

        // Eample #6 Entering grades. We use the sentinel pattern 0-100 is a valid grade so -1 is the sentinel

    }
}
