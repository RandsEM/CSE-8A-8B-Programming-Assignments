/**
 * Filename: Pronounce.java
 * Name: Darren Yeung; Email: dyeung@ucsd.edu; PID: A15943292
 * Login: cs8bwi20rr
 * Date: 1/17/2020
 * Sources of help: Lecture, Podcasts
 * 
 * Description: This file contains the class RatingPredictor which
 * allows the user predict rating of textfiles that contains people's ratings 
 * of certain movies. It can basically use a previous rating file in order to predict
 * the ratings of anohter file which contains no ratings. 
 */

import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

/**
 * This class RatingPredictor is a concrete class that is used to instantiate 
 * an object that can predict ratings of certain reviews that talks about 
 * movie. The instance variables are one hashmap that stores the rating/amount of times 
 * a word has appeared in a review and a hashset that contains the useless words that needs 
 * to be removed from the review in order to predict the rating in a more efficient manner.
 */

public class RatingPredictor {
  private HashMap<String, int[]> wordFreqMap;
  private HashSet<String> stopWords;
  private static final Double defaultRating = 2.0;
  

  /**
   * This is the default constructor for RatingPredictor that instantiates the 
   * instance variables wordFreqMap and stopWords. 
   */
  public RatingPredictor() {
    this.wordFreqMap = new HashMap<String, int[]>();
    this.stopWords = new HashSet<String>();
  }

  /**
   * This method takes in a sentence and splits the words and stores the words into 
   * an arraylist in order 
   * @param sentence A one line review
   * @return An arraylist containing 
   */
  public ArrayList<String> splitLine(String sentence) {
    ArrayList<String> wordStorageList = new ArrayList<>();
    String[] wordStorage = sentence.split(" ");
    for (String string : wordStorage) {
      wordStorageList.add(string);
    }
    return wordStorageList;
  }

  /**
   * This method takes in an arraylist of words and splits them 
   * at hyphens and quotes turning them into two words 
   * @param words Arraylist of words that contains words with quotes and hyphens
   * @return arraylist of words that contains the same words as the input array
   * but with words with hyphens and quotes split up
   */
  public ArrayList<String> splitAtHyphensAndQuotes(ArrayList<String> words) {
    ArrayList<String> splitedAtHQ = new ArrayList<>();
    for (String string : words) {
      if (string.contains("-")) {
        String[] splitH = string.split("-");
        for (int i = 0; i < splitH.length; i++) {
          splitedAtHQ.add(splitH[i]);
        }
      } else if (string.contains("'")) {
        String[] splitS = string.split("'");
        for (int i = 0; i < splitS.length; i++) {
          splitedAtHQ.add(splitS[i]);
        }
      } else {
        splitedAtHQ.add(string);
      }
    }
    return splitedAtHQ;
  }

  /**
   * This method takes in an arraylist of words and removes the puncutation
   * @param words Arraylist of words that contains words with punctuations
   * @return arraylist of words with the same words as in the input arrya except 
   * with the punctuation removed
   */
  public ArrayList<String> removePunctuation(ArrayList<String> words) {
    ArrayList<String> punctuationRemoved = new ArrayList<>();
    String nono = "!\"#$%&\'()*+,-./:;<=>?@[\\]^_`{|}~";
    for (String string : words) {
      String punctRemoved = string;
      for (int i = 0; i < nono.length(); i++) {
        if (punctRemoved.indexOf(nono.charAt(i)) != -1) {
          String c = nono.charAt(i) + "";
          //If punctuation is found in current word, replaces all of it 
          //with a blank string 
          punctRemoved = punctRemoved.replaceAll("\\" + c, "");
        }
      }
      punctuationRemoved.add(punctRemoved);
    }
    return punctuationRemoved;
  }

  /**
   * This method takes in an arraylist of words and removes all white spaces if a word 
   * contains one 
   * @param words Arraylist of words that contains words with whitespaces
   * @return arraylist of words that contains the same words as the input array
   * but with words without whitespaces 
   */
  public ArrayList<String> removeWhiteSpaces(ArrayList<String> words) {
    ArrayList<String> wsRemoved = new ArrayList<>();
    for (String string : words) {
      if (string.contains(" ")) {
        String whiteSpaceRemoved = string.replaceAll(" ", "");
        wsRemoved.add(whiteSpaceRemoved);
      } else {
        wsRemoved.add(string);
      }
    }
    return wsRemoved;
  }

