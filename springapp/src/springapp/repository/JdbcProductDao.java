package springapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import springapp.domain.Accessory;
import springapp.domain.Color;
import springapp.domain.Product;
import springapp.service.UpdateStock;

public class JdbcProductDao extends SimpleJdbcDaoSupport implements ProductDao {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	public List<Product> getProductList() {
		logger.info("JdbcProductDao-Getting products!");
		List<Product> products = getSimpleJdbcTemplate()
		 .query("select *from products INNER JOIN colors ON colors.colorID=products.colorID INNER JOIN accessorys ON accessorys.accessoryID=products.accessoryID",

				new ProductMapper());

		// List<Product> products = getSimpleJdbcTemplate()
		// .query("select *from products INNER JOIN colors ON colors.colorID=products.colorID INNER JOIN accessorys ON accessorys.accessoryID=products.accessoryID",
		// new ProductMapper());
		return products;
	}

	public List<Product> getProductById(int productId) {
		logger.info("JdbcProductDao-UpdateColorId: " + productId);
		String sql = "select *from products INNER JOIN colors ON products.colorID=colors.colorID INNER JOIN accessorys ON accessorys.accessoryID=products.accessoryID WHERE id="
				+ productId;
		List<Product> products = getSimpleJdbcTemplate().query(sql,
				new ProductMapper());

		logger.info("JdbcProductDao-UpdateColorID: " + productId);
		return products;
	}

	public void saveProduct(Product prod) {
		int count = getSimpleJdbcTemplate()
				.update("update products set description = :description, price = :price where id = :id",
						new MapSqlParameterSource()
								.addValue("id", prod.getId())
								.addValue("name", prod.getName())
								.addValue("description", prod.getDescription())
								.addValue("colorID", prod.getColor())
								.addValue("weight", prod.getWeight())
								.addValue("price", prod.getPrice())
								.addValue("stock", prod.getStock())
								.addValue("accessoryID", prod.getAccessory()));
		// .addValue("accessoryID", prod.getAccessoryList()));

		logger.info("JdbcProductDao-Rows affected: " + count);
	}

