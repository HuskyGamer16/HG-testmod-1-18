package net.HuskyGamer16.testmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DowsingRodItem extends Item {
    public DowsingRodItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(context.getWorld().isClient()){
            BlockPos posClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean found = false;
            int i = 0;
            Block below = context.getWorld().getBlockState(posClicked.down(i)).getBlock();
           while ( i<=posClicked.getY()+64&&!isValuableBlock(below)){
               below = context.getWorld().getBlockState(posClicked.down(i)).getBlock();
                i++;
            } if(i<=posClicked.getY()+64){
                outputValuableCoords(posClicked.down(i),player,below);
                found = true;
            }
           if(!found){
               player.sendMessage(new TranslatableText("item.testmod.dowsing_rod.no_valueables"),true);
           }

        }
        context.getStack().damage(1,context.getPlayer(),
                (player) ->player.sendToolBreakStatus(player.getActiveHand()));
        return super.useOnBlock(context);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){

        }else{

        }
    }

    private void outputValuableCoords(BlockPos blockPos, PlayerEntity player, Block blockBelow){
        player.sendMessage(new LiteralText("Found: " + blockBelow.asItem().getName().getString() + " at ("+blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ()+ ")"),true);
    }

    private boolean isValuableBlock(Block block){
        Block[] valuableBlocks = new Block[]{
                Blocks.COPPER_ORE,Blocks.DEEPSLATE_COPPER_ORE,Blocks.COAL_ORE,Blocks.DEEPSLATE_COAL_ORE,
                Blocks.EMERALD_ORE,Blocks.DEEPSLATE_EMERALD_ORE,Blocks.DIAMOND_ORE,Blocks.DEEPSLATE_DIAMOND_ORE,
                Blocks.IRON_ORE,Blocks.DEEPSLATE_IRON_ORE,Blocks.DEEPSLATE_GOLD_ORE,Blocks.GOLD_ORE,
                Blocks.NETHER_GOLD_ORE, Blocks.LAPIS_ORE,Blocks.DEEPSLATE_LAPIS_ORE,
                Blocks.REDSTONE_ORE,Blocks.DEEPSLATE_REDSTONE_ORE,Blocks.NETHER_QUARTZ_ORE, Blocks.ANCIENT_DEBRIS
        };
        int i = 0;
        while (i<valuableBlocks.length && valuableBlocks[i]!= block){
            i++;
        }
        return i < valuableBlocks.length;

    }
}
