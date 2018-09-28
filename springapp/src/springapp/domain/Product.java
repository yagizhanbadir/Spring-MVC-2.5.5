package springapp.domain;

import java.io.Serializable;


public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String description;
	private Color color;
	private Double weight;
	private Double price;
	private int stock;
	private Accessory accessory;

//	private List<Accessory> accessory = new ArrayList<Accessory>();

	// private List<Accessory> accessory;

	public Product() {

	}

	 public Product(int id, String name, String description, Color color,
	 Double weight, Double price, int stock, Accessory accessory) {
	 super();
	 this.id = id;
	 this.name = name;
	 this.description = description;
	 this.color = color;
	 this.weight = weight;
	 this.price = price;
	 this.stock = stock;
	 this.accessory = accessory;
	 }

//	public Product(int id, String name, String description, Color color,
//			Double weight, Double price, int stock, List<Accessory> accessory) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.description = description;
//		this.color = color;
//		this.weight = weight;
//		this.price = price;
//		this.stock = stock;
//		this.accessory = accessory;
//	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		if (stock <= 0 & stock >= Integer.MIN_VALUE) {
			stock = 0;
		} else {

			this.stock = stock;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setId(int i) {
		this.id = i;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Accessory getAccessory() {
		return accessory;
	}

	public void setAccessory(Accessory accessory) {
		this.accessory = accessory;
	}

//	public List<Accessory> getAccessory() {
//		return accessory;
//	}
//
//	public void setAccessory(List<Accessory> accessory) {
//		this.accessory = accessory;
//	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Description: " + description + ";");
		buffer.append("Price: " + price);
		return buffer.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}

}