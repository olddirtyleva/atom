package group;

import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BullsCows {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BullsCows.class);
    private static boolean isWinning = false;
    private static int moveNumber = 0;
    private static int bulls = 0;
    private static int cows = 0;
    private static final Scanner in = new Scanner(System.in);


    public static void main(String[] args) {
        play();
    }

    public static void play() {
        System.out.println("Welcome to Bulls and Cows game!");
        String hiddenWord = pickHiddenWord();
        while (true) {
            System.out.print("> ");
            String playerWord = in.nextLine().toLowerCase();
            if (!checkWord(playerWord, hiddenWord) && moveNumber < 10)
                moveNumber++;
            else {
                if (isWinning) {
                    log.info("Player win!");
                    System.out.println("You win!");
                }
                else {
                    log.info("Player lose!");
                    System.out.println("You lose!");
                }
                System.out.println("Wanna play again? Y/N");
                if (in.nextLine().equals("Y")) {
                    hiddenWord = pickHiddenWord();
                    isWinning = false;
                    moveNumber = 0;
                    bulls = 0;
                    cows = 0;
                } else
                    break;
            }
        }
    }

    public static boolean checkWord(String playerWord, String hiddenWord) {
        log.info("");
        log.info("-------------------------------------------------------");
        log.info("");
        log.info(moveNumber + " turn");
        log.info("Players word: "+ playerWord);
        StringBuilder playerTmp = new StringBuilder();
        StringBuilder hiddenTmp = new StringBuilder();
        if (playerWord.equals(hiddenWord)) {
            isWinning = true;
            return true;
        }
        for (int i = 0; i < playerWord.length(); i++) {
            if (hiddenWord.charAt(i) == playerWord.charAt(i))
                bulls++;
            else {
                hiddenTmp.append(hiddenWord.charAt(i));
                playerTmp.append(playerWord.charAt(i));
            }
        }
        char[] chars = hiddenTmp.toString().toCharArray();
        Arrays.sort(chars);
        hiddenTmp = new StringBuilder(new String(chars));
        chars = playerTmp.toString().toCharArray();
        Arrays.sort(chars);
        playerTmp = new StringBuilder(new String(chars));
        for (int i = 0; i < hiddenTmp.length(); i++)
            if (hiddenTmp.charAt(i) == playerTmp.charAt(i))
                cows++;
        log.info("bulls: " + bulls);
        log.info("cows: " + cows);
        System.out.println("Bulls: " + bulls);
        System.out.println("Cows: " + cows);
        bulls = 0;
        cows = 0;
        return false;
    }

    public static String pickHiddenWord() {
        try {
            Random rnd = new Random();
            ArrayList<String> hiddenWords = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream("dictionary.txt"),
                    StandardCharsets.UTF_8));
            String line;
            while ((line = reader.readLine()) != null) {
                hiddenWords.add(line);
            }
            log.info("Get words list");
            String hiddenWord = hiddenWords.get(rnd.nextInt(hiddenWords.size()));
            System.out.println("I offered a " + hiddenWord.length() + "-letter hiddenWord, your guess?");
            log.info("hidden word: " + hiddenWord);
            return hiddenWord;
        } catch (IOException e) {
            // log error
            System.out.println(e.getMessage());
        }
        return null;
    }

    /*public static void getHiddenWords() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream("dictionary.txt"),
                    StandardCharsets.UTF_8));
            String line;
            while ((line = reader.readLine()) != null) {
                hiddenWords.add(line);
            }
        } catch (IOException e) {
            // log error
            System.out.println(e.getMessage());
        }
    }*/
}