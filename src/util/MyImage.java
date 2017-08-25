package util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class MyImage {
	public static Image get(String path){
		URL u=MyImage.class.getClassLoader().getResource(path);
		BufferedImage img=null;
		try {
			img=ImageIO.read(u);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return img;
	}
}
