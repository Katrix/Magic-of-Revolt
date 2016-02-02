/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 * 
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell;

public abstract class Spell {
	
	protected int warmup;
	protected int mindCost;
	
	public void fizzle(String reason) {
		
	}
	
	public void fizzleParameters() {
		fizzle("Not all parameters set");
	}
	
	public int getWarmup() {
		return warmup;
	}
	
	public int getMindCost() {
		return mindCost;
	}
}
