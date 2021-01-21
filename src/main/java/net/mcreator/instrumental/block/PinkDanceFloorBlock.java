
package net.mcreator.instrumental.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.instrumental.itemgroup.RangedInstrumentsTabItemGroup;
import net.mcreator.instrumental.InstrumentalModElements;

import java.util.List;
import java.util.Collections;

@InstrumentalModElements.ModElement.Tag
public class PinkDanceFloorBlock extends InstrumentalModElements.ModElement {
	@ObjectHolder("instrumental:pink_dance_floor")
	public static final Block block = null;
	public PinkDanceFloorBlock(InstrumentalModElements instance) {
		super(instance, 86);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(RangedInstrumentsTabItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.GLASS).sound(SoundType.GLASS).hardnessAndResistance(1f, 10f).lightValue(15));
			setRegistryName("pink_dance_floor");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
