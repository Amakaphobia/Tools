package permutation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Wrapper class for lists to make permutation accessable
 * @author hdaiv_000
 *
 * @param <T> Element type of the a single List element
 * @since V0.14
 */
public class PermutList<T> implements I_Permutable<List<T>> 
{
	/**holds the data*/
	private final List<T> data;

	/**
	 * Constructor
	 * @param data the list you want to permutate
	 */
	public PermutList(List<T> data) {
		this.data = data;
	}
	
	
	@Override
	public List<T> getData() { return this.data; }

	@Override
	public I_Permutable<List<T>> concat(I_Permutable<List<T>> other) {
		List<T> ret = new ArrayList<>();
		ret.addAll(this.data);
		ret.addAll(other.getData());
		return new PermutList<T>(ret);
	}

	@Override
	public I_Permutable<List<T>> getSet(int startInclusive, int endExclusive) {
		return new PermutList<T>(
					IntStream.range(startInclusive, endExclusive)
							.mapToObj(i -> this.data.get(i))
							.collect(Collectors.toList()));
	}

	@Override
	public int getLaenge() {
		return this.data.size();
	}

}
