/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.compiler;

import javax.annotation.Nonnull;

import katrix.magicOfRevolt.spell.Spell;

/**
 * Something that can hold a spell, and some other data. A part of {@link ISpellCompiler}
 */
public interface ISpellContainer {

	int getId();

	@Nonnull
	Spell getSpell();

	void setSpell(@Nonnull Spell spell);
}
