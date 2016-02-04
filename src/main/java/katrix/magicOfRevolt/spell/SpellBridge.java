package katrix.magicOfRevolt.spell;

import katrix.magicOfRevolt.spell.object.SpellObject;

public class SpellBridge extends Spell implements ISpellVariable<SpellBridge, SpellObject> {

	private SpellObject bridgeObject;
	private static final int BRIDGE_INDEX = 0;

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
}
