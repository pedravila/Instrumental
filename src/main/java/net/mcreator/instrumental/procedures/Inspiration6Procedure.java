package net.mcreator.instrumental.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.instrumental.InstrumentalModElements;

import java.util.Map;

@InstrumentalModElements.ModElement.Tag
public class Inspiration6Procedure extends InstrumentalModElements.ModElement {
	public Inspiration6Procedure(InstrumentalModElements instance) {
		super(instance, 65);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Inspiration6!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((6 == (entity.getPersistentData().getDouble("Inspiration"))) || (6 > (entity.getPersistentData().getDouble("Inspiration"))))) {
			return (true);
		}
		return (false);
	}
}
