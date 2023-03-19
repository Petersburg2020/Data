package nx.peter.java;

import nx.peter.java.dictionary.Dictionary;
import nx.peter.java.dictionary.FullDictionary;
import nx.peter.java.dictionary.LatinDictionary;
import nx.peter.java.util.data.DataManager;
import nx.peter.java.util.data.LoremIpsum;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        LoremIpsum ipsum = LoremIpsum.getInstance();

        FullDictionary dictionary = new LatinDictionary();
        System.out.println();
        System.out.println(dictionary.getWordMeaning("Lūdere"));
        System.out.println(dictionary.getWordCount());

        System.out.println(ipsum.getWordCount());
        System.out.println(ipsum.getSentenceCount());
        System.out.println(ipsum.getParagraphCount());
        System.out.println();

        System.out.printf(DataManager.ALPHABETS_LATIN);

    }
}
