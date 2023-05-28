package module1_5_advance_dsa.array_interview_prob;
import java.util.ArrayList;

/**
 Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Problem Constraints
 0 <= |intervals| <= 105

 Input Format
 First argument is the vector of intervals
 second argument is the new interval to be merged

 Output Format
 Return the vector of intervals after merging

 Example Input  1:
 Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
 Input 2:
 Given intervals [1, 3], [6, 9] insert and merge [2, 6] .

 Example Output
 Output 1:
 [ [1, 5], [6, 9] ]
 Output 2:
 [ [1, 9] ]

 Example Explanation
 Explanation 1:
 (2,5) does not completely merge the given intervals
 Explanation 2:
 (2,6) completely merges the given intervals
 */
public class Merge_Intervals {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> ans = new ArrayList<>();

        for(Interval i: intervals)
        {
            if(newInterval.end < i.start)
            {
                ans.add(newInterval);
                newInterval = i;
            }

            else if(i.end < newInterval.start)
            {
                ans.add(i);
            }

            else
            {
                newInterval.start = Math.min(newInterval.start, i.start);
                newInterval.end = Math.max(newInterval.end, i.end);
            }
        }
        ans.add(newInterval);
        return ans;
    }
}
