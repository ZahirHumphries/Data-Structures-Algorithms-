import java.util.ArrayList;
import java.util.List;



/* Definiton: Two integer variables that move along an iterable (array, String)
 Conventions: left / right, i & j 

 
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
    // Time Complexity: O(n) "traversing through the whole array"
    // Space Complexity: O(1)
            
public boolean checkIfPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1; 

    while (left < right) { 
        // Cost - O(1) each iteration
        if (s.charAt(left) != s.charAt(right)) {
            return false; 
        }

        left++;
        right--;
    }

    return true;
}

// Example 2: Given a sorted array of unique integers & target integer, return true if there exists a pair of numbers that sum to target, false otherwise 

// Time Complexity: O(n) "traversing through the whole array"
// Space Complexity: O(1)
public boolean checkForTarget(int[] nums, int target) {
    int left = 0; 
    int right = nums.length - 1; 

    while(left < right) {
        // curr is the current sum 
        int curr = nums[left] + nums[right];
        if (curr == target) {
            return true;
        } 
        if(curr > target) {
            right--; 
        } else {
            left++;
        }
    }

    return false; 

}


/* 

2nd Idea: Move along both inputs simultaneously until all the elements have been checked 

Steps: 
1.  Creat two pointers, one for each iterable, each pointer starts at the first index 
2.  Use a while loop until one of the pointer reaches the end of the iterable 
3.  At each iteration of the loop, move the pointers forward. Either increment both pointers, or increment one pointer and keep the other pointer in place.
    3a. Decide which pointer to move depending on the problem.
4. Make sure both iterables are exhausted, because one iterable might finish before the other.


General Template:
function fn(arr1, arr2):
i = j = 0
while i < arr1.length and j < arr2.length:
     do some logic here depending on the problem 
     do more logic to decide on one of the following:
    1. i++
    2. j++
    3. Both i++ and j++

     Step 4: make sure both iterables are exhausted 
    one of the loops will run
    while i < arr1.length:
         do something with arr1[i]
        i++

    while j < arr2.length:
         do something with arr2[j]
        j++

*/

// Example 3: Given two sorted integer arrays, return a new array containing all the elements from both arrays in sorted order

// Brute Force Approach: Combine both arrays, Then perform a sort. 
// Time Complexity: O(nlogn) "sorting the array" --> " if it was not sorted then this would good approach"

// Better Approach: Use two pointers to merge the two arrays in sorted order T(C) = O(n), improved by factor of logn 


public List<Integer> combine(int[] arr1, int[] arr2) {
    // ans is the final array that will be returned
    List<Integer> ans = new ArrayList<>();
    // Space (C) = O(1)
    // Time (C) = O(n)

    int i = 0;  
    int j = 0;

    // O(1) --> Operations 
    while(i < arr1.length && j < arr2.length) {
        if (arr1[i] < arr2[j]) {
            ans.add(arr1[i]);
            i++;
        } else {
            ans.add(arr2[j]);
            j++;
        }

        while( i < arr1.length) {
            ans.add(arr1[i]);
            i++;
        }

        while (j < arr2.length) {
            ans.add(arr2[j]);
            j++;
        }
    }

    return ans; 


}

/* Example 4: Subsequnces 
Given two strings s and t, return true if s is a subsequence of t, or false otherwise. 
*/

// Time Complexity: O(n) "traversing through two strings" --> Linear Time
// Space Complexity: O(1)

public boolean isSubsequence(String s, String t) {
int i = 0;
int j = 0; 

while(i < s.length() && j < t.length()) {
    if(s.charAt(i) == t.charAt(j)) {
       i++;
    }
    // Whether the strings are a match or not, we need to move forward in t
    j++;
}
    // We have subsequence if exhausted all of charcters in s
    return i == s.length();
}


// Problem 1: Reverse a String

public void reverseString(char[] s) {
        
    /*
    
    Time Complexity: O(n) -- we traversed the the whole array
    Space Complexity: O(1) -- we used two integer variables 
    input :  s = ["h","e","l","l","o"]
    */
    int left = 0; 
    int right = s.length - 1; 
    
    while(left < right) {
        char temp = s[right]; // temp = "o"
        s[right] = s[left]; // s[right] = "h"
        s[left] = temp;  // s[left] = "o", temp is " " / WE swapped
        left++; 
        right--; 
    }
    
}

// Problem 2: Sqaures of Sorted Array

class Solution {
    public int[] sortedSquares(int[] nums) {
        // Time Complexity: O(n)
        // Space Complexity: O(1)
        //  nums = [-4,-1,0,3,10] --> 16, 100 --> int ans {0,1,9,16,100}
        int left = 0;
        int right = nums.length - 1; 
        
        int[] ans = new int [nums.length];
        // Pointer used to fill up our ans array
        int position = nums.length - 1;
        
        
        while(left < right) {
            // 1st step) square the elements at each position 
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            
            // 2nd step) Sort the elements 
            if(leftSquare > rightSquare) {
                ans[position] = leftSquare;
                left++;
            } else {
                ans[position] = rightSquare;
                right--;
            }
            position--; 
        }
     
        
        return ans; 
    }
}
}
