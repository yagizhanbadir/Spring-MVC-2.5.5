package springapp.repository;


import java.util.List;

import springapp.domain.Accessory;
import springapp.domain.Color;
import springapp.domain.Product;
import springapp.service.UpdateStock;

public interface ProductDao {

	public List<Product> getProductList();
	
	public List<Color> getColorList();
	
	public List<Accessory> getAccessoryList();
		
	public void saveProduct(Product prod);

	public void insertProduct(Product product);

	public void deleteProduct(int id);
	
	public void deleteColor(int id);
	
	public void deleteAccessory(int accessoryID);
	
	public void updateStock(UpdateStock updateStock);
	
	public void increaseStock(int id);
	
	public void decreaseStock(int id);
	
	public void updateProduct(Product product);

	public void updateColor(Color color);

	public void updateAccessory(Accessory accessory);

	public void addColor(Color color);

	public void addAccessory(Accessory accessory);
	
	public List<Color> getColorById(int colorId);

	public List<Product> getProductById(int productId);

	public List<Accessory> getAccessoryById(int accessoryID);






	

	


	
}