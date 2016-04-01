package katrix.magicOfRevolt.spell;

public class SpellException extends Exception {
	
	public static final String CAST_ERROR = "cast";
	public static final String INFINITE_LOOP = "infiniteLoop";
	public static final String MISSING_ARGUMENTS = "missingArgument";
	private boolean explosion = false;
	private float strength;
	
	public SpellException(String arg0) {
		super(arg0);
	}
	
	public SpellException(String arg0, boolean explosion, float strength) {
		super(arg0);
		this.explosion = explosion;
		this.strength = strength;
	}
	
	public SpellException(String arg0, Throwable cause) {
		super(arg0, cause);
	}
	
	public SpellException(String arg0, Throwable cause, boolean explosion, float strength) {
		super(arg0, cause);
		this.explosion = explosion;
		this.strength = strength;
	}
	
	public boolean getExplosion() {
		return explosion;
	}
	
	public float getStrength() {
		return strength;
	}
}
