/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.object.primitive;

import katrix.magicOfRevolt.spell.ICopyable;
import katrix.magicOfRevolt.spell.ISpellVariable;
import katrix.magicOfRevolt.spell.object.SpellObject;

//Yes, I know that a String is technically not a primitive, but I still put it here for convenience sake.
public class SpellString extends SpellObject implements ISpellVariable<SpellString, SpellString>, ICopyable<SpellString> {

	private String string;

	public SpellString() {
	}

	private SpellString(SpellString string) {
		this.string = string.string;
	}

	@Override
	public SpellString copy() {
		return new SpellString(this);
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	@Override
	public SpellString getVariable() {
		return this;
	}

	@Override
	public SpellString getSpell() {
		return this;
	}
}
