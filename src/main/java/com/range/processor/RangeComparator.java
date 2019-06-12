package com.range.processor;

import java.util.Comparator;

public class RangeComparator implements Comparator<Range> {

	public int compare(Range range1, Range range2) {
		if (range1.getLowerRange() > range2.getLowerRange())
			return 1;
		else
			return -1;
	}

}
