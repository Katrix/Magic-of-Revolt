/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.net;

import katrix.magicOfRevolt.lib.LibMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class PacketHandler {

	private static final SimpleNetworkWrapper NET = NetworkRegistry.INSTANCE.newSimpleChannel(LibMod.MODID);

	public static void preInit() {}

	public static void sendTo(IMessage message, EntityPlayerMP player) {
		NET.sendTo(message, player);
	}

	public static void sendToAllNear(IMessage message, Entity entity, int range) {
		NET.sendToAllAround(message, new TargetPoint(entity.worldObj.provider.getDimension(), entity.posX, entity.posY, entity.posZ, range));
	}

	public static void sendToAllNear(IMessage message, BlockPos pos, int dimensionId, int range) {
		NET.sendToAllAround(message, new TargetPoint(dimensionId, pos.getX(), pos.getY(), pos.getZ(), range));
	}

	public static void sendToAllNear(IMessage message, Vec3d pos, int dimensionId, int range) {
		NET.sendToAllAround(message, new TargetPoint(dimensionId, pos.xCoord, pos.yCoord, pos.zCoord, range));
	}

	public static void sendToAll(IMessage message) {
		NET.sendToAll(message);
	}

	public static void sendToDimension(IMessage message, int dimensionId) {
		NET.sendToDimension(message, dimensionId);
	}
}
