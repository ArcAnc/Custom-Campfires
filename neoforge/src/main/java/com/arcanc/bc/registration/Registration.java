/**
 * @author ArcAnc
 * Created at: 15.08.2024
 * Copyright (c) 2024
 * <p>
 * This code is licensed under "Arc's License of Common Sense"
 * Details can be found in the license file in the root folder of this project
 */

package com.arcanc.bc.registration;

import com.arcanc.bc.Database;
import com.arcanc.bc.content.BlockDatabase;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class Registration
{

    public static final class ItemRegister
    {
        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Database.MOD_ID);

        public static void init(@NotNull final IEventBus modEventBus)
        {
            ITEMS.register(modEventBus);
        }
    }

    public static final class BlockRegister
    {
        public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Database.MOD_ID);

        public static final CampfireRegObject ACACIA = register(WoodType.ACACIA);
        public static final CampfireRegObject BAMBOO = register(WoodType.BAMBOO);
        public static final CampfireRegObject BIRCH = register(WoodType.BIRCH);
        public static final CampfireRegObject CHERRY = register(WoodType.CHERRY);
        public static final CampfireRegObject CRIMSON = register(WoodType.CRIMSON);
        public static final CampfireRegObject DARK_OAK = register(WoodType.DARK_OAK);
        public static final CampfireRegObject JUNGLE = register(WoodType.JUNGLE);
        public static final CampfireRegObject MANGROVE = register(WoodType.MANGROVE);
        public static final CampfireRegObject OAK = new CampfireRegObject(Blocks.CAMPFIRE, Blocks.SOUL_CAMPFIRE);
        public static final CampfireRegObject SPRUCE = register(WoodType.SPRUCE);
        public static final CampfireRegObject WARPED = register(WoodType.WARPED);

        public static @Nullable CampfireRegObject getByWoodType (WoodType type)
        {
            if (type == WoodType.OAK)
                return OAK;
            else if (type == WoodType.SPRUCE)
                return SPRUCE;
            else if (type == WoodType.BIRCH)
                return BIRCH;
            else if (type == WoodType.ACACIA)
                return ACACIA;
            else if (type == WoodType.CHERRY)
                return CHERRY;
            else if (type == WoodType.JUNGLE)
                return JUNGLE;
            else if (type == WoodType.DARK_OAK)
                return DARK_OAK;
            else if (type == WoodType.CRIMSON)
                return CRIMSON;
            else if (type == WoodType.WARPED)
                return WARPED;
            else if (type == WoodType.MANGROVE)
                return MANGROVE;
            else if (type == WoodType.BAMBOO)
                return BAMBOO;
            return null;
        }

        private static @NotNull CampfireRegObject register(@NotNull WoodType type)
        {
           return new CampfireRegObject(type, () -> BlockDatabase.getNormalByWoodType(type), () -> BlockDatabase.getSoulByWoodType(type));
        }

        public static class CampfireRegObject
        {
            private final WoodType type;
            private final DeferredHolder<Block, CampfireBlock> NORMAL;
            private final DeferredHolder<Block, CampfireBlock> SOUL;

            private CampfireRegObject(@NotNull WoodType type, Supplier<CampfireBlock> normal, Supplier<CampfireBlock> soul)
            {
                this.type = type;
                NORMAL = BLOCKS.register(type.name() + "_campfire", normal);
                ItemRegister.ITEMS.register(type.name() + "_campfire", () -> new BlockItem(normal.get(), new Item.Properties()));
                SOUL = BLOCKS.register(type.name() + "_soul_campfire", soul);
                ItemRegister.ITEMS.register(type.name() + "_soul_campfire", () -> new BlockItem(soul.get(), new Item.Properties()));
            }

            private CampfireRegObject (Block campfireBlock, Block soulCampfireBlock)
            {
                this.type = WoodType.OAK;
                NORMAL = DeferredHolder.create(Registries.BLOCK, BuiltInRegistries.BLOCK.getKey(campfireBlock));
                SOUL = DeferredHolder.create(Registries.BLOCK, BuiltInRegistries.BLOCK.getKey(soulCampfireBlock));
            }

            public DeferredHolder<Block, CampfireBlock> getNormalCampfire()
            {
                return NORMAL;
            }

            public DeferredHolder<Block, CampfireBlock> getSoulCampfire()
            {
                return SOUL;
            }

            public WoodType getWoodType()
            {
                return type;
            }
        }

        public static void init(@NotNull final IEventBus modEventBus)
        {
            BLOCKS.register(modEventBus);
        }
    }

    public static void init (@NotNull final IEventBus modEventBus)
    {
        ItemRegister.init(modEventBus);
        BlockRegister.init(modEventBus);
    }
}
