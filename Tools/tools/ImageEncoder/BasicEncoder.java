package ImageEncoder;

import java.util.stream.IntStream;
import boxes.Pair;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

/**
 * Class used to encode a message in die least significant bit of aa pixel
 * @author Dave
 *
 */
public class BasicEncoder implements I_Encoder {

	@Override
	public Image encode(Image image, String Message) 
	{
		int width = (int) image.getWidth();
		int height = (int) image.getHeight();

		PixelReader reader = image.getPixelReader();
		WritableImage copy = new WritableImage(reader, width, height);
		PixelWriter writer = copy.getPixelWriter();
		
		boolean[] bits = encode(Message);
		
		IntStream.range(0, bits.length)
			.mapToObj(e -> new Pair<>(e, reader.getArgb(e % width, e/width)))
			.map( pair -> new Pair<>(pair.getKey(), bits[pair.getKey()] ? pair.getValue() | 1 : pair.getValue() &~ 1))
			.forEach(pair -> {
				int x = pair.getKey() % width;
				int y = pair.getKey() / width;
				writer.setArgb(x, y, pair.getValue());
			});
		
		
		
		return copy;
	}
	
	/**
	 * Interna Method used to transform a String into aa bool array
	 * @param message the message you want to encode
	 * @return the bool arrasy containing the message
	 */
	private boolean[] encode(String message)
	{
		byte[] data = message.getBytes();
		
		//int = 32 bit
		//byte 8 bits
		boolean[] bits = new boolean[32 + data.length * 8];
		
		
		//Encode length
		//binary version of the messagelength expressed as a string
		String binary = Integer.toBinaryString(data.length);
		while(binary.length() < 32)
		{
			binary = "0" +binary;
		}
		
		for(int i = 0; i< 32; i++)
		{
			bits[i] = binary.charAt(i) == '1';
		}
		
		
		//encode message
		for(int i = 0; i< data.length; i++)
		{
			byte b = data[i];
			
			//cycle through byte
			for(int j = 0; j < 8; j++)
			{
				bits[32 + i*8 +j] = ((b >> (7-j)) & 1) == 1;
			}
		}
		return bits;
	}

}
