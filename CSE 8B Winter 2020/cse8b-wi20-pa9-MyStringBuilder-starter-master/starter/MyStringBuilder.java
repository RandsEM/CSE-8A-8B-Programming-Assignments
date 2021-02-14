
/**
 * Name: Darren Yeung, A15943292, cs8bwi20rr
 * Date: 3/12/2020
 * Sources of Help: Lectures, Google, Piazza
 * This file contains the class MyStringBuilder which replicates
 * a StringBuilder but a probably more scuffed version of the actual thing. 
 */

/**
 * This is the class MyStringBuilder. This is used to create a StringBuilder
 * Object that utilizes the object CharNode. StringBuiler stores two charNodes a
 * fist CharNode and a Last CharNode. It also stores the length of 
 * the String which is also how many CharnNodes it contains. Thanks for 
 * reading
 */


public class MyStringBuilder{

  protected CharNode first; 
  protected CharNode last; 
  protected int length; 

  /**
   * Default constructor for MyStringBuilder that takes 
   * in a char inut
   * @param input char input that is going to 
   * represent the first CharNode of this MyStringBuilder
   */
  public MyStringBuilder(char input){
    this.first = new CharNode(input);
    this.last = first; 
    this.length += 1; 
  }

  /**
   * Constructor that takes in a string input and 
   * constructors a stringbuilder node by node using that 
   * string
   * @param string the String that is going to have 
   * its contents copied to a MyStringBuilder
   */
  public MyStringBuilder(String string) throws BadInputException{
    try{
      this.append(string);      
    }catch(NullPointerException e){
      System.out.println();
      throw new BadInputException(Constants.FROM_CONSTRUCTOR,"hello");
    }
  }

  /**
   * Constructor that takes in another MyStringBuilder and deepcopies
   * it to form a new one
   * @param input MyStringBuilder that is going to be deep copied
   */
  public MyStringBuilder(MyStringBuilder input)throws BadInputException{
    try{
      String conversion = input.toString();
      this.append(conversion);
    }catch(NullPointerException npe){
      throw new BadInputException(Constants.FROM_DEEPCOPY_CONSTRUCTOR, "lmao");
    }
  }

  /**
   * This method returns the length of the 
   * MyStringBuilder
   * @return int that represents the length of this 
   * MyStringBuilder
   */
  public int length(){
    return this.length; 
  }

  /**
   * This method appends a character to this
   * existing MyStringBuilder
   * @param c character that is going be formed 
   * into a CharNode that is going to the end of this
   * MyStringBuilder
   * @return this
   */
  public MyStringBuilder append(char c){
    if(this.length == 0){
      this.first = new CharNode(c);
      this.last = first; 
      this.length += 1; 
    }else{
      this.last.setNext(new CharNode(c));
      this.last = this.last.getNext();
      this.length += 1; 
    }
    return this;
  }

  /**
   * This method appends an entire String to the existing 
   * MyStringBuilder by creating a new CharNode for each Character
   * in the String
   * @param str String that is going to have its characters formed into
   * a CharNode and appended one by one to this MyStringBuilder
   * @return this
   * @throws BadInputException Thrown when String is null
   */
  public MyStringBuilder append (String str) throws BadInputException{
    try{
      for(int i = 0; i < str.length(); i++){
        this.append(str.charAt(i));  
      }
      return this;
    }catch(NullPointerException npe){
      throw new BadInputException(Constants.FROM_APPEND_STR, "lul");
    }
  }

  /**
   * This method returns the string format of 
   * this MyStringBuilder
   * @return String representation of this 
   * MyStringBuilder
   */
  @Override
  public String toString(){
    String goingOut = "";
    CharNode current = this.first; 
    for(int i = 1; i <= length; i++){
      goingOut += current.getData();
      current = current.getNext();
    }
    return goingOut;
  }

