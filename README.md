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
    
