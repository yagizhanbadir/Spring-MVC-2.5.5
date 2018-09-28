package springapp.web;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import springapp.domain.Color;
import springapp.service.ProductManager;

public class UpdateColorFormController extends SimpleFormController {

	protected final Log logger = LogFactory.getLog(getClass());
	private ProductManager productManager;

	public ModelAndView onSubmit(Object command) throws ServletException {

		Color color = (Color) command;
		productManager.updateColor(color);
		logger.info("returning from UpdateColorForm view to "
				+ getSuccessView());

		return new ModelAndView(new RedirectView(getSuccessView()));
	}

	// @Override
	// protected Object formBackingObject(HttpServletRequest request)
	// throws Exception {
	// int colorID = Integer.parseInt(request.getParameter("colorID"));
	// Color color = (Color) this.productManager.getColorByID(colorID);
	// logger.info("formBackingObject-Color" + color);
	// logger.info("colorIDDDD: " + colorID);
	//
	// return color;
	// }

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		int colorID = Integer.parseInt(request.getParameter("colorID"));
		List<Color> color = this.productManager.getColorById(colorID);
		logger.info("formBackingObject-Color" + color);
		Color col = new Color();
		col.setColorName(color.get(0).getColorName());
		col.setColorCode(color.get(0).getColorCode());
		return col;
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	public ProductManager getProductManager() {
		return productManager;
	}
}

// @Override
// protected Map referenceData(HttpServletRequest request) throws Exception
// {
// Map<String, List<Color>> color = new HashMap<String, List<Color>>();
//
// int colorID = Integer.parseInt(request.getParameter("colorID"));
// List<Color> reference = this.productManager.getColorById(colorID);
// color.put("modelList", reference);
// logger.info("ReferenceDataObject-Color" + reference);
// logger.info("colorIDDDD: " + colorID);
// return color;
// }

// @Override
// protected Map referenceData(HttpServletRequest request) throws Exception
// {
// Map<String, List<Color>> referenceData = new HashMap<String,
// List<Color>>();
// int colorID = Integer.parseInt(request.getParameter("colorID"));
// Color color = this.productManager.getColorByID(colorID);
// referenceData.put("modelList",(List<Color>) color);
//
// logger.info("adsadsadsad" + color);
// logger.info("colorIDDDD: " + colorID);
//
// return referenceData;
// }
//

// protected Map<String, List<Color>> referenceData(HttpServletRequest
// request)
// throws Exception {
//
// Map<String, List<Color>> referenceData = new HashMap<String,
// List<Color>>();
// int colorId = Integer.parseInt(request.getParameter("colorID"));
// logger.info("colorIDDDD: " + colorId);
// referenceData.put("modelList",
// this.productManager.getColorById(colorId));
// logger.info("merakk: " + referenceData.put("modelList",
// this.productManager.getColorById(colorId)));
//
// return referenceData;
// }

// @Override
// protected Object formBackingObject(HttpServletRequest request)
// throws Exception {
// int colorId = Integer.parseInt(request.getParameter("colorID"));
// Color color = this.productManager.getColorByID(colorId);
// color.setColorName(color.getColorName());
// logger.info("colorNAME: " + color.getColorName());
//
// color.setColorCode(color.getColorCode());
// logger.info("colorCODE: " + color.getColorCode());
//
// return color;
//
//
// }
//
