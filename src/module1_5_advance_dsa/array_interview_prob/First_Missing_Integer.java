package module1_5_advance_dsa.array_interview_prob;

/**
 Given an unsorted integer array, A of size N. Find the first missing positive integer.

 Note: Your algorithm should run in O(n) time and use constant space.

 Problem Constraints
 1 <= N <= 1000000
 -109 <= A[i] <= 109

 Input Format
 First argument is an integer array A.

 Output Format
 Return an integer denoting the first missing positive integer.

 Example Input
 Input 1:
 [1, 2, 0]
 Input 2:
 [3, 4, -1, 1]
 Input 3:
 [-8, -7, -6]

 Example Output
 Output 1:
 3
 Output 2:
 2
 Output 3:
 1

 Example Explanation
 Explanation 1:

 A = [1, 2, 0]
 First positive integer missing from the array is 3.
 */
public class First_Missing_Integer {
    public int firstMissingPositive(int[] A) {

        int n = A.length;

        int i = 0;

        while(i < n)
        {
            if(A[i] >= 1 && A[i] <= n)
            {
                int curr_idx = A[i] - 1;
                if(A[curr_idx] != A[i])
                {
                    swap(i, curr_idx, A);
                }
                else
                {
                    i++ ;
                }
            }
            else{
                i++ ;
            }
        }

        for(int j=0; j<n; j++)
        {
            if(A[j] != (j+1))
            {
                return j + 1;
            }
        }
        return n + 1;
    }

    public static void swap(int i, int j, int[] arr)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
