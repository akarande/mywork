package leetcode;

public class RotateMatrix {

	public void rotate(int[][] matrix) {
        solve(matrix);
    }
    
    void solve(int[][] m) {
        //Transpose
        for(int i = 0; i < m.length; i++) {
            for(int j = i; j < m[i].length; j++) {
                int temp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = temp;
            }
        }
        print(m);
        //Now reverse
        /*for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[i].length/2; j++) {
                int temp = m[i][j];
                m[i][j] = m[i][m[i].length-1-j];
                m[i][m[i].length-1-j] = temp;
            }
        }*/
    }
    
    void print(int[][] m) {
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String arg[]) {
    	RotateMatrix rm = new RotateMatrix();
    	int [][]m = {{1,2,3},{4,5,6},{7,8,9}};
    	rm.rotate(m);
    }
}
