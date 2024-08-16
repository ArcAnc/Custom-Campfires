package com.arcanc.cc;


import com.arcanc.cc.data.CCBlockLootSubProvider;
import com.arcanc.cc.data.CCRecipeProvider;
import com.arcanc.cc.data.lang.CCEnUsLangProvider;
import com.arcanc.cc.data.models.CCBlockStateProvider;
import com.arcanc.cc.data.tags.CCBlockTagsProvider;
import com.arcanc.cc.data.tags.CCItemTagsProvider;
import com.arcanc.cc.registration.Registration;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Mod(Database.MOD_ID)
public class CustomCampfires
{

    public CustomCampfires(IEventBus eventBus)
    {
        Registration.init(eventBus);

        //CommonClass.init();

        eventBus.addListener(this :: remapEvent);
        eventBus.addListener(this :: fillCreativeTabs);
        eventBus.addListener(this :: gatherData);
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

    private void remapEvent(@NotNull final BlockEntityTypeAddBlocksEvent event)
    {
        event.modify(BlockEntityType.CAMPFIRE, WoodType.values().
                filter(type -> type != WoodType.OAK).
                flatMap(type ->
                {
                    Registration.BlockRegister.CampfireRegObject obj = Registration.BlockRegister.getByWoodType(type);
                    if (obj != null)
                        return Stream.of(obj.getNormalCampfire().get(), obj.getSoulCampfire().get());
                    return Stream.of();
                }).toArray(Block[] :: new));
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
                        new LootTableProvider.SubProviderEntry(CCBlockLootSubProvider :: new, LootContextParamSets.BLOCK)),
                lookupProvider
        ));

        CCBlockTagsProvider ccBlockTagsProvider = new CCBlockTagsProvider(packOutput, lookupProvider, ext);

        gen.addProvider(event.includeServer(), ccBlockTagsProvider);
        gen.addProvider(event.includeServer(), new CCItemTagsProvider(packOutput, lookupProvider, ccBlockTagsProvider.contentsGetter(), ext));
        gen.addProvider(event.includeServer(), new CCRecipeProvider(packOutput, lookupProvider));
        gen.addProvider(event.includeClient(), new CCEnUsLangProvider(packOutput));
        gen.addProvider(event.includeClient(), new CCBlockStateProvider(packOutput, ext));
    }
}