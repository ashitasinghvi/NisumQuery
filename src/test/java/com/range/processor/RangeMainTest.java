package com.range.processor;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class RangeMainTest extends TestCase {

	public RangeMainTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		TestSuite suite = new TestSuite(RangeMainTest.class);
		return suite;
	}

	public void testCase1() {
		String inputDataSet = "[94133,94133] [94200,94299] [94600,94699]";
		RangeMain main = new RangeMain();
		String result = main.rangeOutput(inputDataSet);
		assertEquals("[94133,94133][94200,94299][94600,94699]", result);
	}

	public void testCase2() {
		String inputDataSet = "[94133,94133] [94200,94299] [94226,94399]";
		RangeMain main = new RangeMain();
		String result = main.rangeOutput(inputDataSet);
		assertEquals("[94133,94133][94200,94399]", result);
	}

	public void testIllegalArgumentException() {
		try {
			String inputDataSet = "[92004,92002] [92003,92004]";
			RangeMain main = new RangeMain();
			String result = main.rangeOutput(inputDataSet);
		} catch (IllegalArgumentException e) {
			assertEquals("IllegalArgumentException", e.getClass().getSimpleName());
		}
	}

	public void testExceptionWhenMoreRanges() {
		try {
			String inputDataSet = "[92004,92002,92003] [92003,92004]";
			RangeMain main = new RangeMain();
			String result = main.rangeOutput(inputDataSet);
		} catch (IllegalArgumentException e) {
			assertEquals("IllegalArgumentException", e.getClass().getSimpleName());
		}
	}

	public void testExceptionMessageWhenLowerRangeIsGreater() {
		try {
			String inputDataSet = "[92004,92002] [92003,92004]";
			RangeMain main = new RangeMain();
			String result = main.rangeOutput(inputDataSet);
		} catch (IllegalArgumentException e) {
			String expectedMessage = "lower Range : 92004: can't be greater than upper range : 92002";
			assertEquals(expectedMessage, e.getMessage());
		}
	}

	public void testExceptionMessageWhenMoreRangeGiven() {
		try {
			String inputDataSet = "[92004,92002,92003] [92003,92004]";
			RangeMain main = new RangeMain();
			String result = main.rangeOutput(inputDataSet);
		} catch (IllegalArgumentException e) {
			String expectedMessage = "Range must have lower and upper range data";
			assertEquals(expectedMessage, e.getMessage());
		}
	}
}
