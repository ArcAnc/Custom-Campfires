/**
 * @author ArcAnc
 * Created at: 15.08.2024
 * Copyright (c) 2024
 * <p>
 * This code is licensed under "Arc's License of Common Sense"
 * Details can be found in the license file in the root folder of this project
 */

package com.arcanc.bc.content;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.function.ToIntFunction;

public class BlockDatabase
{
    public static final CampfireBlock CAMPFIRE_SPRUCE = new CampfireBlock(true, 1, BlockBehaviour.Properties.of().
            mapColor(MapColor.PODZOL).
            instrument(NoteBlockInstrument.BASS).
            strength(2.0F).
            sound(SoundType.WOOD).
            lightLevel(litBlockEmission(15)).
            noOcclusion().
            ignitedByLava());

    public static final CampfireBlock CAMPFIRE_BIRCH = new CampfireBlock(true, 1, BlockBehaviour.Properties.of().
            mapColor(MapColor.PODZOL).
            instrument(NoteBlockInstrument.BASS).
            strength(2.0F).
            sound(SoundType.WOOD).
            lightLevel(litBlockEmission(15)).
            noOcclusion().
            ignitedByLava());

    public static final CampfireBlock CAMPFIRE_ACACIA = new CampfireBlock(true, 1, BlockBehaviour.Properties.of().
            mapColor(MapColor.PODZOL).
            instrument(NoteBlockInstrument.BASS).
            strength(2.0F).
            sound(SoundType.WOOD).
            lightLevel(litBlockEmission(15)).
            noOcclusion().
            ignitedByLava());

    public static final CampfireBlock CAMPFIRE_CHERRY = new CampfireBlock(true, 1, BlockBehaviour.Properties.of().
            mapColor(MapColor.PODZOL).
            instrument(NoteBlockInstrument.BASS).
            strength(2.0F).
            sound(SoundType.CHERRY_WOOD).
            lightLevel(litBlockEmission(15)).
            noOcclusion().
            ignitedByLava());

    public static final CampfireBlock CAMPFIRE_JUNGLE = new CampfireBlock(true, 1, BlockBehaviour.Properties.of().
            mapColor(MapColor.PODZOL).
            instrument(NoteBlockInstrument.BASS).
            strength(2.0F).
            sound(SoundType.WOOD).
            lightLevel(litBlockEmission(15)).
            noOcclusion().
            ignitedByLava());

    public static final CampfireBlock CAMPFIRE_DARK_OAK = new CampfireBlock(true, 1, BlockBehaviour.Properties.of().
            mapColor(MapColor.PODZOL).
            instrument(NoteBlockInstrument.BASS).
            strength(2.0F).
            sound(SoundType.WOOD).
            lightLevel(litBlockEmission(15)).
            noOcclusion().
            ignitedByLava());

    public static final CampfireBlock CAMPFIRE_CRIMSON = new CampfireBlock(true, 1, BlockBehaviour.Properties.of().
            mapColor(MapColor.PODZOL).
            instrument(NoteBlockInstrument.BASS).
            strength(2.0F).
            sound(SoundType.NETHER_WOOD).
            lightLevel(litBlockEmission(15)).
            noOcclusion().
            ignitedByLava());

    public static final CampfireBlock CAMPFIRE_WARPED = new CampfireBlock(true, 1, BlockBehaviour.Properties.of().
            mapColor(MapColor.PODZOL).
            instrument(NoteBlockInstrument.BASS).
            strength(2.0F).
            sound(SoundType.BAMBOO_WOOD).
            lightLevel(litBlockEmission(15)).
            noOcclusion().
            ignitedByLava());

    public static final CampfireBlock CAMPFIRE_MANGROVE = new CampfireBlock(true, 1, BlockBehaviour.Properties.of().
            mapColor(MapColor.PODZOL).
            instrument(NoteBlockInstrument.BASS).
            strength(2.0F).
            sound(SoundType.WOOD).
            lightLevel(litBlockEmission(15)).
            noOcclusion().
            ignitedByLava());

    public static final CampfireBlock CAMPFIRE_BAMBOO = new CampfireBlock(true, 1, BlockBehaviour.Properties.of().
            mapColor(MapColor.PODZOL).
            instrument(NoteBlockInstrument.BASS).
            strength(2.0F).
            sound(SoundType.BAMBOO_WOOD).
            lightLevel(litBlockEmission(15)).
            noOcclusion().
            ignitedByLava());

    //---------------------------------------------

    public static final CampfireBlock SOUL_CAMPFIRE_SPRUCE = new CampfireBlock(true, 2, BlockBehaviour.Properties.of().
            mapColor(MapColor.PODZOL).
            instrument(NoteBlockInstrument.BASS).
            strength(2.0F).
            sound(SoundType.WOOD).
            lightLevel(litBlockEmission(10)).
            noOcclusion().
            ignitedByLava());

    public static final CampfireBlock SOUL_CAMPFIRE_BIRCH = new CampfireBlock(true, 2, BlockBehaviour.Properties.of().
            mapColor(MapColor.PODZOL).
            instrument(NoteBlockInstrument.BASS).
            strength(2.0F).
            sound(SoundType.WOOD).
            lightLevel(litBlockEmission(10)).
            noOcclusion().
            ignitedByLava());

    public static final CampfireBlock SOUL_CAMPFIRE_ACACIA = new CampfireBlock(true, 2, BlockBehaviour.Properties.of().
            mapColor(MapColor.PODZOL).
            instrument(NoteBlockInstrument.BASS).
            strength(2.0F).
            sound(SoundType.WOOD).
            lightLevel(litBlockEmission(10)).
            noOcclusion().
            ignitedByLava());

