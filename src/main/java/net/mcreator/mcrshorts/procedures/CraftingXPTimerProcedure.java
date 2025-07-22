package net.mcreator.mcrshorts.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import net.mcreator.mcrshorts.network.McrshortsModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CraftingXPTimerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(McrshortsModVariables.PLAYER_VARIABLES).CraftingXPTimer > 0) {
			{
				McrshortsModVariables.PlayerVariables _vars = entity.getData(McrshortsModVariables.PLAYER_VARIABLES);
				_vars.CraftingXPTimer = entity.getData(McrshortsModVariables.PLAYER_VARIABLES).CraftingXPTimer - 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}