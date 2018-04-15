package ImageEncoder;
import javafx.scene.image.Image;

/**
 * Interface to be implemented in all encoders
 * @author Dave
 *
 */
public interface I_Encoder {
	
	/**
	 * Method used to encode a string into an image
	 * @param image the image you want to encode into
	 * @param Message the codemessage
	 * @return the new modified image
	 */
	public abstract Image encode (Image image, String Message);
}