package fr.lebonniec.alloysmastering.init;


import fr.lebonniec.alloysmastering.blocks.FoundryBlock;
import fr.lebonniec.alloysmastering.utils.References;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;


/**
 * Blocks' registering class
 */
public class ModBlocks
{

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
                                                                                 References.MODID
    );


    public static final RegistryObject<Block> FOUNDRY = createBlock(
            "foundry",
            () -> new FoundryBlock(AbstractBlock.Properties
                                           .create(Material.IRON)
                                           .hardnessAndResistance(6f,
                                                                  15f
                                           )
                                           .harvestTool(ToolType.PICKAXE)
                                           .setRequiresTool()
                                           .harvestLevel(2)
            )
    );

    public static final RegistryObject<Block> CLAY_FOUNDRY = createBlock(
            "clay_foundry",
            () -> new Block(AbstractBlock.Properties
                                           .create(Material.IRON)
                                           .hardnessAndResistance(6f,
                                                                  15f
                                           )
                                           .harvestTool(ToolType.PICKAXE)
                                           .harvestLevel(0)
            )
    );

    public static final RegistryObject<Block> HARDENED_CLAY_FOUNDRY = createBlock(
            "hardened_clay_foundry",
            () -> new Block(AbstractBlock.Properties
                                    .create(Material.IRON)
                                    .hardnessAndResistance(6f,
                                                           15f
                                    )
                                    .harvestTool(ToolType.PICKAXE)
                                    .setRequiresTool()
                                    .harvestLevel(1)
            )
    );


    public static final RegistryObject<Block> CARBON_ORE = createBlock(
            "carbon_ore",
            () -> new Block(AbstractBlock.Properties
                                    .create(Material.IRON)
                                    .hardnessAndResistance(6f,
                                                           15f
                                    )
                                    .harvestTool(ToolType.PICKAXE)
                                    .setRequiresTool()
                                    .harvestLevel(2)
            )
    );

    public static final RegistryObject<Block> CAST_IRON_BLOCK = createBlock(
            "cast_iron_block",
            () -> new Block(AbstractBlock.Properties
                                    .create(Material.IRON)
                                    .hardnessAndResistance(6f,
                                                           15f
                                    )
                                    .harvestTool(ToolType.PICKAXE)
                                    .setRequiresTool()
                                    .harvestLevel(2)
            )
    );

    public static final RegistryObject<Block> COPPER_ORE = createBlock(
            "copper_ore",
            () -> new Block(AbstractBlock.Properties
                                    .create(Material.IRON)
                                    .hardnessAndResistance(6f,
                                                           15f
                                    )
                                    .harvestTool(ToolType.PICKAXE)
                                    .setRequiresTool()
                                    .harvestLevel(2)
            )
    );


    public static <T extends Block> RegistryObject<T> createBlock(String name, Supplier<? extends Block> supplier)
    {

        RegistryObject<? extends Block> block = BLOCKS.register(name,
                                                                supplier
        );
        ModItems.ITEMS.register(name,
                                () -> new BlockItem(block.get(),
                                                    new Item.Properties().group(ModItemsGroups.TAB)
                                )
        );
        return (RegistryObject<T>) block;
    }

}
