import image.Image;
import java.awt.Color;

public class PA6 {

    // DO NOT CHANGE
    public static Image dummy = new Image(new Color[][]{{Color.white}});

    // DO NOT CHANGE
    public static int luminance(Color c) {
        return (int)(0.2126 * c.getRed() + 0.7152 * c.getGreen() + 0.0722 * c.getBlue());
    }

    // ------------------------------------------------------------------------
    // Filters
    // ------------------------------------------------------------------------

    public static Image grayscale(Image img) {
        // TODO: Implement method, replace return value and delete this comment

        Color[][] revised = new Color[img.getHeight()][img.getWidth()];
        Color[][] now = img.getPixels2D();

        int red;
        int green;
        int blue;

        for(int row = 0; row < img.getHeight(); row++){

          for(int col = 0; col < img.getWidth(); col++){
            red = (now[row][col]).getRed();
            green = (now[row][col]).getGreen();
            blue = (now[row][col]).getBlue();
            int luminance = (int)((0.2126 * red) + (0.7152 * green)+ (0.0722 * blue));

            revised[row][col] = new Color((luminance),(luminance),(luminance));

          }
        }

        Image image = new Image(revised);

        return image;
    }

    public static Image blend(Image img1, Image img2) {

      Color[][] revised = new Color[img1.getHeight()][img1.getWidth()];
      Color[][] now = img1.getPixels2D();
      Color[][] now2 = img2.getPixels2D();



        int red;
        int green;
        int blue;
        int red2;
        int green2;
        int blue2;
        int redaverage;
        int greenaverage;
        int blueaverage;

        for(int row = 0; row < img1.getHeight(); row++){

          for(int col = 0; col < img1.getWidth(); col++){
            red = (now[row][col]).getRed();
            green = (now[row][col]).getGreen();
            blue = (now[row][col]).getBlue();
            red2 = (now2[row][col]).getRed();
            green2 = (now2[row][col]).getGreen();
            blue2 = (now2[row][col]).getBlue();
            redaverage = (red+ red2)/2;
            greenaverage = (green + green2)/2;
            blueaverage = (blue + blue2)/2;


            revised[row][col] = new Color(redaverage, greenaverage, blueaverage);

          }
        }

        Image image = new Image(revised);

        return image;

    }

    public static Image crop(Image img, int width, int height) {
        // TODO: Implement method, replace return value and delete this comment

        Color[][] revised = new Color[width][height];
        Color[][] tobeCropped = img.getPixels2D();

        for(int row = 0; row < height; row++){

          for(int col = 0; col < width; col++){

            int redTBC = (tobeCropped[row][col]).getRed();
            int greenTBC = (tobeCropped[row][col]).getGreen();
            int blueTBC = (tobeCropped[row][col]).getBlue();

            revised[row][col] = new Color((redTBC),(greenTBC),(blueTBC));


          }


        }
        Image croppedImage = new Image(revised);

        return croppedImage;
    }

    // ------------------------------------------------------------------------
    // Tests
    // ------------------------------------------------------------------------

    public static void testGrayscale() {
        // Create a 2x3 array of gray Color objects
        Color[][] test1 = {
            {Color.gray, Color.gray, Color.gray},   // row 0
            {Color.gray, Color.gray, Color.gray},   // row 1
        };

        // Create an image from the 2D array and visualize it
        Image img1 = new Image("images/cat.jpg");
        img1.explore();

        // Call grayscale and visualize the resulting image
        Image result1 = grayscale(img1);
        result1.explore();

        // TODO: Add two more test cases
    }

    public static void testBlend() {
        // Create two 1x1 2D arrays
        Color[][] test1_1 = {{new Color(0, 0, 0)}};
        Color[][] test1_2 = {{new Color(100, 100, 100)}};

        // Create the test images and call blend
        Image result1 = blend(new Image("images/cat.jpg"), new Image("images/texture.jpg"));

        // Explore the image and ensure that the pixel color is (50, 50, 50)
        result1.explore();

        // TODO: Add two more test cases
    }

    public static void testCrop() {
        // Create a 4x4 2D array
        Color[][] test1 = {
            {Color.black, Color.black, Color.red, Color.red},   // row0
            {Color.black, Color.black, Color.red, Color.red},   // row1
            {Color.black, Color.black, Color.red, Color.red},   // row2
            {Color.red, Color.red, Color.red, Color.red}        // row3
        };

        // Create the test image and call crop
        Image img1 = new Image("images/cat.jpg");
        Image result1 = crop(img1, 400, 400);

        // Visualize the result and make sure that it is 3x2 and that all colors
        // are black (255, 255, 255) (first three rows and two columns)
        result1.explore();

        // TODO: Add two more test cases
    }

    // ------------------------------------------------------------------------
    // Main Method
    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        // You may want to uncomment one test at a time

        //testGrayscale();
        //testBlend();
        testCrop();

        // TODO: Add code for Part 2 here
    }
}
