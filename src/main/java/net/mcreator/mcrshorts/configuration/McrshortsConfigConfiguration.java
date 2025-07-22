package net.mcreator.mcrshorts.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class McrshortsConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;

	public static final ModConfigSpec.ConfigValue<Boolean> CRAFTING_XP_ENABLED;
	public static final ModConfigSpec.ConfigValue<Double> CRAFTING_XP_AMOUNT;
	public static final ModConfigSpec.ConfigValue<Double> CRAFTING_XP_COOLDOWN;
	static {
		BUILDER.push("Gameplay");
		CRAFTING_XP_ENABLED = BUILDER.comment("Whether to enable XP gain when crafting items").define("Enable Crafting XP", true);
		CRAFTING_XP_AMOUNT = BUILDER.comment("Amount of experience awarded per crafting action").define("Crafting XP Amount", (double) 20);
		CRAFTING_XP_COOLDOWN = BUILDER.comment("Cooldown time (in ticks) before XP can be awarded again").define("Crafting XP Cooldown", (double) 200);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}