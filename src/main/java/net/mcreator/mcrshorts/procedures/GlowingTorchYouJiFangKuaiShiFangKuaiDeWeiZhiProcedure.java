package net.mcreator.mcrshorts.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class GlowingTorchYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Direction dir, Entity entity,
			ItemStack stack, InteractionHand hand) {
		if (dir == null || dir == Direction.DOWN)
			return;

		BlockPos pos = BlockPos.containing(x, y, z);
		BlockPos targetPos = pos.relative(dir);

		// 尝试优先放置位置
		if (tryPlace(world, targetPos, dir, entity, stack, hand))
			return;

		// 尝试替换原方块并遍历方向
		if (world.getBlockState(pos).canBeReplaced()) {
			for (Direction d : Direction.values()) {
				if (d != Direction.DOWN && tryPlace(world, pos, d, entity, stack, hand))
					return;
			}
		}
	}

	private static boolean tryPlace(LevelAccessor world, BlockPos pos, Direction dir, Entity entity, ItemStack stack,
			InteractionHand hand) {
		BlockState state = dir == Direction.UP ? Blocks.TORCH.defaultBlockState()
				: Blocks.WALL_TORCH.defaultBlockState().setValue(net.minecraft.world.level.block.WallTorchBlock.FACING,
						dir);

		if (!world.getBlockState(pos).canBeReplaced() || !state.canSurvive(world, pos))
			return false;

		if (world instanceof ServerLevel level && entity instanceof Player player
				&& !player.getAbilities().instabuild) {
			stack.hurtAndBreak(1, level, player, item -> {
				player.onEquippedItemBroken(stack.getItem(), Player.getSlotForHand(hand));
				net.neoforged.neoforge.event.EventHooks.onPlayerDestroyItem(player, player.getUseItem(), hand);
				player.stopUsingItem();
			});
		}
		world.setBlock(pos, state, 3);
		return true;
	}
}