  /**
   * This method inserts a particular character at a particular index 
   * of this MyStringBuilder 
   * @param c Character that is going to be formed into a CharNode and then 
   * inserted 
   * @param index Location of where the new character will be inserted
   */
  public MyStringBuilder insert (char c, int index) throws MSBOutOfBoundsException{
      if(index < 0 || index > this.length){
        throw new MSBOutOfBoundsException(Constants.FROM_INSERT_CHAR, "lmao");
      }
      CharNode current = this.first; 
      CharNode inserted = new CharNode(c);
      CharNode oneAfter = null; 
      if(index == 0){
        inserted.setNext(current);
        this.first = inserted; 
        this.length += 1; 
      }else{
        for(int i = 0; i < index - 1; i++){
          current = current.getNext();
        }
        oneAfter = current.getNext();
        current.setNext(inserted);
        inserted.setNext(oneAfter);
        if(index == this.length()){
          current = this.first;
          for(int i = 1; i <= length; i++){
            current = current.getNext();
          }
          this.last = current; 
        }
        this.length += 1; 
      }
      return this;  
  }

  /**
   * This method inserts an entire string at a particular index
   * @param str String that is going to be be inserted into this MyStringBuilder
   * @param index Location where the string is going to be inserted into 
   * @return this 
   * @throws BadInputException Throw when String is null 
   * @throws MSBOutOfBoundsException Thrown when invalid index 
   */
  public MyStringBuilder insert (String str, int index) throws BadInputException, MSBOutOfBoundsException{
    if(str == null){
      throw new BadInputException(Constants.FROM_INSERT_STR, "hello");
    }
    if(index < 0 || index > this.length){
      throw new MSBOutOfBoundsException(Constants.FROM_INSERT_STR, "hello");
    }
    int indexCount = index; 
    for(int i = 0; i < str.length(); i++){
      this.insert(str.charAt(i), indexCount);
      indexCount += 1; 
    }
    return this; 
  }

  /**
   * This method returns the CharNode at the specificed index
   * @param index Location of the CharNode the user wants
   * @reutrn CharNode that is stored at the index
   */
  protected CharNode findIndex(int index) throws MSBOutOfBoundsException{
    if(index > this.length || index < 0 || index == this.length){
      throw new MSBOutOfBoundsException(Constants.FROM_FIND_INDEX, "hello");
    }
    CharNode current = this.first; 
    for(int i = 0; i < index; i++){
      current = current.getNext();
    }
    return current; 
  }

  /**
   * This method removes the particular CharNode at the index
   * @param index Location of CharNode that the user wants to remove
   * @return this
   */
  public MyStringBuilder remove (int index) throws MSBOutOfBoundsException{
    if(index < 0 || index > this.length){
      throw new MSBOutOfBoundsException(Constants.FROM_REMOVE, "hello");
    }
    CharNode current = this.first; 
    CharNode oneAfterCurrent = null;
    if(index == 0){
      current = current.getNext();
      this.first = current; 
      if(index == this.length -1 ){
        this.last = current; 
      }
      this.length -= 1; 
    }else{
      for(int i = 0; i < index - 1; i++){
        current = current.getNext();
      }
      oneAfterCurrent = current.getNext();
      current.setNext(oneAfterCurrent.getNext());
      if(index == this.length -1 ){
        this.last = current; 
      }
      this.length -= 1;
    }
    return this; 
  }

  /**
   * This method deletes all CharNodes starting from startIndex all the way 
   * to the end of the MyStringBuilder
   * @param startIndex Starting point of deletion
   * @return this 
   * @throws MSBOutOfBoundsException Thrown when startIndex invalid
   */
  public MyStringBuilder delete(int startIndex) throws MSBOutOfBoundsException{
    if(startIndex < 0 || startIndex >= this.length){
      throw new MSBOutOfBoundsException(Constants.FROM_DELETE_STARTINDEX, "message");
    }
    int deleted = this.length - startIndex; 
    CharNode current = this.first;
    if(startIndex == 0){
      this.first = null;
      this. last = first; 
      this.length -= deleted; 
      return this; 
    }else{
      for(int i = 1; i < startIndex; i++){
        current = current.getNext();
      }
      current.setNext(null);
      this.last = current; 
      this.length -= deleted; 
      return this;
    }
  }

