package com.arcanc.cc;

import com.arcanc.cc.data.CCBlockLootSubProvider;
import com.arcanc.cc.data.CCRecipeProvider;
import com.arcanc.cc.data.lang.CCEnUsLangProvider;
import com.arcanc.cc.data.models.CCBlockStateProvider;
import com.arcanc.cc.data.tags.CCBlockTagsProvider;
import com.arcanc.cc.data.tags.CCItemTagsProvider;
import com.arcanc.cc.mixin.BEHook;
import com.arcanc.cc.reg.Registration;
import com.google.common.collect.ImmutableSet;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Mod(Database.MOD_ID)
public class CustomCampfires
{
    
    public CustomCampfires()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Registration.init(modEventBus);

        modEventBus.addListener(this :: remapEvent);
        modEventBus.addListener(this :: fillCreativeTabs);

        modEventBus.addListener(this :: gatherData);
    }

    private void fillCreativeTabs(@NotNull final BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey().equals(CreativeModeTabs.FUNCTIONAL_BLOCKS))
        {
            event.acceptAll(WoodType.values().
                    filter(type -> type != WoodType.OAK).
                    flatMap(type ->
                    {
                        Registration.BlockRegister.CampfireRegObject obj = Registration.BlockRegister.getByWoodType(type);
                        if (obj != null)
                            return Stream.of(obj.getNormalCampfire().get(), obj.getSoulCampfire().get());
                        return Stream.of();
                    }).
                    map(campfireBlock -> campfireBlock.asItem().getDefaultInstance()).
                    collect(Collectors.toSet()));
        }
    }

    private void remapEvent(@NotNull final RegisterEvent event)
    {

        if (!event.getRegistryKey().equals(Registries.BLOCK_ENTITY_TYPE))
            return;
        BlockEntityType<CampfireBlockEntity> be = BlockEntityType.CAMPFIRE;
        Set<Block> newBlocks = WoodType.values().
                filter(type -> type != WoodType.OAK).
                flatMap(type ->
                {
                    Registration.BlockRegister.CampfireRegObject obj = Registration.BlockRegister.getByWoodType(type);
                    if (obj != null)
                        return Stream.of(obj.getNormalCampfire().get(), obj.getSoulCampfire().get());
                    return Stream.of();
                }).collect(Collectors.toSet());

        Set<Block> oldBlocks = ((BEHook)be).getValidBlocks();
        newBlocks.addAll(oldBlocks);
        ((BEHook) be).setValidBlocks(ImmutableSet.copyOf(newBlocks));
    }

    private void gatherData(@NotNull final GatherDataEvent event)
    {
        ExistingFileHelper ext = event.getExistingFileHelper();
        DataGenerator gen = event.getGenerator();
        PackOutput packOutput = gen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        gen.addProvider(event.includeServer(), new LootTableProvider(
                packOutput,
                Collections.emptySet(),
                List.of(
                        new LootTableProvider.SubProviderEntry(CCBlockLootSubProvider :: new, LootContextParamSets.BLOCK))
        ));

        CCBlockTagsProvider ccBlockTagsProvider = new CCBlockTagsProvider(packOutput, lookupProvider, ext);

        gen.addProvider(event.includeServer(), ccBlockTagsProvider);
        gen.addProvider(event.includeServer(), new CCItemTagsProvider(packOutput, lookupProvider, ccBlockTagsProvider.contentsGetter(), ext));
        gen.addProvider(event.includeServer(), new CCRecipeProvider(packOutput));
        gen.addProvider(event.includeClient(), new CCEnUsLangProvider(packOutput));
        gen.addProvider(event.includeClient(), new CCBlockStateProvider(packOutput, ext));
    }
}