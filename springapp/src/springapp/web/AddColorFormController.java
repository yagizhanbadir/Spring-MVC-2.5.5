package springapp.web;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import springapp.domain.Color;
import springapp.service.ProductManager;

public class AddColorFormController extends SimpleFormController {

	protected final Log logger = LogFactory.getLog(getClass());
	private ProductManager productManager;

	public ModelAndView onSubmit(Object command) throws ServletException {

		Color color = (Color) command;
		
		productManager.addColor(color);

		logger.info("returning from AddColorForm view to " + getSuccessView());

		return new ModelAndView(new RedirectView(getSuccessView()));
	}
	

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	public ProductManager getProductManager() {
		return productManager;
	}

}
