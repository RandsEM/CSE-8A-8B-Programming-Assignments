/**
 * Filename: Hourglass.java
 * Name: Darren Yeung; email:dyeung@ucsd.edu; PID: A15943292
 * Login: cs8bwi20rr
 * Date: 1/16/2020
 * Sources of Help: Podcasts, lectures
 *
 * This file contains the functions necessary to draw an hourglass recursively.
 * It includes basic error checking and takes in one command line argument which is the width of the top of the hourglass.
 */

/**
 * This class is used to perform basic error checking and print the hourglass
 * onto the console.
 */


public class Hourglass {

    /** DO NOT MODIFY THESE CONSTANTS */
    // Used to determine if a number is even or odd
    private static final int EVEN_DIVISOR = 2;

    // Number of required arguments
    private static final int REQUIRED_ARGS = 1;

    // Used when width is not valid
    private static final String INVALID_WIDTH_ERR = "Width is not valid!\n";

    // Used when there are more arguments passed in than required
    private static final String EXTRA_ARGS_ERR = "Too many args passed in!\n";

    // Used when no arguments are passed in
    private static final String HELP_STR = "Usage: java Hourglass width\n" +
        "width has to be >= 1 and odd\n";

    // The character the hourglass will be drawn with
    private static final char HOURGLASS_CHAR = '*';

    // The character the padding will be drawn with
    private static final char PADDING_CHAR = ' ';

    /** Declare any constants that you may need here */

    private static final int CENTER_WIDTH =1;




    /**
     * Main function that will read in command line arguments and start the
     * recursion if valid arguments were passed in
     *
     * @param args An array of all the command line arguments passed in
     */
    public static void main(String[] args) {

        // Print help message if no arguments are passed in
        if(args.length == 0){
          System.out.println(HELP_STR);
          return;
        }

        // Check to make sure there is exactly one arg
        if(args.length != 1){
          System.out.println(EXTRA_ARGS_ERR);
          return;
        }

        // Parse the width and make sure it's valid

        int width = Integer.parseInt(args[0]);


        if(width <= 0 || width % EVEN_DIVISOR == 0 ){
          System.out.println(INVALID_WIDTH_ERR);
          return;
        }


        // Calls the printHourglass method with the user inputed width starting
        // with zero padding (because it gradually increases)
        printHourglass(width,0);


    }

    /**
     * Recursive function that will print the hourglass with the specified width
     *
     * @param width   The width of the hourglass
     * @param padding The amount of padding to use to position the hourglass
     */
    protected static void printHourglass(int width, int padding) {


      //base case where recursion stops once the width reaches the center
      if(width == CENTER_WIDTH){
        printLine(width, padding);

      //recursive case where it keeps using the printLine method while making
      //the width smaller(by 2) and the padding bigger (by 1)
      }else{

        printLine(width , padding );
        printHourglass(width -2, padding + 1);
        printLine(width , padding );




      }

    }

    /**
     * Helper function that will print a line of the hourglass
     *
     * @param width   The width of the line in the hourglass
     * @param padding The amount of padding to use to position the line
     */
    protected static void printLine(int width, int padding) {
        // Print the padding character padding times
        for(int i = 0; i < padding; i++) {
            System.out.print(PADDING_CHAR);
        }

        // Print the hourglass character width times
        for(int i = 0; i < width; i++) {
            System.out.print(HOURGLASS_CHAR);
        }

        // Print the padding character padding times
        for(int i = 0; i < padding; i++) {
            System.out.print(PADDING_CHAR);
        }

        // Move to the next line (can also be placed at the top)
        System.out.println();
    }
}
