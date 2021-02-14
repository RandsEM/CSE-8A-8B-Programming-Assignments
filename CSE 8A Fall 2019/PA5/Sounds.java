import java.lang.Math.*;

public class Sounds{

    // DO NOT CHANGE
    static CSE8ALib lib = new CSE8ALib();

    // DO NOT CHANGE
    static final int SAMPLE_RATE = 22050;  // 22.05 KHz

    public static void main(String[] args){

        // STEP 2: use your functions here to create your sounds

	    //int[] sound1 = lib.readSound(""); // TODO fill in the path to your first sound (in the sounds folder)
	    //int[] sound2 = lib.readSound(""); // TODO fill in the path to your second sound (in the sounds folder)


       int[] firstsound = sineSound(30000, 10000, 10);
       int[] secondsound = sineSound(20000, 25400, 10);

       int[] thirdsound = concatSounds(firstsound, secondsound);


       changeVolume(thirdsound, 10);

       //boolean  truefalse = lib.play( firstsound);
       //System.out.println(truefalse);

       lib.play(thirdsound);
       lib.explore(thirdsound);


       test();

       System.out.println("");
       System.out.println("");

       System.out.println("Test 2: ");

       test2();

       System.out.println("");
       System.out.println("");

       System.out.println("Test 3: ");


       test3();




    }

    public static void test(){
        // test crop function
        int[] inputCropped = {3, 10, 5, 20, 9, 6};
        int[] croppedAns = {5, 20, 9};
        int[] cropped = crop( inputCropped, 2, 5 );
        System.out.print("Should be: ");
        printArray(croppedAns);
        System.out.print("Got: ");
        printArray(cropped);

        // test concatSounds
        int[] inputSoundConcat1 = {3, 10, 5};
        int[] inputSoundConcat2 = {7, -50, 13};
        int[] concatAns = {3,10,5,7,-50,13};
        int[] concatenated = concatSounds( inputSoundConcat1, inputSoundConcat2 );
        System.out.print("Should be: ");
        printArray(concatAns);
        System.out.print("Got: ");
        printArray(concatenated);

        // test sineSound
        int[] sinAns = {0, 43, -82, 115, -138, 149, -147, 133, -108, 73};
        int[] sineWave = sineSound(10, 10000, 150);
        System.out.print("Should be: ");
        printArray(sinAns);
        System.out.print("Got: ");
        printArray(sineWave);

        // test addSounds
        int[] inputSoundAdd1 = {3, 10, 5};
        int[] inputSoundAdd2 = {7, -50, 13};
        int[] addedAns = {10, -40, 18};
        int[] added = addSounds( inputSoundAdd1, inputSoundAdd2 );
        System.out.print("Should be: ");
        printArray(addedAns);
        System.out.print("Got: ");
        printArray(added);


    }

    public static void test2(){

      int[] inputCropped = {3, 10, 5, 20, 9, 6};
      int[] croppedAns = {20, 9};
      // making sure that it can stop at two numbers
      int[] cropped = crop( inputCropped, 3, 5 );
      System.out.print("Should be: ");
      printArray(croppedAns);
      System.out.print("Got: ");
      printArray(cropped);

      // test concatSounds
      int[] inputSoundConcat1 = {3, 10, 5,8};
      int[] inputSoundConcat2 = {7, -50, 13,8};
      //testing if code can handle array size four
      int[] concatAns = {3,10,5,8,7,-50,13,8};
      int[] concatenated = concatSounds( inputSoundConcat1, inputSoundConcat2 );
      System.out.print("Should be: ");
      printArray(concatAns);
      System.out.print("Got: ");
      printArray(concatenated);

      // test sineSound
      int[] sinAns = {0, 431, -872, 1152, -1380, 1490, -1475, 1334, -1081, 736};
      int[] sineWave = sineSound(10, 10000, 1500);
      //testing if amplitude can be greater than three digits
      System.out.print("Should be: ");
      printArray(sinAns);
      System.out.print("Got: ");
      printArray(sineWave);

      // test addSounds
      int[] inputSoundAdd1 = {3, 10, 5};
      int[] inputSoundAdd2 = {7, -500, 13};
      int[] addedAns = {10, -450, 18};
      //testing if method can handle negative values;
      int[] added = addSounds( inputSoundAdd1, inputSoundAdd2 );
      System.out.print("Should be: ");
      printArray(addedAns);
      System.out.print("Got: ");
      printArray(added);

    }

