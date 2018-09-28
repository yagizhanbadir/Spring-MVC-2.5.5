package springapp.domain;

public class Accessory {


	private int accessoryID;
	private String accessoryName;
	private String accessoryDescription;
	
	public Accessory() {
	}

	public Accessory(int accessoryID, String accessoryName, String accessoryDescription) {
		this.accessoryID = accessoryID;
		this.accessoryName = accessoryName;
		this.accessoryDescription = accessoryDescription;
	}

	public int getAccessoryID() {
		return accessoryID;
	}

	public void setAccessoryID(int accessoryID) {
		this.accessoryID = accessoryID;
	}

	public String getAccessoryName() {
		return accessoryName;
	}

	public void setAccessoryName(String accessoryName) {
		this.accessoryName = accessoryName;
	}

	public String getAccessoryDescription() {
		return accessoryDescription;
	}

	public void setAccessoryDescription(String accessoryDescription) {
		this.accessoryDescription = accessoryDescription;
	}

	@Override
	public String toString() {
		return String
				.format("Accessory [accessoryID=%s, accessoryName=%s, accessoryDescription=%s]",
						accessoryID, accessoryName, accessoryDescription);
	}
	

}
