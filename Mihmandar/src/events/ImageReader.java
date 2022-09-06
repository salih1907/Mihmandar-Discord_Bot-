package events;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int width = 1024;
		int height = 1024;
		
		BufferedImage  image = null;
		
		image = readFromFile(width, height, image);
		
	}

	private static BufferedImage readFromFile(int width, int height, BufferedImage image) {
		try {
			File sampleFile = new File("C:\\Users\\gencs\\Desktop\\images\\kitten.jpg");
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			image = ImageIO.read(sampleFile);
			
			System.out.println("reading complete. "+ image);
		} catch (IOException e) {
			System.out.println("Error: "+e);
		}
		return image;
	}

}
