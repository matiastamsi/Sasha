package tkoaly.pohinatiimi.laudekoodit;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LaudeBot extends TelegramLongPollingBot {

    private Dotenv dotenv = Dotenv.load();

    @Override
    public void onUpdateReceived(Update update) {

        Long chatId = update.getMessage().getChatId();
        String text = update.getMessage().getText();
        
        if (text.toLowerCase().equals("fakta")
                || text.toLowerCase().equals("fact")) {
            SendMessage hmm = new SendMessage()
                    .setChatId(chatId);
            hmm.setText("Hmm...");
            
            try {
                execute(hmm);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            // Initialize answer message
            SendMessage answer = new SendMessage()
                    .setChatId(chatId);

            Random r = new Random();
            try (Stream<String> all_lines
                    = Files.lines(Paths.get("testi.txt"))) {

                String sl = all_lines.skip(r.nextInt(500)).findFirst().get();

                answer.setText(sl);

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
