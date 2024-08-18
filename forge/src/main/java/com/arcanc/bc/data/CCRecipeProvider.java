/**
 * @author ArcAnc
 * Created at: 17.08.2024
 * Copyright (c) 2024
 * <p>
 * This code is licensed under "Arc's License of Common Sense"
 * Details can be found in the license file in the root folder of this project
 */

package com.arcanc.bc.data;

import com.arcanc.bc.reg.Registration;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class CCRecipeProvider extends RecipeProvider
{

    public CCRecipeProvider(PackOutput pOutput)
    {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pRecipeOutput)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Blocks.CAMPFIRE)
                .define('L', ItemTags.OAK_LOGS)
                .define('S', Items.STICK)
                .define('C', ItemTags.COALS)
                .pattern(" S ")
                .pattern("SCS")
                .pattern("LLL")
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_coal", has(ItemTags.COALS))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Blocks.SOUL_CAMPFIRE)
                .define('L', ItemTags.OAK_LOGS)
                .define('S', Items.STICK)
                .define('#', ItemTags.SOUL_FIRE_BASE_BLOCKS)
                .pattern(" S ")
                .pattern("S#S")
                .pattern("LLL")
                .unlockedBy("has_soul_sand", has(ItemTags.SOUL_FIRE_BASE_BLOCKS))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Registration.BlockRegister.ACACIA.getNormalCampfire().get())
                .define('L', ItemTags.ACACIA_LOGS)
                .define('S', Items.STICK)
                .define('C', ItemTags.COALS)
                .pattern(" S ")
                .pattern("SCS")
                .pattern("LLL")
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_coal", has(ItemTags.COALS))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Registration.BlockRegister.ACACIA.getSoulCampfire().get())
                .define('L', ItemTags.ACACIA_LOGS)
                .define('S', Items.STICK)
                .define('#', ItemTags.SOUL_FIRE_BASE_BLOCKS)
                .pattern(" S ")
                .pattern("S#S")
                .pattern("LLL")
                .unlockedBy("has_soul_sand", has(ItemTags.SOUL_FIRE_BASE_BLOCKS))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Registration.BlockRegister.BAMBOO.getNormalCampfire().get())
                .define('L', ItemTags.BAMBOO_BLOCKS)
                .define('S', Items.STICK)
                .define('C', ItemTags.COALS)
                .pattern(" S ")
                .pattern("SCS")
                .pattern("LLL")
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_coal", has(ItemTags.COALS))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Registration.BlockRegister.BAMBOO.getSoulCampfire().get())
                .define('L', ItemTags.BAMBOO_BLOCKS)
                .define('S', Items.STICK)
                .define('#', ItemTags.SOUL_FIRE_BASE_BLOCKS)
                .pattern(" S ")
                .pattern("S#S")
                .pattern("LLL")
                .unlockedBy("has_soul_sand", has(ItemTags.SOUL_FIRE_BASE_BLOCKS))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Registration.BlockRegister.BIRCH.getNormalCampfire().get())
                .define('L', ItemTags.BIRCH_LOGS)
                .define('S', Items.STICK)
                .define('C', ItemTags.COALS)
                .pattern(" S ")
                .pattern("SCS")
                .pattern("LLL")
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_coal", has(ItemTags.COALS))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Registration.BlockRegister.BIRCH.getSoulCampfire().get())
                .define('L', ItemTags.BIRCH_LOGS)
                .define('S', Items.STICK)
                .define('#', ItemTags.SOUL_FIRE_BASE_BLOCKS)
                .pattern(" S ")
                .pattern("S#S")
                .pattern("LLL")
                .unlockedBy("has_soul_sand", has(ItemTags.SOUL_FIRE_BASE_BLOCKS))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Registration.BlockRegister.CHERRY.getNormalCampfire().get())
                .define('L', ItemTags.CHERRY_LOGS)
                .define('S', Items.STICK)
                .define('C', ItemTags.COALS)
                .pattern(" S ")
                .pattern("SCS")
                .pattern("LLL")
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_coal", has(ItemTags.COALS))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Registration.BlockRegister.CHERRY.getSoulCampfire().get())
                .define('L', ItemTags.CHERRY_LOGS)
                .define('S', Items.STICK)
                .define('#', ItemTags.SOUL_FIRE_BASE_BLOCKS)
                .pattern(" S ")
                .pattern("S#S")
                .pattern("LLL")
                .unlockedBy("has_soul_sand", has(ItemTags.SOUL_FIRE_BASE_BLOCKS))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Registration.BlockRegister.CRIMSON.getNormalCampfire().get())
                .define('L', ItemTags.CRIMSON_STEMS)
                .define('S', Items.STICK)
                .define('C', ItemTags.COALS)
                .pattern(" S ")
                .pattern("SCS")
                .pattern("LLL")
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_coal", has(ItemTags.COALS))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Registration.BlockRegister.CRIMSON.getSoulCampfire().get())
                .define('L', ItemTags.CRIMSON_STEMS)
                .define('S', Items.STICK)
                .define('#', ItemTags.SOUL_FIRE_BASE_BLOCKS)
                .pattern(" S ")
                .pattern("S#S")
                .pattern("LLL")
                .unlockedBy("has_soul_sand", has(ItemTags.SOUL_FIRE_BASE_BLOCKS))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Registration.BlockRegister.DARK_OAK.getNormalCampfire().get())
                .define('L', ItemTags.DARK_OAK_LOGS)
                .define('S', Items.STICK)
                .define('C', ItemTags.COALS)
                .pattern(" S ")
                .pattern("SCS")
                .pattern("LLL")
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_coal", has(ItemTags.COALS))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Registration.BlockRegister.DARK_OAK.getSoulCampfire().get())
                .define('L', ItemTags.DARK_OAK_LOGS)
                .define('S', Items.STICK)
                .define('#', ItemTags.SOUL_FIRE_BASE_BLOCKS)
                .pattern(" S ")
                .pattern("S#S")
                .pattern("LLL")
                .unlockedBy("has_soul_sand", has(ItemTags.SOUL_FIRE_BASE_BLOCKS))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Registration.BlockRegister.JUNGLE.getNormalCampfire().get())
                .define('L', ItemTags.JUNGLE_LOGS)
                .define('S', Items.STICK)
                .define('C', ItemTags.COALS)
                .pattern(" S ")
                .pattern("SCS")
                .pattern("LLL")
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_coal", has(ItemTags.COALS))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Registration.BlockRegister.JUNGLE.getSoulCampfire().get())
                .define('L', ItemTags.JUNGLE_LOGS)
                .define('S', Items.STICK)
                .define('#', ItemTags.SOUL_FIRE_BASE_BLOCKS)
                .pattern(" S ")
                .pattern("S#S")
                .pattern("LLL")
                .unlockedBy("has_soul_sand", has(ItemTags.SOUL_FIRE_BASE_BLOCKS))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Registration.BlockRegister.MANGROVE.getNormalCampfire().get())
                .define('L', ItemTags.MANGROVE_LOGS)
                .define('S', Items.STICK)
                .define('C', ItemTags.COALS)
                .pattern(" S ")
                .pattern("SCS")
                .pattern("LLL")
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_coal", has(ItemTags.COALS))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Registration.BlockRegister.MANGROVE.getSoulCampfire().get())
                .define('L', ItemTags.MANGROVE_LOGS)
                .define('S', Items.STICK)
                .define('#', ItemTags.SOUL_FIRE_BASE_BLOCKS)
                .pattern(" S ")
                .pattern("S#S")
                .pattern("LLL")
                .unlockedBy("has_soul_sand", has(ItemTags.SOUL_FIRE_BASE_BLOCKS))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Registration.BlockRegister.SPRUCE.getNormalCampfire().get())
                .define('L', ItemTags.SPRUCE_LOGS)
                .define('S', Items.STICK)
                .define('C', ItemTags.COALS)
                .pattern(" S ")
                .pattern("SCS")
                .pattern("LLL")
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_coal", has(ItemTags.COALS))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Registration.BlockRegister.SPRUCE.getSoulCampfire().get())
                .define('L', ItemTags.SPRUCE_LOGS)
                .define('S', Items.STICK)
                .define('#', ItemTags.SOUL_FIRE_BASE_BLOCKS)
                .pattern(" S ")
                .pattern("S#S")
                .pattern("LLL")
                .unlockedBy("has_soul_sand", has(ItemTags.SOUL_FIRE_BASE_BLOCKS))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Registration.BlockRegister.WARPED.getNormalCampfire().get())
                .define('L', ItemTags.WARPED_STEMS)
                .define('S', Items.STICK)
                .define('C', ItemTags.COALS)
                .pattern(" S ")
                .pattern("SCS")
                .pattern("LLL")
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_coal", has(ItemTags.COALS))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Registration.BlockRegister.WARPED.getSoulCampfire().get())
                .define('L', ItemTags.WARPED_STEMS)
                .define('S', Items.STICK)
                .define('#', ItemTags.SOUL_FIRE_BASE_BLOCKS)
                .pattern(" S ")
                .pattern("S#S")
                .pattern("LLL")
                .unlockedBy("has_soul_sand", has(ItemTags.SOUL_FIRE_BASE_BLOCKS))
                .save(pRecipeOutput);
    }
}
