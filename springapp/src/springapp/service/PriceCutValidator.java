package springapp.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PriceCutValidator  implements Validator {

		private int DEFAULT_MIN_PERCENTAGE = 0;
	    private int DEFAULT_MAX_PERCENTAGE = 50;
	    private int minPercentage = DEFAULT_MIN_PERCENTAGE;
	    private int maxPercentage = DEFAULT_MAX_PERCENTAGE;

	    /** Logger for this class and subclasses */
	    protected final Log logger = LogFactory.getLog(getClass());

	    public boolean supports(@SuppressWarnings("rawtypes") Class clazz) {
	        return PriceCut.class.equals(clazz);
	    }

	    public void validate(Object obj, Errors errors) {
	        PriceCut pc = (PriceCut) obj;
	        if (pc == null) {
	            errors.rejectValue("percentage", "error.not-specified", null, "Value required.");
	        }
	        else {
	            logger.info("Validating with " + pc + ": " + pc.getPercentage());
	            if (pc.getPercentage() > maxPercentage) {
	                errors.rejectValue("percentage", "error.too-high-cut",
	                    new Object[] {new Integer(maxPercentage)}, "Value too high.");
	            }
	            if (pc.getPercentage() <= minPercentage) {
	                errors.rejectValue("percentage", "error.too-low",
	                    new Object[] {new Integer(minPercentage)}, "Value too low.");
	            }
	        }
	    }

	    public void setMinPercentage(int i) {
	        minPercentage = i;
	    }

	    public int getMinPercentage() {
	        return minPercentage;
	    }

	    public void setMaxPercentage(int i) {
	        maxPercentage = i;
	    }

	    public int getMaxPercentage() {
	        return maxPercentage;
	    }

}
