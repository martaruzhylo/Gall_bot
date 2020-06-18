package gall_bot;

import gall_bot.service.GallBotService;
import gall_bot.service.MessageService;

import java.util.Random;
import java.util.Scanner;


public class Game {

    GallBotService gallBotService=new GallBotService();

    public static Scanner scan = new Scanner(System.in);
    StringBuilder emptyLine = new StringBuilder("");
   // String word = "telegram";
    String word = new String();
    public void wordGeneration(Long chatId){
        String[]words={"elephant", "bat", "bison", "chimpanzee", "donkey", "lion", "woolf"};
        word = (words[new Random().nextInt(words.length)]);
        gallBotService.sendMessage(word, chatId);

    }

    void start(){

        System.out.println("In this game you should to guess a word.\n" +
                "You will have few tries to check if the word consist a given letter.\n" +
                "Also you are able to guess a word sooner, if you already know an answer\n" +
                "In this way just enter '*'\n"+
                "But be careful, you only have 1 try to guess a whole word\n" +
                "Good luck!" );
    }
    StringBuilder amountOfLetters() {
        for (int i = 0; i < word.length(); i++) {
            emptyLine.append("_");
        }
        return emptyLine;
    }

    void guessALetter() {

        System.out.println("Please, guess a letter");
        try {
            int correct = 0;
            String input = scan.nextLine();
            char letter = input.charAt(0);
            if(letter=='*') geussWholeWord();
            if(Character.isLetter(letter)) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == letter) {
                        emptyLine.setCharAt(i, letter);
                        correct++;
                    }
                }
                if (correct < 1) {
                    System.out.println("The word doesn't consist letter " + letter);
                }
                System.out.println(emptyLine);
            }else {
                System.out.println("Try again!");
                guessALetter();
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Try again!");
            guessALetter();
        }
    }

    private void geussWholeWord() {
        System.out.println("Please, guess a word");
        String guessWord = scan.nextLine();
        if (word.equals(guessWord)) {
            System.out.println("Congratulation! You win!");
        } else System.out.println("Game over");
        System.exit(1);
    }

//    void choose() {
//        int amountOfTries = 4;
//        for (int i = amountOfTries; i >= 0;  i--) {
//            if (i ==0 ) geussWholeWord();
//            if (i == 1)
//                System.out.println("You have " + amountOfTries-- + " try\nPlease, choose an action:");
//            else {System.out.println("You have " + amountOfTries-- + " tries\nPlease, choose an action:");
//            }
//            System.out.println("Enter 1 - to quess a letter\n      2 - to guess a whole word");
//
//           // choice();
//           // useTries();
//        }
//    }

    void useTries(){
        int amountOfTries = 4;
        for (int i = amountOfTries; i >= 0;  i--) {
            if (i ==0 ) geussWholeWord();
            if (i == 1)
                System.out.println("You have " + amountOfTries-- + " try");
            else {System.out.println("You have " + amountOfTries-- + " tries");
            }
           // System.out.println("Enter 1 - to quess a letter\n      2 - to guess a whole word");

            guessALetter();
        }
        }

        void completeGame(String chatId){
//        wordGeneration();
//        amountOfLetters();
//        useTries();

        }



//void choice(){
//    try {
//        Scanner scan = new Scanner(System.in);
//        int c = scan.nextInt();
//        switch (c) {
//            case (1):
//                guess();
//                break;
//            case (2):
//                geussWholeWord();
//                break;
//            default:
//                System.out.println("Please Enter '1' or '2'!");
//                 choice();
//                break;
//        }
//    } catch (InputMismatchException e) {
//        System.out.println("Please Enter '1' or '2'!");
//        choice();
//    }
//}

    }
