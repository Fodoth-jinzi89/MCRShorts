package net.mcreator.mcrshorts.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.mcrshorts.network.McrshortsModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class TimeMendingTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(McrshortsModVariables.PLAYER_VARIABLES).TimeMendingTimer < 20) {
			{
				McrshortsModVariables.PlayerVariables _vars = entity.getData(McrshortsModVariables.PLAYER_VARIABLES);
				_vars.TimeMendingTimer = entity.getData(McrshortsModVariables.PLAYER_VARIABLES).TimeMendingTimer + 1;
				_vars.syncPlayerVariables(entity);
			}
		} else {
			{
				McrshortsModVariables.PlayerVariables _vars = entity.getData(McrshortsModVariables.PLAYER_VARIABLES);
				_vars.TimeMendingTimer = 0;
				_vars.syncPlayerVariables(entity);
			}
			if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
				for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
					ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx);
					if (itemstackiterator.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("mcrshorts:time_mending")))) != 0) {
						itemstackiterator.setDamageValue((int) Math.max(
								itemstackiterator.getDamageValue()
										- itemstackiterator.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("mcrshorts:time_mending")))),
								0));
					}
				}
			}
		}
	}
}