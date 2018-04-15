package permutation;

/**
 * Interface used to declare Classes that can be permuted.
 * @author hdaiv_000
 *
 * @param <D> the ClassType of the a Single Element.
 * @since V 0.14
 */
public interface I_Permutable<D> 
{	
	/**
	 * Method used to get a Single Element out of a String of permutable Elements.
	 * includes getSet(int,int) of this interface
	 * @param index the index of the desired element
	 * @return the found element.
	 */
	public default I_Permutable<D> getSingle(int index) {
		return this.getSet(index, index+1);
	}
	
	/**
	 * Method used to get a set of elements out of a string of a permutable object, given a startingpoint.
	 * includes getSet(int,int) of this interface
	 * @param startInclusive where you want to start 
	 * @return the found string of elements
	 */
	public default I_Permutable<D> getSet(int startInclusive) {
		return this.getSet(startInclusive, this.getLaenge());
	}
	
	/**
	 * Method used to access the Data object
	 * @return the data object
	 */
	public abstract D getData();
	
	/**
	 * Method used to concat two different permutable elements into a Single new one. it appends the given elelemts to "this" one. 
	 * @param other the elements you want to add to this one
	 * @return a new Permutable object that contains all elements of this and the other object
	 */
	public abstract I_Permutable<D> concat(I_Permutable<D> other);
	
	/**
	 * Method used to get a subset of elements given a starting point index and a endpoint index
	 * @param startInclusive where you want to start
	 * @param endExclusive where you want to end
	 * @return the found subset
	 */
	public abstract I_Permutable<D> getSet(int startInclusive, int endExclusive);
	
	/**
	 * Method used to count all elements in this object
	 * @return integer count
	 */
	public abstract int getLaenge();
}