  /**
   * This method deletes all CharNodes starting from startIndex upto but not including
   * endIndex
   * @param startIndex Starting point of deletion
   * @param endIndex Ending point of deletion (not including)
   * @return this
   * @throws BadInputException Thrown when endIndex is less than startIndex
   * @throws MSBOutOfBoundsException Thrown when invalid Indexes 
   */
  public MyStringBuilder delete (int startIndex, int endIndex) throws BadInputException, MSBOutOfBoundsException{
    if(startIndex == endIndex){
      return this; 
    }
    if(endIndex < startIndex){
      throw new BadInputException(Constants.FROM_DELETE_STARTINDEX_ENDINDEX, "lul");
    }
    if(startIndex < 0 || startIndex > this.length || !(endIndex <= this.length)){
      throw new MSBOutOfBoundsException(Constants.FROM_DELETE_STARTINDEX_ENDINDEX, "lul");
    }
    for(int i = 1; i <= (endIndex - startIndex); i++){
      this.remove(startIndex);
    }
    return this; 
  }

  /**
   * This method returns a String starting from startIndex all the way to the end 
   * of the MyStringBuilder
   * @param startIndex Starting poing of SubString
   * @return A string that represents the SubString starting at startIndex
   * @throws MSBOutOfBoundsException thrown when index is invalid
   */
  public String substring(int startIndex) throws MSBOutOfBoundsException{
    if(startIndex < 0 || startIndex >= this.length){
      throw new MSBOutOfBoundsException(Constants.FROM_SUBSTRING_STARTINDEX, "lul");
    }
    String goingOut = "";
    CharNode current = this.first; 
    for(int i = 0; i < startIndex; i++){
      current = current. getNext();
    }
    while(current != null){
      goingOut += current.getData();
      current = current.getNext();
    }
    return goingOut; 
  }

  /**
   * This method returns a subString starting from startIndex up to but not including
   * endIndex
   * @param startIndex Starting position of SubString
   * @param endIndex Ending position of SubString but not including
   */
  public String substring(int startIndex, int endIndex) throws MSBOutOfBoundsException, BadInputException{
    
    String goingOut = "";
    if(startIndex == endIndex){
      return goingOut; 
    }
    if(startIndex < 0 || startIndex >= this.length || !(endIndex <= this.length)){
      throw new MSBOutOfBoundsException(Constants.FROM_SUBSTRING_STARTINDEX_ENDINDEX, "lul");
    }
    if(endIndex < startIndex){
      throw new BadInputException(Constants.FROM_SUBSTRING_STARTINDEX_ENDINDEX, "lul");
    }
    CharNode current = this.first; 
    for(int i = 0; i < startIndex; i++){
      current = current. getNext();
    }
    int concatTimes = endIndex - startIndex; 
    for(int i = 1; i <= concatTimes; i++){
      goingOut += current.getData();
      current = current.getNext();
    }
    return goingOut;
  }

  /**
   * This method concats another StringBuilder to this
   * @param rightOperand StringBuilder object that is going to be concated to the end 
   * of this 
   * @return this
   * @throws BadInputException Thrown hen rightOperand is null
   */
  public MyStringBuilder concat(MyStringBuilder rightOperand) throws BadInputException{
    if(rightOperand == null){
      throw new BadInputException(Constants.FROM_CONCAT, "lul");
    }
    CharNode current = this.first; 
    for(int i = 1; i <= this.length - 1; i++){
      current = current.getNext();
    }
    current.setNext(rightOperand.first);
    this.last = rightOperand.last;
    this.length += rightOperand.length();
    return this; 
  }

}