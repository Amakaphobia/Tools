package subscribeAndPublish;

/**
 * This Interfaace is used to mark a class as a Publisher
 * @author Dave
 *
 */
public interface I_Publisher 
{
	/**
	 * This method is called by subscribers to add themselves to the notification list
	 * @param sub the subscriber that wants to sub
	 */
	public abstract void subscribe(I_Subscriber sub);
	
	/**
	 * This method is called by subscribers to delete themselves from the notification list
	 * @param sub the subscriber that wants to unsub
	 */
	public abstract void unsubscribe(I_Subscriber sub);
	
	/**
	 * This method is used by the publisher to send updates to the subscribers
	 * @param s the Update to send
	 * @param <T> the datatype of the Update
	 */
	 public abstract <T> void sendUpdate(T s);
}
