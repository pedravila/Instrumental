package net.mcreator.instrumental.procedures;

import net.minecraft.world.GameType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.instrumental.InstrumentalModVariables;
import net.mcreator.instrumental.InstrumentalModElements;
import net.mcreator.instrumental.InstrumentalMod;

import java.util.Map;

@InstrumentalModElements.ModElement.Tag
public class InspirationBar10DisplayOverlayIngameProcedure extends InstrumentalModElements.ModElement {
	public InspirationBar10DisplayOverlayIngameProcedure(InstrumentalModElements instance) {
		super(instance, 191);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				InstrumentalMod.LOGGER.warn("Failed to load dependency entity for procedure InspirationBar10DisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
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
			if (((ItemTags.getCollection().getTagByID(new ResourceLocation(("forge:instruments").toLowerCase(java.util.Locale.ENGLISH)))
					.contains(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()))
					&& ((((entity.getCapability(InstrumentalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new InstrumentalModVariables.PlayerVariables())).Inspiration) >= 10)
							&& (((entity.getCapability(InstrumentalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new InstrumentalModVariables.PlayerVariables())).Inspiration) < 11)))) {
				return (true);
			}
		}
		return (false);
	}
}
