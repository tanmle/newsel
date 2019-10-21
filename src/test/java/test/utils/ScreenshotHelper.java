package test.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

public class ScreenshotHelper {

	public static String convertImageToURI(String imagePath) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		BufferedImage img;
		File image = new File(imagePath);
		try {
			img = ImageIO.read(image);
			ByteArrayOutputStream convert = new ByteArrayOutputStream();
			ImageIO.write(img, "png", convert);
			String data = DatatypeConverter.printBase64Binary(convert.toByteArray());
			return data;
		} catch (Exception ex) {
		}
		return null;
	}

	public static String screenshotURI(String imagePath) {
		String imgURL = convertImageToURI(imagePath);
		String htmlScript = "";
		if (imgURL != null && !imgURL.equals("")) {
			String imageString = "data:image/png;base64," + imgURL;
			htmlScript = "<img src=\"" + imageString + "\"" + " style=\"width: 200px;\"/>";
		}
		return htmlScript;
	}

	public static boolean doesFileExist(String filePath, String fileName) {
		File f = new File(filePath + fileName);
		if (f.exists() && !f.isDirectory()) {
			return true;
		}
		return false;
	}

	public static void deleteFile(String filePath, String fileName) {
		File f = new File(filePath + fileName);
		if (f.exists() && !f.isDirectory()) {
			f.delete();
		}
	}

	public static void waitForFileExist(String filePath, String fileName, int timeOut) {
		int count = 1;
		while (!doesFileExist(filePath, fileName) && count < timeOut) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
		}
	}

	public static String getDownloadFolderPath() {
		return System.getProperty("java.io.tmpdir");
	}
}
