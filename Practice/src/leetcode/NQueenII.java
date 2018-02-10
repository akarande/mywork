package leetcode;

/**
 * NQueen problem counting all unique solutions
 * @author akarande
 *
 */
public class NQueenII {

	int count = 0;
    public int totalNQueens(int n) {
        boolean c[] = new boolean[n]; //Col |
        boolean d1[] = new boolean[2*n]; //Diag1 \
        boolean d2[] = new boolean[2*n]; //Diag2 /
        solve(n, 0, c, d1, d2);
        return count;
    }
    
    void solve(int n, int row, boolean[] c, boolean[] d1, boolean[] d2) {
        if(n == row) count++;
        for(int col = 0; col < n; col++) {
            int diag1 = col - row + n; //Add n so we get a positive index
            int diag2 = col + row;
            if(c[col] || d1[diag1] || d2[diag2]) continue;
            
            c[col] = true; d1[diag1] = true; d2[diag2] = true;
            solve(n, row + 1, c, d1, d2);
            c[col] = false; d1[diag1] = false; d2[diag2] = false;
        }
    }
    
    public static void main(String arg[]) {
    	NQueenII nq = new NQueenII();
    	int n = 8;
    	System.out.println(nq.totalNQueens(n));
    }
}
