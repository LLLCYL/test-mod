package lalawr.server.command;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;

public class TestModCommandManager {
    public static void initialize(){
        CommandRegistrationCallback.EVENT.register((dispatcher,
                                                    registryAccess,
                                                    environment)
                -> dispatcher.register(CommandManager.literal("foo").executes(context -> {
                        // 对于 1.19 之前的版本，把“Text.literal”替换为“new LiteralText”。
                        // 对于 1.20 之前的版本，请移除“() ->”。
                        context.getSource().sendFeedback(() -> Text.literal("调用 /foo，不带参数"), false);

                        return 1;
        })));
    }
}
