/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mcrshorts.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.mcrshorts.block.entity.GoldSlabBlockEntity;
import net.mcreator.mcrshorts.block.entity.GoldSlab2BlockEntity;
import net.mcreator.mcrshorts.block.entity.GildingChamberBlockEntity;
import net.mcreator.mcrshorts.McrshortsMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class McrshortsModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, McrshortsMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GoldSlabBlockEntity>> GOLD_SLAB = register("gold_slab", McrshortsModBlocks.GOLD_SLAB, GoldSlabBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GoldSlab2BlockEntity>> GOLD_SLAB_2 = register("gold_slab_2", McrshortsModBlocks.GOLD_SLAB_2, GoldSlab2BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GildingChamberBlockEntity>> GILDING_CHAMBER = register("gilding_chamber", McrshortsModBlocks.GILDING_CHAMBER, GildingChamberBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> new BlockEntityType(supplier, block.get()));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GOLD_SLAB.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GOLD_SLAB_2.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GILDING_CHAMBER.get(), SidedInvWrapper::new);
	}
}