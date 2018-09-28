package springapp.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import springapp.domain.Accessory;
import springapp.domain.Color;
import springapp.domain.Product;
import springapp.repository.ProductDao;

public class SimpleProductManager implements ProductManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private List<Product> products;
	private ProductDao productDao;
	protected final Log logger = LogFactory.getLog(getClass());

	public List<Product> getProducts() {
		return productDao.getProductList();
	}

	public List<Color> getColors() {
		return productDao.getColorList();
	}

	public List<Accessory> getAccessorys() {
		return productDao.getAccessoryList();
	}

	public void cutPrice(int percentage) {
		List<Product> products = productDao.getProductList();
		if (products != null) {
			for (Product product : products) {
				double newPrice = product.getPrice().doubleValue()
						* (100 - percentage) / 100;
				product.setPrice(newPrice);
				productDao.saveProduct(product);
			}
		}
	}

	public void increasePrice(int percentage) {
		List<Product> products = productDao.getProductList();
		if (products != null) {
			for (Product product : products) {
				double newPrice = product.getPrice().doubleValue()
						* (100 + percentage) / 100;
				product.setPrice(newPrice);
				productDao.saveProduct(product);
			}
		}
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public void addProduct(Product product) {

		productDao.insertProduct(product);
	}

	public void deleteProduct(int id) {
		productDao.deleteProduct(id);

	}

	public void increaseStock(int id) {
		productDao.increaseStock(id);
	}

	public void decreaseStock(int id) {
		productDao.decreaseStock(id);
	}

	public void updateStock(UpdateStock updateStock) {
		productDao.updateStock(updateStock);
	}

	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	public void deleteColor(int id) {
		productDao.deleteColor(id);
	}

	public void deleteAccessory(int accessoryID) {
		productDao.deleteAccessory(accessoryID);

	}

	public void updateColor(Color color) {
		productDao.updateColor(color);
	}
	
	public void updateAccessory(Accessory accessory) {
		productDao.updateAccessory(accessory);
	}

	

	public void addColor(Color color) {
		productDao.addColor(color);
	}
	
	public void addAccessory(Accessory accessory) {
		productDao.addAccessory(accessory);
		
	}


	public List<Color> getColorById(int colorId) {
		return productDao.getColorById(colorId);

	}

	public List<Product> getProductById(int productId) {
		return productDao.getProductById(productId);

	}

	public List<Accessory> getAccessById(int accessoryID) {
		return productDao.getAccessoryById(accessoryID);
	}

	
	// public void updateStock(Product prod) {
	// productDao.updateProduct(prod);
	// }

	// public void setProducts(List<Product> products) {
	// this.products = products;
	// }

}