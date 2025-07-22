package net.mcreator.mcrshorts.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.client.multiplayer.ClientLevel;

import net.mcreator.mcrshorts.procedures.LazyDuckZaiWanJiaTingZhiShiYongShiProcedure;
import net.mcreator.mcrshorts.procedures.LazyDuckShuXingZhiTiGongQiProcedure;

import javax.annotation.Nullable;

import com.mojang.serialization.MapCodec;

public class LazyDuckItem extends Item {
	public LazyDuckItem(Item.Properties properties) {
		super(properties.durability(256));
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
		return ItemUseAnimation.BOW;
	}

	@Override
	public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
		return 80;
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		entity.startUsingItem(hand);
		return ar;
	}

	@Override
	public boolean releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
		LazyDuckZaiWanJiaTingZhiShiYongShiProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
		return super.releaseUsing(itemstack, world, entity, time);
	}

	public record TimeProperty() implements RangeSelectItemModelProperty {
		public static final MapCodec<TimeProperty> MAP_CODEC = MapCodec.unit(new TimeProperty());

		@Override
		public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable LivingEntity entity, int seed) {
			return (float) LazyDuckShuXingZhiTiGongQiProcedure.execute(entity, itemStackToRender);
		}

		@Override
		public MapCodec<TimeProperty> type() {
			return MAP_CODEC;
		}
	}
}