# CS245-Lab02-Backtracking

Due Date: September 9, 2022

## Background

---

Backtracking is an algorithmic technique to solve problems recursively by exploring every possible valid choice. During the process, it will remove solutions that fail to satisfy the constraints of the problem, and once it hits the final state, it will add the working solution to the final result. Problems like 8-Queens, Sudoku, permutations in letters, and combinations in digits can be solved by using backtracking.

For lab 2, you are being asked to solve a “combination” problem:

`{}` is considered as a ***well-formed*** pair of braces. Given `n` pairs of braces, write a function that generate all combinations of well-formed braces.

## Constraints

---

- `1 ≤ n ≤ 8`

## Examples

---

```go
Input: n = 1
Output: ["{}"]
```

```go
Input: n = 2
Output: ["{{}}", "{}{}"]
```

```go
Input: n = 3
Output: ["{{{}}}", "{{}{}}", "{{}}{}", "{}{{}}", "{}{}{}"]
```

P.S. The content in the list may in any order

## Requirements

---

- You must submit a single Java file containing the class named **Lab2.** Your class must contain the function named “**generateBraces**” with the following headers:
    
    ```java
    public static List<String> generateBraces(int n)
    ```
    
## Submission Comments

---
- This program uses backtracking, a form of recursion, to identify all possible combinations of properly-configured brackets given an input of n by the user. It uses the java.util.* library to allow the creation of lists and input from the user.
- My main focus when starting the code was figuring out how the function that required recursion (AddBrace) was going to work. I also thought about how I would represent the brackets in my program, which ended up being a -1 for '{' and 1 for '}' in an array. Since I needed to interchange between adding -1 and 1 into the array, I figured that I needed to add the AddBrace function inside the AddBrace function twice. The first recursion it would do was adding a -1 into the array until it was an improper configuration. After that, it would recurse to add 1s until another improper configuration. I then needed to define what an improper configuration was so it could stop the recursion when required. I did this by using functions (isProper, isEqual). If it was determined that the configuration was filled (using isFill function), also assuming that the configuration passed the isProper and isEqual functions, then that final configuration was stored in a list. The program then were to store all the proper configurations into a list, which would then be displayed to the user once finished.
- Runtime Complexity: O(2^n) | Space Complexity: O(n)
- The first difficulty I encountered was trying to find a way to represent the brackets. I came to the conclusion that using -1s and 1s was a better way to represent them rather than the actual brackets themselves. The next difficulty was figuring out how I would check if the bracket configuration was correct. The first part of this was checking how the configuration would be *incorrect*. My solution was that for every bracket added, the function isProper would check if there were more '}'s than '{' in that given configuration, and if that were the case, it would mean that a '}' was not "hugging" another '{'. It would also check at the halfway point of the configuration whether or not there were more '{'s than '}'s and vice versa. If this were to be true, then it'd mean there were too many of that bracket. I then created functions isFilled and isEqual to further determine if the bracket configuration was correct and if it was finally time to add it to the list. Eventually, I came to the conclusion that the functions needed to be in this order: isProper -> isFilled -> isEqual. Only then did the list display all the correct bracket configurations.