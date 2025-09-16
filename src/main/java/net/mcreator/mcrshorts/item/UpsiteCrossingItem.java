package net.mcreator.mcrshorts.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class UpsiteCrossingItem extends Item {
	public UpsiteCrossingItem(Item.Properties properties) {
		super(properties.rarity(Rarity.RARE).stacksTo(1));
	}
}