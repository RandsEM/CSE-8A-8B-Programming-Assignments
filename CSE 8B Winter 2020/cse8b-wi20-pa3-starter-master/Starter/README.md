I have completed the student satisfaction survey.

Darren Yeung
Login: cs8bwi20rr
1/23/2020
Filename: README.md


##Debugging code
Compile time error: cannot find symbol
Incorrect: for (int i = 0; i < array.length(); i++);
Fix: (int i = 0; i < array.length; i++);
Explanation: In order to get the length of an array, we use array.length, array.length().
Because the .length() method is  used to get the length of a string.

<Next Error>

Compile time error: incompatible types int [] cannot be converted to boolean
Incorrect: if (array = null)
Fix: if (array == null)
Explanation: When we want to test if something is equal to each other, we use ==.
A single equal signs basically assigns a value to something else. Double equal sign
is to test for equality.

<Next Error>

Compile time error: cannot find symbol
Incorrect:  array[j] = temp;
Fix: array[array.length - i - 1] = temp;
Explanation: The variable j has not been declared anywhere within the method so
it cannot find it when we are trying to use it as an index for the array. When we use
array.length - i -1, we are just starting from the end of the array and replacing it with whatever is
stored in temp.

<Next Error>

Runtime error: Array Index out of bounds exception
Incorrect: for (int i = 0; i <= array.length; i++)
Fix: for (int i = 0; i < array.length; i++)
Explanation: When we run the loop all the way up to = to the array length, it doesn't work,
because indexing an array starts at 0 and ends at length -1. So in the case, the length was 8
and it tried to access index 8 but the last index is actually 7 since we started from 0

<Next Error>

Logical error: copy of array yields 00000000
Incorrect: array[i] = result[i];
Fix result[i] = array[i];
Explanation: When we say array[i] = result[i], we are changing the values of the array
we want to copy FROM. We are basically putting in the values of the tobecopied array
which is all 0s into the array we wanted to copy from. If we just reversed it, it would work
because result[i] = array[i] means that we are putting the value from the array we want to copy
from into the new copy.

<Next Error>

Logical error: returned the max plus the min instead of max - min
Incorrect: return max + min;
Fix: return max - min;
Explanation: When we want to find the range of a set of numbers, we want to subtract the
lowest value from the highest value, not add them together.

<Next Error>

Logical error: returned an integer division instead of the actual average that includes decimals
Incorrect: double average = (sum / (array.length));
Fix: double average = ((double)sum / (array.length));
Explanation: The sum is type integer and length is also an integer. When we divide two
integers in java, it does integer division where it basically sees how much of the divisor can
fit inside the dividend, no more, no less. So when the sum is 141, we took it and divided it by 8.
8 can only fit inside 141 17 times which is why we got 17. If we cast the sum to be a double however,
java now knows to double divison and returns the decimal value.

<Next error>

Logical Error: did not iterate the variable j so all the program did was check whether or
not the first value was greater than the second one, switched it if it was, and stopped there
Incorrect: for (int j = 0; j < array.length - i - 1; i++)    
Fix:  for (int j = 0; j < array.length - i -1; j++)     
Explanation: We basically want to use a nested for loop in order to sort the entire array. For the first time the inner loop runs,
it must check whether or not the first value is greater than the second. If so, it swaps them. And then it checks if the second
value is greater than the third one, if so, it swaps. And then it checks if the third one is greater than the fourth one, if so, it swaps.
The reason why the unfixed code did not work is because it did not iterate the variable j so j was always at zero. All it did was keep
checking if array[j] was greater than array[j+1] ( if array[0] was > array[1] ) until i reached the number before array.length -1. To fix, all
we needed to do was iterate j instead of i in the inner for loop.
