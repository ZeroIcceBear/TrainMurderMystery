package dev.doctor4t.trainmurdermystery.item;

import dev.doctor4t.trainmurdermystery.block_entity.DoorBlockEntity;
import dev.doctor4t.trainmurdermystery.index.TMMSounds;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class CrowbarItem extends Item {
    public CrowbarItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockEntity entity = world.getBlockEntity(context.getBlockPos());
        if (!(entity instanceof DoorBlockEntity)) entity = world.getBlockEntity(context.getBlockPos().down());
        if (entity instanceof DoorBlockEntity door && !door.isBlasted() && context.getPlayer() != null) {
            if (!context.getPlayer().isCreative()) context.getPlayer().getItemCooldownManager().set(this, 6000);
            world.playSound(null, context.getBlockPos(), TMMSounds.ITEM_CROWBAR_PRY, SoundCategory.BLOCKS, 2.5f, 1f);
            context.getPlayer().swingHand(Hand.MAIN_HAND, true);
            door.blast();
        }
        return super.useOnBlock(context);
    }
}
