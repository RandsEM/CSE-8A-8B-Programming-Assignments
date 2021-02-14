I have completed the student satisfaction survey.

Darren Yeung
Login: cs8bwi20rr
2/3/2020
Filename: README.md

1. The Game 2048 is a sliding puzzle game on a 4v4 grid. At the start,
two random tiles (2 or 4) are generated. There is a 90% chance to spawn a
2 and a 10% chance to spawn a 4. The user has four moves, left, right, down, or up.
Upon a given request to a direction, all tiles move towards that direction
until stopped by another tile or the wall. If it encounters another that has the
same number, the latter tile becomes the sum of the two tiles and the sum is
added to the player's score. That added tile cannot be combined again with another
during the same turn. After each move, a new random tile is generated on the board
and the process continues until the player cannot make anymore moves in any direction.

2. The benefits of having all our magic numbers in the Config.java file is that it improves
user readability. If we write code and just put a random number there, someone trying
to understand our code may not know what that number means. However, if we defined that number
in English and put that instead, the reader will be able to understand what that number is for. It
also makes it easier for the coder himself to understand what he is coding. Coding can get messy
and when trying to figure out a bug, it may be hard to do so with a bunch of random numbers not
set into English.

3. We want to return a deepCopy in the getBoard() method when we want only read access to it because
if we returned the actual reference to the board, the user can mistakenly change the board by accident.
And since if we returned a shallow copy instead of a deep copy, any changes made the shallow copy
changes the actual thing since they both have the same reference to the 2D array. We return a deep
copy (a completely different 2D array with the same values) in order to prevent the reader from making
changes to the game by accident.
