package module2.sorting3;

import java.util.Arrays;
import java.util.Comparator;

/**
 Given an array A of non-negative integers, arrange them such that they form the largest number.
 Note: The result may be very large, so you need to return a string instead of an integer.

 Problem Constraints
 1 <= len(A) <= 100000
 0 <= A[i] <= 2*109

 Input Format
 The first argument is an array of integers.

 Output Format
 Return a string representing the largest number.

 Example Input
 Input 1:
 A = [3, 30, 34, 5, 9]
 Input 2:
 A = [2, 3, 9, 0]

 Example Output  1:
 "9534330"
 Output 2:
 "9320"

 Example Explanation  1:
 Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
 Explanation 2:
 Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
 */

public class Largest_Number {
    public String largestNumber(final int[] A) {
        //we need to copy the elements to another array because its final we can't modifiy it.
        Integer arr[]=new Integer[A.length];
        for(int i=0;i<A.length;i++){
            arr[i]=A[i];
        }
        //create a new comparator to compare the elements
        Arrays.sort(arr,new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                String x =String.valueOf(a)+String.valueOf(b);
                String y =String.valueOf(b)+String.valueOf(a);
                return y.compareTo(x);
            }
        });
        //edge case to check
        if(arr[0]==0){
            return "0";
        }
        //we need to return it as a string so create a StringBuilder because we need to convert Integer to String.
        StringBuilder str=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            str.append(arr[i]);
        }
        return str.toString();
    }
}
