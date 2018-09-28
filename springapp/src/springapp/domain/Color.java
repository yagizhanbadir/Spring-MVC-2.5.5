package springapp.domain;

import java.io.Serializable;

public class Color implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//getColor sýkýntý yaratýyor
	private int colorID;
	private String colorName;
	private String colorCode;
	
	public Color(){
		
	}
	
	public Color(int colorID){
		this.colorID = colorID;
		
	}
	
	public Color(int colorID, String colorName, String colorCode) {	
		this.colorID = colorID;
		this.colorName = colorName;
		this.colorCode = colorCode;
	}

	public int getColorID() {
		return colorID;
	}

	public void setColorID(int colorID) {
		this.colorID = colorID;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	@Override
	public String toString() {
		return String.format("Color [colorID=%s, colorName=%s, colorCode=%s]",
				colorID, colorName, colorCode);
	}
}
