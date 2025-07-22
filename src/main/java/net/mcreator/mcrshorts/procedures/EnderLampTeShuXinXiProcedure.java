package net.mcreator.mcrshorts.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class EnderLampTeShuXinXiProcedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("isGlowing")) {
			return "\u00A77" + Component.translatable("info.mcrshorts.ender_lamp.0").getString();
		}
		return "\u00A77" + Component.translatable("info.mcrshorts.ender_lamp.1").getString();
	}
}