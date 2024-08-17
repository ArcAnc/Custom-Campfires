/**
 * @author ArcAnc
 * Created at: 17.08.2024
 * Copyright (c) 2024
 * <p>
 * This code is licensed under "Arc's License of Common Sense"
 * Details can be found in the license file in the root folder of this project
 */

package com.arcanc.cc.data.tags;

import com.arcanc.cc.Database;
import com.arcanc.cc.reg.Registration;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CCBlockTagsProvider extends BlockTagsProvider
{
    public CCBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, Database.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider)
    {
        WoodType.values().filter(type -> type != WoodType.OAK).
                forEach(type ->
                {
                    Registration.BlockRegister.CampfireRegObject obj = Registration.BlockRegister.getByWoodType(type);
                    if (obj != null)
                    {
                        this.tag(BlockTags.CAMPFIRES).add(obj.getNormalCampfire().get(), obj.getSoulCampfire().get());
                        this.tag(BlockTags.PIGLIN_REPELLENTS).add(obj.getSoulCampfire().get());
                        this.tag(BlockTags.MINEABLE_WITH_AXE).add(obj.getNormalCampfire().get(), obj.getSoulCampfire().get());
                    }
                });
    }

    @Override
    public @NotNull String getName()
    {
        return Database.MOD_NAME + "Block Tags";
    }
}