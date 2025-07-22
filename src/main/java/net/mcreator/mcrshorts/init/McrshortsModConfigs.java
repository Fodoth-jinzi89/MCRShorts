package net.mcreator.mcrshorts.init;

import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;

import net.mcreator.mcrshorts.configuration.McrshortsConfigConfiguration;
import net.mcreator.mcrshorts.McrshortsMod;

@EventBusSubscriber(modid = McrshortsMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class McrshortsModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModList.get().getModContainerById("mcrshorts").get().registerConfig(ModConfig.Type.COMMON, McrshortsConfigConfiguration.SPEC, "mcrshorts-common.toml");
		});
	}
}