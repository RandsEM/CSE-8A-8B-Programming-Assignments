/**
 * Name: Darren Yeung, A15943292, cs8bwi20rr
 * Date: 3/5/2020
 * Sources of Help: Lectures, Google, Piazza
 * This file contains the generic class Box that replicates
 * a box that can be used to store anything. However, for this
 * assignment, we are using it store pokemon objects.
 */
import java.util.*;

/**
 * This is the generic class box that is used to store anything
 * the user wishes to store. This is why the class is made generic. 
 * Each box has a list that stores a position object which tells the user
 * which position in the box their object T is stored. Every box also 
 * has a limit of how many items they can store which is named maxSize. 
 * @param <T> Generic variable T so when a box is created, T is used 
 * to specifiy the type of object stored in the box.
 */
public class Box<T> {

  private static final String BORDER = "---------------------";
  private static final String DIVIDER = "|";
  private static final String NEW_LINE = "\n";
  private static final String EMPTY_POS = "   ";
  private static final int MAX_ELEM_LINE = 5;
  private static final String OUT_OF_BOUNDS_EXCEPTION = "Index: %s";
  private List<Position<T>> boxElements;
  private int maxSize;

  /**
   * Default constructor that takes in a integer. That integer 
   * specifies how many objects this box can store. It also initializes 
   * the arraylist of position objects and adds position objects that
   * contains null objects until the list is filled. 
   * @param maxSize
   */
  public Box(int maxSize){
    this.maxSize = maxSize;
    this.boxElements = new ArrayList<>();
    for(int i = 1; i <= maxSize; i++){
      Position<T> position = new Position<T>(null);
      this.boxElements.add(position);
    }
  }

  @Override
  public String toString() {
    int counter = 0;
    StringBuilder boxPrintout = new StringBuilder();
    boxPrintout.append(BORDER);

    // Iterate through each element, print 5 at most on a line
    for (Position<T> element : boxElements) {
      if (counter == 0) {
        boxPrintout.append(NEW_LINE);
        boxPrintout.append(DIVIDER);
      }

      // Print EMPTY_POS if the spot is free (null)
      T pokemon = element.getPokemon();
      if (element.isOpen()) {
        boxPrintout.append(EMPTY_POS);
      } else {
        boxPrintout.append(pokemon.toString());
      }
      boxPrintout.append(DIVIDER);

      counter++;

      // Used so we only have 5 elements at most on a line
      if (counter == MAX_ELEM_LINE) {
        boxPrintout.append(NEW_LINE);
        boxPrintout.append(BORDER);
        counter = 0;
      }
    }
    boxPrintout.append(NEW_LINE);

    return boxPrintout.toString();
  }

  /**
   * This method adds a new object T into the box. It can be 
   * anything the user defines but for this assignment, we are 
   * dealing with Pokemon objects.
   * @param newPokemon pokemon object that is going to be added 
   * to the box 
   * @return True if the pokemon was added successfully, false otherwise.
   */
  public boolean deposit(T newPokemon){
    for(int i = 0; i < this.boxElements.size(); i++){
      if(this.boxElements.get(i).isOpen()){
        this.boxElements.get(i).setPokemon(newPokemon);
        return true; 
      }else{
        continue; 
      }
    }
    return false; 
  }

  /**
   * This method takes in a integer and returns the object 
   * stored at that index of the box, which is a position object 
   * @param index integer that is the index of an object the user 
   * wants to get 
   * @return Position<T> Position object that is to be returned if index 
   * is valid. If it not valid, then throws an indexoutofbounds exception 
   * to the user
   */
  public Position<T> getPositionAtIndex(int index) throws OutOfBoundsException{
    if(index < 0 || index >= this.boxElements.size()){
      throw new OutOfBoundsException(String.format(index + "",OUT_OF_BOUNDS_EXCEPTION));
    }
    return this.boxElements.get(index);
  }
  
}