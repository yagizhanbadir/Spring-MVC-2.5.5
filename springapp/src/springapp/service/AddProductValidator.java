package springapp.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import springapp.domain.Product;

public class AddProductValidator implements Validator {

	protected final Log logger = LogFactory.getLog(getClass());

	private int DEFAULT_MIN_STOCK = 0;
	private int minStock = DEFAULT_MIN_STOCK;

	private Double DEFAULT_MIN_PRICE = 0.0;
	private Double minPrice = DEFAULT_MIN_PRICE;

	private Double DEFAULT_MIN_WEIGHT = 0.0;
	private Double minWeight = DEFAULT_MIN_WEIGHT;

	public boolean supports(@SuppressWarnings("rawtypes") Class clazz) {
		return Product.class.equals(clazz);

	}

	public void validate(Object obj, Errors errors) {
		Product prod = (Product) obj;

		if (prod.equals("")) {
			errors.rejectValue("name", "error.not-specified-value", null,
					"Value required.");
		}

		else {
			if (prod.getName().equals("")) {
				errors.rejectValue("name", "error.not-specified-name", null,
						"Value required.");
			} else if (prod.getDescription().equals("")) {
				errors.rejectValue("description",
						"error.not-specified-description", null,
						"Value required.");

			} else if (prod.getWeight() == null) {
				errors.rejectValue("weight", "error.not-specified-weight",
						null, "Value required.");
			} else if (prod.getWeight() <= minWeight) {
				errors.rejectValue("weight", "error.too-low-weight",
						new Object[] { new Double(minWeight) },
						"Value too high.");
			} else if (prod.getPrice() == null) {
				errors.rejectValue("price", "error.not-specified-price", null,
						"Value required.");
			}

			else if (prod.getPrice() <= minPrice) {
				errors.rejectValue("price", "error.too-low-price",
						new Object[] { new Double(minPrice) },
						"Value too high.");
			}

			else if (prod.getStock() == 0) {
				errors.rejectValue("stock", "error.not-specified-stock", null,
						"Value required.");
			}

			else if (prod.getStock() <= minStock) {
				errors.rejectValue("stock", "error.too-low-stock",
						new Object[] { new Integer(minStock) },
						"Value too high.");
			}
		}
	}

	public void setMinStock(int i) {

		minStock = i;
	}

	public int getMinStock() {
		return minStock;
	}

	public void setMinPrice(Double i) {

		minPrice = i;
	}

	public Double getMinPrice() {
		return minPrice;
	}

	public void setMinWeight(Double i) {

		minWeight = i;
	}

	public Double getMinWeight() {
		return minWeight;
	}

}
