/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mcrshorts.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import net.mcreator.mcrshorts.world.inventory.GildingChamberScreenMenu;
import net.mcreator.mcrshorts.world.inventory.GildingChamberScreen1Menu;
import net.mcreator.mcrshorts.network.MenuStateUpdateMessage;
import net.mcreator.mcrshorts.McrshortsMod;

import java.util.Map;

public class McrshortsModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, McrshortsMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<GildingChamberScreenMenu>> GILDING_CHAMBER_SCREEN = REGISTRY.register("gilding_chamber_screen", () -> IMenuTypeExtension.create(GildingChamberScreenMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GildingChamberScreen1Menu>> GILDING_CHAMBER_SCREEN_1 = REGISTRY.register("gilding_chamber_screen_1", () -> IMenuTypeExtension.create(GildingChamberScreen1Menu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				PacketDistributor.sendToPlayer(serverPlayer, new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof McrshortsModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				PacketDistributor.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}