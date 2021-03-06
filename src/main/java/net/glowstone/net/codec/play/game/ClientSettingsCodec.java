package net.glowstone.net.codec.play.game;

import com.flowpowered.networking.Codec;
import com.flowpowered.networking.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.EncoderException;
import net.glowstone.net.message.play.game.ClientSettingsMessage;

import java.io.IOException;

public final class ClientSettingsCodec implements Codec<ClientSettingsMessage> {
    public ClientSettingsMessage decode(ByteBuf buf) throws IOException {
        String locale = ByteBufUtils.readUTF8(buf);
        int viewDistance = buf.readByte();
        int chatFlags = buf.readByte();
        boolean colors = buf.readBoolean();
        int difficulty = buf.readByte();
        boolean showCape = buf.readBoolean();
        return new ClientSettingsMessage(locale, viewDistance, chatFlags, colors, difficulty, showCape);
    }

    public ByteBuf encode(ByteBuf buf, ClientSettingsMessage message) throws IOException {
        throw new EncoderException("Cannot encode ClientSettingsMessage");
    }
}
