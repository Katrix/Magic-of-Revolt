/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell;

import katrix.magicOfRevolt.spell.object.SpellObject;

/**
 * A spell that can hold some sort of object as a variable.
 * @param <T> The variable provider. Usually the spell itself.
 * @param <V> The variable object represented.
 */
public interface ISpellVariable<T extends Spell, V extends SpellObject> {

	/**
	 * @return The variable represented.
	 * @throws SpellException If something went wrong when getting the variable. For example if the variable provider is missing arguments.
	 */
	V getVariable() throws SpellException;

	/**
	 * @return The variable provider.
	 */
	T getSpell();
	
}
