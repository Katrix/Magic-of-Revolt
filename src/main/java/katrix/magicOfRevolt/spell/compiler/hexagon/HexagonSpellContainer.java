/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.compiler.hexagon;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;

import com.google.common.collect.ImmutableMap;

import katrix.magicOfRevolt.spell.Spell;
import katrix.magicOfRevolt.spell.SpellDummy;
import katrix.magicOfRevolt.spell.SpellRegistry;
import katrix.magicOfRevolt.spell.compiler.ISpellContainer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.util.INBTSerializable;

public class HexagonSpellContainer implements INBTSerializable<NBTTagCompound>, ISpellContainer {

	private static final String NBT_SPELL = "spell";
	@SuppressWarnings("NullableProblems")
	@Nonnull //Why is this a problem? I can't see where the spell would be null
	private Spell spell;
	private Map<HexagonSide, Integer> connections = new HashMap<>();
	private World world;
	private final int id;

	HexagonSpellContainer(@Nonnull Spell spell, int id) {
		this.spell = spell;
		world = spell.getEntityWorld();
		this.id = id;
	}

	HexagonSpellContainer(NBTTagCompound tag, World world, int id) {
		this.world = world;
		deserializeNBT(tag);
		this.id = id;
	}

	@Nonnull
	@Override
	public Spell getSpell() {
		return spell;
	}

	@Override
	public void setSpell(@Nonnull Spell spell) {
		this.spell = spell;
	}

	public Map<HexagonSide, Integer> getConnections() {
		return ImmutableMap.copyOf(connections);
	}

	public void addConnection(HexagonSide side, int state) {
		connections.put(side, state);
	}

	public void removeConnection(HexagonSide side) {
		connections.remove(side);
	}

	@Override
	public NBTTagCompound serializeNBT() {
		NBTTagCompound tag = new NBTTagCompound();
		tag.setTag(NBT_SPELL, spell.serializeNBT());
		//TODO: Do connections
		return tag;
	}

	@Override
	public void deserializeNBT(NBTTagCompound tag) {
		spell = SpellRegistry.createSpellFromNBT(tag.getCompoundTag(NBT_SPELL), world);
		if(spell == null) {
			spell = new SpellDummy(world);
		}
		//TODO: Do connections
	}

	@Override
	public int getId() {
		return id;
	}
}