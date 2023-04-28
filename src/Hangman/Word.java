package Hangman;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Word {

    public String getRandomWord(){
        String targetWord = null;
        try{
            Scanner read = new Scanner(new FileReader("src/assets/engmix.txt"));
            ArrayList<String> words = new ArrayList<String>();
            while(read.hasNextLine()){
                words.add(read.nextLine());
            }
            targetWord = words.get(new Random().nextInt(words.size()));
            read.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return targetWord;

    }

}
