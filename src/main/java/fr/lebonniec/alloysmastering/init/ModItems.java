package fr.lebonniec.alloysmastering.init;

import fr.lebonniec.alloysmastering.utils.References;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems
{

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, References.MODID);

    /* Carbon */
    public static final RegistryObject<Item> CARBON_CHUNK = ITEMS.register(
            "carbon_chunk",
            () -> new Item(new Item.Properties()
                    .maxStackSize(64)
                    .group(ModItemsGroups.TAB)
            ));
}