/**
 * Name: Darren Yeung, A15943292, cs8bwi20rr
 * Date: 3/5/2020
 * Sources of Help: Lectures, Google, Piazza
 * This file contains the class Simualtor which simualtes a typical Pokemon game
 * It allows the user to catch Pokemons and run from Pokemons. It also allows
 * the user to choose a starter pokemon and battle its rival pokemon. 
 */

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This is the class Simulator which has various methods that allows the 
 * user to create a scuffed version of a Pokemon game. The user can
 * specify which pokemons he wants in the wild and interact with them 
 * with a storage system whichy is an instance variable
 */
public class Simulator {

    // Used if user selects bulbasaur as starter
    private static final int BULBASAUR = 2;

    // Used to parse the level of a Pokemon
    private static final int LEVEL_INDEX = 2;

    // Number of required arguments
    private static final int REQUIRED_ARGS = 2;
    private static final int REQUIRED_ARGS4 = 4; 

    // Used to split pokemon file / user input
    private static final String SEPARATOR = ",";
    private static final String PROMPT_SEP = " ";

    // Used to index through user arguments
    private static final int BOX_INDEX = 1;
    private static final int POS_INDEX = 2;
    private static final int TO_BOX_INDEX = 3;
    private static final int TO_POS_INDEX = 4;

    // Different choices user can make 
    private static final String OPTION_0 = "0";
    private static final String OPTION_1 = "1";
    private static final String OPTION_2 = "2";

    private static final int POKEMON_CHOICE0 = 0;
    private static final int POKEMON_CHOICE1 = 1;
    private static final int POKEMON_CHOICE2 = 2;

    private static final int ID_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int LEVEL_IND = 2;

    private static final String USER_PROMPT = "> ";

    private static final String USAGE_PROMPT =
        "\nUsage: java Simulator [0|1|2] [filename]\n" +
        "0 - Charmander, 1 - Squirtle, 2 - Bulbasaur\n\n";

    private static final String MAIN_PROMPT =
        "\nWhat would you like to do?\n" + 
        "[0] - Go into the wild!\n" +
        "[1] - View your PC!\n\n";

    private static final String PC_PROMPT =
        "\nCurrently viewing someone's PC\n" +
        "[0] b           - View box b (specify a number)\n" +
        "[1] b1 p1 b2 p2 - Move Pokemon at box b1, pos p1 to box b2, p2\n" +
        "[2] b p         - Release Pokemon at box b, pos p\n\n";

    private static final String WILD_PROMPT =
        "\nYou have encountered a level %d %s!\n" +
        "[0] - Catch\n" + 
        "[1] - Run\n\n";
    
    private static final String CAUGHT_PROMPT =
        "\nSuccessfully caught %s!\n";

    private static final String RUN_PROMPT =
        "\nPhew... ran away!\n";

    private static final String BATTLE_INTRO =
        "\nBattling against your rival!\n" +
        "Your rival sent out %s.\n" +
        "Go! %s!\n" +
        "--------------------------------------\n";

    private static final String BATTLE_MAIN =
        "Your rival has dealt %d damage!\n" +
        "You dealt %d damage!\n\n";

    private static final String BATTLE_WIN =
        "You won!\n";

    private static final String BATTLE_LOSE =
        "You lost! Smell you later!\n";

    private static final String EMPTY_WILD =
        "No more pokemon in the wild!\n";

    private static final String SUCCESSFUL_MOVE =
        "Successful move!\n";

    private static final String SUCCESSFUL_RELEASE =
        "Successful release!\n";

    private static final String UNRECOGNIZED_PROMPT =
        "Unrecognized command. Please try again.\n\n";

    private static final String FILE_NOT_FOUND =
        "File: %s could not be found!\n\n";

    // One storage, one scanner (reinitialize scanner as necessary)
    private static PokemonStorageSystem<Pokemon> storage;
    private static Scanner scanner;

