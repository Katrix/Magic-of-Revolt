/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell;

import java.util.Optional;

import katrix.magicOfRevolt.spell.compiler.ISpellCompiler;
import katrix.magicOfRevolt.spell.compiler.ISpellContainer;
import net.minecraft.util.math.Vec3d;

/**
 * Something that can activate a spell.
 */
public interface ISpellActivator {

	/**
	 * Called to activate the spell. When this is done, all the compiled spells must have their
	 * activator set to this.
	 */
	void activate();

	/**
	 * Opposite of {@link #activate()}. This should halt the execution of the spell immediately.
	 */
	void disable();

	/**
	 * Used to get where to put the explosion in case of spell failure.
	 *
	 * @return The location of this activator
	 */
	Vec3d getPosition();

	/**
	 * @return The compiler for this activator. May be null if the activator has no compiler.
	 */
	Optional<ISpellCompiler> getSpellCompiler();

	/**
	 * Used to send a partial update about the compiler, without sending the whole compiler itself.
	 *
	 * @param container The container to update.
	 */
	void sendUpdate(ISpellContainer container);

	/**
	 * Send a complete update with the whole compiler. In case some big change.
	 */
	void sendCompiler();

}
