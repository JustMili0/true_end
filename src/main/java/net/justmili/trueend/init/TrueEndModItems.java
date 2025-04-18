package net.justmili.trueend.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.justmili.trueend.item.MysteriousCubeItem;
import net.justmili.trueend.TrueEndMod;

public class TrueEndModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TrueEndMod.MODID);
	public static final RegistryObject<Item> DIRT = block(TrueEndModBlocks.DIRT);
	public static final RegistryObject<Item> GRASS_BLOCK = block(TrueEndModBlocks.GRASS_BLOCK);
	public static final RegistryObject<Item> FARMLAND = block(TrueEndModBlocks.FARMLAND);
	public static final RegistryObject<Item> COBBLESTONE = block(TrueEndModBlocks.COBBLESTONE);
	public static final RegistryObject<Item> MOSSY_COBBLESTONE = block(TrueEndModBlocks.MOSSY_COBBLESTONE);
	public static final RegistryObject<Item> STONE = block(TrueEndModBlocks.STONE);
	public static final RegistryObject<Item> COAL_ORE = block(TrueEndModBlocks.COAL_ORE);
	public static final RegistryObject<Item> IRON_ORE = block(TrueEndModBlocks.IRON_ORE);
	public static final RegistryObject<Item> GOLD_ORE = block(TrueEndModBlocks.GOLD_ORE);
	public static final RegistryObject<Item> REDSTONE_ORE = block(TrueEndModBlocks.REDSTONE_ORE);
	public static final RegistryObject<Item> DIAMOND_ORE = block(TrueEndModBlocks.DIAMOND_ORE);
	public static final RegistryObject<Item> WOOD = block(TrueEndModBlocks.WOOD);
	public static final RegistryObject<Item> WOODEN_PLANKS = block(TrueEndModBlocks.WOODEN_PLANKS);
	public static final RegistryObject<Item> TREE_LEAVES = block(TrueEndModBlocks.TREE_LEAVES);
	public static final RegistryObject<Item> OBSIDIAN = block(TrueEndModBlocks.OBSIDIAN);
	public static final RegistryObject<Item> GRAVEL = block(TrueEndModBlocks.GRAVEL);
	public static final RegistryObject<Item> WOOD_6_SIDED = block(TrueEndModBlocks.WOOD_6_SIDED);
	public static final RegistryObject<Item> MYSTERIOUS_CUBE = REGISTRY.register("mysterious_cube", () -> new MysteriousCubeItem());
	public static final RegistryObject<Item> GLASS = block(TrueEndModBlocks.GLASS);
	public static final RegistryObject<Item> SAND = block(TrueEndModBlocks.SAND);
	
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
