package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Skyline {
	    
	//Created a class called point that has x- co-ordinate, height and if it's the begining or end of building
    class Point implements Comparable<Point> {
        int x, height;
        boolean isStart;
        
        public Point(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }
        
        /**Compare logic
        0. Compare that both X-axis value is not same and return the smaller. ELSE
        1. If both are start get the building with highest height first.
        2. If both are end get the building with lowest height first.
        3. If one is start and other is end get the building with highest height.
        **/
        @Override
        public int compareTo(Point p) {
            if(this.x != p.x) return (this.x - p.x);
            else {
                return (this.isStart ? -this.height : this.height) - (p.isStart ? -p.height : p.height);
            }
        }
    }
    
    public List<int[]> getSkyline(int[][] buildings) {
        Point[] points = new Point[buildings.length*2];
        List<int[]>result = new ArrayList<>();
        int i = 0;
        for(int[] building : buildings) {
            Point p1 = new Point(building[0], building[2], true);
            Point p2 = new Point(building[1], building[2], false);
            points[i++] = p1;
            points[i++] = p2;
        }
        Arrays.sort(points);
        //Map contains Key as height, and value as Frequency of the height.
        TreeMap<Integer, Integer>map = new TreeMap<>();
        map.put(0, 1);  //Sentinel value
        int prevMax = 0;
        for(Point p : points) {
            if(p.isStart) {
                map.compute(p.height, (k, v) -> {
                    if(v == null) return 1;
                    else return (v + 1);
                });
            } else {
                map.compute(p.height, (k, v) -> {
                   if(v == 1) return null;
                    else return (v - 1);
                });
            }
            //lastKey() method gives the last max key in the treemap.
            int currMax = map.lastKey().intValue();
            if(currMax != prevMax) {
                result.add(new int[]{ p.x, currMax });
                prevMax = currMax;
            }
        }
        return result;
    }
}
