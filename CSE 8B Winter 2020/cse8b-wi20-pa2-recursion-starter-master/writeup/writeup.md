# PA 2: Fun with Recursion!

## Assignment Overview
**Due date: Tuesday, January 21 @ 11:59PM**

**This assignment will take longer than the first PA. Start as early as possible to ensure that you will be able to finish.**

The purpose of this assignment is to continue building your experience with Java, recursion, command line arguments, and file I/O operations. It will consist of two parts.

The first part of the assignment will require you to draw an hourglass on the console using recursion. It has one required command-line argument, the width, which you will use to determine the size of the hourglass.

The second part of the assignment is a conversion of Hawaiian words into their phonetic pronunciation (with a slight twist in the rules). You will read in a file with Hawaiian words and write each word's pronunciation to another file.

You will also be expected to complete a `README.md` answering a few questions.

## Getting Started
There are a number of ways to get started on development. The following is the recommended way to ensure that your code will compile during grading.

1. If you are using your own machine or are on a lab computer to complete the assignment, go to step 2 directly. Otherwise, ssh into your cs8bwi20 account. 
    - `ssh cs8bwi20__@ieng6.ucsd.edu`
2. Acquire the starter files.
    - From ieng6: 
        - Log in to your cs8bwi20 account. 
        - From the command line, use the command `cp -r ~/../public/pa2 ~/` (this will copy the entire starter files directory to your home directory)
        - Type `ls ~` to verify that you have copied the `pa2` directory over. 
    - From GitHub: 
        - `git clone https://github.com/CaoAssignments/cse8b-wi20-pa2-recursion-starter.git`
        - Alternatively, you can download the repo as a zipped folder.
3. If you downloaded the repo as a zipped folder, navigate to it through your terminal or text editor (Atom, Eclipse, etc.). If you git cloned the repo, you can switch into that directory immediately.
    - `cd cse8b-wi20-pa2-recursion-starter`
    - Optional: You may choose to rename this repo. You can do this by using this command:
        - `mv cse8b-wi20-pa2-recursion-starter pa2`
4. You can now start working on it through vim using the following command or open the directory in your preferred editor.
    - `vim Hourglass.java` or `gvim Hourglass.java`
5. To compile your code, use the `javac` command.
    - Syntax: `javac file1.java file2.java etc...`
    - Example: `javac Hourglass.java`
6. To run your code, use the `java` command passing in the name of the class with the main method that you want to run.
    - Syntax: `java nameOfClass`
    - Example: `java Hourglass`

## Part 1: Recursive Hourglass
In this part of the assignment, you will be printing an hourglass shape to the console using recursion. The program has one required command-line argument, which determines the width of the hourglass. The width must be an integer that is odd and greater than or equal to 1. See sample output below to get a better idea of what output is expected.

### Sample Inputs and Expected Outputs
The best way to ensure that your code works properly is to test it! We have provided sample inputs and their respective outputs below for you to check your output. Be sure your output matches **exactly** by using the string constants that we have defined and the `printLine()` helper function!

Valid inputs:
- `java Hourglass`
- `java Hourglass 1`
- `java Hourglass 15`
- `java Hourglass 109`

Invalid inputs:
- `java Hourglass 0`
- `java Hourglass -1`
- `java Hourglass -25 8 1`
- `java Hourglass 50`

