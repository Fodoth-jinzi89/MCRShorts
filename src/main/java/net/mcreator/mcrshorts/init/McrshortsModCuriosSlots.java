package net.mcreator.mcrshorts.init;

import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class McrshortsModCuriosSlots {
	@SubscribeEvent
	public static void enqueueIMC(final InterModEnqueueEvent event) {
	}
}