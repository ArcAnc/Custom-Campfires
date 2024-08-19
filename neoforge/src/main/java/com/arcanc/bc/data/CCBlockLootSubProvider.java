/**
 * @author ArcAnc
 * Created at: 15.08.2024
 * Copyright (c) 2024
 * <p>
 * This code is licensed under "Arc's License of Common Sense"
 * Details can be found in the license file in the root folder of this project
 */

package com.arcanc.bc.data;

import com.arcanc.bc.registration.Registration;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CCBlockLootSubProvider extends BlockLootSubProvider
{
    private static final Set<Item> EXPLOSION_RESISTANT = Stream.of(
                    Blocks.DRAGON_EGG,
                    Blocks.BEACON,
                    Blocks.CONDUIT,
                    Blocks.SKELETON_SKULL,
                    Blocks.WITHER_SKELETON_SKULL,
                    Blocks.PLAYER_HEAD,
                    Blocks.ZOMBIE_HEAD,
                    Blocks.CREEPER_HEAD,
                    Blocks.DRAGON_HEAD,
                    Blocks.PIGLIN_HEAD,
                    Blocks.SHULKER_BOX,
                    Blocks.BLACK_SHULKER_BOX,
                    Blocks.BLUE_SHULKER_BOX,
                    Blocks.BROWN_SHULKER_BOX,
                    Blocks.CYAN_SHULKER_BOX,
                    Blocks.GRAY_SHULKER_BOX,
                    Blocks.GREEN_SHULKER_BOX,
                    Blocks.LIGHT_BLUE_SHULKER_BOX,
                    Blocks.LIGHT_GRAY_SHULKER_BOX,
                    Blocks.LIME_SHULKER_BOX,
                    Blocks.MAGENTA_SHULKER_BOX,
                    Blocks.ORANGE_SHULKER_BOX,
                    Blocks.PINK_SHULKER_BOX,
                    Blocks.PURPLE_SHULKER_BOX,
                    Blocks.RED_SHULKER_BOX,
                    Blocks.WHITE_SHULKER_BOX,
                    Blocks.YELLOW_SHULKER_BOX
            )
            .map(ItemLike::asItem)
            .collect(Collectors.toSet());

    public CCBlockLootSubProvider(HolderLookup.Provider pRegistries)
    {
        super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate()
    {
        WoodType.values().filter(type -> type != WoodType.OAK).
                forEach(type ->
                {
                    this.add(
                            Registration.BlockRegister.getByWoodType(type).getNormalCampfire().get(),
                            block -> this.createSilkTouchDispatchTable(
                                    block,
                                    this.applyExplosionCondition(
                                            block, LootItem.lootTableItem(Items.CHARCOAL).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))
                                    )
                            )
                    );

                    this.add(
                            Registration.BlockRegister.getByWoodType(type).getSoulCampfire().get(),
                            block -> this.createSilkTouchDispatchTable(
                                    block,
                                    this.applyExplosionCondition(
                                            block, LootItem.lootTableItem(Items.SOUL_SOIL).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                                    )
                            )
                    );
                });
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks()
    {
        return Registration.BlockRegister.BLOCKS.
                getEntries().
                stream().
                map(DeferredHolder :: get).
                filter(block -> !block.getLootTable().equals(BuiltInLootTables.EMPTY)).
                collect(Collectors.toSet());
    }
}
