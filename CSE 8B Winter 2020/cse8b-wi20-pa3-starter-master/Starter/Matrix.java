
/**
* Filename: Matrix.java
* Name: Darren Yeung; email:dyeung@ucsd.edu; PID: A15943292
* Login: cs8bwi20rr
* Date: 1/24/2020
* Sources of Help: podcasts, lectures, brain, google.
*
* This file contains the class to make a new matrix with various methods to manipulate other matrixes.
* This includes adding and multiplying two matrixes and also getting specific values from a matrix.
*/

/**
* This class is used to create new matrix objects and also comes with methods like
* addition and multiplication that can be called with one matrix on another matrix object.
*/

import java.util.*;

public class Matrix {

  private int row;
  private int column;
  private int[][] arr;

  // Printed when user tries to add two matrices that cannot be added
  private static final String ADD_ERROR = "Matrices cannot be added";

  // Printed when user tries to multiply two matrices that cannot be multiplied
  private static final String MULTIPLY_ERROR = "Matrices cannot be multiplied";

  /**
   * Constructor with no parameters
   */
  public Matrix() {
    this.row = 0;
    this.column = 0;
    this.arr = null;

  }

  /**
   * Constructor that initializes the instant variables
   * 
   * @param row    The amount of rows in this matrix
   * @param column The amount of columns in this matrix
   * 
   */
  public Matrix(int row, int column) {

    if (row < 0 || column < 0) {
      this.row = 0;
      this.column = 0;
      this.arr = null;
    } else {
      this.row = row;
      this.column = column;
      this.arr = new int[row][column];

    }

  }

  /**
   * Constructor that copies a matrix object
   * 
   * @param mat the matrix object to be copied
   * 
   */

  public Matrix(Matrix mat) {
    this.arr = new int[mat.row][mat.column];
    for (int i = 0; i < this.arr.length; i++) {
      for (int j = 0; j < this.arr[i].length; j++) {
        this.arr[i][j] = mat.arr[i][j];
      }
    }

    this.row = mat.row;
    this.column = mat.column;
  }

  /**
   * method that sets a particular point in the matrix a desired number
   * 
   * @param r which row the user wants to set his desired value in (starting at 0)
   * @param c which column the user wants to set his desired value in (starting at
   *          0)
   * @return boolean (true if value was set successfully, false if wasn't)
   */

  public boolean setElement(int r, int c, int element) {
    if (r < 0 || r >= this.row || c < 0 || c >= this.column) {
      return false;
    } else {
      this.arr[r][c] = element;
      return true;
    }
  }

  /**
   * method that returns a value based on the user's desired row and column
   * 
   * @param r the row the user wants to get his desired element in
   * @param c the column the user wants to get his desired element in
   * @return the element that was the user specified row and column
   */

  public Integer getElement(int r, int c) {
    if (r < 0 || c < 0 || r >= this.row || c >= this.column) {
      return null;

    }
    return (this.arr[r][c]);
  }

  /**
   * method that returns the number of rows in this matrix
   * 
   * @return the number of rows in this matrix
   */

  public int getRows() {
    return this.row;

  }

  /**
   * method that returns the number of columns in this matrix
   * 
   * @return the number of columns in this matrix
   */

  public int getColumns() {
    return this.column;
  }

  /**
   * method that returns a string which represents the matrix
   * 
   * @return a string that looks like the matrix with its elements printed
   */

  @Override
  public String toString() {
    String toBeReturned = "";
    if (this.arr == null) {
      return toBeReturned;
    }

    for (int i = 0; i < this.arr.length; i++) {
      for (int j = 0; j < this.arr[i].length; j++) {
        toBeReturned += (this.arr[i][j] + " ");

      }

      toBeReturned += ('\n');

    }
    return toBeReturned;
  }

  /**
   * Method that returns a matrix that is the sum of the caller matrix and the
   * paremter
   * 
   * @param y the matrix that is going be added to the caller
   * @return a matrix that is an added matrix of the caller matrix and matrix y
   */

  public Matrix add(Matrix y) {

    if (y == null) {
      return null;
    }

    if ((this.row != y.row) || (this.column != y.column)) {
      System.out.println(ADD_ERROR);
      return null;
    } else {
      Matrix addedUp = new Matrix(this.row, this.column);
      for (int i = 0; i < this.arr.length; i++) {
        for (int j = 0; j < this.arr[i].length; j++) {
          addedUp.arr[i][j] = (this.arr[i][j] + y.arr[i][j]);
        }
      }
      return addedUp;
    }
  }

  /**
   * Method that returns a matrix that is the result of two matrixes multiplied
   * together
   * 
   * @param y the matrix that is to be multiplied by the caller
   * @return matrix that is the result from the multiplication of the the caller
   *         matrix and the parameter matrix
   */

  public Matrix multiply(Matrix y) {

    if (y == null) {
      return null;
    }

    if (this.column != y.row) {
      System.out.println(MULTIPLY_ERROR);
      return null;
    } else {
      Matrix multiplied = new Matrix(this.row, y.column);

      for (int i = 0; i < multiplied.row; i++) {
        for (int j = 0; j < multiplied.column; j++) {

          int[] secondMatrixColumn = new int[y.row];
          for (int k = 0; k < secondMatrixColumn.length; k++) {
            secondMatrixColumn[k] = y.arr[k][j];
          }

          int sum = 0;
          for (int m = 0; m < this.column; m++) {
            sum = sum + (secondMatrixColumn[m] * this.arr[i][m]);
          }
          multiplied.arr[i][j] = sum;
        }
      }
      return multiplied;
    }
  }

  /**
   * Method returns the transposed version of a matrix
   * 
   * @return a transposed version of the caller matrix
   */

  public Matrix transpose() {
    Matrix transposed = new Matrix(this.column, this.row);

    for (int i = 0; i < transposed.row; i++) {
      int[] firstMatrixColumn = new int[this.row];
      for (int m = 0; m < this.row; m++) {
        firstMatrixColumn[m] = this.arr[m][i];
      }
      for (int j = 0; j < transposed.column; j++) {
        transposed.arr[i][j] = firstMatrixColumn[j];
      }
    }
    return transposed;
  }

}
