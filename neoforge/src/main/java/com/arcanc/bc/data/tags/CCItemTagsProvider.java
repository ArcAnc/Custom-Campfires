/**
 * @author ArcAnc
 * Created at: 15.08.2024
 * Copyright (c) 2024
 * <p>
 * This code is licensed under "Arc's License of Common Sense"
 * Details can be found in the license file in the root folder of this project
 */

package com.arcanc.bc.data.tags;

import com.arcanc.bc.Database;
import com.arcanc.bc.registration.Registration;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CCItemTagsProvider extends ItemTagsProvider
{
    public CCItemTagsProvider(PackOutput pOutput,
                              CompletableFuture<HolderLookup.Provider> pLookupProvider,
                              CompletableFuture<TagLookup<Block>> pBlockTags,
                              @Nullable ExistingFileHelper existingFileHelper)
    {
        super(pOutput, pLookupProvider, pBlockTags, Database.MOD_ID, existingFileHelper);
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
                        this.tag(ItemTags.PIGLIN_REPELLENTS).add(obj.getSoulCampfire().get().asItem());
                    }
                });
    }

    @Override
    public @NotNull String getName()
    {
        return Database.MOD_NAME;
    }
}
