package net.mcreator.instrumental.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.block.BlockState;

import net.mcreator.instrumental.item.WaterBlessingMelodyItem;
import net.mcreator.instrumental.item.ThunderyMelodyItem;
import net.mcreator.instrumental.item.SunnyMelodyItem;
import net.mcreator.instrumental.item.SpeedMelodyItem;
import net.mcreator.instrumental.item.ResistanceMelodyItem;
import net.mcreator.instrumental.item.RegenerationMelodyItem;
import net.mcreator.instrumental.item.RainyMelodyItem;
import net.mcreator.instrumental.item.PartyMelodyItem;
import net.mcreator.instrumental.item.NightVisionMelodyItem;
import net.mcreator.instrumental.item.HeroMelodyItem;
import net.mcreator.instrumental.item.HasteMelodyItem;
import net.mcreator.instrumental.item.HarmMelodyItem;
import net.mcreator.instrumental.item.GrowthMelodyItem;
import net.mcreator.instrumental.InstrumentalModElements;
import net.mcreator.instrumental.InstrumentalMod;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;

@InstrumentalModElements.ModElement.Tag
public class PlayMelodyButtonClickedProcedure extends InstrumentalModElements.ModElement {
	public PlayMelodyButtonClickedProcedure(InstrumentalModElements instance) {
		super(instance, 266);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				InstrumentalMod.LOGGER.warn("Failed to load dependency x for procedure PlayMelodyButtonClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				InstrumentalMod.LOGGER.warn("Failed to load dependency y for procedure PlayMelodyButtonClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				InstrumentalMod.LOGGER.warn("Failed to load dependency z for procedure PlayMelodyButtonClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				InstrumentalMod.LOGGER.warn("Failed to load dependency world for procedure PlayMelodyButtonClicked!");
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
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("instrumental:drum_sound")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("instrumental:drum_sound")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putString("MelodyType", "Haste");
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else {
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
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(RainyMelodyItem.block, (int) (1))
					.getItem())) {
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
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("instrumental:drum_sound")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("instrumental:drum_sound")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putString("MelodyType", "Rainy");
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else {
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
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(ThunderyMelodyItem.block, (int) (1))
						.getItem())) {
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
					if (world instanceof World && !world.isRemote()) {
						((World) world)
								.playSound(null, new BlockPos((int) x, (int) y, (int) z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("instrumental:drum_sound")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("instrumental:drum_sound")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString("MelodyType", "Tundery");
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				} else {
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
					}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(SunnyMelodyItem.block, (int) (1))
							.getItem())) {
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
						if (world instanceof World && !world.isRemote()) {
							((World) world)
									.playSound(null, new BlockPos((int) x, (int) y, (int) z),
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("instrumental:drum_sound")),
											SoundCategory.NEUTRAL, (float) 1, (float) 1);
						} else {
							((World) world).playSound(x, y, z,
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("instrumental:drum_sound")),
									SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
						}
						if (!world.isRemote()) {
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							TileEntity _tileEntity = world.getTileEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getTileData().putString("MelodyType", "Sunny");
							if (world instanceof World)
								((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
						}
					} else {
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
						}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0)))
								.getItem() == new ItemStack(HarmMelodyItem.block, (int) (1)).getItem())) {
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
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("instrumental:drum_sound")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1);
							} else {
								((World) world).playSound(x, y, z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("instrumental:drum_sound")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
							}
							if (!world.isRemote()) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putString("MelodyType", "Harm");
								if (world instanceof World)
									((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
						} else {
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
							}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0)))
									.getItem() == new ItemStack(GrowthMelodyItem.block, (int) (1)).getItem())) {
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
								if (world instanceof World && !world.isRemote()) {
									((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("instrumental:drum_sound")),
											SoundCategory.NEUTRAL, (float) 1, (float) 1);
								} else {
									((World) world).playSound(x, y, z,
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("instrumental:drum_sound")),
											SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
								}
								if (!world.isRemote()) {
									BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
									TileEntity _tileEntity = world.getTileEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_tileEntity != null)
										_tileEntity.getTileData().putString("MelodyType", "Growth");
									if (world instanceof World)
										((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
								}
							} else {
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
								}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0)))
										.getItem() == new ItemStack(PartyMelodyItem.block, (int) (1)).getItem())) {
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
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("instrumental:drum_sound")),
												SoundCategory.NEUTRAL, (float) 1, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("instrumental:drum_sound")),
												SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
									}
									if (!world.isRemote()) {
										BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
										TileEntity _tileEntity = world.getTileEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_tileEntity != null)
											_tileEntity.getTileData().putString("MelodyType", "Party");
										if (world instanceof World)
											((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
									}
								} else {
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
									}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0)))
											.getItem() == new ItemStack(HeroMelodyItem.block, (int) (1)).getItem())) {
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
										if (world instanceof World && !world.isRemote()) {
											((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
													(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
															.getValue(new ResourceLocation("instrumental:drum_sound")),
													SoundCategory.NEUTRAL, (float) 1, (float) 1);
										} else {
											((World) world).playSound(x, y, z,
													(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
															.getValue(new ResourceLocation("instrumental:drum_sound")),
													SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
										}
										if (!world.isRemote()) {
											BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
											TileEntity _tileEntity = world.getTileEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_tileEntity != null)
												_tileEntity.getTileData().putString("MelodyType", "Hero");
											if (world instanceof World)
												((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
										}
									} else {
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
										}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0)))
												.getItem() == new ItemStack(NightVisionMelodyItem.block, (int) (1)).getItem())) {
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
											if (world instanceof World && !world.isRemote()) {
												((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
														(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																.getValue(new ResourceLocation("instrumental:drum_sound")),
														SoundCategory.NEUTRAL, (float) 1, (float) 1);
											} else {
												((World) world).playSound(x, y, z,
														(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																.getValue(new ResourceLocation("instrumental:drum_sound")),
														SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
											}
											if (!world.isRemote()) {
												BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
												TileEntity _tileEntity = world.getTileEntity(_bp);
												BlockState _bs = world.getBlockState(_bp);
												if (_tileEntity != null)
													_tileEntity.getTileData().putString("MelodyType", "Nightvision");
												if (world instanceof World)
													((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
											}
										} else {
											if (((new Object() {
												public ItemStack getItemStack(BlockPos pos, int sltid) {
													AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
													TileEntity _ent = world.getTileEntity(pos);
													if (_ent != null) {
														_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																.ifPresent(capability -> {
																	_retval.set(capability.getStackInSlot(sltid).copy());
																});
													}
													return _retval.get();
												}
											}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0)))
													.getItem() == new ItemStack(ResistanceMelodyItem.block, (int) (1)).getItem())) {
												{
													TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
													if (_ent != null) {
														final int _sltid = (int) (0);
														final int _amount = (int) 1;
														_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																.ifPresent(capability -> {
																	if (capability instanceof IItemHandlerModifiable) {
																		ItemStack _stk = capability.getStackInSlot(_sltid).copy();
																		_stk.shrink(_amount);
																		((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
																	}
																});
													}
												}
												if (world instanceof World && !world.isRemote()) {
													((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
															(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																	.getValue(new ResourceLocation("instrumental:drum_sound")),
															SoundCategory.NEUTRAL, (float) 1, (float) 1);
												} else {
													((World) world).playSound(x, y, z,
															(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																	.getValue(new ResourceLocation("instrumental:drum_sound")),
															SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
												}
												if (!world.isRemote()) {
													BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
													TileEntity _tileEntity = world.getTileEntity(_bp);
													BlockState _bs = world.getBlockState(_bp);
													if (_tileEntity != null)
														_tileEntity.getTileData().putString("MelodyType", "Resistance");
													if (world instanceof World)
														((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
												}
											} else {
												if (((new Object() {
													public ItemStack getItemStack(BlockPos pos, int sltid) {
														AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
														TileEntity _ent = world.getTileEntity(pos);
														if (_ent != null) {
															_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																	.ifPresent(capability -> {
																		_retval.set(capability.getStackInSlot(sltid).copy());
																	});
														}
														return _retval.get();
													}
												}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0)))
														.getItem() == new ItemStack(SpeedMelodyItem.block, (int) (1)).getItem())) {
													{
														TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
														if (_ent != null) {
															final int _sltid = (int) (0);
															final int _amount = (int) 1;
															_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																	.ifPresent(capability -> {
																		if (capability instanceof IItemHandlerModifiable) {
																			ItemStack _stk = capability.getStackInSlot(_sltid).copy();
																			_stk.shrink(_amount);
																			((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
																		}
																	});
														}
													}
													if (world instanceof World && !world.isRemote()) {
														((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
																(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																		.getValue(new ResourceLocation("instrumental:drum_sound")),
																SoundCategory.NEUTRAL, (float) 1, (float) 1);
													} else {
														((World) world).playSound(x, y, z,
																(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																		.getValue(new ResourceLocation("instrumental:drum_sound")),
																SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
													}
													if (!world.isRemote()) {
														BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
														TileEntity _tileEntity = world.getTileEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_tileEntity != null)
															_tileEntity.getTileData().putString("MelodyType", "Speed");
														if (world instanceof World)
															((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
													}
												} else {
													if (((new Object() {
														public ItemStack getItemStack(BlockPos pos, int sltid) {
															AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
															TileEntity _ent = world.getTileEntity(pos);
															if (_ent != null) {
																_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																		.ifPresent(capability -> {
																			_retval.set(capability.getStackInSlot(sltid).copy());
																		});
															}
															return _retval.get();
														}
													}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0)))
															.getItem() == new ItemStack(WaterBlessingMelodyItem.block, (int) (1)).getItem())) {
														{
															TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
															if (_ent != null) {
																final int _sltid = (int) (0);
																final int _amount = (int) 1;
																_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																		.ifPresent(capability -> {
																			if (capability instanceof IItemHandlerModifiable) {
																				ItemStack _stk = capability.getStackInSlot(_sltid).copy();
																				_stk.shrink(_amount);
																				((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
																			}
																		});
															}
														}
														if (world instanceof World && !world.isRemote()) {
															((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
																	(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																			.getValue(new ResourceLocation("instrumental:drum_sound")),
																	SoundCategory.NEUTRAL, (float) 1, (float) 1);
														} else {
															((World) world).playSound(x, y, z,
																	(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																			.getValue(new ResourceLocation("instrumental:drum_sound")),
																	SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
														}
														if (!world.isRemote()) {
															BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
															TileEntity _tileEntity = world.getTileEntity(_bp);
															BlockState _bs = world.getBlockState(_bp);
															if (_tileEntity != null)
																_tileEntity.getTileData().putString("MelodyType", "Water");
															if (world instanceof World)
																((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
														}
													} else {
														if (((new Object() {
															public ItemStack getItemStack(BlockPos pos, int sltid) {
																AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
																TileEntity _ent = world.getTileEntity(pos);
																if (_ent != null) {
																	_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																			.ifPresent(capability -> {
																				_retval.set(capability.getStackInSlot(sltid).copy());
																			});
																}
																return _retval.get();
															}
														}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0)))
																.getItem() == new ItemStack(RegenerationMelodyItem.block, (int) (1)).getItem())) {
															{
																TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
																if (_ent != null) {
																	final int _sltid = (int) (0);
																	final int _amount = (int) 1;
																	_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																			.ifPresent(capability -> {
																				if (capability instanceof IItemHandlerModifiable) {
																					ItemStack _stk = capability.getStackInSlot(_sltid).copy();
																					_stk.shrink(_amount);
																					((IItemHandlerModifiable) capability).setStackInSlot(_sltid,
																							_stk);
																				}
																			});
																}
															}
															if (world instanceof World && !world.isRemote()) {
																((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
																		(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																				.getValue(new ResourceLocation("instrumental:drum_sound")),
																		SoundCategory.NEUTRAL, (float) 1, (float) 1);
															} else {
																((World) world).playSound(x, y, z,
																		(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																				.getValue(new ResourceLocation("instrumental:drum_sound")),
																		SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
															}
															if (!world.isRemote()) {
																BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
																TileEntity _tileEntity = world.getTileEntity(_bp);
																BlockState _bs = world.getBlockState(_bp);
																if (_tileEntity != null)
																	_tileEntity.getTileData().putString("MelodyType", "Regeneration");
																if (world instanceof World)
																	((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
															}
														} else {
															if (world instanceof World && !world.isRemote()) {
																((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
																		(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																				.getValue(new ResourceLocation("instrumental:drum_fail_sound.ogg")),
																		SoundCategory.NEUTRAL, (float) 1, (float) 1);
															} else {
																((World) world).playSound(x, y, z,
																		(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																				.getValue(new ResourceLocation("instrumental:drum_fail_sound.ogg")),
																		SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
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
