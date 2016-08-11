package com.zipcode.ZipCodeResolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import com.zipcode.bean.Boundary;
import com.zipcode.delegate.ZipCodeBoundary;

/**
 * 
 * @author Nireesh Thiruveedula
 * @version 1.0
 * 
 */
public class ZipCodeBoundaryTest

{
	/**
	 * Test case to check if the minimum ranges are produced in given ranges.
	 * input zip codes of 10 sets including duplicates, arbitrary order and
	 * overlaps
	 * [50266,52001],[61704,62000],[71305,72000],[52000,52010],[42100,91888
	 * ],[36578,42100],[54123,55000],[90877,91234],[87666,87999],[87666,87999]
	 * output - expected [36578,91888]
	 */
	@org.junit.Test
	public void testOverlapZipCodeRanges() {
		ZipCodeBoundary zB = new ZipCodeBoundary();
		List<Boundary> actual = zB.getZipCodeRanges(createTestData(1));
		Assert.assertEquals(createExpectedData(1).get(0).lowerIndex,
				actual.get(0).lowerIndex);
		Assert.assertEquals(createExpectedData(1).get(0).upperIndex,
				actual.get(0).upperIndex);
	}

	/**
	 * Test case to check if duplicates are eliminated Input
	 * [87666,87999],[87666,87999] output [87666,87999]
	 */
	@org.junit.Test
	public void testRemoveDuplicates() {
		ZipCodeBoundary zB = new ZipCodeBoundary();
		List<Boundary> actual = zB.getZipCodeRanges(createTestData(2));
		Assert.assertEquals(createExpectedData(2).get(0).lowerIndex,
				actual.get(0).lowerIndex);
		Assert.assertEquals(createExpectedData(2).get(0).upperIndex,
				actual.get(0).upperIndex);
	}

	/**
	 * Test case to check if duplicates are eliminated Input
	 * [50266,52001],[52001,52010] output [50266,52010]
	 */
	@org.junit.Test
	public void testToCheckTheSameUpperBoundAndLowerBoundInDifferentSets() {
		ZipCodeBoundary zB = new ZipCodeBoundary();
		List<Boundary> actual = zB.getZipCodeRanges(createTestData(3));
		Assert.assertEquals(createExpectedData(3).get(0).lowerIndex,
				actual.get(0).lowerIndex);
		Assert.assertEquals(createExpectedData(3).get(0).upperIndex,
				actual.get(0).upperIndex);
	}

	/**
	 * Method to create test data for input to test case
	 * 
	 * @param i (selection)
	 * @return List<Boundary>
	 */
	public List<Boundary> createTestData(int i) {

		List<Boundary> bounds = new ArrayList<Boundary>();
		Boundary b1 = new Boundary(50266, 52001);
		Boundary b2 = new Boundary(61704, 62000);
		Boundary b3 = new Boundary(71305, 72000);
		Boundary b4 = new Boundary(52001, 52010);
		Boundary b5 = new Boundary(42100, 91888);
		Boundary b6 = new Boundary(36578, 42100);
		Boundary b7 = new Boundary(54123, 55000);
		Boundary b8 = new Boundary(90877, 91234);
		Boundary b9 = new Boundary(87666, 87999);
		Boundary b10 = new Boundary(87666, 87999);
		switch (i) {
		case 1:
			bounds = new ArrayList<Boundary>();
			bounds.addAll(Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10));
			break;
		case 2:
			bounds = new ArrayList<Boundary>();
			bounds.addAll(Arrays.asList(b9, b10));
			break;
		case 3:
			bounds = new ArrayList<Boundary>();
			bounds.addAll(Arrays.asList(b1, b4));
			break;
		default:
			break;
		}
		return bounds;
	}

	/**
	 * Method to create expected test data
	 * 
	 * @param i (selection)
	 * @return List<Boundary>
	 */
	public List<Boundary> createExpectedData(int i) {
		List<Boundary> bounds = new ArrayList<Boundary>();

		Boundary b1 = new Boundary(36578, 91888);
		Boundary b2 = new Boundary(87666, 87999);
		Boundary b3 = new Boundary(50266, 52010);

		switch (i) {
		case 1:
			bounds = new ArrayList<Boundary>();
			bounds.add(b1);
			break;
		case 2:
			bounds = new ArrayList<Boundary>();
			bounds.add(b2);
			break;
		case 3:
			bounds.add(b3);
			break;

		default:
			break;
		}

		return bounds;
	}
}
