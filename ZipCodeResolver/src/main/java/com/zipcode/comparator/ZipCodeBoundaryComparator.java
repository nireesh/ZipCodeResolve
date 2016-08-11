package com.zipcode.comparator;

import java.util.Comparator;

import com.zipcode.bean.Boundary;

/**
 * @author Nireesh Thiruveedula
 * @version 1.0
 * 
 * Class implements Comparator Interface
 *
 */
public class ZipCodeBoundaryComparator implements Comparator<Boundary>{

	
        /* (non-Javadoc)
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         */
        public int compare(Boundary bCurr, Boundary bNext) { 
            return Integer.compare(bCurr.lowerIndex, bNext.lowerIndex);
        }
    
}
