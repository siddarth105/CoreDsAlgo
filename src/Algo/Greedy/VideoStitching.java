package Algo.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// QN :: https://leetcode.com/problems/video-stitching/description/?envType=problem-list-v2&envId=dynamic-programming&difficulty=MEDIUM
public class VideoStitching {

    public static class Intervals {
        int start;
        int end;

        public Intervals(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int totalSegmentsRequired(int[][] input) {

        List<Intervals> intervals = new ArrayList<>(); List<Intervals> ans = new ArrayList<>();
        for (int i=0; i < input.length; i++) {
            Intervals interval = new Intervals(input[i][0], input[i][1]);
            intervals.add(interval);
        }
        Collections.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));
        int total_start = intervals.get(0).start; int total_end = intervals.get(0).end;

        for (Intervals interval : intervals) {
            if (interval.end > total_end) {
                ans.add(interval);
                total_end = interval.end;
            }
        }
        return ans.size();
    }

    public static void main (String[] args) {
        int[][] input = new int[][] {};
        totalSegmentsRequired(input);

    }
}
