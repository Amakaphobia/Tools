package permutation;

import java.math.BigInteger;
import java.util.List;
import java.util.Vector;

import math.Mathekram;

/**
 * Class to collect Static permutation Methods
 * @author hdaiv_000
 * @since  V0.14
 */
public class Permutation {

	/**
	 * Method used to permute a List.
	 * @param inputList the List you want to permute
	 * @return a Vector with all the Lists created by permutation.
	 * @param <T> The Typeparameter of the given List
	 */
	public static <T> Vector<List<T>> permList(List<T> inputList){
		return permObjDistinct(new PermutList<>(inputList));
	}

	/**
	 * Method used to permute a String
	 * @param str the String you want to permute
	 * @return a Vector with all Strings created by the permutation
	 */
	public static Vector<String> permStr(String str){
		return permObjDistinct(new PermutString(str));
	}

	/**
	 * Method used to permutate a object that implements the {@link I_Permutable} interface.
	 * it will give all permutations.
	 * @param obj the Permutable you want to permute
	 * @param <T> The Type of the given Object
	 * @return Vector with all permutations of the given obj
	 */
	public static <T> Vector<T> permObjEveryOne(I_Permutable<T> obj){
		Vector<I_Permutable<T>> vect = permObjImplementation(obj);
		return
			vect.stream()
				.map(e -> e.getData())
				.collect(Vector::new, Vector::add, Vector::addAll);
	}

	/**
	 * Method used to permutate a object that implements the {@link I_Permutable} interface.
	 * it will give only distinct permutations.
	 * @param obj the Permutable you want to permute
	 * @param <T> The Type of the given Object
	 * @return Vector with all permutations of the given obj
	 */
	public static <T> Vector<T> permObjDistinct(I_Permutable<T> obj) {
		return  permObjImplementation(obj)
					.stream()
					.map(e -> e.getData())
					.distinct()
					.collect(Vector::new, Vector::add, Vector::addAll);
	}

	/**
	 * inner method that actually permutates the given obj. It is implemented by the other methods in this class.
	 * @param obj the object you want to permutate
	 * @param <T> The Type of the given Object
	 * @return all permutations of the given Object in a Vector
	 */
	private static <T> Vector<I_Permutable<T>> permObjImplementation(I_Permutable<T> obj){
	    int laenge = obj.getLaenge();
        Vector<I_Permutable<T>> ret = new Vector<>();

		if (laenge == 1)
			ret.add(obj);
		else{
		    I_Permutable<T> start = obj.getSingle(0);

		    Vector<I_Permutable<T>> afterFirst = permObjImplementation(obj.getSet(1, laenge));

		    for (I_Permutable<T> endStr : afterFirst)
				for (int j = 0; j < laenge; j++)
					ret.add(
	            		endStr.getSet(0, j)
	            			  .concat(start)
	            			  .concat(endStr.getSet(j)));
	    }
		return ret;
	}

	/**
	 * Method used to find out how many permutations there are for given Input.
	 * @param input The {@link I_Permutable} Object you want to count the permutations of.
	 * @return a BigInteger containing the PermutationCount
	 */
	public static BigInteger countPermutations(I_Permutable<?> input) {
		return Mathekram.facultyBig(input.getLaenge());
	}

	/**
	 * Method used to find out how many distinct permutations there are for given Input.
	 * @param input The {@link I_Permutable} Object you want to count the permutations of.
	 * @return a integer containing the PermutationCount
	 */
	public static int countPermutationsDistinct(I_Permutable<?> input) {
		return permObjDistinct(input)
				.size();
	}
}
