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
public class Tooltip {

    /**
     * @param tooltip
     * @param runnable
     */
    @SideOnly(Side.CLIENT)
    public static void construct(List<String> tooltip, Runnable runnable) {
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
    @SideOnly(Side.CLIENT)
    public static void insert(List<String> tooltip, String message, @Nullable Object... parameters) {

        message = local(message).replaceAll("&", "\u00a7");

        Object[] values = new String[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            values[i] = local(parameters[i].toString()).replaceAll("&", "\u00a7");
        }
        if (values != null && values.length > 0) {
            message = String.format(message, values);
        }

        tooltip.add(message);
    }

    /**
     * @param string
     * @return
     */
    @SideOnly(Side.CLIENT)
    public static String local(String string) {
        return I18n.format(string);
    }

    /**
     * @param string
     * @return
     */
    @SideOnly(Side.CLIENT)
    public static String local(String string, Object... parameters) {
        return I18n.format(string, parameters);
    }
}