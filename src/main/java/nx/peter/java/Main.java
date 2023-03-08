package nx.peter.java;

import nx.peter.java.dictionary.Dictionary;
import nx.peter.java.dictionary.FullDictionary;
import nx.peter.java.util.data.LoremIpsum;

public class Main {
    public static void main(String[] args) {
        LoremIpsum ipsum = LoremIpsum.getInstance();

        // System.out.println(ipsum.getWordCount() + " vs " + ipsum.getLoremText().getWords().size());

        Dictionary dictionary = ipsum.getLoremDictionary();
        System.out.println(dictionary.generateWord().toSentenceCase());

        System.out.println(ipsum.getLines());

    }
}
