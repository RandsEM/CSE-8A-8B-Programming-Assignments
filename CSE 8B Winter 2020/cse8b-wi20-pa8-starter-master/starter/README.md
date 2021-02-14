1. The benefits of doing this is that now, we don't neccessary need to store Pokemon objects. 
With it being generic, we can store anything we like. We can store any objects. 

2.  The reason why we need the <T> is because when we are creating the object Position, we 
should specifiy which type of object we want to store in the Position. If we didn't include
the <T>, then it would just assign T has an Object type and iterate over the for each loop. 
This will cause confusion because not all objects are Positions. Putting the <T> there allows 
no confusion to occur. Because assuming the user created the Box with the type Pokemon, the for 
each loop will asign the reference varible Position<Pokemon> t0 each of the position objects 
in the list and do things with those position objects that may only work with Pokemon objects 
and nothing else. 

3. First, the user chooses a starter Pokemon that can either be Charmander, Squirtle, or Bulbasaur. 
He then battles a rival Pokemon and loses or wins depending how much damange they both did. He can then 
go out into the wild and capture various Pokemons that he/she specified in a txt file. If he chooses 
to run from the Pokemon, he never encounters it again. If he catches the pokemon, it is stored in 
the PokemonStorageSystem. A player cannot store more than 8*30 Pokemons which is 240.
