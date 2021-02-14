
import java.util.*;

class PA1 {

    public static void main(String[] args) {
        // Test your methods here



        String name = null;
        printIntroduction(name);



    }

    public static void printASCIIValues(String input) {

        // TODO: Fill in this method for Exercise 1
        for (int i = 0; i < input.length(); i++) {
            System.out.println(input.charAt(i) + " " + (int) (input.charAt(i)));
        }

    }

    public static int[] rotate1DArray(int[] input, int rotations) {
        // a rotation in a java array means that each of its values are moved one spot to the right
        // plan: make a new array, move the last element to the front, and then shift everything to the right with a for loop
        // rotating an array to the left is the same thing as rotating the array to the length - n times
        //think of square. Starting on side 1, if I rotate to the left

        // TODO: Fill in this method for Exercise 2
        if (rotations < 0) {
            if (rotations * -1 >= input.length) {
                rotations = rotations % input.length;
            }
            rotations = rotations * -1;
            rotations = input.length - rotations;
        }

        int[] temparray = new int[input.length];
        //copies array
        System.arraycopy(input, 0, temparray, 0, temparray.length);

        for (int i = 1; i <= rotations; i++) {

            int[] temparray2 = new int[input.length];
            System.arraycopy(temparray, 0, temparray2, 0, temparray.length);
            int lastNumber = temparray[temparray.length - 1];
            for (int j = 1; j < temparray.length; j++) {
                temparray[j] = temparray2[j - 1];
            }
            temparray[0] = lastNumber;

        }

        return temparray;

    }

    public static int[][] rotate2DArray(int[][] input, int rotations,
            boolean rotateRows) {
        // TODO: Fill in this method for Exercise 3

        if (rotations < 0) {
            if (rotations * -1 >= input.length) {
                rotations = rotations % input.length;
            }
            rotations = rotations * -1;
            rotations = input.length - rotations;
        }
        if (rotateRows == true) {

            int[][] temparray = new int[input.length][input[0].length];

            //for loop to copy the 2d array contents
            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input[i].length; j++) {
                    temparray[i][j] = input[i][j];
                }
            }
            for (int i = 1; i <= rotations; i++) {
                int[][] temparray2 = new int[temparray.length][temparray[0].length];
                for (int k = 0; k < input.length; k++) {
                    for (int j = 0; j < input[0].length; j++) {
                        temparray2[k][j] = temparray[k][j];
                    }
                }

                int[] lastArray = temparray[temparray.length - 1];
                for (int j = 1; j < temparray.length; j++) {
                    temparray[j] = temparray2[j - 1];
                }
                temparray[0] = lastArray;
            }

            return temparray;
        } else {

          int[][] copyArray = new int[input.length][input[0].length];
          // copies the contents of input into copyArray
          for (int m = 0; m < input.length; m++) {
              for (int n = 0; n < input[m].length; n++) {
                copyArray[m][n] = input[m][n];
              }
          }


          for(int j = 1; j<= rotations; j++){
            int[] lastnumbers = new int[copyArray.length];
            int[][] copyArray2 = new int[input.length][input.length];

            //copies content in the second copy of array
            for (int m = 0; m < input.length; m++) {
                for (int n = 0; n < input[m].length; n++) {
                  copyArray2[m][n] = copyArray[m][n];
                }
            }

            //copies the last numbers of every row in the array into lastnumbers array
            for(int i = 0; i < copyArray.length; i++){
              int goingToStored = copyArray[i][copyArray[i].length -1];
              lastnumbers[i] = goingToStored;
            }

            for(int b = 0; b < copyArray.length; b++){
              for(int c = 1; c < copyArray[b].length; c++){
                copyArray[b][c] = copyArray2[b][c-1];
              }
            }

            //makes the first element of each row in the array the numbers stored in lastelements
            for(int z = 0; z < lastnumbers.length; z++){
              copyArray[z][0] = lastnumbers[z];

            }

          }

          return copyArray;

        }

    }

    public static void printIntroduction(String name) {

      String thirdline;

      if(name == null){
        thirdline = "* Hello! Welcome to CSE 8B! *";

      }else if(name.equals("")){
        thirdline = "* Hello" + name + "! Welcome to CSE 8B! *";
      }else{
        thirdline = "* Hello " + name + "! Welcome to CSE 8B! *";
      }

      









      int lengthOfThird = thirdline.length();

      for(int i = 1; i <= lengthOfThird; i++){
        System.out.print("*");
      }

      System.out.println();
      System.out.print("*");

      for(int i = 1; i <= lengthOfThird -2; i++){
        System.out.print(" ");
      }

      System.out.print("*");

      System.out.println();

      System.out.println(thirdline);

      System.out.print("*");
      for(int i = 1; i <=  lengthOfThird -2; i++){
        System.out.print(" ");
      }
      System.out.println("*");

      for(int i = 1; i <= lengthOfThird; i++){
        System.out.print("*");
      }

      System.out.println();


        // TODO: Fill in this method for Exercise 4
    }

}
