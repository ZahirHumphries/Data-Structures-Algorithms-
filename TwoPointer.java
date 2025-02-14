// Definiton: Two integer variables that move along an iterable (array, String)
// Conventions: left / right, i & j 

/* 
1st Idea: Start the pointers at the edges of the input, move them towards each other until they meet in the middle

steps: 
1. Start the 1st pointer at the first index 0, the 2nd pointer at the last index input.length - 1
2. Use a While loop unitl the pointers are equal to each other
3. At each iteration, move the pointers towards each other, 
    3a. Increment the pointer @ the first index, decrement the pointer @ the last index, or do both,
    Deciding which pointers to move depends on the problem. 

General Template:

function fn(arr):
left = 0; 
right = arr.length - 1

while left < right:
    // do some logic here depending on the problem 
    // do more logic to decide on one of the following:
    1.left++
    2.right--
    3.both leftt++ and right-- 
*/

// Example: Check if a string is a palindrome

class  TwoPointer {

public static void main(String[] args) {
    TwoPointer tp = new TwoPointer();
    System.out.println(tp.checkIfPalindrome("racecar"));
    System.out.println(tp.checkIfPalindrome("hello"));
}
    
public boolean checkIfPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1; 

    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false; 
        }

        left++;
        right--;
    }

    return true;
}


}










