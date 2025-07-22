package net.mcreator.mcrshorts.init;

import top.theillusivec4.curios.api.client.ICurioRenderer;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.mcreator.mcrshorts.client.renderer.MooHatRenderer;
import net.mcreator.mcrshorts.client.model.Modelmoo_hat;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class McrshortsModCuriosRenderers {
	@SubscribeEvent
	public static void registerLayers(final EntityRenderersEvent.RegisterLayerDefinitions evt) {
		evt.registerLayerDefinition(McrshortsModLayerDefinitions.MOO_HAT, Modelmoo_hat::createBodyLayer);
	}

	@SubscribeEvent
	public static void clientSetup(final FMLClientSetupEvent evt) {
		ICurioRenderer.register(McrshortsModItems.MOO_HAT.get(), MooHatRenderer::new);
	}
}