package mod.baijson.skeleton.common;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Baijson.
 */
public interface ISidedProxy {

    /**
     * @param event
     */
    void init(FMLPreInitializationEvent event);

    /**
     * @param event
     */
    void load(FMLInitializationEvent event);

    /**
     * @param event
     */
    void post(FMLPostInitializationEvent event);
}
