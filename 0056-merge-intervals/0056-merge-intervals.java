import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort intervals based on starting value
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {

            // If list is empty or intervals do not overlap
            if (list.isEmpty() ||
                list.get(list.size() - 1)[1] < intervals[i][0]) {

                list.add(intervals[i]);
            }

            else {
                // Merge overlapping intervals
                list.get(list.size() - 1)[1] =
                    Math.max(list.get(list.size() - 1)[1], intervals[i][1]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}