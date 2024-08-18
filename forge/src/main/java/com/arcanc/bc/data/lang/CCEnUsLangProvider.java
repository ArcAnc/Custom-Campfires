/**
 * @author ArcAnc
 * Created at: 17.08.2024
 * Copyright (c) 2024
 * <p>
 * This code is licensed under "Arc's License of Common Sense"
 * Details can be found in the license file in the root folder of this project
 */

package com.arcanc.bc.data.lang;

import com.arcanc.bc.Database;
import com.arcanc.bc.reg.Registration;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.common.data.LanguageProvider;

public class CCEnUsLangProvider extends LanguageProvider
{
    public CCEnUsLangProvider(PackOutput output)
    {
        super(output, Database.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations()
    {
        WoodType.values().forEach(type ->
        {
            Registration.BlockRegister.CampfireRegObject obj = Registration.BlockRegister.getByWoodType(type);
            if (obj != null)
            {
                String typeName = type == WoodType.DARK_OAK ?
                        type.name().substring(0, 1).toUpperCase() + type.name().replace("_o", " O").substring(1) :
                        type.name().substring(0, 1).toUpperCase() + type.name().substring(1).toLowerCase();
                this.add(obj.getNormalCampfire().get(), typeName + " Campfire");
                this.add(obj.getSoulCampfire().get(), typeName + " Soul Campfire");
            }
        });
    }
}
