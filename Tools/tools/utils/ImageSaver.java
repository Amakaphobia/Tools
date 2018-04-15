package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Class Containing methods to save images to disc
 * @author Dave
 *
 */
public class ImageSaver 
{
	/**
	 * Static method used to save an Image
	 * @param image image to be saved
	 * @param target the absolute target path for image
	 */
	public static void saveImage(BufferedImage image, String target)
	{
		File F = new File(target);
		String suf = target.substring(target.lastIndexOf('.') +1);
		try{
			if(! F.exists())
				F.createNewFile();
			ImageIO.write(image, suf, F);
		}catch(Exception e){e.printStackTrace();}
	}
}
