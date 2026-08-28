import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Step 2: create a list to store merged intervals
        List<int[]> merged = new ArrayList<>();

        // Step 3: iterate through intervals
        for (int[] current : intervals) {
            // if merged list is empty OR no overlap
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < current[0]) {
                merged.add(current); // just add current interval
            } else {
                // overlap → merge by updating the end
                merged.get(merged.size() - 1)[1] = Math.max(
                    merged.get(merged.size() - 1)[1],
                    current[1]
                );
            }
        }

        // Step 4: convert list to array and return
        return merged.toArray(new int[merged.size()][]);
    }
}