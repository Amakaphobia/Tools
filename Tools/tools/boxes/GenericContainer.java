package boxes;

/**
 * Simple Generic Container
 * @author Dave
 *
 * @param <T> the Type of Value to be stored
 */
public class GenericContainer <T>
{
	/**the value field*/
	private T Value;
	
	/**
	 * Constructor
	 * @param Value the value to be stored
	 */
	public GenericContainer(T Value) {
		this.Value = Value;
	}
	/**
	 * Method used to access the value
	 * @return the value
	 */
	public T getValue(){return this.Value;}
}
