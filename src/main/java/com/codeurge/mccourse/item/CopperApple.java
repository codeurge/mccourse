package com.codeurge.mccourse.item;

import com.codeurge.mccourse.MCCourseMod;
import com.codeurge.mccourse.util.KeyboardHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class CopperApple extends Item {
    public CopperApple() {
        super(new Properties()
                .group(MCCourseMod.COURSE_TAB)
                .food(new Food.Builder().hunger(5)
                        .saturation(1.5f)
                        .effect(() -> new EffectInstance(Effects.BLINDNESS, 300, 1), 0.5f).build())
        );
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        if (KeyboardHelper.isHoldingShift()) {
            tooltip.add(new StringTextComponent("Makes sheep drop Copper Ingots"));
        } else {
            tooltip.add(new StringTextComponent("Hold"+ "\u00A7e" + " SHIFT " + "\u00A77" + "for more information!"));
        }

        super.addInformation(stack, world, tooltip, flag);
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
       return 600;
    }
}
