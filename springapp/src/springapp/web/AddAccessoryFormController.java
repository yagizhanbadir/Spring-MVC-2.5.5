package springapp.web;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
import springapp.domain.Accessory;
import springapp.service.ProductManager;

public class AddAccessoryFormController extends SimpleFormController {

	protected final Log logger = LogFactory.getLog(getClass());
	private ProductManager productManager;

	public ModelAndView onSubmit(Object command) throws ServletException {

		Accessory accessory = (Accessory) command;
		
		productManager.addAccessory(accessory);

		logger.info("returning from AddAccessoryForm view to " + getSuccessView());

		return new ModelAndView(new RedirectView(getSuccessView()));
	}
	

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	public ProductManager getProductManager() {
		return productManager;
	}
}
