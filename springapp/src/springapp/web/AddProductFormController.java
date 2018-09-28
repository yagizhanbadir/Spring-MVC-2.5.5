package springapp.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import springapp.domain.Accessory;
import springapp.domain.Color;
import springapp.domain.Product;
import springapp.service.ProductManager;

public class AddProductFormController extends SimpleFormController {

	protected final Log logger = LogFactory.getLog(getClass());
	private ProductManager productManager;

	public ModelAndView onSubmit(Object command) throws ServletException {

		Product product = (Product) command;
		
		productManager.addProduct(product);

		logger.info("returning from AddProductForm view to " + getSuccessView());

		return new ModelAndView(new RedirectView(getSuccessView()));
	}
	
	protected Object formBackingObject(HttpServletRequest request)
			throws ServletException {

		Product production = new Product();
		
		Color color = new Color();
		Accessory accessory = new Accessory();
		production.setAccessory(accessory);
//		List<Accessory> accessoryy = new ArrayList<Accessory>();
//		accessoryy.add(accessory);
//		production.setAccessoryList(accessoryy);
		
		production.setColor(color);
//		prod.setColor(product.get(0).getColor());
		return production;
	}
	
	protected Map<Object, Object> referenceData(HttpServletRequest request)
			throws Exception {
		Map<Object, Object> referenceData = new HashMap<Object, Object>();
		List<Color> colors = this.productManager.getColors();
		List<Accessory> accessory = this.productManager.getAccessorys();
		referenceData.put("modelAccess", accessory);
		referenceData.put("modelList", colors);
		return referenceData;
	}


	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	public ProductManager getProductManager() {
		return productManager;
	}
}
