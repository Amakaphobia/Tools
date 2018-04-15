package imageSliceAndGlue;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

import utils.ImageSaver;

/**
 * Class used to glue a given collection of images together
 * @author Dave
 *
 */
public class ImageGluer 
{
	/**the sourcefolder*/
	private File sourceFolder;
	/**String with the path to the folder*/
	private String dir;
	
	/**List containing all Slices*/
	private LinkedList<BufferedImage> slices;
	/**the glued images*/
	private BufferedImage result;
	
	/**
	 * Constructor used if you have already a list of images
	 * @param slices your images
	 */
	public ImageGluer(LinkedList<BufferedImage> slices)
	{
		this.slices = slices;
		
		int resultHeight = this.slices.getFirst().getHeight();
		int resultWidth =
				this.slices.stream()
					.mapToInt(image -> image.getWidth())
					.sum();
		this.result = new BufferedImage(resultWidth
										, resultHeight
										, BufferedImage.TYPE_INT_RGB);
	}
	
	/**
	 * Constructor
	 * @param sourceFolder the folder containing the source images
	 */
	public ImageGluer(String sourceFolder)
	{
		this.dir = sourceFolder;
		this.sourceFolder = new File(dir);
		this.checkFolder();
		this.slices = new LinkedList<>();
		this.readFolder();
		
		int resultHeight = slices.getFirst().getHeight();
		int resultWidth =
				slices.stream()
					.mapToInt(image -> image.getWidth())
					.sum();
		this.result = new BufferedImage(resultWidth
										, resultHeight
										, BufferedImage.TYPE_INT_RGB);
	}
	
	/**Method used to check a folder for validity*/
	private void checkFolder()
	{
		if(! this.sourceFolder.exists())
			throw new IllegalArgumentException("Sourcefolder doesnt exist");
		if(! this.sourceFolder.isDirectory())
			throw new IllegalArgumentException("Sourcefolder is not a folder");
	}
	
	/**Method used internally to create a List of files out of the sourcefolder*/
	private void readFolder()
	{
		List<File> FList = Arrays.asList(this.sourceFolder.listFiles());
		FList.stream()
			.forEach(this::addToList);
	}
	
	/**
	 * method used internally to add an image to the slicelist 
	 * @param f the file containing the image
	 */
	private void addToList(File f)
	{
		try
		{
			this.slices.add(ImageIO.read(f));
		}
		catch(IOException e)	{e.printStackTrace();}
	}
	
	/**
	 * Method used to start the glue procedure
	 * @return the resulting bufferedImage
	 */
	public BufferedImage glue()
	{
		Graphics g = this.result.createGraphics();
		BufferedImage current;
		int cumultwidth = 0;
		for(int i = 0; i < slices.size(); i++)
		{
			current = slices.get(i);
			g.drawImage(current, cumultwidth, 0, null);
			cumultwidth += current.getWidth();
		}
		g.dispose();
		return result;
	}
	
	/**
	 * Method used to Save the resulting image
	 * @param path the path to wich to save to
	 * @param suf the used filesuffix
	 */
	public void saveIt(String path, String suf)
	{
		StringBuilder strb = new StringBuilder(path);
		strb.append("glued")
			.append(suf);
		ImageSaver.saveImage(this.result, strb.toString());	
	}
	
	/**
	 * Method used to save the result to disc
	 * @param suf filesuffix
	 */
	public void saveIt(String suf)
	{
		StringBuilder strb = new StringBuilder(dir);
		strb.append("glued")
			.append(suf);
		ImageSaver.saveImage(this.result, strb.toString());
	}
}
