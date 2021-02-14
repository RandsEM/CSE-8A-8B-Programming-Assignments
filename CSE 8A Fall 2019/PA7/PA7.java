import java.awt.Color;

public class PA7 {

    // ------------------------------------------------------------------------
    // Tests
    // ------------------------------------------------------------------------

    public static void testCanvas() {
        // Create a blue canvas with width 5 and height 10
        Image canvas1 = new Image(5, 10, Color.blue);

        // Verify the result is a 10x5 blue canvas
        canvas1.explore();

        // TODO: Add two more test cases
    }

    public static void testCrop() {
        // Create a 4x4 2D array
        Color[][] test1 = { { Color.black, Color.black, Color.red, Color.red }, // row0
                { Color.black, Color.black, Color.red, Color.red }, // row1
                { Color.black, Color.black, Color.red, Color.red }, // row2
                { Color.black, Color.black, Color.black, Color.black } // row3
        };

        // Create an image from the array and crop the bottom right corner

        Image img1 = new Image(test1);
        Image cropped1 = img1.crop(2, 0, 4, 3);

        // Visualize the cropped picture
        cropped1.explore();
        Image img2 = new Image("images/pixel-heart.png");
        Image cropped2 = img2.crop(100, 100, 500, 500);

        cropped2.explore();

        // TODO: Add two more test cases
    }

    public static void testOverlay() {
        // Create a 4x4 2D array
        Color[][] bgTest1 = {
            { Color.black, Color.black, Color.black, Color.black }, // row0
            { Color.black, Color.black, Color.black, Color.black }, // row1
            { Color.black, Color.black, Color.black, Color.black }, // row2
            { Color.black, Color.black, Color.black, Color.black } // row3
        };

        // Create a 3x2 2D array
        Color[][] fgTest1 = { { Color.red, Color.red }, { Color.red, Color.red }, { Color.red, Color.red } };

        // Create an image from the array and crop the bottom right corner
        Image bgImg1 = new Image(bgTest1);
        Image fgImg1 = new Image(fgTest1);
        Image overlayed1 = fgImg1.overlay(bgImg1, 1, 1);

        // Visualize the cropped picture
        fgImg1.explore();
        overlayed1.explore();

        // TODO: Add two more test cases
    }

    public static void testChromakey() {
        // Create a 4x4 2D array
        Color[][] bgTest1 = {
            { Color.red, Color.red, Color.red, Color.red }, // row0
            { Color.red, Color.red, Color.red, Color.red }, // row1
            { Color.red, Color.red, Color.red, Color.red }, // row2
            { Color.red, Color.red, Color.red, Color.red } // row3
        };

        // Create a 3x2 2D array
        Color[][] fgTest1 = {
            { Color.green, Color.green, Color.black, Color.black }, // row0
            { Color.green, Color.green, Color.black, Color.black }, // row1
            { Color.green, Color.green, Color.black, Color.black }, // row2
            { Color.green, Color.green, Color.black, Color.black } // row3
        };

        // Create an image from the array and crop the bottom right corner
        Image bgImg1 = new Image(bgTest1);
        Image fgImg1 = new Image(fgTest1);
        Image chromakeyed1 = fgImg1.chromakey(bgImg1, Color.green, 1);

        // Visualize the cropped picture
        chromakeyed1.explore();

        // TODO: Add two more test cases
    }

    public static void testFlipHorizontal() {
        // Create 4x4 2D array
        Color[][] test1 = { { Color.black, Color.black, Color.black, Color.black }, // row0
                { Color.black, Color.black, Color.black, Color.black }, // row1
                { Color.red, Color.red, Color.red, Color.red }, // row2
                { Color.red, Color.red, Color.red, Color.red } // row3
        };

        // First visualize the original image
        Image img1 = new Image(test1);
        img1.explore();

        // Flip the image and visualize the result
        Image flippedImg1 = img1.flipHorizontal();
        flippedImg1.explore();

        // TODO: Add two more test cases
    }

    // ------------------------------------------------------------------------
    // Main Method
    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        // You may want to uncomment one test at a time
        // NOTE: testCanvas will error unless the canvas constructor is implemented
        // please implement the canvas constructor before uncommenting that line.

         //testCanvas();
        //testCrop();
        // testOverlay();
         //testChromakey();
        //testFlipHorizontal();

        // TODO: Add code for Part 2 here
    }
}
