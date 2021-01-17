package net.mcreator.instrumental.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.instrumental.InstrumentalModVariables;
import net.mcreator.instrumental.InstrumentalModElements;

import java.util.Map;

@InstrumentalModElements.ModElement.Tag
public class InspirationBarEmptyDisplayOverlayIngameProcedure extends InstrumentalModElements.ModElement {
	public InspirationBarEmptyDisplayOverlayIngameProcedure(InstrumentalModElements instance) {
		super(instance, 141);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure InspirationBarEmptyDisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (1 > ((entity.getCapability(InstrumentalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new InstrumentalModVariables.PlayerVariables())).Inspiration));
	}
}
