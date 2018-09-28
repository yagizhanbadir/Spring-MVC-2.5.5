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

public class UpdateProductFormController extends SimpleFormController {

	protected final Log logger = LogFactory.getLog(getClass());
	private ProductManager productManager;

	public ModelAndView onSubmit(Object command) throws ServletException {

		Product updateProduct = (Product) command;
		productManager.updateProduct(updateProduct);
		logger.info("returning from UpdateStockForm view to "
				+ getSuccessView());

		return new ModelAndView(new RedirectView(getSuccessView()));
	}

	protected Object formBackingObject(HttpServletRequest request)
			throws ServletException {
		int productId = Integer.parseInt(request.getParameter("id"));
		List<Product> product = this.productManager.getProductById(productId);
		Product prod = new Product();
		prod.setName(product.get(0).getName());
		prod.setDescription(product.get(0).getDescription());
		prod.setColor(product.get(0).getColor());
		prod.setWeight(product.get(0).getWeight());
		prod.setPrice(product.get(0).getPrice());
		prod.setStock(product.get(0).getStock());
		
		
		prod.setAccessory(product.get(0).getAccessory());
//		prod.setAccessoryList(product.get(0).getAccessoryList());
		logger.info("formBacking: " + prod);
		return prod;
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
