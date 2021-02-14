/**
 * Name: Darren Yeung, A15943292, cs8bwi20rr
 * Date: 3/5/2020
 * Sources of Help: Lectures, Google, Piazza
 * This file contains the generic class PokemonStorage system. This allows
 * the user to interact with a storage system like the ones 
 * found in a typical pokemon game. There are many functionalities of the class 
 * which the users can use to manipulate their storage of items, but in this case, 
 * Pokemons
 */

import java.util.*; 

/**
 * This is the generic class PokemonStorageSystem that allows the user to interact with a
 * storage system that stores any object T the user wishes. Each storage system contains 
 * 8 Boxes and each of those boxes are initialized to have 30 spaces
 * @param <T>
 */
public class PokemonStorageSystem <T>{

    private static final int MAX_BOXES = 8;
    private static final int MAX_ITEMS = 30;
    private static final String OUT_OF_BOUNDS_EXCEPTION = "Box: %d, Pos: %d";
    private List<Box<T>> storage; 
    private T partyMember; 

    /**
     * This is the default constructor used make a new Storage system. It initializes 
     * the box array to new Array and adds 8 boxes to the array
     */
    public PokemonStorageSystem(){
        this.storage = new ArrayList<>();
        for(int i = 1; i <= MAX_BOXES; i++){
            Box<T> box = new Box<T>(MAX_ITEMS);
            this.storage.add(box);
        }
    }
    
    /**
     * This method allows the user to the set the current figher pokemon. It
     * basically initializes the partyMember to what the user puts in
     * @param partyMember
     */
    public void setPartyMember(T partyMember){
        this.partyMember = partyMember;
    }

    /**
     * This method allows the user to add a new object to the storage 
     * system. But in this case, we are adding Pokemons. It adds the Pokemon 
     * into the next available space and if no space is available, it throws 
     * an exception
     * @param newPokemon The pokemon that is going to be added to this 
     * storage system
     */
    public void deposit(T newPokemon) throws NoStorageSpaceException{
        for(int i = 0; i < this.storage.size(); i++){
            if(i == this.storage.size() - 1){
                if(this.storage.get(i).deposit(newPokemon) == false){
                    throw new NoStorageSpaceException();
                }
            }
            if(this.storage.get(i).deposit(newPokemon) == true){
                break;
            }else{
                continue; 
            }
        }
    }

    /**
     * This method allows the user to release a specific object from 
     * an index box and an index of of the a position in the box. In this case, 
     * we are talking about pokemons
     * @param box The box position in the storage system
     * @param pos The position in the box 
     * @return the object at the specified position
     * @throws OutOfBoundsException Thrown the box position or the position in the box
     * doesn't exist
     */
    public T release(int box, int pos) throws OutOfBoundsException{
        if(box < 0 || box >= this.storage.size()){
            throw new OutOfBoundsException(String.format(OUT_OF_BOUNDS_EXCEPTION, box , pos));
        }
        if(pos < 0 || pos >= MAX_ITEMS){
            throw new OutOfBoundsException(String.format(OUT_OF_BOUNDS_EXCEPTION,box,pos));
        }
        T pokemon = this.storage.get(box).getPositionAtIndex(pos).getPokemon();
        this.storage.get(box).getPositionAtIndex(pos).setPokemon(null);
        return pokemon;
    }

    /**
     * This method allows the user to move one specific object at a box and its 
     * position at the box to another box/positon in the box. 
     * @param boxFrom Position of box that contains what the user wants to move 
     * @param posFrom Position in the box that contains what the user wants to move
     * @param boxTo Position of the box that contains what the user wants to move to 
     * @param posTo Position in the box that contains what the user wants to move to
     * @throws OutOfBoundsException Thrown when any one of the the box positions or
     * position in the box doesn't exist
     */
    public void move(int boxFrom, int posFrom, int boxTo, int posTo) 
    throws OutOfBoundsException{
        if(boxFrom < 0 || boxFrom >= this.storage.size()){
            throw new OutOfBoundsException(String.format(OUT_OF_BOUNDS_EXCEPTION, boxFrom, posFrom));
        }
        if(posFrom < 0 || posFrom >= MAX_ITEMS){
            throw new OutOfBoundsException(String.format(OUT_OF_BOUNDS_EXCEPTION, boxFrom, posFrom));
        }
        if(boxTo < 0 || boxTo >= this.storage.size()){
            throw new OutOfBoundsException(String.format(OUT_OF_BOUNDS_EXCEPTION, boxTo, posTo));
        }
        if(posTo < 0 || posTo >= MAX_ITEMS){
            throw new OutOfBoundsException(String.format(OUT_OF_BOUNDS_EXCEPTION, boxTo, posTo));
        }
        T pokemonFrom = this.storage.get(boxFrom).getPositionAtIndex(posFrom).getPokemon();
        T pokemonTo = this.storage.get(boxTo).getPositionAtIndex(posTo).getPokemon();
        this.storage.get(boxFrom).getPositionAtIndex(posFrom).setPokemon(pokemonTo);
        this.storage.get(boxTo).getPositionAtIndex(posTo).setPokemon(pokemonFrom);
    }

    /**
     * This method returns a string representation of the entire box the user 
     * wants to print
     * @param boxNumber The box number the user wants to print
     * @return A string representation of the all the contents in the box 
     * the user wants to print
     * @throws OutOfBoundsException Thrown when the user enters a box index that doesn't
     * match any box in the storage
     */
    public String getBox(int boxNumber) throws OutOfBoundsException{
        if(boxNumber < 0 || boxNumber >= this.storage.size()){
            throw new OutOfBoundsException(String.format(OUT_OF_BOUNDS_EXCEPTION,boxNumber,0));
        }else{
            return this.storage.get(boxNumber).toString();
        }
    }
}