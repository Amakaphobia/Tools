package ImageEncoder;
import java.io.File;
import java.net.MalformedURLException;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * View is the main UI element of the encoding program
 * @author Dave
 *
 */
@SuppressWarnings("javadoc")
public class View extends Pane
{
	private Controller controller;
	
	/**
	 * Constructor
	 * @param c the jfx controller
	 */
	public View(Controller c) 
	{
		this.controller = c;
		File F = new File("C:/Users/Dave/workspace.new/$$txtfl/Image/100by100x.png");
		Image image = null;
		
		
		try 
		{
			image = new Image(F.toURI().toURL().toExternalForm());
		}
		
		catch (MalformedURLException e) {e.printStackTrace();}
		
		ImageView original = new ImageView(image);
		ImageView modified = new ImageView();
		double height = original.getImage().getHeight();
		double width = original.getImage().getWidth();
		int margin = 10;
		
		modified.setTranslateX(width);
		
		TextField tf = new TextField("Enter Message");
		tf.setTranslateY(height);
		tf.setPrefWidth(width);
		tf.setOnAction(e -> this.controller.onEncode());
		
		
		
		Button btnDecode = new Button("Decode");
		btnDecode.setTranslateX(width + margin);
		btnDecode.setTranslateY(height);
		btnDecode.setOnAction(e -> this.controller.onDecode());	
		
		this.controller.injectUI(original, modified, tf);
		
		
		getChildren().addAll(original
						, modified
						, tf
						, btnDecode
						);
	
	}
	
	
	
}