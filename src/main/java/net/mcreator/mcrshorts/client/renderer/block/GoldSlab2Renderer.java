package net.mcreator.mcrshorts.client.renderer.block;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelPart;

import net.mcreator.mcrshorts.procedures.GoldSlabHuiFangTiaoJianProcedure;
import net.mcreator.mcrshorts.init.McrshortsModBlockEntities;
import net.mcreator.mcrshorts.client.model.animations.gold_slab1Animation;
import net.mcreator.mcrshorts.client.model.Modelgold_slab2;
import net.mcreator.mcrshorts.block.entity.GoldSlab2BlockEntity;
import net.mcreator.mcrshorts.block.GoldSlab2Block;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GoldSlab2Renderer implements BlockEntityRenderer<GoldSlab2BlockEntity> {
	private final CustomHierarchicalModel model;
	private final ResourceLocation texture;
	private final LivingEntityRenderState renderState;

	GoldSlab2Renderer(BlockEntityRendererProvider.Context context) {
		this.model = new CustomHierarchicalModel(context.bakeLayer(Modelgold_slab2.LAYER_LOCATION));
		this.texture = ResourceLocation.parse("mcrshorts:textures/block/gold_slab.png");
		this.renderState = new LivingEntityRenderState();
	}

	private void updateRenderState(GoldSlab2BlockEntity blockEntity, float partialTick) {
		int tickCount = (int) blockEntity.getLevel().getGameTime();
		renderState.ageInTicks = tickCount + partialTick;
		blockEntity.animationState0.animateWhen(GoldSlabHuiFangTiaoJianProcedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
	}

	@Override
	public void render(GoldSlab2BlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource renderer, int light, int overlayLight) {
		updateRenderState(blockEntity, partialTick);
		poseStack.pushPose();
		poseStack.scale(-1, -1, 1);
		poseStack.translate(-0.5, -0.5, 0.5);
		BlockState state = blockEntity.getBlockState();
		Direction facing = state.getValue(GoldSlab2Block.FACING);
		switch (facing) {
			case NORTH -> {
			}
			case EAST -> poseStack.mulPose(Axis.YP.rotationDegrees(90));
			case WEST -> poseStack.mulPose(Axis.YP.rotationDegrees(-90));
			case SOUTH -> poseStack.mulPose(Axis.YP.rotationDegrees(180));
		}
		poseStack.translate(0, -1, 0);
		VertexConsumer builder = renderer.getBuffer(RenderType.entityCutout(texture));
		model.setupBlockEntityAnim(blockEntity, renderState);
		model.renderToBuffer(poseStack, builder, light, overlayLight);
		poseStack.popPose();
	}

	@SubscribeEvent
	public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(McrshortsModBlockEntities.GOLD_SLAB_2.get(), GoldSlab2Renderer::new);
	}

	private static final class CustomHierarchicalModel extends Modelgold_slab2 {
		public CustomHierarchicalModel(ModelPart root) {
			super(root);
		}

		public void setupBlockEntityAnim(GoldSlab2BlockEntity blockEntity, LivingEntityRenderState state) {
			this.root().getAllParts().forEach(ModelPart::resetPose);
			this.animate(blockEntity.animationState0, gold_slab1Animation.push1, state.ageInTicks, 1f);
			super.setupAnim(state);
		}

		public ModelPart getRoot() {
			return root;
		}
	}
}