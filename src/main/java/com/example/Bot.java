package com.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()) {
            String msg = update.getMessage().getText();

            if(msg.equals("/start")) {
                sendmsg(update.getMessage().getChatId(), "Bot Started!");
            } if(msg.equals("/hello")) {
                sendmsg(update.getMessage().getChatId(), "Hello " + update.getMessage().getFrom().getFirstName());
            } if(msg.equals("/chat")) {
                sendmsg(update.getMessage().getChatId(), "Let's Chat ;)");
            } if(msg.equals("/cat")) {
                SendPhoto pic = new SendPhoto(update.getMessage().getChatId().toString(), new InputFile("https://media.istockphoto.com/id/1199279669/photo/big-eyed-naughty-obese-cat-behind-the-desk-with-red-hat-grey-color-british-sort-hair-cat.jpg?s=2048x2048&w=is&k=20&c=Olry8RmA2EvWtQ1OEa4ssR2xSEMZs-J2hDqNq70iSqo="));

                try {
                    execute(pic);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } if(msg.equals("/video")) {
                SendVideo video = new SendVideo(update.getMessage().getChatId().toString(), new InputFile("https://cdn.pixabay.com/animation/2023/05/17/16/04/16-04-26-783_512.gif"));

                try {
                    execute(video);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            
        }
    }

    public void sendmsg(long chatId, String text) {
        SendMessage msg = new SendMessage(Long.toString(chatId), text);

        try {
            execute(msg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "demoytbot";
    }

    @Override
    public String getBotToken() {
        return "6943319539:AAFDpEY2AA5jhCPCyKMlI7qQU8KiIDkirVc";
    }
    
}
