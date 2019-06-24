package nju.androidchat.client.hw1;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import nju.androidchat.client.ClientMessage;

public class ClientPictureMessage extends ClientMessage {
    @Getter private String img;
    public ClientPictureMessage(UUID messageId, LocalDateTime time, String senderUsername, String message) {
        super(messageId, time, senderUsername, message);
    }
}
