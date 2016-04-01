/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.compiler;

import java.util.List;

import katrix.magicOfRevolt.spell.SpellOutput;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.items.IItemHandlerModifiable;

/**
 * Something that has several {@link ISpellContainer}s, and can compile them into a working list of {@link SpellOutput}
 */
public interface ISpellCompiler extends ICapabilitySerializable<NBTTagCompound>, IItemHandlerModifiable {

	/**
	 * Compile the spell from all the {@link ISpellContainer}
	 * @return A list of {@link SpellOutput} to execute the spell.
	 */
	List<SpellOutput> compile();

	/**
	 * Set the {@link ISpellContainer} for the specific Id.
	 * @param id The id to set the container for. This needs to already exist.
	 * @param container The container to set. Do note that the container might be converted to the correct type of object.
	 */
	void setContainerForId(int id, ISpellContainer container);

	/**
	 * @param id The id to get the container for.
	 * @return The parameter stored at the specific id. This method is NOT guaranteed to return the same as you set when using
	 * {@link #setContainerForId(int, ISpellContainer)}. The spell will be the same, but other data can be lost.
	 */
	ISpellContainer getContainerForId(int id);

}
