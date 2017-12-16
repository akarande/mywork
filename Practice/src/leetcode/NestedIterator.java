package leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> ss = new Stack<>();
    
    public interface NestedInteger {
    	      public boolean isInteger();
    	      public Integer getInteger();
    	      public List<NestedInteger> getList();
    }
    
    
    public NestedIterator(List<NestedInteger> nestedList) {
        int i = nestedList.size()-1;
        while(i >= 0)
            ss.push(nestedList.get(i--));
    }

    @Override
    public Integer next() {
        return ss.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!ss.isEmpty()) {
            NestedInteger curr = ss.peek();
            if(curr.isInteger()) {
                return true;
            }
            ss.pop();
            List<NestedInteger>currList = curr.getList();
            int j = currList.size()-1;
            while(j >= 0) {
                ss.push(currList.get(j--));
            }
        }
        return false;
    }
}