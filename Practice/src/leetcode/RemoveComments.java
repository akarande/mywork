package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {

	public List<String> removeComments(String[] source) {
        List<String>result = new ArrayList<>();
        boolean started = false;
        StringBuilder sb = new StringBuilder();
        for(String line : source) {
        	for(int i = 0; i < line.length(); i++) {
	            //First check for single-line comment
                if(started) {
                    if(line.charAt(i) == '*' && i < line.length() + 1 && line.charAt(i+1) == '/') {
                        started = false;
                        i++;
                    }
                } else {
                    if(line.charAt(i) == '/' && i < line.length() - 1 && line.charAt(i+1) == '/') {
                        break;
                    } else if (line.charAt(i) == '/' && i < line.length() - 1 && line.charAt(i+1) == '*') {
                        started = true;
                        i++;
                    } else {
                        sb.append(line.charAt(i));
                    }
                }
            }
            //Add the line in the end if length is greater than zero
            if(!started && sb.length() > 0) {
                result.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return result;
    }
	
	public static void main(String arg[]) {
		RemoveComments rc = new RemoveComments();
		String code[] = {"/*Test program */", "int main()", "{ ", 
				"  // variable declaration ", "int a, b, c;", "/* This is a test", 
				"   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
		String[] code2 = {"a/*comment", "line", "more_comment*/b"};
		String[] code3 = {"class test{", "public: ", "   int x = 1;", "   /*double y = 1;*/", "   char c;", "};"};
		for(String s : rc.removeComments(code3)) {
			System.out.println(s);
		}
	}
}
