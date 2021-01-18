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
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.instrumental.InstrumentalModVariables;
import net.mcreator.instrumental.InstrumentalModElements;

import java.util.Map;

@InstrumentalModElements.ModElement.Tag
public class InspirationBar13DisplayOverlayIngameProcedure extends InstrumentalModElements.ModElement {
	public InspirationBar13DisplayOverlayIngameProcedure(InstrumentalModElements instance) {
		super(instance, 144);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure InspirationBar13DisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayerEntity) {
					return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
				} else if (_ent instanceof PlayerEntity && _ent.world.isRemote) {
					NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
							.getPlayerInfo(((ClientPlayerEntity) _ent).getGameProfile().getId());
					return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
				}
				return false;
			}
		}.checkGamemode(entity))) {
			if (((ItemTags.getCollection().getOrCreate(new ResourceLocation(("forge:instruments").toLowerCase(java.util.Locale.ENGLISH)))
					.contains(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()))
					&& ((((entity.getCapability(InstrumentalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new InstrumentalModVariables.PlayerVariables())).Inspiration) >= 13)
							&& (((entity.getCapability(InstrumentalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new InstrumentalModVariables.PlayerVariables())).Inspiration) < 14)))) {
				return (true);
			}
		}
		return (false);
	}
}
