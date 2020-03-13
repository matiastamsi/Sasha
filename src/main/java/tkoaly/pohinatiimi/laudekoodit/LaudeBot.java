package tkoaly.pohinatiimi.laudekoodit;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.*;
import java.io.*;

public class LaudeBot extends TelegramLongPollingBot {

    private Dotenv dotenv = Dotenv.load();

    @Override
    public void onUpdateReceived(Update update) {

        Long chatId = update.getMessage().getChatId();
        String text = update.getMessage().getText();

        // Initialize answer message
        SendMessage answer = new SendMessage()
                .setChatId(chatId);

        Random r = new Random();
        try (Scanner tiedostonLukija = new Scanner(new File("testitiedosto.txt"))) {
            int j = 1 + r.nextInt(500);
            // luetaan tiedostoja kunnes kaikki rivit on luettu
           
            for (int i = 0; i < j; i++) {
                tiedostonLukija.nextLine();
            }
            
            System.out.println(tiedostonLukija.nextLine());
            
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }

        // Send message
        try {
            execute(answer);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "SashaTheFaktabot";
    }

    @Override
    public String getBotToken() {
        return dotenv.get("BOT_TOKEN");
    }
}
