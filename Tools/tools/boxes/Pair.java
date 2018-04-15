package boxes;

/**
 * this class is used to store a Pair of generic Data
 * @author Dave
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class Pair<K,V> 
{
	/**the key*/
	private K key;
	/**the value*/
	private V Value;
	
	/**
	 * Constructor
	 * @param key the key you want to save
	 * @param value the value you want to save
	 */
	public Pair(K key, V value)
	{
		this.key = key;
		this.Value = value;
	}
	
	/**
	 * Sets the key
	 * @param key the key you want to save
	 */
	public void setKey(K key) 		{this.key = key;}
	
	/**
	 * sets the value
	 * @param Value the value you want to save
	 */
	public void setValue(V Value) 	{this.Value = Value;}
	
	/**
	 * gets the key
	 * @return theh key
	 */
	public K getKey()					{return this.key;}
	
	/**
	 * gets the value
	 * @return the value
	 */
	public V getValue()				{return this.Value;}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		if(!(obj instanceof Pair<?, ?>)) return false;
		
		Pair<?, ?> other = (Pair<?, ?>)obj;
		
		return 	other.getKey().equals(this.key)
			&&  other.getValue().equals(this.Value);
	}
	
	@Override
	public int hashCode() {
		return this.key.hashCode() + this.Value.hashCode();
	}
	
	@Override
	public String toString() {
		return String.format(
			"Pair(%s, %s): {%s, %s}", 
			this.key.getClass().getSimpleName(),
			this.Value.getClass().getSimpleName(),
			this.key.toString(),
			this.Value.toString());
	}
}
