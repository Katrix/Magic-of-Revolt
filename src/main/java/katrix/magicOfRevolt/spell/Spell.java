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
import java.util.function.Consumer;

import com.google.common.collect.ImmutableList;

import katrix.magicOfRevolt.spell.object.SpellObject;
import net.minecraft.command.CommandResultStats.Type;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.INBTSerializable;

public abstract class Spell implements ICommandSender, INBTSerializable<NBTTagCompound> {

	public static final String NBT_INPUTS = "inputs";
	public static final String NBT_KEY = "key";
	public static final String NBT_VALUE = "value";
	public static final String NBT_ID = "id";
	
	public int ticksUpdated = 0;
	public int ticksExecuted = 0;
	
	protected World world;
	public ISpellActivator activator;
	
	protected boolean warmupDone;
	protected boolean executeDone;

	private Map<Integer, Spell> inputs = new HashMap<>();
	
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
		
		if(warmupDone || ticksUpdated > getWarmup()) {
			updateChild();
			warmupDone = true;
		}

		if (isWarmupComplete() && !isExecuteComplete()) {
			try {
				execute();
			}
			catch (SpellException e) {
				activator.disable();
				//activator.getPlayer().sendMessage("spell.exception." + e.getMessage());
				if(e.getExplosion()) {
					Vec3d pos = activator.getPosition();
					int cost = getTotalMindCost();
					world.createExplosion(null, pos.xCoord, pos.yCoord, pos.zCoord, 20F / cost, cost > 100);
				}
			}
		}
	}

	public void updateChild() {
		getInputs().forEach(Spell::onUpdate);
	}

	public boolean isWarmupComplete() {
		if(warmupDone) {
			for(Spell spell : getInputs()) {
				if(!spell.isWarmupComplete())
					return false;
			}
			return true;
		}
		return false;
	}
	
	public boolean isExecuteComplete() {
		if(executeDone) {
			for(Spell spell : getInputs()) {
				if(!spell.isExecuteComplete()) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public void execute() throws SpellException {
		ticksExecuted++;
		executeDone = true;
		renderParticle();
	}
	
	//TODO: Change to abstract once I have particles set up
	public void renderParticle() {
		
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
	
	public void forEachChildSpell(Consumer<Spell> consumer) {
		consumer.accept(this);
		for (Spell spell : getInputs()) {
			spell.forEachChildSpell(consumer);
		}
	}
	
	public void setActivatorTree(ISpellActivator activator) {
		forEachChildSpell(spell -> spell.setActivator(activator));
	}
	
	public void cancelSpell() {
		forEachChildSpell(spell -> spell.executeDone = true);
	}

	public List<Spell> getInputs() {
		return ImmutableList.copyOf(inputs.values());
	}

	public List<Integer> getInputKeys() {
		return ImmutableList.copyOf(inputs.keySet());
	}
	
	public Spell setInput(Spell spell, int index) {
		if(inputs.containsKey(index)) {
			inputs.remove(index);
		}
		
		inputs.put(index, spell);
		return this;
	}
	
	public Spell getInput(int index) {
		return inputs.get(index);
	}
	
	@SuppressWarnings("unchecked")
	protected <T extends SpellObject> T getVariable(int index) throws SpellException {
		T var;
		try {
			var = ((ISpellVariable<?, T>)getInput(index)).getVariable();
		}
		catch (Exception e) {
			throw new SpellException(SpellException.CAST_ERROR, e);
		}
		return var;
	}

	public String getSpellName() {
		return SpellRegistry.getStringFromClass(this.getClass());
	}

	public void setActivator(ISpellActivator activator) {
		this.activator = activator;
	}

	@Override
	public String getName() {
		return I18n.translateToLocal("spell." + getSpellName() + ".name");
	}

	@Override
	public ITextComponent getDisplayName() {
		ITextComponent chatcomponenttext = new TextComponentString(getName());
		//chatcomponenttext.getChatStyle().setChatHoverEvent(this.getHoverEvent());
		//chatcomponenttext.getChatStyle().setInsertion(this.getUniqueID().toString());
		return chatcomponenttext;
	}

	@Override
	public void addChatMessage(ITextComponent component) {
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
	public Vec3d getPositionVector() {
		return new Vec3d(0D, 0D, 0D);
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
	public MinecraftServer getServer() {
		return world.getMinecraftServer();
	}

	@Override
	public NBTTagCompound serializeNBT() {
		NBTTagCompound tag = new NBTTagCompound();

		List<Spell> inputValues = getInputs();
		List<Integer> inputKey = getInputKeys();
		NBTTagList inputs = new NBTTagList();

		for (int i = 0; i < inputValues.size(); i++) {
			Spell spell = inputValues.get(i);
			int key = inputKey.get(i);
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
			int index = entry.getInteger(NBT_KEY);
			this.inputs.put(index, spell);
		}
	}
	
	@Override
	public String toString() {
		return "Spell [getSpellName()=" + getSpellName() + ", world=" + world + ", activator=" + activator + ", ticksUpdated=" + ticksUpdated + ", ticksExecuted=" + ticksExecuted + ", warmupDone="
				+ warmupDone + ", executeDone=" + executeDone + ", getWarmup()=" + getWarmup() + ", getMindCost()=" + getMindCost() + "]";
	}
}
