
package net.mcreator.instrumental.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.instrumental.itemgroup.RangedInstrumentsTabItemGroup;
import net.mcreator.instrumental.InstrumentalModElements;

@InstrumentalModElements.ModElement.Tag
public class SpeakerItem extends InstrumentalModElements.ModElement {
	@ObjectHolder("instrumental:speaker")
	public static final Item block = null;
	public SpeakerItem(InstrumentalModElements instance) {
		super(instance, 56);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(RangedInstrumentsTabItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("speaker");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
