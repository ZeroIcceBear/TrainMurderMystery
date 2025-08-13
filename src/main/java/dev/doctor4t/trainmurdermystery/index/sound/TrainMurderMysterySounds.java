package dev.doctor4t.trainmurdermystery.index.sound;

import dev.doctor4t.trainmurdermystery.TrainMurderMystery;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public interface TrainMurderMysterySounds {
    // Block generic sounds
    SoundEvent BLOCK_VENT_SHAFT_BREAK = create("block.vent_shaft.break");
    SoundEvent BLOCK_VENT_SHAFT_STEP = create("block.vent_shaft.step");
    SoundEvent BLOCK_VENT_SHAFT_PLACE = create("block.vent_shaft.place");
    SoundEvent BLOCK_VENT_SHAFT_HIT = create("block.vent_shaft.hit");
    SoundEvent BLOCK_VENT_SHAFT_FALL = create("block.vent_shaft.fall");

    // Block special sounds
    SoundEvent BLOCK_CARGO_BOX_OPEN = create("block.cargo_box.open");
    SoundEvent BLOCK_CARGO_BOX_CLOSE = create("block.cargo_box.close");
    SoundEvent BLOCK_LIGHT_TOGGLE = create("block.light.toggle");
    SoundEvent BLOCK_PRIVACY_PANEL_TOGGLE = create("block.privacy_panel.toggle");
    SoundEvent BLOCK_SPACE_BUTTON_TOGGLE = create("block.space_button.toggle");
    SoundEvent BLOCK_BUTTON_TOGGLE_NO_POWER = create("block.button.toggle_no_power");
    SoundEvent BLOCK_DOOR_TOGGLE = create("block.door.toggle");
    SoundEvent BLOCK_SPRINKLER_RUN = create("block.sprinkler.run");

    // Ambience
    SoundEvent AMBIENT_TRAIN_INSIDE = create("ambient.train.inside");
    SoundEvent AMBIENT_TRAIN_OUTSIDE = create("ambient.train.outside");

    private static SoundEvent create(String name) {
        Identifier id = TrainMurderMystery.id(name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    private static BlockSoundGroup createBlockSoundGroup(String name, float volume, float pitch) {
        return new BlockSoundGroup(volume, pitch,
                create("block." + name + ".break"),
                create("block." + name + ".step"),
                create("block." + name + ".place"),
                create("block." + name + ".hit"),
                create("block." + name + ".fall"));
    }

    private static BlockSoundGroup copyBlockSoundGroup(BlockSoundGroup blockSoundGroup, float volume, float pitch) {
        return new BlockSoundGroup(volume, pitch,
                blockSoundGroup.getBreakSound(),
                blockSoundGroup.getStepSound(),
                blockSoundGroup.getPlaceSound(),
                blockSoundGroup.getHitSound(),
                blockSoundGroup.getFallSound());
    }

    static void initialize() {
    }

}
