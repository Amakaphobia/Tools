package ImageEncoder;

import javafx.scene.image.Image;

/**
 * Interface to be implemented in all decoders
 * @author Dave
 *
 */
public interface I_Decoder {
	
	/**
	 * Method used to decode a string out of an image
	 * @param Image the image you want to decode
	 * @return the string containing thhe message
	 */
	public abstract String decode(Image Image);
}
