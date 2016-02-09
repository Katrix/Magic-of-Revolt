/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;

import net.minecraft.command.CommandResultStats.Type;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.INBTSerializable;

public abstract class Spell implements ICommandSender, INBTSerializable<NBTTagCompound> {

	private Map<Integer, Spell> inputs = new HashMap<>();
	protected World world;
	protected ISpellActivator activator;
	public int ticksUpdated = 0;
	public int ticksExecuted = 0;
	protected boolean warmupDone;
	protected boolean executeDone;

	public static final String NBT_INPUTS = "inputs";
	public static final String NBT_KEY = "key";
	public static final String NBT_VALUE = "value";
	public static final String NBT_ID = "id";

	public Spell(World world) {
		this.world = world;
	}

	protected Spell(Spell spell) {
		inputs = spell.inputs;
		world = spell.world;
		activator = spell.activator;
		ticksUpdated = spell.ticksUpdated;
		ticksExecuted = spell.ticksExecuted;
		warmupDone = spell.warmupDone;
		executeDone = spell.executeDone;
	}

	public void onUpdate() {
		ticksUpdated++;
		
		if (warmupDone || ticksUpdated > getWarmup()) {
			updateChild();
			warmupDone = true;
		}

		if (isWarmupComplete() && !executeDone) {
			execute();
		}
	}

	public void updateChild() {
		for (Spell spell : getInputs()) {
			spell.onUpdate();
		}
	}

	public boolean isWarmupComplete() {
		if (ticksUpdated > getWarmup()) {
			for (Spell spell : getInputs()) {
				if (!spell.isWarmupComplete() || !spell.warmupDone)
					return false;
			}
		}
		else
			return false;
		
		return true;
	}

	public void execute() {
		ticksExecuted++;
		executeDone = true;
		renderParticle();
	}
	
	//TODO: Change to abstract once I have particles set up
	public void renderParticle() {
		
	}

	public void fizzle(String reason) {
		IChatComponent message = new ChatComponentTranslation("spell.fizzle." + reason, new Object[0]);
		addChatMessage(message);
		int mindCost = getMindCost();
		Vec3 pos = activator.getPosistion();
		world.createExplosion(null, pos.xCoord, pos.yCoord, pos.zCoord, mindCost /20F, mindCost > 100 ? true : false);
	}

	public void fizzleParameters() {
		fizzle("parameters");
	}

	public int getWarmup() {
		return 2;
	}

	public int getMindCost() {
		return 5;
	}

	public int getTotalMindCost() {
		int total = getMindCost();
		for (Spell spell : getInputs()) {
			total += spell.getMindCost();
		}
		return total;
	}

	public int getTotalWarmup() {
		int total = getWarmup();
		for (Spell spell : getInputs()) {
			total += spell.getWarmup();
		}
		return total;
	}

	public List<Spell> getInputs() {
		return ImmutableList.copyOf(inputs.values());
	}

	public List<Integer> getKeys() {
		return ImmutableList.copyOf(inputs.keySet());
	}

	protected void setInput(int index, Spell spell) {
		inputs.put(index, spell);
	}

	public String getSpellName() {
		return SpellRegistry.getStringFromClass(this.getClass());
	}

	public void setActivator(ISpellActivator activator) {
		this.activator = activator;
	}

	@Override
	public String getName() {
		return StatCollector.translateToLocal("spell." + getSpellName() + ".name");
	}

	@Override
	public IChatComponent getDisplayName() {
		ChatComponentText chatcomponenttext = new ChatComponentText(getName());
		//chatcomponenttext.getChatStyle().setChatHoverEvent(this.getHoverEvent());
		//chatcomponenttext.getChatStyle().setInsertion(this.getUniqueID().toString());
		return chatcomponenttext;
	}

	@Override
	public void addChatMessage(IChatComponent component) {
	}

	@Override
	public boolean canCommandSenderUseCommand(int permLevel, String commandName) {
		return false;
	}

	@Override
	public BlockPos getPosition() {
		return new BlockPos(0D, 0D, 0D);
	}

	@Override
	public Vec3 getPositionVector() {
		return new Vec3(0D, 0D, 0D);
	}

	@Override
	public World getEntityWorld() {
		return world;
	}

	@Override
	public Entity getCommandSenderEntity() {
		return null;
	}

	@Override
	public boolean sendCommandFeedback() {
		return false;
	}

	@Override
	public void setCommandStat(Type type, int amount) {
	}

	@Override
	public NBTTagCompound serializeNBT() {
		NBTTagCompound tag = new NBTTagCompound();

		List<Spell> value = getInputs();
		List<Integer> keys = getKeys();
		NBTTagList inputs = new NBTTagList();

		for (int i = 0; i < value.size(); i++) {
			Spell spell = value.get(i);
			int key = keys.get(i);
			NBTTagCompound entry = new NBTTagCompound();

			entry.setInteger(NBT_KEY, key);
			entry.setTag(NBT_VALUE, spell.serializeNBT());
			inputs.appendTag(entry);
		}

		tag.setTag(NBT_INPUTS, inputs);
		tag.setString(NBT_ID, SpellRegistry.getStringFromClass(this.getClass()));
		return tag;
	}

	@Override
	public void deserializeNBT(NBTTagCompound tag) {
		NBTTagList inputs = tag.getTagList(NBT_INPUTS, Constants.NBT.TAG_COMPOUND);
		for (int i = 0; i < inputs.tagCount(); i++) {
			NBTTagCompound entry = inputs.getCompoundTagAt(i);
			NBTTagCompound value = entry.getCompoundTag(NBT_VALUE);
			Spell spell = SpellRegistry.createSpellFromNBT(value, world);
			this.inputs.put(entry.getInteger(NBT_KEY), spell);
		}
	}
	
	@Override
	public String toString() {
		return "Spell [getSpellName()=" + getSpellName() + ", world=" + world + ", activator=" + activator + ", ticksUpdated=" + ticksUpdated + ", ticksExecuted=" + ticksExecuted + ", warmupDone="
				+ warmupDone + ", executeDone=" + executeDone + ", getWarmup()=" + getWarmup() + ", getMindCost()=" + getMindCost() + "]";
	}
}
