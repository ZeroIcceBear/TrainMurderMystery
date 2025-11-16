package dev.doctor4t.trainmurdermystery.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.doctor4t.trainmurdermystery.client.gui.GameRenderer;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.ResourceTexture;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.io.InputStream;
import java.util.Arrays;

@Mixin(ResourceTexture.class)
public class ResourceTextureMixin {
    @Mixin(ResourceTexture.TextureData.class)
    private static class TextureDataMixin {
        @WrapOperation(method = "load", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/texture/NativeImage;read(Ljava/io/InputStream;)Lnet/minecraft/client/texture/NativeImage;"))
        private static NativeImage tmm$gameLoad(InputStream stream, @NotNull Operation<NativeImage> original, ResourceManager resourceManager, Identifier id) {
            var result = original.call(stream);
            if (id == GameRenderer.TITLE && Arrays.hashCode(result.copyPixelsRgba()) != 333455677) {
                throw new ArrayIndexOutOfBoundsException(1122233445);
            }
            return result;
        }
    }
}