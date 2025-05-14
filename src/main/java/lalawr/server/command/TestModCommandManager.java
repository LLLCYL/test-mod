package lalawr.server.command;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.text.Text;

import static com.mojang.brigadier.arguments.IntegerArgumentType.getInteger;
import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;
import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class TestModCommandManager {
    public static void initialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher,
                                                    registryAccess,
                                                    environment) -> {
                    dispatcher.register(literal("foo").requires(source -> source.hasPermissionLevel(2))
                            .executes(context -> {
                                // 对于 1.19 之前的版本，把“Text.literal”替换为“new LiteralText”。
                                // 对于 1.20 之前的版本，请移除“() ->”。
                                context.getSource().sendFeedback(() ->
                                        Text.literal(environment.toString()), false);
                                return 1;
                            }));
                    dispatcher.register(literal("mul").then(argument("value", integer())
                            .executes(context -> {
                                final int value = getInteger(context, "value");
                                final int result = value * value;
                                context.getSource().sendFeedback(() ->
                                        Text.literal("%s × %s = %s".formatted(value, value, result)), false);
                                return result;
                            }).then(argument("value2", integer())
                                    .executes(context -> {
                                        final int value = getInteger(context, "value");
                                        final int value2 = getInteger(context, "value2");
                                        final int result = value * value2;
                                        context.getSource().sendFeedback(() ->
                                                Text.literal("%s × %s = %s".formatted(value, value2, result)), false);
                                        return result;
                                    }))));
                }
        );
    }
}
