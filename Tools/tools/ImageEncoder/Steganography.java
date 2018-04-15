package ImageEncoder;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * testclass
 * @author Dave
 *
 */
@SuppressWarnings("javadoc")
public class Steganography extends Application
{
	private Model createModel()
	{
		return new Model(new BasicEncoder(), new BasicDecoder());
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene s = new Scene(new View(new Controller(createModel())));
		primaryStage.setTitle("Steganographie");
		primaryStage.setScene(s);
		primaryStage.setWidth(300);
		primaryStage.setHeight(300);
//		primaryStage.sizeToScene();
		primaryStage.show();	
	}
	
	public static void main(String[]a) 		{ launch(a); }
	
}
