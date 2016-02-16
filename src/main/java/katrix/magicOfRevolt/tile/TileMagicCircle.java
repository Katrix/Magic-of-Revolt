/**
 * This class was created by <Katrix>. It's distributed as
 * part of the Magic of Revolt Mod. Get the Source Code in github:
 * https://github.com/Katrix-/Magic-of-Revolt
 *
 * Magic of Revolt is Open Source and distributed under the
 * Botania license: https://github.com/Katrix-/Magic-of-Revolt/blob/master/LICENSE.md
 */
package katrix.magicOfRevolt.tile;

import katrix.magicOfRevolt.spell.ISpellActivator;
import katrix.magicOfRevolt.spell.SpellHexagon;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ITickable;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class TileMagicCircle extends TileEntity implements ITickable, ISpellActivator {
	
	private SpellHexagon spell;
	private boolean active;

	public TileMagicCircle() {
	}
	
	@Override
	public void setSpellHex(SpellHexagon spell) {
		this.spell = spell;
		this.spell.setActivator(this);
	}
	
	public SpellHexagon getSpell() {
		return spell;
	}
	
	@Override
	public void activate() {
		active = true;
	}
	
	public void disable() {
		active = false;
	}

	@Override
	public void update() {
		if(active) {
			spell.onUpdate();
		}
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
		return oldState.getBlock() != newSate.getBlock();
	}

	@Override
	public Vec3 getPosistion() {
		BlockPos pos = getPos();
		return new Vec3(pos.getX(), pos.getY(), pos.getZ());
	}
}
