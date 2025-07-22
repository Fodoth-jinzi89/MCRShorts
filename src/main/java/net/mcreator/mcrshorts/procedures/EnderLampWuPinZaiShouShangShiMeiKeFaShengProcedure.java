package net.mcreator.mcrshorts.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.component.DataComponents;

import net.mcreator.mcrshorts.network.McrshortsModVariables;

import java.util.Comparator;

public class EnderLampWuPinZaiShouShangShiMeiKeFaShengProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean updateGlowing = false;
		updateGlowing = false;
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("isGlowing")) {
			{
				McrshortsModVariables.PlayerVariables _vars = entity.getData(McrshortsModVariables.PLAYER_VARIABLES);
				_vars.GlowingTorchTimer = entity.getData(McrshortsModVariables.PLAYER_VARIABLES).GlowingTorchTimer + 1;
				_vars.syncPlayerVariables(entity);
			}
			if (entity.getData(McrshortsModVariables.PLAYER_VARIABLES).GlowingTorchTimer > 20) {
				{
					McrshortsModVariables.PlayerVariables _vars = entity.getData(McrshortsModVariables.PLAYER_VARIABLES);
					_vars.GlowingTorchTimer = 0;
					_vars.syncPlayerVariables(entity);
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(96 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (!(entityiterator.isCurrentlyGlowing() || entityiterator == entity)) {
							updateGlowing = true;
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 400, 0));
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.PORTAL, (entityiterator.getX()), (entityiterator.getY() + 0.5 * entityiterator.getBbHeight()), (entityiterator.getZ()), 10, 0, 0, 0, 0.1);
						}
					}
				}
			}
			if (updateGlowing && Math.random() < 0.1 && !(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
				if (world instanceof ServerLevel _level) {
					itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
					});
				}
			}
		} else {
			{
				McrshortsModVariables.PlayerVariables _vars = entity.getData(McrshortsModVariables.PLAYER_VARIABLES);
				_vars.GlowingTorchTimer = 20;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}