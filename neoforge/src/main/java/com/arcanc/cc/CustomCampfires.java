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
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mod(Database.MOD_ID)
public class CustomCampfires
{

    public CustomCampfires(IEventBus eventBus, ModContainer modContainer)
    {
        CommonClass.init();

        Registration.init(eventBus);

        eventBus.addListener(this :: gatherData);
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