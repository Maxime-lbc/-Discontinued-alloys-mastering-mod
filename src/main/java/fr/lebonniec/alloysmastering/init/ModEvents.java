package fr.lebonniec.alloysmastering.init;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.system.CallbackI;
import sun.swing.SwingUtilities2;

import java.util.ArrayList;

public class ModEvents
{
    private static boolean isHelmetCastIron;
    private static boolean isChestCastIron;
    private static boolean isLegsCastIron;
    private static boolean isFeetCastIron;
    private static ArrayList<Boolean> pieces = new ArrayList<>();
    private static int castIronPieces = 0;
    private static int castIronPiecesFrom = -1;


    @SubscribeEvent
    public static void onArmorChange(LivingEquipmentChangeEvent event){

        LivingEntity player = event.getEntityLiving();
        EquipmentSlotType slotType = event.getSlot();
        Item itemStackTo = event.getTo().getItem();


        if (
                slotType == EquipmentSlotType.HEAD
                || slotType == EquipmentSlotType.CHEST
                || slotType == EquipmentSlotType.LEGS
                || slotType == EquipmentSlotType.FEET
        ){
            switch (slotType){

                case HEAD:
                    if(itemStackTo == ModItems.CAST_IRON_HELMET.get()){
                        isHelmetCastIron = true;
                    }else {isHelmetCastIron = false;}
                    break;

                case CHEST:
                    if(itemStackTo == ModItems.CAST_IRON_CHESTPLATE.get()){
                        isChestCastIron = true;
                    }else {isChestCastIron = false;}
                    break;

                case LEGS:
                    if(itemStackTo == ModItems.CAST_IRON_LEGGINGS.get()){
                        isLegsCastIron = true;
                    }else {isLegsCastIron = false;}
                    break;

                case FEET:
                    if(itemStackTo == ModItems.CAST_IRON_BOOTS.get()){
                        isFeetCastIron = true;
                    }else {isFeetCastIron = false;}
                    break;

                default:
                    break;
            }
        }

        pieces.add(isHelmetCastIron);
        pieces.add(isChestCastIron);
        pieces.add(isLegsCastIron);
        pieces.add(isFeetCastIron);

        for (Boolean value : pieces) {
            if (value == true) {
                castIronPieces += 1;
            }
        }

        if (castIronPieces != castIronPiecesFrom){
            castIronPiecesFrom = castIronPieces;
            System.out.println(castIronPieces);

            switch (castIronPieces){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        }



        pieces.clear();
        castIronPieces = 0;
    }
}
