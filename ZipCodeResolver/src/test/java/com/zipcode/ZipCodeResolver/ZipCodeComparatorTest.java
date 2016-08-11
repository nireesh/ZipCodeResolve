package com.zipcode.ZipCodeResolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.zipcode.bean.Boundary;
import com.zipcode.comparator.ZipCodeBoundaryComparator;

public class ZipCodeComparatorTest {

	/**
	 * TestCase to check the ascending order for zipcode sorting
	 * input [71305, 72000],[61704, 62000],[50266, 50276]
	 * output [50266, 50276],[61704, 62000],[71305, 72000]
	 */
	@Test
	public void testZipCodeLowerBoundSorting() {
		List<Boundary> actual = createTestData();
		Collections.sort(actual,new ZipCodeBoundaryComparator());
		Assert.assertEquals(createExpectedData(), actual);
	}

	/**
	 * Create test data for sorting 
	 * @return List<Boundary>
	 */
	public List<Boundary> createTestData() {

		List<Boundary> bounds = new ArrayList<Boundary>();
		Boundary b1 = new Boundary(71305, 72000);
		Boundary b2 = new Boundary(61704, 62000);
		Boundary b3 = new Boundary(50266, 50276);
		bounds.addAll((Arrays.asList(b1, b2,b3)));
		return bounds;
	}
	
	/**
	 * Create expected data for test case.
	 * @return List<Boundary>
	 * 
	 */
	public List<Boundary> createExpectedData() {

		List<Boundary> bounds = new ArrayList<Boundary>();
		Boundary b1 = new Boundary(50266, 50276);
		Boundary b2 = new Boundary(61704, 62000);
		Boundary b3 = new Boundary(71305, 72000);
		bounds.addAll((Arrays.asList(b1, b2,b3)));
		return bounds;
	}
}
