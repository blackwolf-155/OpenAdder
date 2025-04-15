package blackwolf155.novaspace.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NsGetCommandTabCompleter implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender,
                                                @NotNull Command command,
                                                @NotNull String label,
                                                @NotNull String @NotNull [] args) {

        List<String> completions = new ArrayList<>();
        // 根据参数位置动态补全

        if (args.length == 1) {
            completions.addAll(Arrays.asList(
                    "list", "dirt", "my_sword"
            ));
        } else if (args.length == 2) {
            if (!args[0].equalsIgnoreCase("list")) {
                completions.add("1");
            }
        }
        return completions;
    }
}
