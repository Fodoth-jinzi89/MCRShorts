package net.mcreator.mcrshorts.item;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.resources.model.EquipmentClientInfo;

import net.mcreator.mcrshorts.init.McrshortsModItems;

import java.util.Map;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class GrowthItem extends ArmorItem {
	public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(30, Map.of(ArmorType.BOOTS, 2, ArmorType.LEGGINGS, 4, ArmorType.CHESTPLATE, 6, ArmorType.HELMET, 2, ArmorType.BODY, 6), 25,
			DeferredHolder.create(Registries.SOUND_EVENT, ResourceLocation.parse("item.armor.equip_gold")), 1f, 0f, TagKey.create(Registries.ITEM, ResourceLocation.parse("mcrshorts:growth_repair_items")),
			ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.parse("mcrshorts:growth")));

	@SubscribeEvent
	public static void registerItemExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("mcrshorts:textures/models/armor/growth_layer_2.png");
			}
		}, McrshortsModItems.GROWTH_LEGGINGS.get());
	}

	private GrowthItem(ArmorType type, Item.Properties properties) {
		super(ARMOR_MATERIAL, type, properties);
	}

	public static class Leggings extends GrowthItem {
		public Leggings(Item.Properties properties) {
			super(ArmorType.LEGGINGS, properties);
		}
	}
}