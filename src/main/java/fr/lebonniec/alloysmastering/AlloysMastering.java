package fr.lebonniec.alloysmastering;

import fr.lebonniec.alloysmastering.events.CastIronArmorEffect;
import fr.lebonniec.alloysmastering.init.*;
import fr.lebonniec.alloysmastering.utils.References;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


/**
 * Main class of the mod
 */
@Mod(References.MODID)
public class AlloysMastering
{

    public AlloysMastering()
    {

        final IEventBus BUS = FMLJavaModLoadingContext.get()
                                                      .getModEventBus();

        BUS.addListener(this::setup);
        BUS.addListener(this::clientSetup);

        ModItems.ITEMS.register(BUS);
        ModBlocks.BLOCKS.register(BUS);
    }

    private void setup(FMLCommonSetupEvent event)
    {

        final ModFeatures modFeatures = new ModFeatures();
        modFeatures.init();
        MinecraftForge.EVENT_BUS.register(modFeatures);
        MinecraftForge.EVENT_BUS.register(CastIronArmorEffect.class);
    }

    private void clientSetup(FMLClientSetupEvent event)
    {

    }

}
