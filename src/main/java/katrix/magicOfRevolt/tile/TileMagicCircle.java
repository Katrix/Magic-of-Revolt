/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.tile;

import java.util.List;
import java.util.Optional;

import katrix.magicOfRevolt.container.ContainerHexagonSpellCreation;
import katrix.magicOfRevolt.lib.LibGuiID;
import katrix.magicOfRevolt.spell.ISpellActivator;
import katrix.magicOfRevolt.spell.Spell;
import katrix.magicOfRevolt.spell.SpellOutput;
import katrix.magicOfRevolt.spell.compiler.ISpellCompiler;
import katrix.magicOfRevolt.spell.compiler.ISpellContainer;
import katrix.magicOfRevolt.spell.compiler.hexagon.HexagonSpellCompiler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;

public class TileMagicCircle extends TileEntity implements ITickable, ISpellActivator, IInteractionObject {

	private HexagonSpellCompiler spellCompiler;
	private List<SpellOutput> compiled;
	private boolean active;

	public TileMagicCircle() {
		spellCompiler = new HexagonSpellCompiler(worldObj);
	}

	@Override
	public Optional<ISpellCompiler> getSpellCompiler() {
		return Optional.of(spellCompiler);
	}

	@Override
	public void activate() {
		active = true;
		compiled = spellCompiler.compile();
		compiled.forEach(spellOutput -> spellOutput.setActivatorTree(this));
	}

	@Override
	public void disable() {
		active = false;
		compiled = null;
	}

	@Override
	public void update() {
		if(active) {
			compiled.forEach(Spell::onUpdate);
		}
	}

	@Override
	public void sendUpdate(ISpellContainer container) {
		//TODO
	}

	@Override
	public void sendCompiler() {
		//TODO Find out how to send description packet
		markDirty();
	}

	@Override
	public Packet<?> getDescriptionPacket() {
		return new SPacketUpdateTileEntity(pos, 1, spellCompiler.serializeNBT());
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		spellCompiler.deserializeNBT(pkt.getNbtCompound());
	}

	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
		return oldState.getBlock() != newSate.getBlock();
	}

	@Override
	public Vec3d getPosition() {
		BlockPos pos = getPos();
		return new Vec3d(pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public Container createContainer(InventoryPlayer invPlayer, EntityPlayer player) {
		return new ContainerHexagonSpellCreation(player, worldObj, pos);
	}

	@Override
	public String getGuiID() {
		return String.valueOf(LibGuiID.SPELLSLINGER_CREATION); //TODO: Right?
	}

	@Override
	public String getName() {
		return "Spell Hex Creation"; //TODO
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	@Override
	public ITextComponent getDisplayName() {
		return null; //TODO
	}

	public void setSpellAtPoint(Spell spell, int x, int y) {
		spellCompiler.setSpellAtPoint(spell, x, y);
	}
}
