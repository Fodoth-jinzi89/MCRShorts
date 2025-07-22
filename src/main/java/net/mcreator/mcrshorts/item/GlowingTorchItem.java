
package net.mcreator.mcrshorts.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.mcreator.mcrshorts.procedures.GlowingTorchYouJiKongQiShiShiTiDeWeiZhiProcedure;
import net.mcreator.mcrshorts.procedures.GlowingTorchYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure;
import net.mcreator.mcrshorts.procedures.GlowingTorchWuPinZaiShouShangShiMeiKeFaShengProcedure;
import net.mcreator.mcrshorts.procedures.GlowingTorchWuPinShiFouYouFaGuangXiaoGuoProcedure;
import net.mcreator.mcrshorts.procedures.GlowingTorchTeShuXinXiProcedure;

import java.util.List;

public class GlowingTorchItem extends Item {
	public GlowingTorchItem(Item.Properties properties) {
		super(properties.rarity(Rarity.COMMON).durability(64));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return GlowingTorchWuPinShiFouYouFaGuangXiaoGuoProcedure.execute(itemstack);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		Entity entity = itemstack.getEntityRepresentation() != null ? itemstack.getEntityRepresentation() : Minecraft.getInstance().player;
		String hoverText = GlowingTorchTeShuXinXiProcedure.execute(itemstack);
		if (hoverText != null) {
			for (String line : hoverText.split("\n")) {
				list.add(Component.literal(line));
			}
		}
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		GlowingTorchYouJiKongQiShiShiTiDeWeiZhiProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity.getItemInHand(hand));
		return ar;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		GlowingTorchYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getClickedFace(), context.getPlayer(),
				context.getItemInHand(), context.getHand());
		return InteractionResult.SUCCESS;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		GlowingTorchWuPinZaiShouShangShiMeiKeFaShengProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
