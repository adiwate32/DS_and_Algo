package module2.sorting1;

/**
 Find the Bth smallest element in given array A .

 NOTE: Users should try to solve it in less than equal to B swaps.

 Problem Constraints
 1 <= |A| <= 100000
 1 <= B <= min(|A|, 500)
 1 <= A[i] <= 109

 Input Format
 The first argument is an integer array A.
 The second argument is integer B.

 Output Format
 Return the Bth smallest element in given array.

 Example Input
 Input 1:
 A = [2, 1, 4, 3, 2]
 B = 3
 Input 2:
 A = [1, 2]
 B = 2

 Example Output
 Output 1:
 2
 Output 2:
 2

 Example Explanation
 Explanation 1:
 3rd element after sorting is 2.
 Explanation 2:
 2nd element after sorting is 2.
 */
public class Kth_Smallest_Element {
    public int kthsmallest(final int[] arr, int B) {
        int n = arr.length;

        for(int i=0; i<n; i++)
        {
            int min_idx = i;
            int min_val = arr[i];

            for(int j=i; j<n; j++)
            {
                if(arr[j] < min_val)
                {
                    min_idx = j;
                    min_val = arr[j];
                }
            }

            swap(arr, i, min_idx);
        }

        return arr[B-1];
    }
    private void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
