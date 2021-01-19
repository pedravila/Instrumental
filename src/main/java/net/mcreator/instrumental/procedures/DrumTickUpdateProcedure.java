package net.mcreator.instrumental.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.util.DamageSource;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.state.IProperty;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BoneMealItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.instrumental.InstrumentalModElements;

import java.util.function.Function;
import java.util.Map;
import java.util.Comparator;

@InstrumentalModElements.ModElement.Tag
public class DrumTickUpdateProcedure extends InstrumentalModElements.ModElement {
	public DrumTickUpdateProcedure(InstrumentalModElements instance) {
		super(instance, 236);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure DrumTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure DrumTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure DrumTickUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure DrumTickUpdate!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double GetDay = 0;
		if ((((new Object() {
			public String getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "MelodyType"))).equals("Haste"))) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("Countdown", ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) x, (int) y, (int) z), "Countdown")) + 1));
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "Countdown")) < 12000)) {
				sx = (double) (-10);
				for (int index0 = 0; index0 < (int) (21); index0++) {
					sy = (double) (-10);
					for (int index1 = 0; index1 < (int) (21); index1++) {
						sz = (double) (-10);
						for (int index2 = 0; index2 < (int) (21); index2++) {
							if ((((Entity) world
									.getEntitiesWithinAABB(AgeableEntity.class,
											new AxisAlignedBB(((sx) + x) - (1 / 2d), ((sy) + y) - (1 / 2d), ((sz) + z) - (1 / 2d),
													((sx) + x) + (1 / 2d), ((sy) + y) + (1 / 2d), ((sz) + z) + (1 / 2d)),
											null)
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
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
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
													.addPotionEffect(new EffectInstance(Effects.HASTE, (int) 200, (int) 0, (false), (true)));
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
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("DrumSoundCounter", ((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) x, (int) y, (int) z), "DrumSoundCounter")) + 1));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (((((new Object() {
					public double getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(new BlockPos((int) x, (int) y, (int) z), "DrumSoundCounter")) % 5) == 0)
						&& (world.isAirBlock(new BlockPos((int) x, (int) (y + 1), (int) z))))) {
					if (!world.getWorld().isRemote) {
						world.playSound(null, new BlockPos((int) x, (int) y, (int) z), (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("instrumental:drum_sound")), SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						world.getWorld().playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("instrumental:drum_sound")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
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
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putString("MelodyType", "None");
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("Countdown", 0);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		}
		if ((((new Object() {
			public String getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "MelodyType"))).equals("Rainy"))) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("Countdown", ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) x, (int) y, (int) z), "Countdown")) + 1));
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "Countdown")) < 12000)) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("DrumSoundCounter", ((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) x, (int) y, (int) z), "DrumSoundCounter")) + 1));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (((((new Object() {
					public double getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(new BlockPos((int) x, (int) y, (int) z), "DrumSoundCounter")) % 5) == 0)
						&& (world.isAirBlock(new BlockPos((int) x, (int) (y + 1), (int) z))))) {
					if (!world.getWorld().isRemote) {
						world.playSound(null, new BlockPos((int) x, (int) y, (int) z), (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("instrumental:drum_sound")), SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						world.getWorld().playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("instrumental:drum_sound")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
						world.getWorld().getServer().getCommandManager()
								.handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
										"weather rain");
					}
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
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putString("MelodyType", "None");
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("Countdown", 0);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		}
		if ((((new Object() {
			public String getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "MelodyType"))).equals("Tundery"))) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("Countdown", ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) x, (int) y, (int) z), "Countdown")) + 1));
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "Countdown")) < 12000)) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("DrumSoundCounter", ((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) x, (int) y, (int) z), "DrumSoundCounter")) + 1));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (((((new Object() {
					public double getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(new BlockPos((int) x, (int) y, (int) z), "DrumSoundCounter")) % 5) == 0)
						&& (world.isAirBlock(new BlockPos((int) x, (int) (y + 1), (int) z))))) {
					if (!world.getWorld().isRemote) {
						world.playSound(null, new BlockPos((int) x, (int) y, (int) z), (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("instrumental:drum_sound")), SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						world.getWorld().playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("instrumental:drum_sound")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
						world.getWorld().getServer().getCommandManager()
								.handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
										"weather thunder");
					}
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
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putString("MelodyType", "None");
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("Countdown", 0);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		}
		if ((((new Object() {
			public String getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "MelodyType"))).equals("Sunny"))) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("Countdown", ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) x, (int) y, (int) z), "Countdown")) + 1));
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "Countdown")) < 12000)) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("DrumSoundCounter", ((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) x, (int) y, (int) z), "DrumSoundCounter")) + 1));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (((((new Object() {
					public double getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(new BlockPos((int) x, (int) y, (int) z), "DrumSoundCounter")) % 5) == 0)
						&& (world.isAirBlock(new BlockPos((int) x, (int) (y + 1), (int) z))))) {
					if (!world.getWorld().isRemote) {
						world.playSound(null, new BlockPos((int) x, (int) y, (int) z), (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("instrumental:drum_sound")), SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						world.getWorld().playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("instrumental:drum_sound")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
						world.getWorld().getServer().getCommandManager()
								.handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
										"weather clear");
					}
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
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putString("MelodyType", "None");
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("Countdown", 0);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		}
		if ((((new Object() {
			public String getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "MelodyType"))).equals("Harm"))) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("Countdown", ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) x, (int) y, (int) z), "Countdown")) + 1));
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "Countdown")) < 12000)) {
				sx = (double) (-10);
				for (int index3 = 0; index3 < (int) (21); index3++) {
					sy = (double) (-10);
					for (int index4 = 0; index4 < (int) (21); index4++) {
						sz = (double) (-10);
						for (int index5 = 0; index5 < (int) (21); index5++) {
							if ((((Entity) world
									.getEntitiesWithinAABB(LivingEntity.class,
											new AxisAlignedBB(((sx) + x) - (1 / 2d), ((sy) + y) - (1 / 2d), ((sz) + z) - (1 / 2d),
													((sx) + x) + (1 / 2d), ((sy) + y) + (1 / 2d), ((sz) + z) + (1 / 2d)),
											null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(((sx) + x), ((sy) + y), ((sz) + z))).findFirst().orElse(null)) != null)) {
								((Entity) world
										.getEntitiesWithinAABB(LivingEntity.class,
												new AxisAlignedBB(((sx) + x) - (1 / 2d), ((sy) + y) - (1 / 2d), ((sz) + z) - (1 / 2d),
														((sx) + x) + (1 / 2d), ((sy) + y) + (1 / 2d), ((sz) + z) + (1 / 2d)),
												null)
										.stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(((sx) + x), ((sy) + y), ((sz) + z))).findFirst().orElse(null))
												.attackEntityFrom(DamageSource.GENERIC, (float) 1);
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
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("DrumSoundCounter", ((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) x, (int) y, (int) z), "DrumSoundCounter")) + 1));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (((((new Object() {
					public double getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(new BlockPos((int) x, (int) y, (int) z), "DrumSoundCounter")) % 5) == 0)
						&& (world.isAirBlock(new BlockPos((int) x, (int) (y + 1), (int) z))))) {
					if (!world.getWorld().isRemote) {
						world.playSound(null, new BlockPos((int) x, (int) y, (int) z), (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("instrumental:drum_sound")), SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						world.getWorld().playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("instrumental:drum_sound")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
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
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putString("MelodyType", "None");
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("Countdown", 0);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		}
		if ((((new Object() {
			public String getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "MelodyType"))).equals("Growth"))) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("Countdown", ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) x, (int) y, (int) z), "Countdown")) + 1));
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "Countdown")) < 12000)) {
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
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("DrumSoundCounter", ((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) x, (int) y, (int) z), "DrumSoundCounter")) + 1));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (((((new Object() {
					public double getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(new BlockPos((int) x, (int) y, (int) z), "DrumSoundCounter")) % 5) == 0)
						&& (world.isAirBlock(new BlockPos((int) x, (int) (y + 1), (int) z))))) {
					if (!world.getWorld().isRemote) {
						world.playSound(null, new BlockPos((int) x, (int) y, (int) z), (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("instrumental:drum_sound")), SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						world.getWorld().playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("instrumental:drum_sound")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					sx = (double) (-10);
					for (int index6 = 0; index6 < (int) (21); index6++) {
						sy = (double) (-10);
						for (int index7 = 0; index7 < (int) (21); index7++) {
							sz = (double) (-10);
							for (int index8 = 0; index8 < (int) (21); index8++) {
								if (((world.getBlockState(new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z))).isSolid())
										|| ((world.getBlockState(new BlockPos((int) ((sx) + x), (int) (((sy) + y) - 1), (int) ((sz) + z))))
												.getBlock() == Blocks.FARMLAND.getDefaultState().getBlock()))) {
									if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), world.getWorld(),
											new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z)))
											|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), world.getWorld(),
													new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z)), (Direction) null)) {
										if (!world.getWorld().isRemote)
											world.getWorld().playEvent(2005, new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z)), 0);
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
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
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putString("MelodyType", "None");
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("Countdown", 0);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		}
		if ((((new Object() {
			public String getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "MelodyType"))).equals("Party"))) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("Countdown", ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) x, (int) y, (int) z), "Countdown")) + 1));
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "Countdown")) < 12000)) {
				sx = (double) (-10);
				for (int index9 = 0; index9 < (int) (21); index9++) {
					sy = (double) (-10);
					for (int index10 = 0; index10 < (int) (21); index10++) {
						sz = (double) (-10);
						for (int index11 = 0; index11 < (int) (21); index11++) {
							if ((BlockTags.getCollection().getOrCreate(new ResourceLocation(("wool").toLowerCase(java.util.Locale.ENGLISH))).contains(
									(world.getBlockState(new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z)))).getBlock()))) {
								if ((Math.random() < 0.00003051757)) {
									{
										BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
										BlockState _bs = Blocks.WHITE_WOOL.getDefaultState();
										BlockState _bso = world.getBlockState(_bp);
										for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
											IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
											if (_bs.has(_property))
												_bs = _bs.with(_property, (Comparable) entry.getValue());
										}
										world.setBlockState(_bp, _bs, 3);
									}
								} else {
									if ((Math.random() < 0.00006103515)) {
										{
											BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
											BlockState _bs = Blocks.ORANGE_WOOL.getDefaultState();
											BlockState _bso = world.getBlockState(_bp);
											for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
												IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
												if (_bs.has(_property))
													_bs = _bs.with(_property, (Comparable) entry.getValue());
											}
											world.setBlockState(_bp, _bs, 3);
										}
									} else {
										if ((Math.random() < 0.00012207031)) {
											{
												BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
												BlockState _bs = Blocks.MAGENTA_WOOL.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_bs.has(_property))
														_bs = _bs.with(_property, (Comparable) entry.getValue());
												}
												world.setBlockState(_bp, _bs, 3);
											}
										} else {
											if ((Math.random() < 0.00024414062)) {
												{
													BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
													BlockState _bs = Blocks.LIGHT_BLUE_WOOL.getDefaultState();
													BlockState _bso = world.getBlockState(_bp);
													for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
														IProperty _property = _bs.getBlock().getStateContainer()
																.getProperty(entry.getKey().getName());
														if (_bs.has(_property))
															_bs = _bs.with(_property, (Comparable) entry.getValue());
													}
													world.setBlockState(_bp, _bs, 3);
												}
											} else {
												if ((Math.random() < 0.00048828125)) {
													{
														BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
														BlockState _bs = Blocks.YELLOW_WOOL.getDefaultState();
														BlockState _bso = world.getBlockState(_bp);
														for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
															IProperty _property = _bs.getBlock().getStateContainer()
																	.getProperty(entry.getKey().getName());
															if (_bs.has(_property))
																_bs = _bs.with(_property, (Comparable) entry.getValue());
														}
														world.setBlockState(_bp, _bs, 3);
													}
												} else {
													if ((Math.random() < 0.0009765625)) {
														{
															BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
															BlockState _bs = Blocks.LIME_WOOL.getDefaultState();
															BlockState _bso = world.getBlockState(_bp);
															for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
																IProperty _property = _bs.getBlock().getStateContainer()
																		.getProperty(entry.getKey().getName());
																if (_bs.has(_property))
																	_bs = _bs.with(_property, (Comparable) entry.getValue());
															}
															world.setBlockState(_bp, _bs, 3);
														}
													} else {
														if ((Math.random() < 0.001953125)) {
															{
																BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
																BlockState _bs = Blocks.PINK_WOOL.getDefaultState();
																BlockState _bso = world.getBlockState(_bp);
																for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
																	IProperty _property = _bs.getBlock().getStateContainer()
																			.getProperty(entry.getKey().getName());
																	if (_bs.has(_property))
																		_bs = _bs.with(_property, (Comparable) entry.getValue());
																}
																world.setBlockState(_bp, _bs, 3);
															}
														} else {
															if ((Math.random() < 0.00390625)) {
																{
																	BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
																	BlockState _bs = Blocks.GRAY_WOOL.getDefaultState();
																	BlockState _bso = world.getBlockState(_bp);
																	for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
																		IProperty _property = _bs.getBlock().getStateContainer()
																				.getProperty(entry.getKey().getName());
																		if (_bs.has(_property))
																			_bs = _bs.with(_property, (Comparable) entry.getValue());
																	}
																	world.setBlockState(_bp, _bs, 3);
																}
															} else {
																if ((Math.random() < 0.0078125)) {
																	{
																		BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																				(int) ((sz) + z));
																		BlockState _bs = Blocks.LIGHT_GRAY_WOOL.getDefaultState();
																		BlockState _bso = world.getBlockState(_bp);
																		for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues()
																				.entrySet()) {
																			IProperty _property = _bs.getBlock().getStateContainer()
																					.getProperty(entry.getKey().getName());
																			if (_bs.has(_property))
																				_bs = _bs.with(_property, (Comparable) entry.getValue());
																		}
																		world.setBlockState(_bp, _bs, 3);
																	}
																} else {
																	if ((Math.random() < 0.015625)) {
																		{
																			BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																					(int) ((sz) + z));
																			BlockState _bs = Blocks.CYAN_WOOL.getDefaultState();
																			BlockState _bso = world.getBlockState(_bp);
																			for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues()
																					.entrySet()) {
																				IProperty _property = _bs.getBlock().getStateContainer()
																						.getProperty(entry.getKey().getName());
																				if (_bs.has(_property))
																					_bs = _bs.with(_property, (Comparable) entry.getValue());
																			}
																			world.setBlockState(_bp, _bs, 3);
																		}
																	} else {
																		if ((Math.random() < 0.03125)) {
																			{
																				BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																						(int) ((sz) + z));
																				BlockState _bs = Blocks.PURPLE_WOOL.getDefaultState();
																				BlockState _bso = world.getBlockState(_bp);
																				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues()
																						.entrySet()) {
																					IProperty _property = _bs.getBlock().getStateContainer()
																							.getProperty(entry.getKey().getName());
																					if (_bs.has(_property))
																						_bs = _bs.with(_property, (Comparable) entry.getValue());
																				}
																				world.setBlockState(_bp, _bs, 3);
																			}
																		} else {
																			if ((Math.random() < 0.0625)) {
																				{
																					BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																							(int) ((sz) + z));
																					BlockState _bs = Blocks.BLUE_WOOL.getDefaultState();
																					BlockState _bso = world.getBlockState(_bp);
																					for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																							.getValues().entrySet()) {
																						IProperty _property = _bs.getBlock().getStateContainer()
																								.getProperty(entry.getKey().getName());
																						if (_bs.has(_property))
																							_bs = _bs.with(_property, (Comparable) entry.getValue());
																					}
																					world.setBlockState(_bp, _bs, 3);
																				}
																			} else {
																				if ((Math.random() < 0.125)) {
																					{
																						BlockPos _bp = new BlockPos((int) ((sx) + x),
																								(int) ((sy) + y), (int) ((sz) + z));
																						BlockState _bs = Blocks.BROWN_WOOL.getDefaultState();
																						BlockState _bso = world.getBlockState(_bp);
																						for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																								.getValues().entrySet()) {
																							IProperty _property = _bs.getBlock().getStateContainer()
																									.getProperty(entry.getKey().getName());
																							if (_bs.has(_property))
																								_bs = _bs.with(_property,
																										(Comparable) entry.getValue());
																						}
																						world.setBlockState(_bp, _bs, 3);
																					}
																				} else {
																					if ((Math.random() < 0.25)) {
																						{
																							BlockPos _bp = new BlockPos((int) ((sx) + x),
																									(int) ((sy) + y), (int) ((sz) + z));
																							BlockState _bs = Blocks.GREEN_WOOL.getDefaultState();
																							BlockState _bso = world.getBlockState(_bp);
																							for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																									.getValues().entrySet()) {
																								IProperty _property = _bs.getBlock()
																										.getStateContainer()
																										.getProperty(entry.getKey().getName());
																								if (_bs.has(_property))
																									_bs = _bs.with(_property,
																											(Comparable) entry.getValue());
																							}
																							world.setBlockState(_bp, _bs, 3);
																						}
																					} else {
																						if ((Math.random() < 0.5)) {
																							{
																								BlockPos _bp = new BlockPos((int) ((sx) + x),
																										(int) ((sy) + y), (int) ((sz) + z));
																								BlockState _bs = Blocks.RED_WOOL.getDefaultState();
																								BlockState _bso = world.getBlockState(_bp);
																								for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																										.getValues().entrySet()) {
																									IProperty _property = _bs.getBlock()
																											.getStateContainer()
																											.getProperty(entry.getKey().getName());
																									if (_bs.has(_property))
																										_bs = _bs.with(_property,
																												(Comparable) entry.getValue());
																								}
																								world.setBlockState(_bp, _bs, 3);
																							}
																						} else {
																							{
																								BlockPos _bp = new BlockPos((int) ((sx) + x),
																										(int) ((sy) + y), (int) ((sz) + z));
																								BlockState _bs = Blocks.BLACK_WOOL.getDefaultState();
																								BlockState _bso = world.getBlockState(_bp);
																								for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																										.getValues().entrySet()) {
																									IProperty _property = _bs.getBlock()
																											.getStateContainer()
																											.getProperty(entry.getKey().getName());
																									if (_bs.has(_property))
																										_bs = _bs.with(_property,
																												(Comparable) entry.getValue());
																								}
																								world.setBlockState(_bp, _bs, 3);
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							} else {
								if ((BlockTags.getCollection().getOrCreate(new ResourceLocation(("terracota").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z))))
												.getBlock()))) {
									if ((Math.random() < 0.00003051757)) {
										{
											BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
											BlockState _bs = Blocks.WHITE_TERRACOTTA.getDefaultState();
											BlockState _bso = world.getBlockState(_bp);
											for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
												IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
												if (_bs.has(_property))
													_bs = _bs.with(_property, (Comparable) entry.getValue());
											}
											world.setBlockState(_bp, _bs, 3);
										}
									} else {
										if ((Math.random() < 0.00006103515)) {
											{
												BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
												BlockState _bs = Blocks.ORANGE_TERRACOTTA.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_bs.has(_property))
														_bs = _bs.with(_property, (Comparable) entry.getValue());
												}
												world.setBlockState(_bp, _bs, 3);
											}
										} else {
											if ((Math.random() < 0.00012207031)) {
												{
													BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
													BlockState _bs = Blocks.MAGENTA_TERRACOTTA.getDefaultState();
													BlockState _bso = world.getBlockState(_bp);
													for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
														IProperty _property = _bs.getBlock().getStateContainer()
																.getProperty(entry.getKey().getName());
														if (_bs.has(_property))
															_bs = _bs.with(_property, (Comparable) entry.getValue());
													}
													world.setBlockState(_bp, _bs, 3);
												}
											} else {
												if ((Math.random() < 0.00024414062)) {
													{
														BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
														BlockState _bs = Blocks.LIGHT_BLUE_TERRACOTTA.getDefaultState();
														BlockState _bso = world.getBlockState(_bp);
														for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
															IProperty _property = _bs.getBlock().getStateContainer()
																	.getProperty(entry.getKey().getName());
															if (_bs.has(_property))
																_bs = _bs.with(_property, (Comparable) entry.getValue());
														}
														world.setBlockState(_bp, _bs, 3);
													}
												} else {
													if ((Math.random() < 0.00048828125)) {
														{
															BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
															BlockState _bs = Blocks.YELLOW_TERRACOTTA.getDefaultState();
															BlockState _bso = world.getBlockState(_bp);
															for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
																IProperty _property = _bs.getBlock().getStateContainer()
																		.getProperty(entry.getKey().getName());
																if (_bs.has(_property))
																	_bs = _bs.with(_property, (Comparable) entry.getValue());
															}
															world.setBlockState(_bp, _bs, 3);
														}
													} else {
														if ((Math.random() < 0.0009765625)) {
															{
																BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
																BlockState _bs = Blocks.LIME_TERRACOTTA.getDefaultState();
																BlockState _bso = world.getBlockState(_bp);
																for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
																	IProperty _property = _bs.getBlock().getStateContainer()
																			.getProperty(entry.getKey().getName());
																	if (_bs.has(_property))
																		_bs = _bs.with(_property, (Comparable) entry.getValue());
																}
																world.setBlockState(_bp, _bs, 3);
															}
														} else {
															if ((Math.random() < 0.001953125)) {
																{
																	BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
																	BlockState _bs = Blocks.PINK_TERRACOTTA.getDefaultState();
																	BlockState _bso = world.getBlockState(_bp);
																	for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
																		IProperty _property = _bs.getBlock().getStateContainer()
																				.getProperty(entry.getKey().getName());
																		if (_bs.has(_property))
																			_bs = _bs.with(_property, (Comparable) entry.getValue());
																	}
																	world.setBlockState(_bp, _bs, 3);
																}
															} else {
																if ((Math.random() < 0.00390625)) {
																	{
																		BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																				(int) ((sz) + z));
																		BlockState _bs = Blocks.GRAY_TERRACOTTA.getDefaultState();
																		BlockState _bso = world.getBlockState(_bp);
																		for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues()
																				.entrySet()) {
																			IProperty _property = _bs.getBlock().getStateContainer()
																					.getProperty(entry.getKey().getName());
																			if (_bs.has(_property))
																				_bs = _bs.with(_property, (Comparable) entry.getValue());
																		}
																		world.setBlockState(_bp, _bs, 3);
																	}
																} else {
																	if ((Math.random() < 0.0078125)) {
																		{
																			BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																					(int) ((sz) + z));
																			BlockState _bs = Blocks.LIGHT_GRAY_TERRACOTTA.getDefaultState();
																			BlockState _bso = world.getBlockState(_bp);
																			for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues()
																					.entrySet()) {
																				IProperty _property = _bs.getBlock().getStateContainer()
																						.getProperty(entry.getKey().getName());
																				if (_bs.has(_property))
																					_bs = _bs.with(_property, (Comparable) entry.getValue());
																			}
																			world.setBlockState(_bp, _bs, 3);
																		}
																	} else {
																		if ((Math.random() < 0.015625)) {
																			{
																				BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																						(int) ((sz) + z));
																				BlockState _bs = Blocks.CYAN_TERRACOTTA.getDefaultState();
																				BlockState _bso = world.getBlockState(_bp);
																				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues()
																						.entrySet()) {
																					IProperty _property = _bs.getBlock().getStateContainer()
																							.getProperty(entry.getKey().getName());
																					if (_bs.has(_property))
																						_bs = _bs.with(_property, (Comparable) entry.getValue());
																				}
																				world.setBlockState(_bp, _bs, 3);
																			}
																		} else {
																			if ((Math.random() < 0.03125)) {
																				{
																					BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																							(int) ((sz) + z));
																					BlockState _bs = Blocks.PURPLE_TERRACOTTA.getDefaultState();
																					BlockState _bso = world.getBlockState(_bp);
																					for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																							.getValues().entrySet()) {
																						IProperty _property = _bs.getBlock().getStateContainer()
																								.getProperty(entry.getKey().getName());
																						if (_bs.has(_property))
																							_bs = _bs.with(_property, (Comparable) entry.getValue());
																					}
																					world.setBlockState(_bp, _bs, 3);
																				}
																			} else {
																				if ((Math.random() < 0.0625)) {
																					{
																						BlockPos _bp = new BlockPos((int) ((sx) + x),
																								(int) ((sy) + y), (int) ((sz) + z));
																						BlockState _bs = Blocks.BLUE_TERRACOTTA.getDefaultState();
																						BlockState _bso = world.getBlockState(_bp);
																						for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																								.getValues().entrySet()) {
																							IProperty _property = _bs.getBlock().getStateContainer()
																									.getProperty(entry.getKey().getName());
																							if (_bs.has(_property))
																								_bs = _bs.with(_property,
																										(Comparable) entry.getValue());
																						}
																						world.setBlockState(_bp, _bs, 3);
																					}
																				} else {
																					if ((Math.random() < 0.125)) {
																						{
																							BlockPos _bp = new BlockPos((int) ((sx) + x),
																									(int) ((sy) + y), (int) ((sz) + z));
																							BlockState _bs = Blocks.BROWN_TERRACOTTA
																									.getDefaultState();
																							BlockState _bso = world.getBlockState(_bp);
																							for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																									.getValues().entrySet()) {
																								IProperty _property = _bs.getBlock()
																										.getStateContainer()
																										.getProperty(entry.getKey().getName());
																								if (_bs.has(_property))
																									_bs = _bs.with(_property,
																											(Comparable) entry.getValue());
																							}
																							world.setBlockState(_bp, _bs, 3);
																						}
																					} else {
																						if ((Math.random() < 0.25)) {
																							{
																								BlockPos _bp = new BlockPos((int) ((sx) + x),
																										(int) ((sy) + y), (int) ((sz) + z));
																								BlockState _bs = Blocks.GREEN_TERRACOTTA
																										.getDefaultState();
																								BlockState _bso = world.getBlockState(_bp);
																								for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																										.getValues().entrySet()) {
																									IProperty _property = _bs.getBlock()
																											.getStateContainer()
																											.getProperty(entry.getKey().getName());
																									if (_bs.has(_property))
																										_bs = _bs.with(_property,
																												(Comparable) entry.getValue());
																								}
																								world.setBlockState(_bp, _bs, 3);
																							}
																						} else {
																							if ((Math.random() < 0.5)) {
																								{
																									BlockPos _bp = new BlockPos((int) ((sx) + x),
																											(int) ((sy) + y), (int) ((sz) + z));
																									BlockState _bs = Blocks.RED_TERRACOTTA
																											.getDefaultState();
																									BlockState _bso = world.getBlockState(_bp);
																									for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																											.getValues().entrySet()) {
																										IProperty _property = _bs.getBlock()
																												.getStateContainer().getProperty(
																														entry.getKey().getName());
																										if (_bs.has(_property))
																											_bs = _bs.with(_property,
																													(Comparable) entry.getValue());
																									}
																									world.setBlockState(_bp, _bs, 3);
																								}
																							} else {
																								{
																									BlockPos _bp = new BlockPos((int) ((sx) + x),
																											(int) ((sy) + y), (int) ((sz) + z));
																									BlockState _bs = Blocks.BLACK_TERRACOTTA
																											.getDefaultState();
																									BlockState _bso = world.getBlockState(_bp);
																									for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																											.getValues().entrySet()) {
																										IProperty _property = _bs.getBlock()
																												.getStateContainer().getProperty(
																														entry.getKey().getName());
																										if (_bs.has(_property))
																											_bs = _bs.with(_property,
																													(Comparable) entry.getValue());
																									}
																									world.setBlockState(_bp, _bs, 3);
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								} else {
									if ((BlockTags.getCollection()
											.getOrCreate(new ResourceLocation(("glazed_terracota").toLowerCase(java.util.Locale.ENGLISH)))
											.contains((world.getBlockState(new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z))))
													.getBlock()))) {
										if ((Math.random() < 0.00003051757)) {
											{
												BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
												BlockState _bs = Blocks.WHITE_GLAZED_TERRACOTTA.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_bs.has(_property))
														_bs = _bs.with(_property, (Comparable) entry.getValue());
												}
												world.setBlockState(_bp, _bs, 3);
											}
										} else {
											if ((Math.random() < 0.00006103515)) {
												{
													BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
													BlockState _bs = Blocks.ORANGE_GLAZED_TERRACOTTA.getDefaultState();
													BlockState _bso = world.getBlockState(_bp);
													for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
														IProperty _property = _bs.getBlock().getStateContainer()
																.getProperty(entry.getKey().getName());
														if (_bs.has(_property))
															_bs = _bs.with(_property, (Comparable) entry.getValue());
													}
													world.setBlockState(_bp, _bs, 3);
												}
											} else {
												if ((Math.random() < 0.00012207031)) {
													{
														BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
														BlockState _bs = Blocks.MAGENTA_GLAZED_TERRACOTTA.getDefaultState();
														BlockState _bso = world.getBlockState(_bp);
														for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
															IProperty _property = _bs.getBlock().getStateContainer()
																	.getProperty(entry.getKey().getName());
															if (_bs.has(_property))
																_bs = _bs.with(_property, (Comparable) entry.getValue());
														}
														world.setBlockState(_bp, _bs, 3);
													}
												} else {
													if ((Math.random() < 0.00024414062)) {
														{
															BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
															BlockState _bs = Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA.getDefaultState();
															BlockState _bso = world.getBlockState(_bp);
															for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
																IProperty _property = _bs.getBlock().getStateContainer()
																		.getProperty(entry.getKey().getName());
																if (_bs.has(_property))
																	_bs = _bs.with(_property, (Comparable) entry.getValue());
															}
															world.setBlockState(_bp, _bs, 3);
														}
													} else {
														if ((Math.random() < 0.00048828125)) {
															{
																BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
																BlockState _bs = Blocks.YELLOW_GLAZED_TERRACOTTA.getDefaultState();
																BlockState _bso = world.getBlockState(_bp);
																for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
																	IProperty _property = _bs.getBlock().getStateContainer()
																			.getProperty(entry.getKey().getName());
																	if (_bs.has(_property))
																		_bs = _bs.with(_property, (Comparable) entry.getValue());
																}
																world.setBlockState(_bp, _bs, 3);
															}
														} else {
															if ((Math.random() < 0.0009765625)) {
																{
																	BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
																	BlockState _bs = Blocks.LIME_GLAZED_TERRACOTTA.getDefaultState();
																	BlockState _bso = world.getBlockState(_bp);
																	for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
																		IProperty _property = _bs.getBlock().getStateContainer()
																				.getProperty(entry.getKey().getName());
																		if (_bs.has(_property))
																			_bs = _bs.with(_property, (Comparable) entry.getValue());
																	}
																	world.setBlockState(_bp, _bs, 3);
																}
															} else {
																if ((Math.random() < 0.001953125)) {
																	{
																		BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																				(int) ((sz) + z));
																		BlockState _bs = Blocks.PINK_GLAZED_TERRACOTTA.getDefaultState();
																		BlockState _bso = world.getBlockState(_bp);
																		for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues()
																				.entrySet()) {
																			IProperty _property = _bs.getBlock().getStateContainer()
																					.getProperty(entry.getKey().getName());
																			if (_bs.has(_property))
																				_bs = _bs.with(_property, (Comparable) entry.getValue());
																		}
																		world.setBlockState(_bp, _bs, 3);
																	}
																} else {
																	if ((Math.random() < 0.00390625)) {
																		{
																			BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																					(int) ((sz) + z));
																			BlockState _bs = Blocks.GRAY_GLAZED_TERRACOTTA.getDefaultState();
																			BlockState _bso = world.getBlockState(_bp);
																			for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues()
																					.entrySet()) {
																				IProperty _property = _bs.getBlock().getStateContainer()
																						.getProperty(entry.getKey().getName());
																				if (_bs.has(_property))
																					_bs = _bs.with(_property, (Comparable) entry.getValue());
																			}
																			world.setBlockState(_bp, _bs, 3);
																		}
																	} else {
																		if ((Math.random() < 0.0078125)) {
																			{
																				BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																						(int) ((sz) + z));
																				BlockState _bs = Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA
																						.getDefaultState();
																				BlockState _bso = world.getBlockState(_bp);
																				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues()
																						.entrySet()) {
																					IProperty _property = _bs.getBlock().getStateContainer()
																							.getProperty(entry.getKey().getName());
																					if (_bs.has(_property))
																						_bs = _bs.with(_property, (Comparable) entry.getValue());
																				}
																				world.setBlockState(_bp, _bs, 3);
																			}
																		} else {
																			if ((Math.random() < 0.015625)) {
																				{
																					BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																							(int) ((sz) + z));
																					BlockState _bs = Blocks.CYAN_GLAZED_TERRACOTTA.getDefaultState();
																					BlockState _bso = world.getBlockState(_bp);
																					for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																							.getValues().entrySet()) {
																						IProperty _property = _bs.getBlock().getStateContainer()
																								.getProperty(entry.getKey().getName());
																						if (_bs.has(_property))
																							_bs = _bs.with(_property, (Comparable) entry.getValue());
																					}
																					world.setBlockState(_bp, _bs, 3);
																				}
																			} else {
																				if ((Math.random() < 0.03125)) {
																					{
																						BlockPos _bp = new BlockPos((int) ((sx) + x),
																								(int) ((sy) + y), (int) ((sz) + z));
																						BlockState _bs = Blocks.PURPLE_GLAZED_TERRACOTTA
																								.getDefaultState();
																						BlockState _bso = world.getBlockState(_bp);
																						for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																								.getValues().entrySet()) {
																							IProperty _property = _bs.getBlock().getStateContainer()
																									.getProperty(entry.getKey().getName());
																							if (_bs.has(_property))
																								_bs = _bs.with(_property,
																										(Comparable) entry.getValue());
																						}
																						world.setBlockState(_bp, _bs, 3);
																					}
																				} else {
																					if ((Math.random() < 0.0625)) {
																						{
																							BlockPos _bp = new BlockPos((int) ((sx) + x),
																									(int) ((sy) + y), (int) ((sz) + z));
																							BlockState _bs = Blocks.BLUE_GLAZED_TERRACOTTA
																									.getDefaultState();
																							BlockState _bso = world.getBlockState(_bp);
																							for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																									.getValues().entrySet()) {
																								IProperty _property = _bs.getBlock()
																										.getStateContainer()
																										.getProperty(entry.getKey().getName());
																								if (_bs.has(_property))
																									_bs = _bs.with(_property,
																											(Comparable) entry.getValue());
																							}
																							world.setBlockState(_bp, _bs, 3);
																						}
																					} else {
																						if ((Math.random() < 0.125)) {
																							{
																								BlockPos _bp = new BlockPos((int) ((sx) + x),
																										(int) ((sy) + y), (int) ((sz) + z));
																								BlockState _bs = Blocks.BROWN_GLAZED_TERRACOTTA
																										.getDefaultState();
																								BlockState _bso = world.getBlockState(_bp);
																								for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																										.getValues().entrySet()) {
																									IProperty _property = _bs.getBlock()
																											.getStateContainer()
																											.getProperty(entry.getKey().getName());
																									if (_bs.has(_property))
																										_bs = _bs.with(_property,
																												(Comparable) entry.getValue());
																								}
																								world.setBlockState(_bp, _bs, 3);
																							}
																						} else {
																							if ((Math.random() < 0.25)) {
																								{
																									BlockPos _bp = new BlockPos((int) ((sx) + x),
																											(int) ((sy) + y), (int) ((sz) + z));
																									BlockState _bs = Blocks.GREEN_GLAZED_TERRACOTTA
																											.getDefaultState();
																									BlockState _bso = world.getBlockState(_bp);
																									for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																											.getValues().entrySet()) {
																										IProperty _property = _bs.getBlock()
																												.getStateContainer().getProperty(
																														entry.getKey().getName());
																										if (_bs.has(_property))
																											_bs = _bs.with(_property,
																													(Comparable) entry.getValue());
																									}
																									world.setBlockState(_bp, _bs, 3);
																								}
																							} else {
																								if ((Math.random() < 0.5)) {
																									{
																										BlockPos _bp = new BlockPos((int) ((sx) + x),
																												(int) ((sy) + y), (int) ((sz) + z));
																										BlockState _bs = Blocks.RED_GLAZED_TERRACOTTA
																												.getDefaultState();
																										BlockState _bso = world.getBlockState(_bp);
																										for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																												.getValues().entrySet()) {
																											IProperty _property = _bs.getBlock()
																													.getStateContainer().getProperty(
																															entry.getKey().getName());
																											if (_bs.has(_property))
																												_bs = _bs.with(_property,
																														(Comparable) entry
																																.getValue());
																										}
																										world.setBlockState(_bp, _bs, 3);
																									}
																								} else {
																									{
																										BlockPos _bp = new BlockPos((int) ((sx) + x),
																												(int) ((sy) + y), (int) ((sz) + z));
																										BlockState _bs = Blocks.BLACK_GLAZED_TERRACOTTA
																												.getDefaultState();
																										BlockState _bso = world.getBlockState(_bp);
																										for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																												.getValues().entrySet()) {
																											IProperty _property = _bs.getBlock()
																													.getStateContainer().getProperty(
																															entry.getKey().getName());
																											if (_bs.has(_property))
																												_bs = _bs.with(_property,
																														(Comparable) entry
																																.getValue());
																										}
																										world.setBlockState(_bp, _bs, 3);
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									} else {
										if ((BlockTags.getCollection()
												.getOrCreate(new ResourceLocation(("concrete_powder").toLowerCase(java.util.Locale.ENGLISH)))
												.contains((world.getBlockState(new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z))))
														.getBlock()))) {
											if ((Math.random() < 0.00003051757)) {
												{
													BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
													BlockState _bs = Blocks.WHITE_CONCRETE_POWDER.getDefaultState();
													BlockState _bso = world.getBlockState(_bp);
													for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
														IProperty _property = _bs.getBlock().getStateContainer()
																.getProperty(entry.getKey().getName());
														if (_bs.has(_property))
															_bs = _bs.with(_property, (Comparable) entry.getValue());
													}
													world.setBlockState(_bp, _bs, 3);
												}
											} else {
												if ((Math.random() < 0.00006103515)) {
													{
														BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
														BlockState _bs = Blocks.ORANGE_CONCRETE_POWDER.getDefaultState();
														BlockState _bso = world.getBlockState(_bp);
														for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
															IProperty _property = _bs.getBlock().getStateContainer()
																	.getProperty(entry.getKey().getName());
															if (_bs.has(_property))
																_bs = _bs.with(_property, (Comparable) entry.getValue());
														}
														world.setBlockState(_bp, _bs, 3);
													}
												} else {
													if ((Math.random() < 0.00012207031)) {
														{
															BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
															BlockState _bs = Blocks.MAGENTA_CONCRETE_POWDER.getDefaultState();
															BlockState _bso = world.getBlockState(_bp);
															for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
																IProperty _property = _bs.getBlock().getStateContainer()
																		.getProperty(entry.getKey().getName());
																if (_bs.has(_property))
																	_bs = _bs.with(_property, (Comparable) entry.getValue());
															}
															world.setBlockState(_bp, _bs, 3);
														}
													} else {
														if ((Math.random() < 0.00024414062)) {
															{
																BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
																BlockState _bs = Blocks.LIGHT_BLUE_CONCRETE_POWDER.getDefaultState();
																BlockState _bso = world.getBlockState(_bp);
																for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
																	IProperty _property = _bs.getBlock().getStateContainer()
																			.getProperty(entry.getKey().getName());
																	if (_bs.has(_property))
																		_bs = _bs.with(_property, (Comparable) entry.getValue());
																}
																world.setBlockState(_bp, _bs, 3);
															}
														} else {
															if ((Math.random() < 0.00048828125)) {
																{
																	BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
																	BlockState _bs = Blocks.YELLOW_CONCRETE_POWDER.getDefaultState();
																	BlockState _bso = world.getBlockState(_bp);
																	for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
																		IProperty _property = _bs.getBlock().getStateContainer()
																				.getProperty(entry.getKey().getName());
																		if (_bs.has(_property))
																			_bs = _bs.with(_property, (Comparable) entry.getValue());
																	}
																	world.setBlockState(_bp, _bs, 3);
																}
															} else {
																if ((Math.random() < 0.0009765625)) {
																	{
																		BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																				(int) ((sz) + z));
																		BlockState _bs = Blocks.LIME_CONCRETE_POWDER.getDefaultState();
																		BlockState _bso = world.getBlockState(_bp);
																		for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues()
																				.entrySet()) {
																			IProperty _property = _bs.getBlock().getStateContainer()
																					.getProperty(entry.getKey().getName());
																			if (_bs.has(_property))
																				_bs = _bs.with(_property, (Comparable) entry.getValue());
																		}
																		world.setBlockState(_bp, _bs, 3);
																	}
																} else {
																	if ((Math.random() < 0.001953125)) {
																		{
																			BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																					(int) ((sz) + z));
																			BlockState _bs = Blocks.PINK_CONCRETE_POWDER.getDefaultState();
																			BlockState _bso = world.getBlockState(_bp);
																			for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues()
																					.entrySet()) {
																				IProperty _property = _bs.getBlock().getStateContainer()
																						.getProperty(entry.getKey().getName());
																				if (_bs.has(_property))
																					_bs = _bs.with(_property, (Comparable) entry.getValue());
																			}
																			world.setBlockState(_bp, _bs, 3);
																		}
																	} else {
																		if ((Math.random() < 0.00390625)) {
																			{
																				BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																						(int) ((sz) + z));
																				BlockState _bs = Blocks.GRAY_CONCRETE_POWDER.getDefaultState();
																				BlockState _bso = world.getBlockState(_bp);
																				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues()
																						.entrySet()) {
																					IProperty _property = _bs.getBlock().getStateContainer()
																							.getProperty(entry.getKey().getName());
																					if (_bs.has(_property))
																						_bs = _bs.with(_property, (Comparable) entry.getValue());
																				}
																				world.setBlockState(_bp, _bs, 3);
																			}
																		} else {
																			if ((Math.random() < 0.0078125)) {
																				{
																					BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																							(int) ((sz) + z));
																					BlockState _bs = Blocks.LIGHT_GRAY_CONCRETE_POWDER
																							.getDefaultState();
																					BlockState _bso = world.getBlockState(_bp);
																					for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																							.getValues().entrySet()) {
																						IProperty _property = _bs.getBlock().getStateContainer()
																								.getProperty(entry.getKey().getName());
																						if (_bs.has(_property))
																							_bs = _bs.with(_property, (Comparable) entry.getValue());
																					}
																					world.setBlockState(_bp, _bs, 3);
																				}
																			} else {
																				if ((Math.random() < 0.015625)) {
																					{
																						BlockPos _bp = new BlockPos((int) ((sx) + x),
																								(int) ((sy) + y), (int) ((sz) + z));
																						BlockState _bs = Blocks.CYAN_CONCRETE_POWDER
																								.getDefaultState();
																						BlockState _bso = world.getBlockState(_bp);
																						for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																								.getValues().entrySet()) {
																							IProperty _property = _bs.getBlock().getStateContainer()
																									.getProperty(entry.getKey().getName());
																							if (_bs.has(_property))
																								_bs = _bs.with(_property,
																										(Comparable) entry.getValue());
																						}
																						world.setBlockState(_bp, _bs, 3);
																					}
																				} else {
																					if ((Math.random() < 0.03125)) {
																						{
																							BlockPos _bp = new BlockPos((int) ((sx) + x),
																									(int) ((sy) + y), (int) ((sz) + z));
																							BlockState _bs = Blocks.PURPLE_CONCRETE_POWDER
																									.getDefaultState();
																							BlockState _bso = world.getBlockState(_bp);
																							for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																									.getValues().entrySet()) {
																								IProperty _property = _bs.getBlock()
																										.getStateContainer()
																										.getProperty(entry.getKey().getName());
																								if (_bs.has(_property))
																									_bs = _bs.with(_property,
																											(Comparable) entry.getValue());
																							}
																							world.setBlockState(_bp, _bs, 3);
																						}
																					} else {
																						if ((Math.random() < 0.0625)) {
																							{
																								BlockPos _bp = new BlockPos((int) ((sx) + x),
																										(int) ((sy) + y), (int) ((sz) + z));
																								BlockState _bs = Blocks.BLUE_CONCRETE_POWDER
																										.getDefaultState();
																								BlockState _bso = world.getBlockState(_bp);
																								for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																										.getValues().entrySet()) {
																									IProperty _property = _bs.getBlock()
																											.getStateContainer()
																											.getProperty(entry.getKey().getName());
																									if (_bs.has(_property))
																										_bs = _bs.with(_property,
																												(Comparable) entry.getValue());
																								}
																								world.setBlockState(_bp, _bs, 3);
																							}
																						} else {
																							if ((Math.random() < 0.125)) {
																								{
																									BlockPos _bp = new BlockPos((int) ((sx) + x),
																											(int) ((sy) + y), (int) ((sz) + z));
																									BlockState _bs = Blocks.BROWN_CONCRETE_POWDER
																											.getDefaultState();
																									BlockState _bso = world.getBlockState(_bp);
																									for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																											.getValues().entrySet()) {
																										IProperty _property = _bs.getBlock()
																												.getStateContainer().getProperty(
																														entry.getKey().getName());
																										if (_bs.has(_property))
																											_bs = _bs.with(_property,
																													(Comparable) entry.getValue());
																									}
																									world.setBlockState(_bp, _bs, 3);
																								}
																							} else {
																								if ((Math.random() < 0.25)) {
																									{
																										BlockPos _bp = new BlockPos((int) ((sx) + x),
																												(int) ((sy) + y), (int) ((sz) + z));
																										BlockState _bs = Blocks.GREEN_CONCRETE_POWDER
																												.getDefaultState();
																										BlockState _bso = world.getBlockState(_bp);
																										for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																												.getValues().entrySet()) {
																											IProperty _property = _bs.getBlock()
																													.getStateContainer().getProperty(
																															entry.getKey().getName());
																											if (_bs.has(_property))
																												_bs = _bs.with(_property,
																														(Comparable) entry
																																.getValue());
																										}
																										world.setBlockState(_bp, _bs, 3);
																									}
																								} else {
																									if ((Math.random() < 0.5)) {
																										{
																											BlockPos _bp = new BlockPos(
																													(int) ((sx) + x),
																													(int) ((sy) + y),
																													(int) ((sz) + z));
																											BlockState _bs = Blocks.RED_CONCRETE_POWDER
																													.getDefaultState();
																											BlockState _bso = world
																													.getBlockState(_bp);
																											for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																													.getValues().entrySet()) {
																												IProperty _property = _bs.getBlock()
																														.getStateContainer()
																														.getProperty(entry.getKey()
																																.getName());
																												if (_bs.has(_property))
																													_bs = _bs.with(_property,
																															(Comparable) entry
																																	.getValue());
																											}
																											world.setBlockState(_bp, _bs, 3);
																										}
																									} else {
																										{
																											BlockPos _bp = new BlockPos(
																													(int) ((sx) + x),
																													(int) ((sy) + y),
																													(int) ((sz) + z));
																											BlockState _bs = Blocks.BLACK_CONCRETE_POWDER
																													.getDefaultState();
																											BlockState _bso = world
																													.getBlockState(_bp);
																											for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																													.getValues().entrySet()) {
																												IProperty _property = _bs.getBlock()
																														.getStateContainer()
																														.getProperty(entry.getKey()
																																.getName());
																												if (_bs.has(_property))
																													_bs = _bs.with(_property,
																															(Comparable) entry
																																	.getValue());
																											}
																											world.setBlockState(_bp, _bs, 3);
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										} else {
											if ((BlockTags.getCollection()
													.getOrCreate(new ResourceLocation(("concrete").toLowerCase(java.util.Locale.ENGLISH))).contains(
															(world.getBlockState(new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z))))
																	.getBlock()))) {
												if ((Math.random() < 0.00003051757)) {
													{
														BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
														BlockState _bs = Blocks.WHITE_CONCRETE.getDefaultState();
														BlockState _bso = world.getBlockState(_bp);
														for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
															IProperty _property = _bs.getBlock().getStateContainer()
																	.getProperty(entry.getKey().getName());
															if (_bs.has(_property))
																_bs = _bs.with(_property, (Comparable) entry.getValue());
														}
														world.setBlockState(_bp, _bs, 3);
													}
												} else {
													if ((Math.random() < 0.00006103515)) {
														{
															BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
															BlockState _bs = Blocks.ORANGE_CONCRETE.getDefaultState();
															BlockState _bso = world.getBlockState(_bp);
															for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
																IProperty _property = _bs.getBlock().getStateContainer()
																		.getProperty(entry.getKey().getName());
																if (_bs.has(_property))
																	_bs = _bs.with(_property, (Comparable) entry.getValue());
															}
															world.setBlockState(_bp, _bs, 3);
														}
													} else {
														if ((Math.random() < 0.00012207031)) {
															{
																BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
																BlockState _bs = Blocks.MAGENTA_CONCRETE.getDefaultState();
																BlockState _bso = world.getBlockState(_bp);
																for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
																	IProperty _property = _bs.getBlock().getStateContainer()
																			.getProperty(entry.getKey().getName());
																	if (_bs.has(_property))
																		_bs = _bs.with(_property, (Comparable) entry.getValue());
																}
																world.setBlockState(_bp, _bs, 3);
															}
														} else {
															if ((Math.random() < 0.00024414062)) {
																{
																	BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
																	BlockState _bs = Blocks.LIGHT_BLUE_CONCRETE.getDefaultState();
																	BlockState _bso = world.getBlockState(_bp);
																	for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
																		IProperty _property = _bs.getBlock().getStateContainer()
																				.getProperty(entry.getKey().getName());
																		if (_bs.has(_property))
																			_bs = _bs.with(_property, (Comparable) entry.getValue());
																	}
																	world.setBlockState(_bp, _bs, 3);
																}
															} else {
																if ((Math.random() < 0.00048828125)) {
																	{
																		BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																				(int) ((sz) + z));
																		BlockState _bs = Blocks.YELLOW_CONCRETE.getDefaultState();
																		BlockState _bso = world.getBlockState(_bp);
																		for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues()
																				.entrySet()) {
																			IProperty _property = _bs.getBlock().getStateContainer()
																					.getProperty(entry.getKey().getName());
																			if (_bs.has(_property))
																				_bs = _bs.with(_property, (Comparable) entry.getValue());
																		}
																		world.setBlockState(_bp, _bs, 3);
																	}
																} else {
																	if ((Math.random() < 0.0009765625)) {
																		{
																			BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																					(int) ((sz) + z));
																			BlockState _bs = Blocks.LIME_CONCRETE.getDefaultState();
																			BlockState _bso = world.getBlockState(_bp);
																			for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues()
																					.entrySet()) {
																				IProperty _property = _bs.getBlock().getStateContainer()
																						.getProperty(entry.getKey().getName());
																				if (_bs.has(_property))
																					_bs = _bs.with(_property, (Comparable) entry.getValue());
																			}
																			world.setBlockState(_bp, _bs, 3);
																		}
																	} else {
																		if ((Math.random() < 0.001953125)) {
																			{
																				BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																						(int) ((sz) + z));
																				BlockState _bs = Blocks.PINK_CONCRETE.getDefaultState();
																				BlockState _bso = world.getBlockState(_bp);
																				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues()
																						.entrySet()) {
																					IProperty _property = _bs.getBlock().getStateContainer()
																							.getProperty(entry.getKey().getName());
																					if (_bs.has(_property))
																						_bs = _bs.with(_property, (Comparable) entry.getValue());
																				}
																				world.setBlockState(_bp, _bs, 3);
																			}
																		} else {
																			if ((Math.random() < 0.00390625)) {
																				{
																					BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																							(int) ((sz) + z));
																					BlockState _bs = Blocks.GRAY_CONCRETE.getDefaultState();
																					BlockState _bso = world.getBlockState(_bp);
																					for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																							.getValues().entrySet()) {
																						IProperty _property = _bs.getBlock().getStateContainer()
																								.getProperty(entry.getKey().getName());
																						if (_bs.has(_property))
																							_bs = _bs.with(_property, (Comparable) entry.getValue());
																					}
																					world.setBlockState(_bp, _bs, 3);
																				}
																			} else {
																				if ((Math.random() < 0.0078125)) {
																					{
																						BlockPos _bp = new BlockPos((int) ((sx) + x),
																								(int) ((sy) + y), (int) ((sz) + z));
																						BlockState _bs = Blocks.LIGHT_GRAY_CONCRETE.getDefaultState();
																						BlockState _bso = world.getBlockState(_bp);
																						for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																								.getValues().entrySet()) {
																							IProperty _property = _bs.getBlock().getStateContainer()
																									.getProperty(entry.getKey().getName());
																							if (_bs.has(_property))
																								_bs = _bs.with(_property,
																										(Comparable) entry.getValue());
																						}
																						world.setBlockState(_bp, _bs, 3);
																					}
																				} else {
																					if ((Math.random() < 0.015625)) {
																						{
																							BlockPos _bp = new BlockPos((int) ((sx) + x),
																									(int) ((sy) + y), (int) ((sz) + z));
																							BlockState _bs = Blocks.CYAN_CONCRETE.getDefaultState();
																							BlockState _bso = world.getBlockState(_bp);
																							for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																									.getValues().entrySet()) {
																								IProperty _property = _bs.getBlock()
																										.getStateContainer()
																										.getProperty(entry.getKey().getName());
																								if (_bs.has(_property))
																									_bs = _bs.with(_property,
																											(Comparable) entry.getValue());
																							}
																							world.setBlockState(_bp, _bs, 3);
																						}
																					} else {
																						if ((Math.random() < 0.03125)) {
																							{
																								BlockPos _bp = new BlockPos((int) ((sx) + x),
																										(int) ((sy) + y), (int) ((sz) + z));
																								BlockState _bs = Blocks.PURPLE_CONCRETE
																										.getDefaultState();
																								BlockState _bso = world.getBlockState(_bp);
																								for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																										.getValues().entrySet()) {
																									IProperty _property = _bs.getBlock()
																											.getStateContainer()
																											.getProperty(entry.getKey().getName());
																									if (_bs.has(_property))
																										_bs = _bs.with(_property,
																												(Comparable) entry.getValue());
																								}
																								world.setBlockState(_bp, _bs, 3);
																							}
																						} else {
																							if ((Math.random() < 0.0625)) {
																								{
																									BlockPos _bp = new BlockPos((int) ((sx) + x),
																											(int) ((sy) + y), (int) ((sz) + z));
																									BlockState _bs = Blocks.BLUE_CONCRETE
																											.getDefaultState();
																									BlockState _bso = world.getBlockState(_bp);
																									for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																											.getValues().entrySet()) {
																										IProperty _property = _bs.getBlock()
																												.getStateContainer().getProperty(
																														entry.getKey().getName());
																										if (_bs.has(_property))
																											_bs = _bs.with(_property,
																													(Comparable) entry.getValue());
																									}
																									world.setBlockState(_bp, _bs, 3);
																								}
																							} else {
																								if ((Math.random() < 0.125)) {
																									{
																										BlockPos _bp = new BlockPos((int) ((sx) + x),
																												(int) ((sy) + y), (int) ((sz) + z));
																										BlockState _bs = Blocks.BROWN_CONCRETE
																												.getDefaultState();
																										BlockState _bso = world.getBlockState(_bp);
																										for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																												.getValues().entrySet()) {
																											IProperty _property = _bs.getBlock()
																													.getStateContainer().getProperty(
																															entry.getKey().getName());
																											if (_bs.has(_property))
																												_bs = _bs.with(_property,
																														(Comparable) entry
																																.getValue());
																										}
																										world.setBlockState(_bp, _bs, 3);
																									}
																								} else {
																									if ((Math.random() < 0.25)) {
																										{
																											BlockPos _bp = new BlockPos(
																													(int) ((sx) + x),
																													(int) ((sy) + y),
																													(int) ((sz) + z));
																											BlockState _bs = Blocks.GREEN_CONCRETE
																													.getDefaultState();
																											BlockState _bso = world
																													.getBlockState(_bp);
																											for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																													.getValues().entrySet()) {
																												IProperty _property = _bs.getBlock()
																														.getStateContainer()
																														.getProperty(entry.getKey()
																																.getName());
																												if (_bs.has(_property))
																													_bs = _bs.with(_property,
																															(Comparable) entry
																																	.getValue());
																											}
																											world.setBlockState(_bp, _bs, 3);
																										}
																									} else {
																										if ((Math.random() < 0.5)) {
																											{
																												BlockPos _bp = new BlockPos(
																														(int) ((sx) + x),
																														(int) ((sy) + y),
																														(int) ((sz) + z));
																												BlockState _bs = Blocks.RED_CONCRETE
																														.getDefaultState();
																												BlockState _bso = world
																														.getBlockState(_bp);
																												for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																														.getValues().entrySet()) {
																													IProperty _property = _bs
																															.getBlock()
																															.getStateContainer()
																															.getProperty(entry
																																	.getKey()
																																	.getName());
																													if (_bs.has(_property))
																														_bs = _bs.with(_property,
																																(Comparable) entry
																																		.getValue());
																												}
																												world.setBlockState(_bp, _bs, 3);
																											}
																										} else {
																											{
																												BlockPos _bp = new BlockPos(
																														(int) ((sx) + x),
																														(int) ((sy) + y),
																														(int) ((sz) + z));
																												BlockState _bs = Blocks.BLACK_CONCRETE
																														.getDefaultState();
																												BlockState _bso = world
																														.getBlockState(_bp);
																												for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso
																														.getValues().entrySet()) {
																													IProperty _property = _bs
																															.getBlock()
																															.getStateContainer()
																															.getProperty(entry
																																	.getKey()
																																	.getName());
																													if (_bs.has(_property))
																														_bs = _bs.with(_property,
																																(Comparable) entry
																																		.getValue());
																												}
																												world.setBlockState(_bp, _bs, 3);
																											}
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
							sz = (double) ((sz) + 1);
						}
						sy = (double) ((sy) + 1);
					}
					sx = (double) ((sx) + 1);
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("DrumSoundCounter", ((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) x, (int) y, (int) z), "DrumSoundCounter")) + 1));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (((((new Object() {
					public double getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(new BlockPos((int) x, (int) y, (int) z), "DrumSoundCounter")) % 5) == 0)
						&& (world.isAirBlock(new BlockPos((int) x, (int) (y + 1), (int) z))))) {
					if (!world.getWorld().isRemote) {
						world.playSound(null, new BlockPos((int) x, (int) y, (int) z), (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("instrumental:drum_sound")), SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						world.getWorld().playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("instrumental:drum_sound")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
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
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putString("MelodyType", "None");
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("Countdown", 0);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		}
	}
}
