/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mcrshorts.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.mcrshorts.potion.LastStandMobEffect;
import net.mcreator.mcrshorts.McrshortsMod;

public class McrshortsModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, McrshortsMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> LAST_STAND = REGISTRY.register("last_stand", () -> new LastStandMobEffect());
}