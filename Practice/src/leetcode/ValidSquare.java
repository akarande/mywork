package leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ValidSquare {

	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer>set = new HashSet<>();
        set.add(distance(p1, p2));
        set.add(distance(p1, p3));
        set.add(distance(p1, p4));
        set.add(distance(p2, p3));
        set.add(distance(p2, p4));
        set.add(distance(p3, p4));
        if(set.size() != 2) return false;
        //System.out.println(set);
        int a[] = getArray(set);
        if(a.length == 2 && a[0]+a[0] == a[1] || a[1]+a[1] == a[0]) return true;
        return false;
    }
    
    int distance(int[] p1, int[] p2) {
        return ((p1[1] - p2[1]) * (p1[1] - p2[1])  + (p1[0] - p2[0]) * (p1[0] - p2[0]));
    }
    
    int[] getArray(Set<Integer> a) {
        int ans[] = new int[a.size()];
        int k = 0;
        Iterator<Integer> iter = a.iterator();
        while(iter.hasNext()) {
            ans[k++] = iter.next();
        }
        return ans;
    }
    
    public static void main(String arg[]) {
    	ValidSquare vs = new ValidSquare();
    	int[] p1 = {0, 0}, p2 = {1, 0}, p3 = {1, 1}, p4 = {0, 1};
    	System.out.println(vs.validSquare(p1, p2, p3, p4));
    }
}
