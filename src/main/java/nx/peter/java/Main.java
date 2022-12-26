package nx.peter.java;

import nx.peter.java.util.data.Data;
import nx.peter.java.util.data.Word;
import nx.peter.java.util.data.comparator.ComparedLetters;

public class Main {
    public static void main(String[] args) {
        Word word = new Word("Peter", Word.PartOfSpeech.Noun);
        Data<?> data = new Word(word);

        data.append("See ", 0);

        ComparedLetters compared = word.getAlmostEquals(new Word(data));


        println(data.append(", Esther, Blessing"));
        println();

        // word.set(data);

        println(word.getAlmostEquals((Word) data));
        println();
        println(word.getAlmostEquals((Word) data).getComparedLetters());
        println();
        println(data.equalsIgnoreCase(word));
        println();
    }

    public static void println() {
        println("");
    }

    public static void print(Object object) {
        System.out.print(object);
    }

    public static void println(Object object) {
        System.out.println(object);
    }
}