package mod.baijson.skeleton.common.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Baijson.
 */
abstract public class ConfigFactory {

    private Configuration configuration;

    /**
     * @param event
     */
    public void init(FMLPreInitializationEvent event) {
        this.configuration = new Configuration(event.getSuggestedConfigurationFile());
        sync(false);
    }

    /**
     * @param load
     */
    public void sync(boolean load) {
        try {
            if (load) {
                configuration.load();
            }
            load(configuration);
        } catch (Exception e) {
            // do nothing
        } finally {
            if (configuration.hasChanged()) {
                configuration.save();
            }
        }
    }

    /**
     * @param configuration
     */
    public void load(Configuration configuration) {
        //
    }

    /**
     * @return
     */
    public Configuration handle() {
        return configuration;
    }
}
