package net.mcreator.mcrshorts.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.mcrshorts.network.McrshortsModVariables;
import net.mcreator.mcrshorts.init.McrshortsModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class UpsiteCrossingItemComsumeProcedureProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(McrshortsModVariables.PLAYER_VARIABLES).UpsideCrossingTimer > 0) {
			{
				McrshortsModVariables.PlayerVariables _vars = entity.getData(McrshortsModVariables.PLAYER_VARIABLES);
				_vars.UpsideCrossingTimer = entity.getData(McrshortsModVariables.PLAYER_VARIABLES).UpsideCrossingTimer - 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity.getData(McrshortsModVariables.PLAYER_VARIABLES).UpsideCrossingTimer > 0) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("item.totem.use")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("item.totem.use")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.RAID_OMEN, x, y, z, 20, 0.1, 0.1, 0.1, 0.1);
			}
			if (world.isClientSide())
				Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(McrshortsModItems.UPSITE_CROSSING.get()));
		}
	}
}