package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalSort {
	    
    public List<Integer> lexicalOrder2(int n) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            answer[i] = new String(String.valueOf(i+1));
        }
        partition(answer, 0, answer.length-1);
        List<Integer>ret = new ArrayList<>();
        for(String s : answer) {
            ret.add(Integer.valueOf(s));
        }
        return ret;
    }
    
    void partition(String[] answer, int low, int high) {
        if(low < high) {
            int mid = (low + high) / 2; 
            partition(answer, low, mid);
            partition(answer, mid+1, high);
            merge(answer, low, mid, high);
        }
    }
    
    void merge(String[] answer, int low, int mid, int high) {
        int i = low;
        int j = mid+1;
        int k = low;
        String[] sorted = new String[answer.length];
        while(i <= mid && j <= high) {
            String curr = new String(answer[i].compareTo(answer[j]) < 0 ? answer[i++] : answer[j++]);
            sorted[k++] = curr;
        }
        
        while(i <= mid) {
            sorted[k++] = answer[i++];
        }
        while(j <= high) {
            sorted[k++] = answer[j++];
        }
        
        for(int x = low; x <= high; x++) {
            answer[x] = sorted[x];
        }
    }
    
    //Efficient Solution
    public List<Integer> lexicalOrder(int n) {
        List<Integer>ret = new ArrayList<>();
        for(int i = 1; i < 10; i++) {
            solve(i, n, ret);
        }
        return ret;
    }
    
    void solve(int curr, int n, List<Integer>result) {
        if(curr > n) return;
        else {
            result.add(curr);
            for(int j = 0; j <= 9; j++) {
                if(10*curr + j > n) return;
                solve(10*curr+j, n, result);
            }
        }
    }
    
    public static void main(String arg[]) {
    	LexicographicalSort ls = new LexicographicalSort();
    	ls.lexicalOrder(13).stream().forEach(e -> System.out.print(e + "\t"));
    }
}