	private static class ProductMapper implements
			ParameterizedRowMapper<Product> {


		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

			Product prod = new Product();
			Color color = new Color();

			prod.setId(rs.getInt("id"));
			prod.setName(rs.getString("name"));
			prod.setDescription(rs.getString("description"));
			prod.setWeight(new Double(rs.getDouble("weight")));
			prod.setPrice(new Double(rs.getDouble("price")));
			prod.setStock(rs.getInt("stock"));

			// prod.setColor(rs.getString("color"));
			color.setColorID(rs.getInt("colorID"));
			color.setColorName(rs.getString("colorName"));
			color.setColorCode(rs.getString("colorCode"));
			prod.setColor(color);

			Accessory accessory = new Accessory();
			accessory.setAccessoryID(rs.getInt("accessoryID"));
			accessory.setAccessoryName(rs.getString("accessoryName"));
			accessory.setAccessoryDescription(rs
					.getString("accessoryDescription"));
			prod.setAccessory(accessory);
			// Accessory accessory = new Accessory();
			// accessory.setAccessoryID(rs.getInt("accessoryID"));
			// accessory.setAccessoryName(rs.getString("accessoryName"));
			// accessory.setAccessoryDescription(rs.getString("accessoryDescription"));
			// logger.info("dddddddddddddddddddddddd           " + accessory );
			// prod.getAccessoryList().add(accessory);
			return prod;
		}
	}

	public void insertProduct(Product prod) {

		int count = getSimpleJdbcTemplate()
				.update("INSERT INTO products (name, description, colorID, weight, price, stock, accessoryID) values("
						+ "'"
						+ prod.getName()
						+ "',"
						+ "'"
						+ prod.getDescription()
						+ "','"
						+ prod.getColor().getColorID()
						+ "',"
						+ prod.getWeight()
						+ ","
						+ prod.getPrice()
						+ ","
						+ prod.getStock()
						+ ","
						+ prod.getAccessory().getAccessoryID()
						// + prod.getAccessoryList().get(0).getAccessoryID()
						+ ")",
						new MapSqlParameterSource()
								.addValue("name", prod.getName())
								.addValue("description", prod.getDescription())
								.addValue("colorID",
										prod.getColor().getColorID())
								.addValue("weight", prod.getWeight())
								.addValue("price", prod.getPrice())
								.addValue("stock", prod.getStock())
								.addValue("accessoryID",
										prod.getAccessory().getAccessoryID())
								// .addValue("accessoryID",
								// prod.getAccessoryList().get(0).getAccessoryID())
								.addValue("id", prod.getId()));
		logger.info("InsertProduct - Count: " + count);
	}

	public void updateProduct(Product product) {
		logger.info("JdbcProductDao-UpdateProduct: " + product.getColor());

		String sql = "UPDATE products SET name=?, description=?, colorID=?, weight=?, price=?, stock=?, accessoryID=? WHERE id=?";
		// logger.info("getAccessory: " + product.getAccessoryList());
		logger.info("getAccessory: " + product.getAccessory());
		getSimpleJdbcTemplate().update(sql, product.getName(),
				product.getDescription(), product.getColor().getColorID(),
				product.getWeight(), product.getPrice(), product.getStock(),
				product.getAccessory().getAccessoryID(),
				// product.getAccessoryList().get(0).getAccessoryID(),
				product.getId());

		logger.info("JdbcProductDao-UpdateProduct: " + product.getColor());

	}

	public void updateAccessory(Accessory accessory) {
		String sql = "UPDATE accessorys SET accessoryName=?, accessoryDescription=? WHERE accessoryID=?";
		getSimpleJdbcTemplate()
				.update(sql, accessory.getAccessoryName(),
						accessory.getAccessoryDescription(),
						accessory.getAccessoryID());

	}

	public void deleteAccessory(int accessoryID) {
		String sql = "DELETE FROM accessorys where accessoryID=?";
		getSimpleJdbcTemplate().update(sql, accessoryID);
		logger.info("JdbcProductDao-Deleted Accessory: " + accessoryID);

	}

	public void deleteColor(int id) {
		String sql = "DELETE FROM colors where colorID=?";
		getSimpleJdbcTemplate().update(sql, id);
		logger.info("JdbcProductDao-Deleted Color: " + id);
	}

	public void updateColor(Color color) {
		String sql = "UPDATE colors SET colorName=?, colorCode=? WHERE colorID=?";
		getSimpleJdbcTemplate().update(sql, color.getColorName(),
				color.getColorCode(), color.getColorID());
	}

	public List<Color> getColorList() {
		logger.info("JdbcProductDao-Getting colors!");
		List<Color> colors = getSimpleJdbcTemplate().query(
				"select *from colors", new ColorMapper());
		return colors;
	}

	public List<Color> getColorById(int colorId) {
		logger.info("JdbcProductDao-UpdateColorId: " + colorId);

		String sql = "select *from colors WHERE colorID=" + colorId;
		List<Color> colors = getSimpleJdbcTemplate().query(sql,
				new ColorMapper());

		logger.info("JdbcProductDao-UpdateColorID: " + colorId);
		return colors;
	}

	private static class ColorMapper implements ParameterizedRowMapper<Color> {

		public Color mapRow(ResultSet rs, int rowNum) throws SQLException {
			Color color = new Color();
			color.setColorID(rs.getInt("colorID"));
			color.setColorName(rs.getString("colorName"));
			color.setColorCode(rs.getString("colorCode"));

			// int colorID = rs.getInt("colorID");
			// String colorName = rs.getString("colorName");
			// String colorCode = rs.getString("colorCode");
			// return new Color(colorID,colorName,colorCode);
			return color;
		}
	}

	public void addColor(Color color) {
		logger.info("JdbcProductDao-Saving-color ");

		int count = getSimpleJdbcTemplate().update(
				"INSERT INTO colors (colorName, colorCode) VALUES (" + "'"
						+ color.getColorName() + "'" + ",'"
						+ color.getColorCode() + "')",
				new MapSqlParameterSource()
						.addValue("colorName", color.getColorName())
						.addValue("colorCode", color.getColorCode())
						.addValue("colorID", color.getColorID()));
		logger.info("addColor - Count: " + count);

	}

	public void increaseStock(int id) {

		String sql = "UPDATE products SET stock=stock+1 WHERE id=?";
		getSimpleJdbcTemplate().update(sql, id);
		logger.info("JdbcProductDao-Update stock id: " + id);
	}

	public void decreaseStock(int id) {
		String sql = "UPDATE products SET stock=stock-1 WHERE id=? AND stock>0";
		getSimpleJdbcTemplate().update(sql, id);
		logger.info("JdbcProductDao-Update stock id: " + id);
	}

	public List<Accessory> getAccessoryList() {
		logger.info("JdbcProductDao-Getting accessory!");
		List<Accessory> accessorys = getSimpleJdbcTemplate().query(
				"select *from accessorys", new AccessoryMapper());
		return accessorys;
	}

	public List<Accessory> getAccessoryById(int accessoryID) {
		logger.info("JdbcProductDao-UpdateAccessoryId: " + accessoryID);
		String sql = "SELECT *FROM accessorys WHERE accessoryID=" + accessoryID;
		List<Accessory> accessory = getSimpleJdbcTemplate().query(sql,
				new AccessoryMapper());
		logger.info("JdbcProductDao-UpdateAccessoryID: " + accessoryID);
		return accessory;
	}

	public void addAccessory(Accessory accessory) {
		logger.info("JdbcProductDao-AddAccessory ");

		int count = getSimpleJdbcTemplate()
				.update("INSERT INTO accessorys (accessoryName, accessoryDescription) VALUES ("
						+ "'"
						+ accessory.getAccessoryName()
						+ "','"
						+ accessory.getAccessoryDescription() + "')",
						new MapSqlParameterSource()
								.addValue("accessoryName",
										accessory.getAccessoryName())
								.addValue("accessoryDescription",
										accessory.getAccessoryDescription())
								.addValue("accessoryID",
										accessory.getAccessoryID()));
		logger.info("addColor - Count: " + count);

	}

	private static class AccessoryMapper implements
			ParameterizedRowMapper<Accessory> {

		public Accessory mapRow(ResultSet rs, int rowNum) throws SQLException {
			Accessory accessory = new Accessory();
			accessory.setAccessoryID(rs.getInt("accessoryID"));
			accessory.setAccessoryName(rs.getString("accessoryName"));
			accessory.setAccessoryDescription(rs
					.getString("accessoryDescription"));

			// int colorID = rs.getInt("colorID");
			// String colorName = rs.getString("colorName");
			// String colorCode = rs.getString("colorCode");
			// return new Color(colorID,colorName,colorCode);
			return accessory;
		}
	}

	public void deleteProduct(int id) {

		String sql = "DELETE FROM products where id=?";
		getSimpleJdbcTemplate().update(sql, id);
		logger.info("JdbcProductDao-Deleted: " + id);
	}

	public void updateStock(UpdateStock updateStock) {
		String sql = "UPDATE products SET stock=? WHERE id=?";
		getSimpleJdbcTemplate().update(sql, updateStock.getNewStock(),
				updateStock.getProductId());
		logger.info("JdbcProductDao-UpdateStock: " + updateStock.getNewStock()
				+ " JdbcProductDao-id: " + updateStock.getProductId());

	}

}