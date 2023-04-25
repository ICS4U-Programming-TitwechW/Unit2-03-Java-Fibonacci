import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
* This program find n in the Fibonacci
* sequence then displays the answer.
*
*
* @author Titwech Wal
* @version 1.0
* @since   2023-05-23
*/

public final class Fibonacci {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private Fibonacci() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {

        // Pass path to file as parameter.
        final File input = new File("input.txt");

        // Display on the marks spreadsheet.
        final File output = new File("output.txt");

        try {
            // Create FileWriter object to write to file.
            final FileWriter fW = new FileWriter(output);
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(input);
            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fW);

            while (sc.hasNextLine()) {
                // Read line as string.
                final String str = sc.nextLine();

                try {

                    // Parse(split) the input from file.
                    final int newLine = Integer.parseInt(str);

                    // Declare variable.
                    final int strParse = newLine;

                    // Call function.
                    final int fibAnswer = recFib(strParse);

                    // Check if the number is too low if not display result
                    if (strParse <= 0) {
                        System.out.println("Your number is too low");
                        write.println("Your number is too low");

                    } else {
                        // Displays result to console.
                        System.out.println("The answer is " + fibAnswer);
                        // Displays result to output file.
                        write.println("The answer is " + fibAnswer);
                    }

                } catch (NumberFormatException error) {
                    System.out.println("An error occurred: "
                            + error.getMessage());
                    write.println("An error occurred: "
                            + error.getMessage());

                }
            }

            // Closes scanner & writer.
            write.close();
            sc.close();
        } catch (IOException error) {
            System.out.println("An error occurred: "
                    + error.getMessage());

        }
    }

    /**
     * This function returns n.
     *
     * @param number
     *
     * @return n
     *
     */

    public static int recFib(int number) {

        // Check if the input string is empty.
        if (number <= 1) {
            return number;

        } else {
            return recFib(number - 1) + recFib(number - 2);

        }

    }
}
