/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mcrshorts.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.mcrshorts.McrshortsMod;

public class McrshortsModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, McrshortsMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MCR_SHORTS = REGISTRY.register("mcr_shorts",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.mcrshorts.mcr_shorts")).icon(() -> new ItemStack(McrshortsModItems.GLOWING_TORCH.get())).displayItems((parameters, tabData) -> {
				tabData.accept(McrshortsModItems.GLOWING_TORCH.get());
				tabData.accept(McrshortsModItems.SPIRIT_LAMP.get());
				tabData.accept(McrshortsModItems.ENDER_LAMP.get());
				tabData.accept(McrshortsModBlocks.ANCIENT_DEBRIS_LEAVES.get().asItem());
				tabData.accept(McrshortsModBlocks.ANCIENT_DEBRIS_SAPLING.get().asItem());
				tabData.accept(McrshortsModItems.LAZY_DUCK.get());
				tabData.accept(McrshortsModItems.GOLDERBREAD_MAN.get());
				tabData.accept(McrshortsModItems.MOO_HAT.get());
				tabData.accept(McrshortsModItems.EXCALIBUR.get());
				tabData.accept(McrshortsModItems.LUNCHBOX.get());
				tabData.accept(McrshortsModItems.EMPTY_LUNCHBOX.get());
			}).build());
}