package Main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PollCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String args[]) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (commandLabel.equalsIgnoreCase("poll")) {
                File file = new File(Bukkit.getPluginManager().getPlugin("PotatoPoll").getDataFolder() + "/Polls.yml");
                YamlConfiguration myFile = YamlConfiguration.loadConfiguration(file);
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("list")) {
                        player.sendMessage("Available Voting Topics are:");
                        for (String key : myFile.getConfigurationSection("Games").getKeys(false)) {
                            player.sendMessage("    " + key);
                        }
                        return true;
                    } else {

                        return true;
                    }
                }
                if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("create")) {
                        myFile.set("Games." + args[1]+ ".Voters", 0);
                        try {
                            myFile.save(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        player.sendMessage("Created " + args[1] + " poll!");
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("vote")) {

                    }
                }
            }
        }
        return false;
    }
}
