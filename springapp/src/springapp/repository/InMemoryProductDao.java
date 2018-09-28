package springapp.repository;

import java.util.List;

import springapp.domain.Accessory;
import springapp.domain.Color;
import springapp.domain.Product;
import springapp.service.UpdateStock;

public class InMemoryProductDao implements ProductDao {

	private List<Product> productList;

	public InMemoryProductDao(List<Product> productList) {
		this.productList = productList;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public List<Color> getColorList() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveProduct(Product prod) {
	}

	public void insertProduct(Product product) {

	}

	public void deleteProduct(int id) {
		// TODO Auto-generated method stub

	}

	public void increaseStock(int id) {
		// TODO Auto-generated method stub

	}

	public void decreaseStock(int id) {
		// TODO Auto-generated method stub

	}

	public void updateStock(UpdateStock upStock) {
		// TODO Auto-generated method stub

	}

	public void updateProduct(Product product) {
		// TODO Auto-generated method stub

	}

	public void deleteColor(int id) {
		// TODO Auto-generated method stub

	}

	public void updateColor(Color color) {
		// TODO Auto-generated method stub

	}

	public void addColor(Color color) {
		// TODO Auto-generated method stub

	}

	public List<Color> getColorById(int colorId) {
		return null;
	}

	public Color getColorByID(int colorId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getProductById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Accessory> getAccessoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteAccessory(int accessoryID) {
		// TODO Auto-generated method stub

	}

	public void addAccessory(Accessory accessory) {
		// TODO Auto-generated method stub

	}

	public void updateAccessory(Accessory accessory) {
		// TODO Auto-generated method stub

	}

	public List<Accessory> getAccessoryById(int accessoryID) {
		// TODO Auto-generated method stub
		return null;
	}

}