package net.mcreator.mcrshorts.item;

import net.minecraft.world.item.Item;

public class EmptyLunchboxItem extends Item {
	public EmptyLunchboxItem(Item.Properties properties) {
		super(properties.stacksTo(1));
	}
}