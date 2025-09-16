package net.mcreator.mcrshorts.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.mcrshorts.McrshortsMod;

public class LastStandMobEffect extends MobEffect {
	public LastStandMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -2875617);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(McrshortsMod.MODID, "effect.last_stand_0"), 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.ENTITY_INTERACTION_RANGE, ResourceLocation.fromNamespaceAndPath(McrshortsMod.MODID, "effect.last_stand_1"), 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(McrshortsMod.MODID, "effect.last_stand_2"), 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}
}