  /**
   * This method takes in an arraylist of words and removes all empty words 
   * @param words Arraylist of words that contains words that can potentially be 
   * empty
   * @return arraylist of words that contains the same words as the input array
   * except empty words ("") are moved 
   */
  public ArrayList<String> removeEmptyWords(ArrayList<String> words) {
    ArrayList<String> emptyRemoved = new ArrayList<String>();
    for (String string : words) {
      //checks if string is empty 
      if (string.isEmpty()) {
        continue;
      } else {
        emptyRemoved.add(string);
      }
    }
    return emptyRemoved;
  }

  /**
   * This method takes in an arraylist of words and removes all single letter 
   * words 
   * @param words Arraylist of words that contains single letter words
   * @return arraylist of words that contains the same words as the input array
   * but with words that are single lettered removed 
   */
  public ArrayList<String> removeSingleLetterWords(ArrayList<String> words) {
    ArrayList<String> emptyRemoved = new ArrayList<String>();
    for (String string : words) {
      //checks if string is one letter aka length one 
      if (string.length() == 1) {
        continue;
      } else {
        emptyRemoved.add(string);
      }
    }
    return emptyRemoved;
  }

  /**
   * This method takes in an arraylist of words and lowercases all characters 
   * in each word
   * @param words Arraylist of words that contains words with uppercase characters
   * @return arraylist of words that contains the same words as the input array
   * but with words all lowercased
   */
  public ArrayList<String> toLowerCase(ArrayList<String> words) {
    ArrayList<String> lowerCased = new ArrayList<>();
    for (String string : words) {
      String lowered = string.toLowerCase();
      lowerCased.add(lowered);
    }
    return lowerCased;
  }

  /**
   * This method takes in an arraylist of words and removes the one that the user of class
   * deems useless 
   * @param words Arraylist of words that contains useless words
   * @return arraylist of words that contains the same words as the input array
   * but with all useless words removed
   */
  public ArrayList<String> removeStopWords(ArrayList<String> arrList) {
    ArrayList<String> removedStopped = new ArrayList<>();
    for (String string : arrList) {
      if (this.stopWords.contains(string)) {
        continue;
      } else {
        removedStopped.add(string);
      }
    }
    return removedStopped;
  }

  /**
   * This method takes in the name of a file that contains useless words, adds all those words to 
   * the object's instance object hashset stopwords, and writes all those words into a file that 
   * has a name of the second parameter where there are no duplicates 
   * @param inFile name of file that contains useless words
   * @param outFile name of output file that is going to contain useless words but with no duplicates
   */
  public void createStopWordsSet(String inFile, String outFile) throws FileNotFoundException {
    File inputFile = new File(inFile);
    Scanner sc = new Scanner(inputFile);
    while (sc.hasNextLine()) {
      this.stopWords.add(sc.nextLine());
    }
    File outputFile = new File(outFile);
    PrintWriter pw = new PrintWriter(outputFile);
    //iterates over the instance object hashmap stopwords and writes all words
    Iterator<String> it = this.stopWords.iterator();
    while (it.hasNext()) {
      pw.println(it.next());
    }
    sc.close();
    pw.close();
  }

