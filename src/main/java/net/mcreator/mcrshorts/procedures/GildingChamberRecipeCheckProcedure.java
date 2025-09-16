package net.mcreator.mcrshorts.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.IoSupplier;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

import java.io.InputStream;

import com.ibm.icu.util.Output;

public class GildingChamberRecipeCheckProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		com.google.gson.JsonArray ingredients = new com.google.gson.JsonArray();
		com.google.gson.JsonArray results = new com.google.gson.JsonArray();
		com.google.gson.JsonObject recipe = new com.google.gson.JsonObject();
		com.google.gson.JsonObject ingredients_item = new com.google.gson.JsonObject();
		com.google.gson.JsonObject ingredients_gild = new com.google.gson.JsonObject();
		com.google.gson.JsonObject results_item = new com.google.gson.JsonObject();
		boolean start = false;
		start = false;
		{
			if (world instanceof ServerLevel srvlvl_) {
				class Output implements PackResources.ResourceOutput {
					private List<com.google.gson.JsonObject> jsonObjects;
					private PackResources packResources;

					public Output(List<com.google.gson.JsonObject> jsonObjects) {
						this.jsonObjects = jsonObjects;
					}

					public void setPackResources(PackResources packResources) {
						this.packResources = packResources;
					}

					@Override
					public void accept(ResourceLocation resourceLocation, IoSupplier<InputStream> ioSupplier) {
						try {
							com.google.gson.JsonObject jsonObject = new com.google.gson.Gson()
									.fromJson(new java.io.BufferedReader(new java.io.InputStreamReader(ioSupplier.get(), java.nio.charset.StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n")), com.google.gson.JsonObject.class);
							this.jsonObjects.add(jsonObject);
						} catch (Exception e) {
						}
					}
				}
				List<com.google.gson.JsonObject> jsons = new ArrayList<>();
				Output output = new Output(jsons);
				ResourceManager rm = srvlvl_.getServer().getResourceManager();
				rm.listPacks().forEach(resource -> {
					output.setPackResources(resource);
					resource.listResources(PackType.SERVER_DATA, "mcrshorts", "recipe/gilding_chamber", output);
				});
				for (com.google.gson.JsonObject jsoniterator : jsons) {
					recipe = jsoniterator;
					ingredients = recipe.get("ingredients").getAsJsonArray();
					results = recipe.get("results").getAsJsonArray();
					ingredients_item = ingredients.get((int) 0).getAsJsonObject();
					ingredients_gild = ingredients.get((int) 1).getAsJsonObject();
					results_item = results.get((int) 0).getAsJsonObject();
					if ((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem()).toString()).equals(ingredients_item.get("item").getAsString())
							&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getCount() >= ingredients_item.get("count").getAsDouble()
							&& (BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem()).toString()).equals(ingredients_gild.get("gild").getAsString())
							&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount() >= ingredients_gild.get("count").getAsDouble()) {
						if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0
								|| (BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()).toString()).equals(results_item.get("id").getAsString())
										&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + results_item.get("count").getAsDouble() <= 64) {
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								int _slotid = 0;
								ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
								_stk.shrink((int) ingredients_item.get("count").getAsDouble());
								_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
							}
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								int _slotid = 1;
								ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
								_stk.shrink((int) ingredients_gild.get("count").getAsDouble());
								_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
							}
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putString("result", results_item.get("id").getAsString());
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("count", results_item.get("count").getAsDouble());
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("ticks", recipe.get("ticks").getAsDouble());
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("progress", 1);
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							start = true;
							break;
						}
					}
				}
			}
		}
		return start;
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}