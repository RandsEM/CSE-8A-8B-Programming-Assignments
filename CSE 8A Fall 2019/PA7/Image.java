import image.Pixel;
import image.SimplePicture;
import java.awt.Color;

/**
 * Simple class used to represent an image.
 *
 * Internally, it stores the image data as a 2D array of Color objects where
 * each element in the array represents one pixel in the given image object.
 */
public class Image {

    // DO NOT CHANGE
    public static Image dummy = new Image(new Color[][]{{Color.white}});

    // Member variable used to store the pixels of the Image object
    private Color[][] pixels;

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
        Pixel[] pixelsToLoad = pic.getPixels();
        this.width = pic.getWidth();
        this.height = pic.getHeight();
        this.pixels = new Color[this.height][this.width];
        for (int row = 0; row < this.height; row++) {
            for (int col = 0; col < this.width; col++) {
                Pixel p = pixelsToLoad[row * width + col];
                this.pixels[row][col] = new Color(p.getRed(), p.getGreen(), p.getBlue());
            }
        }
    }

    /**
     * Constructor that creates a new Image object from the given pixels.
     */
    public Image(Color[][] pixelsToLoad) {
        // Make a copy of the pixels array to avoid mutating this Image object
        this.width = pixelsToLoad[0].length;
        this.height = pixelsToLoad.length;
        this.pixels = new Color[this.height][this.width];
        for (int row = 0; row < this.height; row++) {
            for (int col = 0; col < this.width; col++) {
                this.pixels[row][col] = pixelsToLoad[row][col];
            }
        }
    }

    /**
     * Gets the distance between two colors
     */
    public static double colorDistance(Color color1, Color color2) {
        int redDistance = color1.getRed()-color2.getRed();
        int greenDistance = color1.getGreen()-color2.getGreen();
        int blueDistance = color1.getBlue()-color2.getBlue();
        int totalDistance = redDistance * redDistance +
            greenDistance * greenDistance +
            blueDistance * blueDistance;
        return totalDistance / 1000.0;
    }

    /**
     * Visualizes this Image object in an interactive window.
     */
    public void explore() {
        SimplePicture picToExplore = new SimplePicture(this.width, this.height);
        for (int row = 0; row < this.height; row++) {
            for (int col = 0; col < this.width; col++) {
                picToExplore.setBasicPixel(col, row, this.pixels[row][col].getRGB());
            }
        }
        picToExplore.explore();
    }

    /**
     * Returns the width of this Image object.
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Returns the height of this Image object.
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Returns a copy of the pixels of this Image object.
     */
    public Color[][] getPixels2D() {
        Color[][] copy = new Color[this.height][this.width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                copy[row][col] = this.pixels[row][col];
            }
        }
        return copy;
    }

    /**
     * Returns a String representation of this Image object
     */
    @Override
    public String toString() {
        String pixelRef = this.pixels.toString();
        String p = pixelRef.substring(pixelRef.indexOf("@"));
        return "Image[width=" + this.width + ", height=" + this.height + ", pixels=" + p + "]";
    }

    // ------------------------------------------------------------------------
    // TODO: Implement the methods below
    // ------------------------------------------------------------------------

    /**
     * A Canvas Constructor that creates a new Image object
     * that is a canvas of the given color with the given dimensions.
     */
    public Image(int widthIn, int heightIn, Color color) {

      this.width = widthIn;
      this.height = heightIn;

      this.pixels = new Color[heightIn][widthIn];


      for(int row = 0; row < heightIn; row++){
        for(int col = 0; col < widthIn; col++){
          this.pixels[row][col] = color;
        }
      }


    }

    public Image crop(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY) {
        // TODO: Implement method, replace return value and delete this comment
        // x means col
        // y means row

        int sizerows = (bottomRightY - topLeftY);
        int sizecols = (bottomRightX - topLeftX);
        Color[][] croppedImage = new Color[sizerows][sizecols];

        Color[][] currentarray = this.getPixels2D();



        int coladvancer = topLeftX;
        int rowadvancer = topLeftY;
        for(int row = 0; row < sizerows; row++ ){
          for(int col = 0; col < sizecols; col++){

            croppedImage[row][col] = currentarray[rowadvancer][coladvancer];
            coladvancer += 1;
          }
          coladvancer = topLeftX;
          rowadvancer += 1;

        }

        Image transferimage = new Image(croppedImage);
        return transferimage;


    }

    public Image overlay(Image bg, int topLeftX, int topLeftY) {
        // TODO: Implement method, replace return value and delete this comment
        //x = col;
        //y = row
        Color[][] thisimage = this.getPixels2D();
        Color[][] backgroundimage = bg.getPixels2D();

        int imageheight = bg.getHeight();
        int imagewidth = bg.getWidth();

        int xincrement = topLeftX;
        int yincrement = topLeftY;

        for(int row = 0; row < this.getHeight(); row++){
          for(int col = 0; col < this.getWidth(); col++){
            backgroundimage[yincrement][xincrement] = thisimage[row][col];
            xincrement += 1;

          }

          xincrement = topLeftX;
          yincrement += 1;
        }

        Image imagethatisreturned = new Image(backgroundimage);


        return imagethatisreturned;
    }

    public Image chromakey(Image bg, Color key, double threshold) {
        // TODO: Implement method, replace return value and delete this comment

        Color[][] thisimage = this.getPixels2D();
        Color[][] backgroundimage = bg.getPixels2D();

        for(int row = 0; row < this.getHeight(); row++){
          for(int col = 0; col < this.getWidth() ;col++){
            if(colorDistance(thisimage[row][col], key) < threshold){
              thisimage[row][col] = backgroundimage[row][col];
            }
          }
        }

        Image imagetobereturned = new Image(thisimage);
        return imagetobereturned;
    }

    public Image flipHorizontal() {
        // TODO: Implement method, replace return value and delete this comment
        Color[][] thisimage = this.getPixels2D();
        Color[][] imagetobereturned = new Color[this.getHeight()][this.getWidth()];
        int thisimageheight = this.getHeight() ;
        int x = 1;
        for(int row = 0; row < this.getHeight(); row ++){
          for(int col = 0; col < this.getWidth(); col++){
            imagetobereturned[row][col] = thisimage[thisimageheight - x][col];


          }
          x += 1;
        }

        Image  imagetobereturned2 = new Image(imagetobereturned);


        return imagetobereturned2;
    }
}
