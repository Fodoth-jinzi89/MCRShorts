package net.mcreator.mcrshorts.client.renderer;

import top.theillusivec4.curios.api.client.ICurioRenderer;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import net.mcreator.mcrshorts.init.McrshortsModLayerDefinitions;
import net.mcreator.mcrshorts.client.model.Modelmoo_hat;

import com.mojang.blaze3d.vertex.PoseStack;

public class MooHatRenderer implements ICurioRenderer.ModelRender<Modelmoo_hat> {
	private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("mcrshorts", "textures/entities/moo_hat.png");
	private final Modelmoo_hat model;

	public MooHatRenderer() {
		this.model = new Modelmoo_hat(Minecraft.getInstance().getEntityModels().bakeLayer(McrshortsModLayerDefinitions.MOO_HAT));
	}

	@Override
	public Modelmoo_hat getModel(ItemStack stack, SlotContext slotContext) {
		return model;
	}

	@Override
	public ResourceLocation getModelTexture(ItemStack stack, SlotContext slotContext) {
		return TEXTURE;
	}

	@Override
	public <S extends LivingEntityRenderState, M extends EntityModel<? super S>> void renderModel(ItemStack stack, SlotContext slotContext, PoseStack poseStack, MultiBufferSource renderTypeBuffer, int packedLight, S renderState,
			RenderLayerParent<S, M> renderLayerParent, EntityRendererProvider.Context context, float yRotation, float xRotation) {
		poseStack.pushPose();
		HumanoidModel<?> parentModel = (HumanoidModel<?>) renderLayerParent.getModel();
		parentModel.head.translateAndRotate(poseStack);
		poseStack.translate(0 / 16.0F, -24 / 16.0F, 0 / 16.0F);
		ICurioRenderer.renderModel(this.getModel(stack, slotContext), this.getModelTexture(stack, slotContext), poseStack, renderTypeBuffer, packedLight, stack.hasFoil() ? RenderType.entityGlint() : null);
		poseStack.popPose();
	}
}