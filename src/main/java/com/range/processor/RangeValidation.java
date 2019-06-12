package com.range.processor;

import java.util.LinkedList;
import java.util.List;

public class RangeValidation {

	public List<Range> validateDataAndReturnList(String ranges) {
		String[] rangeArray = ranges.split(" ");
		List<Range> rangeList = new LinkedList<Range>();
		for (int i = 0; i < rangeArray.length; i++) {
			rangeList.add(validate(rangeArray[i].replaceAll("\\[|\\]", "").split(",")));
		}
		return rangeList;
	}

	public boolean checkLength(int range) {
		if ((int) (Math.log10(range) + 1) != 5)
			return false;
		return true;
	}

	public Range validate(String[] rangeArray) {
		if (rangeArray.length != 2)
			throw new IllegalArgumentException("Range must have lower and upper range data");
		int lowerRange = Integer.parseInt(rangeArray[0]);
		int upperRange = Integer.parseInt(rangeArray[1]);

		if (!checkLength(lowerRange) && !checkLength(upperRange))
			throw new IllegalArgumentException(
					"lower Range : " + lowerRange + ": and upper range : " + upperRange + " must be of 5 digits");
		if (lowerRange > upperRange)
			throw new IllegalArgumentException(
					"lower Range : " + lowerRange + ": can't be greater than upper range : " + upperRange);

		Range range = new Range();
		range.setLowerRange(lowerRange);
		range.setUpperRange(upperRange);
		return range;
	}

}
