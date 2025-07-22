
package net.mcreator.mcrshorts.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.SaplingBlock;
import java.util.Optional;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class AncientDebrisSaplingBlock extends SaplingBlock {
	public AncientDebrisSaplingBlock(BlockBehaviour.Properties properties) {
		super(new TreeGrower("ancient_debris", Optional.empty(),
				Optional.of(ResourceKey.create(Registries.CONFIGURED_FEATURE,
						ResourceLocation.parse("mcrshorts:ancient_debris_tree_feature"))),
				Optional.empty()),
				properties.mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)
						.pushReaction(PushReaction.DESTROY));
	}
}
