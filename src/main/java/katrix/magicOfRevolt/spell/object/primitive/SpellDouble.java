/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.object.primitive;

import katrix.magicOfRevolt.spell.object.SpellObject;

public class SpellDouble extends SpellObject {

	private double spellDouble;
	
	public SpellDouble() {}

	private SpellDouble(SpellDouble spellDouble) {
		this.spellDouble = spellDouble.spellDouble;
	}

	@Override
	public SpellDouble copy() {
		return new SpellDouble(this);
	}

	public double getDouble() {
		return spellDouble;
	}

	public void setDouble(double spellDouble) {
		this.spellDouble = spellDouble;
	}
}
