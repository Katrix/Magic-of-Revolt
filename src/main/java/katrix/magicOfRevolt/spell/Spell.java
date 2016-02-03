/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

import net.minecraft.command.CommandResultStats.Type;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class Spell implements ICommandSender {

	protected int warmup;
	protected int mindCost;
	protected List<Spell> inputs = new ArrayList<Spell>();
	
	protected String name = "spell";
	protected World world;
	
	public Spell() {}

	protected Spell(Spell spell) {
		warmup = spell.warmup;
		mindCost = spell.mindCost;
	}

	public void fizzle(String reason) {
		IChatComponent message = new ChatComponentTranslation("spell.fizzle." + reason, new Object[0]);
		this.addChatMessage(message);
	}

	public void fizzleParameters() {
		fizzle("parameters");
	}
	
	public Spell calculateCost() {
		for(Spell spell : this.getInputs()) {
			if(spell != null) {
				spell.calculateCost();
				this.mindCost += spell.mindCost;
				this.warmup += spell.warmup;
			}
		}
		return this;
	}
	
	public Spell runSpell(Spell parent) {
		for(Spell spell : this.getInputs()) {
			if(spell != null) {
				spell.runSpell(this);
			}
			else {
				fizzleParameters();
			}
		}
		return this;
	}

	public int getWarmup() {
		return warmup;
	}

	public int getMindCost() {
		return mindCost;
	}
	
	public List<Spell> getInputs() {
		return ImmutableList.copyOf(inputs);
	}
	
	@Override
	public String getName() {
		return StatCollector.translateToLocal("spell." + name + ".name");
	}

	@Override
	public IChatComponent getDisplayName() {
        ChatComponentText chatcomponenttext = new ChatComponentText(this.getName());
        //chatcomponenttext.getChatStyle().setChatHoverEvent(this.getHoverEvent());
        //chatcomponenttext.getChatStyle().setInsertion(this.getUniqueID().toString());
        return chatcomponenttext;
	}

	@Override
	public void addChatMessage(IChatComponent component) {}

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
		if(world != null) {
			return world;
		}
		else {
			return MinecraftServer.getServer().getEntityWorld();
		}
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
	public void setCommandStat(Type type, int amount) {}
}
