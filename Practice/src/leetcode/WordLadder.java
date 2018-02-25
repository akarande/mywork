package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordLadder {

  public int ladderLength(String beginWord, String endWord, List<String> wordDict) {
     Set<String> queue = new HashSet<String>();
     queue.add(beginWord);
     int distance = 1;
     while (!queue.contains(endWord)) {
         Set<String> temp = new HashSet<String>();
         for (String s : queue) {
             for (int i = 0; i < s.length(); i++) {
                 char[] c = s.toCharArray();
                 for (char k = 'a'; k <= 'z'; k++) {
                     c[i] = k;
                     String word = new String(c);
                     if (wordDict.contains(word)) {
                         temp.add(word);
                         wordDict.remove(word);
                     }
                 }
             }
         }
         distance++;
         if (temp.size() == 0) return 0;
         queue = temp;
     }
     return distance;
  }
  public static void main(String arg[]) {
  	WordLadder wl = new WordLadder();
  	List<String>wordList = new ArrayList<>(Arrays.asList("ted","tex","red","tax","tad","den","rex","pee"));
  	String beginWord = "red", endWord = "tax";
  	System.out.println(wl.ladderLength(beginWord, endWord, wordList));
  }
}
