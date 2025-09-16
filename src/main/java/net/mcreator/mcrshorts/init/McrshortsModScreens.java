/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mcrshorts.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.mcrshorts.client.gui.GildingChamberScreenScreen;
import net.mcreator.mcrshorts.client.gui.GildingChamberScreen1Screen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class McrshortsModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(McrshortsModMenus.GILDING_CHAMBER_SCREEN.get(), GildingChamberScreenScreen::new);
		event.register(McrshortsModMenus.GILDING_CHAMBER_SCREEN_1.get(), GildingChamberScreen1Screen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}