    /**
     * This method takes in the string of a filename containing 
     * details of a pokemon and converts that to a pokemon and stores
     * it in a list until there are no more lines in the text file
     * @param filename Name of file that contains the details of 
     * pokemons the user wants in the game
     * @return A list containing all pokemons objects that was listed
     * in string form in the text file
     */
    private static List<Pokemon> parsePokemonFile(String filename){
      List<Pokemon> pokemonsFromFile = new ArrayList<>();
      File pokemons = new File(filename);
      try{
        Scanner sc = new Scanner(pokemons);
        while(sc.hasNextLine()){
          try{
            String current = sc.nextLine();
            if(current.isEmpty()){
              continue; 
            }
            current = current.trim();
            String[] splitted; 
            splitted = current.split(SEPARATOR);
            if(splitted.length != 3){
              continue; 
            }
            String id = splitted[ID_INDEX];
            String name = splitted[NAME_INDEX];
            int level = Integer.parseInt(splitted[LEVEL_IND]);
            Pokemon pokemon = new Pokemon(id, name, level);
            pokemonsFromFile.add(pokemon);
          }catch(MinLevelException mle){
            System.out.println(mle.getMessage());
            return null; 
          }catch(MaxLevelException mle){
            System.out.println(mle.getMessage());
            return null; 
          }
        }
      }catch(FileNotFoundException fnfe){
        System.out.printf(FILE_NOT_FOUND,filename);
        return null;
      }
      return pokemonsFromFile;
    }

    /**
     * This method handles the battle that occurs when the user first runs 
     * the program. 
     * @param starter The Pokemon that the user chose to start with
     * @param rival The Pokemon that is the rival of the user's Pokemon
     */
    private static void handleBattle(Pokemon starter, Pokemon rival) {
        // Initial battle text
        System.out.printf(BATTLE_INTRO, rival.getName(), starter.getName());

        /** TODO Implement rival battle logic */
        // Calculate damage done from each pokemon
        int starterAttack = starter.attack();
        int rivalAttack = rival.attack();
        System.out.printf(BATTLE_MAIN,rivalAttack,starterAttack); 

        // Use System.out.printf with BATTLE_MAIN as format string

        // Battle logic -- you win if your damage > rival damage
        if(starterAttack > rivalAttack){
          System.out.println(BATTLE_WIN);
        }else{
          System.out.println(BATTLE_LOSE);
        }
        // System.out.printf BATTLE_WIN if you win
        // else BATTLE_LOSE
    }

    /**
     * This method handles what happens when the user runs into the wild
     * The user can either catch a wild pokemon or run from it 
     * Throws an exception if the user wants to catch a Pokemon but his/her 
     * storage system is already filled
     */
    private static void handleWild(Pokemon wild) {
        // Use the wild pokemon that was passed in
        System.out.printf(WILD_PROMPT, wild.getLevel(), wild.getName());
        // Parse user's next decision
        String line;
        boolean invalid = true;
        try {
            // Keep prompting user until a valid action has been made
            while(invalid) {
                System.out.print(USER_PROMPT);
                line = scanner.nextLine().toUpperCase().trim();
                switch(line) {
                    case OPTION_0:
                        invalid = false;
                        storage.deposit(wild);
                        System.out.printf(CAUGHT_PROMPT, wild.getName());
                        break;
                    case OPTION_1:
                        invalid = false;
                        System.out.printf(RUN_PROMPT);
                        break;
                    default:
                        System.out.printf(UNRECOGNIZED_PROMPT);
                        break;
                }
            }
        }catch(NoStorageSpaceException nsse){
          System.out.println(nsse.getMessage());
        }
        /** TODO Add catch statement here. No `Exception e` */ 
    }
    
