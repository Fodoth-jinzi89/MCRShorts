package net.mcreator.mcrshorts.item;

import net.mcreator.mcrshorts.init.McrshortsModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class LunchboxItem extends Item {
	public LunchboxItem(Item.Properties properties) {
		super(properties.durability(4).food(new FoodProperties.Builder().nutrition(12).saturationModifier(8f).alwaysEdible().build()));
	}

	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entity) {
		if (!level.isClientSide && entity instanceof Player player && !player.getAbilities().instabuild && level instanceof ServerLevel serverLevel) {
			stack.hurtAndBreak(1, serverLevel, player, p -> {});
		}
		if (stack.isEmpty()) {
			return new ItemStack(McrshortsModItems.EMPTY_LUNCHBOX.get());
		}
		return stack;
	}
}
