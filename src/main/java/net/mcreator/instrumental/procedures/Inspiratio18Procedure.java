package net.mcreator.instrumental.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.instrumental.InstrumentalModVariables;
import net.mcreator.instrumental.InstrumentalModElements;

import java.util.Map;

@InstrumentalModElements.ModElement.Tag
public class Inspiratio18Procedure extends InstrumentalModElements.ModElement {
	public Inspiratio18Procedure(InstrumentalModElements instance) {
		super(instance, 77);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Inspiratio18!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((18 == ((entity.getCapability(InstrumentalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new InstrumentalModVariables.PlayerVariables())).Inspiration))
				|| (18 > ((entity.getCapability(InstrumentalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new InstrumentalModVariables.PlayerVariables())).Inspiration)))) {
			return (true);
		}
		return (false);
	}
}
