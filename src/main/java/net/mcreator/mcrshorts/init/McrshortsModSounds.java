/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mcrshorts.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.mcrshorts.McrshortsMod;

public class McrshortsModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, McrshortsMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> PLAYER_MCRSHORTS_LAZY_DUCK = REGISTRY.register("player.mcrshorts.lazy_duck",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("mcrshorts", "player.mcrshorts.lazy_duck")));
}