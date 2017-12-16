package leetcode;

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {

    Integer topValue;
    Iterator<Integer> itr;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    itr = iterator;
        if(itr.hasNext()) {
            topValue = itr.next();
        }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return topValue;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer curr = topValue;
        if(itr.hasNext()) {
            topValue = itr.next();
        } else {
            topValue = null;
        }
        return curr;
	}

	@Override
	public boolean hasNext() {
	    return !(topValue == null);
	}
}