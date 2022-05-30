package com.telegrambot.bots;

import com.telegrambot.controllers.HomeController;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
public class TgBot extends TelegramLongPollingBot {
    private static String chatId;
    public static void setChatId(String id){
        chatId = id;
        new TgBot().sendMSG();
    }

    @Override
    public String getBotUsername() {
        return "str_button2_bot";
    }

    @Override
    public String getBotToken() {
        return "5331836629:AAEvFm0UenDxqkUPWY6fWLbj5L5cj-OQ8tI";
    }
    public static InlineKeyboardMarkup sendInlineKeyBoardMessage(){
        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Зеленый");
        inlineKeyboardButton1.setCallbackData("Зеленый");

        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText("Красный");
        inlineKeyboardButton2.setCallbackData("Красный");

        keyboardButtonsRow.add(inlineKeyboardButton1);
        keyboardButtonsRow.add(inlineKeyboardButton2);
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowList);


        return inlineKeyboardMarkup;
    }
    public void sendMSG(){
        SendMessage sm = new SendMessage();
        sm.setChatId(chatId);
        sm.setText("Выберите цвет");
        sm.setReplyMarkup(sendInlineKeyBoardMessage());
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            sendMSG();
        } else if (update.hasCallbackQuery()){
            System.out.println(update.getCallbackQuery().getData());
            HomeController.setColor(update.getCallbackQuery().getData());
        }

    }


}
