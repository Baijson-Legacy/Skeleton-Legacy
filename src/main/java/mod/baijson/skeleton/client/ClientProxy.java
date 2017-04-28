package mod.baijson.skeleton.client;

import mod.baijson.skeleton.common.CommonProxy;
import mod.baijson.skeleton.common.ISidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Baijson.
 */
public class ClientProxy extends CommonProxy implements ISidedProxy {

    /**
     * @param event
     */
    @Override
    public void init(FMLPreInitializationEvent event) {
        super.init(event);
    }

    /**
     * @param event
     */
    @Override
    public void load(FMLInitializationEvent event) {
        super.load(event);
    }

    /**
     * @param event
     */
    @Override
    public void post(FMLPostInitializationEvent event) {
        super.post(event);
    }
}