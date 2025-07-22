
package net.mcreator.mcrshorts.block;

import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Mob;
import net.minecraft.core.BlockPos;

public class AncientDebrisLeavesBlock extends LeavesBlock {
	public AncientDebrisLeavesBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.AZALEA_LEAVES).strength(0.2f).noOcclusion().pushReaction(PushReaction.DESTROY));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 1;
	}

	@Override
	public PathType getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return PathType.LEAVES;
	}
}
