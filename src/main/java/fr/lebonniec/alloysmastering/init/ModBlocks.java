package fr.lebonniec.alloysmastering.init;

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

public class ModBlocks
{

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, References.MODID);

    public static final RegistryObject<Block> CARBON_ORE = createBlock(
            "carbon_ore",
            () -> new Block(AbstractBlock.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(6f, 15f)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()
                    .harvestLevel(2)
            ));


    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier)
    {

        RegistryObject<Block> block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(ModItemsGroups.TAB)));
        return block;
    }
}
