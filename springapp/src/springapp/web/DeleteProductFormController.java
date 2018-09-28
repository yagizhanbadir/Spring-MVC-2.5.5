package springapp.web;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import springapp.domain.Product;
import springapp.service.ProductManager;

public class DeleteProductFormController extends SimpleFormController {

	protected final Log logger = LogFactory.getLog(getClass());
	private ProductManager productManager;

	public ModelAndView onSubmit(Object command) throws ServletException {

		
		Product product = (Product) command;
		productManager.deleteProduct(product.getId());

		logger.info("returning from DeleteProductForm view to " + getSuccessView());

		return new ModelAndView(new RedirectView(getSuccessView()));
	}

	
	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	public ProductManager getProductManager() {
		return productManager;
	}
}
