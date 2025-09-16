/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mcrshorts.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.mcrshorts.block.GoldSlabBlock;
import net.mcreator.mcrshorts.block.GoldSlab2Block;
import net.mcreator.mcrshorts.block.GildingChamberBlock;
import net.mcreator.mcrshorts.block.AncientDebrisSaplingBlock;
import net.mcreator.mcrshorts.block.AncientDebrisLeavesBlock;
import net.mcreator.mcrshorts.McrshortsMod;

import java.util.function.Function;

public class McrshortsModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(McrshortsMod.MODID);
	public static final DeferredBlock<Block> ANCIENT_DEBRIS_LEAVES = register("ancient_debris_leaves", AncientDebrisLeavesBlock::new);
	public static final DeferredBlock<Block> ANCIENT_DEBRIS_SAPLING = register("ancient_debris_sapling", AncientDebrisSaplingBlock::new);
	public static final DeferredBlock<Block> GOLD_SLAB = register("gold_slab", GoldSlabBlock::new);
	public static final DeferredBlock<Block> GOLD_SLAB_2 = register("gold_slab_2", GoldSlab2Block::new);
	public static final DeferredBlock<Block> GILDING_CHAMBER = register("gilding_chamber", GildingChamberBlock::new);

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier, BlockBehaviour.Properties.of());
	}
}