package Main;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class MainClass extends JavaPlugin {

    public void onEnable() {
        registerCommands();
        registerEvents();
        checkFiles();
    }

    public void onDisable() {

    }

    private void registerCommands() {
        getCommand("poll").setExecutor(new PollCommand());
    }

    private void registerEvents() {

    }

    private void checkFiles() {
        File file = new File(getDataFolder() + "/VotingData.yml");
        YamlConfiguration myFile = YamlConfiguration.loadConfiguration(file);
        if (!file.exists()) {
            try {
                myFile.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Generating missing files.");
        }
    }

}
