package com.zipcode.delegate;

import java.util.List;

import com.zipcode.bean.Boundary;

/**
 * 
 * @author Nireesh Thiruveedula
 * @version 1.0
 * 
 * Class ZipCodeBoundary resolves the zip code ranges which are provided in arbitrary order.
 * Operations performed : Sorting of the zip code ranges, finding and merging the overlapped boundaries. 
 * 
 * 
 */
public class ZipCodeBoundary {

	/**
	 * Method to resolve the zip code ranges and merge the overlapped ranges and produce the minimum number of ranges.
	 * @param zipCodeRanges List<Boundary>zipCodeRanges
	 * @return List<Boundary>
	 */
	public List<Boundary> getZipCodeRanges(List<Boundary> zipCodeRanges) {
		ZipCodeResolverDelegate codeResolverDelegate = new ZipCodeResolverDelegate();
		return codeResolverDelegate.joinOverlaps(zipCodeRanges);
	}

}
