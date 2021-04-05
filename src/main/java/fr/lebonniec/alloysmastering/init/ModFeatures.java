package fr.lebonniec.alloysmastering.init;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * Class in which ore generation is set up
 */
public class ModFeatures
{


    public static ConfiguredFeature<?,?> CARBON_ORE_FEATURE;
    public static ConfiguredFeature<?,?> COPPER_ORE_FEATURE;

    public void init()
    {
        CARBON_ORE_FEATURE = register(
                "carbon_ore.json",
                Feature.ORE.withConfiguration(new OreFeatureConfig(
                        OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                        ModBlocks.CARBON_ORE.get().getDefaultState(),
                        5
                ))
                .square()
                .range(50)
                .func_242731_b(15)
        );

        COPPER_ORE_FEATURE = register(
                "copper_ore.json",
                Feature.ORE.withConfiguration(new OreFeatureConfig(
                        OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                        ModBlocks.COPPER_ORE.get().getDefaultState(),
                        4
                ))
                        .square()
                        .range(40)
                        .func_242731_b(15)
        );
    }

    public <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> feature)
    {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, name, feature);
    }


    @SubscribeEvent
    public void biomeLoading(BiomeLoadingEvent event){
        BiomeGenerationSettingsBuilder generation = event.getGeneration();

        if (event.getCategory() != Biome.Category.NETHER){
            generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, CARBON_ORE_FEATURE);
            generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, COPPER_ORE_FEATURE);
        }
    }


}
