package leetcode;

import java.util.*;

public class MinRectangleArea {

    public int minAreaRect(int[][] points) {
        if(points.length < 4) return 0;
        Map<String, int[]> used = new HashMap<>();

        // Now loop through to get the minimum area.
        int minArea = Integer.MAX_VALUE;
        for(int[] p1 : points) {
            for(String key : used.keySet()) {
                int[] p2 = used.get(key);
                if(used.containsKey(p2[0] + "$" + p1[1]) && used.containsKey(p1[0] + "$" + p2[1])) {
                    int currArea = Math.abs(p2[1] - p1[1]) * Math.abs(p2[0] - p1[0]);
                    minArea = Math.min(currArea, minArea);
                }
            }
            used.put(p1[0] + "$" + p1[1], new int[] {p1[0], p1[1]});
        }
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }

    public static void main(String[] args) {
        int[][] points = {{1,1},{1,3},{3,1},{3,3},{2,2}};
        MinRectangleArea minRectangeArea = new MinRectangleArea();
        int ans = minRectangeArea.minAreaRect(points);
        System.out.println("ans = " + ans);

    }
}

