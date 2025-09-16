/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mcrshorts.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.client.event.RegisterRangeSelectItemModelPropertyEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.mcrshorts.item.UpsiteCrossingItem;
import net.mcreator.mcrshorts.item.SuperIngotItem;
import net.mcreator.mcrshorts.item.SpiritLampItem;
import net.mcreator.mcrshorts.item.MooHatItem;
import net.mcreator.mcrshorts.item.LunchboxItem;
import net.mcreator.mcrshorts.item.LazyDuckItem;
import net.mcreator.mcrshorts.item.GrowthItem;
import net.mcreator.mcrshorts.item.GolderbreadManItem;
import net.mcreator.mcrshorts.item.GlowingTorchItem;
import net.mcreator.mcrshorts.item.ExcaliburItem;
import net.mcreator.mcrshorts.item.EnderLampItem;
import net.mcreator.mcrshorts.item.EmptyLunchboxItem;
import net.mcreator.mcrshorts.item.DemonHornNecklaceItem;
import net.mcreator.mcrshorts.item.BadEnderLampItem;
import net.mcreator.mcrshorts.McrshortsMod;

import java.util.function.Function;

public class McrshortsModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(McrshortsMod.MODID);
	public static final DeferredItem<Item> GLOWING_TORCH = register("glowing_torch", GlowingTorchItem::new);
	public static final DeferredItem<Item> SPIRIT_LAMP = register("spirit_lamp", SpiritLampItem::new);
	public static final DeferredItem<Item> ENDER_LAMP = register("ender_lamp", EnderLampItem::new);
	public static final DeferredItem<Item> BAD_ENDER_LAMP = register("bad_ender_lamp", BadEnderLampItem::new);
	public static final DeferredItem<Item> ANCIENT_DEBRIS_LEAVES = block(McrshortsModBlocks.ANCIENT_DEBRIS_LEAVES);
	public static final DeferredItem<Item> ANCIENT_DEBRIS_SAPLING = block(McrshortsModBlocks.ANCIENT_DEBRIS_SAPLING);
	public static final DeferredItem<Item> LAZY_DUCK = register("lazy_duck", LazyDuckItem::new);
	public static final DeferredItem<Item> GOLDERBREAD_MAN = register("golderbread_man", GolderbreadManItem::new);
	public static final DeferredItem<Item> MOO_HAT = register("moo_hat", MooHatItem::new);
	public static final DeferredItem<Item> EXCALIBUR = register("excalibur", ExcaliburItem::new);
	public static final DeferredItem<Item> LUNCHBOX = register("lunchbox", LunchboxItem::new);
	public static final DeferredItem<Item> EMPTY_LUNCHBOX = register("empty_lunchbox", EmptyLunchboxItem::new);
	public static final DeferredItem<Item> SUPER_INGOT = register("super_ingot", SuperIngotItem::new);
	public static final DeferredItem<Item> GROWTH_LEGGINGS = register("growth_leggings", GrowthItem.Leggings::new);
	public static final DeferredItem<Item> DEMON_HORN_NECKLACE = register("demon_horn_necklace", DemonHornNecklaceItem::new);
	public static final DeferredItem<Item> UPSITE_CROSSING = register("upsite_crossing", UpsiteCrossingItem::new);
	public static final DeferredItem<Item> GOLD_SLAB = block(McrshortsModBlocks.GOLD_SLAB);
	public static final DeferredItem<Item> GILDING_CHAMBER = block(McrshortsModBlocks.GILDING_CHAMBER);

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new BlockItem(block.get(), prop), properties);
	}

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ItemsClientSideHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public static void registerItemModelProperties(RegisterRangeSelectItemModelPropertyEvent event) {
			event.register(ResourceLocation.parse("mcrshorts:lazy_duck/time"), LazyDuckItem.TimeProperty.MAP_CODEC);
		}
	}
}