package math;

import java.util.OptionalInt;

import boxes.Pair;

/**
 * A Pythagoran Triplet are 3 Integers abc with <code> a &lt; b &lt; c and a^2 + b^2 = c^2. </code>
 * a Triplet can be Instanciated via the constructor. Beware that you are able to instanciate triplets which are not valid.
 * to check if a triplet is valid use the Method {@link PythagronTriplet#isValid()}.
 * @author Dave
 * @since V0.14
 *
 */
public class PythagronTriplet {
	/**Pair of A and B*/
	private final Pair<Integer, Integer> AB;
	/**Optional Containing C if there is a C*/
	private final OptionalInt c;
	/**A Squared*/
	private final int a2;
	/**B Squared*/
	private final int b2;
	/**C Squared*/
	private final int c2;

	/**
	 * Constructor
	 * @param a a
	 * @param b b
	 */
	public PythagronTriplet(int a, int b) {
		this.AB = a < b ?
				new Pair<>(a,b) :
				new Pair<>(b,a);
		this.a2 = a * a;
		this.b2 = b * b;
		this.c2 = this.b2 + this.a2;
		double sqrt = Math.sqrt(this.c2);
		boolean test = sqrt % 1 == 0;
		this.c = test ? OptionalInt.of((int)sqrt) : OptionalInt.empty();
	}

	/**
	 * Used to get C or if it isn't present get a default value
	 * @param els default value
	 * @return C or the default value
	 */
	public int getCOrElse(int els) {
		return this.c.orElse(els);
	}

	/**
	 * Used to get A
	 * @return A
	 */
	public int getA() { return this.AB.getKey(); }
	/**
	 * Used to get B
	 * @return B
	 */
	public int getB() { return this.AB.getValue(); }
	/**
	 * Used to get C
	 * @return C
	 */
	public int getC() { return this.c.getAsInt(); }

	/**
	 * Checks if the triplet is a valid one.
	 * @return true if this triplet is valid
	 */
	public boolean isValid() {
		return this.c.isPresent()
			&&  this.getA() < this.getB()
			&&  this.getB() < this.getC();
	}

	@Override
	public int hashCode() {
		return this.getA() * this.getA() + this.getB() * this.getB();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		if(obj instanceof PythagronTriplet) {
			PythagronTriplet other = (PythagronTriplet) obj;
			return this.getA() == other.getA()
				&&  this.getB() == other.getB();
		}
		return false;
	}

	@Override
	public String toString() {
		return this.isValid() ? String.format("%s %s %s", this.getA(), this.getB(), this.c.getAsInt()) : "Not Valid";
	}
}
