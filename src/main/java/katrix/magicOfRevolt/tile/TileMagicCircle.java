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

import katrix.magicOfRevolt.spell.ISpellActivator;
import katrix.magicOfRevolt.spell.Spell;
import katrix.magicOfRevolt.spell.SpellOutput;
import katrix.magicOfRevolt.spell.container.ISpellContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TileMagicCircle extends TileEntity implements ITickable, ISpellActivator {
	
	private ISpellContainer container;
	private List<SpellOutput> compiled;
	private boolean active;

	public TileMagicCircle() {
	}
	
	@Override
	public void setSpellContainer(ISpellContainer spell) {
		this.container = spell;
	}
	
	public ISpellContainer getContainer() {
		return container;
	}
	
	@Override
	public void activate() {
		active = true;
		compiled = container.compile();
		for(Spell spell : compiled) {
			spell.setActivator(this);
		}
	}
	
	public void disable() {
		active = false;
	}

	@Override
	public void update() {
		if(active) {
			for(Spell spell: compiled) {
				spell.onUpdate();
			}
		}
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
		return oldState.getBlock() != newSate.getBlock();
	}

	@Override
	public Vec3d getPosistion() {
		BlockPos pos = getPos();
		return new Vec3d(pos.getX(), pos.getY(), pos.getZ());
	}
}
