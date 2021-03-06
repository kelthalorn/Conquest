package com.settlers.input;

import com.settlers.network.PacketHandler;
import com.settlers.network.PacketSendKey;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class InputHandler {

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (KeyBindings.tutorialKey.isPressed()) {
            // Someone pressed our tutorialKey. We send a message
            PacketHandler.INSTANCE.sendToServer(new PacketSendKey());
        }
    }
}
