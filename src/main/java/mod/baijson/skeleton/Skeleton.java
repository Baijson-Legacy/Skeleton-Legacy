package mod.baijson.skeleton;

import mod.baijson.skeleton.common.ISidedProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Baijson.
 */
@Mod(modid = Skeleton.MODID, name = Skeleton.MODNM, version = Skeleton.VERSION, dependencies = Skeleton.DEPENDENCIES)
public class Skeleton {

    /**
     * Constants.
     */
    public static final String MODID = "skeleton";
    public static final String MODNM = "Skeleton";

    public static final String VERSION = "1.0.3";

    public static final String PROXY_COMMON = "mod.baijson." + MODID + ".common.CommonProxy";
    public static final String PROXY_CLIENT = "mod.baijson." + MODID + ".client.ClientProxy";

    /**
     * Dependencies.
     */
    public static final String DEPENDENCIES = "";

    /**
     * Proxy setup
     */
    @SidedProxy(clientSide = Skeleton.PROXY_CLIENT, serverSide = Skeleton.PROXY_COMMON)
    public static ISidedProxy proxy;

    /**
     * Instance
     */
    @Mod.Instance(value = Skeleton.MODID)
    public static Skeleton instance;

    /**
     * @param event
     */
    @Mod.EventHandler
    public void init(FMLPreInitializationEvent event) {
        proxy.init(event);
    }

    /**
     * @param event
     */
    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        proxy.load(event);
    }

    /**
     * @param event
     */
    @Mod.EventHandler
    public void post(FMLPostInitializationEvent event) {
        proxy.post(event);
    }
}
