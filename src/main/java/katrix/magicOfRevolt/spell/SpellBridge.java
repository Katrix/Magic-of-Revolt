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

	private static final int BRIDGE_INDEX = 0;

	public SpellBridge(World world) {
		super(world);
		setInput(new SpellDummy(world), BRIDGE_INDEX);
	}

	@Override
	public SpellObject getVariable() {
		return (SpellObject)getInput(BRIDGE_INDEX);
	}

	@Override
	public SpellBridge getSpell() {
		return this;
	}
}
