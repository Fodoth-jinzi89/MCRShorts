package net.mcreator.mcrshorts.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.mcrshorts.procedures.MooHatShiPinZhuangBeiShiMeiKeZhiXingProcedure;

public class MooHatItem extends Item implements ICurioItem {
	public MooHatItem(Item.Properties properties) {
		super(properties.stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		MooHatShiPinZhuangBeiShiMeiKeZhiXingProcedure.execute(slotContext.entity());
	}
}