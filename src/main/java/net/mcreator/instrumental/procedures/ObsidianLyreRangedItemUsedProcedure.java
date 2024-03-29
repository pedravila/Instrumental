package net.mcreator.instrumental.procedures;

import net.minecraft.world.GameType;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.instrumental.InstrumentalModVariables;
import net.mcreator.instrumental.InstrumentalModElements;
import net.mcreator.instrumental.InstrumentalMod;

import java.util.Map;

@InstrumentalModElements.ModElement.Tag
public class ObsidianLyreRangedItemUsedProcedure extends InstrumentalModElements.ModElement {
	public ObsidianLyreRangedItemUsedProcedure(InstrumentalModElements instance) {
		super(instance, 218);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				InstrumentalMod.LOGGER.warn("Failed to load dependency entity for procedure ObsidianLyreRangedItemUsed!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				InstrumentalMod.LOGGER.warn("Failed to load dependency itemstack for procedure ObsidianLyreRangedItemUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayerEntity) {
					return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
				} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
					NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
							.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
					return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
				}
				return false;
			}
		}.checkGamemode(entity))) {
			{
				double _setval = (double) (((entity.getCapability(InstrumentalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new InstrumentalModVariables.PlayerVariables())).Inspiration) - 5);
				entity.getCapability(InstrumentalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Inspiration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 20);
		}
	}
}
