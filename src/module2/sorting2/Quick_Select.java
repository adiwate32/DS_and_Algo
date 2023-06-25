package module2.sorting2;

public class Quick_Select {
    public static int solve(int[] A, int k) {

        int n = A.length;
        return quick_select(A, 0, n-1, k);
    }

    public static int quick_select(int[] A, int lo, int hi, int K)
    {

        int idx = partitions(A, lo, hi);

        if(idx == K-1)
        {
            return A[idx];
        }
        else if(idx < K)
        {
            quick_select(A, lo, idx-1, K);

        }
        else {
            quick_select(A, idx+1, hi, K);

        }
        return -1;
    }

    public static int partitions(int[] A, int lo, int hi)
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

    public static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args)
    {
        int [] A = new int[]{1, 2, 3, 4, 5, 6};
        int x = solve(A, 2);
        System.out.println(x);
    }
}
