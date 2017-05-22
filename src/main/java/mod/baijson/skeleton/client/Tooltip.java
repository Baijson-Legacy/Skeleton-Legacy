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
    @SideOnly(Side.CLIENT)
    static public void insert(List<String> tooltip, String message, @Nullable Object... parameters) {
        Object[] values = new String[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            values[i] = local(parameters[i].toString()).replaceAll("&", "\u00a7");
        }
        tooltip.add(local(message, values).replaceAll("&", "\u00a7"));
    }

    /**
     * @param checked
     * @return
     */
    public static String checked(boolean checked) {
        return local("skeleton.tooltip.checked." + (checked ? "1" : "0"));
    }

    /**
     * @return
     */
    public static String bullets() {
        return local("skeleton.tooltip.bullets");
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