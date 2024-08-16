package com.arcanc.cc;

import com.arcanc.cc.content.BlockDatabase;
import com.arcanc.cc.content.Blocks;
import com.arcanc.cc.mixin.BEHook;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomCampfires implements ModInitializer
{
    
    @Override
    public void onInitialize()
    {
        CommonClass.init();

        Blocks.init();

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).
                register(tab -> tab.acceptAll(WoodType.values().filter(type -> type != WoodType.OAK).
                        flatMap(type ->
                        {
                            Block normal = BlockDatabase.getNormalByWoodType(type);
                            Block soul = BlockDatabase.getSoulByWoodType(type);
                            return Stream.of(normal, soul);
                        }).
                        map(block -> block.asItem().getDefaultInstance()).
                        collect(Collectors.toSet())));

        BlockEntityType<CampfireBlockEntity> be = BlockEntityType.CAMPFIRE;
        Set<Block> currentBlocks = ((BEHook)be).getValidBlocks();
        Set<Block> newBlocks = WoodType.values().filter(type -> type != WoodType.OAK).
                flatMap(type ->
                {
                    Block normal = BlockDatabase.getNormalByWoodType(type);
                    Block soul = BlockDatabase.getSoulByWoodType(type);
                    return Stream.of(normal, soul);
                }).
                collect(Collectors.toSet());
        newBlocks.addAll(currentBlocks);
        ((BEHook) be).setValidBlocks(newBlocks);

        BlockRenderLayerMapImpl.INSTANCE.putBlocks(RenderType.cutout(), WoodType.values().
                        filter(type -> type != WoodType.OAK).
                        flatMap(type ->
                        {
                            Block normal = BlockDatabase.getNormalByWoodType(type);
                            Block soul = BlockDatabase.getSoulByWoodType(type);
                            return Stream.of(normal, soul);
                        }).toArray(Block[]::new));
    }
}
