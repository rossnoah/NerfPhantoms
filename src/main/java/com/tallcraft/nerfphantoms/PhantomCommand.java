package com.tallcraft.nerfphantoms;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PhantomCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage("This command can only be run by a player.");
            return true;
        }
        Player player = (Player) commandSender;
        boolean isDisabled = NerfPhantoms.getInstance().togglePhantomSpawn(player);
        String message = NerfPhantoms.getInstance().getConfig().getString("messages.phantom-command").replace("%status%", isDisabled ? "disabled" : "enabled");

        MiniMessage miniMessage = MiniMessage.miniMessage();
        player.sendMessage(miniMessage.deserialize(message));
        return true;
    }
}
