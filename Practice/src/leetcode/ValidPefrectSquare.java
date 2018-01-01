package leetcode;

public class ValidPefrectSquare {

	public boolean isPerfectSquare(int num) {
        long i = 0;
        for(i = num; i*i > num; i = (i + num/i)/2);
        return i*i == num;
    }
	
	public static void main(String arg[]) {
		ValidPefrectSquare vps = new ValidPefrectSquare();
		int n = 65;
		System.out.println(vps.isPerfectSquare(n));
	}
}
