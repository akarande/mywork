package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

	class Interval {
		int start;
		int end;
		public Interval() {start = 0; end = 0;}
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> ans = new ArrayList<>();
		int n = intervals.size();
        int i = 0;
		while(i < n && intervals.get(i).end < newInterval.start) {	//Put all smaller ones outside the range
            ans.add(intervals.get(i));
            i++;
        }
        while(i < n && intervals.get(i).start <= newInterval.end) {	//Now changed the ones that fall in range take min and max from the intervals or the newInterval
            newInterval = new Interval(
                Math.min(intervals.get(i).start, newInterval.start),
                Math.max(intervals.get(i).end, newInterval.end));
            i++;
        }
        ans.add(newInterval);
        while(i < n) ans.add(intervals.get(i++));	//Don't forget to add the ones greater than the range
		return ans;
	}
	
	public static void main(String arg[]) {
		List<Interval>arrList = new ArrayList<>();
		MergeIntervals mi = new MergeIntervals();
		/*arrList.add(mi.new Interval(1,3));
		arrList.add(mi.new Interval(6,9));*/
		
		
		/*arrList.add(mi.new Interval(1,2));
		arrList.add(mi.new Interval(3,5));
		arrList.add(mi.new Interval(6,7));
		arrList.add(mi.new Interval(8,10));
		arrList.add(mi.new Interval(12,16));*/
		arrList.add(mi.new Interval(1, 5));
		//arrList.add(mi.new Interval(6,9));
		
		for(Interval interval : mi.insert(arrList, mi.new Interval(2,3))) {
			System.out.println("[" + interval.start + ", " + interval.end + "]");
		}
		
	}
}
