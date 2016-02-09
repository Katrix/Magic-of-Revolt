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

public class SpellDo extends SpellFunctional {
	
	public SpellDo(World world) {
		super(world);
	}

	private SpellFunctional spell;
	private boolean condition;
	private static final int SPELL_INDEX = 0;
	private static final int CONDITION_INDEX = 1;
	
	public static final String NBT_SPELL = "spell";
	public static final String NBT_CONDITION = "condition";
	
	private int limit = 0;

	@Override
	public void execute() {
		super.execute();
		do {
			spell.execute();
			limit++;
		} while (condition && limit < 1000);
		
		if(limit >= 1000) {
			fizzle("infiniteLoop");
		}
		warmupDone =true;
	}
	
	public SpellDo setSpell1(SpellFunctional spell) {
		this.spell = spell;
		setInput(SPELL_INDEX, spell);
		return this;
	}
	
	public SpellDo setCondition(ISpellVariable<?, SpellBoolean> condition) {
		this.condition = condition.getVariable().getBoolean();
		setInput(CONDITION_INDEX, condition.getSpell());
		return this;
	}
	
	@Override
    public NBTTagCompound serializeNBT() {
    	NBTTagCompound tag = super.serializeNBT();
    	tag.setTag(NBT_SPELL, spell.serializeNBT());
    	tag.setBoolean(NBT_CONDITION, condition);
		return tag;
	}
    
	@Override
    public void deserializeNBT(NBTTagCompound tag) {
    	super.deserializeNBT(tag);
    	spell = (SpellFunctional)SpellRegistry.createSpellFromNBT(tag.getCompoundTag(NBT_SPELL), world);
    	condition = tag.getBoolean(NBT_CONDITION);
	}
}
