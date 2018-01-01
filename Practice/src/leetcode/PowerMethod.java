package leetcode;

public class PowerMethod {

    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n < 0) {
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
    
    public static void main(String arg[]) {
    	PowerMethod pm = new PowerMethod();
    	System.out.println(pm.myPow(2.00000, -2147483648));
    }
}
