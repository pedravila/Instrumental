package net.mcreator.instrumental.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.instrumental.InstrumentalModElements;

import java.util.Map;
import java.util.HashMap;

@InstrumentalModElements.ModElement.Tag
public class PlayerFlyProcedure extends InstrumentalModElements.ModElement {
	public PlayerFlyProcedure(InstrumentalModElements instance) {
		super(instance, 286);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure PlayerFly!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false)) {
			if (entity instanceof PlayerEntity) {
				((PlayerEntity) entity).abilities.allowFlying = (true);
				((PlayerEntity) entity).sendPlayerAbilities();
			}
		} else {
			entity.getPersistentData().putDouble("FlyCounter", ((entity.getPersistentData().getDouble("FlyCounter")) + 1));
			if ((((entity.getPersistentData().getDouble("FlyCounter")) % 60) == 0)) {
				entity.getPersistentData().putBoolean("Fly", (false));
			}
			if (entity instanceof PlayerEntity) {
				((PlayerEntity) entity).abilities.allowFlying = (entity.getPersistentData().getBoolean("Fly"));
				((PlayerEntity) entity).sendPlayerAbilities();
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
