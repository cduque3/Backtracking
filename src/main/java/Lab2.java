/**
 * Lab 02 - Backtracking
 * @author Carlo Duque
 */
import java.util.*;

public class Lab2 {
    /*
     * Note: -1's and 1's are used to represent the '{' and '}' brackets 
     * respectively.
    */

    /* 
     * Calculates the sum of the array with its current values.
     * It is used for error handling as seen below in certain functions.
     * *
     * @param array: holds brackets of the given array
     * @param n: length of array
     * @return sum: the total sum of the array values
    */
    public static int sum(int[] array, int n) {
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += array[i];
        }

        return sum; 
    }
    
    /* 
     * Checks if the current configuration of the array
     * meets the requirements of a proper bracket configuration.
     * *
     * @param array: holds brackets of the given array
     * @param n: length of the array
     * @return bool: true = proper configuration, false = improper configuration
    */
    public static boolean isProper(int array[], int n) {
  
        /*
        * Monitors whether a bracket exceeds half the length of 2 * n
        * If so, this means there is too many of that bracket
        */
        if (sum(array, 2 * n) > n || sum(array, 2 * n) < -n){
            return false;
        }

        /* 
        * Monitors whether the current bracket configuration has more '}' than '{'
        * If so, this means that a '}' is not "hugging" another '{'
        */
        for(int i = 0; i < 2 * n; i++) {
            if(sum(array, i) >= 1) {
                return false;
            }
        }

        return true;
    }

    /*
     * Checks whether the current result is completely filled with brackets
     * *
     * @param array: holds brackets of given array
     * @param n: length of array
     * @return bool: true = array is filled with all brackets, false = array is not filled
    */
    public static boolean isFilled(int array[], int n) {

        if(array[(2 * n) - 1] != 0){
            return true;
        }

        return false;
    }

    /*
     * Checks whether the number of '{' brackets in the final product is equal 
     * to the number of '}' brackets. 
     * *
     * @param array: holds brackets of given array
     * @param n: length of array
     * @return bool: true = equal brackets, false = either too many '{' brackets  
     * or '}' brackets
    */
    public static boolean isEqual(int array[], int n) {

        if(sum(array, 2 * n ) != 0) {
            return false;
        }
        return true;
    }

    /*
     * Converts the -1's and 1's in the array to '{' and '}' respectively.
     * *
     * @param array: holds brackets of given array
     * @param n: length of array
     * @return result: final bracket configuration
    */
    public static String getResult(int array[], int n) 
    {

        String result = "";

        for(int i = 0; i < (2 * n); i++) {
            
            if(array[i] == -1) {
                result += "{";
            }
            if(array[i] == 1) {
                result += "}";
            }
        }
    
        return result;
    }

    /*
     * The recursive function to add brackets to the current configuration.
     * *
     * @param bracket: the '{' or '}' bracket to be added to the array
     * @param pos: position in the array to add a bracket
     * @param array: holds brackets of given array
     * @param n: length of array
     * @param list: holds all bracket configurations
     * @return: no return value, merely adds brackets to array + final configurations to list
    */
    public static void addBrace(int bracket, int pos, int array[], int n, List<String> list) {

        /*
         * In the current position, add the bracket passed into the function.
         * -1 signifies '{' and '1' signifies '}'
        */
        array[pos] = bracket;

        /*
         * Checks if the current bracket configuration is correct. If not, reset the current position 
         * and move on to the next bracket.
        */
        if(isProper(array, n)) {
            
            //Checks if the array is filled, move on to see if the final configuration is correct.
            if(isFilled(array, n)) {

                /*
                 * Checks if the final configuration has an equal number of '{' and '}' brackets
                 * If not move on to the next bracket.
                */ 
                if(isEqual(array, n)) {
                    
                    //The final configuration has checked out, add it to the list.
                    list.add(getResult(array,n)); }

            }
            else { 

                
                //Recurse to add a '{' bracket to the current configuration
                addBrace(-1, pos + 1, array, n, list);

                //Recurse to add a '}' bracket to the current configuration
                addBrace(1, pos + 1, array, n, list); 
            }
        }

        //Resets bracket if it is an improper configuration.
        array[pos] = 0;

    } 

    /*
     * The starting function to generate bracket configurations of n * 2 length.
     * *
     * @param n: Bracket length that the user has inputted.
     * @return list: all the bracket configurations
    */
    public static List<String> generateBrackets(int n) {
        
        /* 
         * Initialize list to hold all properly-configured bracket configurations,
         * array to hold each configuration, and set the starting position of the array.
        */
        List<String> list = new ArrayList<String>(); 
        int[] array = new int[ n * 2];
        int pos = 0;

        //Starts bracket configuration with '{', recurses to add more brackets
        addBrace(-1, pos, array, n, list);

        //Returns the final list of bracket configurations
        return list;

    }

    public static void main(String[] args) {

        //Initialize the list and put all bracket configurations in it
        List<String> solution = generateBrackets(5);

        //Print out all proper bracket configurations
        System.out.println(Arrays.toString(solution.toArray()));
    }
}
