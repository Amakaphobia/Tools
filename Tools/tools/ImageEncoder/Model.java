package ImageEncoder;

import javafx.scene.image.Image;

/**
 * This class holds the de and encoder objects
 * @author Dave
 *
 */
@SuppressWarnings("javadoc")
public class Model 
{
	private I_Encoder enc;
	private I_Decoder dec;
	
	/**
	 * Constructor
	 * @param enc the encode object you want to use
	 * @param dec the decode object you want to use
	 */
	public Model(I_Encoder enc, I_Decoder dec)
	{
		this.enc = enc;
		this.dec = dec;
	}
	
	/**
	 * Method used to invoke the encode method
	 * @param image the image you want to encode into
	 * @param Message the message you want to encode
	 * @return the modified image
	 */
	public Image encode (Image image, String Message)
	{
		return this.enc.encode(image, Message);
	}
	
	/**
	 * Method used to invoke the decode method
	 * @param image the image you want to decode
	 * @return the string contained in the image
	 */
	public String decode (Image image)
	{
		return this.dec.decode(image);
	}
}