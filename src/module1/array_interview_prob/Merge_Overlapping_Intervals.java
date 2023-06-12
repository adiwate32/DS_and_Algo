package module1.array_interview_prob;

import java.util.ArrayList;
import java.util.Comparator;

/**
 Given a collection of intervals, merge all overlapping intervals.

 Problem Constraints
 1 <= Total number of intervals <= 100000.

 Input Format
 First argument is a list of intervals.

 Output Format
 Return the sorted list of intervals after merging all the overlapping intervals.

 Example Input
 Input 1:
 [1,3],[2,6],[8,10],[15,18]

 Example Output
 Output 1:
 [1,6],[8,10],[15,18]

 Example Explanation
 Explanation 1:
 Merge intervals [1,3] and [2,6] -> [1,6].
 so, the required answer after merging is [1,6],[8,10],[15,18].
 No more overlapping intervals present.
 */
public class Merge_Overlapping_Intervals {
    public static class Interval {
       int start;
       int end;
       Interval() { start = 0; end = 0; }
       Interval(int s, int e) { start = s; end = e; }
   }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        ArrayList<Interval> ans = new ArrayList<>();
        int n = intervals.size();

        intervals.sort(new compare());
        Interval inter = intervals.get(0);


        for(int i=1; i<n; i++)
        {
            Interval curr_inter = intervals.get(i);
            if(inter.end < curr_inter.start)
            {
                ans.add(inter);
                inter = curr_inter;
            }
            else{
                inter.start = Math.min(inter.start, curr_inter.start);
                inter.end = Math.max(inter.end, curr_inter.end);
            }
        }
        ans.add(inter);
        return ans;
    }

    private static class compare implements Comparator<Interval>
    {
        public int compare(Interval inter1, Interval inter2)
        {
            int cmp1 = Integer.compare(inter1.start, inter2.start);

            if(cmp1 !=0)
            {
                return cmp1;
            }

            return Integer.compare(inter1.end, inter2.end);
        }
    }
}
