/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt;

import katrix.magicOfRevolt.spell.SpellOutput;
import katrix.magicOfRevolt.spell.SpellRegistry;
import katrix.magicOfRevolt.spell.functional.acting.SpellAddMotion;
import katrix.magicOfRevolt.spell.functional.acting.SpellExplosion;
import katrix.magicOfRevolt.spell.object.SpellBlockPos;
import katrix.magicOfRevolt.spell.object.SpellEntity;
import katrix.magicOfRevolt.spell.object.SpellLiving;
import katrix.magicOfRevolt.spell.object.primitive.SpellFloat;
import katrix.magicOfRevolt.spell.object.primitive.SpellVoid;
import katrix.magicOfRevolt.spell.variable.SpellVectorFromLook;

public class CommonProxy {

	public void registerModels() {
		//NO-OP
	}
	
	public void registerSpells() {
		SpellRegistry.register(SpellBlockPos.class, "objectBlockPos", MagicOfRevolt.instance);
		SpellRegistry.register(SpellFloat.class, "objectFloat", MagicOfRevolt.instance);
		SpellRegistry.register(SpellExplosion.class, "explosion", MagicOfRevolt.instance);
		SpellRegistry.register(SpellOutput.class, "output", MagicOfRevolt.instance);
		SpellRegistry.register(SpellVoid.class, "void", MagicOfRevolt.instance);
		SpellRegistry.register(SpellEntity.class, "objectEntity", MagicOfRevolt.instance);
		SpellRegistry.register(SpellLiving.class, "objectLiving", MagicOfRevolt.instance);
		SpellRegistry.register(SpellVectorFromLook.class, "lookVec", MagicOfRevolt.instance);
		SpellRegistry.register(SpellAddMotion.class, "addMotion", MagicOfRevolt.instance);
	}
}
