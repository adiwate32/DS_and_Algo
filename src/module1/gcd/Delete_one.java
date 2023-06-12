package module1.gcd;

/**
 Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.

 Find the maximum value of GCD.

 Problem Constraints
 2 <= N <= 105
 1 <= A[i] <= 109

 Input Format
 First argument is an integer array A.

 Output Format
 Return an integer denoting the maximum value of GCD.

 Example Input
 Input 1:
 A = [12, 15, 18]
 Input 2:
 A = [5, 15, 30]

 Example Output
 Output 1:
 6
 Output 2:
 15

 Example Explanation
 Explanation 1:
 If you delete 12, gcd will be 3.
 If you delete 15, gcd will be 6.
 If you delete 18, gcd will 3.
 Maximum vallue of gcd is 6.
 Explanation 2:
 If you delete 5, gcd will be 15.
 If you delete 15, gcd will be 5.
 If you delete 30, gcd will be 5.
 */
public class Delete_one {
    public int solve(int[] A) {
        int n = A.length;

        int [] p_gcd = new int[n];
        int [] s_gcd = new int[n];

        p_gcd[0] = A[0];
        s_gcd[n-1] = A[n-1];

        for(int i=1; i<n; i++)
        {
            p_gcd[i] = gcd(A[i], p_gcd[i-1]);
            s_gcd[n-i-1] = gcd(A[n-i-1], s_gcd[n-i]);
        }

        int max = 0;

        for(int i=0; i<n; i++)
        {
            int left = 0;
            if(i!=0)
            {
                left = p_gcd[i-1];
            }
            int right = 0;
            if(i!=n-1)
            {
                right = s_gcd[i+1];
            }
            max = Math.max(max, gcd(left,right));
        }

        return max;
    }

    public int gcd(int a, int b) {

        if(b == 0)
        {
            return a;
        }

        return gcd(b, a % b);
    }
}
