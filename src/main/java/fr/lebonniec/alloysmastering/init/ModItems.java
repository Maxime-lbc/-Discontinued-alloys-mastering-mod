package fr.lebonniec.alloysmastering.init;

import fr.lebonniec.alloysmastering.utils.References;
import fr.lebonniec.alloysmastering.utils.modutils.CustomArmorMaterials;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


/**
 * Items' registering class
 */
public class ModItems
{

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
                                                                               References.MODID
    );


    /*
        CARBON STUFF
     */

    public static final RegistryObject<Item> CARBON_CHUNK = ITEMS.register(
            "carbon_chunk",
            () -> new Item(new Item.Properties()
                                   .maxStackSize(64)
                                   .group(ModItemsGroups.TAB)
            )
    );



    /*
        CAST IRON STUFF
     */

    public static final RegistryObject<Item> CAST_IRON_INGOT = ITEMS.register(
            "cast_iron_ingot",
            () -> new Item(new Item.Properties()
                                   .maxStackSize(16)
                                   .group(ModItemsGroups.TAB)
            )
    );

    public static final RegistryObject<Item> CAST_IRON_HELMET = ITEMS.register(
            "cast_iron_helmet",
            () -> new ArmorItem(
                    CustomArmorMaterials.CAST_IRON_ARMOR,
                    EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModItemsGroups.TAB)
            )
    );

    public static final RegistryObject<Item> CAST_IRON_CHESTPLATE = ITEMS.register(
            "cast_iron_chestplate",
            () -> new ArmorItem(
                    CustomArmorMaterials.CAST_IRON_ARMOR,
                    EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModItemsGroups.TAB)
            )
    );

    public static final RegistryObject<Item> CAST_IRON_LEGGINGS = ITEMS.register(
            "cast_iron_leggings",
            () -> new ArmorItem(
                    CustomArmorMaterials.CAST_IRON_ARMOR,
                    EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModItemsGroups.TAB)
            )
    );

    public static final RegistryObject<Item> CAST_IRON_BOOTS = ITEMS.register(
            "cast_iron_boots",
            () -> new ArmorItem(
                    CustomArmorMaterials.CAST_IRON_ARMOR,
                    EquipmentSlotType.FEET,
                    new Item.Properties().group(ModItemsGroups.TAB)
            )
    );



    /*
        COPPER STUFF
     */

    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register(
            "copper_ingot",
            () -> new Item(new Item.Properties()
                                   .maxStackSize(32)
                                   .group(ModItemsGroups.TAB)
            )
    );


}
