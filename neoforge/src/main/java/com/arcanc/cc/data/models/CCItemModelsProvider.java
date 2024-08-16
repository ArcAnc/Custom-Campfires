/**
 * @author ArcAnc
 * Created at: 15.08.2024
 * Copyright (c) 2024
 * <p>
 * This code is licensed under "Arc's License of Common Sense"
 * Details can be found in the license file in the root folder of this project
 */

package com.arcanc.cc.data.models;

import com.arcanc.cc.Database;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class CCItemModelsProvider extends ItemModelProvider
{
    public CCItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, Database.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {

    }
}