Sample outputs:
- `java Hourglass`
![](https://i.imgur.com/Hoxy71r.png)

- `java Hourglass 5`
![](https://i.imgur.com/Xj81HBj.png)

- `java Hourglass 7`
![](https://i.imgur.com/fn1cJnd.png)

- `java Hourglass -1`
![](https://i.imgur.com/0mcpLg3.png)

- `java Hourglass 0 3`
![](https://i.imgur.com/xaQiVaB.png)


### `Hourglass.java`
You will be writing all of your code for this part of the assignment in this file. We have already defined constants that should help you complete this part. The constants that we have defined are declared as `private static final`. **Please use these constants so your output matches the expected result exactly.** Feel free to add constants if necessary. Remember to use constants instead of having magic numbers in your code!

#### `protected static void printLine(int width, int padding)`
**This helper method is given to you!** This function will print a line using this format:
- `[p][w][p]`
- where **p** will have `PADDING_CHAR` `padding` times and **w** will have `HOURGLASS_CHAR` `width` times.

#### `protected static void printHourglass(int width, int padding)`
This method will recursively print an hourglass to the console using the given `width`. `padding` is a parameter that will be useful when you are recursively calling on the function.

From a high level perspective, this method will first print the top half of the hourglass, stop when it reaches the center, and then print the bottom half of the hourglass.

To approach this function, take a look at the sample output. When we pass in 7 as our `width`, what is the width of each line?

After you have identified the pattern, recall that recursion has 3 general parts to its structure: the base case, the recursive call, and the body of the function, where you perform some action at a given function call.

- Your base case needs to stop the recursive calls. Taking a look at the sample outputs, when would be an appropriate time to stop?
    - **Hint:** Use the width in your base case.
- Your recursive call needs to approach the base case. What should you pass into your recursive call?
    - **Hint:** Your width should shrink and your padding should grow.
- Your "body" needs to perform some useful actions. What would this action be?
    - **Hint:** Recall that recursion creates multiple stack frames and places each one on top of each other. What is the difference of performing an action before and after a recursive call? Perform some action before and after your recursive call to produce the intended result.


#### `public static void main(String[] args)`
This method will process any command line arguments and call `printHourglass()` if appropriate.

**You must perform command line argument validation in this order.** When printing the usage or error messages, use `System.out.println()`.

If no arguments were provided, print `HELP_STR` and return. 

Otherwise, check to make sure that only one argument was provided. If more than one argument was provided, print the appropriate error message `EXTRA_ARGS_ERR` and return.

If only one argument was provided, we will parse this argument as an integer and make sure that it is a valid width. You can assume that the argument will always be a valid integer. Parse the argument using [`Integer.parseInt()`](https://docs.oracle.com/javase/10/docs/api/java/lang/Integer.html#parseInt(java.lang.String)) before performing validation checks. If the width is even or less than or equal to 0, the width is invalid, so print out `INVALID_WIDTH_ERR` and return.

If the width is valid, call `printHourglass()` with the appropriate arguments.

## Part 2: Hawaiian Phonetic Translations

### Background on the Hawaiian language

Long Hawaiian words like the fish lauwiliwilinukunuku'oi'oi may seem very intimidating to pronounce, but the language is actually suprisingly simple. Hawaiian language only has 12 of the 26 English characters: 5 vowels and 7 consonants. In this PA, you will write code that will allow a user to get the intuitive pronunciation of Hawaiian words. 

### `Pronounce.java`

At the top of the starter code, you can see some constants (`private static final` variables) that are provided for you. You should use these and declare other constants to avoid the use of magic numbers. 

#### `protected boolean isVowel(char ch)`
First, we write a simple helper function. This method will return `true` if `ch` is a vowel (`a`, `e`, `i`, `o`, or `u`) and `false` otherwise. 

#### `protected boolean isValidChar(char ch)` 
Similarly, we want a helper function to help us figure out if `ch` is a valid character for the Hawaiian language. The valid characters are `'a'`,`'e'`,`'i'`,`'o'`,`'u'`,`'p'`,`'k'`,`'h'`,`'l'`,`'m'`,`'n'`,`'w'`,`' '`(the space character), `'\''`(the single quotation character, since single quotes are also used to denote `char`s, we need to "escape" the quote by adding the backslash to the front). In total, there are 14 valid characters (12 plus the space and the single quote). 

**Hint**: At this point, you might realize how tedious (or maybe you're already one step ahead!) it is to write out all of these conditions. Furthermore, if you were to change the valid characters in the future, you might need to change a lot of code. Although you may learn/discover some much easier and efficient ways to do this check in the future, these are beyond the scope of the course. However, you may want to explore using a loop to iterate across the valid characters. This would work for `isVowel()` too! If you choose to explore this path, you will find that the code for the two functions is nearly identical. Try using some of the provided constants. 

#### `protected boolean isValidString(String str)`
We also want a helper method to check if all the characters in the given String are valid. If the input String is `null`, return `false`. Writing the code for this would be easy by using a loop. However, we want you to practice recursion. **The use of recursion is mandatory for this method.** 

**Note**: You might find [`charAt()`](https://docs.oracle.com/javase/10/docs/api/java/lang/String.html#charAt(int)) and [`substring()`](https://docs.oracle.com/javase/10/docs/api/java/lang/String.html#substring(int)) methods from the `String` class usefulwhen manipulating the String. 

**Note**: You should use your previously written `isValidChar()` to check each character's validity. 

**Hint**: Begin by thinking about the base case. In the base case, we want the empty string (`""` to return `true`). Now, for the recursive case, we can simply check a single character and recursively call `isValidString()` on the remaining string (the original string minus the checked character). 


#### `public String convert(String str)`
Finally, we want to convert a given Hawaiian string to its pronunciation, with only the first character being capitalized. This method should only convert "valid" strings (a string is valid if it only contains our previously-defined valid characters). If a string is not valid, then we should return the original input to this function. Notice that there is the small problem when using our `isValidString()` function: the string `"a"` would be valid but the string `"A"` would not be, which doesn't make sense. Thus, we need to make `convert()` work case insensitively. 

1. Check if `str` is `null`. If it is `null`, then it is invalid and we want to return the original input. 
1. `isValidString()` will only properly work on lowercase strings, so let's do that. Use the [`toLowerCase` method from the `String` class](https://docs.oracle.com/javase/10/docs/api/java/lang/String.html#toLowerCase()) for this. Remember that we haven't checked if the string is valid yet. If it turns out to be invalid, we want to return the original value of `str`, not the lower cased one. 
1. Now, check if the lowercase string is valid using the `isValidString()` method. If the string is invalid, return the original value of `str` immediately. 
1. Now, call the currently unwritten `convertHelper()` method on the valid fully-lowercase string. Store the output in some variable. For now we will not write `convertHelper()` but just assume that it will eventually give the correct output (the phonetic string). 
1. Finally, we have the fully-lowercase pronunciation string. Our final task is to capitalize the first letter. In other cases we might want to take care of the cases where the string is the empty string (`""`) or if the string does not start with a letter (`" hi"` or `" "`), but we won't give you any strings like this. Simply capitalize the zeroth character in the string without doing any checks. You can do this using the [`substring()` method from the `String` class](https://docs.oracle.com/javase/10/docs/api/java/lang/String.html#substring(int)) (which you already used) combined with the [`Character.toUpperCase(char)` method](https://docs.oracle.com/javase/10/docs/api/java/lang/Character.html#toUpperCase(char)). Return this result. 

**Note:** You only need to check if the given String is valid and change the capitalization here. The actual conversion will be handled by `convertHelper()`.

**Note:** You can test your `convert()` before implementing `convertHelper()` by checking if your `convert()` is able to perform the sanity check (i.e. null object and empty string input), validity check, and transform the valid string by making only the first character capitalized. Below are some sample input and output.

|String input|`convert(input)` (before implementation of `convertHelper()`)|Explanation|
|---|---|---|
|null|null|
|""|""|
|"paul"|"Paul"|Valid string, only uppercase first letter
|"ALOHA"|"Aloha"|Valid string, only uppercase first letter
|"CHARLES"|"CHARLES"|Invalid string

#### `protected String convertHelper(String str)`
Since this is a PA about recursion, we require you to complete this method recursively. **You will not earn credit if this method is implemented iteratively (by using a loop to go through the string)**. We use this helper method to do the actual String conversion. After completing this method, try to think about why we have this section of code as a helper method.

To convert a given string into the pronunciation, first you want to check if the character is a vowel. 
1. Check if the first character is a vowel. If it is not a vowel, then the pronunciation is as is. Simply skip to recursively converting the remainder of the string.
2. If it is a vowel, then check if it forms a vowel group with the next character (refer to the table below for vowel groups and vowels pronunciation).
    1. Regardless of if there is a single vowel sound or a vowel group sound, replace the original vowel or vowel group with the pronunciation.
    2. After conversion of a vowel or vowel group, add a dash `-` after the converted vowel or vowel group unless there is a space character (`' '`) or single quote character (`'\''`) following the vowel or vowel group (e.g. `E komo mai` would be converted to `Eh koh-moh meye`).
    3. You can now proceed to recurse on the remainder of the string.

The table of conversions is given below. All trailing spaces should be preserved (See example input and output).

We have given you most of the code for this method. There are 7 `TODOS`, where the 3rd `TODO` has 7 parts (change what the appropriate pronunciation is) and the 5th `TODO` has 5 parts (change what the appropriate pronunciation is).

**Hint**: The recursion here should be very similar to the recursion in `validString()`.

**Note**: You might want to untilize `switch` statements here to avoid a bunch of `else if` statements. You can see the [Java tutorials](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html) for more details.

|Vowels|Conversion|
|---|---|
|a| `ah`|
|e| `eh`|
|i| `ee`|
|o| `oh`|
|u| `oo`|

|Vowel Groups|Conversion|
|---|---|
|ai|`eye`|
|ae|`eye`|
|ao|`ow`|
|au|`ow`|
|ei|`ay`|
|eu|`eh-oh`|
|iu|`ew`|
|oi|`oy`|
|ou|`ow`|
|ui|`ooey`|


#### `protected void convertFile(String infilename, String outfilename)`
Awesome! You have now successfully converted a single Hawaiian word into its Hawaiian Phoenetic Translation. But what if we want to convert an entire file containing multiple such words?

In this method, we have two parameters:`inputfilename` and `outputfilename`. `inputfilename` is the name of the file which has a list of Hawaiian strings (each on a separate line, each string may have multiple words though) that need to be converted into their corresponding Hawaiian phoenetic translations. The `outputfilename` is the name of the file where you will have to write the converted phoenetic translations (again, each on a separate line).

We've provided you with some code that should exist in all code of this form (it has to do with handling exceptions, which we won't focus on for now). You only need to write code at spots marked with `// TODO` comments. There are 2 `TODO`s. 

**Note:** Some strings have multiple words. Thus, simply convert each line (in its entirety) and write the conversion on a new line of the output file each time (each line of output file match each line of the input file). For invalid lines, rewrite the entire line to the output file. Since our `convert()` method returns the original string for invalid strings, we can just write the output from `convert()` for each line (thus delegating the validity checking).


#### `protected void readUserInput()`
**This method is given to you!** This method will help read in user input commands and process them to produce results.

There are 3 valid single letter commands a user can input:

1. **'i'** - This command will prompt the user to enter a word, convert the input word and print it out to the terminal.
2. **'f'** - This command will first prompt the user for an input file name followed by an output file name. The program will then proceed to convert all words in the input file and write them out to the output file. (Hmmm... what function can be used here?)
3. **'q'** - This command will terminate the loop for continuous user input.

Reading the user input should be a continuous and never ending cycle until the user explicitly wants to stop by entering the **'q'** command. If the user gives any invalid input, you must print out a list of valid commands as instructions to use the program and then reprompt the user. 

#### `public static void main(String[] args)`
You have reached the final step of this part! In the main method, we need to identify different "flags" (signals for a function or process) in the command line to call the corresponding functions. **Just like in part 1, please check these flags in this order.** There are 4 situations:

1. The number of arguments is **not 0** and the first argument in the command line is the String **"-h"**. It represents that the user needs help to understand how to use this program. Then, print out the `USAGE` message in the terminal no matter what other arguments are and return. 
1. The number of arguments is **not 0** and the first argument in the command line is the String **"-f"**. It represents that the user wants to convert a file containing Hawaiian words to the phonetic pronunciations and output the result to another file. The format is like `-f infile outfile`. Thus, if there are only 3 arguments in the command line, then call a function that you have written to fulfill the converting functionality of this program. Otherwise, print out the `USAGE` message to tell the user how to input valid arguments. After this, return. 
**Note**: you don't need to check if the files are valid here.
1. The number of arguments is **not 0** and the command line does **not** begin with "-h" or "-f", convert **every** word (argument) in the command line to its phonetic pronunciation, printing the conversion (remember that the conversion of invalid strings is the original string) to the console (using `System.out.println()`). After printing all the conversions, return. 
1. The number of arguments **is 0**. Then, continually prompt the user for a Hawaiian word and read the user's input to convert it to the phonetic pronunciation. You can do this by calling on`readUserInput()`.

### Sample Inputs and Expected Outputs of `convert()`
You can now test by compiling `Pronounce.java` and running `Pronounce` with no extra command line arguments. This will put you in the `readUserInput()` loop where you can test all the following cases (except the null case). 

|String input|convert(input)|Explanation (if needed)|
|---|---|---|
|null | null|
|""| ""|
|"ALOHA"|"Ah-loh-hah"| Only the first letter is capitalized
|"Kokua "|"Koh-koo-ah "| Trailing space preserved
|"E komo mai"|"Eh koh-moh meye"|
|"a hui hou"|"Ah hooey how"|The first letter is capitalized|
|" Hana Hou"|" hah-nah how"|Nothing is capitalized because the first character is a space
|"M3n3hun3"|"M3n3hun3"|Invalid input
|"Hau'oli Makahiki Hou"|"How'oh-lee mah-kah-hee-kee how"|
|"humuhumunukunukuapua'a"|"Hoo-moo-hoo-moo-noo-koo-noo-koo-ah-poo-ah'ah"|

## `README.md`

Answer the following questions in a file named `README.md`. Write them in sections corresponding to question letter. **Remember to add a file header to your `README.md`. We have provided you with sample headers in the files you have been working in.**

You can create this file by using the touch command or saving the file with the `.md` extension in a text editor.
- `touch README.md`

a. What single command will print the first 13 lines (or up to 13, if fewer than 13 lines are in the file) of `./Pronounce.java` to the console?

b. What single command will list every file and directory in the current directory (including hidden files like `.vimrc`)? Hidden files and directories are denoted by a `.` at the beginning of their names.

c. What single command will create a file called `CSE.rocks` in the current directory (**without** leaving the terminal by, for example, entering `vim/gvim`)? (You may have already used it to create this file.)

d. How do you copy a directory named `PA_Work` and all its contents with one command to the home directory? Assume `PA_Work` is in the directory that you are currently in.

e. How do you rename a file named `foo.f` to `bar.b` with one command from the command line? Assume `foo.f` is in the directory that you are currently in.

f. How do you copy all files ending with `.java` in the parent directory to the current directory with one command?

## Student Satisfaction Survey

Please fill out our [student satisfaction survey](https://docs.google.com/forms/d/e/1FAIpQLSf8CereivDrCmTrneKcp7M-WZj1a5R-mSwQkr7tk8tjWmmD9A/viewform). We are changing how we approach giving assignments and would like to hear about your experiences. After filling out the survey, please write the following sentence at the top of your `README.md` file: **I have completed the student satisfaction survey.** 

## Style
**In this PA, we will focus on the following items: 1, 2, 3, 4, 5. We will start to strictly grade on style starting from PA3.**

We will grade your code style thoroughly. Namely, there are a few things you must have in each file / class / method:

1. File header
2. Class header
3. Method header(s)
4. Inline comments
5. Proper indentation
6. Descriptive variable names
7. No magic numbers
8. Reasonably short methods (if you have implemented each method according to specification in this write-up, you’re fine). This is not enforced as strictly.
9. Lines shorter than 80 characters (keep in mind each tab is equivalent to 8 spaces).
10. Javadoc conventions (@param, @return tags, /** comments */, etc.)

A full [style guideline](https://sites.google.com/eng.ucsd.edu/cse8b-winter2020/style-guide?authuser=0) can be found here. If you need any clarifications, feel free to ask on Piazza.

## Submission Preparation
Before submitting, make sure your code compiles and runs properly on ieng6 if you aren't already working on ieng6. **Note:** If you are on a lab computer, then your files are already on ieng6.

You can follow these steps to transfer your files to the ieng6 server.
1. From your terminal, navigate to the directory containing your work. To verify that you are in the correct directory, use the following command.
    - `ls cse8b-wi20-pa2-recursion` or `ls your_PA2_folder_name`
    - The folder where all of your work is located should appear. If it says "No such file or directory", then you need to switch to the correct directory.
2. Once in the correct directory, you can use the `scp` command to transfer your files to the server.
    - `scp -r cse8b-wi20-pa2-recursion cs8bwi20__@ieng6.ucsd.edu:~/` or
    - `scp -r your_PA2_folder_name cs8bwi20__@ieng6.ucsd.edu:~/`
    - It will ask for your password. If nothing is displayed while you are typing your password, this is expected! This is for security purposes so no one else can see how many characters are in your password.
3. `ssh` into the server to compile and run your code.

After you have confirmed that your code works properly, if you were working remotely and need the files on your local machine, you can follow these steps. **Note:** If you are on a lab computer, the files are already available for you to zip and upload to Gradescope.
1. From your **local machine**, open up your terminal.
2. Navigate to the directory where you want to place your work.
3. `scp` the folder from the server to your local machine. This command assumes that your work is in your home directory on ieng6.
    - `scp -r cs8bwi20__@ieng6.ucsd.edu:~/cse8b-wi20-pa2-recursion .` or
    - `scp -r cs8bwi20__@ieng6.ucsd.edu:~/your_PA2_folder_name .`
    - This will copy your PA2 work to the directory that you are currently in locally. Again, it will ask for your password so don't be alarmed if nothing appears when you type your password.
4. You can now zip this folder or select all of the files to upload to Gradescope.

If you want to copy a single file instead of the entire directory, you can remove the `-r` flag from the respective command above and specify the path to the single file that you want to copy. For example:
- `scp cs8bwi20__@ieng6.ucsd.edu:~/Hourglass.java .` will copy the `Hourglass.java` file located in the home directory of your ieng6 account to the current directory on your local machine.


## Submission
Required Submission Files
- `Hourglass.java`
- `Pronounce.java`
- `README.md`

*Start early and start often!*
