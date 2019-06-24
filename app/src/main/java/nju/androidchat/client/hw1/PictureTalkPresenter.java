package nju.androidchat.client.hw1;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import nju.androidchat.client.ClientMessage;

@AllArgsConstructor
public class PictureTalkPresenter implements Mvp0Contract.Presenter {
    private Mvp0Contract.Model mvp0TalkModel;
    private Mvp0Contract.View iMvp0TalkView;

    @Getter
    private List<ClientMessage> clientMessages;

    @Override
    public void sendMessage(String content) {
        ClientMessage clientMessage = mvp0TalkModel.sendInformation(content);
        refreshMessageList(clientMessage);
    }

    @Override
    public void receiveMessage(ClientMessage clientMessage) {
        refreshMessageList(clientMessage);
    }

    @Override
    public String getUsername() {
        return mvp0TalkModel.getUsername();
    }

    //改动，增加对图片的识别
    private void refreshMessageList(ClientMessage clientMessage) {
        if (isPicture(clientMessage)){
            clientMessage = new ClientPictureMessage(clientMessage.getMessageId(), clientMessage.getTime(),
                    clientMessage.getSenderUsername(), clientMessage.getMessage());
        }
        clientMessages.add(clientMessage);
        iMvp0TalkView.showMessageList(clientMessages);
    }

    //新增，判断是否是图片
    private boolean isPicture(ClientMessage message){
        String content = message.getMessage();
        if (content.matches("!\\[(.*)\\]\\((.*)\\)")){
            return true;
        }
        return false;
    }

    //撤回消息，Mvp0暂不实现
    @Override
    public void recallMessage(int index0) {

    }

    @Override
    public void start() {

    }
}
