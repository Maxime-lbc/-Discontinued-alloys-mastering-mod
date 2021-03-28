package fr.lebonniec.alloysmastering;

import fr.lebonniec.alloysmastering.init.ModItems;
import fr.lebonniec.alloysmastering.utils.References;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(References.MODID)
public class AlloysMastering
{

    public AlloysMastering()
    {
        final IEventBus BUS = FMLJavaModLoadingContext.get().getModEventBus();

        BUS.addListener(this::setup);
        BUS.addListener(this::clientSetup);

        ModItems.ITEMS.register(BUS);
    }

    private void setup(FMLCommonSetupEvent event)
    {

    }

    private void clientSetup(FMLClientSetupEvent event)
    {

    }
}
