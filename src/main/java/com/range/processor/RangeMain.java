package com.range.processor;

import java.util.List;
import java.util.Scanner;

public class RangeMain {
	
	public static void main(String[] args) {
		RangeMain range = new RangeMain();
		System.out.println("output ::" +range.rangeOutput("[94133,94133] [94200,94299] [94226,94399]"));
		System.out.println("output ::" +range.rangeOutput("[11111,11111] [11111,11111] [11111,11111]"));
		System.out.println("output ::" +range.rangeOutput("[94133,94133] [94200,94299] [94600,94699]"));

	}

	public String rangeOutput(String rangeData) {		
		String result="";
		RangeValidation rangeValidation = new RangeValidation();
		/*validation check */
		List<Range> rangeList = rangeValidation.validateDataAndReturnList(rangeData);
		RangeProcessor rangeProcessor = new RangeProcessor();
		/* sorting */
		List<Range> sortedRangeList = rangeProcessor.sortRangeListWithLowerRange(rangeList);
		/* final output */
		List<Range> outputRangeList = rangeProcessor.rangeOutput(sortedRangeList);
		for (Range range : outputRangeList) {
			result = result + "[" + range.getLowerRange() + "," + range.getUpperRange() + "] ";			
		}
		return result;

	}
}
