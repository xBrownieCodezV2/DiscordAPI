package ac.sparky.discord;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class Plugin extends JavaPlugin {

    @Getter private static Plugin instance;
    private ExecutorService executor;

    @Override
    public void onEnable() {
        instance = this;
        this.executor = Executors.newSingleThreadExecutor();
        getLogger().info("Loaded Sparky Discord API.");
    }

    @Override
    public void onDisable() {
        this.executor.shutdownNow();
    }
}
