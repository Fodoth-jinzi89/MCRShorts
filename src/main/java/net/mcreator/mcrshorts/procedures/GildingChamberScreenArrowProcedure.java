package net.mcreator.mcrshorts.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class GildingChamberScreenArrowProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "progress") > 0) {
			return (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "progress") / getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ticks")) * 19;
		}
		return 0;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}