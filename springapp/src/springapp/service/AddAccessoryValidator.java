package springapp.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import springapp.domain.Accessory;

public class AddAccessoryValidator implements Validator {

	protected final Log logger = LogFactory.getLog(getClass());

	public boolean supports(@SuppressWarnings("rawtypes") Class clazz) {
		return Accessory.class.equals(clazz);

	}

	public void validate(Object obj, Errors errors) {
		Accessory accessory = (Accessory) obj;

		if (accessory.equals("")) {
			errors.rejectValue("name", "error.not-specified-value", null,
					"Value required.");
		}

		else {
			if (accessory.getAccessoryName().trim().equals("")) {
				errors.rejectValue("accessoryName", "error.not-specified-name",
						null, "Value required.");

			} else if (accessory.getAccessoryDescription().equals("")) {
				errors.rejectValue("accessoryDescription",
						"error.not-specified-colorcode1", null,
						"Value required.");

			}
		}
	}
}
