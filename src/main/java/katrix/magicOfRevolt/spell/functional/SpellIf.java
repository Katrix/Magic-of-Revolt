/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 * 
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.functional;

import katrix.magicOfRevolt.spell.ISpellVariable;
import katrix.magicOfRevolt.spell.SpellRegistry;
import katrix.magicOfRevolt.spell.object.primitive.SpellBoolean;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class SpellIf extends SpellFunctional {
	
	public SpellIf(World world) {
		super(world);
	}

	private SpellFunctional spell1;
	private SpellFunctional spell2;
	private boolean condition;
	private static final int SPELL1_INDEX = 0;
	private static final int SPELL2_INDEX = 1;
	private static final int CONDITION_INDEX = 2;
	
	public static final String NBT_SPELL1 = "spell1";
	public static final String NBT_SPELL2 = "spell2";
	public static final String NBT_CONDITION = "condition";

	@Override
	public void execute() {
		super.execute();
		if(condition) {
			spell1.execute();
		}
		else if(spell2 != null) {
			spell2.execute();
		}
		warmupDone = true;
	}
	
	public SpellIf setSpell1(SpellFunctional spell) {
		this.spell1 = spell;
		setInput(SPELL1_INDEX, spell);
		return this;
	}
	
	public SpellIf setSpell2(SpellFunctional spell) {
		this.spell2 = spell;
		setInput(SPELL2_INDEX, spell);
		return this;
	}
	
	public SpellIf setCondition(ISpellVariable<?, SpellBoolean> condition) {
		this.condition = condition.getVariable().getBoolean();
		setInput(CONDITION_INDEX, condition.getSpell());
		return this;
	}
	
	@Override
    public NBTTagCompound serializeNBT() {
    	NBTTagCompound tag = super.serializeNBT();
    	tag.setTag(NBT_SPELL1, spell1.serializeNBT());
    	tag.setTag(NBT_SPELL2, spell2.serializeNBT());
    	tag.setBoolean(NBT_CONDITION, condition);
		return tag;
	}
    
	@Override
    public void deserializeNBT(NBTTagCompound tag) {
    	super.deserializeNBT(tag);
    	spell1 = (SpellFunctional)SpellRegistry.createSpellFromNBT(tag.getCompoundTag(NBT_SPELL1), world);
    	spell2 = (SpellFunctional)SpellRegistry.createSpellFromNBT(tag.getCompoundTag(NBT_SPELL2), world);
    	condition = tag.getBoolean(NBT_CONDITION);
	}
}
