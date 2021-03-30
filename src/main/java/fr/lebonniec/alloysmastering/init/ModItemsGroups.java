package fr.lebonniec.alloysmastering.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemsGroups
{
    public static final ItemGroup TAB = new ItemGroup("alloysmastering") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.CARBON_CHUNK.get());
        }
    };
}
