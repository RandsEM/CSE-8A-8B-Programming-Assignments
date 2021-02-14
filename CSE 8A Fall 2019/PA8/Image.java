import image.Pixel;
import image.SimplePicture;
import java.awt.Color;
import image.PictureFrame;
import java.lang.Thread;
/**
 * Simple class used to represent an image.
 *
 * Internally, it stores the image data as a 2D array of Color objects where
 * each element in the array represents one pixel in the given image object.
 */
public class Image {

    // Member variable used to store the pixels of the Image object
    private Color[][] pixels;

    // Class variable for the frame in which Image objects can be displayed
    //private static PictureFrame pf = new PictureFrame();

    // Member variables used to store the width and height of the Image object
    private int width;
    private int height;

    /**
     * Constructor that creates a new Image object from the image file specified by
     * the given path.
     */

    public Image(String path) {
        // Use SimplePicture to parse file and convert Pixel object
        // to Color object for this Image object
        SimplePicture pic = new SimplePicture(path);
        Pixel[] pixels = pic.getPixels();
        this.width = pic.getWidth();
        this.height = pic.getHeight();
        this.pixels = new Color[this.height][this.width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Pixel p = pixels[i * width + j];
                this.pixels[i][j] = new Color(p.getRed(), p.getGreen(), p.getBlue());
            }
        }
    }

    /**
     * Constructor that creates a new Image object from the given pixels.
     */
    public Image(Color[][] pixels) {
        // Make a copy of the pixels array to avoid mutating this Image object
        this.width = pixels[0].length;
        this.height = pixels.length;
        this.pixels = new Color[this.height][this.width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.pixels[i][j] = pixels[i][j];
            }
        }
    }




    /**
     * Gets the distance between two colors
     */
    public double colorDistance(Color color1, Color color2) {
        int redDistance = color1.getRed()-color2.getRed();
        int greenDistance = color1.getGreen()-color2.getGreen();
        int blueDistance = color1.getBlue()-color2.getBlue();
        int totalDistance = redDistance * redDistance +
            greenDistance * greenDistance +
            blueDistance * blueDistance;
        return totalDistance / 1000;
    }

    /**
     * Visualizes this Image object in an interactive window.
     */
    public void explore() {

        SimplePicture picToExplore = new SimplePicture(width, height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                picToExplore.setBasicPixel(j, i, pixels[i][j].getRGB());
            }
        }
        picToExplore.explore();

    }

    /**
     * Display the image in a simple frame
     */

/*
    public void show(){

        SimplePicture picToExplore = new SimplePicture(width, height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                picToExplore.setBasicPixel(j, i, pixels[i][j].getRGB());
            }
        }
        pf.setPicture(picToExplore);
        pf.displayImage();
    }

  */





    /**
     * Returns the width of this Image object.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of this Image object.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns a copy of the pixels of this Image object.
     */
    public Color[][] getPixels2D() {
        Color[][] copy = new Color[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                copy[i][j] = pixels[i][j];
            }
        }
        return copy;
    }

    /**
     * Returns a String representation of this Image object
     */
    @Override
    public String toString() {
        String pixelRef = pixels.toString();
        String p = pixelRef.substring(pixelRef.indexOf("@"));
        return "Image[width=" + width + ", height=" + height + ", pixels=" + p + "]";
    }


    //x means col
    //y means row

     //TODO : function for flip a bounded rectangle within an image on the horizontal axis
     public void flipHorizontalRect(int topLeftX, int topLeftY, int width, int height){

       Color[][] thisimage = this.getPixels2D();

       int x = 1;

       for(int row = topLeftY; row < height; row ++){
         for(int col = topLeftX ; col < width ; col++){
           this.pixels[row][col] = thisimage[height - x][col];
         }

         x += 1;
       }
    }

    //TODO :  CUSTOM FILTER - write the method for your custom filter

    public void grayscale(int topLeftX, int topLeftY, int width, int height){

      int startingheight = this.getHeight();
      int startingwidth = this.getWidth();
      if(topLeftY < 0){
        height = height - (topLeftY * (-1));
        topLeftY = 0;
      }
      if(topLeftX < 0){
        width = width - (topLeftX * (-1));
        topLeftX = 0;
      }

      for(int row = topLeftY; row < height; row++){
        for(int col = topLeftX; col < width; col++){
          if(col > startingwidth-1){
            break;
          }

          Color rightnow = this.pixels[row][col];
          int red = rightnow.getRed();
          int green = rightnow.getGreen();
          int blue = rightnow.getBlue();
          int lumi = (int)(0.2126*red + 0.7152*green + 0.0722*blue);

          Color newcolor = new Color(lumi, lumi, lumi);


          this.pixels[row][col] = newcolor;

        }
        if(row > startingheight-1){
          break;
        }
      }

    }

  }
