
package net.mcreator.instrumental.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.instrumental.item.GoldTrumpetItem;
import net.mcreator.instrumental.InstrumentalModElements;

@InstrumentalModElements.ModElement.Tag
public class RangedInstrumentsTabItemGroup extends InstrumentalModElements.ModElement {
	public RangedInstrumentsTabItemGroup(InstrumentalModElements instance) {
		super(instance, 202);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabranged_instruments_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(GoldTrumpetItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
