package springapp.service;

import java.io.Serializable;
import java.util.List;

import springapp.domain.Accessory;
import springapp.domain.Color;
import springapp.domain.Product;

public interface ProductManager extends Serializable {

	public void increasePrice(int percentage);

	public void cutPrice(int percentage);

	public List<Product> getProducts();
		
	public List<Color> getColors();

	public List<Accessory> getAccessorys();

	public void addProduct(Product product);

	public void addColor(Color color);

	public void addAccessory(Accessory accessory);

	public void deleteProduct(int id);

	public void increaseStock(int id);

	public void decreaseStock(int id);

	public void updateStock(UpdateStock updateStock);

	public void updateProduct(Product updateProduct);

	public void updateColor(Color color);

	public void updateAccessory(Accessory accessory);

	public void deleteColor(int id);

	public List<Color> getColorById(int i);

	public List<Product> getProductById(int productId);

	public List<Accessory> getAccessById(int accessoryID);

	public void deleteAccessory(int accessoryID);


}
