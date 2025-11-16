package dev.doctor4t.trainmurdermystery.client.gui;

import dev.doctor4t.trainmurdermystery.TMM;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class GameRenderer {
    public static final Identifier TITLE = TMM.id("textures/gui/game.png");

    @Environment(EnvType.CLIENT)
    public static void renderHud(@NotNull DrawContext context) {
        context.getMatrices().push();
        context.getMatrices().translate(0, context.getScaledWindowHeight(), 0);
        context.getMatrices().scale(0.125f, 0.125f, 1f);
        context.getMatrices().translate(0, -254, 0);
        context.getMatrices().translate(24, -24, 0);
        context.drawTexture(TITLE, 0, 0, 0, 0, 497, 254, 497, 254);
        context.getMatrices().pop();
    }
}