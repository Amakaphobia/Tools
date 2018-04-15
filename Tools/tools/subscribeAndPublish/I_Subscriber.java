package subscribeAndPublish;

/**
 * This Interface is used to mark a class as a subscriber to publishers.
 * @author Dave
 *
 */
public interface I_Subscriber 
{
	/**
	 * This Method is called by the Publisher Object to send a new Update to its subscribers
	 * @param Update the update you want to send in a generic form
	 * @param <T> the datatype of the object send
	 */
	public abstract <T> void getUpdates(T Update);
}