    public static void test3(){

      int[] inputCropped = {3, 10, 5, 200, 9, 6};
      int[] croppedAns = {200, 9};
      // making sure method can handle three digit numbers
      int[] cropped = crop( inputCropped, 3, 5 );
      System.out.print("Should be: ");
      printArray(croppedAns);
      System.out.print("Got: ");
      printArray(cropped);

      // test concatSounds
      int[] inputSoundConcat1 = {3, 10, 5,8,10};
      int[] inputSoundConcat2 = {7, -50, 13,8,7};
      //making sure method can handle repeated numbers
      int[] concatAns = {3,10,5,8,10,7,-50,13,8,7};
      int[] concatenated = concatSounds( inputSoundConcat1, inputSoundConcat2 );
      System.out.print("Should be: ");
      printArray(concatAns);
      System.out.print("Got: ");
      printArray(concatenated);

      // test sineSound
      int[] sinAns = {0, -946, 1468, -1332, 600, 401, -1222, 1496, -1100, 210};
      int[] sineWave = sineSound(10, 13420, 1500);
      //testing to see if frequency can have digits other than zero after the one
      System.out.print("Should be: ");
      printArray(sinAns);
      System.out.print("Got: ");
      printArray(sineWave);

      // test addSounds
      int[] inputSoundAdd1 = {3, 1000, 5};
      int[] inputSoundAdd2 = {7, -500, 13};
      int[] addedAns = {10, 500, 18};
      //testing the method to see if it can handle four digit numbers;
      int[] added = addSounds( inputSoundAdd1, inputSoundAdd2 );
      System.out.print("Should be: ");
      printArray(addedAns);
      System.out.print("Got: ");
      printArray(added);

    }



    // 3 parameters:
    //      1) an array of ints representing a sound
    //      2) a start index
    //      3) an end index
    // returns:
    //      a new array of ints representing the interval of that same sound that starts
    //      with the sample at the start index and ends at the sample immediately before the
    //      end index.  (You can assume that the end index given will be greater than the start index.)
    public static int[] crop(int[] sound, int start_index, int end_index){
      int[] returned = new int[end_index - start_index];
      int j = 0;
      for(int i = start_index; i < end_index; i++){
        returned[j] = sound[i];
        j++;
      }
        return returned;

    }

    // STEP 1: write concatSounds function
    // 2 parameters:
    //      1) an array of ints representing the first sound
    //      2) an array of ints representing the second sound
    // returns:
    //      a new sound that contains the first sound followed by the second.
    public static int[] concatSounds(int[] sound1, int[] sound2){
      int[] returned = new int[sound1.length + sound2.length ];
      for (int i = 0; i < sound1.length; i++) {
          returned[i] = sound1[i];
      }
      int k = 0;
      for (int j = sound1.length; j < sound2.length + sound1.length; j++) {
          returned[j] = sound2[k];
          k++;
      }
      return returned;
    }

    // STEP 1: write sineSound
    // 3  parameters:
    //      1) a length in samples
    //      2) a frequency in oscillations per second
    //      3) an amplitude
    // returns:
    //      a sound (array of ints) that has the given number of samples, where each entry is given by
    //      sin(((2 * pi * i) / samplerate) * frequency) * amplitude, where i is the index of the entry.
    public static int[] sineSound(int length, int frequency, int amplitude){
      int[] sinestuff = new int[length];

      for(int i = 0; i < length; i++){
      sinestuff[i] = lib.doubleToInt(lib.sin(((2*Math.PI * i)/(SAMPLE_RATE))*frequency)  * amplitude);
    }
      return sinestuff;
    }

    // STEP 1: write addSounds
    // 2 parameters:
    //      1) array of ints representing one sound
    //      2) array of ints representing another sound
    // returns:
    //      a new sound (array of ints) where the amplitude at each index
    //      is the sum of the amplitudes of the input sounds at that index.
    public static int[] addSounds(int[] sound1, int[] sound2){

      int[] sumArray = new int[sound1.length];

      for(int j = 0; j < sound1.length; j++){
        sumArray[j] = sound1[j] + sound2[j];

      }



        return sumArray;
    }

    // DO NOT CHANGE
    // changeVolume
    // 2 parameters:
    //      1) array of ints representing one sound
    //      2) double representing the scaling factor
    // returns:
    //      an array of ints representing the scaled input sound
    // NOTE: to lower the volume, scalar should be less than 1
    // NOTE: to raise the volume, scalar should be greater than 1
    public static int[] changeVolume(int[] sound, double scalar){
        int[] res = new int[sound.length];
        for(int i = 0; i < sound.length; i++){
            res[i] = lib.doubleToInt(lib.intToDouble(sound[i]) * scalar);
        }
        return res;
    }

    // DO NOT CHANGE
    // printArray
    // 1 parameter:
    //      1) array of ints representing one sound
    // returns:
    //      this function does not return anything
    public static void printArray(int[] array){
        System.out.print("{");
        for(int i = 0; i < array.length-1; i++){
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length-1] + " }");
    }

}
