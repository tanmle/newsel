package test.data.customer.call;

import java.io.File;

public class Attachments {

	private String file;
	private String location;
	private String size;

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFullPath() {
		File file = new File(this.location);
		return file.getAbsolutePath();
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
}
