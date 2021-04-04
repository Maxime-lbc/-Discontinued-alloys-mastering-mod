package fr.lebonniec.alloysmastering.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

/**
 * Class in which creative tab of the mod is created
 */
public class ModItemsGroups
{
    public static final ItemGroup TAB = new ItemGroup("alloysmastering") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.CAST_IRON_INGOT.get());
        }
    };
}
