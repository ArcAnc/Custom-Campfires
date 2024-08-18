/**
 * @author ArcAnc
 * Created at: 17.08.2024
 * Copyright (c) 2024
 * <p>
 * This code is licensed under "Arc's License of Common Sense"
 * Details can be found in the license file in the root folder of this project
 */

package com.arcanc.bc.content;

import com.arcanc.bc.Database;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.Comparator;

public class Blocks
{
    public static void register (Block block, String name)
    {
        ResourceLocation loc = new ResourceLocation(Database.MOD_ID, name);

        BlockItem item = new BlockItem(block, new Item.Properties());
        Registry.register(BuiltInRegistries.ITEM, loc, item);

        Registry.register(BuiltInRegistries.BLOCK, loc, block);
    }

    public static void init()
    {
        WoodType.values().filter(type -> type != WoodType.OAK).
                sorted(Comparator.comparing(WoodType::name)).
                forEach(type ->
                {
                    register(BlockDatabase.getNormalByWoodType(type), type.name() + "_campfire");
                    register(BlockDatabase.getSoulByWoodType(type), type.name() + "_soul_campfire");
                });
    }
}