  /**
   * This method takes in a name of a file that contains raw reviews and writes the cleaned version of the 
   * reviews into a file with the name in the form of the string outfile. Cleaned means all lowercase, 
   * no single letter words, whitespaces removed, punctuation removed, etc. 
   * @param inFile name of file that contains raw reviews
   * @param outFile name oef file that contains the same reviews as the inFile but with its reviews cleaned
   * @param ratingIncluded boolean value of whether or not the raw review file has number ratings attached to the 
   * reviews or not 
   * 
   */
  public void cleanData(String inFile, String outFile, boolean ratingIncluded) throws FileNotFoundException {
    File inputFile = new File(inFile);
    File outputFile = new File(outFile);

    Scanner sc = new Scanner(inputFile);
    PrintWriter pw = new PrintWriter(outputFile);
    if (ratingIncluded == false) {
      while (sc.hasNextLine()) {
        ArrayList<String> cleanData = this.splitLine(sc.nextLine());
        //cleans current line
        cleanData = this.splitAtHyphensAndQuotes(cleanData);
        cleanData = this.removePunctuation(cleanData);
        cleanData = this.removeWhiteSpaces(cleanData);
        cleanData = this.removeEmptyWords(cleanData);
        cleanData = this.removeSingleLetterWords(cleanData);
        cleanData = this.toLowerCase(cleanData);
        cleanData = this.removeStopWords(cleanData);
        for (int i = 0; i < cleanData.size(); i++) {
          if (i == cleanData.size() - 1) {
            pw.print(cleanData.get(i));
          } else {
            pw.print(cleanData.get(i) + " ");
          }
        }
        pw.println();
      }
    } else {
      while (sc.hasNextLine()) {
        ArrayList<String> cleanData = this.splitLine(sc.nextLine());
        String rating = cleanData.get(0);
        //cleans current line
        cleanData = this.splitAtHyphensAndQuotes(cleanData);
        cleanData = this.removePunctuation(cleanData);
        cleanData = this.removeWhiteSpaces(cleanData);
        cleanData = this.removeEmptyWords(cleanData);
        cleanData = this.removeSingleLetterWords(cleanData);
        cleanData = this.toLowerCase(cleanData);
        cleanData = this.removeStopWords(cleanData);
        cleanData.add(0, rating);
        for (int i = 0; i < cleanData.size(); i++) {
          if (i == cleanData.size() - 1) {
            pw.print(cleanData.get(i));
          } else {
            pw.print(cleanData.get(i) + " ");
          }
        }
        pw.println();
      }
    }
    sc.close();
    pw.close();
  }

  /**
   * Method that takes in a name of a cleaned file and adds all words to the wordFreqMap and stores 
   * the sum of all ratings attached to the word and the amount of times the word appears in the review in a
   * int array of size 2
   * @param inCleanFile name of file that contains cleaned reviews 
   */
  public void updateHashMap(String inCleanFile) throws FileNotFoundException {
    this.wordFreqMap = new HashMap<>();
    File cleanFile = new File(inCleanFile);
    Scanner sc = new Scanner(cleanFile);
    while (sc.hasNextLine()) {
      ArrayList<String> splittedLine = this.splitLine(sc.nextLine());
      int rating = Integer.parseInt(splittedLine.get(0));
      splittedLine.remove(0);
      for (String string : splittedLine) {
        if (!this.wordFreqMap.keySet().contains(string)) {
          this.wordFreqMap.put(string, new int[2]);
          (this.wordFreqMap.get(string))[0] = rating;
          (this.wordFreqMap.get(string))[1] = 1;
        } else {
          (this.wordFreqMap.get(string))[0] += rating;
          (this.wordFreqMap.get(string))[1] += 1;
        }
      }
    }
    sc.close();
  }

  /**
   * Method that takes in a name of a file that contains cleaned reviews without ratings and writes the 
   * predicton of ratings to a file name of the second parameter 
   * @param inCleanFile name of file that contains cleaned reviews without ratings
   * @param outRatingsFile name of file that contains predicted number ratings coressponding
   * to each line of the review from the inCleanFile
   */
  public void rateReviews(String inCleanFile, String outRatingsFile) throws FileNotFoundException {
    File cleanedFile = new File(inCleanFile);
    File outFile = new File(outRatingsFile);
    Scanner sc = new Scanner(cleanedFile);
    PrintWriter pr = new PrintWriter(outFile);
    ArrayList<Double> allRatings = new ArrayList<>();
    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      ArrayList<String> splittedLine = this.splitLine(line);
      ArrayList<Double> thisLineRatings = new ArrayList<>();
      for (String string : splittedLine) {
        if (!this.wordFreqMap.keySet().contains(string)) {
          thisLineRatings.add(defaultRating);
        } else {
          int[] arrayOfWord = this.wordFreqMap.get(string);
          Double averageRating = Double.valueOf(arrayOfWord[0]) / arrayOfWord[1];
          thisLineRatings.add(averageRating);
        }
      }
      Double sum = 0.0;
      for (Double dub : thisLineRatings) {
        sum += dub;
      }
      //rounds decimal to one decimal place 
      DecimalFormat value = new DecimalFormat("#.#");
      allRatings.add(Double.parseDouble(value.format((sum / (thisLineRatings.size())))));
    }
    for (Double dub : allRatings) {
      pr.println(dub);
    }
    sc.close();
    pr.close();
  }

}
