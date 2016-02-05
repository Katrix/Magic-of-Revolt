package katrix.magicOfRevolt.spell;

import katrix.magicOfRevolt.spell.object.SpellObject;
import net.minecraft.nbt.NBTTagCompound;

public class SpellBridge extends Spell implements ISpellVariable<SpellBridge, SpellObject> {

	private SpellObject bridgeObject;
	private static final int BRIDGE_INDEX = 0;
	
	public static final String NBT_OBJECT = "bridgeObject";

	public void setBridgeObject(SpellObject bridgeObject) {
		this.bridgeObject = bridgeObject;
		addInput(BRIDGE_INDEX, bridgeObject);
	}
	
	@Override
	public SpellObject getVariable() {
		return bridgeObject;
	}

	@Override
	public SpellBridge getSpell() {
		return this;
	}
	
	@Override
    public NBTTagCompound serializeNBT() {
    	NBTTagCompound tag = super.serializeNBT();
    	tag.setTag(NBT_OBJECT, bridgeObject.serializeNBT());
		return tag;
	}
    
	@Override
    public void deserializeNBT(NBTTagCompound tag) {
    	super.deserializeNBT(tag);
    	bridgeObject = (SpellObject)Spell.getSpellFromNBT(tag.getCompoundTag(NBT_OBJECT));
	}
}
