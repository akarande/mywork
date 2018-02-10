package leetcode;

public class LongestAbsolutePath {

	public int lengthLongestPath(String input) {
        if(input == null || input.length() == 0) return 0;
        String str[] = input.split("\n");
        int n = str.length;
        int tab[] = new int[n];
        
        //Get the tab count for each path in str
        for(int i = 0; i < n; i++) {
            int k = 0;
            int tabs = 0;
            while(k < n && str[i].charAt(k++) == '\t') tabs++;
            str[i] = str[i].substring(k-1);
            tab[i] = tabs;
        }
        
        //Calcuate the parent dir for each path
        int parent[] = new int[n];
        for(int i = 0; i < n; i++) {
            //If it's the first element then it has no parent
            if(tab[i] == 0) {
                parent[i] = -1;
            } else {
                int j = i - 1;
                while(j >= 0) {
                    //Find the parent for ith dir/file
                    if(tab[i]  == tab[j] + 1) {
                        parent[i] = j;
                        break;
                    }
                    j--;
                }
            }
        }
        
        //Form the full path and store the maximum
        String[] fullPath = new String[n];
        int mx = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            //This is the base directory
            if(parent[i] == -1) {
                fullPath[i] = str[i];
            } else {
                fullPath[i] = fullPath[parent[i]] + "/" + str[i];
            }
            //Only check for candidates with a file.
            if(fullPath[i].contains(".")) {
                mx = Math.max(mx, fullPath[i].length());
            }
        }
        if(mx == Integer.MIN_VALUE) return 0;
        return mx;
    }
	
	public static void main(String arg[]) {
		LongestAbsolutePath lap = new LongestAbsolutePath();
		String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		System.out.println(lap.lengthLongestPath(input));
	}
}
