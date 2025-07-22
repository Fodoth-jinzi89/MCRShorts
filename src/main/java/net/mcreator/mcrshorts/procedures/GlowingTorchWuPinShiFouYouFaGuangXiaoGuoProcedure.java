package net.mcreator.mcrshorts.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class GlowingTorchWuPinShiFouYouFaGuangXiaoGuoProcedure {
	public static boolean execute(ItemStack itemstack) {
		return itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("isGlowing");
	}
}