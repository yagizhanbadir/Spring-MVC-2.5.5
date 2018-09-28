package springapp.web;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
import springapp.domain.Accessory;
import springapp.service.ProductManager;

public class UpdateAccessoryFormController extends SimpleFormController {

	protected final Log logger = LogFactory.getLog(getClass());
	private ProductManager productManager;

	public ModelAndView onSubmit(Object command) throws ServletException {

		Accessory accessory =  (Accessory) command;
		productManager.updateAccessory(accessory);
		logger.info("returning from UpdateColorForm view to "
				+ getSuccessView());

		return new ModelAndView(new RedirectView(getSuccessView()));
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		int accessoryID = Integer.parseInt(request.getParameter("accessoryID"));
		List<Accessory> accessorys = this.productManager.getAccessById(accessoryID);
		logger.info("formBackingObject-Accessory" + accessorys);
		Accessory accessory = new Accessory();
		accessory.setAccessoryName(accessorys.get(0).getAccessoryName());
		accessory.setAccessoryDescription(accessorys.get(0).getAccessoryDescription());
		return accessory;
	}
	
	
	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	public ProductManager getProductManager() {
		return productManager;
	}

}
