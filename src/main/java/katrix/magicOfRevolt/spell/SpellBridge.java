/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell;

import katrix.magicOfRevolt.spell.object.SpellObject;
import net.minecraft.world.World;

public class SpellBridge extends Spell implements ISpellVariable<SpellBridge, SpellObject> {

	private static final String BRIDGE_NAME = "bridge";
	
	public SpellBridge(World world) {
		super(world);
		setInput(BRIDGE_NAME, new SpellDummy(world), Side.UP_RIGHT);
	}
	
	@Override
	public SpellObject getVariable() {
		return (SpellObject)getInput(BRIDGE_NAME);
	}

	@Override
	public SpellBridge getSpell() {
		return this;
	}
}
