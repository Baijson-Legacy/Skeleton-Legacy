package mod.baijson.skeleton.client;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by Baijson.
 */
@SideOnly(Side.CLIENT)
public class Tooltip {

    /**
     * @param tooltip
     * @param runnable
     */
    static public void construct(List<String> tooltip, Runnable runnable) {
        if (GuiScreen.isShiftKeyDown()) {
            runnable.run();
        } else {
            insert(tooltip, "skeleton.tooltip.shiftable");
        }
    }

    /**
     * @param tooltip
     * @param message
     * @param parameters
     */
    static public void insert(List<String> tooltip, String message, @Nullable Object... parameters) {
        message = local(message).replace("&", "\u00a7");
        if (parameters != null) {
            Object[] values = new String[parameters.length];
            for (int i = 0; i < parameters.length; i++) {
                values[i] = local(parameters[i].toString()).replaceAll("&", "\u00a7");
            }
            if (values.length > 0) {
                message = String.format(message, values);
            }
        }
        tooltip.add(message);
    }

    /**
     * @return
     */
    static public String local(String string, @Nullable Object... parameters) {
        return I18n.format(string, parameters);
    }
}