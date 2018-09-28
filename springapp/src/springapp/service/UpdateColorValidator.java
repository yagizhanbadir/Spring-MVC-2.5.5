package springapp.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import springapp.domain.Color;

public class UpdateColorValidator implements Validator {

	protected final Log logger = LogFactory.getLog(getClass());

	public boolean supports(@SuppressWarnings("rawtypes") Class clazz) {
		return Color.class.equals(clazz);

	}

	public void validate(Object obj, Errors errors) {
		Color color = (Color) obj;

		if (color.equals("")) {
			errors.rejectValue("name", "error.not-specified-value", null,
					"Value required.");
		} else {
			if (color.getColorName().trim().equals("")) {
				errors.rejectValue("colorName", "error.not-specified-name",
						null, "Value required.");
			} else if (color.getColorName().contains("0") == true) {
				errors.rejectValue("colorName", "error.not-number-colorName",
						null, "Value required.");

			} else if (color.getColorName().contains("1") == true) {
				errors.rejectValue("colorName", "error.not-number-colorName",
						null, "Value required.");

			} else if (color.getColorName().contains("2") == true) {
				errors.rejectValue("colorName", "error.not-number-colorName",
						null, "Value required.");
			} else if (color.getColorName().contains("3") == true) {
				errors.rejectValue("colorName", "error.not-number-colorName",
						null, "Value required.");
			} else if (color.getColorName().contains("4") == true) {
				errors.rejectValue("colorName", "error.not-number-colorName",
						null, "Value required.");
			} else if (color.getColorName().contains("5") == true) {
				errors.rejectValue("colorName", "error.not-number-colorName",
						null, "Value required.");
			} else if (color.getColorName().contains("6") == true) {
				errors.rejectValue("colorName", "error.not-number-colorName",
						null, "Value required.");
			} else if (color.getColorName().contains("7") == true) {
				errors.rejectValue("colorName", "error.not-number-colorName",
						null, "Value required.");
			} else if (color.getColorName().contains("8") == true) {
				errors.rejectValue("colorName", "error.not-number-colorName",
						null, "Value required.");
			} else if (color.getColorName().contains("9") == true) {
				errors.rejectValue("colorName", "error.not-number-colorName",
						null, "Value required.");

			} else if (color.getColorCode().equals("")) {
				errors.rejectValue("colorCode",
						"error.not-specified-colorcode1", null,
						"Value required.");

			} else if (color.getColorCode().startsWith("#") == false) {
				errors.rejectValue("colorCode", "error.not-start-colorcode",
						null, "Value required.");
			} else if (!(color.getColorCode().trim().length() == 7)) {
				errors.rejectValue("colorCode", "error.not-length-colorcode",
						null, "Value required.");
			}
		}
	}
}
