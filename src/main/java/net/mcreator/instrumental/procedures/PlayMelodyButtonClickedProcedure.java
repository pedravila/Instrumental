package net.mcreator.instrumental.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.instrumental.item.HasteMelodyItem;
import net.mcreator.instrumental.InstrumentalModElements;

import java.util.function.Function;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;
import java.util.Comparator;

@InstrumentalModElements.ModElement.Tag
public class PlayMelodyButtonClickedProcedure extends InstrumentalModElements.ModElement {
	public PlayMelodyButtonClickedProcedure(InstrumentalModElements instance) {
		super(instance, 216);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure PlayMelodyButtonClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure PlayMelodyButtonClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure PlayMelodyButtonClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure PlayMelodyButtonClicked!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (((new Object() {
			public ItemStack getItemStack(BlockPos pos, int sltid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
				}
				return _retval.get();
			}
		}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(HasteMelodyItem.block, (int) (1)).getItem())) {
			sx = (double) (-10);
			for (int index0 = 0; index0 < (int) (21); index0++) {
				sy = (double) (-10);
				for (int index1 = 0; index1 < (int) (21); index1++) {
					sz = (double) (-10);
					for (int index2 = 0; index2 < (int) (21); index2++) {
						if ((((Entity) world
								.getEntitiesWithinAABB(PlayerEntity.class, new AxisAlignedBB(((sx) + x) - (1 / 2d), ((sy) + y) - (1 / 2d),
										((sz) + z) - (1 / 2d), ((sx) + x) + (1 / 2d), ((sy) + y) + (1 / 2d), ((sz) + z) + (1 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(((sx) + x), ((sy) + y), ((sz) + z))).findFirst().orElse(null)) != null)) {
							if (((Entity) world
									.getEntitiesWithinAABB(PlayerEntity.class,
											new AxisAlignedBB(((sx) + x) - (1 / 2d), ((sy) + y) - (1 / 2d), ((sz) + z) - (1 / 2d),
													((sx) + x) + (1 / 2d), ((sy) + y) + (1 / 2d), ((sz) + z) + (1 / 2d)),
											null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(((sx) + x), ((sy) + y), ((sz) + z))).findFirst().orElse(null)) instanceof LivingEntity)
								((LivingEntity) ((Entity) world
										.getEntitiesWithinAABB(PlayerEntity.class,
												new AxisAlignedBB(((sx) + x) - (1 / 2d), ((sy) + y) - (1 / 2d), ((sz) + z) - (1 / 2d),
														((sx) + x) + (1 / 2d), ((sy) + y) + (1 / 2d), ((sz) + z) + (1 / 2d)),
												null)
										.stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(((sx) + x), ((sy) + y), ((sz) + z))).findFirst().orElse(null)))
												.addPotionEffect(new EffectInstance(Effects.HASTE, (int) 960, (int) 1, (false), (true)));
						}
						sz = (double) ((sz) + 1);
					}
					sy = (double) ((sy) + 1);
				}
				sx = (double) ((sx) + 1);
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (0);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			if (!world.getWorld().isRemote) {
				world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("instrumental:drum_sound")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				world.getWorld().playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("instrumental:drum_sound")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
		} else {
			if (!world.getWorld().isRemote) {
				world.playSound(null, new BlockPos((int) x, (int) y, (int) z), (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
						.getValue(new ResourceLocation("instrumental:drum_fail_sound.ogg")), SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				world.getWorld().playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("instrumental:drum_fail_sound.ogg")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
		}
	}
}
