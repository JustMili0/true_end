
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.justmili.trueend.init;

import net.justmili.trueend.block.*;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.world.level.block.Block;
import net.justmili.trueend.block.WoodenPlanksBlock;
import net.justmili.trueend.block.WoodBlock;
import net.justmili.trueend.block.Wood6SidedBlock;
import net.justmili.trueend.block.TreeLeavesBlock;
import net.justmili.trueend.block.StoneBlock;
import net.justmili.trueend.block.CoalOreBlock;
import net.justmili.trueend.block.IronOreBlock;
import net.justmili.trueend.block.GoldOreBlock;
import net.justmili.trueend.block.RedstoneOreBlock;
import net.justmili.trueend.block.DiamondOreBlock;
import net.justmili.trueend.block.SandBlock;
import net.justmili.trueend.block.ObsidianBlock;
import net.justmili.trueend.block.GravelBlock;
import net.justmili.trueend.block.GrassBlockBlock;
import net.justmili.trueend.block.GlassBlock;
import net.justmili.trueend.block.DirtBlock;
import net.justmili.trueend.block.CobblestoneBlock;
import net.justmili.trueend.block.MossyCobblestoneBlock;
import net.justmili.trueend.block.FarmlandBlock;
import net.justmili.trueend.block.BeyondTheDreamPortalBlock;
import net.justmili.trueend.TrueEndMod;

public class TrueEndModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, TrueEndMod.MODID);
	public static final RegistryObject<Block> DIRT = REGISTRY.register("dirt", () -> new DirtBlock());
	public static final RegistryObject<Block> GRASS_BLOCK = REGISTRY.register("grass_block", () -> new GrassBlockBlock());
	public static final RegistryObject<Block> FARMLAND = REGISTRY.register("farmland", () -> new FarmlandBlock());
	public static final RegistryObject<Block> COBBLESTONE = REGISTRY.register("cobblestone", () -> new CobblestoneBlock());
	public static final RegistryObject<Block> MOSSY_COBBLESTONE = REGISTRY.register("mossy_cobblestone", () -> new MossyCobblestoneBlock());
	public static final RegistryObject<Block> STONE = REGISTRY.register("stone", () -> new StoneBlock());
	public static final RegistryObject<Block> COAL_ORE = REGISTRY.register("coal_ore", () -> new CoalOreBlock());
	public static final RegistryObject<Block> IRON_ORE = REGISTRY.register("iron_ore", () -> new IronOreBlock());
	public static final RegistryObject<Block> GOLD_ORE = REGISTRY.register("gold_ore", () -> new GoldOreBlock());
	public static final RegistryObject<Block> REDSTONE_ORE = REGISTRY.register("redstone_ore", () -> new RedstoneOreBlock());
	public static final RegistryObject<Block> DIAMOND_ORE = REGISTRY.register("diamond_ore", () -> new DiamondOreBlock());
	public static final RegistryObject<Block> WOOD = REGISTRY.register("wood", () -> new WoodBlock());
	public static final RegistryObject<Block> WOODEN_PLANKS = REGISTRY.register("wooden_planks", () -> new WoodenPlanksBlock());
	public static final RegistryObject<Block> TREE_LEAVES = REGISTRY.register("tree_leaves", () -> new TreeLeavesBlock());
	public static final RegistryObject<Block> OBSIDIAN = REGISTRY.register("obsidian", () -> new ObsidianBlock());
	public static final RegistryObject<Block> GRAVEL = REGISTRY.register("gravel", () -> new GravelBlock());
	public static final RegistryObject<Block> WOOD_6_SIDED = REGISTRY.register("wood_6_sided", () -> new Wood6SidedBlock());
	public static final RegistryObject<Block> BEYOND_THE_DREAM_PORTAL = REGISTRY.register("beyond_the_dream_portal", () -> new BeyondTheDreamPortalBlock());
	public static final RegistryObject<Block> GLASS = REGISTRY.register("glass", () -> new GlassBlock());
	public static final RegistryObject<Block> SAND = REGISTRY.register("sand", () -> new SandBlock());
}
