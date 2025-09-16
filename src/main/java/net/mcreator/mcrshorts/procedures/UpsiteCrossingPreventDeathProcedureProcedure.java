package net.mcreator.mcrshorts.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.mcrshorts.network.McrshortsModVariables;
import net.mcreator.mcrshorts.init.McrshortsModMobEffects;
import net.mcreator.mcrshorts.init.McrshortsModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class UpsiteCrossingPreventDeathProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, double amount) {
		execute(null, world, entity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, double amount) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(McrshortsModMobEffects.LAST_STAND))
				&& (amount >= 0.4 * (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) || amount >= 0.8 * (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 0.2 * (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1))) {
			if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
				for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
					ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx);
					if (itemstackiterator.getItem() == McrshortsModItems.UPSITE_CROSSING.get()) {
						itemstackiterator.shrink(1);
						{
							McrshortsModVariables.PlayerVariables _vars = entity.getData(McrshortsModVariables.PLAYER_VARIABLES);
							_vars.UpsideCrossingTimer = 2;
							_vars.syncPlayerVariables(entity);
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(McrshortsModMobEffects.LAST_STAND, 400, 0, false, true));
						if (event instanceof LivingIncomingDamageEvent _event) {
							_event.setAmount(0);
						}
						break;
					}
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(McrshortsModMobEffects.LAST_STAND)) {
			if (event instanceof LivingIncomingDamageEvent _event) {
				_event.setAmount((float) (amount * (0.05 / ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(McrshortsModMobEffects.LAST_STAND) ? _livEnt.getEffect(McrshortsModMobEffects.LAST_STAND).getAmplifier() : 0) + 1))));
			}
		}
	}
}