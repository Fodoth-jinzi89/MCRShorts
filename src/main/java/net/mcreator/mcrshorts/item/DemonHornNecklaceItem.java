package net.mcreator.mcrshorts.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.living.LivingUseTotemEvent;
import top.theillusivec4.curios.api.CurioAttributeModifiers;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class DemonHornNecklaceItem extends Item implements ICurioItem {
	public DemonHornNecklaceItem(Item.Properties properties) {
		super(properties.stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	public CurioAttributeModifiers getDefaultCurioAttributeModifiers(ItemStack stack) {
		return CurioAttributeModifiers.builder().addModifier(Attributes.ATTACK_DAMAGE,
				new AttributeModifier(ResourceLocation.parse("mcrshorts:strength_bonus"), 2.0, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
				"necklace").build();
	}

}