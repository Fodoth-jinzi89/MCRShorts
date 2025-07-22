package net.mcreator.mcrshorts.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class BadEnderLampWuPinZaiWuPinLanShiMeiKeFaShengProcedure {
	public static void execute(ItemStack itemstack) {
		{
			final String _tagName = "Timer";
			final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Timer") + 1);
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
		}
	}
}