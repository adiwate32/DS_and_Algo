package module2.sorting2;

/**
 Given an array of integers A, sort the array into a wave-like array and return it.
 In other words, arrange the elements into a sequence such that
 a1 >= a2 <= a3 >= a4 <= a5.....
 NOTE: If multiple answers are possible, return the lexicographically smallest one.

 Problem Constraints
 1 <= len(A) <= 106
 1 <= A[i] <= 106

 Input Format
 The first argument is an integer array A.

 Output Format
 Return an array arranged in the sequence as described.


 Example Input
 Input 1:
 A = [1, 2, 3, 4]
 Input 2:
 A = [1, 2]

 Example Output
 Output 1:
 [2, 1, 4, 3]
 Output 2:
 [2, 1]

 Example Explanation
 Explanation 1:
 One possible answer : [2, 1, 4, 3]
 Another possible answer : [4, 1, 3, 2]
 First answer is lexicographically smallest. So, return [2, 1, 4, 3].
 Explanation 1:

 Only possible answer is [2, 1].
 */
public class Wave_Array {
    public int[] wave(int[] A) {

        int n = A.length;
        quick_sort(A, 0, n-1);

        int i=0;

        while(i < n)
        {
            if(i+1 < n)
            {
                swap(A, i, i+1);
            }
            i += 2;
        }
        return A;

    }

    public void quick_sort(int[] A, int lo, int hi)
    {
        if(lo >= hi)
        {
            return;
        }
        int idx = partitions(A, lo, hi);
        quick_sort(A, lo, idx-1);
        quick_sort(A, idx+1, hi);
    }

    public int partitions(int[] A, int lo, int hi)
    {
        int i = lo;
        int j = lo;
        int pivot = hi;

        for(j=lo; j<hi; j++)
        {
            if(A[j] < A[pivot])
            {
                swap(A, i, j);
                i += 1;
            }
        }
        swap(A, i, j);
        return i;
    }

    public void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
