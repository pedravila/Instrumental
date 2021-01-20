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

import net.mcreator.instrumental.block.YellowDanceFloorBlock;
import net.mcreator.instrumental.block.WhiteDanceFloorBlock;
import net.mcreator.instrumental.block.RedDanceFloorBlock;
import net.mcreator.instrumental.block.PurpleDancFloorBlock;
import net.mcreator.instrumental.block.PinkDanceFloorBlock;
import net.mcreator.instrumental.block.OrangeDanceFloorBlock;
import net.mcreator.instrumental.block.MagentaDanceFloorBlock;
import net.mcreator.instrumental.block.LimeDanceFloorBlock;
import net.mcreator.instrumental.block.LightGrayDanceFloorBlock;
import net.mcreator.instrumental.block.LightBlueDanceFloorBlock;
import net.mcreator.instrumental.block.GreenDanceFloorBlock;
import net.mcreator.instrumental.block.GrayDanceFloorBlock;
import net.mcreator.instrumental.block.DanceFloorBlock;
import net.mcreator.instrumental.block.CyanDanceFloorBlock;
import net.mcreator.instrumental.block.BrownDanceFloorBlock;
import net.mcreator.instrumental.block.BlueDanceFloorBlock;
import net.mcreator.instrumental.block.BlackDanceFloorBlock;
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
							if ((BlockTags.getCollection()
									.getOrCreate(new ResourceLocation(("forge:dance_floor_tag").toLowerCase(java.util.Locale.ENGLISH))).contains(
											(world.getBlockState(new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z)))).getBlock()))) {
								if ((Math.random() < 0)) {
									{
										BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
										BlockState _bs = WhiteDanceFloorBlock.block.getDefaultState();
										BlockState _bso = world.getBlockState(_bp);
										for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
											IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
											if (_bs.has(_property))
												_bs = _bs.with(_property, (Comparable) entry.getValue());
										}
										world.setBlockState(_bp, _bs, 3);
									}
								} else {
									if ((Math.random() < 0.0625)) {
										{
											BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
											BlockState _bs = OrangeDanceFloorBlock.block.getDefaultState();
											BlockState _bso = world.getBlockState(_bp);
											for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
												IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
												if (_bs.has(_property))
													_bs = _bs.with(_property, (Comparable) entry.getValue());
											}
											world.setBlockState(_bp, _bs, 3);
										}
									} else {
										if ((Math.random() < 0.125)) {
											{
												BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
												BlockState _bs = MagentaDanceFloorBlock.block.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_bs.has(_property))
														_bs = _bs.with(_property, (Comparable) entry.getValue());
												}
												world.setBlockState(_bp, _bs, 3);
											}
										} else {
											if ((Math.random() < 0.1875)) {
												{
													BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
													BlockState _bs = LightBlueDanceFloorBlock.block.getDefaultState();
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
												if ((Math.random() < 0.25)) {
													{
														BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
														BlockState _bs = YellowDanceFloorBlock.block.getDefaultState();
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
													if ((Math.random() < 0.3125)) {
														{
															BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
															BlockState _bs = LimeDanceFloorBlock.block.getDefaultState();
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
														if ((Math.random() < 0.375)) {
															{
																BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
																BlockState _bs = PinkDanceFloorBlock.block.getDefaultState();
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
															if ((Math.random() < 0.4375)) {
																{
																	BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
																	BlockState _bs = GrayDanceFloorBlock.block.getDefaultState();
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
																if ((Math.random() < 0.5)) {
																	{
																		BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																				(int) ((sz) + z));
																		BlockState _bs = LightGrayDanceFloorBlock.block.getDefaultState();
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
																	if ((Math.random() < 0.5625)) {
																		{
																			BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																					(int) ((sz) + z));
																			BlockState _bs = CyanDanceFloorBlock.block.getDefaultState();
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
																		if ((Math.random() < 0.625)) {
																			{
																				BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																						(int) ((sz) + z));
																				BlockState _bs = PurpleDancFloorBlock.block.getDefaultState();
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
																			if ((Math.random() < 0.6875)) {
																				{
																					BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y),
																							(int) ((sz) + z));
																					BlockState _bs = BlueDanceFloorBlock.block.getDefaultState();
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
																				if ((Math.random() < 0.75)) {
																					{
																						BlockPos _bp = new BlockPos((int) ((sx) + x),
																								(int) ((sy) + y), (int) ((sz) + z));
																						BlockState _bs = BrownDanceFloorBlock.block.getDefaultState();
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
																					if ((Math.random() < 0.8125)) {
																						{
																							BlockPos _bp = new BlockPos((int) ((sx) + x),
																									(int) ((sy) + y), (int) ((sz) + z));
																							BlockState _bs = GreenDanceFloorBlock.block
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
																						if ((Math.random() < 0.875)) {
																							{
																								BlockPos _bp = new BlockPos((int) ((sx) + x),
																										(int) ((sy) + y), (int) ((sz) + z));
																								BlockState _bs = RedDanceFloorBlock.block
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
																							{
																								BlockPos _bp = new BlockPos((int) ((sx) + x),
																										(int) ((sy) + y), (int) ((sz) + z));
																								BlockState _bs = BlackDanceFloorBlock.block
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
				sx = (double) (-10);
				for (int index12 = 0; index12 < (int) (21); index12++) {
					sy = (double) (-10);
					for (int index13 = 0; index13 < (int) (21); index13++) {
						sz = (double) (-10);
						for (int index14 = 0; index14 < (int) (21); index14++) {
							if ((BlockTags.getCollection()
									.getOrCreate(new ResourceLocation(("forge:dance_floor_tag").toLowerCase(java.util.Locale.ENGLISH))).contains(
											(world.getBlockState(new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z)))).getBlock()))) {
								{
									BlockPos _bp = new BlockPos((int) ((sx) + x), (int) ((sy) + y), (int) ((sz) + z));
									BlockState _bs = DanceFloorBlock.block.getDefaultState();
									BlockState _bso = world.getBlockState(_bp);
									for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
										IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
										if (_bs.has(_property))
											_bs = _bs.with(_property, (Comparable) entry.getValue());
									}
									world.setBlockState(_bp, _bs, 3);
								}
							}
							sz = (double) ((sz) + 1);
						}
						sy = (double) ((sy) + 1);
					}
					sx = (double) ((sx) + 1);
				}
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
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "MelodyType"))).equals("Fly"))) {
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
				for (int index15 = 0; index15 < (int) (21); index15++) {
					sy = (double) (-10);
					for (int index16 = 0; index16 < (int) (21); index16++) {
						sz = (double) (-10);
						for (int index17 = 0; index17 < (int) (21); index17++) {
							if ((((Entity) world
									.getEntitiesWithinAABB(PlayerEntity.class,
											new AxisAlignedBB(((sx) + x) - (2 / 2d), ((sy) + y) - (2 / 2d), ((sz) + z) - (2 / 2d),
													((sx) + x) + (2 / 2d), ((sy) + y) + (2 / 2d), ((sz) + z) + (2 / 2d)),
											null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(((sx) + x), ((sy) + y), ((sz) + z))).findFirst().orElse(null)) != null)) {
								if (((Entity) world
										.getEntitiesWithinAABB(PlayerEntity.class,
												new AxisAlignedBB(((sx) + x) - (2 / 2d), ((sy) + y) - (2 / 2d), ((sz) + z) - (2 / 2d),
														((sx) + x) + (2 / 2d), ((sy) + y) + (2 / 2d), ((sz) + z) + (2 / 2d)),
												null)
										.stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(((sx) + x), ((sy) + y), ((sz) + z))).findFirst().orElse(null)) instanceof PlayerEntity) {
									((PlayerEntity) ((Entity) world
											.getEntitiesWithinAABB(PlayerEntity.class,
													new AxisAlignedBB(((sx) + x) - (2 / 2d), ((sy) + y) - (2 / 2d), ((sz) + z) - (2 / 2d),
															((sx) + x) + (2 / 2d), ((sy) + y) + (2 / 2d), ((sz) + z) + (2 / 2d)),
													null)
											.stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
												}
											}.compareDistOf(((sx) + x), ((sy) + y), ((sz) + z))).findFirst()
											.orElse(null))).abilities.allowFlying = (((Entity) world
													.getEntitiesWithinAABB(PlayerEntity.class,
															new AxisAlignedBB(((sx) + x) - (2 / 2d), ((sy) + y) - (2 / 2d), ((sz) + z) - (2 / 2d),
																	((sx) + x) + (2 / 2d), ((sy) + y) + (2 / 2d), ((sz) + z) + (2 / 2d)),
															null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparing(
																	(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(((sx) + x), ((sy) + y), ((sz) + z))).findFirst().orElse(null)) != null);
									((PlayerEntity) ((Entity) world
											.getEntitiesWithinAABB(PlayerEntity.class,
													new AxisAlignedBB(((sx) + x) - (2 / 2d), ((sy) + y) - (2 / 2d), ((sz) + z) - (2 / 2d),
															((sx) + x) + (2 / 2d), ((sy) + y) + (2 / 2d), ((sz) + z) + (2 / 2d)),
													null)
											.stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
												}
											}.compareDistOf(((sx) + x), ((sy) + y), ((sz) + z))).findFirst().orElse(null))).sendPlayerAbilities();
								}
								((Entity) world
										.getEntitiesWithinAABB(PlayerEntity.class,
												new AxisAlignedBB(((sx) + x) - (2 / 2d), ((sy) + y) - (2 / 2d), ((sz) + z) - (2 / 2d),
														((sx) + x) + (2 / 2d), ((sy) + y) + (2 / 2d), ((sz) + z) + (2 / 2d)),
												null)
										.stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(((sx) + x), ((sy) + y), ((sz) + z))).findFirst().orElse(null)).getPersistentData()
												.putBoolean("Fly", (true));
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
	}
}
