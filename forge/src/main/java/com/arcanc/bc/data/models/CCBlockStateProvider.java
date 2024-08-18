/**
 * @author ArcAnc
 * Created at: 17.08.2024
 * Copyright (c) 2024
 * <p>
 * This code is licensed under "Arc's License of Common Sense"
 * Details can be found in the license file in the root folder of this project
 */

package com.arcanc.bc.data.models;

import com.arcanc.bc.Database;
import com.arcanc.bc.reg.Registration;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class CCBlockStateProvider extends BlockStateProvider
{
    public CCBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper)
    {
        super(output, Database.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        WoodType.values().
                filter(type -> type != WoodType.OAK).
                forEach(type ->
                {
                    Registration.BlockRegister.CampfireRegObject obj = Registration.BlockRegister.getByWoodType(type);
                    if (obj != null)
                    {
                        CampfireBlock normalCampfire = obj.getNormalCampfire().get();

                        ResourceLocation textureFire = new ResourceLocation(blockPrefix("campfire_fire"));
                        ResourceLocation textureLogLit = new ResourceLocation(Database.MOD_ID, blockPrefix(type.name() + "_campfire_log_lit"));
                        ResourceLocation textureLogOff = new ResourceLocation(Database.MOD_ID, blockPrefix(type.name() + "_campfire_log"));
                        ResourceLocation textureItemNormal = new ResourceLocation(Database.MOD_ID, itemPrefix(type.name() + "_campfire"));

                        ModelFile modelOn = models().withExistingParent(blockPrefix(name(normalCampfire)), mcLoc(blockPrefix("template_campfire"))).
                                renderType("cutout").
                                texture("fire", textureFire).
                                texture("lit_log", textureLogLit).
                                texture("log", textureLogOff).
                                texture("particle", textureLogLit);

                        ModelFile modelOff = models().withExistingParent(blockPrefix(name(normalCampfire)) + "_off", mcLoc(blockPrefix("campfire_off"))).
                                renderType("cutout").
                                texture("log", textureLogOff).
                                texture("particle", textureLogOff);

                        getVariantBuilder(normalCampfire).forAllStates(state ->
                        {
                            Direction facing = state.getValue(CampfireBlock.FACING);
                            boolean lit = state.getValue(CampfireBlock.LIT);

                            ConfiguredModel.Builder<?> builder = ConfiguredModel.builder();

                            builder.rotationY(90 * facing.get2DDataValue()).modelFile(lit ? modelOn : modelOff);

                            return builder.build();
                        });
                        itemModels().withExistingParent(itemPrefix(name(normalCampfire)), itemPrefix("generated")).
                                texture("layer0", textureItemNormal);

                        CampfireBlock soulCampfire = obj.getSoulCampfire().get();

                        textureFire = new  ResourceLocation(blockPrefix("soul_campfire_fire"));
                        textureLogLit = new ResourceLocation(Database.MOD_ID, blockPrefix(type.name() + "_soul_campfire_log_lit"));
                        textureLogOff = new ResourceLocation(Database.MOD_ID, blockPrefix(type.name() + "_campfire_log"));
                        textureItemNormal = new ResourceLocation(Database.MOD_ID, itemPrefix(type.name() + "_soul_campfire"));

                        ModelFile modelSoulOn = models().withExistingParent(blockPrefix(name(soulCampfire)), mcLoc(blockPrefix("template_campfire"))).
                                renderType("cutout").
                                texture("fire", textureFire).
                                texture("lit_log", textureLogLit).
                                texture("log", textureLogOff).
                                texture("particle", textureLogLit);

                        ModelFile modelSoulOff = models().withExistingParent(blockPrefix(name(soulCampfire)) + "_off", mcLoc(blockPrefix("campfire_off"))).
                                renderType("cutout").
                                texture("log", textureLogOff).
                                texture("particle", textureLogOff);

                        getVariantBuilder(soulCampfire).forAllStates(state ->
                        {
                            Direction facing = state.getValue(CampfireBlock.FACING);
                            boolean lit = state.getValue(CampfireBlock.LIT);

                            ConfiguredModel.Builder<?> builder = ConfiguredModel.builder();

                            builder.rotationY(90 * facing.get2DDataValue()).modelFile(lit ? modelSoulOn : modelSoulOff);

                            return builder.build();
                        });
                        itemModels().withExistingParent(itemPrefix(name(soulCampfire)), itemPrefix("generated")).
                                texture("layer0", textureItemNormal);

                    }
                });
    }

    private static @NotNull String blockPrefix(String str)
    {
        return "block/" + str;
    }

    private static @NotNull String itemPrefix(String str)
    {
        return "item/" + str;
    }

    private @NotNull String name(Block block)
    {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }

    @Override
    public @NotNull String getName()
    {
        return Database.MOD_NAME + "Block States and Models";
    }
}
