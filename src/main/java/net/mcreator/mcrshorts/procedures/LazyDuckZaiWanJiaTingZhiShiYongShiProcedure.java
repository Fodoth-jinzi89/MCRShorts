package net.mcreator.mcrshorts.procedures;

import org.checkerframework.checker.units.qual.t;
import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class LazyDuckZaiWanJiaTingZhiShiYongShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double t = 0;
		double t1 = 0;
		t = (entity instanceof LivingEntity _entUseTicks0 ? _entUseTicks0.getTicksUsingItem() : 0) / new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert("20");
		t1 = t / 3;
		if (t > 1 && entity.isUnderWater()) {
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
				});
			}
			entity.setAirSupply((int) Math.min(entity.getAirSupply() + t * 100, 300));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, (entity instanceof LivingEntity _entUseTicks6 ? _entUseTicks6.getTicksUsingItem() : 0) * 5, 0, false, true));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, (entity instanceof LivingEntity _entUseTicks8 ? _entUseTicks8.getTicksUsingItem() : 0) * 5, 0, false, true));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.BUBBLE, x, (y + 0.5 * entity.getBbHeight()), z, entity instanceof LivingEntity _entUseTicks11 ? _entUseTicks11.getTicksUsingItem() : 0, t1, t1, t1, 0.2);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y + 0.5 * entity.getBbHeight(), z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("mcrshorts:player.mcrshorts.lazy_duck")), SoundSource.PLAYERS, (float) 0.7, 1);
				} else {
					_level.playLocalSound(x, (y + 0.5 * entity.getBbHeight()), z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("mcrshorts:player.mcrshorts.lazy_duck")), SoundSource.PLAYERS, (float) 0.7, 1, false);
				}
			}
		}
	}
}