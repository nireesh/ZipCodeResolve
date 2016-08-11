package com.zipcode.delegate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.zipcode.bean.Boundary;
import com.zipcode.comparator.ZipCodeBoundaryComparator;


/**
 * @author Nireesh Thruveedula
 * @version 1.0
 * Class contains operations to join the overlapped zip code ranges. 
 */
public class ZipCodeResolverDelegate {

    /**
     * Method to check for the zipcode ranges that overlap and join basing on lower and upper bounds.
     * @param bounds List<Boundary>
     * @return List<Boundary>
     */
    public List<Boundary> joinOverlaps(List<Boundary> bounds){
    	// if there is only one zip code range return same 
        if (bounds.size() < 2){
            return bounds;
        }
        // Sort collections basing on the lower bound index in set.
        Collections.sort(bounds,new ZipCodeBoundaryComparator());
        //create a temp list to hold the result values
        List<Boundary> finalList = new ArrayList<Boundary>();
        finalList.add(bounds.get(0));
        //loop through the range of zipcodes and compare against the finalList last value for every iteration. 
        //If the last item in final list satisfies the below condition ,remove or insert accordingly
        for (int i = 1; i < bounds.size(); i++){
            Boundary lastElement = finalList.get(finalList.size() - 1);
            finalList.remove(finalList.size() - 1);
            List<Boundary> zipCodebounds = join(lastElement, bounds.get(i));
            finalList.addAll(zipCodebounds);           
        }
        return finalList;
 
    }
    /**
     * Method to compare each element in list and join the range.
     * @param bCurr <Boundary>
     * @param bNext <Boundary>
     * @return List<Boundary>
     */
    private List<Boundary> join(Boundary bCurr, Boundary bNext){
    	// condition for no overlap
        if (bCurr.upperIndex < bNext.lowerIndex){
            return Arrays.asList(bCurr, bNext);
        } else{
        	// condition for overlap
            Boundary merged = new Boundary(bCurr.lowerIndex, Math.max(bCurr.upperIndex, bNext.upperIndex));
            return Arrays.asList(merged);
        }
    }
     
}