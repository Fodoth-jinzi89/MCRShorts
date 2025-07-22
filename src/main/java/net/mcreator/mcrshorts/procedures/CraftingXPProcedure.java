package net.mcreator.mcrshorts.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.mcrshorts.network.McrshortsModVariables;
import net.mcreator.mcrshorts.configuration.McrshortsConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CraftingXPProcedure {
	@SubscribeEvent
	public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(McrshortsModVariables.PLAYER_VARIABLES).CraftingXPTimer <= 0 && McrshortsConfigConfiguration.CRAFTING_XP_ENABLED.get()) {
			if (entity instanceof Player _player)
				_player.giveExperiencePoints((int) (double) McrshortsConfigConfiguration.CRAFTING_XP_AMOUNT.get());
			{
				McrshortsModVariables.PlayerVariables _vars = entity.getData(McrshortsModVariables.PLAYER_VARIABLES);
				_vars.CraftingXPTimer = (double) McrshortsConfigConfiguration.CRAFTING_XP_COOLDOWN.get();
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}