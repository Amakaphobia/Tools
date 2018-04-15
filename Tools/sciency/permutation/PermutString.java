package permutation;


/**
 * Wrapper class for Strings to make them permutable
 * @author hdaiv_000
 * @since  V0.14
 */
public class PermutString implements I_Permutable<String>{

	/**String you want to permute*/
	private final String data;

	/**
	 * Constructor
	 * @param data the String you want to permutate
	 */
	public PermutString(String data) {
		this.data = data;
	}

	@Override
	public String getData() { return this.data; }

	@Override
	public I_Permutable<String> concat(I_Permutable<String> other) {
		return new PermutString(this.data.concat(other.getData()));
	}

	@Override
	public I_Permutable<String> getSet(int startInclusive, int endExclusive) {
		return new PermutString(this.data.substring(startInclusive, endExclusive));
	}

	@Override
	public int getLaenge() {
		return this.data.length();
	}

	@Override
	public String toString() { return this.data; }
	@Override
	public int hashCode() {	return this.data.hashCode(); }

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		if(!(obj instanceof PermutString)) return false;

		PermutString other = (PermutString) obj;

		return this.data.equals(other.data);
	}

}
