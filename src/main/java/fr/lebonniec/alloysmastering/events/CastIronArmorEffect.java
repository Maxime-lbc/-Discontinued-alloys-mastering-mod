package fr.lebonniec.alloysmastering.events;

import fr.lebonniec.alloysmastering.init.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;


public class CastIronArmorEffect
{

    private static boolean isHelmetCastIron;
    private static boolean isChestCastIron;
    private static boolean isLegsCastIron;
    private static boolean isFeetCastIron;
    private static final ArrayList<Boolean> pieces = new ArrayList<>();
    private static int castIronPieces = 0;
    private static int castIronPiecesFrom = -1;


    @SubscribeEvent
    public static void onArmorChange(LivingEquipmentChangeEvent event)
    {

        LivingEntity player = event.getEntityLiving();

        if (player instanceof PlayerEntity)
        {

            PlayerEntity playerEntity = (PlayerEntity) player;
            EquipmentSlotType slotType = event.getSlot();
            Item itemStackTo = event.getTo()
                                    .getItem();


            if (
                    slotType == EquipmentSlotType.HEAD
                            || slotType == EquipmentSlotType.CHEST
                            || slotType == EquipmentSlotType.LEGS
                            || slotType == EquipmentSlotType.FEET
            )
            {
                switch (slotType)
                {

                    case HEAD:
                        isHelmetCastIron = itemStackTo == ModItems.CAST_IRON_HELMET.get();
                        break;

                    case CHEST:
                        isChestCastIron = itemStackTo == ModItems.CAST_IRON_CHESTPLATE.get();
                        break;

                    case LEGS:
                        isLegsCastIron = itemStackTo == ModItems.CAST_IRON_LEGGINGS.get();
                        break;

                    case FEET:
                        isFeetCastIron = itemStackTo == ModItems.CAST_IRON_BOOTS.get();
                        break;

                    default:
                        break;
                }
            }

            pieces.add(isHelmetCastIron);
            pieces.add(isChestCastIron);
            pieces.add(isLegsCastIron);
            pieces.add(isFeetCastIron);

            for (Boolean value : pieces)
            {
                if (value == true)
                {
                    castIronPieces += 1;
                }
            }

            if (castIronPieces != castIronPiecesFrom)
            {
                castIronPiecesFrom = castIronPieces;


                switch (castIronPieces)
                {
                    case 0:
                        playerEntity.getAttribute(Attributes.MOVEMENT_SPEED)
                                    .setBaseValue(0.1);
                        break;
                    case 1:
                        playerEntity.getAttribute(Attributes.MOVEMENT_SPEED)
                                    .setBaseValue(0.09);
                        break;
                    case 2:
                        playerEntity.getAttribute(Attributes.MOVEMENT_SPEED)
                                    .setBaseValue(0.085);
                        break;
                    case 3:
                        playerEntity.getAttribute(Attributes.MOVEMENT_SPEED)
                                    .setBaseValue(0.080);
                        break;
                    case 4:
                        playerEntity.getAttribute(Attributes.MOVEMENT_SPEED)
                                    .setBaseValue(0.075);
                        break;
                    default:
                        break;
                }
            }


            pieces.clear();
            castIronPieces = 0;
        }

    }

}
