package net.HuskyGamer16.testmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpeedyBlock extends Block {
    public SpeedyBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit){
        if(world.isClient()){
            if(hand == Hand.MAIN_HAND){
                player.sendMessage(new LiteralText("Main hand"),false);
            }else{
                player.sendMessage(new LiteralText("Off hand"),false);
            }
        }

        return ActionResult.PASS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity){
        if(!world.isClient){
            if(entity instanceof LivingEntity){
                LivingEntity Living = ((LivingEntity) entity);
                Living.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 300, 3));
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }
}
