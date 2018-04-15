package imageSliceAndGlue;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;
import java.util.stream.IntStream;

import javax.imageio.ImageIO;

import boxes.Pair;
import utils.ImageSaver;


@SuppressWarnings("javadoc")
/**
 * Class used to slice an image int multiple vertical slices
 * @author Dave
 *
 */
public class ImageSlicer 
{
	private String sliced;
	private String origpath;
	private BufferedImage image;
	private int sliceCount;
	private int sliceWidth;
	private int imgWidth;
	private int imgHeight;
	
	LinkedList<BufferedImage> slices; 
	
	/**
	 * Constructor
	 * @param toSlice target absolute filepath
	 * @param slicewidth the desired width of the single slices
	 */
	public ImageSlicer(String toSlice, int slicewidth)
	{
		this.origpath = toSlice;
		this.sliced = "sliced/";
		this.slices = new LinkedList<>();
		File F = new File(toSlice);
		
		try
		{
			if(! F.exists())
				throw new Exception("that file doesnt Exist");
			
			image = ImageIO.read(F);
			
			if(image.getWidth() % slicewidth == 0)
			{
				this.sliceWidth = slicewidth;
			}
			else
			{
				this.sliceWidth = 0;
				throw new IllegalArgumentException("image width % sliceWidth != 0  !!!");
			}
			
			this.imgHeight = image.getHeight();
			this.imgWidth  = image.getWidth();
			this.sliceCount = this.imgWidth / this.sliceWidth;
			
		}catch(Exception e) {e.printStackTrace();}
	}
	
	/**method used to start the slicing procedure*/
	public void slice(){
		BufferedImage img;
		
		for(int i = 0; i < this.sliceCount; i++)
		{
			img = this.image.getSubimage(i * this.sliceWidth, 
											0, 
											this.sliceWidth,
											this.imgHeight);
			slices.add(this.copyImage(img));
		}
		
	}
	
	/**method used to save the resulting collection to files*/
	public void save(){
		IntStream.range(0, slices.size())
			.mapToObj(i -> new Pair<>(i, slices.get(i)))
			.forEach(pair -> ImageSaver.saveImage(pair.getValue(), this.buildTarget(pair.getKey())));
			
	}
	
	/**
	 * InternalMethod used to build the filename for the single slice
	 * @param key the index of the slice
	 * @return a string containing the abolute filepath
	 */
	private String buildTarget(Integer key) 
	{
		String suf = origpath.substring(origpath.lastIndexOf('.'));
		String folder = origpath.substring(0, origpath.lastIndexOf('/') +1);
		StringBuilder strb = new StringBuilder(folder);
		
		int stellen = (String.valueOf(sliceCount)).length();
		int currstell = (String.valueOf(key)).length();
		int dif = stellen - currstell;
		
		StringBuilder filename = new StringBuilder();
		for(int i = 0; i < dif; i++)
			filename.append("0");
		filename.append(key);
		
		strb.append(sliced)
			.append(filename.toString())
			.append(suf);
		return strb.toString();
	}

	/**
	 * Method used internally to create a "deep copy" of an image
	 * @param source the image to be copied
	 * @return the copied image
	 */
	private BufferedImage copyImage(BufferedImage source)
	{
	    BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
	    Graphics g = b.getGraphics();
	    g.drawImage(source, 0, 0, null);
	    g.dispose();
	    return b;
	}
	
	/**
	 * Method that can be used to change the outputfolder
	 * @param name the filepath to the folde
	 */
	public void setOutputfolderName(String name)
	{
		String folder = name;
		if(!folder.endsWith("/"))
			folder.concat("/");
		this.sliced = folder; 
	}
	
	
}
