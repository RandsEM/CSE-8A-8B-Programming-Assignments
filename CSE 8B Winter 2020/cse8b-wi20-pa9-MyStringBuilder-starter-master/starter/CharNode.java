
/**
 * Name: Darren Yeung, A15943292, cs8bwi20rr
 * Date: 3/12/2020
 * Sources of Help: Lectures, Google, Piazza
 * This file contains the class CharNode. The file MyStringBuilder.java
 * relies on this file. 
 */

/**
 * This class is the class CharNode. It is an object that stores one 
 * character and also a reference to the next CharNode. Therefore multiple 
 * of these objects can be used to form a String.
 */
public class CharNode{
  private char data; 
  private CharNode next; 

  /**
   * This is the default constructor which takes in one Char
   * @param ch Char that is going to be stored in this CharNode
   */
  public CharNode(char ch){
    this.data = ch;
    this.next = null;  
  }

  /**
   * This method returns the Char stored 
   * @return char stored in this CharNode
   */
  public char getData(){
    return this.data; 
  }

  /**
   * This method returns the CharNode stored in this 
   * CharNode
   * @return CharNode stored in this CharNode
   */
  public CharNode getNext(){
    return this.next;
  }

  /**
   * This method takes in a char and replaces the current 
   * char stored in this CharNode with the new char
   * @param newData char that is going to replace the existing char
   * in this CharNode
   * @return this
   */
  public CharNode setData(char newData){
    this.data = newData; 
    return this; 
  }

  /**
   * This method takes in a CharNode and replaces the current
   * one stored with it
   * @param newNext CharNode that is going to take the place of the existing
   * CharNode
   * @return this
   */
  public CharNode setNext(CharNode newNext){
    this.next = newNext; 
    return this;
  }

}