    /**
     * This method handles what happens if the user wants to interact with 
     * his storage system The user can do various tasks when he chooses this 
     * option like moving his pokemon from one location to another, releasing
     * Pokemons, and just merely seeing his collection of Pokemons in various Boxes
     * in the storage system 
     */
    private static void handlePC() {
        System.out.printf(PC_PROMPT);
        String line;
        String[] splitLine;
        // Keep looping until we have a valid input
        boolean invalid = true;
        try {
            while(invalid) {
                System.out.print(USER_PROMPT);
                line = scanner.nextLine().trim();
                splitLine = line.split(PROMPT_SEP);
                // Check to ensure number of required args is correct
                // If so, then parse accordingly
                // Assumes that inputs are numbers; Not handling invalid cases
                switch(splitLine[0].toUpperCase()) {
                    case OPTION_0: {
                        if(splitLine.length-1 != 1) {
                            System.out.printf(UNRECOGNIZED_PROMPT);
                            break;
                        }
                        invalid = false;
                        /** TODO Pase argument and pass in getBox */
                        String box = storage.getBox(Integer.parseInt(splitLine[1]));
                        /** TODO System.out.printf output of getBox */
                        System.out.printf(box);
                        break;
                    }
                    case OPTION_1: {
                        if(splitLine.length -1 != REQUIRED_ARGS4) {
                            System.out.printf(UNRECOGNIZED_PROMPT);
                            break;
                        }
                        invalid = false;
                        /** TODO Parse arguments and pass into move */
                        int box = Integer.parseInt(splitLine[BOX_INDEX]);
                        int pos = Integer.parseInt(splitLine[POS_INDEX]);
                        int boxTo = Integer.parseInt(splitLine[TO_BOX_INDEX]);
                        int posTo = Integer.parseInt(splitLine[TO_POS_INDEX]);
                        storage.move(box,pos,boxTo,posTo);
                        System.out.printf(SUCCESSFUL_MOVE);
                        break;
                    }
                    case OPTION_2: {
                        if(splitLine.length -1 != REQUIRED_ARGS) {
                            System.out.printf(UNRECOGNIZED_PROMPT);
                            break;
                        }
                        invalid = false;
                        /** TODO Parse arguments and pass into release */
                        int box = Integer.parseInt(splitLine[BOX_INDEX]);
                        int pos = Integer.parseInt(splitLine[POS_INDEX]);
                        storage.release(box, pos);
                        System.out.printf(SUCCESSFUL_RELEASE);
                        break;
                    }
                    default:
                        System.out.printf(UNRECOGNIZED_PROMPT);
                        break;
                }
            }
        }catch(OutOfBoundsException oobe){
          System.out.println(oobe.getMessage());
        }
        /** TODO Add catch statement */
    }

    /**
     * Method that starts the program. Contains two command line arguments. 
     * The first one is the starter Pokemon and the second one is the name 
     * of the txt file containing the Pokemons the user wants to encounter 
     * in the wild
     * @param args String array that contains the command line arguments
     */
    public static void main(String[] args) {
        if(args.length != REQUIRED_ARGS) {
            System.out.printf(USAGE_PROMPT);
            return;
        }
        /** TODO Initialize global pokemon storage */
        Simulator.storage = new PokemonStorageSystem<Pokemon>();
        // Choose your starter pokemon
        int choice = Integer.parseInt(args[0]);
        Pokemon starter = null;
        Pokemon rival = null;
        /** TODO Initialize the starter and rival variables accordingly */
        try{
          if(choice == POKEMON_CHOICE0){
            starter = new Charmander();
            rival = new Squirtle();
          }else if(choice == POKEMON_CHOICE1){
            starter = new Squirtle();
            rival = new Bulbasaur();
          }else if(choice == POKEMON_CHOICE2){
            starter = new Bulbasaur();
            rival = new Charmander();
          }else{
            return; 
          }
        }catch(MinLevelException min){
          System.out.println(min.getMessage());
          return; 
        }catch(MaxLevelException max){
          System.out.println(max.getMessage());
          return; 
        }
        storage.setPartyMember(starter);
        /** TODO Start battle against the opposing rival pokemon */
        handleBattle(starter, rival);
        // Retrieve the filename of all the Pokemon that can be attainable
        List<Pokemon> allPokemon = parsePokemonFile(args[1]);
        if(allPokemon == null) {
            return;
        }
        // Used to index through allPokemon
        int currIndex = 0;
        // Interactive mode
        System.out.printf(MAIN_PROMPT);
        System.out.print(USER_PROMPT);
        scanner = new Scanner(System.in);
        String line;
        // Keep looping until ctrl+D
        while(scanner.hasNextLine()) {
            // Decide whether to go into the wild or view PC
            line = scanner.nextLine().toUpperCase().trim();
            switch(line) {
                case OPTION_0:
                    if(currIndex >= allPokemon.size()){
                        System.out.printf(EMPTY_WILD);
                    } else {
                        /** TODO Call on handleWild */
                        handleWild(allPokemon.get(currIndex));
                        currIndex += 1; 
                    }
                    break;
                case OPTION_1:
                    handlePC();
                    break;
                default:
                    System.out.printf(UNRECOGNIZED_PROMPT);
                    break;
            }
            System.out.printf(MAIN_PROMPT);
            System.out.print(USER_PROMPT);
        }
    }
}
