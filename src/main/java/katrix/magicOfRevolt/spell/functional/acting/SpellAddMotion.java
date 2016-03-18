/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.spell.functional.acting;

import katrix.magicOfRevolt.spell.SpellDummy;
import katrix.magicOfRevolt.spell.SpellException;
import katrix.magicOfRevolt.spell.object.SpellEntity;
import katrix.magicOfRevolt.spell.object.SpellVector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SpellAddMotion extends SpellTarget<SpellEntity> {

	public static final int VECTOR_INDEX = 1;

	public SpellAddMotion(World world) {
		super(world);
		setInput(new SpellDummy(world), VECTOR_INDEX);
	}

	@Override
	public void execute() throws SpellException {
		super.execute();
		if (!world.isRemote) {
			Entity entity = getTarget().getEntity();
			Vec3d vector = this.<SpellVector>getVariable(VECTOR_INDEX).getVector();
			entity.addVelocity(vector.xCoord, vector.yCoord, vector.zCoord);
			entity.posX += vector.xCoord;
			entity.posY += vector.yCoord;
			entity.posZ += vector.zCoord;
			if (entity instanceof EntityPlayer) {
				((EntityPlayerMP)entity).playerNetServerHandler.sendPacket(new SPacketEntityVelocity(entity));
			}
		}
	}
}
