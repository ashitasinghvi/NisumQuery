package com.range.processor;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RangeProcessor {
	public List<Range> sortRangeListWithLowerRange(List<Range> RangeList) {
		Collections.sort(RangeList, new RangeComparator());
		return RangeList;
	}

	public List<Range> rangeOutput(List<Range> sortedRangeList) {
		List<Range> rangeList = new LinkedList<Range>();
		Range range = null;
		for (Range sortedRange : sortedRangeList) {
			if (range == null)
				range = sortedRange;
			else {
				if (range.getUpperRange() >= sortedRange.getLowerRange()) {
					range.setUpperRange(Math.max(range.getUpperRange(), sortedRange.getUpperRange()));
				} else {
					rangeList.add(range);
					range = sortedRange;
				}
			}
		}
		rangeList.add(range);
		return rangeList;
	}

}
