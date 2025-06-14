package net.justmili.trueend.procedures.randomevents;

import java.util.List;

import net.justmili.trueend.TrueEnd;
import net.justmili.trueend.init.TrueEndBlocks;
import net.justmili.trueend.init.TrueEndEntities;
import net.justmili.trueend.network.TrueEndVariables;
import static net.justmili.trueend.regs.DimKeyRegistry.BTD;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jline.utils.DiffHelper;

@Mod.EventBusSubscriber
public class EntitySpawning {
    @SubscribeEvent
    public static void onWorldTick(TickEvent.LevelTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            execute(event);
        }
    }

    private static void execute(TickEvent.LevelTickEvent lvlEvent) {
        Level lvl = lvlEvent.level;
        if (lvl.isClientSide()) {
            return;
        }
        ServerLevel world = (ServerLevel) lvl;
        long gameTicks = world.getGameTime();
        if (gameTicks % 100L != 0L) {
            return;
        }

        // Difficulty-based multiplier
        Difficulty difficulty;
        double chanceMultiplier = 0.0;
        difficulty = ((LevelAccessor) world).getDifficulty();
        if (difficulty == Difficulty.PEACEFUL) {
            chanceMultiplier = 0.1;
        } else if (difficulty == Difficulty.EASY) {
            chanceMultiplier = 0.5;
        } else if (difficulty == Difficulty.NORMAL) {
            chanceMultiplier = 1.0;
        } else if (difficulty == Difficulty.HARD) {
            chanceMultiplier = 3.0;
        }

        //The IF's
        if (world.dimension() == BTD) {
            if (TrueEndVariables.randomEventsToggle.getValue()) {
                if (Math.random() < (TrueEndVariables.entitySpawnChance.getValue() * chanceMultiplier)) {
                    if (!TrueEndVariables.MapVariables.get(world).isUnknownInWorld()) {
                        //Spawning
                        TrueEnd.LOGGER.info("Searching for 'Unknown' entity spawn position...");

                        List<ServerPlayer> players = world.players();
                        if (players.isEmpty()) {
                            return;
                        }
                        ServerPlayer player = players.get(world.getRandom().nextInt(players.size()));

                        double px = player.getX();
                        double pz = player.getZ();
                        double angle = world.getRandom().nextDouble() * Math.PI * 2.0;
                        double minDist = 32.0;
                        double maxDist = (Minecraft.getInstance().gameRenderer.getRenderDistance() * 16) - 16;
                        double distance = minDist + world.getRandom().nextDouble() * (maxDist - minDist);
                        int spawnX = Mth.floor(px + Math.cos(angle) * distance);
                        int spawnZ = Mth.floor(pz + Math.sin(angle) * distance);
                        int spawnY = world.getHeight(Heightmap.Types.MOTION_BLOCKING, spawnX, spawnZ);

                        BlockPos groundPos = new BlockPos(spawnX, spawnY, spawnZ);
                        Block groundBlock = world.getBlockState(groundPos).getBlock();

                        Block grassBlock = TrueEndBlocks.GRASS_BLOCK.get();
                        Block stoneBlock = TrueEndBlocks.STONE.get();
                        Block sandBlock = TrueEndBlocks.SAND.get();

                        if (groundBlock == grassBlock || groundBlock == stoneBlock || grassBlock == sandBlock) {
                            BlockPos posOne = new BlockPos(spawnX, spawnY + 1, spawnZ);
                            BlockPos posTwo = new BlockPos(spawnX, spawnY + 2, spawnZ);
                            if (world.isEmptyBlock(posOne) && world.isEmptyBlock(posTwo)) {
                                EntityType<?> unknownType = TrueEndEntities.UNKNOWN.get();
                                Entity unknownEntity = unknownType.create(world);
                                unknownEntity.moveTo(spawnX + 0.5, spawnY + 1.0, spawnZ + 0.5,
                                        world.getRandom().nextFloat() * 360.0F,
                                        0.0F);

                                unknownEntity.getPersistentData().putBoolean("PersistenceRequired", true);
                                world.addFreshEntity(unknownEntity);

                                TrueEnd.LOGGER.info("Spawned 'unknown' at X={}, Y={}, Z={}", spawnX, spawnY + 1, spawnZ);
                                TrueEndVariables.MapVariables.get(world).setUnknownInWorld(true);
                            }
                        } else {
                            TrueEnd.LOGGER.error("Entity spawn attempt failed, tried to spawn on a blacklisted block.");
                        }
                    } else {
                        System.err.println("Entity spawn attempt failed, entity already in the world.");
                    }
                }
            }
        }
    }
}