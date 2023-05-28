package module1_3_advance_dsa.array_1d;

import java.util.List;

/**
 Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

 Problem Constraints
 1 <= |A| <= 100000

 Input Format
 First and only argument is the vector A

 Output Format
 Return one integer, the answer to the question

 Example Input
 Input 1:
 A = [0, 1, 0, 2]
 Input 2:
 A = [1, 2]

 Example Output
 Output 1:
 1
 Output 2:
 0

 Example Explanation  1:
 1 unit is trapped on top of the 3rd element.
 Explanation 2:
 No water is trapped.
 */

public class rainWaterTrapped {

    /**
     Approach by calculating left Max and right Max array
     TC: 0(N)
     SC: O(N)
     */
    public int trap(final List<Integer> A) {

        int n = A.size();
        int [] left = new int[n];
        int [] right = new int[n];

        left[0] = A.get(0);
        right[n-1] = A.get(n-1);

        for(int i=1; i<n; i++)
        {
            left[i] = Math.max(left[i-1], A.get(i));
        }

        for(int i=n-2; i>=0; i--)
        {
            right[i] = Math.max(right[i+1], A.get(i));
        }

        int ans = 0;
        for(int i=0; i<n; i++)
        {
            int min = Math.min(left[i], right[i]);
            ans += (min - A.get(i));

        }

        return ans;
    }

    /**
    Optimised two pointer approach
     SC: O(N)
     TC: O(1)
     */
    public int trap2(final List<Integer> a) {

        int n = a.size();

        int leftMax = 0;
        int rightMax = 0;

        int lp = 0;
        int rp = n-1;

        int ans = 0;

        while(lp < rp)
        {
            if(a.get(lp) <= a.get(rp))
            {
                if(a.get(lp) > leftMax)
                {
                    leftMax = a.get(lp);
                }
                else
                {
                    ans += (leftMax - a.get(lp));
                }
                lp++;
            }
            else{
                if(a.get(rp) > rightMax)
                {
                    rightMax = a.get(rp);
                }
                else
                {
                    ans += (rightMax - a.get(rp));
                }
                rp --;
            }
        }
        return ans;

    }
}
