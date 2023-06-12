package module1.array_interview_prob;

/**
 Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.

 If such arrangement is not possible, it must be rearranged as the lowest possible order, i.e., sorted in ascending order.

 NOTE:
 The replacement must be in-place, do not allocate extra memory.
 DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.

 Problem Constraints
 1 <= N <= 5 * 105
 1 <= A[i] <= 109

 Input Format
 The first and the only argument of input has an array of integers, A.

 Output Format
 Return an array of integers, representing the next permutation of the given array.

 Example Input
 Input 1:
 A = [1, 2, 3]
 Input 2:
 A = [3, 2, 1]

 Example Output
 Output 1:
 [1, 3, 2]
 Output 2:
 [1, 2, 3]

 Example Explanation
 Explanation 1:
 Next permutation of [1, 2, 3] will be [1, 3, 2].
 Explanation 2:
 No arrangement is possible such that the number are arranged into the numerically next greater permutation of numbers.
 So will rearrange it in the lowest possible order.
 */
public class Next_Permutation {
    public int[] nextPermutation(int[] A) {

        int n = A.length;

        int idx = -1;

        for(int i=n-2; i>=0; i--)
        {
            if(A[i] < A[i+1])
            {
                idx = i;
                break;
            }
        }

        if(idx != -1)
        {
            int min_idx = indexOfSmallest(A, idx, n);
            swap(idx, min_idx, A);
            reverse(idx+1, n-1, A);
        }
        else{
            reverse(0, n-1, A);
        }
        return A;

    }
    public static int indexOfSmallest(int[] A, int idx, int n){

        int min_idx = -1;

        for(int i=n-1; i>=idx+1; i--)
        {
            if(A[i] > A[idx])
            {
                if(min_idx == -1)
                {
                    min_idx = i;
                }
                else if(A[i] < A[min_idx])
                {
                    min_idx = i;
                }
            }
        }
        return min_idx;
    }


    public static void swap(int i, int j, int[] A)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void reverse(int s, int e, int[] A)
    {
        while(s < e)
        {
            swap(s, e, A);
            s++;
            e--;
        }
    }
}
