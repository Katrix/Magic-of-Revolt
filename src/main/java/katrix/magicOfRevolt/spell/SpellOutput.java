/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell;

import net.minecraft.world.World;

public class SpellOutput extends Spell {

	public int limit = 6;

	public SpellOutput(World world) {
		super(world);
		for(int i = 0; i < limit; i++) {
			setInput(new SpellDummy(world), i);
		}
	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		if(isExecuteComplete()) {
			activator.disable();
		}
	}
}
