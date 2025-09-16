package net.mcreator.mcrshorts.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;

public class GildingChamberWuPinLanCaoWeiZiDongFangZhiTiaoJianProcedure {
	public static boolean execute(Direction direction, ItemStack itemstack, double index) {
		if (direction == null)
			return false;
		if (index == 0) {
			return direction == Direction.UP && itemstack.is(ItemTags.create(ResourceLocation.parse("mcrshorts:gilding_input_1")));
		} else if (index == 1) {
			return !(direction == Direction.UP) && !(direction == Direction.DOWN) && itemstack.is(ItemTags.create(ResourceLocation.parse("mcrshorts:gilding_input_2")));
		}
		return false;
	}
}