package katrix.magicOfRevolt.spell;

import katrix.magicOfRevolt.spell.object.SpellObject;

public class SpellBridge extends Spell {

	private SpellObject bridgeObject;
	private static final int BRIDGE_INDEX = 0;

	public SpellObject getBridgeObject() {
		return bridgeObject;
	}

	public void setBridgeObject(SpellObject bridgeObject) {
		this.bridgeObject = bridgeObject;
		inputs.set(BRIDGE_INDEX, bridgeObject);
	}
}