    public static final CampfireBlock SOUL_CAMPFIRE_CHERRY = new CampfireBlock(true, 2, BlockBehaviour.Properties.of().
            mapColor(MapColor.PODZOL).
            instrument(NoteBlockInstrument.BASS).
            strength(2.0F).
            sound(SoundType.CHERRY_WOOD).
            lightLevel(litBlockEmission(10)).
            noOcclusion().
            ignitedByLava());

    public static final CampfireBlock SOUL_CAMPFIRE_JUNGLE = new CampfireBlock(true, 2, BlockBehaviour.Properties.of().
            mapColor(MapColor.PODZOL).
            instrument(NoteBlockInstrument.BASS).
            strength(2.0F).
            sound(SoundType.WOOD).
            lightLevel(litBlockEmission(10)).
            noOcclusion().
            ignitedByLava());

    public static final CampfireBlock SOUL_CAMPFIRE_DARK_OAK = new CampfireBlock(true, 2, BlockBehaviour.Properties.of().
            mapColor(MapColor.PODZOL).
            instrument(NoteBlockInstrument.BASS).
            strength(2.0F).
            sound(SoundType.WOOD).
            lightLevel(litBlockEmission(10)).
            noOcclusion().
            ignitedByLava());

    public static final CampfireBlock SOUL_CAMPFIRE_CRIMSON = new CampfireBlock(true, 2, BlockBehaviour.Properties.of().
            mapColor(MapColor.PODZOL).
            instrument(NoteBlockInstrument.BASS).
            strength(2.0F).
            sound(SoundType.NETHER_WOOD).
            lightLevel(litBlockEmission(10)).
            noOcclusion().
            ignitedByLava());

    public static final CampfireBlock SOUL_CAMPFIRE_WARPED = new CampfireBlock(true, 2, BlockBehaviour.Properties.of().
            mapColor(MapColor.PODZOL).
            instrument(NoteBlockInstrument.BASS).
            strength(2.0F).
            sound(SoundType.NETHER_WOOD).
            lightLevel(litBlockEmission(10)).
            noOcclusion().
            ignitedByLava());

    public static final CampfireBlock SOUL_CAMPFIRE_MANGROVE = new CampfireBlock(true, 2, BlockBehaviour.Properties.of().
            mapColor(MapColor.PODZOL).
            instrument(NoteBlockInstrument.BASS).
            strength(2.0F).
            sound(SoundType.WOOD).
            lightLevel(litBlockEmission(10)).
            noOcclusion().
            ignitedByLava());

    public static final CampfireBlock SOUL_CAMPFIRE_BAMBOO = new CampfireBlock(true, 2, BlockBehaviour.Properties.of().
            mapColor(MapColor.PODZOL).
            instrument(NoteBlockInstrument.BASS).
            strength(2.0F).
            sound(SoundType.BAMBOO_WOOD).
            lightLevel(litBlockEmission(10)).
            noOcclusion().
            ignitedByLava());

    public static final Map<WoodType, Pair<CampfireBlock, CampfireBlock>> BY_TREE_TYPE = ImmutableMap.<WoodType, Pair<CampfireBlock, CampfireBlock>>builder().
            put(WoodType.OAK, Pair.of((CampfireBlock) Blocks.CAMPFIRE, (CampfireBlock) Blocks.SOUL_CAMPFIRE)).
            put(WoodType.SPRUCE, Pair.of(CAMPFIRE_SPRUCE, SOUL_CAMPFIRE_SPRUCE)).
            put(WoodType.BIRCH, Pair.of(CAMPFIRE_BIRCH, SOUL_CAMPFIRE_BIRCH)).
            put(WoodType.ACACIA, Pair.of(CAMPFIRE_ACACIA, SOUL_CAMPFIRE_ACACIA)).
            put(WoodType.CHERRY, Pair.of(CAMPFIRE_CHERRY, SOUL_CAMPFIRE_CHERRY)).
            put(WoodType.JUNGLE, Pair.of(CAMPFIRE_JUNGLE, SOUL_CAMPFIRE_JUNGLE)).
            put(WoodType.DARK_OAK, Pair.of(CAMPFIRE_DARK_OAK, SOUL_CAMPFIRE_DARK_OAK)).
            put(WoodType.CRIMSON, Pair.of(CAMPFIRE_CRIMSON, SOUL_CAMPFIRE_CRIMSON)).
            put(WoodType.WARPED, Pair.of(CAMPFIRE_WARPED, SOUL_CAMPFIRE_WARPED)).
            put(WoodType.MANGROVE, Pair.of(CAMPFIRE_MANGROVE, SOUL_CAMPFIRE_MANGROVE)).
            put(WoodType.BAMBOO, Pair.of(CAMPFIRE_BAMBOO, SOUL_CAMPFIRE_BAMBOO)).
            build();

    public static CampfireBlock getSoulByWoodType(@NotNull WoodType type)
    {
        return BY_TREE_TYPE.get(type).getSecond();
    }

    public static CampfireBlock getNormalByWoodType(@NotNull WoodType type)
    {
        return BY_TREE_TYPE.get(type).getFirst();
    }

    private static @NotNull ToIntFunction<BlockState> litBlockEmission(int pLightValue)
    {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? pLightValue : 0;
    }

    public static void init()
    {

    }
}
