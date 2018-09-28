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

import springapp.domain.Product;
import springapp.service.UpdateStock;
import springapp.service.ProductManager;

public class UpdateStockFormController extends SimpleFormController {

	protected final Log logger = LogFactory.getLog(getClass());
	private ProductManager productManager;

	public ModelAndView onSubmit(Object command) throws ServletException {

		UpdateStock productStock = (UpdateStock) command;
		productManager.updateStock(productStock);
		logger.info("returning from UpdateStockForm view to "
				+ getSuccessView());

		return new ModelAndView(new RedirectView(getSuccessView()));
	}

	protected Map<String, List<Product>> referenceData(HttpServletRequest request) throws Exception {

		Map<String, List<Product>> referenceData = new HashMap<String, List<Product>>();
		List<Product> product = this.productManager.getProducts();
		referenceData.put("modelList", product);
		return referenceData;
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	public ProductManager getProductManager() {
		return productManager;
	}
}

// protected Object formBackingObject(HttpServletRequest request)
// throws ServletException {
// UpdateStock upStock = new UpdateStock();
// upStock.setNewStock(100);
// return upStock;
// }

// public ModelAndView handleRequest(HttpServletRequest request,
// HttpServletResponse response) throws ServletException, IOException {
//
// Map<String, Object> myModel = new HashMap<String, Object>();
// myModel.put("products", this.productManager.getProducts());
// logger.info("returning handleRequest");
// logger.info("Model: " + myModel);
// return new ModelAndView("updateproduct", "model", myModel);
// }

// @Override
// public Map<String, Object> referenceData(HttpServletRequest request) {
// List<Product> product = this.productManager.getProducts();
// Map<String, Object> model = new HashMap<String, Object>();
// model.put("products", product);
// logger.info("Model: " + model);
// logger.info("returning referenceData");
//
// return model;
// }

// @Override
// protected Object formBackingObject(HttpServletRequest request)
// throws Exception {
// UpdateStock upstock = new UpdateStock();
// List<Product> product = this.productManager.getProducts();
// Map<String, Object> model = new HashMap<String, Object>();
// model.put("products", product);
// upstock.setMyModel(model);
// return upstock;
// }


//@Override
//protected Object formBackingObject(HttpServletRequest request)
//	throws Exception {
//	
//	UpdateStock upStock = new UpdateStock();		
//	upStock.setProductName("Seciniz");
//	return upStock;
//	
//}