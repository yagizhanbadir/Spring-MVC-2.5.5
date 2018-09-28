package springapp.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UpdateStock {

	protected final Log logger = LogFactory.getLog(getClass());

	private int productId;
	private int newStock;

	public int getNewStock() {
		return newStock;
	}

	public void setNewStock(int newStock) {
		logger.info("UpdateStock-newStock " + newStock);
		this.newStock = newStock;

	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
		logger.info("UpdateStock-StockId: " + productId);
	}

	

}
