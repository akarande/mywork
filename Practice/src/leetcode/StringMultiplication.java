package leetcode;

public class StringMultiplication {

    String multiply(String s1, String s2) {
        if(s1 == null || s2 == null) return "0";
        int n1 = s1.length(), n2 = s2.length();
        int[] res = new int[s1.length() + s2.length()];
        for(int i = n1 - 1; i >= 0; i--) {
            for(int j = n2 - 1; j >= 0; j--) {
                int idx = n1 - i - 1 + n2 - j - 1;
                res[idx] += (Character.getNumericValue(s1.charAt(i)) * Character.getNumericValue(s2.charAt(j)));
                res[idx + 1] += res[idx] / 10;
                res[idx] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < res.length - 1; i++) {
            sb.append(res[i]);
        }
        sb = sb.reverse();
        String result = sb.toString();
        while(result.charAt(0) == '0') result = result.substring(1);
        return result;
    }

    public static void main(String[] args) {
        String n1 = "123", n2 = "456";
        StringMultiplication stringMultiplication = new StringMultiplication();
        String multiply = stringMultiplication.multiply(n1, n2);
        System.out.println("multiply = " + multiply);
    }
}
