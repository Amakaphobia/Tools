package ImageEncoder;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Java FX controller class
 * @author Dave
 *
 */
@SuppressWarnings("javadoc")
public class Controller 
{
	private Model model;
	
	private TextField tf;

	private ImageView originalView;
	private ImageView modifiedView;
	
	/**
	 * Constructor
	 * @param m holding the decode and encode objects
	 */
	public Controller(Model m) {
		this.model = m;
	}
	
	/**
	 * Method used to inject all UI elements
	 * @param original the original imageview
	 * @param modified thhe view that will contain the modified image
	 * @param tf te textfield for entering the message
	 */
	public void injectUI(ImageView original, ImageView modified, TextField tf)
	{
		this.originalView = original;
		this.modifiedView = modified;
		this.tf = tf;
	}
	
	/**Methods used to start encode procedure*/
	public void onEncode(){
		Image modified = model.encode(originalView.getImage(), tf.getText());
		this.modifiedView.setImage(modified);
	}
	/**Method used start decode procedure*/
	public void onDecode(){
		String message = this.model.decode(modifiedView.getImage());
		System.out.println(message);
	}
}
