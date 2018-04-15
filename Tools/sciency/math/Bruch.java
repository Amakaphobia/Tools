package math;

import java.util.stream.IntStream;

import boxes.Pair;

/**
 * Klasse um Brüche Darzustellen. Um einen Bruch zu initialisieren
 * wird die statische Methode buildBruch(zähler, nenner) genutzt.
 * der bruch wird automatisch soweit wie möglich gekürzt.
 * 
 * @author hdaiv_000
 * @since 0.13
 */
public class Bruch extends Number implements Comparable<Bruch>{

	/**serial*/
	private static final long serialVersionUID = -7814378271244012625L;
	/**Zähler */
	private double zaehler;
	/**Nenner*/
	private double nenner;
	
	/**
	 * private Constructor
	 * @param z	der zähler
	 * @param n der nenner
	 */
	private Bruch(Number z, Number n) {
		if(n.doubleValue() == 0)
			throw new RuntimeException("Teilen durch Null geht nicht!");
		this.zaehler = z.doubleValue();		
		this.nenner = n.doubleValue();
	}
	
	/**
	 * Statische Method die anstelle des Konstruktors genutzt werden sollte
	 * @param z zähler
	 * @param n nenner
	 * @return der gewünschte und gekürzte Bruch
	 */
	public static Bruch buildBruch(Number z, Number n) {
		return new Bruch(z,n).shorten();
	}
	
	/**
	 * Methode die benutzt wird um zwei Brüche miteinander zu multiplizieren
	 * @param other der bruch der mit dism multipliziert werden soll
	 * @return der neue Bruch
	 */
	public Bruch multiply(Bruch other) {
		return new Bruch(
				this.zaehler * other.getZaehler(),
				this.nenner * other.getNenner()
				)
				.shorten();
	}
	
	/**
	 * Methode die genutzt wird um den Bruch zu invertieren
	 * @return der invertierte Bruch
	 */
	public Bruch inverse() {
		return Bruch.buildBruch(this.nenner, this.zaehler);
	}
	
	/**
	 * Methode die benutzt wird um zwei Brüche durcheinander zu teilen
	 * @param Other der bruch der mit dism geteilt werden soll
	 * @return der neue Bruch
	 */
	public Bruch divide(Bruch Other) {
		return this.multiply(Other.inverse()).shorten();
	}
	
	/**
	 * Methode die benutzt wird um zwei Brüche miteinander zu addieren
	 * @param other der bruch der mit diesem addiert werden soll
	 * @return der neue Bruch
	 */
	public Bruch add(Bruch other) {
		double z = this.zaehler * other.getNenner() 
			  + other.getZaehler() * this.nenner;
		double n = this.nenner * other.getNenner();
		return new Bruch(z,n).shorten();
	}
	
	/**
	 * Methode die benutzt wird um zwei Brüche miteinander zu subtrahieren
	 * @param other der bruch der von diesem abgezogen werden soll
	 * @return der neue Bruch
	 */
	public Bruch substract(Bruch other) {
		double z = this.zaehler * other.getNenner() 
			  - other.getZaehler() * this.nenner;
		double n = this.nenner * other.getNenner();
		return new Bruch(z,n).shorten();
	}
	
	/**
	 * Methode die genutzt wird um den bruch zu kürzen
	 * @return der neue Bruch
	 */
	public Bruch shorten() {
		Pair<Double, Double> p = this.zaehler > this.nenner 
				?new Pair<>(this.nenner, this.zaehler)
				:new Pair<>(this.zaehler, this.nenner);
		double teiler =
			IntStream.rangeClosed(0,p.getKey().intValue())
				.filter(zahl -> this.nenner % zahl == 0)
				.filter(zahl -> this.zaehler % zahl == 0)
				.max()
				.orElse(1);
		
		if(teiler != 1)
			return new Bruch(
					this.zaehler / teiler,
					this.nenner / teiler);
		else
			return this;
	}
	
	/**
	 * Methode um den Wert des bruches auszugeben
	 * @return der wert als double
	 */
	public double value() {
		return this.zaehler / this.nenner;
	}

	/**
	 * getZähler
	 * @return der Zähler
	 */
	public double getZaehler() {
		return zaehler;
	}

	/**
	 * getNenner
	 * @return der Nenner
	 */
	public double getNenner() {
		return nenner;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		if(!(obj instanceof Bruch)) return false;
		
		Bruch other = (Bruch) obj;
		return this.zaehler == other.zaehler
			&&  this.nenner == other.nenner;
	}
	
	@Override
	public String toString() {
		return String.format("%s / %s", this.zaehler, this.nenner);
	}
	
	@Override
	public int hashCode() {
		return (int)(this.getNenner() + this.getZaehler()* this.getZaehler());
	}

	@Override
	public int compareTo(Bruch o) {
		if(this.equals(o)) return 0;
		return Double.compare(this.value(), o.value());
	}

	@Override
	public int intValue() { return (int)this.value(); }
	@Override
	public long longValue() { return (long)this.value(); }
	@Override
	public float floatValue() { return (float)this.value(); }
	@Override
	public double doubleValue() { return this.value(); }
}
