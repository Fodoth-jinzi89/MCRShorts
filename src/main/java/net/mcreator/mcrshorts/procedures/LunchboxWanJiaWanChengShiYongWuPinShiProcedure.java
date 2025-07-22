package net.mcreator.mcrshorts.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class LunchboxWanJiaWanChengShiYongWuPinShiProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack newBox = ItemStack.EMPTY;
		newBox = itemstack.copy();
		newBox.setDamageValue(itemstack.getDamageValue() + 1);
		if (entity instanceof Player _player) {
			ItemStack _setstack = newBox.copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
	}
}