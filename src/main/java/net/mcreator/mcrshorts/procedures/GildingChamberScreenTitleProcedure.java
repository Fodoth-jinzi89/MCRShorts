package net.mcreator.mcrshorts.procedures;

import net.minecraft.network.chat.Component;

public class GildingChamberScreenTitleProcedure {
	public static String execute() {
		return Component.translatable("gui.mcrshorts.gilding_chamber.title").getString();
	}
}