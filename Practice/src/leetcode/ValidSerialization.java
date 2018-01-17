package leetcode;

public class ValidSerialization {

	/*
    public boolean isValidSerialization(String preorder) {
        String nodes[] = preorder.split(",");
        int i = 0, count = 0;
        for(; i < nodes.length; i++) {
            if(nodes[i].equals("#")) {
                if(count == 0) break;
                count--;
            } else {
                count++;
            }
        }
        return count == 0 && i == nodes.length-1 && nodes[i].equals("#");
    }
    */
    
    //By counting the in-degree and out degree
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int degree = 1;
        //For every node subtract 1 for outdegree(i.e. node to parent) 
        //and for every child(not null) add 2 for two outdegree i.e. left and right child
        for(String n : nodes) {
            //if we enter inside there is a node so decrement
            degree--;
            if(degree < 0) return false;
            //Not node is a child add 2
            else if(!n.equals("#")) degree += 2;
        }
        //In the end the degree should be zero
        return degree == 0;
    }
    
    public static void main(String arg[]) {
    	ValidSerialization vs = new ValidSerialization();
    	String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
    	System.out.println(vs.isValidSerialization(preorder));
    }
}
