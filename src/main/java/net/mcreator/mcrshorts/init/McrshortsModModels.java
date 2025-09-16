/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mcrshorts.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.mcrshorts.client.model.Modelmoo_hat;
import net.mcreator.mcrshorts.client.model.Modelgold_slab2;
import net.mcreator.mcrshorts.client.model.Modelgold_slab1;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class McrshortsModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelgold_slab2.LAYER_LOCATION, Modelgold_slab2::createBodyLayer);
		event.registerLayerDefinition(Modelmoo_hat.LAYER_LOCATION, Modelmoo_hat::createBodyLayer);
		event.registerLayerDefinition(Modelgold_slab1.LAYER_LOCATION, Modelgold_slab1::createBodyLayer);
	}
}