/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.object.primitive;

import katrix.magicOfRevolt.spell.Spell;
import katrix.magicOfRevolt.spell.object.SpellObject;

//Not really a primitive. Used where you would normally use void or null. A real null is uses to specify that a input was never set.
public final class SpellVoid extends SpellObject {

	public static final SpellVoid spell = new SpellVoid();

	private SpellVoid() {
	}

	@Override
	public SpellObject copy() {
		return spell;
	}

	@Override
	public Spell runSpell(Spell parent) {
		return this;
	}

	@Override
	public Spell calculateCost() {
		return this;
	}
}
